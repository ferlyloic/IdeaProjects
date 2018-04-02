def xml = """
<languages>
<language name="Groovy">
<feature coolness="low">SQL</feature>
<feature coolness="high">Template</feature>
</language>
<language name="Perl"/>
</languages>"""

def root = new XmlParser().parseText(xml)
println root.language.feature[1].text()
root.language.feature
        .findAll{ it['@coolness'] == "low" }
        .each{ println it.toString() }