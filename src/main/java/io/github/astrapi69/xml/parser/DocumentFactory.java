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

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;

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
		return newDocument(new InputSource(new StringReader(xml)));
	}

	/**
	 * Factory method for create a new {@link Document} object from the given xml as
	 * {@link InputSource} object
	 *
	 * @param inputSource
	 *            the xml as {@link InputSource} object
	 * @return the new {@link Document} object from the given xml as {@link String} object
	 * @throws ParserConfigurationException
	 *             the parser configuration exception
	 * @throws SAXException
	 *             is thrown if a sax parse error occurs
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public static Document newDocument(InputSource inputSource)
		throws ParserConfigurationException, SAXException, IOException
	{
		return DocumentBuilderFactoryInitializer.newDocumentBuilder().parse(inputSource);
	}

	/**
	 * Factory method for create a new {@link Document} object
	 *
	 * @return the new {@link Document} object
	 * @throws ParserConfigurationException
	 *             the parser configuration exception
	 */
	public static Document newDocument() throws ParserConfigurationException
	{
		return DocumentBuilderFactoryInitializer.newDocumentBuilder().newDocument();
	}
}
