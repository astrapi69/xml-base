/**
 * The MIT License
 * <p>
 * Copyright (C) 2021 Asterios Raptis
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package io.github.astrapi69.xml.sax.handler;

import io.github.astrapi69.throwable.RuntimeExceptionDecorator;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.Writer;
import java.util.Objects;

/**
 * The abstract class {@link WriterHandler}.
 */
public abstract class WriterHandler extends DefaultHandler
{

	/** The writer. */
	private final Writer writer;
	/** The string builder. */
	private StringBuilder stringBuilder;

	/**
	 * Instantiates a new {@link WriterHandler} object with the given {@link Writer}
	 *
	 * @param writer
	 *            the writer
	 */
	public WriterHandler(final Writer writer)
	{
		Objects.requireNonNull(writer);
		this.writer = writer;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void characters(final char[] buf, final int offset, final int len) throws SAXException
	{
		final String string = new String(buf, offset, len);
		if (stringBuilder == null)
		{
			stringBuilder = new StringBuilder(string);
		}
		else
		{
			stringBuilder.append(string);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void endDocument() throws SAXException
	{
		insertNewLine();
		RuntimeExceptionDecorator.decorate(() -> {
			insertNewLine();
			writer.flush();
		});
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void endElement(final String namespaceURI, final String simpleName,
		final String qualifiedName) throws SAXException
	{
		writeToBuffer();
		write("</" + getName(simpleName, qualifiedName) + ">");
	}

	public Writer getWriter()
	{
		return writer;
	}

	/**
	 * Insert a new line to the writer
	 *
	 * @throws SAXException
	 *             any SAX exception, possibly wrapping another exception
	 */
	private void insertNewLine() throws SAXException
	{
		RuntimeExceptionDecorator
			.decorate(() -> writer.write(System.getProperty("line.separator")));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void startDocument() throws SAXException
	{
		write("<?xml version='1.0' encoding='UTF-8'?>");
		insertNewLine();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void startElement(final String namespaceURI, final String simpleName,
		final String qualifiedName, final Attributes attributes) throws SAXException
	{
		writeToBuffer();
		write("<" + getName(simpleName, qualifiedName));
		if (attributes != null)
		{
			for (int i = 0; i < attributes.getLength(); i++)
			{
				String attributeName = getName(attributes.getLocalName(i), attributes.getQName(i));
				write(" ");
				write(attributeName + "=\"" + attributes.getValue(i) + "\"");
			}
		}
		write(">");
	}

	/**
	 * Write the given {@link String} object
	 *
	 * @param string
	 *            the string
	 * @throws SAXException
	 *             any SAX exception, possibly wrapping another exception
	 */
	protected abstract void write(final String string) throws SAXException;

	/**
	 * Write to buffer.
	 *
	 * @throws SAXException
	 *             any SAX exception, possibly wrapping another exception
	 */
	private void writeToBuffer() throws SAXException
	{
		if (stringBuilder == null)
		{
			return;
		}
		final String string = stringBuilder.toString().trim();
		write(string);
		stringBuilder = null;
	}

	public String getName(String defaultName, String alternativeName)
	{
		if ("".equals(defaultName))
		{
			return alternativeName;
		}
		return defaultName;
	}
}
