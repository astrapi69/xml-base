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
package io.github.astrapi69.xml.transform;

import java.io.File;
import java.util.Map;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamSource;

/**
 * The class {@link TransformerFactoryInitializer} provides method for initialize
 * {@link TransformerFactory} and {@link Transformer} objects
 */
public final class TransformerFactoryInitializer
{
	private TransformerFactoryInitializer()
	{
	}

	/**
	 * Factory method for create a new {@link TransformerFactory} object
	 *
	 * @return the new {@link TransformerFactory} object
	 */
	public static TransformerFactory newTransformerFactory()
	{
		return TransformerFactory.newInstance();
	}

	/**
	 * Factory method for create a new {@link TransformerFactory} object with the given attributes
	 * 
	 * @param attributes
	 *            the attributes for the {@link TransformerFactory} object
	 *
	 * @return the new {@link TransformerFactory} object
	 */
	public static TransformerFactory newTransformerFactory(final Map<String, Object> attributes)
	{
		TransformerFactory transformerFactory = newTransformerFactory();
		for (Map.Entry<String, Object> entry : attributes.entrySet())
		{
			transformerFactory.setAttribute(entry.getKey(), entry.getValue());
		}
		return transformerFactory;
	}

	/**
	 * Factory method for create a new {@link Transformer} object
	 *
	 * @return the new {@link Transformer} object
	 * @throws TransformerConfigurationException
	 *             is thrown if there are errors when parsing the <code>Source</code> or it is not
	 *             possible to create a <code>Transformer</code> instance.
	 */
	public static Transformer newTransformer() throws TransformerConfigurationException
	{
		return newTransformerFactory().newTransformer();
	}

	/**
	 * Factory method for create a new {@link Transformer} object
	 *
	 * @param attributes
	 *            the attributes for the {@link TransformerFactory} object
	 * @return the new {@link Transformer} object
	 * @throws TransformerConfigurationException
	 *             is thrown if there are errors when parsing the <code>Source</code> or it is not
	 *             possible to create a <code>Transformer</code> instance.
	 */
	public static Transformer newTransformer(final Map<String, Object> attributes)
		throws TransformerConfigurationException
	{
		return newTransformerFactory(attributes).newTransformer();
	}

	/**
	 * Factory method for create a new {@link Transformer} object
	 *
	 * @param attributes
	 *            the attributes for the {@link TransformerFactory} object
	 * @param outputProperties
	 *            the output properties for the {@link Transformer} object
	 * @return the new {@link Transformer} object
	 * @throws TransformerConfigurationException
	 *             is thrown if there are errors when parsing the <code>Source</code> or it is not
	 *             possible to create a <code>Transformer</code> instance.
	 */
	public static Transformer newTransformer(final Map<String, Object> attributes,
		final Map<String, String> outputProperties) throws TransformerConfigurationException
	{
		Transformer transformer = newTransformerFactory(attributes).newTransformer();
		for (Map.Entry<String, String> entry : outputProperties.entrySet())
		{
			transformer.setOutputProperty(entry.getKey(), entry.getValue());
		}
		return transformer;
	}

	/**
	 * Factory method for create a new {@link Transformer} object from the given xslt {@link File}
	 * object
	 *
	 * @param xsltFile
	 *            the xslt file
	 * @return the new {@link Transformer} object
	 * @throws TransformerConfigurationException
	 *             is thrown if there are errors when parsing the <code>Source</code> or it is not
	 *             possible to create a <code>Transformer</code> instance.
	 */
	public static Transformer newTransformer(final File xsltFile)
		throws TransformerConfigurationException
	{
		return newTransformer(new StreamSource(xsltFile));
	}

	/**
	 * Factory method for create a new {@link Transformer} object from the given xslt {@link Source}
	 * object
	 *
	 * @param xsltSource
	 *            the xslt {@link Source} object
	 * @return the new {@link Transformer} object
	 * @throws TransformerConfigurationException
	 *             is thrown if there are errors when parsing the <code>Source</code> or it is not
	 *             possible to create a <code>Transformer</code> instance.
	 */
	public static Transformer newTransformer(final Source xsltSource)
		throws TransformerConfigurationException
	{
		return newTransformerFactory().newTransformer(xsltSource);
	}

	/**
	 * Factory method for create a new {@link Transformer} object from the given xslt file as
	 * {@link String} object
	 *
	 * @param xsltInputFile
	 *            the xslt input file
	 * @return the new {@link Transformer} object
	 * @throws TransformerConfigurationException
	 *             is thrown if there are errors when parsing the <code>Source</code> or it is not
	 *             possible to create a <code>Transformer</code> instance.
	 */
	public static Transformer newTransformer(final String xsltInputFile)
		throws TransformerConfigurationException
	{
		return newTransformer(new File(xsltInputFile));
	}

}
