package com.banana.reader.analyze

import java.io.BufferedInputStream
import java.io.BufferedReader
import java.io.ByteArrayOutputStream
import java.io.InputStreamReader
import java.net.URL
import java.nio.charset.Charset
import javax.net.ssl.HttpsURLConnection

class HttpsUtils {

    fun doPost(reqUrl: String, content: String): String {
        var connection: HttpsURLConnection? = null
        try {
            val url = URL(reqUrl)
            connection = url.openConnection() as HttpsURLConnection?
            with(connection) {
                this?.requestMethod = "POST"
                this?.connectTimeout = 6666
                this?.readTimeout = 6666
                this?.doOutput = true
                this?.outputStream?.write(content.toByteArray())
                this?.outputStream?.flush()
                this?.outputStream?.close()
            }
            return getResponseBody(connection).trim()
        } catch (e: Exception) {
            throw RuntimeException(e.message, e)
        } finally {
            connection?.disconnect()
            connection = null
        }
    }

    private fun getResponseBody(url: HttpsURLConnection?): String {
        try {
            val input = url?.inputStream
            val reader = BufferedReader(InputStreamReader(input, "UTF-8"))
            var tempLine = reader.readLine()
            val str = StringBuffer()
            val crl = System.getProperty("line.separator")
            while (tempLine != null) {
                str.append(tempLine)
                str.append(crl)
                tempLine = reader.readLine()
            }
            reader.close()
            input?.close()
            return str.toString()
        } catch (e: java.lang.Exception) {
            throw RuntimeException(e.message, e)
        }
    }

    fun doGet(link: String, charset: Charset): String {
        try {
            val url = URL(link)
            val connection = url.openConnection() as HttpsURLConnection
            with(connection) {
                requestMethod = "GET"
                setRequestProperty("User-Agent", "Reader")
            }
            val input = BufferedInputStream(connection.inputStream)
            val output = ByteArrayOutputStream()
            val buf = ByteArray(1024)
            var i: Int
            while (input.read(buf).also { i = it } > 0) {
                output.write(buf, 0, i)
            }
            output.flush()
            return String(output.toByteArray(), charset)
        } catch (e: Exception) {
            throw RuntimeException(e.message, e)
        }
    }
}