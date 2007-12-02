/*
 * TypeMap.java
 *
 * Created on 24. September 2004, 00:23
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

package org.sablecc.sablecc;

import java.util.*;

/**
 *
 * Maps type names to package names of that type. Used in generator for 
 * LAttrEvalAdapter to allow reflective access to type system and type
 * checks. This should probably factored out into the specification file
 * in a later version, for the prototype this hardcoded map ought to be enough.
 *
 * @author Ansgar Konermann
 * @version
 */
public class TypeMap extends Object {
    
    private Map packagesByTypeName = new HashMap();
    
    /** Creates new TypeMap */
    public TypeMap() {
        initializePackageDirectory();
    }

    public String getPackageForType(String type) {
        String pkgName = (String) packagesByTypeName.get(type);
        if ( pkgName == null ) {
            throw new RuntimeException("No package name for type " + type + " in type to package map " + this.getClass().getName());
        }
        return pkgName;
    }
    
    private void initializePackageDirectory() {
        Map m = packagesByTypeName;
        addPackage(m, "java.lang", new String[] 
            { "Object", "String", "Boolean", "Double", "Integer", "Long"
            }
        );
        /*addPackage(m, "java.util", new String[] 
            { "List"
            }
        );*/
        /*addPackage(m, "ocl2as", new String[] 
            { "ocl2as.List"
            }
        );*/
        addPackage(m, "tudresden.ocl20.pivot.ocl2parser.gen.ocl2as", new String[] 
            {
        		"OclFileAS",
        		"PackagedConstraintAS",
                "ExpressionInOclAS",
                "ConstraintAS",
                "AttrOrAssocConstraintAS",
                "InitAttrOrAssocConstraintAS",
                "DeriveAttrOrAssocConstraintAS",
                "ClassifierConstraintAS",
                "DefClassifierConstraintAS",
                "DefAttributeConstraintAS",
                "DefOperationConstraintAS",
                "InvClassifierConstraintAS",
                "OperationConstraintAS",
                "OperationSignatureAS",
                "TypeAS",
                "PathNameAS",
                "TupleTypeAS",
                "CollectionTypeAS",
                "OclExpressionAS",
                "LiteralExpAS",
                "TupleLiteralExpAS",
                "TupleLiteralPartAS",
                "CollectionLiteralExpAS",
                "CollectionLiteralPartAS",
                "CollectionRangeAS",
                "CollectionItemAS",
                "PrimitiveLiteralExpAS",
                "BooleanLiteralExpAS",
                "StringLiteralExpAS",
                "NumericalLiteralExpAS",
                "IntegerLiteralExpAS",
                "RealLiteralExpAS",
                "LetExpAS",
                "IfExpAS",
                "CallExpAS",
                "LoopExpAS",
                "IterateExpAS",
                "IteratorExpAS",
                "FeatureCallExpAS",
                "OperationCallExpAS",
                "PropertyCallExpAS",
                "VariableExpAS",
                "VariableAS",
                "TokenAS"
                
            }
        );
    }
        
    private void addPackage(Map m, String pkgName, String[] classNames) {
        for (int i = 0; i < classNames.length; i++) {
            m.put(classNames[i],  pkgName);
        }
    }
    
}
