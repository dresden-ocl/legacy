/* Generated by Together */

package com.togethersoft.modules.ocl;

import tudresden.ocl.check.types.Any;
import com.togethersoft.openapi.rwi.RwiElement;
import tudresden.ocl.check.types.Type;
import com.togethersoft.openapi.rwi.RwiProperty;
import tudresden.ocl.check.OclTypeException;
import com.togethersoft.openapi.rwi.enum.RwiElementEnumeration;
import java.util.Collection;
import java.util.Vector;
import com.togethersoft.openapi.rwi.RwiShapeType;
import com.togethersoft.openapi.rwi.enum.RwiPropertyEnumeration;
import com.togethersoft.openapi.rwi.RwiPropertyMap;
import com.togethersoft.openapi.rwi.RwiModel;
import com.togethersoft.openapi.rwi.RwiModelAccess;
import com.togethersoft.openapi.rwi.RwiNode;
import com.togethersoft.openapi.rwi.RwiVisitorAdapter;
import java.util.ArrayList;
import com.togethersoft.openapi.rwi.enum.RwiMemberEnumeration;
import com.togethersoft.openapi.rwi.enum.RwiLinkEnumeration;
import com.togethersoft.openapi.rwi.RwiMember;
import com.togethersoft.openapi.rwi.RwiLink;
import tudresden.ocl.check.types.Basic;
import tudresden.ocl.check.types.ReflectionFacade;
import tudresden.ocl.check.types.DefaultReflectionAdapter;
import tudresden.ocl.check.types.OclType;
import com.togethersoft.modules.ocl.Multiplicity.MultiplicityException;
import com.togethersoft.openapi.sci.SciClass;
import com.togethersoft.openapi.sci.SciModelAccess;
import com.togethersoft.openapi.sci.SciLanguage;
import com.togethersoft.openapi.sci.SciMember;
import com.togethersoft.openapi.sci.SciElement;
import com.togethersoft.openapi.sci.SciOperation;
import com.togethersoft.openapi.sci.SciType;

/**
 * This Implementation of {@link tudresden.ocl.check.types.Any Any} encapsulates representations of classifiers from Together models.
 * @author Christian Nill
 */
// "public" mainly for testing purposes
public class TogetherAny implements Any {
    
    // DEBUG
    DebugHelper dh = new DebugHelper();
    
	/**
     * The <code>RwiElement</code> being represented. Usually, but not necessarily a <code>RwiNode</code>
     */
    RwiElement context;

    /** @link dependency 
     * @label <<create>>*/
    /*# TogetherAny lnkTogetherAny; */

    /**
     * The constructor takes the representation of the classifier, that is to be encapsulated, from the Together model.
     * @param context Should usually be of type {@link com.togethersoft.openapi.rwi.RwiNode RwiNode}.
     **/
    public TogetherAny(RwiElement context) {
        try {
            RwiMember rwiMember = (RwiMember)context;
            RwiModel rwiModel = RwiModelAccess.getModel();
            this.context = rwiModel.findElement(context.getProperty(RwiProperty.TYPE_REFERENCED_ELEMENT));
        } catch (ClassCastException e) {
            // context was not a RwiMember, so there's nothing to prepare
	        this.context = context;
        }
        dh.printInformation("New TogetherAny created. Name: "+context.getProperty(RwiProperty.NAME)+
			    "  Type: "+context.getProperty(RwiProperty.TYPE));
    }    
    
    /**
     * Checks, whether the classifier wrapped by the current <code>TogetherAny</code> instance conforms with another classifier (i.e. is of the same class, or a subclass of it).
     * @param t Operation will only be useful, if <code>t</code> is a <code>TogetherAny</code>. 
     * @return <code>true</code> if the current instance's classifier conforms to <code>t</code>, otherwise <code>false</code>
     * @see {@link com.togethersoft.modules.ocl.test.TestTogetherAny#testConformsTo() TestTogetherAny}
     */
    public boolean conformsTo(Type t) {
        if (t instanceof TogetherAny) {
			ConformsToVisitor ctv = new ConformsToVisitor(((TogetherAny)t).getContext().getProperty(RwiProperty.FULL_NAME));

            Boolean returnValue = (Boolean)(context.accept(ctv));
            return returnValue.booleanValue();
        } else {
            // what else to do? Can only compare to TogetherAny instances...
	    return false;
        }
    }    
    
