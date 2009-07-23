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
package tudresden.ocl20.pivot.xocl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Loop Exp XS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link tudresden.ocl20.pivot.xocl.LoopExpXS#getIterator <em>Iterator</em>}</li>
 *   <li>{@link tudresden.ocl20.pivot.xocl.LoopExpXS#getBody <em>Body</em>}</li>
 * </ul>
 * </p>
 *
 * @see tudresden.ocl20.pivot.xocl.XOCLPackage#getLoopExpXS()
 * @model abstract="true"
 * @generated
 */
public interface LoopExpXS extends CallExpXS {

  /**
   * Returns the value of the '<em><b>Iterator</b></em>' containment reference list.
   * The list contents are of type {@link tudresden.ocl20.pivot.xocl.VariableXS}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Iterator</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Iterator</em>' containment reference list.
   * @see tudresden.ocl20.pivot.xocl.XOCLPackage#getLoopExpXS_Iterator()
   * @model containment="true"
   * @generated
   */
  EList<VariableXS> getIterator();

  /**
   * Returns the value of the '<em><b>Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Body</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Body</em>' containment reference.
   * @see #setBody(OclExpressionXS)
   * @see tudresden.ocl20.pivot.xocl.XOCLPackage#getLoopExpXS_Body()
   * @model containment="true" required="true"
   * @generated
   */
  OclExpressionXS getBody();

  /**
   * Sets the value of the '{@link tudresden.ocl20.pivot.xocl.LoopExpXS#getBody <em>Body</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Body</em>' containment reference.
   * @see #getBody()
   * @generated
   */
  void setBody(OclExpressionXS value);

} // LoopExpXS