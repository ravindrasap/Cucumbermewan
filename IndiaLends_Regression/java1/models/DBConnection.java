package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import Utility.Base;

public class DBConnection extends Base {
	
	protected static Properties properties;
	private static final int Emptype = 3;
	protected static final int Pincode =1;
	private static final int Salary = 2;
	private static final int isITR = 4;
	private static final int CompanyName = 5;
	private static final int LenderId = 6;
	private static final int Cardtype = 7;
	private static final int Mode = 8;
	private static final int Age = 9;
	private static final int SalaryMode = 10;
	private static final int UserId = 11;
	private static final int ExistingLenderId = 12;
	private static final int Icicirelation =13;
	private static final int PaySlip = 14;
	private static final int Existingaccount = 15;
	private static final int Designatione = 16;
	private static final int Maxlimit = 17;
	public static void databasecon(){
	
    String dbURL = "jdbc:sqlserver://52.172.134.136;database=ilend_uat;columnEncryptionSetting=Enabled";
	String user = "developer";
	String password = "developer@2017";
	
	 String SPURL = Base.loadPropertiesFile("SP.properties", "SPURL"); 
		System.out.println("test22");
		
		
		try {
			@SuppressWarnings("unused")
			Connection connection = DriverManager.getConnection(dbURL, user, password);
			//if (connection != null) {
			
				System.out.println("Connected to the database");
	//}
		} catch (SQLException e) {
			e.printStackTrace();
}}
}