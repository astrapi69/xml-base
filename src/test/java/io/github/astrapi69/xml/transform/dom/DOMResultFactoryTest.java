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
package io.github.astrapi69.xml.transform.dom;

import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;

import javax.xml.transform.TransformerException;
import javax.xml.transform.dom.DOMResult;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * The unit test class for the class {@link DOMResultFactory}
 */
public class DOMResultFactoryTest
{

	/**
	 * Test method for {@link DOMResultFactory#newDOMResult(String)}
	 *
	 * @throws TransformerException
	 *             is thrown if an unrecoverable error occurs during the course of the
	 *             transformation
	 */
	@Test
	public void testNewDOMResult() throws TransformerException
	{
		String xmlString;
		xmlString = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><Customer id=\"1\">\n"
			+ "\t\t<age>34</age>\n" + "\t\t<name>John</name>\n" + "\t\t<gender>Male</gender>\n"
			+ "\t\t<role>Cpp Developer</role>\n" + "\t</Customer>";
		DOMResult domResult = DOMResultFactory.newDOMResult(xmlString);
		assertNotNull(domResult);

	}

	/**
	 * Test method for {@link DOMResultFactory}
	 */
	@Test
	public void testWithBeanTester()
	{
		final BeanTester beanTester = new BeanTester();
		beanTester.testBean(DOMResultFactory.class);
	}

}
