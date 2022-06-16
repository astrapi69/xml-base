package io.github.astrapi69.xml.transform.dom;

import io.github.astrapi69.xml.xpath.NodeExtensions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.dom.DOMResult;
import javax.xml.xpath.XPathExpressionException;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DOMResultFactoryTest
{

	/**
	 * Test method for {@link DOMResultFactory#newDOMResult(String)}
	 *
	 * @throws ParserConfigurationException
	 *             if a DocumentBuilder cannot be created which satisfies the configuration
	 *             requested.
	 * @throws TransformerException
	 *             is thrown if an unrecoverable error occurs during the course of the
	 *             transformation
	 */
	@Test
	@Disabled
	public void testNewDOMResult() throws ParserConfigurationException, TransformerException
	{
		String xmlString;
		// TODO
		xmlString = "";

		DOMResult domResult = DOMResultFactory.newDOMResult(xmlString);
		assertNotNull(domResult);

	}
}
