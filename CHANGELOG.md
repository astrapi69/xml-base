## Change log
----------------------

Version 1.5-SNAPSHOT
-------------

Version 1.4
-------------

ADDED:

- new requires statement to module-info.java file for module throwable
- exports for all project packages in the module-info.java file

CHANGED:

- update of gradle to new version 7.5-rc-2
- update of dependency throwable to new minor version 2.2
- update gradle-plugin dependency of io.freefair.gradle:lombok-plugin to new patch version 6.5.0.2
- increase of code coverage to 100%

Version 1.3
-------------

ADDED:

- new factory methods for DocumentFactory with InputSource object
- new factory class DOMResultFactory for create DOMResult object
- new extension methods for get xml string represantation from NodeList and Node objects
- new extension method for get text content values from a given node and a given xpath expression

Version 1.2
-------------

ADDED:

- new class DocumentExtensions that provides extension methods for Document objects
- new class DocumentFactory that provides factory methods for creating Document objects
- new factory methods for TransformerFactory for provide needed attributes
- new factory methods for Transformer for provide needed attributes and output properties
- new extension method for print a Document object as String object

CHANGED:

- update of gradle plugin dependency com.diffplug.spotless:spotless-plugin-gradle to new patch version 6.7.2
- update of test dependency throwable to new minor version 2.1

Version 1.1
-------------

ADDED:

- new class ParserFactory for creation of new SAXParserFactory objects
- new abstract class WriterHandler for provide and handle xml with Writer objects
- new class OutputStreamWriterHandler for handle xml with Writer objects
- new class TemplateHandler for handle template xml or html objects
- new class TransformerFactoryInitializer for initialize TransformerFactory Transformer objects
- new class XPathExtensions for resolve NodeList from given xml files or xml strings
- new class XmlResourceBundle for support all character sets and enables multi-language support
- new class XmlResourceBundleControl for provide ResourceBundle object for xml resource bundles

Version 1
-------------

ADDED:

- new CHANGELOG.md file created

Notable links:
[keep a changelog](http://keepachangelog.com/en/1.0.0/) Don’t let your friends dump git logs into changelogs
