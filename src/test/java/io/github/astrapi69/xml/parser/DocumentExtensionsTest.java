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
package io.github.astrapi69.xml.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import io.github.astrapi69.file.delete.DeleteFileExtensions;
import io.github.astrapi69.file.read.ReadFileExtensions;
import io.github.astrapi69.file.search.PathFinder;

public class DocumentExtensionsTest
{
	@Test
	public void testDocumentToFile()
		throws ParserConfigurationException, IOException, SAXException, TransformerException
	{

		String actual;
		String expected;
		File xmlFile;
		File xmlNewFile;
		xmlFile = PathFinder.getRelativePath(PathFinder.getSrcTestResourcesDir(), "test-xml.xml");
		xmlNewFile = PathFinder.getRelativePath(PathFinder.getSrcTestResourcesDir(),
			"test-new-xml.xml");
		final Document document = DocumentFactory.newDocument(xmlFile);

		DocumentExtensions.toFile(document, xmlNewFile);
		actual = ReadFileExtensions.readFromFile(xmlFile).replace("\r", "").replace("\n", "")
			.replace("\t", "").replace(" ", "").trim();
		expected = ReadFileExtensions.readFromFile(xmlNewFile).replace("\r", "").replace("\n", "")
			.replace("\t", "").replace(" ", "").trim();
		assertEquals(expected, actual);
		DeleteFileExtensions.delete(xmlNewFile);
	}

	@Test
	public void testDocumentToString()
		throws ParserConfigurationException, IOException, SAXException, TransformerException
	{
		String actual;
		String expected;

		File xmlFile;
		xmlFile = PathFinder.getRelativePath(PathFinder.getSrcTestResourcesDir(), "test-xml.xml");
		final Document document = DocumentFactory.newDocument(xmlFile);
		actual = DocumentExtensions.toString(document).replace("\r", "").replace("\n", "")
			.replace("\t", "").replace(" ", "").trim();
		expected = ReadFileExtensions.readFromFile(xmlFile).replace("\r", "").replace("\n", "")
			.replace("\t", "").replace(" ", "").trim();
		assertEquals(expected, actual);
	}
}
