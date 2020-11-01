package org.my.plant.console.helpers

import mu.KotlinLogging
import java.io.*

val logger = KotlinLogging.logger {}

//to write out to file
fun write( fileName: String, data: String) {

    val file = File(fileName)
    try {
        //from java.io
        val outputStreamWriter = OutputStreamWriter(FileOutputStream(file))
        outputStreamWriter.write(data)
        outputStreamWriter.close()
    } catch (e: Exception) {
        logger.error { "Cannot read file: " + e.toString() }
    }
}

//read from file
fun read(fileName: String): String {
    val file = File(fileName)
    var str = ""
    try {
        val inputStreamReader = InputStreamReader(FileInputStream(file))
        if (inputStreamReader != null) {
            val bufferedReader = BufferedReader(inputStreamReader)
            val partialStr = StringBuilder()
            var done = false
            while (!done) {
                var line = bufferedReader.readLine()
                done = (line == null);
                if (line != null) partialStr.append(line);
            }
            inputStreamReader.close()
            str = partialStr.toString()
        }
    } catch (e: FileNotFoundException) {
        logger.error { "Cannot Find file: " + e.toString() }
    } catch (e: IOException) {
        logger.error { "Cannot Read file: " + e.toString() }
    }
    return str
}

fun exists(fileName: String): Boolean {
    val file = File(fileName)
    return file.exists()
}