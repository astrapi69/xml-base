package io.github.astrapi69.xml.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import io.github.astrapi69.file.read.ReadFileExtensions;
import io.github.astrapi69.file.search.PathFinder;

public class DocumentExtensionsTest
{
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
			.replace("\t", "").trim();
		expected = ReadFileExtensions.readFromFile(xmlFile).replace("\r", "").replace("\n", "")
			.replace("\t", "").trim();
		assertEquals(expected, actual);
	}
}