    /**
     * Checks, if another classifier is the same as the one encapsulated by the current <code>TogetherAny</code> instance.
     * @param o Operation is only useful
     * @param if <code>o</code> is a <code>TogetherAny</code>.
     * @return <code>true</code> if <code>o</code> is a <code>TogetherAny</code> instance encapsulating the same classifier, otherwise <code>false</code>. 
     */
    public boolean equals(Object o) {
	if (o instanceof TogetherAny) {
            return(((TogetherAny)o).getContext().getProperty(RwiProperty.FULL_NAME).equals(
                context.getProperty(RwiProperty.FULL_NAME)));
        } else {
            return false;
        }
    }    
    
    /**
     * Not implemented.
     * @return 0 
     */
    public int hashCode() {
        return 0; // TO DO
    }

    /**
     * Navigates along attributes and associations. Uses the {@link TogetherAny.NavigateQualifiedVisitor NavigateQualifiedVisitor}
     * @param name Name of the feature to navigate along
     * @param qualifiers Not supported, must be <code>null</code>
     * @return instance of <code>TogetherAny</code>, representing the type of the attribute or association end
     */
    public Type navigateQualified(String name, Type[] qualifiers) throws OclTypeException{

		RwiNode contextNode = null;
        if (context.getProperty(RwiProperty.SHAPE_TYPE).equals(RwiShapeType.CLASS)) {
            contextNode = (RwiNode)context;
        } else if (context.getProperty(RwiProperty.SHAPE_TYPE).equals(RwiShapeType.OPERATION)) {
            contextNode = ((RwiMember)context).getContainingNode();
        }

        if (contextNode == null) {
            throw new OclTypeException("Attempting to access features of VOID.");
        }
        if (qualifiers != null) {
            throw new OclTypeException("Qualifiers not yet supported.");
        }
	
		// basic type?
        Type type = Basic.navigateAnyQualified(name, this, qualifiers);
        if (type != null) return type;
	
		// to search for the attribute / assoc. "name", an implementation of RwiVisitorAdapter is used --> Visitor-Pattern!
        NavigateQualifiedVisitor nqv = new NavigateQualifiedVisitor(name);
        // Type result = (Type)context.accept(nqv);
        Type result = (Type)nqv.visitNode(contextNode);

        if (result == null) {
            throw new OclTypeException("No feature \"" + name + "\" found in context "+ context.getProperty(RwiProperty.FULL_NAME));
        } else {
		    return result;
        }
    }

    /**
     * Navigates along operations. Uses the {@link TogetherAny.NavigateParameterizedVisitor NavigateParameterizedVisitor}
     * @param name Name of the operation to navigate along
     * @param params Array of the operation's parameters. Should only be instances of <code>TogetherAny</code>
     * @return instance of <code>TogetherAny</code>, representing the type of the attribute or association end
     */
    private Type navigateAnyParameterized(String name, Type[] params) {
      if (params.length!=1) return null;
      if (name.equals("oclIsKindOf") && params[0] instanceof Any) {
    	  return Basic.BOOLEAN;
      } else if (name.equals("oclIsTypeOf") && params[0] instanceof Any) {
  	    return Basic.BOOLEAN;
      } else if (name.equals("oclAsType") && params[0] instanceof Any) {
	      return params[0];
      } else if (name.equals("oclInState") && params[0]==Basic.STRING) {
	      return Basic.BOOLEAN;
      }
	  return null;
    }

    
    public Type navigateParameterized(String name, Type[] params) {
        if (context == null) {
            throw new OclTypeException("TogetherAny-instance not correctly instantiated. Attempting to access features of VOID.");
        }
        Type type = navigateAnyParameterized(name, params);
        if (type != null) return type;

		// to search for the operation "name", a implementation of RwiVisitorAdapter is used --> Visitor-Pattern!
        NavigateParameterizedVisitor npv = new NavigateParameterizedVisitor(name, params);
        // start looking in the root node
        Type result = (Type)context.accept(npv);
	
        if (result == null) {
            String paramStr = "";
            for (int i=0; i < params.length; i++) { paramStr += params[i]; }
            throw new OclTypeException("No operation \"" + name + "(" +
				       paramStr + ")\" found in context "+ context.getProperty(RwiProperty.FULL_NAME));
        } else {
	        return result;
        }
    }    
    
