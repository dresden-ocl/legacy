/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * OCL Compiler                                                      *
 * Copyright (C) 1999, 2000 Frank Finger (frank@finger.org).         *
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
// FILE: d:/java/classes/de/tudresden/ocl/OclAny.java

package tudresden.ocl20.core.lib;
import java.util.*;

/** This class represents the part of the OCL type OclAny common to basic
 *  types and application types, i.e. the availablity of certain properties.
 */
public abstract class OclAny implements OclRoot {
    
    public OclAny() {
    }
    
    public abstract OclBoolean isEqualTo(Object o);
    
    /** @return the negated result of isEqualTo
     */
    public OclBoolean isNotEqualTo(Object o) {
        return isEqualTo(o).not();
    }
    
    /** This method returns true if the OclType given as parameter is a type
     *  of the object whose method is called or a supertype of such a type.
     */
    public OclBoolean oclIsKindOf(OclType t) {
        if(isUndefined()){
            return new OclBoolean(0, getUndefinedReason());
        }
        return OclBoolean.getOclRepresentationFor(t.isOfKind(this));
    }
    
    /** This method returns true if the OclType given as parameter is a "type"
     *  of this object. "Type" is to be understood in the UML/OCL sense of the
     *  word, meaning that an OclAny has exactly one type and
     *  this types supertypes are not types of the object.
     */
    public OclBoolean oclIsTypeOf(OclType t) {
        if(isUndefined()){
            return new OclBoolean(0, getUndefinedReason());
        }
        return OclBoolean.getOclRepresentationFor(t.isOfType(this));
    }
    
    
    public OclAny oclAsType(OclType t) {
        return this;
    }
        
    /**
     The reason, why this object represents an undefined value.
     Additionally, this is the tag, whether this object represents
     a undefined value.
     Is null, if and only if it is not undefined.
     */
    private String undefinedreason=null;
    
    /**
     Constructs an instance representing an undefined value.
     @parameter dummy must be 0.
     */
    protected OclAny(int dummy, String undefinedreason) {
        if(dummy!=0)
            throw new RuntimeException();
        this.undefinedreason=undefinedreason;
    }
    
    public final boolean isUndefined() {
        return undefinedreason!=null;
    }
    
    public final String getUndefinedReason() {
        if(undefinedreason!=null)
            return undefinedreason;
        else
            throw new RuntimeException();
    }
    
    // END of section implementing undefined values
    
} /* end class OclAny */

