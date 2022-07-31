package dev.assemblage.push.sender

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject

class FcmSender {

    fun sendPush(serverKey: String, payloadPath: String) {
        val body = JSONObject()
        body.put(REQUEST_ATTRIBUTE_TOKENS, loadJsonArray("fcm/tokens.json"))
            .put(REQUEST_ATTRIBUTE_DATA, loadJsonObject(payloadPath))
        println(body.toString(4))
        val request = Request.Builder()
            .url(FCM_ENDPOINT)
            .addHeader(HEADER_CONTENT_TYPE, HEADER_CONTENT_TYPE_JSON)
            .addHeader("Authorization", "key=$serverKey")
            .post(body.toString().toRequestBody())
            .build()
        val okHttpClient = OkHttpClient()
        val response = okHttpClient.newCall(request).execute()
        println(response.body?.string())
    }
}