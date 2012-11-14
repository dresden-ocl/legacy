/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * OCL Compiler                                                      *
 * Copyright (C) 2001 Steffen Zschaler (sz9@inf.tu-dresden.de).       *
 * All rights reserved.                                              *
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

// ConstraintChangeEvent.java -- Event to be sent when constraints change
//
// 02/15/2001  [sz9 ]   Created.
//
package tudresden.ocl.gui.events;

import java.util.EventObject;

import tudresden.ocl.gui.ConstraintRepresentation;

/** 
  *
  * @author  sz9
  */
public class ConstraintChangeEvent extends EventObject {

  private int m_nIdx;
  private ConstraintRepresentation m_crOld;
  private ConstraintRepresentation m_crNew;
  
  /** Creates new ConstraintChangeEvent */
  public ConstraintChangeEvent (Object source,
                                    int nIdx,
                                    ConstraintRepresentation crOld,
                                    ConstraintRepresentation crNew) {
    super (source);
    
    m_nIdx = nIdx;
    m_crOld = crOld;
    m_crNew = crNew;
  }
  
  public int getIndex() {
    return m_nIdx;
  }
  
  public ConstraintRepresentation getOld() {
    return m_crOld;
  }

  public ConstraintRepresentation getNew() {
    return m_crNew;
  }
}