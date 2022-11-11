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
package io.github.astrapi69.xml.parser;

import io.github.astrapi69.file.search.PathFinder;
import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.dom.DOMSource;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * The unit test class for the class {@link DocumentBuilderFactoryInitializer}
 */
public class DocumentBuilderFactoryInitializerTest
{

	/**
	 * Test method for {@link DocumentBuilderFactoryInitializer#newDOMSource(Document)}
	 *
	 * @throws ParserConfigurationException
	 *             the parser configuration exception
	 * @throws SAXException
	 *             If a SAX error occurs during parsing
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	@Test
	public void testNewDOMSourceWithDocument()
		throws ParserConfigurationException, IOException, SAXException
	{
		DOMSource actual;
		File xmlFile;
		xmlFile = PathFinder.getRelativePath(PathFinder.getSrcTestResourcesDir(), "test-xml.xml");
		final Document document = DocumentFactory.newDocument(xmlFile);
		actual = DocumentBuilderFactoryInitializer.newDOMSource(document);
		assertNotNull(actual);
	}

	/**
	 * Test method for {@link DocumentBuilderFactoryInitializer#newDOMSource(File)}
	 *
	 * @throws ParserConfigurationException
	 *             the parser configuration exception
	 * @throws SAXException
	 *             If a SAX error occurs during parsing
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	@Test
	public void testNewDOMSourceWithFile()
		throws ParserConfigurationException, IOException, SAXException
	{
		DOMSource actual;
		File xmlFile;
		xmlFile = PathFinder.getRelativePath(PathFinder.getSrcTestResourcesDir(), "test-xml.xml");
		actual = DocumentBuilderFactoryInitializer.newDOMSource(xmlFile);
		assertNotNull(actual);
	}

	/**
	 * Test method for
	 * {@link DocumentBuilderFactoryInitializer#newDocumentBuilderFactory(String, String, String, boolean, boolean)}
	 */
	@Test
	public void testNewDocumentBuilderFactory()
	{
		DocumentBuilderFactory actual;
		String schema;
		String schemaLanguage;
		String documentBuilderFactoryName;
		boolean namespaceAwareness;
		boolean factoryValidating;

		schema = null;
		schemaLanguage = null;
		documentBuilderFactoryName = null;
		namespaceAwareness = false;
		factoryValidating = false;

		actual = DocumentBuilderFactoryInitializer.newDocumentBuilderFactory(schema, schemaLanguage,
			documentBuilderFactoryName, namespaceAwareness, factoryValidating);
		assertNotNull(actual);
	}

	/**
	 * Test method for {@link DocumentBuilderFactoryInitializer}
	 */
	@Test
	public void testWithBeanTester()
	{
		final BeanTester beanTester = new BeanTester();
		beanTester.testBean(DocumentBuilderFactoryInitializer.class);
	}

}
