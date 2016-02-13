@echo off
rmdir /s /q output
mkdir output
mkdir output\images
pandoc -f markdown -t html5 -o output\jaybird_manual.html -s src\jaybird_manual_metadata.yaml src\jaybird_manual.md
copy src\images\* output\images