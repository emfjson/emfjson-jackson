/*
 * Copyright (c) 2015 Guillaume Hillairet.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Guillaume Hillairet - initial API and implementation
 *
 */
package org.emfjson.gwt.junit.model;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 * <p/>
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.emfjson.gwt.junit.model.Node#getLabel <em>Label</em>}</li>
 * <li>{@link org.emfjson.gwt.junit.model.Node#getTarget <em>Target</em>}</li>
 * <li>{@link org.emfjson.gwt.junit.model.Node#getSource <em>Source</em>}</li>
 * <li>{@link org.emfjson.gwt.junit.model.Node#getManyRef <em>Many Ref</em>}</li>
 * <li>{@link org.emfjson.gwt.junit.model.Node#getChild <em>Child</em>}</li>
 * <li>{@link org.emfjson.gwt.junit.model.Node#getUniqueChild <em>Unique Child</em>}</li>
 * </ul>
 * </p>
 *
 * @model
 * @generated
 * @see org.emfjson.gwt.junit.model.ModelPackage#getNode()
 */
public interface Node extends EObject {
	/**
	 * Returns the value of the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Label</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Label</em>' attribute.
	 * @model
	 * @generated
	 * @see #setLabel(String)
	 * @see org.emfjson.gwt.junit.model.ModelPackage#getNode_Label()
	 */
	String getLabel();

	/**
	 * Sets the value of the '{@link org.emfjson.gwt.junit.model.Node#getLabel <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value the new value of the '<em>Label</em>' attribute.
	 * @generated
	 * @see #getLabel()
	 */
	void setLabel(String value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.emfjson.gwt.junit.model.Node#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Target</em>' reference.
	 * @model opposite="source" resolveProxies="false"
	 * @generated
	 * @see #setTarget(Node)
	 * @see org.emfjson.gwt.junit.model.ModelPackage#getNode_Target()
	 * @see org.emfjson.gwt.junit.model.Node#getSource
	 */
	Node getTarget();

	/**
	 * Sets the value of the '{@link org.emfjson.gwt.junit.model.Node#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @generated
	 * @see #getTarget()
	 */
	void setTarget(Node value);

	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.emfjson.gwt.junit.model.Node#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Source</em>' reference.
	 * @model opposite="target" resolveProxies="false"
	 * @generated
	 * @see #setSource(Node)
	 * @see org.emfjson.gwt.junit.model.ModelPackage#getNode_Source()
	 * @see org.emfjson.gwt.junit.model.Node#getTarget
	 */
	Node getSource();

	/**
	 * Sets the value of the '{@link org.emfjson.gwt.junit.model.Node#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @generated
	 * @see #getSource()
	 */
	void setSource(Node value);

	/**
	 * Returns the value of the '<em><b>Many Ref</b></em>' reference list.
	 * The list contents are of type {@link org.emfjson.gwt.junit.model.Node}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Many Ref</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Many Ref</em>' reference list.
	 * @model resolveProxies="false"
	 * @generated
	 * @see org.emfjson.gwt.junit.model.ModelPackage#getNode_ManyRef()
	 */
	EList<Node> getManyRef();

	/**
	 * Returns the value of the '<em><b>Child</b></em>' containment reference list.
	 * The list contents are of type {@link org.emfjson.gwt.junit.model.Node}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Child</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Child</em>' containment reference list.
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 * @see org.emfjson.gwt.junit.model.ModelPackage#getNode_Child()
	 */
	EList<Node> getChild();

	/**
	 * Returns the value of the '<em><b>Unique Child</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unique Child</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Unique Child</em>' containment reference.
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 * @see #setUniqueChild(Node)
	 * @see org.emfjson.gwt.junit.model.ModelPackage#getNode_UniqueChild()
	 */
	Node getUniqueChild();

	/**
	 * Sets the value of the '{@link org.emfjson.gwt.junit.model.Node#getUniqueChild <em>Unique Child</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value the new value of the '<em>Unique Child</em>' containment reference.
	 * @generated
	 * @see #getUniqueChild()
	 */
	void setUniqueChild(Node value);

} // Node
