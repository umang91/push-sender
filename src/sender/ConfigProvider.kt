package sender

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import java.io.File

@Serializable
data class ProjectConfig(val projectId: String, val fids: List<String>)

fun getProjectConfig(): ProjectConfig {
    return Json.decodeFromString<ProjectConfig>(loadConfigText())
}


fun loadConfigText(): String {
    val path = System.getenv("PUSH_SENDER_CONFIG") ?: "fcm_config_local.json"
    val file = File(path)
    require(file.exists()) { "Missing ${file.absolutePath}. add config file." }
    return file.readText()
}