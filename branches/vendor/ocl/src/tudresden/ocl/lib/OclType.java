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
// FILE: d:/java/classes/de/tudresden/ocl/OclType.java

package tudresden.ocl.lib; /* !!! if the package name is changed,
                            * please change the class attribute
                            * "oclPackage" further down
                            */

import java.util.*;
import java.lang.reflect.*;

/** This class represents the predefined OCL class OclType and gives access to
 *  the meta level of OCL. Is is implemented as an adapter class around a
 *  java.lang.Class object.
 *
 *  @see java.lang.Class
 *  @author Frank Finger
 */
public class OclType extends OclAny {

  /** the name of this package
   */
  private static String oclPackage="tudresden.ocl.lib";

  /** the encapsulated Class object of this instance of OclType;
   *  for basic OCL types this is a class of this library,
   *  e.g. OclInteger
   */
  private java.lang.Class myClass;

  /** the name of this OclType object, e.g. "Integer" or "Person"
   */
  private String myName;

  private boolean bUndefined;

  /** the OclType object that is the result of an undefined OCL expression
   */
  public static OclType UNDEFINED=new OclType();

  /** singletons for the predefined types; can also be accessed through
   *  getOclTypeFor(String), which calls getPredefinedTypeFor(String)
   */
  public static final OclType typeInteger;
  public static final OclType typeReal;
  public static final OclType typeString;
  public static final OclType typeBoolean;
  public static final OclType typeAny;
  public static final OclType typeType;

  /** a Set containing all names of predefined OCL types
   */
  private static Map predefinedTypes;

  static {
    OclType tInteger, tReal, tString, tBoolean, tAny, tType;
    try {
      tInteger = new OclType(Class.forName(oclPackage+".OclInteger"));
      tReal    = new OclType(Class.forName(oclPackage+".OclReal"));
      tString  = new OclType(Class.forName(oclPackage+".OclString"));
      tBoolean = new OclType(Class.forName(oclPackage+".OclBoolean"));
      tAny     = new OclType(Class.forName(oclPackage+".OclAny"));
      tType    = new OclType(Class.forName(oclPackage+".OclType"));
    } catch (ClassNotFoundException cnf) {
      System.out.println("error in initializer of class OclType");
      // and now, some assigments to keep the compiler happy
      tInteger=tReal=tString=tBoolean=tAny=tType=null;
    }
    typeInteger=tInteger;
    typeReal=tReal;
    typeString=tString;
    typeBoolean=tBoolean;
    typeAny=tAny;
    typeType=tType;

    predefinedTypes=getPredefinedTypes();
  }

  /** package-visible constructor for defined OclType objects
   *
   *  @throws OclException if parameter c is <CODE>null</CODE>
   */
  protected OclType(Class c) {
    if (c==null) {
      throw new OclException(
        "constructor of OclType called with <null> as argument"
      );
    }
    myClass=c;
  }

  /** private constructor for the undefined OclType object
   */
  private OclType() {
    bUndefined=true;
  }

  /** factory method for OclTypes that creates OclType objects from its fully
   *  qualified name; if no class with the given name is found, this method
   *  either raises an exception or returns the undefined OclType object,
   *  depending on the value of Ocl.STRICT_CHECKING
   *
   *  @param name the name of the class that will be encapsulated by this
   *         instance of OclType; the name needs to be fully qualified for
   *         application types or be one of the names of the predefined OCL
   *         types, e.g. "String" or "Integer"
   *
   *  @throws OclException there is no name with the given class and
   *          Ocl.STRICT_CHECKING is <CODE>true</CODE>
   *
   *  @see Ocl#STRICT_CHECKING
   *  @see #UNDEFINED
   */
  public static OclType getOclTypeFor(String name) {
    if (predefinedTypes.get(name)!=null) return getPredefinedTypeFor(name);
    try {
      Class cls=Class.forName(name);
      return new OclType(cls);
    } catch (ClassNotFoundException cfe) {
      if (Ocl.STRICT_CHECKING)
        throw new OclException("no class found for name "+name);
      else
        return UNDEFINED;
    }
  }

