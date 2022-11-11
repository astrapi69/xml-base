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

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;

import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;

/**
 * The class {@link SchemaInitializer} provides method for initialize {@link Schema} objects
 */
public final class SchemaInitializer
{

	/** The Constant HTTP_WWW_W3_ORG_2001_XML_SCHEMA is a value for the schema language */
	private static final String HTTP_WWW_W3_ORG_2001_XML_SCHEMA = "http://www.w3.org/2001/XMLSchema";

	/**
	 * Factory method for create a new {@link Schema} object from the given {@link File} object and
	 * the given {@link ErrorHandler} object
	 *
	 * @param xsd
	 *            the xsd {@link File} object
	 * @param errorHandler
	 *            the {@link ErrorHandler} object
	 * @return the new {@link Schema} object from the given {@link File} object
	 * @throws SAXException
	 *             If a SAX error occurs during parsing
	 */
	public static Schema newSchema(final File xsd, final ErrorHandler errorHandler)
		throws SAXException
	{
		// Create a new instance for an XSD-aware SchemaFactory
		final SchemaFactory schemaFactory = SchemaFactory
			.newInstance(HTTP_WWW_W3_ORG_2001_XML_SCHEMA);

		// Set the ErrorHandler implementation.
		schemaFactory.setErrorHandler(errorHandler);

		// get the custom xsd schema that describes
		// the required format for my XML files.
		return schemaFactory.newSchema(xsd);
	}

	/**
	 * Factory method for create a new {@link Schema} object from the given {@link File} object
	 *
	 * @param xsd
	 *            the xsd {@link File} object
	 * @return the schema
	 * @throws SAXException
	 *             If a SAX error occurs during parsing
	 */
	public static Schema newSchema(final File xsd) throws SAXException
	{
		// Create a new instance for an XSD-aware SchemaFactory
		final SchemaFactory schemaFactory = SchemaFactory
			.newInstance(HTTP_WWW_W3_ORG_2001_XML_SCHEMA);
		// get the custom xsd schema that describes
		// the required format for my XML files.
		return schemaFactory.newSchema(xsd);
	}
}
