/**
 * The MIT License
 *
 * Copyright (C) 2021 Asterios Raptis
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package io.github.astrapi69.xml.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import io.github.astrapi69.file.delete.DeleteFileExtensions;
import io.github.astrapi69.file.read.ReadFileExtensions;
import io.github.astrapi69.file.search.PathFinder;

/**
 * The unit test class for the class {@link DocumentExtensions}
 */
public class DocumentExtensionsTest
{

	/**
	 * Test method for {@link DocumentExtensions#toFile(Document, File)}
	 *
	 * @throws ParserConfigurationException
	 *             the parser configuration exception
	 * @throws SAXException
	 *             If a SAX error occurs during parsing
	 * @throws IOException
	 *             Signals that an I/O exception has occurred
	 * @throws TransformerException
	 *             is thrown if an error occurred with during the transformation process
	 */
	@Test
	public void testDocumentToFile()
		throws ParserConfigurationException, IOException, SAXException, TransformerException
	{

		String actual;
		String expected;
		File xmlFile;
		File xmlNewFile;
		xmlFile = PathFinder.getRelativePath(PathFinder.getSrcTestResourcesDir(), "test-xml.xml");
		xmlNewFile = PathFinder.getRelativePath(PathFinder.getSrcTestResourcesDir(),
			"test-new-xml.xml");
		final Document document = DocumentFactory.newDocument(xmlFile);

		DocumentExtensions.toFile(document, xmlNewFile);
		actual = ReadFileExtensions.readFromFile(xmlFile).replace("\r", "").replace("\n", "")
			.replace("\t", "").replace(" ", "").trim();
		expected = ReadFileExtensions.readFromFile(xmlNewFile).replace("\r", "").replace("\n", "")
			.replace("\t", "").replace(" ", "").trim();
		assertEquals(expected, actual);
		DeleteFileExtensions.delete(xmlNewFile);
	}

	/**
	 * Test method for {@link DocumentExtensions#toString(Document)}
	 *
	 * @throws ParserConfigurationException
	 *             the parser configuration exception
	 * @throws SAXException
	 *             If a SAX error occurs during parsing
	 * @throws IOException
	 *             Signals that an I/O exception has occurred
	 * @throws TransformerException
	 *             is thrown if an error occurred with during the transformation process
	 */
	@Test
	public void testDocumentToString()
		throws ParserConfigurationException, IOException, SAXException, TransformerException
	{
		String actual;
		String expected;

		File xmlFile;
		xmlFile = PathFinder.getRelativePath(PathFinder.getSrcTestResourcesDir(), "test-xml.xml");
		final Document document = DocumentFactory.newDocument(xmlFile);
		actual = DocumentExtensions.toString(document).replace("\r", "").replace("\n", "")
			.replace("\t", "").replace(" ", "").trim();
		expected = ReadFileExtensions.readFromFile(xmlFile).replace("\r", "").replace("\n", "")
			.replace("\t", "").replace(" ", "").trim();
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link DocumentExtensions#toString(Document, boolean)}
	 *
	 * @throws ParserConfigurationException
	 *             the parser configuration exception
	 * @throws SAXException
	 *             If a SAX error occurs during parsing
	 * @throws IOException
	 *             Signals that an I/O exception has occurred
	 * @throws TransformerException
	 *             is thrown if an error occurred with during the transformation process
	 */
	@Test
	public void testDocumentToStringPrettyPrint()
		throws ParserConfigurationException, IOException, SAXException, TransformerException
	{
		String actual;
		String expected;

		File xmlFile;
		xmlFile = PathFinder.getRelativePath(PathFinder.getSrcTestResourcesDir(), "test-xml.xml");
		final Document document = DocumentFactory.newDocument(xmlFile);
		actual = DocumentExtensions.toString(document, true);
		expected = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n"
			+ "<Customers>\n" + "    \t\n" + "    <Customer id=\"1\">\n" + "        \t\t\n"
			+ "        <age>34</age>\n" + "        \t\t\n" + "        <name>John</name>\n"
			+ "        \t\t\n" + "        <gender>Male</gender>\n" + "        \t\t\n"
			+ "        <role>Cpp Developer</role>\n" + "        \t\n" + "    </Customer>\n"
			+ "    \t\n" + "    <Customer id=\"2\">\n" + "        \t\t\n"
			+ "        <age>32</age>\n" + "        \t\t\n" + "        <name>Nelly</name>\n"
			+ "        \t\t\n" + "        <gender>Female</gender>\n" + "        \t\t\n"
			+ "        <role>CEO</role>\n" + "        \t\n" + "    </Customer>\n" + "    \t\n"
			+ "    <Customer id=\"3\">\n" + "        \t\t\n" + "        <age>20</age>\n"
			+ "        \t\t\n" + "        <name>Jim</name>\n" + "        \t\t\n"
			+ "        <gender>Male</gender>\n" + "        \t\t\n"
			+ "        <role>Manager</role>\n" + "        \t\n" + "    </Customer>\n" + "    \t\n"
			+ "    <Customer id=\"4\">\n" + "        \t\t\n" + "        <age>28</age>\n"
			+ "        \t\t\n" + "        <name>Tanja</name>\n" + "        \t\t\n"
			+ "        <gender>Female</gender>\n" + "        \t\t\n"
			+ "        <role>Manager</role>\n" + "        \t\n" + "    </Customer>\n" + "    \n"
			+ "</Customers>\n";
		actual = actual.replace("\r", "").replace("\n", "").replace("\t", "").replace(" ", "")
			.trim();
		expected = expected.replace("\r", "").replace("\n", "").replace("\t", "").replace(" ", "")
			.trim();
		assertEquals(expected, actual);

		actual = DocumentExtensions.toString(document, false);
		expected = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><Customers>\n"
			+ "\t<Customer id=\"1\">\n" + "\t\t<age>34</age>\n" + "\t\t<name>John</name>\n"
			+ "\t\t<gender>Male</gender>\n" + "\t\t<role>Cpp Developer</role>\n" + "\t</Customer>\n"
			+ "\t<Customer id=\"2\">\n" + "\t\t<age>32</age>\n" + "\t\t<name>Nelly</name>\n"
			+ "\t\t<gender>Female</gender>\n" + "\t\t<role>CEO</role>\n" + "\t</Customer>\n"
			+ "\t<Customer id=\"3\">\n" + "\t\t<age>20</age>\n" + "\t\t<name>Jim</name>\n"
			+ "\t\t<gender>Male</gender>\n" + "\t\t<role>Manager</role>\n" + "\t</Customer>\n"
			+ "\t<Customer id=\"4\">\n" + "\t\t<age>28</age>\n" + "\t\t<name>Tanja</name>\n"
			+ "\t\t<gender>Female</gender>\n" + "\t\t<role>Manager</role>\n" + "\t</Customer>\n"
			+ "</Customers>";
		actual = actual.replace("\r", "").replace("\n", "").replace("\t", "").replace(" ", "")
			.trim();
		expected = expected.replace("\r", "").replace("\n", "").replace("\t", "").replace(" ", "")
			.trim();
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link DocumentExtensions}
	 */
	@Test
	public void testWithBeanTester()
	{
		final BeanTester beanTester = new BeanTester();
		beanTester.testBean(DocumentExtensions.class);
	}

}
