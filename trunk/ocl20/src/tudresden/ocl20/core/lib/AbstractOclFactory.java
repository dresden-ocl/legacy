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
// FILE: d:/java/classes/de/tudresden/ocl/DefaultOclFactory.java

package tudresden.ocl20.lib;

import java.util.*;
import java.util.Enumeration;

/** This class is the default implementation of the <CODE>OclFactory</CODE>
 *  interface. It is suitable for Java code generated by Argo and Rational
 *  Rose.
 *
 *  @author Frank Finger
 */
public abstract class  AbstractOclFactory implements OclFactory {

    public abstract OclRoot getOclRepresentationFor(OclType type, Object o);
        
    
    public abstract OclRoot getOclRepresentationFor(Object o); 

  // factory methods for basic values:

  public OclRoot getOclRepresentationFor(boolean b) {
    if (b)
      return OclBoolean.TRUE;
    else
      return OclBoolean.FALSE;
  }

  /** @return an <CODE>OclInteger</CODE> object */
  public OclRoot getOclRepresentationFor(byte b) {
    return new OclInteger((long)b);
  }

  /** @return an <CODE>OclInteger</CODE> object */
  public OclRoot getOclRepresentationFor(short s) {
    return new OclInteger((long)s);
  }

  /** @return an <CODE>OclInteger</CODE> object */
  public OclRoot getOclRepresentationFor(int i) {
    return new OclInteger(i);
  }

  /** @return an <CODE>OclInteger</CODE> object */
  public OclRoot getOclRepresentationFor(long l) {
    return new OclInteger(l);
  }

  /** @return an <CODE>OclReal</CODE> object
   */
  public OclRoot getOclRepresentationFor(float f) {
    return new OclReal((double)f);
  }

  /** @return an <CODE>OclReal</CODE> object
   */
  public OclRoot getOclRepresentationFor(double d) {
    return new OclReal(d);
  }

  /** @return an <CODE>OclString</CODE> object
   */
  public OclRoot getOclRepresentationFor(char c) {
    return new OclString(new Character(c).toString());
  }

  /** @return an OclState object with s as state description; this method
   *          might be implemented differently to increase performance with
   *          frequent state queries
   *
   *  @see OclStateAdapter
   */
  public OclState getOclStateFor(String s) {
    return new OclState(s);
  }

  public abstract Object reconvert(OclRoot oclObject);
  public abstract Object reconvert(OclParameter param);
  public abstract Object reconvert(NonOclType targetType, OclRoot oclObject);

  public abstract OclModelType getOclModelTypeFor(String name);   

  public OclEnumLiteral getOclEnumLiteralFor(String enumName, String literalName){
    return getOclEnumTypeFor(enumName).getLiteralFor(literalName);
  }
  
  public abstract OclEnumType getOclEnumTypeFor(String pathname);
  
  public OclTupleType getOclTupleType(String[] names, OclType[] types) {
      return OclTupleType.make(names, types);
  }
  
} /* end class DefaultOclFactory */

