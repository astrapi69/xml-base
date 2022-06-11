package io.github.astrapi69.xml.parser;

import java.io.StringWriter;

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
	 * Factory method for create a new {@link String} object from the given {@link Document} object
	 *
	 * @param document
	 *            the {@link Document} object
	 * @return the new {@link String} object from the given {@link Document} object
	 * @throws TransformerException
	 *             is thrown if an error occurred with during the transformation process
	 */
	public static String toString(Document document) throws TransformerException
	{
		DOMSource domSource = DocumentBuilderFactoryInitializer.newDOMSource(document);
		StringWriter writer = new StringWriter();
		StreamResult streamResult = new StreamResult(writer);
		Transformer transformer = TransformerFactoryInitializer.newTransformer();
		transformer.transform(domSource, streamResult);
		return writer.toString();
	}

}
