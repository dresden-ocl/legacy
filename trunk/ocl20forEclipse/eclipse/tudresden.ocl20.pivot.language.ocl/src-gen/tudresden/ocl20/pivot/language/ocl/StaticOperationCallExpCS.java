/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package tudresden.ocl20.pivot.language.ocl;

import org.eclipse.emf.common.util.EList;

import tudresden.ocl20.pivot.pivotmodel.Operation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Static Operation Call Exp CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link tudresden.ocl20.pivot.language.ocl.StaticOperationCallExpCS#getTypeName <em>Type Name</em>}</li>
 *   <li>{@link tudresden.ocl20.pivot.language.ocl.StaticOperationCallExpCS#getOperationName <em>Operation Name</em>}</li>
 *   <li>{@link tudresden.ocl20.pivot.language.ocl.StaticOperationCallExpCS#getArguments <em>Arguments</em>}</li>
 * </ul>
 * </p>
 *
 * @see tudresden.ocl20.pivot.language.ocl.OclPackage#getStaticOperationCallExpCS()
 * @model
 * @generated
 */
public interface StaticOperationCallExpCS extends OperationCallExpCS {
	/**
	 * Returns the value of the '<em><b>Type Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type Name</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Name</em>' containment reference.
	 * @see #setTypeName(TypePathNameCS)
	 * @see tudresden.ocl20.pivot.language.ocl.OclPackage#getStaticOperationCallExpCS_TypeName()
	 * @model containment="true" required="true"
	 * @generated
	 */
	TypePathNameCS getTypeName();

	/**
	 * Sets the value of the '{@link tudresden.ocl20.pivot.language.ocl.StaticOperationCallExpCS#getTypeName <em>Type Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type Name</em>' containment reference.
	 * @see #getTypeName()
	 * @generated
	 */
	void setTypeName(TypePathNameCS value);

	/**
	 * Returns the value of the '<em><b>Operation Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operation Name</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation Name</em>' reference.
	 * @see #setOperationName(Operation)
	 * @see tudresden.ocl20.pivot.language.ocl.OclPackage#getStaticOperationCallExpCS_OperationName()
	 * @model required="true"
	 * @generated
	 */
	Operation getOperationName();

	/**
	 * Sets the value of the '{@link tudresden.ocl20.pivot.language.ocl.StaticOperationCallExpCS#getOperationName <em>Operation Name</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation Name</em>' reference.
	 * @see #getOperationName()
	 * @generated
	 */
	void setOperationName(Operation value);

	/**
	 * Returns the value of the '<em><b>Arguments</b></em>' containment reference list.
	 * The list contents are of type {@link tudresden.ocl20.pivot.language.ocl.OclExpressionCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Arguments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Arguments</em>' containment reference list.
	 * @see tudresden.ocl20.pivot.language.ocl.OclPackage#getStaticOperationCallExpCS_Arguments()
	 * @model containment="true"
	 * @generated
	 */
	EList<OclExpressionCS> getArguments();

} // StaticOperationCallExpCS
