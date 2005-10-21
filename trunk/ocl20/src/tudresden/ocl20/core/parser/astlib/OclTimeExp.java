/*
 * OclTimeExp.java
 *
 * Created on 6. Oktober 2004, 14:58
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
 * AST enumeration node representing <i>all the different kinds</i> ;o) of OCL
 * time expressions, currently only "@pre".
 *
 * @author Ansgar Konermann
 * @version
 */
public class OclTimeExp extends Object {
    
    private int id;
    
    /** Creates new OclTimeExp */
    private OclTimeExp(int id) { this.id = id; }
    
    public static final OclTimeExp AT_PRE = new OclTimeExp(1);
    
}
