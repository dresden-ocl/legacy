/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * OCL 2 Compiler                                                    *
 * Copyright (C) 2002, 2003 Stefan Ocke (stefan.ocke@gmx.de).        *
 * All rights reserved.                                              *
 *                                                                   *
 * This work was done as a diploma project at the Chair for Software *
 * Technology, Dresden University Of Technology, Germany             *
 * (http://www-st.inf.tu-dresden.de).  It is understood that any     *
 * modification not identified as such is not covered by the         *
 * preceding statement.                                              *
 *                                                                   *
 * This work is free software; you can redistribute it and/or        *
 * modify it under the terms of the GNU Library General Public       *
 * License as published by the Free Software Foundation; either      *
 * version 2 of the License, or (at your option) any later version.  *
 *                                                                   *
 * This work is distributed in the hope that it will be useful,      *
 * but WITHOUT ANY WARRANTY; without even the implied warranty of    *
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU *
 * Library General Public License for more details.                  *
 *                                                                   *
 * You should have received a copy of the GNU Library General Public *
 * License along with this library; if not, write to the             *
 * Free Software Foundation, Inc., 59 Temple Place - Suite 330,      *
 * Boston, MA  02111-1307, USA.                                      *
 *                                                                   *
 * To submit a bug report, send a comment, or get the latest news on *
 * this project and other projects, please visit the web site:       *
 * http://www-st.inf.tu-dresden.de/ (Chair home page) or             *
 * http://www-st.inf.tu-dresden.de/ocl/ (project home page)          *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

package tudresden.ocl20.core.jmi.uml15.impl.core;

import java.util.*;


import tudresden.ocl20.core.jmi.uml15.uml15.Uml15Package;
import tudresden.ocl20.core.jmi.uml15.core.*;
import tudresden.ocl20.core.jmi.uml15.datatypes.*;
import tudresden.ocl20.core.jmi.uml15.impl.modelmanagement.ModelHelper;
import tudresden.ocl20.core.jmi.uml15.impl.uml15ocl.types.OclLibraryHelper;
import tudresden.ocl20.core.jmi.uml15.modelmanagement.Model;
import tudresden.ocl20.core.jmi.uml15.uml15ocl.expressions.*;
import tudresden.ocl20.core.jmi.uml15.commonbehavior.Reception;
import tudresden.ocl20.core.jmi.uml15.commonbehavior.Signal;
import tudresden.ocl20.integration.ModelFacade;
import tudresden.ocl20.core.jmi.uml15.core.Enumeration;

//import tudresden.ocl20.jmi.impl.uml15ocl.OclLibrary;

import org.netbeans.mdr.handlers.InstanceHandler;
import org.netbeans.mdr.storagemodel.StorableObject;

/**
 *
 * @author  Administrator
 */
public abstract class ClassifierImpl extends NamespaceImpl implements Classifier{
    
    /** Creates a new instance of ClassifierImpl */
    protected ClassifierImpl(StorableObject storable) {
        super(storable);
    }
    
    /**
     * Returns the parents of a classifier. If a classifier has no parents and if an instance of the class ModelFacade exists
     * this methods returns the OCL-Type OclAny. If the classifier is an Instance of the class OclVoid this method returns
     * all classes without parents.
     */
    public List getParents()
    {
    	List result = new ArrayList();
    	ModelFacade instance = ModelFacade.getInstance(this.refOutermostPackage().refMofId());

    	if (instance != null)
    	{
    	    if (instance.isRepresentative(this.refMofId())&&
    	        instance.hasRefObject(this.refMofId()))
    	      {
    	         if (getGeneralization().isEmpty() && !(this instanceof Interface) && !(this instanceof Enumeration))
    	         {
    	         	result.add(OclLibraryHelper.getInstance(this).
    											getAny());
    	            return result;
    	    	    }
    	      }    	      
    	   
	    	if (equals(OclLibraryHelper.getInstance(this).getVoid()))
	    	{
	    		Model topPackage = ModelHelper.
	    						   		getInstance(
	    						   				(Uml15Package) this.refOutermostPackage()).
	    						   						getTopPackage();
	    		result.addAll(((NamespaceImpl)topPackage).getAllClassesWithoutSpez());
	    		return result;
	    	}
    	}   
    	Iterator it = getGeneralization().iterator();

    	while(it.hasNext())
    	{
    	    Generalization g = (Generalization)it.next(); 
    	    result.add(g.getParent());
    	}
    	return result;
    }
    
    /**
     * Returns all subclasses of a classifier.
     */
	public List getChildren(){
        List result = new ArrayList();
        Iterator it = getSpecialisation().iterator();
        while(it.hasNext()){
            Generalization g = (Generalization)it.next(); 
            result.add(g.getChild());
            //System.out.println(" "+getName()+"   Parent:" +g.getParent().getName());
        }
        return result;
    }
    
    //Ocl Submission version 1.6, chapter 3.2.1
    //MOF-UML-Common
    public boolean conformsTo(tudresden.ocl20.core.jmi.ocl.commonmodel.Classifier c) {
        //System.out.println(getName()+" conformsTo "+((Classifier)c).getName()+" ?");
        
        if(equals(c)){
            return true;
        }
        
        Iterator it = getParents().iterator();
        while(it.hasNext()){
            tudresden.ocl20.core.jmi.ocl.commonmodel.Classifier parent = (tudresden.ocl20.core.jmi.ocl.commonmodel.Classifier) it.next();
            
                //System.out.println("Consider parent:" + ((Classifier)parent).getName());
                if(parent.equals(c)){
                    return true;
                }
                if(parent.conformsTo(c)){
                    return true;
                }
        }
        //System.out.println("No!");
        return false;
    }
    
    //Ocl Submission version 1.6, chapter 3.3.8, p 3-22
    public tudresden.ocl20.core.jmi.ocl.commonmodel.Classifier commonSuperType(tudresden.ocl20.core.jmi.ocl.commonmodel.Classifier c) {
        
	if (this.conformsTo(c)) { return c;    }
	if (c.conformsTo(this)) { return this; }
        Set thisParents = new HashSet(); ;
        thisParents.add(this);
        Set cParents = new HashSet(); ;
        cParents.add(c);
        
        //the transitive closure of the Classifier and all  of its  parents
        Set thisTC = new HashSet();
        Set cTC = new HashSet();
        
        while(!(thisParents.isEmpty() && cParents.isEmpty())){
            thisTC.addAll(thisParents);
            cTC.addAll(cParents);
            
            Set thisParentsTemp = new HashSet();
            Iterator thisParentsIt = thisParents.iterator();
            while(thisParentsIt.hasNext()){
                tudresden.ocl20.core.jmi.ocl.commonmodel.Classifier aThisParent = (tudresden.ocl20.core.jmi.ocl.commonmodel.Classifier) thisParentsIt.next();
                if(cTC.contains(aThisParent)){
                    return aThisParent;
                }
                thisParentsTemp.addAll(aThisParent.getParents());
            }
            thisParents=thisParentsTemp;
            
            Set cParentsTemp = new HashSet();
            Iterator cParentsIt = cParents.iterator();
            while(cParentsIt.hasNext()){
                tudresden.ocl20.core.jmi.ocl.commonmodel.Classifier aCParent = (tudresden.ocl20.core.jmi.ocl.commonmodel.Classifier) cParentsIt.next();
                if(thisTC.contains(aCParent)){
                    return aCParent;
                }
                cParentsTemp.addAll(aCParent.getParents());
            }
            cParents=cParentsTemp;
        }
        return null; //should only occure if c is a collection type
    }
    
    public tudresden.ocl20.core.jmi.ocl.types.CollectionType getCollectionType(){
        return getOclLibrary().getCollectionType(this);
    }
    public tudresden.ocl20.core.jmi.ocl.types.SetType getSetType(){
        return getOclLibrary().getSetType(this);
    }
    public tudresden.ocl20.core.jmi.ocl.types.BagType getBagType(){
        return getOclLibrary().getBagType(this);
    }
    public tudresden.ocl20.core.jmi.ocl.types.SequenceType getSequenceType(){
        return getOclLibrary().getSequenceType(this);
    }
    
    /*public Collection allAssociationClasses() {
        return null;
    }
     
    public Collection allAssociationEnds() {
        return null;
    }
    */ 
    public List allAttributes() {
        List allAttributes = new ArrayList();
        Iterator featuresIt =  getFeature().iterator();
        while(featuresIt.hasNext()){
            Feature feature  = (Feature) featuresIt.next();
            if(feature instanceof Attribute){
                allAttributes.add(feature);
            }
        }
        Iterator parentsIt = this.getParents().iterator();
        while(parentsIt.hasNext()){
            Classifier parent = (Classifier) parentsIt.next();
            allAttributes.addAll(parent.allAttributes());
        }
        return allAttributes;
    }
    
     
    public List allOperations() {
        List allOperations = new ArrayList();
        Iterator featuresIt =  getFeature().iterator();
        while(featuresIt.hasNext()){
            Feature feature  = (Feature) featuresIt.next();
            if(feature instanceof Operation){
                allOperations.add(feature);
            }
        }
        Iterator parentsIt = this.getParents().iterator();
        
        while(parentsIt.hasNext()){
            Classifier parent = (Classifier) parentsIt.next();
            //System.out.println(parent.getNameA());
            allOperations.addAll(parent.allOperations());
        }
        return allOperations;
    }
    
    /*
    public Collection allReceptions() {
        return null;
    }*/
    
    //NOTE: We implement the lookupOperations without using the "all..."-Operations,
    //in order to get some more efficient code.
    //But, of course, they  still conform to the specification.
    
    public tudresden.ocl20.core.jmi.ocl.commonmodel.AssociationClass lookupAssociationClass(java.lang.String name) {
        //the "association" reference is missing in the UML-Metamodel!
    	Iterator ownEnds = null;
    	ModelFacade instance = ModelFacade.getInstance(this.refOutermostPackage().refMofId());
    	if (instance != null && 
    		instance.isRepresentative(this.refMofId())&&
    		instance.hasRefObject(this.refMofId()))
    	{    		
    		ownEnds = instance.getAssociationEnds(this.refMofId()).iterator();
    	}
    	else
    		ownEnds = ((CorePackage)this.refImmediatePackage()).getAParticipantAssociation().getAssociation(this).iterator();
    	
    	while(ownEnds.hasNext()){
            AssociationEnd ownEnd = (AssociationEnd) ownEnds.next();
            Association a = ownEnd.getAssociation();
            if(a instanceof UmlAssociationClass && name.equals(a.getNameA())){
                return (UmlAssociationClass) a;
            }
        }
        Iterator parentsIt = this.getParents().iterator();//getGeneralization().iterator();
        while(parentsIt.hasNext()){
            Classifier parent = (Classifier) parentsIt.next();//((GeneralizationImpl) parentsIt.next()).getParent();
            UmlAssociationClass ac = (UmlAssociationClass) parent.lookupAssociationClass(name);
            if(ac != null){
                return ac;
            }
        }
        return null;
    }
    
    //Ocl Submission version 1.6, chapter 3.3.8 p.3-23
    public tudresden.ocl20.core.jmi.ocl.commonmodel.AssociationEnd lookupAssociationEnd(java.lang.String name) {
        //Iterator ownEnds = this.getAssociation().
        //the "association" reference is missing in the UML-Metamodel!
    	Iterator ownEnds = null;
    	ModelFacade instance = ModelFacade.getInstance(this.refOutermostPackage().refMofId());
    	if (instance != null && 
    		instance.isRepresentative(this.refMofId())&&
    		instance.hasRefObject(this.refMofId()))
    	{    		
    		ownEnds = instance.getAssociationEnds(this.refMofId()).iterator();
    	}
    	else
    		ownEnds = ((CorePackage)this.refImmediatePackage()).getAParticipantAssociation().getAssociation(this).iterator();
    	
        while(ownEnds.hasNext()){
            AssociationEnd ownEnd = (AssociationEnd) ownEnds.next();
            Association a = ownEnd.getAssociation();
            Iterator oppositeEnds = a.getConnection().iterator();
            while(oppositeEnds.hasNext()){
                AssociationEnd oppositeEnd = (AssociationEnd) oppositeEnds.next();
                if(!oppositeEnd.equals(ownEnd) && name.equals(oppositeEnd.getNameA())){
                    return oppositeEnd;
                    //Issue: What about unnamed AssociationEnds?
                }
            }
        }
        Iterator parentsIt = this.getParents().iterator();//getGeneralization().iterator();
        while(parentsIt.hasNext()){
            Classifier parent = (Classifier) parentsIt.next();//((GeneralizationImpl) parentsIt.next()).getParent();
            AssociationEnd ae = (AssociationEnd) parent.lookupAssociationEnd(name);
            if(ae != null){
                return ae;
            }
        }
        
        //In addition to the specification, we consider the case, where this is
        //an  AssociationClass as well and look for the AssociationEnds being parts
        //of  this  Association
        if(this instanceof AssociationClass){
            Iterator ends = ((Association) this).getConnection().iterator();
            while(ends.hasNext()){
                AssociationEnd ae = (AssociationEnd) ends.next();
                if(name.equals(ae.getNameA())){
                    return ae;
                    //Issue: What about unnamed AssociationEnds?
                }
            }
        }
        
        return null;
    }
    
    
    //Ocl Submission version 1.6, chapter 3.3.8 p.3-23
    public tudresden.ocl20.core.jmi.ocl.commonmodel.Attribute lookupAttribute(java.lang.String attName) {
        Iterator featuresIt =  getFeature().iterator();
        while(featuresIt.hasNext()){
            Feature feature  = (Feature) featuresIt.next();
            if(feature instanceof Attribute && feature.getNameA().equals(attName)){
                return (Attribute) feature;
            }
        }
        Iterator parentsIt = this.getParents().iterator();//getGeneralization().iterator();
        while(parentsIt.hasNext()){
            Classifier parent = (Classifier) parentsIt.next();//((GeneralizationImpl) parentsIt.next()).getParent();
            Attribute a = (Attribute) parent.lookupAttribute(attName);
            if(a != null){
                return a;
            }
        }
        
        return null;
    }
    
    //Issue: overloading ... what about operation(Object) vs operation(String) ?
    public tudresden.ocl20.core.jmi.ocl.commonmodel.Operation lookupOperation(java.lang.String name, List paramTypes) {
        Operation op;
        
        //UML-MOF-Common
        Iterator allOperationsIt =  allOperations().iterator();
        while(allOperationsIt.hasNext()){
            op = (Operation) allOperationsIt.next();               
            if(name.equals(op.getNameA()) && op.hasMatchingSignature(paramTypes)){
                return op;
            }           
        }

        return null;
    }
    
    public tudresden.ocl20.core.jmi.ocl.commonmodel.Signal lookupSignal(java.lang.String sigName, List paramTypes) {
        Iterator featuresIt =  getFeature().iterator();
        while(featuresIt.hasNext()){
            Feature feature  = (Feature) featuresIt.next();
            if(feature instanceof Reception){
                Signal s = ((Reception) feature).getSignal();
                
                if(sigName.equals(s.getNameA()) && s.hasMatchingSignature(paramTypes)){
                    return s;
                }
            }
        }
        Iterator parentsIt = this.getParents().iterator();//getGeneralization().iterator();
        while(parentsIt.hasNext()){
            Classifier parent = (Classifier) parentsIt.next();//((GeneralizationImpl) parentsIt.next()).getParent();
            Signal s = (Signal) parent.lookupSignal(sigName, paramTypes);
            if(s != null){
                return s;
            }
        }
        
        return null;
    }
    
    public tudresden.ocl20.core.jmi.ocl.commonmodel.Classifier toOclType() {
        // Problem: no predefined types in OCL -> every CASE Tool does "whatever it likes"
        if ( this instanceof DataType ) {
            String name = getNameA().toLowerCase();
            if ( name.equals("int") || 
                name.toLowerCase().equals("integer") ||
                name.toLowerCase().equals("long") ||
                name.toLowerCase().equals("byte")
            ) {
                return this.getOclLibrary().getOclInteger(); 
            } else if ( 
                name.equals("double") ||
                name.toLowerCase().equals("float") ||
                name.toLowerCase().equals("real") 
            ) {
                return this.getOclLibrary().getOclReal(); 
            } else if (
                name.equals("string") ||
                name.equals("String")
            ) {
                return this.getOclLibrary().getOclString(); 
            } else if ( 
                name.equals("bool") ||
                name.equals("boolean")
            ) {
                return this.getOclLibrary().getOclBoolean(); 
            }
            else return this;
        } else {
            String name = getNameA().toLowerCase();
            if ( name.endsWith("string") ) {
                String pathName = this.getPathNameA();
                // use endsWith instead of equals, since the top package also
                // has a name 
                if ( pathName.endsWith("java::lang::String") 
				|  pathName.endsWith("UML_OCL::String")
				|  pathName.endsWith("oclLib::String")) {
                    return this.getOclLibrary().getOclString();
                }
            }
            return this;
        }
    }
    
    // method added by Ansgar Konermann 
    public java.lang.String getPathNameA() {
        String result = getNameA();
        Namespace container = this.getNamespace();
        while ( container != null ) {
            result = container.getNameA() + "::" + result;
            container = container.getNamespace();
        }
        return result;
    }    
    
    public java.util.Collection getExpressionInOclA() {
        return ((Uml15Package)this.refOutermostPackage()).getUml15ocl().getOcl().getExpressions().getAContextualClassifierExpressionInOcl().getExpressionInOcl(this);
    } 
    
    
    public tudresden.ocl20.core.jmi.ocl.commonmodel.Operation createOperation(java.lang.String name, tudresden.ocl20.core.jmi.ocl.commonmodel.Classifier resultType, java.util.List params){
        CorePackage corePackage = (CorePackage)this.refImmediatePackage();
        
        Operation operation = corePackage.getOperation().createOperation(name, VisibilityKindEnum.VK_PUBLIC, false,ScopeKindEnum.SK_INSTANCE, true, CallConcurrencyKindEnum.CCK_CONCURRENT, false, false, false, "");
        operation.setOwner(this);
                   
        Iterator paramVarsIt = params.iterator();
        while(paramVarsIt.hasNext()){
            VariableDeclaration vd = (VariableDeclaration) paramVarsIt.next();
            Parameter param = corePackage.getParameter().createParameter(vd.getName(), VisibilityKindEnum.VK_PUBLIC, false, null, ParameterDirectionKindEnum.PDK_IN);
            param.setBehavioralFeature(operation);
            param.setType((Classifier) vd.getType());
        }
        
        Parameter returnParam = corePackage.getParameter().createParameter(name+".Return", VisibilityKindEnum.VK_PUBLIC, false, null, ParameterDirectionKindEnum.PDK_RETURN);
        
        returnParam.setBehavioralFeature(operation);
        returnParam.setType((Classifier) resultType);
        return operation;
    }
    
    protected abstract java.util.List super_getFeature();

    /**
     * Returns the features of a classifier. If an instance of the class ModelFacade exists
     * the methode getFeature() of the class ModelFacade is used.
     */
    public java.util.List getFeature() 
    {
    	ModelFacade instance = ModelFacade.getInstance(this.refOutermostPackage().refMofId());
    	if (instance != null && 
    		instance.isRepresentative(this.refMofId())&&
    		instance.hasRefObject(this.refMofId()))
    	{    	
    		List list = instance.getFeature(this.refMofId());
    		list.addAll(super_getFeature());
    		
    		return list;    		
    	}
        
    	return super_getFeature();
    }
    
    protected abstract Collection super_getGeneralization();

    /**
     * Returns the generalization of a classifier, where the classifier is the superclass. 
     * If an instance of the class ModelFacade exists the method getGeneralization() of 
     * the class ModelFacade is used.
     */
    public Collection getGeneralization()
    {
    	ModelFacade instance = ModelFacade.getInstance(this.refOutermostPackage().refMofId());
    	if (instance != null && 
    		instance.isRepresentative(this.refMofId())&&
    		instance.hasRefObject(this.refMofId()))
    	{
    		Collection col = new ArrayList();
    		col = instance.getGeneralization(this.refMofId());
    		
    		return col;    		
    	}
        
    	return super_getGeneralization();
    }
    
    /**
     * Returns the generalization of a classifier, where the classifier is the subclass. 
     * If an instance of the class ModelFacade exists the method getSpecialisation() of 
     * the class ModelFacade is used.
     */
    public Collection getSpecialisation()
    {
    	ModelFacade instance = ModelFacade.getInstance(this.refOutermostPackage().refMofId());
    	if (instance != null && 
    		instance.isRepresentative(this.refMofId())&&
    		instance.hasRefObject(this.refMofId()))
    	{
    		Collection col = new ArrayList();
    		col = instance.getSpecialization(this.refMofId());
    		
    		return col;    		
    	}
        
    	return ((Uml15Package)this.refOutermostPackage()).getCore().getAParentSpecialization().getSpecialization(this);
    }
    
}
