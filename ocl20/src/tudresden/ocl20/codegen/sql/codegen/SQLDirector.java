/*
 * SQLDirector.java
 * 
 * Copyright (c) 2001 Sten Loecher
 *
 * This file is part of the Dresden OCL2.0 Toolkit
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

package tudresden.ocl20.codegen.sql.codegen;



/**
 *  This interface must be implemented by classes that use SQLBuilders.
 *  See the SQLBuilder documentation for further details.
 *  
 *  @author Sten Loecher
 *  @see SQLBuilder
 *  @deprecated See tudresden.ocl20.codegen.decl.tools.sql
 */
public interface SQLDirector {
    /**
     *  @param sqlb a builder used by the director to build database specific code
     */
    public void setBuilder(SQLBuilder sqlb);
    
    /**
     *  Does the construction of the SQL code.
     */
    public void construct();
    
    /**
     *  @return the resulting SQL code from the construction process
     */
    public String getCode(); 
}

