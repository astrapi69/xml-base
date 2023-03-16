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
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import javax.xml.XMLConstants;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

import io.github.astrapi69.xml.transform.TransformerFactoryInitializer;

/**
 * The class {@link DocumentExtensions} provides extension methods for {@link Document} objects
 */
public final class DocumentExtensions
{

	/**
	 * This method creates a new {@link String} object from the given {@link Document} object
	 *
	 * @param document
	 *            the {@link Document} object
	 * @return the new {@link String} object from the given {@link Document} object
	 * @throws TransformerException
	 *             is thrown if an error occurred with during the transformation process
	 */
	public static String toString(Document document) throws TransformerException
	{
		return toString(document, 4);
	}

	/**
	 * This method creates a new {@link String} object from the given {@link Document} object
	 *
	 * @param document
	 *            the {@link Document} object
	 * @param indent
	 *            the number for indent the xml {@link String} object
	 * @return the new {@link String} object from the given {@link Document} object
	 * @throws TransformerException
	 *             is thrown if an error occurred with during the transformation process
	 */
	public static String toString(Document document, int indent) throws TransformerException
	{
		Map<String, Object> attributes;
		Map<String, String> outputProperties;

		attributes = new HashMap<>();
		outputProperties = new HashMap<>();
		attributes.put("indent-number", indent);
		attributes.put(XMLConstants.ACCESS_EXTERNAL_DTD, "");
		attributes.put(XMLConstants.ACCESS_EXTERNAL_STYLESHEET, "");
		outputProperties.put(OutputKeys.INDENT, "yes");
		Transformer transformer = TransformerFactoryInitializer.newTransformer(attributes,
			outputProperties);
		DOMSource domSource = DocumentBuilderFactoryInitializer.newDOMSource(document);
		StringWriter writer = new StringWriter();
		StreamResult streamResult = new StreamResult(writer);
		transformer.transform(domSource, streamResult);
		return writer.toString();
	}

	/**
	 * This method creates transfers the given {@link Document} object to the given {@link File}
	 * object
	 *
	 * @param document
	 *            the {@link Document} object
	 * @param xmlFile
	 *            the xml {@link File} object
	 * @throws TransformerException
	 *             is thrown if an error occurred with during the transformation process
	 */
	public static void toFile(Document document, File xmlFile)
		throws TransformerException, IOException
	{
		Map<String, Object> attributes;
		Map<String, String> outputProperties;
		int indent;

		attributes = new HashMap<>();
		outputProperties = new HashMap<>();
		indent = 4;
		attributes.put("indent-number", indent);
		attributes.put(XMLConstants.ACCESS_EXTERNAL_DTD, "");
		attributes.put(XMLConstants.ACCESS_EXTERNAL_STYLESHEET, "");
		outputProperties.put(OutputKeys.INDENT, "yes");
		Transformer transformer = TransformerFactoryInitializer.newTransformer(attributes,
			outputProperties);
		DOMSource domSource = DocumentBuilderFactoryInitializer.newDOMSource(document);
		Writer writer = new FileWriter(xmlFile);
		StreamResult streamResult = new StreamResult(writer);
		transformer.transform(domSource, streamResult);
	}

	/**
	 * This method creates a new {@link String} object from the given {@link Document} object
	 *
	 * @param document
	 *            the {@link Document} object
	 * @param prettyPrint
	 *            if this flag is true the output is pretty printed
	 * @return the new {@link String} object from the given {@link Document} object
	 * @throws TransformerException
	 *             is thrown if an error occurred with during the transformation process
	 */
	public static String toString(Document document, boolean prettyPrint)
		throws TransformerException
	{
		if (prettyPrint)
		{
			return toString(document);
		}
		Transformer transformer = TransformerFactoryInitializer.newTransformer();
		StringWriter writer = new StringWriter();
		transformer.transform(new DOMSource(document), new StreamResult(writer));
		return writer.toString();
	}

}
