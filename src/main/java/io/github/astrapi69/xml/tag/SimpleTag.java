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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * The class Tag represents an tag for xml or html.
 */
public class SimpleTag implements Serializable
{

	/**
	 * The Constant serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;
	/** The attributes of the tag. */
	private Map<String, String> attributes;
	/** The children. */
	private List<SimpleTag> children;
	/** The content of the tag. */
	private String content;
	/** The flag endTag signals if this tag has an ending tag. */
	private boolean endTag;
	/** The name of the tag. */
	private String name;

	public SimpleTag()
	{
	}

	public SimpleTag(Map<String, String> attributes, List<SimpleTag> children, String content,
		boolean endTag, String name)
	{
		this.attributes = attributes;
		this.children = children;
		this.content = content;
		this.endTag = endTag;
		this.name = name;
	}

	public static SimpleTagBuilder builder()
	{
		return new SimpleTagBuilder();
	}

	/**
	 * Adds the attribute with the given name and value.
	 *
	 * @param name
	 *            the name
	 * @param value
	 *            the value
	 * @return the string
	 */
	public String addAttribute(final String name, final String value)
	{
		if (getAttributes() == null)
		{
			setAttributes(new LinkedHashMap<>());
		}
		return getAttributes().put(name, value);
	}

	/**
	 * Adds the given child.
	 *
	 * @param child
	 *            the child
	 * @return true, if successful
	 */
	public boolean addChild(final SimpleTag child)
	{
		if (getChildren() == null)
		{
			setChildren(new ArrayList<>());
		}
		return getChildren().add(child);
	}

