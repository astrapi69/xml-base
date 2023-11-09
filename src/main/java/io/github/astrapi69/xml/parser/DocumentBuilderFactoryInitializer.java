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

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.dom.DOMSource;

import org.w3c.dom.Document;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;

/**
 * The class {@link DocumentBuilderFactoryInitializer} provides method for initialize
 * {@link DocumentBuilderFactory}, {@link DocumentBuilder} and {@link DOMSource} objects
 */
public final class DocumentBuilderFactoryInitializer
{

	/** The Constant DOCUMENT_BUILDER_FACTORY_KEY. */
	private static final String DOCUMENT_BUILDER_FACTORY_KEY = "javax.xml.parsers.DocumentBuilderFactory";

	/** The Constant SAX_PARSER_FACTORY_XERCES_VALUE. */
	private static final String XERCES_SAX_PARSER_FACTORY_VALUE = "org.apache.xerces.jaxp.SAXParserFactoryImpl";

	/** The Constant XALAN_TRANSFORMER_FACTORY_VALUE. */
	private static final String XALAN_TRANSFORMER_FACTORY_VALUE = "org.apache.xalan.processor.TransformerFactoryImpl";

	/** The Constant XERCES_DOCUMENT_BUILDER_FACTORY_VALUE. */
	private static final String XERCES_DOCUMENT_BUILDER_FACTORY_VALUE = "org.apache.xerces.jaxp.DocumentBuilderFactoryImpl";

	/** The Constant DOCUMENT_BUILDER_FACTORY_VALUE. */
	private static final String DOCUMENT_BUILDER_FACTORY_VALUE = "org.apache.xerces.jaxp.DocumentBuilderFactoryImpl";

	/** The Constant HTTP_WWW_W3_ORG_2001_XML_SCHEMA. */
	private static final String HTTP_WWW_W3_ORG_2001_XML_SCHEMA = "http://www.w3.org/2001/XMLSchema";

	/** The Constant SCHEMA_LANGUAGE_KEY. */
	private static final String SCHEMA_LANGUAGE_KEY = "http://java.sun.com/xml/jaxp/properties/schemaLanguage";

	/** The Constant SCHEMA_SOURCE_KEY. */
	private static final String SCHEMA_SOURCE_KEY = "http://java.sun.com/xml/jaxp/properties/schemaSource";

	/**
	 * Factory method for create a new {@link DocumentBuilderFactory} object
	 *
	 * @param schema
	 *            the schema
	 * @param schemaLanguage
	 *            the schema language
	 * @param documentBuilderFactoryName
	 *            the name of the document builder factory
	 * @param namespaceAwareness
	 *            the flag if the namespace should be aware
	 * @param factoryValidating
	 *            the flag if the factory should validate
	 * @return the document builder factory
	 */
	public static DocumentBuilderFactory newDocumentBuilderFactory(final String schema,
		final String schemaLanguage, final String documentBuilderFactoryName,
		boolean namespaceAwareness, boolean factoryValidating)
	{
		if (documentBuilderFactoryName != null)
		{
			System.setProperty(DOCUMENT_BUILDER_FACTORY_KEY, documentBuilderFactoryName);
		}
		final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(namespaceAwareness);
		factory.setValidating(factoryValidating);

		if (schemaLanguage != null)
		{
			factory.setAttribute(SCHEMA_LANGUAGE_KEY, schemaLanguage);
		}
		if (schema != null)
		{
			factory.setAttribute(SCHEMA_SOURCE_KEY, schema);
		}
		return factory;
	}

	/**
	 * Factory method for create a new {@link DocumentBuilderFactory} object
	 *
	 * @param schema
	 *            the schema
	 * @return the document builder factory
	 */
	public static DocumentBuilderFactory newDocumentBuilderFactory(final String schema)
	{
		return newDocumentBuilderFactory(schema, HTTP_WWW_W3_ORG_2001_XML_SCHEMA,
			DOCUMENT_BUILDER_FACTORY_VALUE, true, true);
	}

	/**
	 * Factory method for create a new {@link DocumentBuilder} object
	 *
	 * @param schema
	 *            the schema
	 * @throws ParserConfigurationException
	 *             if a DocumentBuilder cannot be created which satisfies the configuration
	 *             requested.
	 */
	public static DocumentBuilder newDocumentBuilder(final String schema)
		throws ParserConfigurationException
	{
		final DocumentBuilderFactory factory = DocumentBuilderFactoryInitializer
			.newDocumentBuilderFactory(schema);
		return factory.newDocumentBuilder();
	}

