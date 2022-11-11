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
package io.github.astrapi69.xml.sax.handler;

import io.github.astrapi69.file.compare.CompareFileExtensions;
import io.github.astrapi69.file.compare.api.IFileContentResultBean;
import io.github.astrapi69.file.csv.CsvFileExtensions;
import io.github.astrapi69.file.delete.DeleteFileExtensions;
import io.github.astrapi69.file.search.PathFinder;
import io.github.astrapi69.file.write.WriteFileExtensions;
import org.junit.jupiter.api.Test;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * The unit test class for the class {@link TemplateHandler}
 */
public class TemplateHandlerTest
{

	/**
	 * Test method for {@link TemplateHandler#write(String)}
	 */
	@Test
	public void testWrite() throws IOException
	{
		// The resources destination dir
		final File testResDir = PathFinder.getSrcTestResourcesDir();
		final String templateName = "LoginAsProvider";
		final String expectedFileName = "expected.html";
		final File template = new File(testResDir, templateName + ".xml");
		final File expected = new File(testResDir, expectedFileName);
		final File input = new File(testResDir, templateName + ".cvs");
		final List<Map<String, String>> testData = CsvFileExtensions.getCvsAsListMap(input);
		final Map<String, String> oneline = testData.get(0);
		final StringWriter writer = new StringWriter();
		final TemplateHandler handler = new TemplateHandler(oneline, writer);
		try
		{
			// Use the default (non-validating) parser
			final SAXParserFactory factory = SAXParserFactory.newInstance();
			// Parse the input
			final SAXParser saxParser = factory.newSAXParser();
			saxParser.parse(template, handler);
		}
		catch (final ParserConfigurationException | SAXException e)
		{
			e.printStackTrace();
		}
		final File output = new File(testResDir, "test-generated" + ".html");
		if (!output.exists())
		{
			output.createNewFile();
		}
		WriteFileExtensions.writeStringToFile(output, writer.toString(), "UTF-8");

		final IFileContentResultBean bean = CompareFileExtensions.compareFiles(output, expected);
		assertTrue(bean.getContentEquality());
		DeleteFileExtensions.delete(output);

	}

	/**
	 * Test method for {@link TemplateHandler#startElement(String, String, String, Attributes)}
	 */
	@Test
	public void testStartElement() throws IOException, SAXException
	{
		// The resources destination dir
		final File testResDir = PathFinder.getSrcTestResourcesDir();
		final String templateName = "LoginAsProvider";
		final File input = new File(testResDir, templateName + ".cvs");
		final List<Map<String, String>> testData = CsvFileExtensions.getCvsAsListMap(input);
		final Map<String, String> oneline = testData.get(0);
		final StringWriter writer = new StringWriter();
		final TemplateHandler handler = new TemplateHandler(oneline, writer);

		handler.startElement("", "", "html", null);
		assertNotNull(handler);
		String actual;
		String expected;
		actual = handler.getName("", "foo");
		expected = "foo";
		assertEquals(expected, actual);
		actual = handler.getName("bar", "foo");
		expected = "bar";
		assertEquals(expected, actual);
	}

}
