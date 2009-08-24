/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * OCL Interpreter                                                   *
 * Copyright (C) 2002 Nikolai Krambrock (nikk@gmx.de)                *
 * All rights reserved.                                              *
 *                                                                   *
 * This work was done as a diploma project at the Chair for Software *
 * Construction, University Of Technology Aachen, Germany            *
 * (http://www-lufgi3.informatik.rwth-aachen.de).                    *
 * It was done in co-operation with Software & Design and Managment  *
 * Troisdorf, Germany (http://www.sdm.de)                            *
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
 * this project, please visit the project home page:                 *
 * http://dresden-ocl.sourceforge.net                                * 
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

package tudresden.ocl.interp.exp.intern;

import tudresden.ocl.check.types.Collection;

import tudresden.ocl.interp.core.intern.Assert;

import tudresden.ocl.lib.OclBag;
import tudresden.ocl.lib.OclRoot;
import tudresden.ocl.lib.OclSequence;
import tudresden.ocl.lib.OclSet;


/**
 * This Expression evaluates to a new empty OclCollection of a specific type.
 */
public class ExpCollEmpty extends Exp {
  int colKind;

  public ExpCollEmpty(int colKind) {
    this.colKind = colKind;
  }

  public OclRoot evaluateInternal() {
    if (colKind == Collection.SET) {
      return OclSet.getEmptyOclSet();
    } else if (colKind == Collection.BAG) {
      return OclBag.getEmptyOclBag();
    } else {
      Assert.assertTrue(colKind == Collection.SEQUENCE);
      return OclSequence.getEmptyOclSequence();
    }
  }
}