## Push Sender

A utility project to send Firebase Cloud Message notification. Supports sending `data` notifications to Android devices.

### Usage

### Tokens
Add the token(s) to the `tokens.json` file in the `resources/fcm` folder.

### Payload
Define the payload to be sent in the `payload.json` file in the `resources/fcm/payload` folder.

### Server Key
Set the server key for sending the push notification in the `Main.kt` file, use the defined constant in the file.

```kotlin
const val SERVER_KEY ="<YOUR_FCM_SERVER_KEY>"
```
Once the above configurations are done, the project is ready to send out push notifications. Just run the application i.e. run the main function to send notification to the device.