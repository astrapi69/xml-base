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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;

import io.github.astrapi69.collection.list.ListFactory;
import io.github.astrapi69.collection.map.MapFactory;
import io.github.astrapi69.velocity.VelocityExtensions;
import nl.jqno.equalsverifier.EqualsVerifier;

/**
 * The unit test class for the class {@link SimpleTag}
 */
public class SimpleTagTest
{

	/**
	 * Test method for {@link SimpleTag}.
	 *
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws CloneNotSupportedException
	 *             is thrown if the object's class does not support the {@code Cloneable} interface.
	 *             Subclasses that override the {@code clone} method can also throw this exception
	 *             to indicate that an instance cannot be cloned.
	 */
	@Test
	public void test() throws IOException, CloneNotSupportedException
	{
		String expected;
		String actual;
		final SimpleTag tag = new SimpleTag();
		tag.setName("div");
		tag.addAttribute("wicket:id", "contentLabel");
		tag.addAttribute("class", "myClass");
		tag.setContent("xy");
		tag.setEndTag(true);

		expected = "<div wicket:id=\"contentLabel\" class=\"myClass\" >xy</div>";
		actual = tag.toXmlString();
		/* check if equal */
		assertEquals(expected, actual);

		tag.setEndTag(false);

		expected = "<div wicket:id=\"contentLabel\" class=\"myClass\" />";
		actual = tag.toXmlString();
		/* check if equal */
		assertEquals(expected, actual);

		final SimpleTag cloned = (SimpleTag)tag.clone();

		assertEquals(tag, cloned);

		assertEquals(tag.hashCode(), cloned.hashCode());
		// add end tag to the div
		tag.setEndTag(true);

		expected = "<div wicket:id=\"contentLabel\" class=\"myClass\" >xy</div>";
		actual = tag.toXmlString();
		/* check if equal */
		assertEquals(expected, actual);

		final SimpleTag child1 = new SimpleTag();

		child1.addAttribute("wicket:id", "name");
		child1.addAttribute("class", "other");
		child1.setName("span");
		child1.setContent("Hello ");
		child1.setEndTag(true);

		tag.addChild(child1);
		expected = "<div wicket:id=\"contentLabel\" class=\"myClass\" >xy<span wicket:id=\"name\" "
			+ "class=\"other\" >Hello </span></div>";
		actual = tag.toXmlString();
		/* check if equal */
		assertEquals(expected, actual);

		final SimpleTag granChild1 = new SimpleTag();
		granChild1.setName("b");
		granChild1.setContent("world");
		granChild1.setEndTag(true);

		child1.addChild(granChild1);

		expected = "<div wicket:id=\"contentLabel\" class=\"myClass\" >xy<span wicket:id=\"name\" "
			+ "class=\"other\" >Hello <b>world</b></span></div>";
		actual = tag.toXmlString();
		/* check if equal */
		assertEquals(expected, actual);


		/* create a velocity template as String object from the tag */
		final StringBuilder velocityTemplateBuilder = tag.toVelocityTemplate();
		actual = velocityTemplateBuilder.toString();
		expected = "<${div.name}\n " + "#foreach($attribute in $div.attributes.keySet())\n"
			+ "$attribute=\"$div.getAttributes().get($attribute)\"\n" + " #end\n"
			+ "#if(${div.endTag})>${div.content}\n" + "#foreach($span in $div.children)\n"
			+ "<${span.name}\n" + " #foreach($attribute in $span.attributes.keySet())\n"
			+ "$attribute=\"$span.getAttributes().get($attribute)\"\n" + " #end\n"
			+ "#if(${span.endTag})>${span.content}\n" + "#foreach($b in $span.children)\n"
			+ "<${b.name}\n" + "#if(${b.endTag})>${b.content}\n" + "</${b.name}>\n" + "#else />\n"
			+ "#end\n" + "#end\n" + "</${span.name}>\n" + "#else />\n" + "#end\n" + "#end\n"
			+ "</${div.name}>\n" + "#else />\n" + "#end\n";
		/* check if equal */
		assertEquals(expected, actual);
		/* Merge the created velocity template from the tag and merge it with the context. */
		final String velocityTemplate = actual;
		/* first, we init the runtime engine. Defaults are fine. */
		Velocity.init();

		/* lets make a Context and put data into it */
		final VelocityContext context = new VelocityContext();
		/* put the tag into the context */
		context.put(tag.getName(), tag);
		actual = VelocityExtensions.merge(context, velocityTemplate);
		expected = "<div\n" + " wicket:id=\"contentLabel\"\n" + " class=\"myClass\"\n" + " >xy\n"
			+ "<span\n" + " wicket:id=\"name\"\n" + " class=\"other\"\n" + " >Hello \n" + "<b\n"
			+ ">world\n" + "</b>\n" + "</span>\n" + "</div>\n";
		/* check if equal */
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link SimpleTag} constructors and builders
	 */
	@Test
	public final void testConstructors()
	{
		SimpleTag model = new SimpleTag();
		assertNotNull(model);
		model = new SimpleTag(MapFactory.newLinkedHashMap(), ListFactory.newArrayList(), "bar",
			false, "foo");
		assertNotNull(model);
		model = SimpleTag.builder().build();
		assertNotNull(model);
	}

	/**
	 * Test method for {@link SimpleTag#removeAttribute(String)}
	 */
	@Test
	public void testRemoveAttribute()
	{
		SimpleTag child1 = SimpleTag.builder().name("img").build();
		SimpleTag child2 = SimpleTag.builder().name("b").build();
		SimpleTag simpleTag = new SimpleTag(MapFactory.newLinkedHashMap(),
			ListFactory.newArrayList(child1, child2), "bar", false, "foo");

		simpleTag.addAttribute("class", "fluid box");

		assertTrue(simpleTag.getAttributes().containsKey("class"));

		simpleTag.removeAttribute("class");
		assertFalse(simpleTag.getAttributes().containsKey("class"));
	}

	/**
	 * Test method for {@link SimpleTag#removeChild(SimpleTag)}
	 */
	@Test
	public void testRemoveChild()
	{
		SimpleTag child1 = SimpleTag.builder().name("img").build();
		SimpleTag child2 = SimpleTag.builder().name("b").build();
		SimpleTag simpleTag = new SimpleTag(MapFactory.newLinkedHashMap(),
			ListFactory.newArrayList(child1, child2), "bar", false, "foo");

		assertTrue(simpleTag.getChildren().contains(child1));

		simpleTag.removeChild(child1);

		assertFalse(simpleTag.getChildren().contains(child1));

		assertFalse(child1.removeChild(child2));
	}

	/**
	 * Test method for {@link SimpleTag}
	 */
	@Test
	public void testWithBeanTester()
	{
		final BeanTester beanTester = new BeanTester();
		beanTester.testBean(SimpleTag.class);
	}

	/**
	 * Test method for {@link SimpleTag#equals(Object)} , {@link SimpleTag#hashCode()} and
	 * {@link SimpleTag#toString()}
	 */
	@Test
	public void verifyEqualsHashcodeAndToStringContracts()
	{
		EqualsVerifier
			.simple().forClass(SimpleTag.class).withPrefabValues(SimpleTag.class,
				SimpleTag.builder().name("foo").build(), SimpleTag.builder().name("bar").build())
			.verify();
	}

}
