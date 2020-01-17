package Utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.commons.codec.binary.Base64;

public class SMS_Alert {

	public static void sendsms(String message) {

        try {
            String phoneNumber = "917875505834";
            String appKey = "cpnYV2cSoUyvGdjKFa63dg";
            String appSecret = "INDLNS";
           // String message = "Helloworld!";

            URL url = new URL("https://www.smsgatewayhub.com/api/mt/SendSMS?APIKey="+appKey+"&senderid=INDIAL&channel=2&DCS=0&flashsms=0&number="+phoneNumber+"&text="+message+"&route=Normal");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");

            String userCredentials = "application\\" + appKey + ":" + appSecret;
            byte[] encoded = Base64.encodeBase64(userCredentials.getBytes());
            String basicAuth = "Basic " + new String(encoded);
            connection.setRequestProperty("Authorization", basicAuth);

            String postData = "{\"Message\":\"" + message + "\"}";
            OutputStream os = connection.getOutputStream();
            os.write(postData.getBytes());

            StringBuilder response = new StringBuilder();
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String line;
            while ( (line = br.readLine()) != null)
                response.append(line);

            br.close();
            os.close();

            System.out.println(response.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
	public static void sendsms(String message,String phoneNumber) {

        try {
           
            String appKey = "cpnYV2cSoUyvGdjKFa63dg";
            String appSecret = "INDLNS";
           // String message = "Helloworld!";

            URL url = new URL("https://www.smsgatewayhub.com/api/mt/SendSMS?APIKey="+appKey+"&senderid=INDIAL&channel=2&DCS=0&flashsms=0&number="+phoneNumber+"&text="+message+"&route=Normal");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");

            String userCredentials = "application\\" + appKey + ":" + appSecret;
            byte[] encoded = Base64.encodeBase64(userCredentials.getBytes());
            String basicAuth = "Basic " + new String(encoded);
            connection.setRequestProperty("Authorization", basicAuth);

            String postData = "{\"Message\":\"" + message + "\"}";
            OutputStream os = connection.getOutputStream();
            os.write(postData.getBytes());

            StringBuilder response = new StringBuilder();
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String line;
            while ( (line = br.readLine()) != null)
                response.append(line);

            br.close();
            os.close();

            System.out.println(response.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}