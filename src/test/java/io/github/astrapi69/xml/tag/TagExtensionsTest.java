/**
 * The MIT License
 * <p>
 * Copyright (C) 2021 Asterios Raptis
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package io.github.astrapi69.xml.tag;

import io.github.astrapi69.collection.map.MapFactory;
import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;

import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The class {@link TagExtensionsTest}
 */
public class TagExtensionsTest
{

	/**
	 * Test method for {@link TagExtensions#attributesToString(Map)}
	 */
	@Test
	public final void testAttributesToString()
	{
		Optional<String> actual;
		Optional<String> expected;
		Map<String, String> attributes = MapFactory.newLinkedHashMap();

		attributes.put("wicket:id", "name");
		attributes.put("class", "other");

		actual = TagExtensions.attributesToString(attributes);
		expected = Optional.of(" wicket:id=\"name\" class=\"other\" ");
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link TagExtensions}
	 */
	@Test
	public void testWithBeanTester()
	{
		final BeanTester beanTester = new BeanTester();
		beanTester.testBean(TagExtensions.class);
	}

}
