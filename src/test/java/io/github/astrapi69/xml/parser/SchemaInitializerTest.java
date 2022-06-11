package io.github.astrapi69.xml.parser;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.File;

import javax.xml.validation.Schema;

import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import io.github.astrapi69.file.search.PathFinder;

public class SchemaInitializerTest
{
	@Test
	public void testNewSchema() throws SAXException
	{
		Schema actual;
		File xsd;
		xsd = new File(PathFinder.getSrcTestResourcesDir(), "dataset.xsd");
		actual = SchemaInitializer.newSchema(xsd);
		assertNotNull(actual);
	}
}
