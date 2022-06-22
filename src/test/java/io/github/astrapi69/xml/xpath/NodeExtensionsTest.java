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
package io.github.astrapi69.xml.xpath;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathExpressionException;

import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import io.github.astrapi69.collections.list.ListFactory;
import io.github.astrapi69.file.search.PathFinder;

/**
 * The unit test class for the class {@link NodeExtensions}
 */
public class NodeExtensionsTest
{

	/**
	 * Test method for {@link NodeExtensions#toXmlString(NodeList, int)}
	 *
	 * @throws XPathExpressionException
	 *             the x path expression exception
	 * @throws ParserConfigurationException
	 *             the parser configuration exception
	 * @throws SAXException
	 *             If a SAX error occurs during parsing
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	@Test
	public void testToStringNodeListIndex() throws XPathExpressionException,
		ParserConfigurationException, SAXException, IOException, TransformerException
	{
		String actual;
		String expected;
		NodeList nodeList;
		File xml;
		String xpathExpression;

		xml = PathFinder.getRelativePath(PathFinder.getSrcTestResourcesDir(), "test-xml.xml");
		xpathExpression = "/Customers/Customer";
		nodeList = XPathExtensions.getNodeList(xml, xpathExpression);
		actual = NodeExtensions.toXmlString(nodeList, 0);
		expected = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><Customer id=\"1\">\n"
			+ "\t\t<age>34</age>\n" + "\t\t<name>John</name>\n" + "\t\t<gender>Male</gender>\n"
			+ "\t\t<role>Cpp Developer</role>\n" + "\t</Customer>";
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link NodeExtensions#toXmlString(Node, Map)}
	 *
	 * @throws XPathExpressionException
	 *             the x path expression exception
	 * @throws ParserConfigurationException
	 *             the parser configuration exception
	 * @throws SAXException
	 *             If a SAX error occurs during parsing
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	@Test
	public void testNodeWithMapToXmlString() throws XPathExpressionException,
		ParserConfigurationException, SAXException, IOException, TransformerException
	{
		Map<String, String> outputProperties;
		String actual;
		String expected;
		NodeList nodeList;
		File xml;
		String xpathExpression;

		outputProperties = new HashMap<>();
		outputProperties.put(OutputKeys.INDENT, "yes");

		xml = PathFinder.getRelativePath(PathFinder.getSrcTestResourcesDir(), "company.xml");
		xpathExpression = "/Company";
		nodeList = XPathExtensions.getNodeList(xml, xpathExpression);
		Node item = nodeList.item(0);

		actual = NodeExtensions.toXmlString(item, outputProperties);
		expected = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><Company>\n" + "    \t\n"
			+ "    <Customers>\n" + "        \t\t\n" + "        <Customer id=\"1\">\n"
			+ "            \t\t\t\n" + "            <age>34</age>\n" + "            \t\t\t\n"
			+ "            <name>John</name>\n" + "            \t\t\t\n"
			+ "            <gender>Male</gender>\n" + "            \t\t\t\n"
			+ "            <role>Cpp Developer</role>\n" + "            \t\t\n"
			+ "        </Customer>\n" + "        \t\t\n" + "        <Customer id=\"2\">\n"
			+ "            \t\t\t\n" + "            <age>32</age>\n" + "            \t\t\t\n"
			+ "            <name>Nelly</name>\n" + "            \t\t\t\n"
			+ "            <gender>Female</gender>\n" + "            \t\t\t\n"
			+ "            <role>CEO</role>\n" + "            \t\t\n" + "        </Customer>\n"
			+ "        \t\t\n" + "        <Customer id=\"3\">\n" + "            \t\t\t\n"
			+ "            <age>20</age>\n" + "            \t\t\t\n"
			+ "            <name>Jim</name>\n" + "            \t\t\t\n"
			+ "            <gender>Male</gender>\n" + "            \t\t\t\n"
			+ "            <role>Manager</role>\n" + "            \t\t\n" + "        </Customer>\n"
			+ "        \t\t\n" + "        <Customer id=\"4\">\n" + "            \t\t\t\n"
			+ "            <age>28</age>\n" + "            \t\t\t\n"
			+ "            <name>Tanja</name>\n" + "            \t\t\t\n"
			+ "            <gender>Female</gender>\n" + "            \t\t\t\n"
			+ "            <role>Manager</role>\n" + "            \t\t\n" + "        </Customer>\n"
			+ "        \t\n" + "    </Customers>\n" + "    \n" + "</Company>\n";
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link NodeExtensions#toXmlString(NodeList)}
	 *
	 * @throws XPathExpressionException
	 *             the x path expression exception
	 * @throws ParserConfigurationException
	 *             the parser configuration exception
	 * @throws SAXException
	 *             If a SAX error occurs during parsing
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	@Test
	public void testNodeListToXmlString() throws XPathExpressionException,
		ParserConfigurationException, SAXException, IOException, TransformerException
	{
		String actual;
		String expected;
		NodeList nodeList;
		File xml;
		String xpathExpression;

		xml = PathFinder.getRelativePath(PathFinder.getSrcTestResourcesDir(), "test-xml.xml");
		xpathExpression = "/Customers/Customer";
		nodeList = XPathExtensions.getNodeList(xml, xpathExpression);
		actual = NodeExtensions.toXmlString(nodeList);
		expected = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><Customer id=\"1\">\n"
			+ "\t\t<age>34</age>\n" + "\t\t<name>John</name>\n" + "\t\t<gender>Male</gender>\n"
			+ "\t\t<role>Cpp Developer</role>\n"
			+ "\t</Customer><?xml version=\"1.0\" encoding=\"UTF-8\"?><Customer id=\"2\">\n"
			+ "\t\t<age>32</age>\n" + "\t\t<name>Nelly</name>\n" + "\t\t<gender>Female</gender>\n"
			+ "\t\t<role>CEO</role>\n"
			+ "\t</Customer><?xml version=\"1.0\" encoding=\"UTF-8\"?><Customer id=\"3\">\n"
			+ "\t\t<age>20</age>\n" + "\t\t<name>Jim</name>\n" + "\t\t<gender>Male</gender>\n"
			+ "\t\t<role>Manager</role>\n"
			+ "\t</Customer><?xml version=\"1.0\" encoding=\"UTF-8\"?><Customer id=\"4\">\n"
			+ "\t\t<age>28</age>\n" + "\t\t<name>Tanja</name>\n" + "\t\t<gender>Female</gender>\n"
			+ "\t\t<role>Manager</role>\n" + "\t</Customer>";
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link NodeExtensions#getTextContentValues(Node, String)}
	 *
	 * @throws XPathExpressionException
	 *             the x path expression exception
	 * @throws ParserConfigurationException
	 *             the parser configuration exception
	 * @throws SAXException
	 *             If a SAX error occurs during parsing
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	@Test
	public void testGetTextContentValues() throws XPathExpressionException,
		ParserConfigurationException, SAXException, IOException, TransformerException
	{
		List<String> actual;
		List<String> expected;
		NodeList nodeList;
		File xml;
		String xpathExpression;

		xml = PathFinder.getRelativePath(PathFinder.getSrcTestResourcesDir(), "company.xml");
		xpathExpression = "/Company";
		nodeList = XPathExtensions.getNodeList(xml, xpathExpression);
		Node item = nodeList.item(0);
		actual = NodeExtensions.getTextContentValues(item, "/Company/Customers/Customer/age");
		expected = ListFactory.newArrayList("34", "32", "20", "28");
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link NodeExtensions}
	 */
	@Test
	public void testWithBeanTester()
	{
		final BeanTester beanTester = new BeanTester();
		beanTester.testBean(NodeExtensions.class);
	}


}
