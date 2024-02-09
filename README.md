# jaybird-manual
Jaybird JDBC Driver Java Programmer's Manual [![Build Status](https://github.com/FirebirdSQL/jaybird-manual/actions/workflows/publish-to-github-pages.yml/badge.svg?branch=master)](https://github.com/FirebirdSQL/jaybird-manual/actions?query=branch%3Amaster+workflow%3Apublish-to-github-pages)

Manual for [Jaybird](https://github.com/FirebirdSQL/jaybird), the Firebird JDBC driver.

Snapshot build of manual
========================

You can see the latest snapshot build of the manual on https://firebirdsql.github.io/jaybird-manual/jaybird_manual.html.
We also provide a print-friendly PDF on https://firebirdsql.github.io/jaybird-manual/jaybird_manual.pdf.

These documents are automatically built for each change on master.

Style
=====

Line breaking convention: a single sentence per line, no line breaks within a sentence. If a line 
becomes too long, take that as a hint to rewrite (if possible).

NOTE: The previous convention was 100 characters per line. Only apply the single sentence per line style
per paragraph when making changes in that paragraph.

Sourcecode examples: indent 2 spaces, continuations: 4 spaces 

How to build
============

Run `./gradlew` or its full equivalent `./gradlew clean asciidoctor`. 
Add `asciidoctorPdf` for the PDF version.

Building the documentation requires Java 9 or higher, use of Java 17 or higher is advisable.

Supporting information
======================

This project uses [asciidoctor](https://asciidoctor.org/).

Reporting bugs
==============

Please report bugs or corrections through [issues](https://github.com/FirebirdSQL/jaybird-manual/issues) or create a pull request with your improvements.
