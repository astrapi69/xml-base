package io.github.astrapi69.xml.transform;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.File;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.stream.StreamSource;

import org.junit.jupiter.api.Test;

import io.github.astrapi69.file.search.PathFinder;

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
	public void testGetTransformerSource() throws TransformerConfigurationException
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
	public void testGetTransformerString() throws TransformerConfigurationException
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
}
