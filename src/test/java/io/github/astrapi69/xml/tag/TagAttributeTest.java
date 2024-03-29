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
package io.github.astrapi69.xml.tag;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;

import io.github.astrapi69.collection.list.ListFactory;
import nl.jqno.equalsverifier.EqualsVerifier;

/**
 * The unit test class for the class {@link TagAttribute}
 */
public class TagAttributeTest
{

	/**
	 * Test method for {@link TagAttribute} constructors and builders
	 */
	@Test
	public final void testConstructors()
	{
		TagAttribute model = new TagAttribute();
		assertNotNull(model);
		model = new TagAttribute("class", " ", ListFactory.newArrayList("row", "fluid"));
		assertNotNull(model);
		model = TagAttribute.builder().build();
		assertNotNull(model);
		model = TagAttribute.builder().name("class").delimiter(" ").value("row").value("fluid")
			.build();
		assertNotNull(model);
	}

	/**
	 * Test method for {@link TagAttribute#joinValues()}
	 */
	@Test
	public void testJoinValues()
	{
		final String actual = TagAttribute.builder().name("class").delimiter(" ").value("row")
			.value("fluid").build().joinValues();
		final String expected = "row fluid";
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link TagAttribute}
	 */
	@Test
	public void testWithBeanTester()
	{
		final BeanTester beanTester = new BeanTester();
		beanTester.testBean(TagAttribute.class);
	}

	/**
	 * Test method for {@link TagAttribute#equals(Object)} , {@link TagAttribute#hashCode()} and
	 * {@link TagAttribute#toString()}
	 */
	@Test
	public void verifyEqualsHashcodeAndToStringContracts()
	{
		EqualsVerifier.simple().forClass(TagAttribute.class).verify();
	}

}
