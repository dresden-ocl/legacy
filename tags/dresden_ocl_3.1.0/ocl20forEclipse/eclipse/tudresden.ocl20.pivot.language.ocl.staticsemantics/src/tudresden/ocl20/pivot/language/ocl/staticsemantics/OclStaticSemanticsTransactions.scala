package tudresden.ocl20.pivot.language.ocl.staticsemantics

import org.kiama.attribution.Attribution._
import org.eclipse.emf.ecore._
import tudresden.ocl20.pivot.language.ocl.semantics._
import tudresden.ocl20.pivot.model._
import tudresden.ocl20.pivot.pivotmodel._
import tudresden.ocl20.pivot.language.ocl.resource.ocl.mopp._

object OclStaticSemanticsTransactions {

  private val parsedConstraints = new collection.jcl.IdentityHashMap[IOclResource, java.util.List[Constraint]]()
  
  /**
   * If there are constraints and defined operations/properties in the model,
   * remove those for the current OclResource.
   */
  def startStaticSemanticsAnalysis(oclStaticSemantics : OclStaticSemantics, root : EObject) = {
     parsedConstraints.get(oclStaticSemantics.resource) match {
      case Some(constraints) => {
        oclStaticSemantics.model.removeConstraints(constraints)
      }
      case None => // do nothing
    }
    parsedConstraints.removeKey(oclStaticSemantics.resource)
  }
  
  def getAllDefs(oclStaticSemantics : OclStaticSemantics, root : EObject) = {
    // try to find all defs
    val allDefs = new collection.mutable.HashMap[Type, collection.mutable.Set[VariableDeclarationWithInitCS]] with collection.mutable.MultiMap[Type, VariableDeclarationWithInitCS]
    val allDefsOp = new collection.mutable.HashMap[Type, collection.mutable.Set[Tuple2[OperationDefinitionInDefCS, OclExpressionCS]]] with collection.mutable.MultiMap[Type, Tuple2[OperationDefinitionInDefCS, OclExpressionCS]]
    root match {
      case PackageDeclarationCS(contextDeclarations) => {
        contextDeclarations.foreach{cd =>
          cd match {
            case ClassifierContextDeclarationCS(typeName, invariantsAndDefinitions) => {
              invariantsAndDefinitions.foreach{iad =>
                iad match {
                  case DefinitionExpCS(definitionPartExp, static) => {
                    definitionPartExp match {
                      case DefinitionExpPropertyCS(variableDeclaration) => {
                        (oclStaticSemantics.eObject2Attributable(typeName)->oclStaticSemantics.oclType) match {
                          case Full(tipe) => allDefs.add(tipe, variableDeclaration)
                          case other => // ignore
                        }
                      }
                      case DefinitionExpOperationCS(operation, oclExpression, _) => {
                        (oclStaticSemantics.eObject2Attributable(typeName)->oclStaticSemantics.oclType) match {
                          case Full(tipe) => allDefsOp.add(tipe, (operation, oclExpression))
                          case other => // ignore
                        }
                      }
                    }
                  }
                  case other => // ignore
                }
              }
            }
            case other => // ignore
          }
        }
      }
      case other => //ignore
    }
    (allDefs, allDefsOp)
  }
  
  /**
   * After the semantic analysis, the parsed constraints and defined
   * properties/operations are added to the model.
   */
  def endStaticSemanticsAnalysis(model : IModel, resource : IOclResource, constraints : java.util.List[Constraint]) = {
    val iter = constraints.iterator
    while (iter.hasNext) {
      val constraint = iter.next
      val iter2 = constraint.getConstrainedElement.iterator
      while (iter2.hasNext) {
        val constrainedElement = iter2.next
        constrainedElement match {
          case t :Type => {
            t.getNamespace.addRule(constraint)
            // in case there is a defined feature, add it to the model, too
            constraint.getDefinedFeature match {
              case null => // do nothing
              case p : Property => t.addProperty(p)
              case o : Operation => t.addOperation(o)
            }
          }
          case o : Operation => Box.!! (o.getOwningType).map{ot =>
            ot.getNamespace.addRule(constraint)
          }
          case p : Property => Box.!! (p.getOwningType).map{ot =>
            ot.getNamespace.addRule(constraint)
          }
        }
      }
    }
    parsedConstraints += resource -> constraints
  }
  
}
