package models;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.HttpURLConnection;
import javax.net.ssl.HttpsURLConnection;

import org.json.JSONObject;
import org.testng.annotations.Test;

public class CRAnalysisAPI {
	@Test
	public void API_verify_AE_certificate() throws Exception {

		
		System.out.println("================Verify IL API Ae certificate Start ===========================");
		String result = "";
		int responseCode = 200;
		// String url =
		// "https://mobileapi-live.indialends.com/api/creditreport/Ex_state_mapping";
		String url = " http://ilcrapiuat-ea.azurewebsites.net/api/CreditReportAnalysis/newReco?u_g_user_id=9B98C30F-4C8B-481A-882A-F814DDAAF1D5";
	//	String postparam = "{\"mobile_number\":\"7373334633\"}";
		URL obj = new URL(url);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

		// add reuqest header
		con.setRequestMethod("GET");
		con.setRequestProperty("Content-Type", "application/json");
		con.setRequestProperty("RoleValue", "IL");

		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
	//	wr.write(postparam.getBytes());
		wr.flush();
		wr.close();

		responseCode = con.getResponseCode();

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		// print result
		String s = response.toString();
		System.out.println(s);

		JSONObject obj1 = new JSONObject(s);
		JSONObject info = obj1.getJSONObject("accountListCCReco");
		
		int status=info.getInt("status");
	    
		String SubscriberName = info.getString("SubscriberName");
		
		
		String msg=info.getString("message");
		System.out.println(status);
		System.out.println(msg);

		
		 if (status == 100) { 
			result = "Certificate of API" +url+ "is working fine and status is:"+status;
		    //System.out.println(result);
		   // SendMail.sendmail(result); 
		  } else { 
			//result = "Certificate failure of API" +url+ "Now status is: " +status+" Message is :"+msg;
			System.out.println(result);
		   // SendMail.sendmail(result); 
		    }
		 System.out.println("================Verify  API output End ===========================");
				 
	}


}
