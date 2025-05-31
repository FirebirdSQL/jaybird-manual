// Preprocessor for since/until roles in pdf backend (in html5 backed this is handled using CSS)
preprocessor {
    document, reader ->
        if (document.getAttribute('backend') != 'pdf') {
            println 'skipping since/until preprocessor for non-PDF'
            return
        }
        def pattern = ~/\[\.(since|until)\]_([^_]+?)_/
        def allLines = reader.readLines()
        // 290 requires a resize, and 300 is sufficient, taking some extra slack, so: 320
        def buffer = new StringBuilder(320)
        def replacement = allLines.collect { line ->
            def matcher = pattern.matcher(line)
            if (matcher.find()) {
                // Reset buffer for reuse
                buffer.setLength(0)
                while (true) {
                    def replacement = matcher.group(1) == "since" ? /[.since]_**Since:** $2_/ : /[.until]_**Removed in:** $2_/
                    matcher.appendReplacement(buffer, replacement)
                    if (!matcher.find()) break
                }
                matcher.appendTail(buffer)
                return buffer.toString()
            } else {
                return line
            }
        }
        reader.restoreLines(replacement)
}
docinfo_processor {
    document -> {
        if (!document.basebackend('html') || !document.hasAttribute('fb-canonical-html')) {
            return
        }
        return "<link rel=\"canonical\" href=\"${document.getAttribute('fb-canonical-html')}\"/>"
    }
}