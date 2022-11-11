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
package io.github.astrapi69.xml.transform.dom;

import io.github.astrapi69.xml.transform.TransformerFactoryInitializer;

import javax.xml.transform.TransformerException;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.stream.StreamSource;
import java.io.StringReader;

/**
 * The factory class {@link DOMResultFactory} provides factory methods for creating
 * {@link DOMResult} objects
 */
public class DOMResultFactory
{

	/**
	 * Creates a new {@link DOMResult} object from the given {@link String} object
	 *
	 * @param xmlString
	 *            the xmlString as {@link String} object
	 * @return a new {@link DOMResult} object from the given {@link String} object
	 * @throws TransformerException
	 *             is thrown if an unrecoverable error occurs during the course of the
	 *             transformation
	 */
	public static DOMResult newDOMResult(String xmlString) throws TransformerException
	{
		DOMResult domResult = new DOMResult();
		TransformerFactoryInitializer.newTransformer()
			.transform(new StreamSource(new StringReader(xmlString)), domResult);
		return domResult;
	}

}
