## Change log
----------------------

Version 1.6
-------------

ADDED:

- new method toString with argument of document and indent in extension class DocumentExtensions

CHANGED:

- update gradle to new version 8.0.2
- update of gradle-plugin dependency of 'io.freefair.gradle:lombok-plugin' in version 6.6.3
- update of gradle plugin dependency com.github.ben-manes.versions.gradle.plugin to new minor version 0.46.0
- update of gradle plugin dependency com.diffplug.spotless:spotless-plugin-gradle to new patch version 6.17.0
- update of dependency lombok to new patch version 1.18.26
- update of dependency file-worker to new minor version 11.6
- update of test dependency silly-collection to new major version 21
- update of test dependency silly-io to new minor version 2.2
- update of test dependency equalsverifier to new minor version 3.14
- update of test dependency junit-jupiter-api to new minor version 5.9.2
- update of test dependency 'com.github.meanbeanlib:meanbean' to new version 3.0.0-M9

Version 1.5
-------------

ADDED:

- new enum class NodeType for determine the type of org.w3c.dom.Node object
- new bean classes for tag representation
- new test dependency silly-bean in version 2
- new test dependency velocity-extensions in version 1.5
- new test dependency velocity in version 1.7
- new test dependency equalsverifier in version 3.11

CHANGED:

- update of gradle to new version 7.6-rc-2
- update of gradle plugin dependency com.github.ben-manes.versions.gradle.plugin to new minor version 0.43.0
- update of gradle-plugin dependency of 'io.freefair.gradle:lombok-plugin' in version 6.5.1
- update of gradle-plugin dependency of 'com.diffplug.spotless:spotless-plugin-gradle' in version 6.11.0
- update of dependency throwable to new minor version 2.3
- update of test dependency file-worker to new patch version 11.5.1
- update of test dependency junit-jupiter-api to new minor version 5.9.1
- update of test dependency jobj-core to new major version 7
- update of test dependency silly-collection to new minor version 20.1
- update of test dependency silly-io to new minor version 2.1

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
