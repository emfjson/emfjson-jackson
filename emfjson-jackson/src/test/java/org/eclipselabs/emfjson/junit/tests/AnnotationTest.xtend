package org.eclipselabs.emfjson.junit.tests

import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.IOException
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EcoreFactory
import org.eclipse.emf.ecore.EcorePackage
import org.eclipselabs.emfjson.EMFJs
import org.eclipselabs.emfjson.junit.support.TestSupport
import org.junit.Test

import static org.junit.Assert.*

class AnnotationTest extends TestSupport {

	override setUp() {
		super.setUp()
		options.put(EMFJs.OPTION_INDENT_OUTPUT, true)
	}

	@Test
	def testSaveAnnotation() throws IOException {
		val expectedString = '''
			{
			  "eClass" : "http://www.eclipse.org/emf/2002/Ecore#//EClass",
			  "name" : "Foo",
			  "eAnnotations" : [ {
			    "eClass" : "http://www.eclipse.org/emf/2002/Ecore#//EAnnotation",
			    "source" : "source",
			    "details" : {
			      "displayName" : "value"
			    }
			  } ]
			}'''

		val eClass = EcoreFactory.eINSTANCE.createEClass()
		eClass.setName("Foo")

		val eAnnotation = EcoreFactory.eINSTANCE.createEAnnotation()
		eAnnotation.setEModelElement(eClass)
		eAnnotation.setSource("source")
		eAnnotation.getDetails().put("displayName", "value")
		eClass.getEAnnotations().add(eAnnotation)

		val resource = resourceSet.createResource(URI.createURI("test.json"))
		resource.getContents().add(eClass)

		val outStream = new ByteArrayOutputStream()
		resource.save(outStream, options)

		assertEquals(expectedString, outStream.toString())
	}

	@Test
	def testLoadAnnotation() throws IOException {
		val inputString = '''
			{
			  "eClass" : "http://www.eclipse.org/emf/2002/Ecore#//EClass",
			  "name" : "Foo",
			  "eAnnotations" : [ {
			    "eClass" : "http://www.eclipse.org/emf/2002/Ecore#//EAnnotation",
			    "source" : "source",
			    "details" : {
			      "displayName" : "value"
			    }
			  } ]
			}'''

		val resource = resourceSet.createResource(URI.createURI("test.json"))
		resource.load(new ByteArrayInputStream(inputString.getBytes()), null)

		assertEquals(1, resource.getContents().size())

		val root = resource.getContents().get(0)

		assertEquals(EcorePackage.Literals.ECLASS, root.eClass())

		val annotations = (root as EClass).getEAnnotations()

		assertEquals(1, annotations.size())

		val annotation = annotations.get(0)
		assertEquals(1, annotation.getDetails().size())
		assertEquals("displayName", annotation.getDetails().get(0).getKey())
		assertEquals("value", annotation.getDetails().get(0).getValue())
	}

}