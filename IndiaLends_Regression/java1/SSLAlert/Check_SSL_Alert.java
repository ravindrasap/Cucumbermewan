package SSLAlert;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.testng.annotations.Test;

import Utility.Base;
import Utility.SMS_Send;
import Utility.Sendmail;
import models.CC_DATA;
import models.SSL_DATA;

@SuppressWarnings("unused")
public class Check_SSL_Alert {
	


	public void execute(List<SSL_DATA> empList) throws Exception {

	for (SSL_DATA data : empList) {
		
		System.out.println(data.getcertificateused());
		System.out.println("RAVI");
	}
}
}