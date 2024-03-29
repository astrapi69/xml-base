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

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;
import org.meanbean.test.Configuration;
import org.meanbean.test.ConfigurationBuilder;

import nl.jqno.equalsverifier.EqualsVerifier;

/**
 * The unit test class for the class {@link ChildTagPosition}
 */
public class ChildTagPositionTest
{

	/**
	 * Test method for {@link ChildTagPosition} constructors and builders
	 */
	@Test
	public final void testConstructors()
	{
		ChildTagPosition model = new ChildTagPosition();
		assertNotNull(model);
		Tag child = Tag.builder().build();
		model = new ChildTagPosition(child, 1);
		assertNotNull(model);
		model = ChildTagPosition.builder().build();
		assertNotNull(model);
		model = ChildTagPosition.builder().position(1).build();
		assertNotNull(model);
		model = ChildTagPosition.builder().position(1).build();
		assertNotNull(model);
		model = ChildTagPosition.builder().child(child).position(1).build();
		assertNotNull(model);
	}

	/**
	 * Test method for {@link ChildTagPosition}
	 */
	@Test
	public void testWithBeanTester()
	{
		Configuration configuration = new ConfigurationBuilder()
			.overrideFactory("child", () -> Tag.builder().build()).build();
		final BeanTester beanTester = new BeanTester();
		beanTester.testBean(ChildTagPosition.class, configuration);
	}

	/**
	 * Test method for {@link ChildTagPosition#equals(Object)} , {@link ChildTagPosition#hashCode()}
	 * and {@link ChildTagPosition#toString()}
	 */
	@Test
	public void verifyEqualsHashcodeAndToStringContracts()
	{
		EqualsVerifier.simple().forClass(ChildTagPosition.class)
			.withPrefabValues(ChildTagPosition.class,
				ChildTagPosition.builder().position(1).build(),
				ChildTagPosition.builder().position(2).build())
			.verify();
	}
}
