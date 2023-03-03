package com.banana.reader.analyze

import org.xml.sax.Attributes
import org.xml.sax.InputSource
import org.xml.sax.helpers.DefaultHandler
import java.io.StringReader
import javax.xml.parsers.SAXParserFactory

class XMLParserHelper {

    fun parseBySax(data: String) {
        try {
            val factory = SAXParserFactory.newInstance()
            val reader = factory.newSAXParser().xmlReader
            reader.contentHandler = mHandler
            reader.parse(InputSource(StringReader(data)))
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private val mHandler = object : DefaultHandler() {
        override fun startDocument() {

        }

        override fun startElement(uri: String, localName: String, qName: String, attributes: Attributes) {

        }

        override fun characters(ch: CharArray, start: Int, length: Int) {

        }

        override fun endElement(uri: String, localName: String, qName: String) {

        }

        override fun endDocument() {

        }
    }
}