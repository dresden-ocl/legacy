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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>If Exp XS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link tudresden.ocl20.pivot.xocl.IfExpXS#getElseExpression <em>Else Expression</em>}</li>
 *   <li>{@link tudresden.ocl20.pivot.xocl.IfExpXS#getCondition <em>Condition</em>}</li>
 *   <li>{@link tudresden.ocl20.pivot.xocl.IfExpXS#getThenExpression <em>Then Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see tudresden.ocl20.pivot.xocl.XOCLPackage#getIfExpXS()
 * @model
 * @generated
 */
public interface IfExpXS extends OclExpressionXS {

  /**
   * Returns the value of the '<em><b>Else Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Else Expression</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Else Expression</em>' containment reference.
   * @see #setElseExpression(OclExpressionXS)
   * @see tudresden.ocl20.pivot.xocl.XOCLPackage#getIfExpXS_ElseExpression()
   * @model containment="true" required="true"
   * @generated
   */
  OclExpressionXS getElseExpression();

  /**
   * Sets the value of the '{@link tudresden.ocl20.pivot.xocl.IfExpXS#getElseExpression <em>Else Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Else Expression</em>' containment reference.
   * @see #getElseExpression()
   * @generated
   */
  void setElseExpression(OclExpressionXS value);

  /**
   * Returns the value of the '<em><b>Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Condition</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Condition</em>' containment reference.
   * @see #setCondition(OclExpressionXS)
   * @see tudresden.ocl20.pivot.xocl.XOCLPackage#getIfExpXS_Condition()
   * @model containment="true" required="true"
   * @generated
   */
  OclExpressionXS getCondition();

  /**
   * Sets the value of the '{@link tudresden.ocl20.pivot.xocl.IfExpXS#getCondition <em>Condition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Condition</em>' containment reference.
   * @see #getCondition()
   * @generated
   */
  void setCondition(OclExpressionXS value);

  /**
   * Returns the value of the '<em><b>Then Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Then Expression</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Then Expression</em>' containment reference.
   * @see #setThenExpression(OclExpressionXS)
   * @see tudresden.ocl20.pivot.xocl.XOCLPackage#getIfExpXS_ThenExpression()
   * @model containment="true" required="true"
   * @generated
   */
  OclExpressionXS getThenExpression();

  /**
   * Sets the value of the '{@link tudresden.ocl20.pivot.xocl.IfExpXS#getThenExpression <em>Then Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Then Expression</em>' containment reference.
   * @see #getThenExpression()
   * @generated
   */
  void setThenExpression(OclExpressionXS value);

} // IfExpXS
