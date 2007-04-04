/**
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Copyright (C) 2007 Matthias Braeuer (braeuer.matthias@web.de).            *
 * All rights reserved.                                                      *
 *                                                                           *
 * This work was done as a project at the Chair for Software Technology      *
 * Dresden University Of Technology, Germany (http://st.inf.tu-dresden.de).  *
 * It is understood that any modification not identified as such is not      *
 * covered by the preceding statement.                                       *
 *                                                                           *
 * This work is free software; you can redistribute it and/or modify it      *
 * under the terms of the GNU Library General Public License as published    *
 * by the Free Software Foundation; either version 2 of the License, or      *
 * (at your option) any later version.                                       *
 *                                                                           *
 * This work is distributed in the hope that it will be useful, but WITHOUT  *
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or     *
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Library General Public     *
 * License for more details.                                                 *
 *                                                                           *
 * You should have received a copy of the GNU Library General Public License *
 * along with this library; if not, you can view it online at                *
 * http://www.fsf.org/licensing/licenses/gpl.html.                           *
 *                                                                           *
 * To submit a bug report, send a comment, or get the latest news on this    *
 * project, please visit the website: http://dresden-ocl.sourceforge.net.    *
 * For more information on OCL and related projects visit the OCL Portal:    *
 * http://st.inf.tu-dresden.de/ocl                                           *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *
 * $Id$
 */
package tudresden.ocl20.pivot.pivotmodel;

import java.util.List;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Generic Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link tudresden.ocl20.pivot.pivotmodel.GenericType#getTypedElement <em>Typed Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public interface GenericType extends NamedElement {

  /**
   * Returns the value of the '<em><b>Typed Element</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link tudresden.ocl20.pivot.pivotmodel.TypedElement#getGenericType <em>Generic Type</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Typed Element</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Typed Element</em>' container reference.
   * @see #setTypedElement(TypedElement)
   * @see tudresden.ocl20.pivot.pivotmodel.TypedElement#getGenericType
   * @generated
   */
  TypedElement getTypedElement();

  /**
   * Sets the value of the '{@link tudresden.ocl20.pivot.pivotmodel.GenericType#getTypedElement <em>Typed Element</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Typed Element</em>' container reference.
   * @see #getTypedElement()
   * @generated
   */
  void setTypedElement(TypedElement value);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  TypedElement bindTypedElement(List<TypeParameter> parameters, List<? extends Type> types);

  /**
   * Redefines {@link NamedElement#clone()} with a covariant return type.
   * 
   * @see tudresden.ocl20.pivot.pivotmodel.NamedElement#clone()
   */
  GenericType clone();

} // GenericType
