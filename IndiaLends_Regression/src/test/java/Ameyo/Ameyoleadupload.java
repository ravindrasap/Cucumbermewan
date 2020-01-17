package Ameyo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.testng.annotations.Test;

import Utility.Base;
import Utility.SMS_Send;
import Utility.SendmailSSL;

public class Ameyoleadupload {
	 String dbURL = Base.loadPropertiesFile("AmeyoDB.properties", "URL");
	 String user = Base.loadPropertiesFile("AmeyoDB.properties", "user");
	 String password = Base.loadPropertiesFile("AmeyoDB.properties", "password");
	
	@Test
	public void verify_Lealupload_result() {
		System.out.println("==========================  Start alert when lead count more than 100 lead not uploaded in Ameyo  =========================");
		try {
			Connection connection = DriverManager.getConnection(dbURL, user, password);
			if (connection != null) {
				System.out.println("Connected to the database");
				try {
		
					CallableStatement pstmt = connection.prepareCall("{call PrcGetAmeyoUploadStatus()}");

					ResultSet result = pstmt.executeQuery();
               // Will send the alert when lead count more than 100 lead not uploaded in Ameyo  and status is zero ////////////////
					while(result.next()){
                    System.out.println("NotUploadedCount"+result.getObject("NotUploadedCount"));
                    int leadcount = (int) result.getObject("NotUploadedCount");
                    int  Alrtlet = 100;
                    if (leadcount > Alrtlet) {
                    	
                     SendmailSSL.sendmail("Ameyo API is not working,Lead not uploaded in Ameyo: lead count" + leadcount);
                    }
                    	
                    System.out.println(leadcount);
                    System.out.println("==========================  END uploaded in Ameyo  ========================="); 
					}
				}
				
				finally {
					connection.close();
				}

			} 
		} catch (SQLException e) {
			System.out.println("Exception is:" + e.getMessage());
			e.printStackTrace();
		}

	}

	
}
