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
// FILE: d:/java/classes/de/tudresden/ocl/OclStateAdapter.java

package tudresden.ocl.lib;
import java.util.*;

/** This interface must be implemented if <CODE>OclAny</CODE>s operation
 *  <CODE>oclInState</CODE> is used. The implementation must be able to check
 *  the state of objects. That can be done either in a object dependent way,
 *  or in object independent way if the state machines are generated by a CASE
 *  tool and that tools generation schemes permits a general solution. If the
 *  proposed way of state evaluation through <CODE>OclState</CODE>s String
 *  seems inadequate for performance reasons, consider creating a more
 *  efficient subclass of <CODE>OclState</CODE>, and a subclass of
 *  <CODE>DefaultOclFactory</CODE> that uses these custom OclStates.
 *
 *  @see OclAny#oclInState(OclState state)
 *  @see OclState
 *  @see Ocl#getOclStateFor(String s)
 *  @author Frank Finger
 */
public interface OclStateAdapter {

 /** @return true (not OclBoolean.TRUE) if <CODE>obj</CODE> is in the state
  *  denoted by <CODE>stateName</CODE>
  *
  *  @param obj an application object whos state is to be checked
  *  @param stateName a String containing the state name
  */
  public boolean objectInState(Object obj, String stateName);

} /* end interface OclStateAdapter */

