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

package tudresden.ocl20.core.jmi.mof14.impl.mof14ocl.adapters;

import tudresden.ocl20.core.jmi.mof14.impl.model.ClassifierImpl;
import tudresden.ocl20.core.jmi.mof14.mof14ocl.adapters.*;
import tudresden.ocl20.core.jmi.mof14.model.ModelPackage;
import tudresden.ocl20.core.jmi.mof14.model.EnumerationType;
import tudresden.ocl20.core.jmi.mof14.model.TypeMapping;
import org.netbeans.mdr.handlers.InstanceHandler;
import org.netbeans.mdr.storagemodel.StorableObject;

/** MOF1.4-specific implementations for Operations defined in
 * CommonModel::Enumeration
 * @author Administrator
 */
public abstract class AdEnumerationImpl extends tudresden.ocl20.core.jmi.mof14.impl.model.MofClassImpl implements AdEnumeration{
    
    /** Creates a new instance of AdEnumerationImpl */
    protected AdEnumerationImpl(StorableObject storable){
        super(storable);
    }
    
    public java.util.List getLiteralA() {
        return this.getLiteral();
    }
    
    //always return the path to the "orignial" enumeration...!
    public java.lang.String getPathNameA() {
        TypeMapping tm = ((ModelPackage)this.refOutermostPackage()).getTypeMapping();
        EnumerationType et = (EnumerationType) tm.getMofType(this).iterator().next(); //this is always exactly one...
        return ((ClassifierImpl)et).getPathNameA();
    }
}
