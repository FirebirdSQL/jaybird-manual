@echo off
rmdir /s /q output
mkdir output
mkdir output\images
copy src\images\* output\images
asciidoctor -b html5 -D output src\jaybird_manual.asciidoc
