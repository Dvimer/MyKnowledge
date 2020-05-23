import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import lombok.val;

import java.io.FileInputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, FirebaseMessagingException {
        FileInputStream serviceAccount =
                new FileInputStream("/Users/dvimer/Project/Own/MyKnowledge/firebase/src/main/resources/path/to/serviceAccountKey.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://firsttest-24a39.firebaseio.com")
                .build();


        FirebaseApp.initializeApp(options);
                sendMessage();

    }

    private static void sendMessage() throws FirebaseMessagingException {
        val message = createMessage();
        String response = FirebaseMessaging.getInstance().send(message);
        System.out.println("Successfully sent message: " + response);
    }

    private static Message createMessage() {
        // This registration token comes from the client FCM SDKs.
        String registrationToken = "dXdG-b6CTfg:APA91bHAvMGaQivHHrZeqnilTeVWMU7BAIrJYp3sU53rCrCfSnujeMSWAmRTJ_gG9f_JS69CJW2awnqVwiOGq3rAp29Ku9Eb9Ay-63bVzaI2ay2TwfLXixKsmXtVc7lyI2SDTKdNZfb1";
        return Message.builder()
                .setNotification(Notification.builder().setBody("hggghg").build())
                .putData("score", "850")
                .putData("time", "2:45")
                .setToken(registrationToken)
                .build();
    }
}
