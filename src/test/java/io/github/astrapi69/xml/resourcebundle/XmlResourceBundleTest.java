/**
 * The MIT License
 *
 * Copyright (C) 2015 Asterios Raptis
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
package io.github.astrapi69.xml.resourcebundle;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.github.astrapi69.collections.iterators.EnumerationIterator;
import io.github.astrapi69.file.search.PathFinder;

/**
 * The unit test class for the class {@link XmlResourceBundle}
 */
public class XmlResourceBundleTest
{

	/** The properties for unit tests. */
	Properties properties;

	/** The german properties xml file for unit tests. */
	File propertiesDeXml;

	/** The properties german for unit tests. */
	Properties propertiesGerman;

	/** The default properties xml file for unit tests. */
	File propertiesXml;

	/**
	 * Sets up method will be invoked before every unit test method
	 */
	@BeforeEach
	protected void setUp()
	{
		propertiesXml = new File(PathFinder.getSrcTestResourcesDir(), "SigninPanel.xml");
		propertiesDeXml = new File(PathFinder.getSrcTestResourcesDir(), "SigninPanel_de.xml");
		properties = new Properties();
		properties.setProperty("global.email.label", "Email");
		properties.setProperty("global.enter.your.email.label", "Enter your email");
		properties.setProperty("global.password.label", "Password");
		properties.setProperty("global.enter.your.password.label", "Enter your password");
		properties.setProperty("password.forgotten.label", "Forgot your password?");
		propertiesGerman = new Properties();
		propertiesGerman.setProperty("global.email.label", "Email");
		propertiesGerman.setProperty("global.enter.your.email.label", "Gib deine Email ein");
		propertiesGerman.setProperty("global.password.label", "Passwort");
		propertiesGerman.setProperty("global.enter.your.password.label", "Gib dein Passwort ein");
		propertiesGerman.setProperty("password.forgotten.label", "Passwort vergessen?");
	}

	/**
	 * Tear down method will be invoked after every unit test method
	 */
	@AfterEach
	protected void tearDown()
	{
		propertiesXml = null;
		propertiesDeXml = null;
		properties = null;
		propertiesGerman = null;
	}

	/**
	 * Test method for {@link XmlResourceBundle} constructors.
	 *
	 * @throws FileNotFoundException
	 *             the file not found exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	@Test
	public final void testConstructors() throws FileNotFoundException, IOException
	{
		XmlResourceBundle model = new XmlResourceBundle(new FileInputStream(propertiesXml));
		assertNotNull(model);
	}

	/**
	 * Test method for {@link XmlResourceBundle#getKeys()}.
	 *
	 * @throws FileNotFoundException
	 *             the file not found exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	@Test
	public final void testGetKeys() throws FileNotFoundException, IOException
	{
		XmlResourceBundle actual;
		Enumeration<String> keys;
		EnumerationIterator<String> iterator;

		actual = new XmlResourceBundle(new FileInputStream(propertiesXml));
		assertNotNull(actual);
		keys = actual.getKeys();
		iterator = new EnumerationIterator<>(keys);
		while (iterator.hasNext())
		{
			String key = iterator.next();
			assertTrue(properties.containsKey(key));
			String actualValue = actual.getString(key);
			String expectedValue = properties.getProperty(key);
			assertEquals(actualValue, expectedValue);
		}

		actual = new XmlResourceBundle(new FileInputStream(propertiesDeXml));
		assertNotNull(actual);
		keys = actual.getKeys();
		iterator = new EnumerationIterator<>(keys);
		while (iterator.hasNext())
		{
			String key = iterator.next();
			assertTrue(propertiesGerman.containsKey(key));
			String actualValue = actual.getString(key);
			String expectedValue = propertiesGerman.getProperty(key);
			assertEquals(actualValue, expectedValue);
		}
	}

}
