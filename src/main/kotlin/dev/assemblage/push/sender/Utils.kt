package dev.assemblage.push.sender


import org.json.JSONArray
import org.json.JSONObject
import java.io.BufferedReader
import java.io.FileInputStream
import java.io.InputStreamReader

/**
 * @author Umang Chamaria
 * Date: 31/12/20
 */

fun loadFileContent(filePath: String): String {
    val br = BufferedReader(
        InputStreamReader(
            FileInputStream(
                ClassLoader.getSystemClassLoader().getResource(filePath).file
            )
        )
    )
    val sb = StringBuilder()
    var line = br.readLine()
    while (line != null) {
        sb.append(line)
        line = br.readLine()
    }
    return sb.toString()
}

fun loadJsonObject(filePath: String): JSONObject {
    return JSONObject(loadFileContent(filePath))
}

fun loadJsonArray(filePath: String): JSONArray {
    return JSONArray(loadFileContent(filePath))
}