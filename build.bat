@echo off
if not exist output mkdir output
pandoc -f markdown -t html5 -o output\jaybird_manual.html -s src\jaybird_manual.md