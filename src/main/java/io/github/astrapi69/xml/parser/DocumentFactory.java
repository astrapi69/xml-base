package io.github.astrapi69.xml.parser;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 * The factory class {@link DocumentFactory} provides factory methods for creating {@link Document}
 * objects
 */
public final class DocumentFactory
{

	/**
	 * Factory method for create a new {@link Document} object from the given xml {@link File}
	 * object
	 *
	 * @param xml
	 *            the xml file as string
	 * @return the new {@link Document} object from the given xml {@link File} object
	 * @throws ParserConfigurationException
	 *             the parser configuration exception
	 * @throws SAXException
	 *             is thrown if a sax parse error occurs
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public static Document newDocument(File xml)
		throws ParserConfigurationException, SAXException, IOException
	{
		return DocumentBuilderFactoryInitializer.newDocumentBuilder().parse(xml);
	}

	/**
	 * Factory method for create a new {@link Document} object from the given xml as {@link String}
	 * object
	 *
	 * @param xml
	 *            the xml as {@link String} object
	 * @return the new {@link Document} object from the given xml as {@link String} object
	 * @throws ParserConfigurationException
	 *             the parser configuration exception
	 * @throws SAXException
	 *             is thrown if a sax parse error occurs
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public static Document newDocument(String xml)
		throws ParserConfigurationException, SAXException, IOException
	{
		return DocumentBuilderFactoryInitializer.newDocumentBuilder().parse(xml);
	}
}
