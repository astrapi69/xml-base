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

	public static String toString(NodeList nodeList, int index) throws TransformerException
	{
		return toString(nodeList.item(index));
	}

	public static String toString(Node node) throws TransformerException
	{
		StringWriter stringWriter = new StringWriter();
		Transformer transformer = TransformerFactoryInitializer.newTransformer();
		transformer.transform(new DOMSource(node), new StreamResult(stringWriter));
		return stringWriter.toString();
	}

	public static String toString(Node node, Map<String, String> outputProperties)
		throws TransformerException
	{
		StringWriter stringWriter = new StringWriter();
		Transformer transformer = TransformerFactoryInitializer.newTransformer(null,
			outputProperties);
		transformer.transform(new DOMSource(node), new StreamResult(stringWriter));
		return stringWriter.toString();
	}

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