	/**
	 * Factory method for create a new {@link DocumentBuilder} object
	 *
	 * @throws ParserConfigurationException
	 *             if a DocumentBuilder cannot be created which satisfies the configuration
	 *             requested.
	 */
	public static DocumentBuilder newDocumentBuilder() throws ParserConfigurationException
	{
		return newDocumentBuilder(true);
	}

	/**
	 * Factory method for create a new {@link DocumentBuilder} object
	 *
	 * @param namespaceAware
	 *            the flag if the namespace should be considered
	 * @throws ParserConfigurationException
	 *             if a DocumentBuilder cannot be created which satisfies the configuration
	 *             requested.
	 */
	public static DocumentBuilder newDocumentBuilder(boolean namespaceAware) throws ParserConfigurationException
	{
		final DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		if(namespaceAware) {
			documentBuilderFactory.setNamespaceAware(true);
		}
		return documentBuilderFactory.newDocumentBuilder();
	}

	/**
	 * Parses the given xml {@link File} object and the given {@link ErrorHandler} object
	 *
	 * @param xml
	 *            the {@link File} object
	 * @param errorHandler
	 *            the {@link ErrorHandler} object
	 * @return the {@link Document} object from the given xml {@link File} object
	 * @throws SAXException
	 *             If a SAX error occurs during parsing.
	 * @throws ParserConfigurationException
	 *             if a DocumentBuilder cannot be created which satisfies the configuration
	 *             requested.
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public static Document parse(final File xml, final ErrorHandler errorHandler)
		throws SAXException, ParserConfigurationException, IOException
	{
		final DocumentBuilder builder = DocumentBuilderFactoryInitializer
			.newDocumentBuilder(xml.getName());
		if (errorHandler != null)
		{
			builder.setErrorHandler(errorHandler);
		}
		return builder.parse(xml);
	}

	/**
	 * Parses the given xml {@link File} object
	 *
	 * @param xml
	 *            the {@link File} object
	 * @return the {@link Document} object from the given xml {@link File} object
	 * @throws SAXException
	 *             If a SAX error occurs during parsing.
	 * @throws ParserConfigurationException
	 *             if a DocumentBuilder cannot be created which satisfies the configuration
	 *             requested.
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public static Document parse(final File xml)
		throws SAXException, ParserConfigurationException, IOException
	{
		return parse(xml, null);
	}

	/**
	 * Factory method for create a new {@link DOMSource} object with the given {@link File} object
	 * and the given {@link ErrorHandler} object
	 *
	 * @param xml
	 *            the xml {@link File} object
	 * @param errorHandler
	 *            the {@link ErrorHandler} object
	 * @return the new {@link DOMSource} object with the given {@link File} object
	 *
	 * @throws SAXException
	 *             If a SAX error occurs during parsing.
	 * @throws ParserConfigurationException
	 *             if a DocumentBuilder cannot be created which satisfies the configuration
	 *             requested.
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public static DOMSource newDOMSource(final File xml, final ErrorHandler errorHandler)
		throws SAXException, ParserConfigurationException, IOException
	{
		return newDOMSource(DocumentBuilderFactoryInitializer.parse(xml, errorHandler));
	}

	/**
	 * Factory method for create a new {@link DOMSource} object with the given {@link File} object
	 *
	 * @param xml
	 *            the xml {@link File} object
	 * @return the new {@link DOMSource} object with the given {@link File} object
	 *
	 * @throws SAXException
	 *             If a SAX error occurs during parsing.
	 * @throws ParserConfigurationException
	 *             if a DocumentBuilder cannot be created which satisfies the configuration
	 *             requested.
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public static DOMSource newDOMSource(final File xml)
		throws SAXException, ParserConfigurationException, IOException
	{
		return newDOMSource(DocumentBuilderFactoryInitializer.parse(xml));
	}

	/**
	 * Factory method for create a new {@link DOMSource} object with the given {@link Document}
	 * object
	 *
	 * @param document
	 *            the {@link Document} object
	 * @return the new {@link DOMSource} object with the given {@link Document} object
	 */
	public static DOMSource newDOMSource(final Document document)
	{
		return new DOMSource(document);
	}

}