    /**
     * not supported
     * @return <code>false</code> 
     */
    public boolean hasState(String stateName) {
        // not yet implemented
        return false;
    }    
    
    /**
     * @return name of the classifier being encapsulated by this <code>TogetherAny</code> instance. 
     */
    public String toString() {
		String resultString;
       	resultString = context.getProperty(RwiProperty.NAME);
	    return resultString;
    }
    
    /**
     * Visitor to facilitate navigating along attributes and associations.
     * Used by <code>navigateQualified()</code>, searches for associations and attributes in
     * the current <code>TogetherAny</code> instance. Must be instantiated with the feature
     * name that is being looked for.
     * @author Christian Nill
     */
    private class NavigateQualifiedVisitor extends RwiVisitorAdapter {

        /**
         * The feature name being looked for
         */
        String featureName;

        /**
         * The name of the target type, if <code>featureName</code> is an unnamed association
         */
        private String possibleClassName;


		/**
         * Also instantiates <code>possibleClassName</code>
         * @param featureName the feature being looked for
         */
        NavigateQualifiedVisitor(String featureName) {
          	this.featureName = featureName;
			// featureName with the first char in upper case, e.g. someName ==> SomeName
            this.possibleClassName = String.valueOf(featureName.charAt(0)).toUpperCase().concat(
                featureName.substring(1, featureName.length()));
        }
	

        public Object visitNode(RwiNode rwiNode) {
            Type resultType = null;

		    dh.printInformation("NQV.visitNode("+rwiNode.getProperty(RwiProperty.NAME)+")  Step 1");
			// first, search members, links
		    RwiMemberEnumeration rme = rwiNode.members();
		    while (rme.hasMoreElements() && resultType == null) {
				RwiMember someRwiMember = rme.nextRwiMember();
				resultType = (Type)someRwiMember.accept(this);
		    }
			if (resultType != null) { return resultType; }

		    // then search the inheritance tree
		    RwiLinkEnumeration rle = rwiNode.outgoingLinks();
	    	while (rle.hasMoreElements() && resultType == null) {
				// only generalizations and implementations are of interest
				RwiLink someRwiLink = rle.nextRwiLink();
				if (someRwiLink.getProperty(RwiProperty.SHAPE_TYPE).equals(RwiShapeType.IMPLEMENTATION) ||
				    someRwiLink.getProperty(RwiProperty.SHAPE_TYPE).equals(RwiShapeType.GENERALIZATION)) {
					    // note, that getDestination() returns a RwiElement
					    resultType = (Type)someRwiLink.getDestination().accept(this);
				}
		    }
            return resultType;
        }
	

		public Object visitElement(RwiElement rwiElement) {
            RwiNode rwiNode;
		    // try to cast to RwiNode and use the RwiNode's accept()-method, otherwise return
            try {
                rwiNode = (RwiNode)rwiElement;
				return rwiNode.accept(this);
            } catch (ClassCastException e) {
                return null;
            }
        }