  /** factory method for OclTypes that creates OclType objects from its
   *  name; if the name does not contains a '.' character, package information
   *  is extracted from the object given as <CODE>context</CODE>
   *  (should usually be called with <code>this</code> as context parameter);
   *  if no class with the given name is found, this method
   *  either raises an exception or returns the undefined OclType object,
   *  depending on the value of Ocl.STRICT_CHECKING
   *
   *  @param name the name of the class that will be encapsulated by this
   *         instance of OclType; the name needs to be fully qualified for
   *         application types or be one of the names of the predefined OCL
   *         types, e.g. "String" or "Integer"
   *
   *  @param context package information is extracted from this object (the
   *         class with the requested name will be assumed to be in the same
   *         package as the <CODE>context</CODE> object)
   *
   *  @throws OclException there is no name with the given class and
   *          Ocl.STRICT_CHECKING is <CODE>true</CODE>
   *
   *  @see Ocl#STRICT_CHECKING
   *  @see #UNDEFINED
   */
  public static OclType getOclTypeFor(Object context, String name) {
    String fullyQualName;
    if ( name.indexOf('.')==-1 && predefinedTypes.get(name)==null ) {
      fullyQualName=context.getClass().getName();
      fullyQualName=
        fullyQualName.substring(0, fullyQualName.lastIndexOf('.'))+"."+name;
    }
    else {
      fullyQualName=name;
    }
    return getOclTypeFor(fullyQualName);
  }

  protected static OclType getPredefinedTypeFor(String name) {
    OclType type=(OclType)predefinedTypes.get(name);
    if (type==null)
      throw new OclException("request for non-existent predefined type");
    return type;
  }

  private static Map getPredefinedTypes() {
    Map map=new HashMap();
    map.put("OclInteger", typeInteger);
    map.put("OclReal", typeReal);
    map.put("OclBoolean", typeBoolean);
    map.put("OclString", typeString);
    map.put("Integer", typeInteger);
    map.put("Real", typeReal);
    map.put("Boolean", typeBoolean);
    map.put("String", typeString);
    map.put("OclAny", typeAny);
    map.put("OclType", typeType);
    return map;
  }

  public OclBoolean isEqualTo(Object o) {
    if ( !(o instanceof OclType) ) {
      if (Ocl.STRICT_CHECKING) {
        throw new OclClassCastException(
          "OclType isEqualTo() is called with a non-OclType parameter"
        );
      } else
      {
        return OclBoolean.FALSE;
      }
    }
    OclType other=(OclType)o;
    if (isUndefined() || other.isUndefined() ) return OclBoolean.UNDEFINED;
    if (this==o || this.myClass.equals(other.myClass))
      return OclBoolean.TRUE;
    else
      return OclBoolean.FALSE;
  }

  public boolean equals(Object o) {
    if ( !(o instanceof OclType) ) return false;
    OclType other=(OclType) o;
    return myClass.equals(other.myClass);
  }

  public int hashCode() {
    return myClass.hashCode();
  }

  public String toString() {
    return "OclType<"+myClass.getName()+">";
  }

  /** This method either throws a runtime exception or returns an undefined
   *  value, depending on OCL.STRICT_CHECKING.
   *
   *  @see Ocl#STRICT_CHECKING
   */
  public OclRoot getFeature(String name) {
    if (Ocl.STRICT_CHECKING) {
      throw new OclException("feature "+name+" of OclType requested");
    }
    return UNDEFINED;
  }

  /** @see OclAny#oclIsKindOf(OclType type)
   */
  public OclBoolean oclIsKindOf(OclType type) {
    if (isUndefined()) return OclBoolean.UNDEFINED;
    return oclIsTypeOf(type).or(super.oclIsKindOf(type));
  }

  public OclBoolean oclIsTypeOf(OclType type) {
    if (isUndefined()) return OclBoolean.UNDEFINED;
    boolean ret;
    if (type.equals(typeType))
      return OclBoolean.TRUE;
    else
      return OclBoolean.FALSE;
  }


  /** @return the name of this type, in the format defined for java.lang.Class
   *          names and represented by a OclString object
   *
   *  @see Class#getName()
   */
  public OclString name() {
    if (isUndefined()) return OclString.UNDEFINED;
    if (predefinedTypes.containsValue(this)) {
      if (this==typeAny) {
        return (OclString) Ocl.getFor("OclAny");
      } else if (this==typeBoolean) {
        return (OclString) Ocl.getFor("Boolean");
      } else if (this==typeReal) {
        return (OclString) Ocl.getFor("Real");
      } else if (this==typeInteger) {
        return (OclString) Ocl.getFor("Integer");
      } else if (this==typeString) {
        return (OclString) Ocl.getFor("String");
      } else if (this==typeType) {
        return (OclString) Ocl.getFor("OclType");
      }
    }
    String ret=myClass.getName();
    if (! Ocl.JAVA_CLASS_NAMES) {
      int start=ret.lastIndexOf(".");
      if (start != -1)
        ret=ret.substring(start+1);
    }
    return new OclString(ret);
  }

