package io.github.astrapi69.xml.transform.dom;

import java.io.StringReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.stream.StreamSource;

import io.github.astrapi69.xml.transform.TransformerFactoryInitializer;

/**
 * The factory class {@link DOMResultFactory} provides factory methods for creating
 * {@link DOMResult} objects
 */
public class DOMResultFactory
{

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
	public static DOMResult newDOMResult(String xml) throws TransformerException
	{
		StreamSource streamSource = new StreamSource(new StringReader(xml));
		DOMResult domResult = new DOMResult();
		Transformer transformer = TransformerFactoryInitializer.newTransformer(streamSource);
		transformer.transform(streamSource, domResult);
		return domResult;
	}

}
