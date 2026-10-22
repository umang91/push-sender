package sender

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import java.io.File

fun main(args: Array<String>) {
    val projectConfig = getProjectConfig()
    if (projectConfig.fids.isEmpty()) {
        println("No fids found, can't send push.")
    }
    for (fid in projectConfig.fids) {
        FcmV1Sender().sendPush(
            projectConfig.projectId,
            fid
        )
    }
}