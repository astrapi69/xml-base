package io.github.astrapi69.xml.parser;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.dom.DOMSource;

import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import io.github.astrapi69.file.search.PathFinder;

public class DocumentBuilderFactoryInitializerTest
{
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
}
