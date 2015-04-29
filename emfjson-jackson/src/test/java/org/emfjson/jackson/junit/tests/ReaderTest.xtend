package org.emfjson.jackson.junit.tests

import java.io.ByteArrayInputStream
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EcorePackage
import org.emfjson.jackson.junit.model.ETypes
import org.emfjson.jackson.junit.model.ModelPackage
import org.emfjson.jackson.junit.support.TestSupport
import org.junit.Test

import static org.junit.Assert.*

class ReaderTest extends TestSupport {

	@Test
	def shouldReadObjectWhenEClassFieldIsNotFirst() {
		val data = '''
		  {
		  	"eInt" : 1,
		  	"eClass" : "http://www.eclipselabs.org/emfjson/junit#//ETypes",
		  	"eInts": [1, 2]
		  }'''

		  val resource = resourceSet.createResource(URI.createURI("tests/test.json"))
		  resource.load(new ByteArrayInputStream(data.getBytes()), null)

		  assertEquals(1, resource.getContents().size())

		  val result = resource.contents.get(0)

		  assertEquals(ModelPackage.Literals.ETYPES, result.eClass)
		  assertEquals(1, (result as ETypes).EInt)
		  assertEquals(2, (result as ETypes).EInts.size)
		  assertEquals(1, (result as ETypes).EInts.get(0))
		  assertEquals(2, (result as ETypes).EInts.get(1))
	}

	@Test
	def shouldReadObjectTreeWithEClassFieldNotFirst() {
		val data = '''
			{
				"name": "A",
				"eStructuralFeatures": [
				{
					"name": "foo",
					"eClass": "http://www.eclipse.org/emf/2002/Ecore#//EAttribute"
				},
				{
					"name": "bar",
					"eClass": "http://www.eclipse.org/emf/2002/Ecore#//EAttribute"
				} ],
				"eClass": "http://www.eclipse.org/emf/2002/Ecore#//EClass"
			}
		'''

		val resource = resourceSet.createResource(URI.createURI("tests/test.json"))
		resource.load(new ByteArrayInputStream(data.getBytes()), null)

		assertEquals(1, resource.getContents().size())

		val result = resource.contents.get(0)
		assertEquals(EcorePackage.Literals.ECLASS, result.eClass)
		assertEquals(2, (result as EClass).EStructuralFeatures.size)
		assertEquals(EcorePackage.Literals.EATTRIBUTE, (result as EClass).EStructuralFeatures.get(0).eClass)
		assertEquals(EcorePackage.Literals.EATTRIBUTE, (result as EClass).EStructuralFeatures.get(1).eClass)
	}

	@Test
	def shouldReadObjectTreeWithEClassFieldRandomPosition() {
		val data = '''
			{
				"eClass": "http://www.eclipse.org/emf/2002/Ecore#//EClass",
				"name": "A",
				"eStructuralFeatures": [
				{
					"name": "foo",
					"eClass": "http://www.eclipse.org/emf/2002/Ecore#//EAttribute"
				},
				{
					"eClass": "http://www.eclipse.org/emf/2002/Ecore#//EAttribute",
					"name": "bar"
				} ]
			}
		'''

		val resource = resourceSet.createResource(URI.createURI("tests/test.json"))
		resource.load(new ByteArrayInputStream(data.getBytes()), null)

		assertEquals(1, resource.getContents().size())

		val result = resource.contents.get(0)
		assertEquals(EcorePackage.Literals.ECLASS, result.eClass)
		assertEquals(2, (result as EClass).EStructuralFeatures.size)
		assertEquals(EcorePackage.Literals.EATTRIBUTE, (result as EClass).EStructuralFeatures.get(0).eClass)
		assertEquals(EcorePackage.Literals.EATTRIBUTE, (result as EClass).EStructuralFeatures.get(1).eClass)
	}

	@Test
	def shouldSkipAttributeFieldForWhichThereIsNoFeature() {
		val data = '''
			{
				"eClass": "http://www.eclipse.org/emf/2002/Ecore#//EClass",
				"name": "A",
				"some_unknown_feature": "some value"
			}
		'''

		val resource = resourceSet.createResource(URI.createURI("tests/test.json"))
		resource.load(new ByteArrayInputStream(data.getBytes()), null)

		assertEquals(1, resource.getContents().size())

		val result = resource.contents.get(0)
		assertEquals(EcorePackage.Literals.ECLASS, result.eClass)
	}

	@Test
	def shouldSkipObjectFieldForWhichThereIsNoFeature() {
		val data = '''
			{
				"eClass": "http://www.eclipse.org/emf/2002/Ecore#//EClass",
				"name": "A",
				"some_unknown_feature":
				{
					"name": "foo",
					"eClass": "http://www.eclipse.org/emf/2002/Ecore#//EAttribute"
				}
			}
		'''

		val resource = resourceSet.createResource(URI.createURI("tests/test.json"))
		resource.load(new ByteArrayInputStream(data.getBytes()), null)

		assertEquals(1, resource.getContents().size())

		val result = resource.contents.get(0)
		assertEquals(EcorePackage.Literals.ECLASS, result.eClass)
	}

	@Test
	def shouldSkipArrayFieldForWhichThereIsNoFeature() {
		val data = '''
			{
				"eClass": "http://www.eclipse.org/emf/2002/Ecore#//EClass",
				"name": "A",
				"some_unknown_feature": [
				{
					"name": "foo",
					"eClass": "http://www.eclipse.org/emf/2002/Ecore#//EAttribute"
				} ]
			}
		'''

		val resource = resourceSet.createResource(URI.createURI("tests/test.json"))
		resource.load(new ByteArrayInputStream(data.getBytes()), null)

		assertEquals(1, resource.getContents().size())

		val result = resource.contents.get(0)
		assertEquals(EcorePackage.Literals.ECLASS, result.eClass)
	}

}
