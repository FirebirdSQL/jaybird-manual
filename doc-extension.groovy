// Preprocessor for since/until roles in pdf backend (in html5 backed this is handled using CSS)
preprocessor {
    document, reader ->
        if (document.options['backend'] != 'pdf') {
            println 'skipping since/until preprocessor for non-PDF'
            return
        }
        def pattern = ~/\[\.(since|until)\]_([^_]+?)_/
        def allLines = reader.readLines()
        def replacement = allLines.collect { line ->
            def matcher = pattern.matcher(line)
            if (matcher.find()) {
                def buffer = new StringBuffer(line.length() + 16)
                while (true) {
                    def replacement = matcher.group(1) == "since" ? /[.since]_**Since:** $2_/ : /[.until]_**Removed in:** $2_/
                    matcher.appendReplacement(buffer, replacement)
                    if (!matcher.find()) break;
                }
                matcher.appendTail(buffer)
                return buffer.toString()
            } else {
                return line
            }
        }
        reader.restoreLines(replacement)
}