        public Object visitMember(RwiMember rwiMember) {
            Type resultType;
		    // members
		    if (rwiMember.getProperty(RwiProperty.SHAPE_TYPE).equals(RwiShapeType.ATTRIBUTE) &&
				rwiMember.getProperty(RwiProperty.NAME).equals(featureName)) {
				resultType = getBasicOclRepresentation(rwiMember.getProperty(RwiProperty.TYPE));
       	        if (resultType==null) {
        			// to use the proper node, navigate there by the appropriateµ RwiLink
                    RwiModel myModel = RwiModelAccess.getModel();
                    RwiLink theLink = (RwiLink)myModel.findElement(rwiMember.getProperty(RwiProperty.MEMBER_LINK));
   	    	        return new TogetherAny(theLink.getDestination());
       	    	} else {
            		return resultType;
  	       		}
		    }

			// named associations
		    try {
				if (rwiMember.getProperty(RwiProperty.SHAPE_TYPE).equals(RwiShapeType.ATTRIBUTE) &&
			    	(rwiMember.hasProperty("supplierRole") &&
                       	rwiMember.getProperty("supplierRole").equals(featureName))) {

			    	if (rwiMember.getProperty(RwiProperty.MEMBER_LINK) != null) {
						RwiModel myModel = RwiModelAccess.getModel();
						RwiLink someRwiLink = (RwiLink)myModel.findElement(rwiMember.getProperty(RwiProperty.MEMBER_LINK));
						return someRwiLink.accept(this);
		    		}
				} else if (rwiMember.getProperty(RwiProperty.SHAPE_TYPE).equals(RwiShapeType.ATTRIBUTE) &&
                    rwiMember.hasProperty("bidirectional")) {
					RwiMember clientMember = getClientMemberInBidirectionalAssociation(rwiMember);
                    // "clientRole", because link in "reverse" direction
                    if (clientMember.getProperty("clientRole").equals(featureName)) {

        	            // what about multiplicities?
            	        // return new TogetherAny(rwiMember);
			    		if (clientMember.getProperty(RwiProperty.MEMBER_LINK) != null) {
							RwiModel myModel = RwiModelAccess.getModel();
							RwiLink someRwiLink = (RwiLink)myModel.findElement(clientMember.getProperty(RwiProperty.MEMBER_LINK));
							return visitLink(someRwiLink, true);
		                }
                    }
                }
		    } catch (NullPointerException e) {
				// ignore and go on
		    }
	    
            // unnamed associations
		    try {
                // an attribute without rolename is unnamed (or a simple member)
			    if (rwiMember.getProperty(RwiProperty.SHAPE_TYPE).equals(RwiShapeType.ATTRIBUTE)  &&
					!(rwiMember.hasProperty("supplierRole"))) {
			    	if (rwiMember.getProperty(RwiProperty.MEMBER_LINK) != null) {
						RwiModel myModel = RwiModelAccess.getModel();
						RwiLink someRwiLink = (RwiLink)myModel.findElement(rwiMember.getProperty(RwiProperty.MEMBER_LINK));
                        RwiElement foundElement = someRwiLink.getDestination();
                        if (foundElement.getProperty(RwiProperty.NAME).equals(possibleClassName)) {
//                            return new TogetherAny(foundElement);
							  return someRwiLink.accept(this);
                        }
                   	}
			    }
	    	} catch (NullPointerException e) {
				// ignore and go on
		    }

	        return null;
    	}


		public Object visitLink(RwiLink rwiLink) {
            return visitLink(rwiLink, false);
        }


