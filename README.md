## Push Sender

A utility project to send Firebase Cloud Message notification. Supports sending `data` notifications to Android devices.

### Usage

### Project Name and Token 
Pass the project name token as input parameter to `sendPush()` of `FcmV1Sender`

### Payload
Define the payload to be sent in the `payload.json` file in the `resources/fcm/payload` folder.

### Credentials
Add `service_account.json` file(downloaded from the firebase console) in the `src/main/resources` folder for authentication. 

Once the above configurations are done, the project is ready to send out push notifications. Just run the application i.e. run the main function to send notification to the device.