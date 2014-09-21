package org.eclipselabs.emfjson.junit.tests

import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.math.BigDecimal
import java.math.BigInteger
import java.util.Date
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EcorePackage
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipselabs.emfjson.EMFJs
import org.eclipselabs.emfjson.junit.model.ETypes
import org.eclipselabs.emfjson.junit.model.ModelFactory
import org.eclipselabs.emfjson.junit.model.ModelPackage
import org.eclipselabs.emfjson.junit.support.TestSupport
import org.junit.Test

import static org.junit.Assert.*

class ValueTest extends TestSupport {

	override setUp() {
		super.setUp()
		options.put(EMFJs.OPTION_INDENT_OUTPUT, true)
	}

	@Test
	def testStringValues() throws IOException {
		val expectedString = 
			'''
			{
			  "eClass" : "http://www.eclipselabs.org/emfjson/junit#//ETypes",
			  "eString" : "Hello",
			  "eStrings" : [ "Hello", "World" ]
			}'''

		val resource = resourceSet.createResource(URI.createURI("tests/test.json"))
		val valueObject = ModelFactory.eINSTANCE.createETypes()
		valueObject.setEString("Hello")

		val arrayValue = #{ "Hello", "World" }
		valueObject.getEStrings().addAll(arrayValue)

		resource.getContents().add(valueObject)

		val outStream = new ByteArrayOutputStream()
		resource.save(outStream, options)

		assertEquals(expectedString, new String(outStream.toByteArray()))
	}

	@Test
	def testIntValues() throws IOException {
		val expectedString = 
			'''
			  {
			    "eClass" : "http://www.eclipselabs.org/emfjson/junit#//ETypes",
			    "eInt" : 1,
			    "eInts" : [ 1, 2 ]
			  }'''

		val resource = resourceSet.createResource(URI.createURI("tests/test.json"))

		val valueObject = ModelFactory.eINSTANCE.createETypes()
		valueObject.setEInt(1)

		val arrayValue = #{ 1, 2 }
		valueObject.getEInts().addAll(arrayValue)
		resource.getContents().add(valueObject)

		val outStream = new ByteArrayOutputStream()
		resource.save(outStream, options)

		assertEquals(expectedString, new String(outStream.toByteArray()))
	}

	@Test
	def testLoadIntValues() throws IOException {
		val inputString = '''
		  {
		  	"eClass" : "http://www.eclipselabs.org/emfjson/junit#//ETypes",
		  	"eInt" : 1,
		  	"eInts" : [ 1, 2 ]
		  }'''

		val resource = resourceSet.createResource(URI.createURI("tests/test.json"))
		resource.load(new ByteArrayInputStream(inputString.getBytes()), null)

		assertEquals(1, resource.getContents().size())

		val root = resource.getContents().get(0)
		assertEquals(ModelPackage.Literals.ETYPES, root.eClass())

		val ints = (root as ETypes).getEInts()
		assertEquals(2, ints.size())
		assertTrue(1 == ints.get(0))
		assertTrue(2 == ints.get(1))
	}

	@Test
	def testBooleanValues() throws IOException {
		val expectedString = '''
			{
			  "eClass" : "http://www.eclipselabs.org/emfjson/junit#//ETypes",
			  "eBoolean" : true,
			  "eBooleans" : [ false, true ]
			}'''

		val resource = resourceSet.createResource(URI.createURI("tests/test.json"))

		val valueObject = ModelFactory.eINSTANCE.createETypes()
		valueObject.setEBoolean(true)

		val arrayValue = #{ false, true }
		valueObject.getEBooleans().addAll(arrayValue)

		resource.getContents().add(valueObject)

		val outStream = new ByteArrayOutputStream()
		resource.save(outStream, options)

		assertEquals(expectedString, new String(outStream.toByteArray()))
	}

