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

import org.netbeans.mdr.handlers.*;
import org.netbeans.mdr.storagemodel.*;

import tudresden.ocl20.core.jmi.uml15.datatypes.*;
import tudresden.ocl20.core.jmi.uml15.core.*;
import tudresden.ocl20.integration.ModelFacade;

import java.util.*;
/**
 *
 * @author  Administrator
 */
public abstract class AssociationEndImpl extends ModelElementImpl implements AssociationEnd{
    
    /** Creates a new instance of AssociationEndImpl */
    protected AssociationEndImpl(StorableObject storable) {
        super(storable);
    }
    
    public boolean hasMultiGreaterOne() {
        return isMultipleA();
    }    

    public boolean isOrderedA() {
        return getOrdering().equals(OrderingKindEnum.OK_ORDERED);
    }
    
    public boolean isMultipleA() {
        int result = 0;
        Iterator it = getMultiplicity().getRange().iterator();
        while(it.hasNext()){
            MultiplicityRange mr = (MultiplicityRange) it.next();
            if(mr.getUpper()>1 || mr.getUpper()==-1){
                return true;
            }
        }
        return false;
    }
    
    public boolean isUniqueA() {
        //UML-Associations always have set semantics
        return true;
    }
    
    public tudresden.ocl20.core.jmi.ocl.commonmodel.Classifier getTypeA() {
        return this.getParticipant().toOclType();
    }
    
    public boolean isBinaryA() {
        return this.getAssociation().getConnection().size()==2;
    }
    
    
    public java.util.List getQualifiersA() {
       return getQualifier();
    }
    
    protected abstract tudresden.ocl20.core.jmi.uml15.datatypes.Multiplicity super_getMultiplicity();
    
    /**
     * Returns the multiplicity of an association end. If an instance of the class ModelFacade exists 
     * the method getMultiplicity() of the class ModelFacade is used.
     */
    public tudresden.ocl20.core.jmi.uml15.datatypes.Multiplicity getMultiplicity()
    {
    	ModelFacade instance = ModelFacade.getInstance(this.refOutermostPackage().refMofId());
    	if (instance != null && 
    		instance.isRepresentative(this.refMofId())&&
    		instance.hasRefObject(this.refMofId()))
    	{    		
    		return instance.getMultiplicity(this.refMofId());
    	}
    	
        return super_getMultiplicity();
    }
    
    protected abstract tudresden.ocl20.core.jmi.uml15.core.Association super_getAssociation();
    
    /**
     * Returns the association of an association end. If an instance of the class ModelFacade exists 
     * the method getAssociation() of the class ModelFacade is used.
     * Implemented by Raphael Schmid (schmidra@student.ethz.ch).
     */
    public tudresden.ocl20.core.jmi.uml15.core.Association getAssociation()
    {
    	ModelFacade instance = ModelFacade.getInstance(this.refOutermostPackage().refMofId());
    	if (instance != null && 
    		instance.isRepresentative(this.refMofId())&&
    		instance.hasRefObject(this.refMofId()))
    	{    		
    		return instance.getAssociation(this.refMofId());
    	} 
    	
		return super_getAssociation();	
    }
    
    protected abstract tudresden.ocl20.core.jmi.uml15.core.Classifier super_getParticipant();

    /**
     * Returns the classifier of an association end. If an instance of the class ModelFacade exists 
     * the method getParticipant() of the class ModelFacade is used.
     * Implemented by Raphael Schmid (schmidra@student.ethz.ch).
     */
    public tudresden.ocl20.core.jmi.uml15.core.Classifier getParticipant()
    {
    	ModelFacade instance = ModelFacade.getInstance(this.refOutermostPackage().refMofId());
    	if (instance != null && 
    		instance.isRepresentative(this.refMofId())&&
    		instance.hasRefObject(this.refMofId()))
    	{    		
    		return instance.getParticipant(this.refMofId());
    	} 
    	
		return super_getParticipant();	
    }
    
    protected abstract tudresden.ocl20.core.jmi.uml15.datatypes.OrderingKind super_getOrdering();

   /**
     * Returns the OrderingKind of an attribute or an association end. If an instance of the class ModelFacade exists 
     * the method getOrdering() of the class ModelFacade is used.
     * Implemented by Raphael Schmid (schmidra@student.ethz.ch).
     */
    public tudresden.ocl20.core.jmi.uml15.datatypes.OrderingKind getOrdering()
    {
    	ModelFacade instance = ModelFacade.getInstance(this.refOutermostPackage().refMofId());
    	if (instance != null && 
    		instance.isRepresentative(this.refMofId())&&
    		instance.hasRefObject(this.refMofId()))
    	{    		
    		return instance.getOrdering(this.refMofId());
    	} 
    	
    	return super_getOrdering();
    	
	}    
}
