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

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.xml.XMLConstants;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamSource;

import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;

import io.github.astrapi69.file.search.PathFinder;

/**
 * The unit test class for the class {@link TransformerFactoryInitializer}
 */
public class TransformerFactoryInitializerTest
{

	/**
	 * Test method for {@link TransformerFactoryInitializer#newTransformer(Source)}
	 *
	 * @throws TransformerConfigurationException
	 *             is thrown if there are errors when parsing the <code>Source</code> or it is not
	 *             possible to create a <code>Transformer</code> instance.
	 */
	@Test
	public void testNewTransformer() throws TransformerConfigurationException
	{
		Transformer actual;

		actual = TransformerFactoryInitializer.newTransformer();
		assertNotNull(actual);
	}

	/**
	 * Test method for {@link TransformerFactoryInitializer#newTransformer(Map)}
	 *
	 * @throws TransformerConfigurationException
	 *             is thrown if there are errors when parsing the <code>Source</code> or it is not
	 *             possible to create a <code>Transformer</code> instance.
	 */
	@Test
	public void testNewTransformerMap() throws TransformerConfigurationException
	{
		Map<String, Object> attributes;
		int indent;
		Transformer actual;

		attributes = new HashMap<>();
		indent = 4;
		attributes.put("indent-number", indent);
		attributes.put(XMLConstants.ACCESS_EXTERNAL_DTD, "");
		attributes.put(XMLConstants.ACCESS_EXTERNAL_STYLESHEET, "");
		actual = TransformerFactoryInitializer.newTransformer(attributes);
		assertNotNull(actual);
	}

	/**
	 * Test method for {@link TransformerFactoryInitializer#newTransformer(Map, Map)}
	 *
	 * @throws TransformerConfigurationException
	 *             is thrown if there are errors when parsing the <code>Source</code> or it is not
	 *             possible to create a <code>Transformer</code> instance.
	 */
	@Test
	public void testNewTransformerMapMap() throws TransformerConfigurationException
	{
		Map<String, Object> attributes;
		Map<String, String> outputProperties;
		int indent;
		Transformer actual;

		attributes = new HashMap<>();
		outputProperties = new HashMap<>();
		indent = 4;
		attributes.put("indent-number", indent);
		attributes.put(XMLConstants.ACCESS_EXTERNAL_DTD, "");
		attributes.put(XMLConstants.ACCESS_EXTERNAL_STYLESHEET, "");
		outputProperties.put(OutputKeys.INDENT, "yes");
		actual = TransformerFactoryInitializer.newTransformer(attributes, outputProperties);
		assertNotNull(actual);
	}

	/**
	 * Test method for {@link TransformerFactoryInitializer#newTransformerFactory(Map)}
	 */
	@Test
	public void testNewTransformerFactoryMap()
	{
		Map<String, Object> attributes;
		int indent;
		TransformerFactory actual;

		attributes = new HashMap<>();
		indent = 4;
		attributes.put("indent-number", indent);
		attributes.put(XMLConstants.ACCESS_EXTERNAL_DTD, "");
		attributes.put(XMLConstants.ACCESS_EXTERNAL_STYLESHEET, "");
		actual = TransformerFactoryInitializer.newTransformerFactory(attributes);
		assertNotNull(actual);
		attributes.clear();
		actual = TransformerFactoryInitializer.newTransformerFactory(attributes);
		assertNotNull(actual);
		attributes = null;
		actual = TransformerFactoryInitializer.newTransformerFactory(attributes);
		assertNotNull(actual);
	}

	/**
	 * Test method for {@link TransformerFactoryInitializer#newTransformer(Source)}
	 *
	 * @throws TransformerConfigurationException
	 *             is thrown if there are errors when parsing the <code>Source</code> or it is not
	 *             possible to create a <code>Transformer</code> instance.
	 */
	@Test
	public void testNewTransformerSource() throws TransformerConfigurationException
	{
		Transformer actual;
		File resDestDir;
		File xsltFile;
		StreamSource xsltSource;

		resDestDir = PathFinder.getSrcTestResourcesDir();
		xsltFile = PathFinder.getRelativePathTo(resDestDir, "\\.",
			"io.github.astrapi69.xml.transform", "functions.xsl");
		xsltSource = new StreamSource(xsltFile);

		actual = TransformerFactoryInitializer.newTransformer(xsltSource);
		assertNotNull(actual);
	}

	/**
	 * Test method for {@link TransformerFactoryInitializer#newTransformer(String)}
	 *
	 * @throws TransformerConfigurationException
	 *             is thrown if there are errors when parsing the <code>Source</code> or it is not
	 *             possible to create a <code>Transformer</code> instance.
	 */
	@Test
	public void testNewTransformerString() throws TransformerConfigurationException
	{
		Transformer actual;
		File resDestDir;
		File xsltFile;

		resDestDir = PathFinder.getSrcTestResourcesDir();
		xsltFile = PathFinder.getRelativePathTo(resDestDir, "\\.",
			"io.github.astrapi69.xml.transform", "functions.xsl");

		actual = TransformerFactoryInitializer.newTransformer(xsltFile.getAbsolutePath());
		assertNotNull(actual);
	}

	/**
	 * Test method for {@link TransformerFactoryInitializer}
	 */
	@Test
	public void testWithBeanTester()
	{
		final BeanTester beanTester = new BeanTester();
		beanTester.testBean(TransformerFactoryInitializer.class);
	}

}