        public Object visitLink(RwiLink rwiLink, boolean reverse) {
            Type result = null;

		    try {
                // Multiplicity helper class by Stefan Ocke
                Multiplicity multiplicity;
                if (!reverse) {
					multiplicity = new Multiplicity(rwiLink.getProperty("supplierCardinality"));
                } else {
					multiplicity = new Multiplicity(rwiLink.getProperty("clientCardinality"));
                }
				// if it has to be treated as collection...
				if (multiplicity.isMultivalued()) {
				    // make sure to know, what the objects' types are
			    	tudresden.ocl.check.types.Collection resultCollection;
					Type collectionType;

	                if (!reverse) {
					    collectionType = new TogetherAny(rwiLink.getDestination());
        	        } else {
    	                collectionType = new TogetherAny(rwiLink.getSource());
	                }

        			// result collection depending on some more tags INTERIM SOLUTION!!!
					int returnCollection = tudresden.ocl.check.types.Collection.COLLECTION; // standard collection
        			if (rwiLink.hasProperty("ordered")) {
            			returnCollection = tudresden.ocl.check.types.Collection.SEQUENCE;
			        }
        			else if (rwiLink.hasProperty("OCLCollection-Type")) {
            			String collectionTypeText = rwiLink.getProperty("OCLCollection-Type");
                        if (collectionTypeText.equals("Set")) {
							returnCollection = tudresden.ocl.check.types.Collection.SET;
                        }
                        else if (collectionTypeText.equals("Bag")) {
							returnCollection = tudresden.ocl.check.types.Collection.BAG;
                        }
                        else if (collectionTypeText.equals("Sequence")) {
							returnCollection = tudresden.ocl.check.types.Collection.SEQUENCE;
                        }
			        }

				    result = new tudresden.ocl.check.types.Collection(
						returnCollection,
						collectionType );
		    
				    return result;
				}
		    } catch (NullPointerException e) {
				// treat as multiplicity 1 ==> single object
			    dh.printInformation("NQV.visitLink("+rwiLink.getProperty(RwiProperty.NAME)+") " + e.toString());
		    } catch (MultiplicityException e) {
				// ignore as well
			    dh.printInformation("NQV.visitLink("+rwiLink.getProperty(RwiProperty.NAME)+") " + e.toString());
		    }
			// no collection ==> find the right end of the link
            RwiElement someNode;
            if (!reverse) {
                someNode = rwiLink.getDestination();
            } else {
				someNode = rwiLink.getSource();
            }

			// if the right attribute is found, check, whether it's a basic type
			result = getBasicOclRepresentation(someNode.getProperty(RwiProperty.NAME));
            if (result == null) {
			    result = new TogetherAny(someNode);
            }
			return result;
        }


		/**
         * Gets the rolename of a client in a bidrectional association, starting from
         * the supplier class.
         * @param rwiElement The supplier class; this <code>RwiElement</code> should have the property "bidirectional"
         */
        private String getRolenameOfBidirectionalAssociation(RwiMember rwiMember) {
            String linkUniqueName = rwiMember.getProperty(RwiProperty.MEMBER_LINK);
            if (linkUniqueName != null) {
	            RwiLink rwiLink = (RwiLink)RwiModelAccess.getModel().findElement(linkUniqueName);
                RwiNode linkedNode = (RwiNode)rwiLink.getDestination();

			    RwiMemberEnumeration rme = linkedNode.members();
			    while (rme.hasMoreElements()) {
					RwiMember someRwiMember = rme.nextRwiMember();
                    // clientRole is the supplier role from the supplier class' view
					if (someRwiMember.hasProperty("bidirectional")) {
                        // Have a look on how information about suppliers are stored for
                        //   bidirectional associations. Not very neat, but works here.
                        if (someRwiMember.getProperty("bidirectional").equals(
                            "<{" + rwiMember.getContainingNode().getProperty(RwiProperty.FULL_NAME) +
                                "#" + rwiMember.getProperty(RwiProperty.NAME) + "}>")) {

                            return(someRwiMember.getProperty("clientRole"));
                        }
		             }
    	        }
            }
            return null;
        }


