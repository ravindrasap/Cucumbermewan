package CRM;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.testng.annotations.Test;

import Utility.Base;

@Test
public class GetDBValue {

	String dbURL = Base.loadPropertiesFile("DB.properties", "URL4");
	String user = Base.loadPropertiesFile("DB.properties", "user4");
	String password = Base.loadPropertiesFile("DB.properties", "password4");

	public String fetchDbValue(String mobile) {
		String encryptkey = null;
		int admin_id = 0;
		try {

			Connection connection = DriverManager.getConnection(dbURL, user, password);
			if (connection != null) {
				System.out.println("Connected to the database");
				try {

					String query = "select * from admin_leads_object where l_mobile_no= " + "'" + mobile + "'";
					PreparedStatement pstmtmv = connection.prepareStatement(query);

					ResultSet result = pstmtmv.executeQuery();

					while (result.next()) {
						admin_id = (Integer) result.getObject("admin_id");
						System.out.println("Admin id is: "+result.getObject("admin_id"));
					}

					String query1 = "select dbo.Encrypt(" + admin_id + ")";
					PreparedStatement pstmtmv1 = connection.prepareStatement(query1);

					ResultSet result1 = pstmtmv1.executeQuery();

					while (result1.next()) {
						encryptkey = (String) result1.getObject(1);
						System.out.println("Admin id encrypt key is :"+result1.getObject(1));
					}

					pstmtmv.close();

				}

				finally {
					connection.close();
				}

			} else {
				System.out.println("not able to Connect database");
			}
		} catch (SQLException e) {
			System.out.println("Exception is:" + e.getMessage());
			e.printStackTrace();
		}
		return encryptkey;
	}

}
