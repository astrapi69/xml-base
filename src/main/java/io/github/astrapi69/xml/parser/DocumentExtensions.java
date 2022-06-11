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

}