        private RwiMember getClientMemberInBidirectionalAssociation(RwiMember supplierMember) {
            String linkUniqueName = supplierMember.getProperty(RwiProperty.MEMBER_LINK);
            if (linkUniqueName != null) {
	            RwiLink rwiLink = (RwiLink)RwiModelAccess.getModel().findElement(linkUniqueName);
                RwiNode linkedNode = (RwiNode)rwiLink.getDestination();

			    RwiMemberEnumeration rme = linkedNode.members();
			    while (rme.hasMoreElements()) {
					RwiMember someRwiMember = rme.nextRwiMember();
                    // clientRole is the supplier role from the supplier class' view
					if (someRwiMember.hasProperty("bidirectional")) {
                        // Have a look on how information about suppliers are stored for
                        //   bidirectional associations. Not very neat, but works here.
                        if (someRwiMember.getProperty("bidirectional").equals(
                            "<{" + supplierMember.getContainingNode().getProperty(RwiProperty.FULL_NAME) +
                                "#" + supplierMember.getProperty(RwiProperty.NAME) + "}>")) {
                            return someRwiMember;
                        }
                    }
                }
            }
            return null;
        }
    }


    /**
     * @author Christian Nill 
     */
	private class NavigateParameterizedVisitor extends RwiVisitorAdapter {
    
    	String featureName;
    	Type[] params;
    
	    NavigateParameterizedVisitor(String featureName, Type[] params) {
			this.featureName = featureName;
			this.params = params;
	    }
    
	    public Object visitNode(RwiNode rwiNode) {
			// search all members
			RwiMemberEnumeration rme = rwiNode.members();
			while (rme.hasMoreElements()) {
	    		// only operations are of interest...
			    RwiMember someRwiMember = rme.nextRwiMember();
			    if (someRwiMember.getProperty(RwiProperty.SHAPE_TYPE).equals(RwiShapeType.OPERATION) &&
					someRwiMember.getProperty(RwiProperty.NAME).equals(featureName)) {
					return someRwiMember.accept(this);
		    	}
			}

			// then search links
			RwiLinkEnumeration rle = rwiNode.outgoingLinks();
			while (rle.hasMoreElements()) {
			    // only generalizations and implementations are of interest
	    		RwiLink someRwiLink = rle.nextRwiLink();
		    	if (someRwiLink.getProperty(RwiProperty.SHAPE_TYPE).equals(RwiShapeType.IMPLEMENTATION) ||
					someRwiLink.getProperty(RwiProperty.SHAPE_TYPE).equals(RwiShapeType.GENERALIZATION)) {
					// note, that getDestination() returns a RwiElement
					return someRwiLink.getDestination().accept(this);
		    	}
			}
    	    return null;
	    }
    
