package sender

import java.io.BufferedReader
import java.io.FileInputStream
import java.io.InputStreamReader

/**
 * @author Umang Chamaria
 * Date: 31/12/20
 */

fun loadFileContent(filePath: String): String {
   return ClassLoader.getSystemClassLoader()
        .getResourceAsStream(filePath)
        ?.bufferedReader()
        ?.use { it.readText() }
        ?: error("file.json not found on classpath")
}