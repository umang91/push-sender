## Push Sender

A utility project to send Firebase Cloud Message notification. Supports sending `data` notifications to Android devices.

### Usage

### Project Name and Firebase Installation Ids 
Enter the project name and Firebase Installation Id(s) in the `fcm_config.json` and set the file path as an environment variable with the variable name as `PUSH_SENDER_CONFIG`.
Alternatively, for local testing you could create a `fcm_config_local.json` and do the same thing.

### Payload
Define the payload to be sent in the `payload.json` file in the `resources/fcm/payload` folder.

### Credentials
Add `service_account.json` file(downloaded from the firebase console) in the `resources` folder for authentication. 

Once the above configurations are done, the project is ready to send out push notifications. Just run the application i.e. run the main function to send notification to the device.