	    public Object visitMember(RwiMember rwiMember) {
			// check, whether this member complies with the parameters given (it IS an operation)
			RwiPropertyEnumeration paramsEnumeration = rwiMember.properties(RwiProperty.PARAMETER);
			int i;
			for (i = 0; i < this.params.length; i++) {
			    // if the operation to be evaluated has less parameters than the one in the OCL expression, return null
			    if (paramsEnumeration.hasMoreElements() == false) {
					return null;
			    }
	    
			    // else evaluate that parameter more closely
			    RwiProperty someRwiProperty = paramsEnumeration.nextRwiProperty();
	    		RwiPropertyMap somePropertyContainer = someRwiProperty.getSubproperties();
		    	// is it a basic type?
			    Type someType = getBasicOclRepresentation(somePropertyContainer.getProperty(RwiProperty.TYPE));
		    	// if it's not a basic type, fetch the type-representation from the model
			    if (someType == null) {
					RwiModel myModel = RwiModelAccess.getModel();
					RwiElement foundElement = myModel.findElement(somePropertyContainer.getProperty(RwiProperty.TYPE_REFERENCED_ELEMENT));

					// IF imported, TRY REFLECTIONFACADE...
/*                    if (foundElement.getProperty(RwiProperty.MODEL_PART).equals("import")) {
						ReflectionFacade rf = new ReflectionFacade(new String[]{""}, new DefaultReflectionAdapter(), new SimpleNameAdapter());
                        try {
	                        someType = rf.getClassifier(foundElement.getProperty(RwiProperty.FULL_NAME));
                        } catch (tudresden.ocl.check.OclTypeException e) {
							// in case of an exception we could only TRY it with TogetherAny,
                            // or should we just throw an exception then ("not found")?
                        }
                	}
*/
                    someType = new TogetherAny(myModel.findElement(somePropertyContainer.getProperty(RwiProperty.TYPE_REFERENCED_ELEMENT)));
			    }
	    
			    if (!someType.conformsTo(params[i])) {
					return null;
		    	}
			}
	
		// again, check on number of parameters...
		if (i == params.length && paramsEnumeration.hasMoreElements() == false) {
	    
		    Type result = getBasicOclRepresentation(rwiMember.getProperty(RwiProperty.RETURN_TYPE));
		    if (result == null) {
				RwiModel myModel = RwiModelAccess.getModel();
				result = new TogetherAny(myModel.findElement(rwiMember.getProperty(RwiProperty.RETURN_TYPE_REFERENCED_ELEMENT)));
				// what, if return type is an array?
				RwiElement returnRwiElement = myModel.findElement(rwiMember.getProperty(RwiProperty.RETURN_TYPE_REFERENCED_ELEMENT));
	            SciElement sciElement = SciModelAccess.getModel().findElement(rwiMember.getProperty(RwiProperty.UNIQUE_NAME));
                String operationText = sciElement.getText();
                String returnTypeText = returnRwiElement.getProperty(RwiProperty.NAME);
                int indexOfArrayText = operationText.indexOf(returnTypeText) + returnTypeText.length();
                while(String.valueOf(operationText.charAt(indexOfArrayText)).equals(" ")) indexOfArrayText++;
                // if array, return as COLLECTION
                if (operationText.substring(indexOfArrayText, indexOfArrayText+2).equals("[]")) {
				    return new tudresden.ocl.check.types.Collection(
						tudresden.ocl.check.types.Collection.COLLECTION,
						result );
                }
		    }
		    return result;
		}
	
		// else
		return null;
	    }
	}


/**
 * Checks for basic types.
 * @param str String of a Java type
 * @param e.g. <code>"int"</code> or "<code>Integer</code>".
 * @return an instance of <code>tudresden.ocl.check.types.Basic</code> representing a basic type, if <code>str</code> names such a type, otherwise <code>null</code> 
 */
protected Type getBasicOclRepresentation(String str) {
    Type result = null;

    if (str.equals("int") || str.equals("Integer")) {
		result = Basic.INTEGER;
    }
    else if (str.equals("float") || str.equals("double")) {
		result = Basic.REAL;
    }
    else if (str.equals("bool") || str.equals("Boolean") ||
		str.equals("boolean")) {
		result = Basic.BOOLEAN;
    }
    else if (str.equals("String")) {
		result = Basic.STRING;
    }
    // okay for the type checker
    else if (str.equals("void")) {
        result = Any.VOID;
    }
    // result will still be null, if str is no basic OCL type
    return result;
}

    /**
     * @author Christian Nill 
     */
	private class ConformsToVisitor extends RwiVisitorAdapter {
        String fullClassName;

		public ConformsToVisitor(String fullClassName) {
            this.fullClassName = fullClassName;
        }

        public Object visitNode(RwiNode rwiNode) {
            // check name
            if (rwiNode.getProperty(RwiProperty.FULL_NAME).equals(fullClassName)) {
                return new Boolean(true);
            }
            // then try it further up in the inheritance tree
		    RwiLinkEnumeration rle = rwiNode.outgoingLinks();
	    	while (rle.hasMoreElements()) {
            	RwiLink someLink = rle.nextRwiLink();
				if (someLink.getProperty(RwiProperty.SHAPE_TYPE).equals(RwiShapeType.IMPLEMENTATION) ||
				    someLink.getProperty(RwiProperty.SHAPE_TYPE).equals(RwiShapeType.GENERALIZATION)) {
                    return someLink.getDestination().accept(this);
                }
        	}
        	// else
            return new Boolean(false);
        }
    }


	/**
	 * getter for context : RwiElement
	 */
	public RwiElement getContext() {
    	return context;
	}


}

