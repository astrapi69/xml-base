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
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathExpressionException;

import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import io.github.astrapi69.collections.list.ListFactory;
import io.github.astrapi69.file.read.ReadFileExtensions;
import io.github.astrapi69.file.search.PathFinder;

/**
 * The unit test class for the class {@link XPathExtensions}
 */
public class XPathExtensionsTest
{

	/**
	 * Test method for {@link XPathExtensions#getNodeList(File, String)}
	 *
	 * @throws XPathExpressionException
	 *             the x path expression exception
	 * @throws ParserConfigurationException
	 *             the parser configuration exception
	 * @throws SAXException
	 *             the sAX exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	@Test
	public void testGetNodeListFileString()
		throws XPathExpressionException, ParserConfigurationException, SAXException, IOException
	{
		NodeList actual;
		File xml;
		String xpathExpression;

		xml = PathFinder.getRelativePath(PathFinder.getSrcTestResourcesDir(), "test-xml.xml");
		xpathExpression = "/Customers/Customer[gender='Female']/name/text()";
		actual = XPathExtensions.getNodeList(xml, xpathExpression);
		assertNotNull(actual);
		assertEquals(actual.getLength(), 2);
	}

	/**
	 * Test method for {@link XPathExtensions#getNodeList(String, String)}
	 *
	 * @throws XPathExpressionException
	 *             the x path expression exception
	 * @throws ParserConfigurationException
	 *             the parser configuration exception
	 * @throws SAXException
	 *             the sAX exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	@Test
	public void testGetNodeListStringString() throws XPathExpressionException,
		ParserConfigurationException, SAXException, IOException, TransformerException
	{

		NodeList actual;
		File xml;
		String xpathExpression;
		String xmlString;
		List<String> actualList;
		List<String> expectedList;

		xml = PathFinder.getRelativePath(PathFinder.getSrcTestResourcesDir(), "test-xml.xml");
		xpathExpression = "/Customers/Customer[gender='Female']/name/text()";
		xmlString = ReadFileExtensions.readFromFile(xml);
		actual = XPathExtensions.getNodeList(xmlString, xpathExpression);
		assertNotNull(actual);
		assertEquals(actual.getLength(), 2);

		xmlString = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + "<List>\n" + "\t<Order>\n"
			+ "\t\t<Id>44</Id>\n" + "\t\t<Id>6</Id>\n" + "\t\t<Id>7</Id>\n" + "\t\t<Id>5</Id>\n"
			+ "\t</Order>\n" + "</List>";
		actual = XPathExtensions.getNodeList(xmlString, "/List/Order/Id");
		assertNotNull(actual);
		assertEquals(actual.getLength(), 4);
		actualList = NodeExtensions.getTextContentValues(actual);
		expectedList = ListFactory.newArrayList("44", "6", "7", "5");
		assertEquals(actualList, expectedList);
	}

	/**
	 * Test method for {@link XPathExtensions}
	 */
	@Test
	public void testWithBeanTester()
	{
		final BeanTester beanTester = new BeanTester();
		beanTester.testBean(XPathExtensions.class);
	}

}
