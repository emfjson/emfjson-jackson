/*
 * Copyright (c) 2019 Guillaume Hillairet and others.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0, or the MIT License which is
 * available at https://opensource.org/licenses/MIT.
 *
 * SPDX-License-Identifier: EPL-2.0 OR MIT
 *
 */
package org.emfjson.jackson.bench;

import org.eclipse.emf.ecore.*;

import org.emfjson.jackson.junit.model.ConcreteTypeOne;
import org.emfjson.jackson.junit.model.Container;
import org.emfjson.jackson.junit.model.ModelFactory;
import org.emfjson.jackson.junit.model.Node;

public class Benchmarks {

	public static EObject first() {
		Container root = ModelFactory.eINSTANCE.createContainer();
		for (int i = 0; i < 100000; i++) {
			ConcreteTypeOne child = ModelFactory.eINSTANCE.createConcreteTypeOne();
			child.setName("Concrete" + i);
			root.getElements().add(child);
		}
		return root;
	}

	public static EObject second() {
		Node root = ModelFactory.eINSTANCE.createNode();

		for (int i = 0; i < 100; i++) {
			Node n1 = ModelFactory.eINSTANCE.createNode();
			n1.setLabel("first" + i);
			root.getChild().add(n1);

			for (int j = 0; j < 100; j++) {
				Node n2 = ModelFactory.eINSTANCE.createNode();
				n2.setLabel("second" + j);
				n1.getChild().add(n2);

				for (int k = 0; k < 100; k++) {
					Node n3 = ModelFactory.eINSTANCE.createNode();
					n3.setLabel("third" + k);
					n2.getChild().add(n3);
				}
			}
		}
		return root;
	}

	public static EObject third() {
		EPackage p = EcoreFactory.eINSTANCE.createEPackage();
		p.setName("p");
		for (int i = 0; i < 500; i++) {
			EClass ec = EcoreFactory.eINSTANCE.createEClass();
			ec.setName("ClassTest" + i);

			for (int j = 0; j < 30; j++) {
				EAttribute a = EcoreFactory.eINSTANCE.createEAttribute();
				a.setName("attr" + i + j);
				a.setEType(EcorePackage.Literals.ESTRING);
				ec.getEStructuralFeatures().add(a);
			}
			p.getEClassifiers().add(ec);
		}
		return p;
	}

}
