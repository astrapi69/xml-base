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