	protected boolean canEqual(final Object other)
	{
		return other instanceof SimpleTag;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object clone() throws CloneNotSupportedException
	{

		return new SimpleTag(this.attributes, this.children, this.content, this.endTag, this.name);
	}

	@Override
	public boolean equals(final Object o)
	{
		if (o == this)
			return true;
		if (!(o instanceof SimpleTag))
			return false;
		final SimpleTag other = (SimpleTag)o;
		if (!other.canEqual(this))
			return false;
		final Object this$content = this.getContent();
		final Object other$content = other.getContent();
		if (this$content == null ? other$content != null : !this$content.equals(other$content))
			return false;
		if (this.isEndTag() != other.isEndTag())
			return false;
		final Object this$name = this.getName();
		final Object other$name = other.getName();
		if (this$name == null ? other$name != null : !this$name.equals(other$name))
			return false;
		if (this.getAttributes() == null
			? other.getAttributes() != null
			: !this.getAttributes().equals(other.getAttributes()))
			return false;
		if (this.getChildren() == null
			? other.getChildren() != null
			: !this.getChildren().equals(other.getChildren()))
			return false;
		return true;
	}

	public Map<String, String> getAttributes()
	{
		return this.attributes;
	}

	public SimpleTag setAttributes(Map<String, String> attributes)
	{
		this.attributes = attributes;
		return this;
	}

	public List<SimpleTag> getChildren()
	{
		return this.children;
	}

	public SimpleTag setChildren(List<SimpleTag> children)
	{
		this.children = children;
		return this;
	}

	public String getContent()
	{
		return this.content;
	}

	public SimpleTag setContent(String content)
	{
		this.content = content;
		return this;
	}

	public String getName()
	{
		return this.name;
	}

	public SimpleTag setName(String name)
	{
		this.name = name;
		return this;
	}

	@Override
	public int hashCode()
	{
		final int PRIME = 59;
		int result = 1;
		final Object $content = this.getContent();
		result = result * PRIME + ($content == null ? 43 : $content.hashCode());
		result = result * PRIME + (this.isEndTag() ? 79 : 97);
		final Object $name = this.getName();
		result = result * PRIME + ($name == null ? 43 : $name.hashCode());
		final Object $attributes = this.getAttributes();
		result = result * PRIME + ($attributes == null ? 43 : $attributes.hashCode());
		final Object $children = this.getChildren();
		result = result * PRIME + ($children == null ? 43 : $children.hashCode());
		return result;
	}

	public boolean isEndTag()
	{
		return this.endTag;
	}

	public SimpleTag setEndTag(boolean endTag)
	{
		this.endTag = endTag;
		return this;
	}

	/**
	 * Removes the attribute with the given name.
	 *
	 * @param name
	 *            the name
	 * @return the string
	 */
	public String removeAttribute(final String name)
	{
		if (getAttributes() != null)
		{
			getAttributes().remove(name);
		}
		return null;
	}

	/**
	 * Removes the given child if exists.
	 *
	 * @param child
	 *            the child
	 * @return true, if successful
	 */
	public boolean removeChild(final SimpleTag child)
	{
		if (getChildren() != null)
		{
			return getChildren().remove(child);
		}
		return false;
	}

	public SimpleTagBuilder toBuilder()
	{
		return new SimpleTagBuilder().attributes(this.attributes).children(this.children)
			.content(this.content).endTag(this.endTag).name(this.name);
	}

	@Override
	public String toString()
	{
		return "SimpleTag(content=" + this.getContent() + ", endTag=" + this.isEndTag() + ", name="
			+ this.getName() + ")";
	}

	/**
	 * Creates from this Tag object an velocity template as String object. It puts children Tag
	 * object in the template recursively.
	 *
	 * @return the string buffer
	 */
	public StringBuilder toVelocityTemplate()
	{
		final StringBuilder buffer = new StringBuilder();
		buffer.append("<");
		buffer.append("${").append(getName()).append(".name}\n");
		if (getAttributes() != null && !getAttributes().isEmpty())
		{
			buffer.append(" #foreach(" + "$attribute in $").append(getName())
				.append(".attributes.keySet()" + ")\n");
			buffer.append("$attribute=\"$").append(getName())
				.append(".getAttributes().get($attribute)\"\n");
			buffer.append(" #end\n");
		}
		buffer.append("#if(${").append(getName()).append(".endTag})>${").append(getName())
			.append(".content}\n");
		if (getChildren() != null && !getChildren().isEmpty())
		{
			buffer.append("#foreach($").append(getChildren().get(0).getName()).append(" in $")
				.append(getName()).append(".children)\n");
			for (final SimpleTag child : getChildren())
			{
				buffer.append(child.toVelocityTemplate().toString());
			}
			buffer.append("#end\n");
		}
		buffer.append("</${").append(getName()).append(".name}>\n");
		buffer.append("#else />\n" + "#end\n");
		return buffer;
	}

	/**
	 * Creates from this Tag object an xml string.
	 *
	 * @return the string
	 */
	public String toXmlString()
	{
		final StringBuilder buffer = new StringBuilder();
		buffer.append("<");
		buffer.append(getName());
		Optional<String> attr = TagExtensions.attributesToString(getAttributes());
		if (attr.isPresent())
		{
			buffer.append(attr.get());
		}
		if (isEndTag())
		{
			buffer.append(">");
			buffer.append(getContent());
			if (getChildren() != null && !getChildren().isEmpty())
			{
				for (final SimpleTag child : getChildren())
				{
					buffer.append(child.toXmlString());
				}
			}
			buffer.append("</");
			buffer.append(getName());
			buffer.append(">");
		}
		else
		{
			buffer.append("/>");
		}
		return buffer.toString();
	}

	public static class SimpleTagBuilder
	{
		private Map<String, String> attributes;
		private List<SimpleTag> children;
		private String content;
		private boolean endTag;
		private String name;

		SimpleTagBuilder()
		{
		}

		public SimpleTagBuilder attributes(Map<String, String> attributes)
		{
			this.attributes = attributes;
			return this;
		}

		public SimpleTag build()
		{
			return new SimpleTag(attributes, children, content, endTag, name);
		}

		public SimpleTagBuilder children(List<SimpleTag> children)
		{
			this.children = children;
			return this;
		}

		public SimpleTagBuilder content(String content)
		{
			this.content = content;
			return this;
		}

		public SimpleTagBuilder endTag(boolean endTag)
		{
			this.endTag = endTag;
			return this;
		}

		public SimpleTagBuilder name(String name)
		{
			this.name = name;
			return this;
		}

		@Override
		public String toString()
		{
			return "SimpleTag.SimpleTagBuilder(attributes=" + this.attributes + ", children="
				+ this.children + ", content=" + this.content + ", endTag=" + this.endTag
				+ ", name=" + this.name + ")";
		}
	}
}
