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

package tudresden.ocl20.core.jmi.uml15.impl.uml15ocl.types;

import java.util.*;

import tudresden.ocl20.core.jmi.uml15.impl.core.ClassifierImpl;
import tudresden.ocl20.core.jmi.uml15.core.*;
import tudresden.ocl20.core.jmi.uml15.datatypes.*;
import tudresden.ocl20.core.jmi.uml15.uml15.Uml15Package;
import tudresden.ocl20.core.jmi.uml15.uml15ocl.types.*;

import org.netbeans.mdr.storagemodel.StorableObject;

/**
 *
 * @author  Administrator
 */
public abstract class TupleTypeImpl extends ClassifierImpl implements TupleType{
    
    /** Creates a new instance of TupleTypeImpl */
    protected TupleTypeImpl(StorableObject storable) {
        super(storable);
    }
    
    //Ocl Submission version 1.6, chapter 3.2.1, p 3-5
    //we consider "attributes" instead of "allAttributes", because
    //we dont establish real Generalizations  between TupleTypes
    //that is, a TupleType only inherits directly  from OclAny
    public boolean conformsTo(tudresden.ocl20.core.jmi.ocl.commonmodel.Classifier c) {
        if(c instanceof TupleType){
            Iterator otherIt = c.allAttributes().iterator();
            while(otherIt.hasNext()){
                Attribute otherAttr = (Attribute) otherIt.next();
                Attribute matchingAttr =  (Attribute)lookupAttribute(otherAttr.getNameA());
                if(matchingAttr ==  null){return false;}
                if(!matchingAttr.getType().conformsTo(otherAttr.getType())){
                    return false;
                }
            }          
            return true;
        } else {
            return super.conformsTo(c);  //will return true for OclAny only
        }
    }
    public tudresden.ocl20.core.jmi.ocl.commonmodel.Classifier commonSuperType(tudresden.ocl20.core.jmi.ocl.commonmodel.Classifier c){
        if(c instanceof TupleType){
            CorePackage core = ((Uml15Package)refOutermostPackage()).getCore();

            //create a TupleType whose Attributes  are the intersection of the two TupleTypes. 
            //e.g. TupleType(a:Integer ,  b:Set(Real)) and TupleType (b:Bag(Real), c:String)
            //yield a commonSuperType TupleType(b:Collection(Real));
            List commonAttributes = new  ArrayList();
            Iterator otherIt = c.allAttributes().iterator();
            while(otherIt.hasNext()){
                Attribute otherAttr = (Attribute) otherIt.next();
                Attribute matchingAttr =  (Attribute)lookupAttribute(otherAttr.getNameA());
                if(matchingAttr !=  null){

                    String name = otherAttr.getNameA();
                    Classifier type = (Classifier)matchingAttr.getType().commonSuperType(otherAttr.getType());
                    Attribute a = (Attribute)core.getAttribute().make(name,type);
                    commonAttributes.add(a);
                }           
            } 
            
            return (Classifier)((TupleTypeClass) refClass()).make(commonAttributes);     
        } else {
            return super.commonSuperType(c);  //will return OclAny 
        }
    }
   
}
