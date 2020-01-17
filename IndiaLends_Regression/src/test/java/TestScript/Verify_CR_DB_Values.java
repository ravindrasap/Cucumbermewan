package TestScript;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.testng.annotations.Test;

import Utility.Base;

@Test
public class Verify_CR_DB_Values {
	
	String dbURL = Base.loadPropertiesFile("DB.properties", "URL");
	String user = Base.loadPropertiesFile("DB.properties", "user");
	String password = Base.loadPropertiesFile("DB.properties", "password");

	public void fetchDbValue(String mobile) {
		
		try {

			Connection connection = DriverManager.getConnection(dbURL, user, password);
			if (connection != null) {
				System.out.println("Connected to the database");
				try {

					String query = "select * from user_information where u_mobile_number= " + "'" + mobile + "'";
					PreparedStatement pstmtmv = connection.prepareStatement(query);

					ResultSet result = pstmtmv.executeQuery();
					
					ResultSetMetaData rsmd = result.getMetaData();
					  
				      System.out.println("");
				  
				      int numberOfColumns = rsmd.getColumnCount();

					while (result.next()) {
						System.out.println("UserId is: "+result.getObject("u_user_id"));
						 for (int i = 1; i <= numberOfColumns; i++) {
					          if (i > 1) System.out.print(",  ");
					          String columnValue = result.getString(i);
					          System.out.print(columnValue);
					        }
					        System.out.println("");  
						
						
					}

			/*		String query1 = "select dbo.Encrypt(" + admin_id + ")";
					PreparedStatement pstmtmv1 = connection.prepareStatement(query1);

					ResultSet result1 = pstmtmv1.executeQuery();

					while (result1.next()) {
						encryptkey = (String) result1.getObject(1);
						System.out.println("Admin id encrypt key is :"+result1.getObject(1));
					}*/

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
		
	}


}