  /** @return an OclSet containing OclString representations of the names
   *          of all attributes of this type; it also contains all names of
   *          association ends of the corresponding UML model class,
   *          since these are represented by attributes in the Java class
   */
  public OclSet attributes() {
    if (isUndefined()) return OclSet.UNDEFINED;
    Set set=new HashSet();
    Class cls=myClass;
    while (cls!=null) {
      Field[] fields=cls.getFields();
      for (int i=0; i<fields.length; i++) {
        set.add(new OclString(fields[i].getName()));
      }
      cls=cls.getSuperclass();
    }
    return new OclSet(set);
  }

  /** @return an OclSet containing all possible names of association ends for
   *          all fields of the backing java.lang.Class instance, as returned
   *          by <CODE>Ocl.getPossibleAssociationNames()</CODE>.
   *
   *  @see Ocl#getPossibleAssociationNames(String n)
   */
  public OclSet associationEnds() {
    if (isUndefined()) return OclSet.UNDEFINED;
    Set set=new HashSet();
    Class cls=myClass;
    while (cls!=null) {
      Field[] fields=cls.getFields();
      for (int i=0; i<fields.length; i++) {
        String[] posNames=Ocl.getPossibleAssociationNames(fields[i].getName());
        for (int j=0; j<posNames.length; j++) {
          set.add(new OclString(posNames[j]));
        }
      }
      cls=cls.getSuperclass();
    }
    return new OclSet(set);
  }

  /** @return an OclSet containing the names of all public methods of the Java
   *          class encapsulated by this OclType object, represented as
   *          OclStrings
   */
  public OclSet operations() {
    if (isUndefined()) return OclSet.UNDEFINED;
    Set set=new HashSet();
    Method[] methods=myClass.getMethods();
    for (int i=0; i<methods.length; i++) {
      set.add(new OclString(methods[i].getName()));
    }
    return new OclSet(set);
  }

  /** @return an OclSet that contains OclType objects for this class'
   *          superclass and all interfaces
   */
  public OclSet supertypes() {
    if (isUndefined()) return OclSet.UNDEFINED;
    Set set=new HashSet();
    Class superclass=myClass.getSuperclass();
    if (superclass!=null) set.add(new OclType(superclass));
    Class[] interfaces=myClass.getInterfaces();
    for (int i=0; i<interfaces.length; i++) {
      set.add( new OclType(interfaces[i]) );
    }
    return new OclSet(set);
  }

  /** @return an OclSet that contains OclType objects for this class'
   *          superclasses and all interfaces
   */
  public OclSet allSupertypes() {
    if (isUndefined()) return OclSet.UNDEFINED;
    Set set=new HashSet();
    Class superclass=myClass.getSuperclass();
    while (superclass!=null) {
      set.add(new OclType(superclass));
      superclass=superclass.getSuperclass();
    }
    Class[] interfaces=myClass.getInterfaces();
    for (int i=0; i<interfaces.length; i++) {
      set.add( new OclType(interfaces[i]) );
    }
    set.add(typeAny);
    return new OclSet(set);
  }

  /** In general, it is not possible to get all instances of a class or type in
   *  Java. It might be possible in certain environments, e.g. in a CASE
   *  platform through accessing the repository. This method calls
   *  <code>Ocl.getAllInstances(OclType)</code>, which needs an implementation
   *  of AllInstancesAdapter.
   *
   *  @throws OclException if no AllInstancesAdapter is set in the class Ocl
   *
   *  @see Ocl#getAllInstances(OclType t)
   *  @see AllInstancesAdapter
   */
  public OclSet allInstances() {
    if (isUndefined()) return OclSet.UNDEFINED;
    return Ocl.getAllInstances(this);
  }

  /** @return true if this OclType is the result of an undefined OCL expression
   */
  public boolean isUndefined() {
    return bUndefined;
  }
} /* end class OclType */

