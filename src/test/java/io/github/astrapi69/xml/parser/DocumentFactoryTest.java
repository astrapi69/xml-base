package io.github.astrapi69.xml.parser;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;

/**
 * The unit test class for the class {@link DocumentFactory}
 */
public class DocumentFactoryTest
{

	/**
	 * Test method for {@link DocumentFactory#newDocument()}
	 *
	 * @throws ParserConfigurationException
	 *             the parser configuration exception
	 */
	@Test
	public void testDocumentToFile() throws ParserConfigurationException
	{
		Document actual;

		actual = DocumentFactory.newDocument();
		assertNotNull(actual);
	}
}
