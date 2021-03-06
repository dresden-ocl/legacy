/*
 * OclOperationOclDefinedEntityDecl.java
 *
 * Created on 27. Oktober 2004, 17:47
 *
 * Copyright (c) 2004, 2005 Ansgar Konermann
 * Contact: <konermann@itikko.net>
 *
 * This file is part of the OCL2.0 parser and compiler libraries
 * created at Technische Universitaet Dresden (TUD), Germany.
 * Visit http://dresden-ocl.sourceforge.net/ for details.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston,
 * MA  02111-1307  USA
 *
 */

package tudresden.ocl20.core.parser.astlib;

/**
 *
 * AST node for operation entity definitions. Specialized subclass of
 * OclDefinedEntityDecl.
 *
 * @author Ansgar Konermann
 * @version
 */

public class OclOperationDefinedEntityDecl extends OclDefinedEntityDecl {
    
    /**
     * Holds value of property operationSignature.
     */
    private OclOperationSignature operationSignature;

    /**
     * Holds value of property operationName
     */
    private String operationName;
    
    public OclOperationDefinedEntityDecl() {
        super(OclDefinedEntityDecl.EntityType.OPERATION);
    }
    
    /**
     * Getter for property operationDeclaration.
     * @return Value of property operationDeclaration.
     */
    public OclOperationSignature getOperationSignature() {
        return this.operationSignature;
    }
    
    /**
     * Setter for property operationDeclaration.
     * @param operationDeclaration New value of property operationDeclaration.
     */
    public void setOperationSignature(OclOperationSignature operationSignature) {
        this.operationSignature = operationSignature;
    }

    
    /**
     * Getter for property operationName.
     * @return Value of property operationName
     */
    public String getOperationName() {
    	return this.operationName;
    }
    
    /**
     * Setter for property operationName.
     * @param operationName New value of property operationName.
     */
    public void setOperationName(String operationName) {
    	this.operationName = operationName;
    }
    
}