	@Test
	def testDateValue() throws IOException {
		val expectedString = '''
			{
			  "eClass" : "http://www.eclipselabs.org/emfjson/junit#//ETypes",
			  "eDate" : "2011-10-10T00:00:00"
			}'''

		val resource = resourceSet.createResource(URI.createURI("tests/test.json"))
		val valueObject = ModelFactory.eINSTANCE.createETypes()
		val value = EcoreUtil.createFromString(EcorePackage.eINSTANCE.getEDate(), "2011-10-10") as Date
		valueObject.setEDate(value)

		resource.getContents().add(valueObject)

		val outStream = new ByteArrayOutputStream()
		resource.save(outStream, options)

		assertEquals(expectedString, new String(outStream.toByteArray()))
	}

	@Test
	def testBigIntegerValue() throws IOException {
		val expectedString = '''
			{
			  "eClass" : "http://www.eclipselabs.org/emfjson/junit#//ETypes",
			  "eBigInteger" : "15"
			}'''

		val resource = resourceSet.createResource(URI.createURI("tests/test.json"))

		val valueObject = ModelFactory.eINSTANCE.createETypes()
		valueObject.setEBigInteger(new BigInteger("15"))
		resource.getContents().add(valueObject)

		val outStream = new ByteArrayOutputStream()
		resource.save(outStream, options)

		assertEquals(expectedString, new String(outStream.toByteArray()))
	}

	@Test
	def testLoadBigIntegerValue() throws IOException {
		val inputString = '''
			{
			  "eClass" : "http://www.eclipselabs.org/emfjson/junit#//ETypes",
			  "eBigInteger" : "15"
			}'''

		val resource = resourceSet.createResource(URI.createURI("tests/test.json"))
		resource.load(new ByteArrayInputStream(inputString.getBytes()), null)

		assertEquals(1, resource.getContents().size())

		val root = resource.getContents().get(0)
		assertEquals(ModelPackage.Literals.ETYPES, root.eClass())

		val value = (root as ETypes).getEBigInteger()

		assertEquals(new BigInteger("15"), value)
	}

	@Test
	def testByteValue() throws IOException {
		val expectedString = '''
			{
			  "eClass" : "http://www.eclipselabs.org/emfjson/junit#//ETypes",
			  "eByte" : "1"
			}'''

		val resource = resourceSet.createResource(URI.createURI("tests/test.json"))

		val valueObject = ModelFactory.eINSTANCE.createETypes()
		val b = 1 as byte
		valueObject.setEByte(b)
		resource.getContents().add(valueObject)

		val outStream = new ByteArrayOutputStream()
		resource.save(outStream, options)

		assertEquals(expectedString, new String(outStream.toByteArray()))
	}

	@Test
	def testBigDecimalValue() throws IOException {
		val expectedString = '''
			{
			  "eClass" : "http://www.eclipselabs.org/emfjson/junit#//ETypes",
			  "eBigDecimal" : "1.5"
			}'''

		val resource = resourceSet.createResource(URI.createURI("tests/test.json"))

		val valueObject = ModelFactory.eINSTANCE.createETypes()
		valueObject.setEBigDecimal(new BigDecimal(1.5))
		resource.getContents().add(valueObject)

		val outStream = new ByteArrayOutputStream();
		resource.save(outStream, options);

		assertEquals(expectedString, new String(outStream.toByteArray()));
	}

	@Test
	def testLoadBigDecimalValue() throws IOException {
		val inputString = '''
			{
			  "eClass" : "http://www.eclipselabs.org/emfjson/junit#//ETypes",
			  "eBigDecimal" : 1.5
			}'''

		val resource = resourceSet.createResource(URI.createURI("tests/test.json"))
		resource.load(new ByteArrayInputStream(inputString.getBytes()), null)

		assertEquals(1, resource.getContents().size())

		val root = resource.getContents().get(0)
		assertEquals(ModelPackage.Literals.ETYPES, root.eClass())

		val value = (root as ETypes).getEBigDecimal()

		assertEquals(new BigDecimal(1.5), value)
	}

}