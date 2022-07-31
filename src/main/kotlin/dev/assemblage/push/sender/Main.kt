package dev.assemblage.push.sender

const val SERVER_KEY = "<YOUR_SERVER_KEY>"

fun main(args: Array<String>) {
    FcmSender().sendPush(SERVER_KEY, "fcm/payload/payload.json")
}