/**
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Copyright (C) 2007 Matthias Braeuer (braeuer.matthias@web.de).            *
 * All rights reserved.                                                      *
 *                                                                           *
 * This work was done as a project at the Chair for Software Technology,     *
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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Multiplicity Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>
 * A <code>MultiplicityElement</code> is an abstract 
 * metaclass which includes optional attributes for defining 
 * properties related to the multiplicity of an element.
 * </p>
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link tudresden.ocl20.pivot.pivotmodel.MultiplicityElement#isOrdered <em>Ordered</em>}</li>
 *   <li>{@link tudresden.ocl20.pivot.pivotmodel.MultiplicityElement#isUnique <em>Unique</em>}</li>
 *   <li>{@link tudresden.ocl20.pivot.pivotmodel.MultiplicityElement#isMultiple <em>Multiple</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public interface MultiplicityElement {

  /**
   * Returns the value of the '<em><b>Ordered</b></em>' attribute.
   * The default value is <code>"false"</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <p>
   * For a multivalued multiplicity, this attribute specifies whether 
   * the values in an instantiation of this element are
   * sequentially ordered. Default is <code>false</code>.
   * </p>
   * <!-- end-model-doc -->
   * @return the value of the '<em>Ordered</em>' attribute.
   * @see #setOrdered(boolean)
   * @generated
   */
  boolean isOrdered();

  /**
   * Sets the value of the '{@link tudresden.ocl20.pivot.pivotmodel.MultiplicityElement#isOrdered <em>Ordered</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ordered</em>' attribute.
   * @see #isOrdered()
   * @generated
   */
  void setOrdered(boolean value);

  /**
   * Returns the value of the '<em><b>Unique</b></em>' attribute.
   * The default value is <code>"true"</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <p>
   * For a multivalued multiplicity, this attributes specifies 
   * whether the values in an instantiation of this element are 
   * unique. Default is <code>true</code>.
   * </p>
   * <!-- end-model-doc -->
   * @return the value of the '<em>Unique</em>' attribute.
   * @see #setUnique(boolean)
   * @generated
   */
  boolean isUnique();

  /**
   * Sets the value of the '{@link tudresden.ocl20.pivot.pivotmodel.MultiplicityElement#isUnique <em>Unique</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Unique</em>' attribute.
   * @see #isUnique()
   * @generated
   */
  void setUnique(boolean value);

  /**
   * Returns the value of the '<em><b>Multiple</b></em>' attribute.
   * The default value is <code>"false"</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <p>
   * Specifies whether this multiplity element has an upper bound larger than 1. Default is <code>false</code>.
   * 
   * The reason for not including concrete lower and upper 
   * bounds in the Pivot Model is that for an evaluation with 
   * OCL this information is not needed. The distinction between 
   * single-valued and multi-valued multiplicities suffices.
   * </p>
   * <!-- end-model-doc -->
   * @return the value of the '<em>Multiple</em>' attribute.
   * @see #setMultiple(boolean)
   * @generated
   */
  boolean isMultiple();

  /**
   * Sets the value of the '{@link tudresden.ocl20.pivot.pivotmodel.MultiplicityElement#isMultiple <em>Multiple</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Multiple</em>' attribute.
   * @see #isMultiple()
   * @generated
   */
  void setMultiple(boolean value);

} // MultiplicityElement
