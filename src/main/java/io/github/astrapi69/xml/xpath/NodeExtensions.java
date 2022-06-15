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

import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import io.github.astrapi69.xml.parser.DocumentFactory;
import io.github.astrapi69.xml.transform.TransformerFactoryInitializer;

/**
 * The class {@link NodeExtensions} provides methods for convert NodeList objects to string objects
 */
public class NodeExtensions
{
	/**
	 * Resolves the node from the given index and returns it as {@link String} object
	 * 
	 * @param nodeList
	 *            the node list
	 * @param index
	 *            the index from the node
	 * @return the node from the given index and returns it as {@link String} object
	 * @throws TransformerException
	 *             is thrown if an unrecoverable error occurs during the course of the
	 *             transformation
	 */
	public static String toString(NodeList nodeList, int index) throws TransformerException
	{
		return toString(nodeList.item(index));
	}

	/**
	 * Returns the given {@link NodeList} object as {@link String} object
	 *
	 * @param nodeList
	 *            the node list
	 * @return the given {@link NodeList} object as {@link String} object
	 * @throws TransformerException
	 *             is thrown if an unrecoverable error occurs during the course of the
	 *             transformation
	 */
	public static String toString(NodeList nodeList) throws TransformerException
	{
		int length = nodeList.getLength();
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < length; i++)
		{
			Node item = nodeList.item(i);
			stringBuilder.append(toString(item));
		}
		return stringBuilder.toString();
	}

	/**
	 * Returns the content of the values from the given {@link NodeList} object as {@link List} of
	 * {@link String} objects
	 * 
	 * @param nodeList
	 *            the node list
	 * @return the content of the values from the given {@link NodeList} object as {@link List} of
	 *         {@link String} objects
	 */
	public static List<String> toValueList(NodeList nodeList)
	{
		int length = nodeList.getLength();
		List<String> result = new ArrayList<>(length);
		for (int i = 0; i < length; i++)
		{
			Node item = nodeList.item(i);
			String stringValue = toStringValue(item);
			result.add(stringValue);
		}
		return result;
	}

	/**
	 * Returns a xml representation as {@link String} object of the given {@link Node} object
	 * 
	 * @param node
	 *            the {@link Node} object
	 * @return a xml representation as {@link String} object of the given {@link Node} object
	 * @throws TransformerException
	 *             is thrown if an unrecoverable error occurs during the course of the
	 *             transformation
	 */
	public static String toString(Node node) throws TransformerException
	{
		StringWriter stringWriter = new StringWriter();
		Transformer transformer = TransformerFactoryInitializer.newTransformer();
		transformer.transform(new DOMSource(node), new StreamResult(stringWriter));
		return stringWriter.toString();
	}

	/**
	 * Returns the text content as {@link String} object of the given {@link Node} object
	 * 
	 * @param node
	 *            the {@link Node} object
	 * @return the text content as {@link String} object of the given {@link Node} object
	 */
	public static String toStringValue(Node node)
	{
		return node.getTextContent();
	}

	/**
	 * Returns a xml representation as {@link String} object of the given {@link Node} object
	 * 
	 * @param node
	 *            the {@link Node} object
	 * @param outputProperties
	 *            the output properties for the as {@link Transformer} object
	 * @return a xml representation as {@link String} object of the given {@link Node} object
	 * @throws TransformerException
	 *             is thrown if an unrecoverable error occurs during the course of the
	 *             transformation
	 */
	public static String toString(Node node, Map<String, String> outputProperties)
		throws TransformerException
	{
		StringWriter stringWriter = new StringWriter();
		Transformer transformer = TransformerFactoryInitializer.newTransformer(null,
			outputProperties);
		transformer.transform(new DOMSource(node), new StreamResult(stringWriter));
		return stringWriter.toString();
	}

	/**
	 * Creates a new {@link DOMResult} object from the given {@link String} object
	 * 
	 * @param xml
	 *            the xml as {@link String} object
	 * @return a new {@link DOMResult} object from the given {@link String} object
	 * @throws ParserConfigurationException
	 *             if a DocumentBuilder cannot be created which satisfies the configuration
	 *             requested.
	 * @throws TransformerException
	 *             is thrown if an unrecoverable error occurs during the course of the
	 *             transformation
	 */
	public static DOMResult toDOMResult(String xml)
		throws ParserConfigurationException, TransformerException
	{
		StreamSource streamSource = new StreamSource(new StringReader(xml));
		DOMResult domResult = new DOMResult(DocumentFactory.newDocument());
		Transformer transformer = TransformerFactoryInitializer.newTransformer(streamSource);
		transformer.transform(streamSource, domResult);
		return domResult;
	}

}
