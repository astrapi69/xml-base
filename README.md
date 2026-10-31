# Overview

<div style="text-align: center">

[![Java CI with Gradle](https://github.com/astrapi69/xml-base/actions/workflows/gradle.yml/badge.svg)](https://github.com/astrapi69/xml-base/actions/workflows/gradle.yml)
[![Coverage Status](https://codecov.io/gh/astrapi69/xml-base/branch/develop/graph/badge.svg)](https://codecov.io/gh/astrapi69/xml-base)
[![Open Issues](https://img.shields.io/github/issues/astrapi69/xml-base.svg?style=flat)](https://github.com/astrapi69/xml-base/issues)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/io.github.astrapi69/xml-base/badge.svg)](https://maven-badges.herokuapp.com/maven-central/io.github.astrapi69/xml-base)
[![Javadocs](http://www.javadoc.io/badge/io.github.astrapi69/xml-base.svg)](http://www.javadoc.io/doc/io.github.astrapi69/xml-base)
[![MIT License](http://img.shields.io/badge/license-MIT-brightgreen.svg?style=flat)](http://opensource.org/licenses/MIT)
[![Donate](https://img.shields.io/badge/donate-❤-ff2244.svg)](https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=GVBTWLRAZ7HB8)
[![Hits Of Code](https://hitsofcode.com/github/astrapi69/xml-base?branch=develop)](https://hitsofcode.com/github/astrapi69/xml-base/view?branch=develop)
[![Lines Of Code](https://tokei.rs/b1/github/astrapi69/xml-base)](https://github.com/astrapi69/xml-base)

</div>

Holds helper classes for handling xml objects.

> Please support this project by simply putting a
>
Github <a class="github-button" href="https://github.com/astrapi69/xml-base" data-icon="octicon-star" aria-label="Star astrapi69/xml-base on GitHub">
> Star ⭐</a>
>
> Share this library with friends on Twitter and everywhere else you can
>
> If you love this project
> [![Donation](https://img.shields.io/badge/donate-❤-ff2244.svg)](https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=GVBTWLRAZ7HB8)

## Note

No animals were harmed in the making of this library.

## License

The source code comes under the liberal MIT License, making xml-base great for all types of
applications.

## gradle dependency

Replace the variable ${latestVersion} with the current latest
version: [![Maven Central](https://maven-badges.herokuapp.com/maven-central/io.github.astrapi69/xml-base/badge.svg)](https://maven-badges.herokuapp.com/maven-central/io.github.astrapi69/xml-base)

You can first define the version in the ext section and add than the following gradle dependency to
your project `build.gradle` if you want to import the core functionality of xml-base:

define version in file gradle.properties

```
xmlBaseVersion=${latestVersion}
```

or in build.gradle ext area

```
    xmlBaseVersion = "${latestVersion}"
```

then add the dependency to the dependencies area

```
    implementation("io.github.astrapi69:xml-base:$xmlBaseVersion")
```

## Maven dependency

Maven dependency is now on sonatype.
Check
out [sonatype repository](https://oss.sonatype.org/index.html#nexus-search;gav~io.github.astrapi69~xml-base~~~)
for latest snapshots and releases.

Add the following maven dependency to your project `pom.xml` if you want to import the core
functionality of xml-base:

Than you can add the dependency to your dependencies:

    <properties>
            ...
        <!-- xml-base version -->
        <xml-base.version>${latestVersion}</xml-base.version>
            ...
    </properties>
            ...
        <dependencies>
            ...
            <!-- xml-base DEPENDENCY -->
            <dependency>
                <groupId>io.github.astrapi69</groupId>
                <artifactId>xml-base</artifactId>
                <version>${xml-base.version}</version>
            </dependency>
            ...
        </dependencies>

## Support this project

If xml-base is useful to you, a star on [GitHub](https://github.com/astrapi69/xml-base) helps others find it.
Sharing it or reporting a bug helps just as much.

If you would like to contribute financially, the channels are on the repository's Sponsor button, which
reads [.github/FUNDING.yml](.github/FUNDING.yml): GitHub Sponsors, Liberapay, Ko-fi and PayPal.

## Semantic Versioning

The versions of xml-base are maintained with the Semantic Versioning guidelines.

Release version numbers will be incremented in the following format:

`<major>.<minor>.<patch>`

For detailed information on versioning you can visit
the [wiki page](https://github.com/lightblueseas/mvn-parent-projects/wiki/Semantic-Versioning).

## Want to Help and improve it? ###

The source code for xml-base are on GitHub. Please feel free to fork and send pull requests!

Create your own fork of [astrapi69/xml-base/fork](https://github.com/astrapi69/xml-base/fork)

To share your
changes, [submit a pull request](https://github.com/astrapi69/xml-base/pull/new/develop).

Don't forget to add new units tests on your changes.

## Contacting the Developers

Do not hesitate to contact the xml-base developers with your questions, concerns, comments, bug
reports, or feature requests.

- Feature requests, questions and bug reports can be reported at
  the [issues page](https://github.com/astrapi69/xml-base/issues).

## Similar projects

* [VTD-XML](https://vtd-xml.sourceforge.io/) VTD-XML: Process Huge XML Documents (Bigger than 2GB)

## Credits
