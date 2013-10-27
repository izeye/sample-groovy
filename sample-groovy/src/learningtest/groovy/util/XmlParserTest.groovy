package learningtest.groovy.util;

import static org.junit.Assert.*

import org.junit.Test

class XmlParserTest {

	@Test
	public void parseText() {
		def xml = '<root><one a1="uno!" /><two>Some text!</two></root>'
		def rootNode = new XmlParser().parseText(xml)
		assert rootNode.name() == 'root'

		println rootNode.one
		println rootNode.one[0]
		println rootNode.two
		println rootNode.two[0]

		assert rootNode.one[0].@a1 == 'uno!'
		assert rootNode.two.text() == 'Some text!'
		rootNode.children().each {
			assert it.name() in ['one', 'two']
		}
	}
}
