package dev.assemblage.push.sender

import com.google.auth.oauth2.GoogleCredentials
import kotlinx.serialization.json.*
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.FileInputStream

class FcmV1Sender {

    private fun getAccessToken(): String {
        val googleCredentials =
            GoogleCredentials.fromStream(FileInputStream(javaClass.classLoader.getResource("service_account.json")?.file))
                .createScoped(arrayListOf("https://www.googleapis.com/auth/firebase.messaging"))
        return googleCredentials.refreshAccessToken().tokenValue
    }

    fun sendPush(projectId: String, token: String) {
        val requestBody = buildJsonObject {
            putJsonObject("message") {
                put("token", token)
                put("data", Json.parseToJsonElement(loadFileContent("fcm/payload/payload.json")))
            }
        }
        val request = Request.Builder()
            .url("https://fcm.googleapis.com/v1/projects/$projectId/messages:send")
            .addHeader(HEADER_CONTENT_TYPE, "application/json; UTF-8")
            .addHeader("Authorization", "Bearer ${getAccessToken()}")
            .post(requestBody.toString().toRequestBody())
            .build()
        val okHttpClient = OkHttpClient()
        val response = okHttpClient.newCall(request).execute()
        println(response.body?.string())
    }

}