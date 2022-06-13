package io.github.astrapi69.xml.xpath;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathExpressionException;

import org.junit.jupiter.api.Test;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import io.github.astrapi69.file.search.PathFinder;

public class NodeExtensionsTest
{

	/**
	 * Test method for {@link NodeExtensions#toString(NodeList, int)}
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
		actual = NodeExtensions.toString(nodeList, 0);
		expected = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><Customer id=\"1\">\n"
			+ "\t\t<age>34</age>\n" + "\t\t<name>John</name>\n" + "\t\t<gender>Male</gender>\n"
			+ "\t\t<role>Cpp Developer</role>\n" + "\t</Customer>";
		assertEquals(expected, actual);
	}
}
