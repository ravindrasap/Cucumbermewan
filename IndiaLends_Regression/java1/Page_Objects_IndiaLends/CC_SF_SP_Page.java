package Page_Objects_IndiaLends;
import java.math.BigDecimal;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.SQLType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;
import java.util.zip.Inflater;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import Utility.Base;
import models.UserData;
public class CC_SF_SP_Page extends Base {
	protected static Properties properties;
	private static int office = 7;
	private static int card_type = 9;
	private static int campaign = 10;
	private static int track_url = 11;
	private static int ip_address= 12;
	private static int platform_id =13;
	private static int lead_type=14;
	private static int employment_status=15;
	private static int mobile_verified=16;
	private static int session_track_id=17;
	private static int created_by =18;
	private static int comments=19;
	private static int is_itr=20;
	private static int ga_client_id=21;
	private static int xsell=22;
	private static int advert_id=23;
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
	private static final String SPUR = null;
	private static final String SPURLMV = null;
	private static final String Mobile = null;
	private static final int FSTName = 1;
	private static final int LSTName = 2;
	private static final int MIdName = 3;
	private static final int EmailId = 4;
	private static final int MobileNumb = 5;
	private static final int Pinconde = 6;
	private static final int ESalary = 8;
	private static final boolean NULL = false;
	private static final String OTPval = null;
	private static final String leadunique = null;
	private static final String u_unique_user_id = null;
		//protected WebDriver driver;
//	protected static Properties properties;
	
	@SuppressWarnings("null")
	public static void main(String[] args) throws Exception {
		
		ArrayList<UserData> data = GetList();
 
		String dbURL = "jdbc:sqlserver://52.172.134.136;databaseName=ilend_uat;columnEncryptionSetting=Enabled;";
		String user = "developer";
		String password = "developer@2017";
		
	   @SuppressWarnings("unused")
	  String pincode = loadPropertiesFile("CC_SP_Data.properties", "pincode");
	   String FName = loadPropertiesFile("CC_SP_Data.properties", "FName");
	   String LName = loadPropertiesFile("CC_SP_Data.properties", "LName");
	  
	//	BigDecimal bd1 = new BigDecimal(5000.00); 
		
		// System.out.println("bd1 " + bd1);SPURLMV
		 
	   String SPLEADTRCK = Base.loadPropertiesFile("SP.properties", "SPLEADTRCK"); 
	   String SPURLMV = Base.loadPropertiesFile("SP.properties", "SPURLMV"); 
	   String PSTMTINSRT = Base.loadPropertiesFile("SP.properties", "PSTMTINSRT"); 
	   String SPCCLenderEng = Base.loadPropertiesFile("SP.properties", "SPCCLenderEng");
	   
		System.out.println("test rr");

		try {
			Connection connection = DriverManager.getConnection(dbURL, user, password);
			if (connection != null) {
				System.out.println("Connected to the database");
				try {

					CallableStatement pstmt = connection
							.prepareCall(SPLEADTRCK);
						//	.prepareCall(SPURLMV);
									
					for (int i = 0; i < data.size(); i++) {
						if (data.get(i).getPincode() != null) {
							
							pstmt.registerOutParameter("lead_track_id", java.sql.Types.VARCHAR); 	/// Data read from DB output @lead_track_id      output,
							pstmt.registerOutParameter("lead_unique_id", java.sql.Types.VARCHAR);// @lead_unique_id     output,
							pstmt.setString("first_name", "Test");  
							pstmt.setString("last_name", "User");
							pstmt.setString ("middle_name","");  
							pstmt.setString("email_id", "test@test.com"); // email id
							pstmt.setString("mobile_number", "6734567830"); //-- mobile no
							pstmt.setString("res_pin_code", "110045");
							pstmt.setString("ofc_name" , "Office");
							pstmt.setDouble("monthly_salary", 50000);
							pstmt.setInt("card_type", 102);
							pstmt.setString("campaign", "Direct");
							pstmt.setString("track_url", "/credit-card/hdfc-bank-credit-card/");
							pstmt.setString("ip_address", "14.98.77.82");
							pstmt.setInt("platform_id", 1);
							pstmt.setInt("lead_type", 3); 
							pstmt.setInt("employment_status", 0);
							pstmt.setInt("mobile_verified", 1);
							pstmt.setString("session_track_id", "");
							pstmt.setInt("created_by", 0);
							pstmt.setString("comments", "");
							pstmt.setInt("is_itr", 0);
							pstmt.setString("ga_client_id", "Null");
							pstmt.setInt("xsell", 0);
							pstmt.setString("advert_id", "Null");
							
							
						//	 rs = pstmt.executeQuery();
						//	boolean rs = pstmt.execute();
						   boolean result=   pstmt.execute();
					      String  leadunique = pstmt.getString("lead_unique_id");
					      System.out.println(leadunique);
				    	//   System.out.println("lead_unique_id " + pstmt.getString("lead_unique_id"));
						 
				        MobileOtpcreation(dbURL, user, password,SPURLMV);
				    	   
				        OTPreader(OTPval);
				            
				 	 MobileOtpVerification(dbURL, user, password,SPURLMV,OTPval);						   
						
				 Usercreation(dbURL, user, password,leadunique);
				 	 
				 Insert_Lead_Details(dbURL, user, password, PSTMTINSRT, leadunique);
					
					 SortFormEngine(dbURL,user,password,leadunique,u_unique_user_id);
					
				//	 PANFormEngine(dbURL,user,password,leadunique,u_unique_user_id);
					 
					 
					 
								
						/*	while (result || true)	{
								// System.out.println("v_code " + pstmt.getString("v_code"));
								
					    	   System.out.println("lead_track_id " + pstmt.getString("lead_track_id")); 
					    	   System.out.println("lead_unique_id " + pstmt.getString("lead_unique_id"));
					    	  
					        	break;	  
						
					        	
					        }*/
					        }
							}
							pstmt.close();

						} finally {
							connection.close();
						}

					} else {
						System.out.println("not able to Connect database");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
							
							
	
	private static void PANFormEngine(String dbURL, String user, String password, String leadunique2,
			String uUniqueUserId) {
		// TODO Auto-generated method stub
		
	}



	private static void Prc_Create_User(String dbURL, String user, String password, String leadunique) throws SQLException {
		
		 String PSTMTI = Base.loadPropertiesFile("SP.properties", "SPUSERCR"); 
					
			ArrayList<UserData> data = GetList();
			Connection connection = null;
			try {
				connection = DriverManager.getConnection(dbURL, user, password);
					
					CallableStatement pstmt = connection
						.prepareCall(PSTMTI);
				
			
				for (int i = 0; i < data.size(); i++) {
					if (data.get(i).getPincode() != null) {
						System.out.println(leadunique);		
						
					   pstmt.setString("u_mobile_number", "6734567830");
						pstmt.setString("g_lead_id", leadunique);
						
						pstmt.setInt("mode", 2);
						pstmt.setString("type", leadunique);
						pstmt.setString("g_lead_id", leadunique);
						
						pstmt.setString("email_id_plain", "test@test.com");
							
						boolean result = pstmt.execute();
						
						System.out.println(result);					
					}
				}
				       pstmt.close();
											
						} finally {
						connection.close();
						  }

						}



	public static void Usercreation(String dbURL, String user, String password, String leadunique) throws SQLException {
			// TODO Auto-generated method stub
		
		 String SPURSER = Base.loadPropertiesFile("SP.properties", "PSUSERCR"); 
	
		ArrayList<UserData> data = GetList();
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(dbURL, user, password);
				
				CallableStatement pstmt = connection
					.prepareCall(SPURSER);
			
		
			for (int i = 0; i < data.size(); i++) {
				if (data.get(i).getPincode() != null) {
					System.out.println(leadunique);					
				   pstmt.setString("u_mobile_number", "6734567830");
					pstmt.setString("g_lead_id", leadunique);
					
					pstmt.setString("email_id_plain", "test@test.com");
						
					boolean result = pstmt.execute();
					
					System.out.println(result);		
			    	//  System.out.println("v_code " + pstmtMv.getInt("v_code"));
			//		boolean result =pstmt.execute();
			    	  // System.out.println("v_code " + pstmtMv.getInt("v_code"));			
			 					// System.out.println("is_eligible " + result.getInt("is_eligible"))
									
//					 }
						}
			}
			       pstmt.close();
										
					} finally {
					connection.close();
					  }

					}

                
	public static void OTPreader(String OTPval)throws Exception {
		
		String mobileNo = "6734567830";
		URL urlForGetRequest = new URL("https://uatweb.indialends.com/internal/a/get_otp_mail_verify_api.ashx?mobileno="+mobileNo+"&mode=0");
        String readLine = null;
        HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
        conection.setRequestMethod("GET");
      //  conection.setRequestProperty("userId", "a1bcdef"); // set userId its a sample here
        int responseCode = conection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(
                new InputStreamReader(conection.getInputStream()));
            StringBuffer response = new StringBuffer();
            while ((readLine = in .readLine()) != null) {
                response.append(readLine);
            } in .close();
            // print result
         //   System.out.println("JSON String Result " + response.toString());
            String value=response.toString();
            String[] otp=value.split("otp_code");
            String value1=otp[1];
            String numberOnly= value1.replaceAll("[^0-9]", "");
            System.out.println(numberOnly);
            
        } else {
            System.out.println("GET NOT WORKED");
        }
    }
		

       //=============// OTP Creation =============
	public static void MobileOtpcreation(String dbURL, String user, String password, String SPURLMV) throws SQLException {
		// TODO Auto-generated method stub
	

		ArrayList<UserData> data = GetList();
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(dbURL, user, password);
			PreparedStatement pstmtMv =  connection
				.prepareStatement(SPURLMV);
			
		
			for (int i = 0; i < data.size(); i++) {
				if (data.get(i).getPincode() != null) {
					
					
					pstmtMv.setString(1, "6734567830");
					pstmtMv.setString(2, "6734567830");
					
					pstmtMv.setInt(3, 279877);  // need to discusssed with yogesh
					pstmtMv.setInt(4,0);
					pstmtMv.setInt(5, 77);
					pstmtMv.setString(6, "test@test.com");
					
					ResultSet	rs = pstmtMv.executeQuery();
					
					
				   //   System.out.println(metadata.get));//(i1));
				      ArrayList<String> alist=new ArrayList<String>();
				   //   alist.add("mode");
				  		
				    }
					
					
				
					}
					
			       pstmtMv.close();
										
					} finally {
					connection.close();
					  }
	}

  // 2nd SP		//  Mobile verification SP
	@SuppressWarnings("unused")
	public static void MobileOtpVerification(String dbURL, String user, String password,String SPURLMV,String OTPval ) throws SQLException {
		int isVerified =0;
		ArrayList<UserData> data = GetList();
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(dbURL, user, password);
				
				CallableStatement pstmtMv = connection
					.prepareCall(SPURLMV);
			
		
			for (int i = 0; i < data.size(); i++) {
				if (data.get(i).getPincode() != null) {
											
				   pstmtMv.setString("mobileno", "6734567830");
					pstmtMv.setString("u_mobile_number", "6734567830");
					
					pstmtMv.setInt("v_code", 279877);  // need to discusssed with yogesh
					pstmtMv.setInt("mode",2);
					pstmtMv.setInt("p_mode", 77);
					pstmtMv.setString("emailid", "test@test.com");
					
						
					boolean result = pstmtMv.execute();
			    	//  System.out.println("v_code " + pstmtMv.getInt("v_code"));
			//		boolean result =pstmt.execute();
			    	  // System.out.println("v_code " + pstmtMv.getInt("v_code"));			
			 					// System.out.println("is_eligible " + result.getInt("is_eligible"))
									
//					 }
						}
			}
			       pstmtMv.close();
										
					} finally {
					connection.close();
					  }

					}

	
	

// # //===========3 SP Insert the lead  ====================
	
	public static void Insert_Lead_Details(String dbURL, String user, String password, String leadunique, String PSTMTINSRT) throws SQLException {
		 String PSTMTINSRT1 = Base.loadPropertiesFile("SP.properties", "PSTMTINSRT"); 
			ArrayList<UserData> data = GetList();
			Connection connection = null;
			try {
				
				connection = DriverManager.getConnection(dbURL, user, password);
					CallableStatement pstmt = connection
						.prepareCall(PSTMTINSRT1);
						
				for (int i = 0; i < data.size(); i++) {
					if (data.get(i).getPincode() != null) {
						
						pstmt.registerOutParameter("u_unique_user_id", java.sql.Types.VARCHAR); 
					
						System.out.println(PSTMTINSRT);
						pstmt.setString("lead_unique_id",PSTMTINSRT); 
					//	pstmt.setString("lead_unique_id", "86890E7B-EEDC-4EE9-803D-5BAF31A0C439"); //  need to pass the same Unique id
						pstmt.setString("card_type", "102");
						pstmt.setString("mobile_number_plain", "6734567830");
						pstmt.setInt("platform_id", 1);
						pstmt.setInt("is_cross_sell", 0);
						pstmt.setInt("PL_admin_id", 0);
						pstmt.setInt("last_admin_id", 0);
						pstmt.setInt("is_new", 0);
						pstmt.setInt("is_user_journey", 0);
						
						boolean result=   pstmt.execute();
						
										
						String  u_unique_user_id = pstmt.getString("u_unique_user_id");	
						System.out.println(u_unique_user_id);
					//	 String  leadunique = pstmt.getString("lead_unique_id");
				//	result = pstmt.execute();
						System.out.println("u_unique_user_id " + pstmt.getString("u_unique_user_id")); 
					
						 while(result || true) {
						//		while (result1.next()) {
						
							 break;
						//	System.out.println("u_unique_user_id " + result1.getInt("u_unique_user_id"));
								
							 }
						 
						}
					
					}
				
					pstmt.close();											
				} 
				finally {
						connection.close();
				}
			}

	
	
	
	
	// ===============5th SP of Sort form eligibility  =================//
	
	
	public static void SortFormEngine(String dbURL, String user, String password, String leadunique, String u_unique_user_id) throws SQLException {
	
		String SPCCLenderEng1 = Base.loadPropertiesFile("SP.properties", "SPCCLenderEng"); 
		ArrayList<UserData> data = GetList();
		Connection connection = null;
		try {
			
			connection = DriverManager.getConnection(dbURL, user, password);
				CallableStatement pstmt = connection
					.prepareCall(SPCCLenderEng1);
					
			for (int i = 0; i < data.size(); i++) {
				if (data.get(i).getPincode() != null) {
					
					//pstmt.registerOutParameter("u_unique_user_id", java.sql.Types.VARCHAR); 
					System.out.println("Ravindra");
					
					System.out.println(leadunique);
					System.out.println(u_unique_user_id);
					pstmt.setString("mode", "1"); //  
					pstmt.setString("lead_unique_id", leadunique);
					pstmt.setString("lender_id", "1");
					pstmt.setInt("card_type", 102);
					pstmt.setString("u_g_user_id", u_unique_user_id);// how to get the G_user Id
					pstmt.setInt("is_cross_sell", 0);
					pstmt.setInt("platform_id", 1);
					pstmt.setInt("vc", 0);
					pstmt.setInt("is_insert", 0);
					pstmt.setInt("iscardSpecific", 1);
					pstmt.setString("old_flow_sf", "");
										
					boolean result= pstmt.execute();
			
					System.out.println(result);
					
					 while(result || true) {
					
							System.out.println("PAss");
							 break;
					//		while (result1.next()) {
					//	System.out.println("u_unique_user_id " + result1.getInt("u_unique_user_id"));
								// System.out.println("is_user_journey " + result.getInt("lead_unique_id"));
						// System.out.println("u_unique_user_id " + pstmt.getString("u_unique_user_id")); 
				 		}
					}
				}
				pstmt.close();											
			} 
			finally {
					connection.close();
			}

		
		
	}

	
	
// Lead tracking SP			

		@SuppressWarnings("unused")
	public static ArrayList<UserData> GetList() {
		ArrayList<UserData> userdatas = new ArrayList<UserData>();
		FileInputStream file = null;
		try {
			file = new FileInputStream(System.getProperty("user.dir") + "//src//test//resources//Excel_Data_Provider//"
					+ "Test_Data.xlsx");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		XSSFWorkbook workbook = null;
		try {
			workbook = new XSSFWorkbook(file);
		} catch (IOException e) {
			e.printStackTrace();
		}

		XSSFSheet sheet = workbook.getSheetAt(2);

		int totalNumberofRows = sheet.getPhysicalNumberOfRows();
		int totalNumberofcoll = sheet.getDefaultColumnWidth();
		for (int i = 1; i < totalNumberofRows; i++) {
			int totalNumberOfCells = sheet.getRow(i).getPhysicalNumberOfCells();
			UserData data = new UserData();
			
			for (int j = 0; j < totalNumberOfCells; j++) {
				XSSFCell cell = sheet.getRow(i).getCell(j);
				try {
					
					switch (j) {
					case 0:
						data.setPincode(cell.getStringCellValue());
						break;
					case 1:
					//	data.setSalary(Integer.parseInt(cell.getStringCellValue()));
						data.setSalaryMode(cell.getStringCellValue());
						break;
					case 2:
						data.setCompany(cell.getStringCellValue());
						break;
					case 3:
						data.setEmployeetype((int) cell.getNumericCellValue());
						break;
					case 4:
						data.setITR((int) cell.getNumericCellValue());
						break;
					case 5:
						data.setLenderId((int)cell.getNumericCellValue());		
						break;
					case 6:
						data.setCardtype ((int)cell.getNumericCellValue());
						break;
					case 7:
						data.setMode((int)cell.getNumericCellValue());
						
					case 8:
						data.setAge ((int)cell.getNumericCellValue());
						break;
					case 9:
						data.setSalaryMode(cell.getStringCellValue());
						break;	
					case 10:
						data.setUserId ((int)cell.getNumericCellValue());
						break;
					case 11:
						data.setExistingLenderId (cell.getStringCellValue());
						break;
					case 12:
						data.setIcicirelation((int) cell.getNumericCellValue());
						break;
						
					case 14:
						data.setPaySlip((int) cell.getNumericCellValue());
						break;
						
					case 15:
						data.setExisting_account((int) cell.getNumericCellValue());
						break;
						
					case 16:
						data.setDesignation(cell.getStringCellValue());
						break;
						
					case 17:
						data.setMax_limit(cell.getStringCellValue());
						break;
						
						
						//default:
						//	break;
							//throw new Exception("Data Found");
						
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			userdatas.add(data);
			
		}
		return userdatas;
		
	}
	public void getSPURL() {
		String SPURL = loadPropertiesFile("SP.properties", "SPURL");
		System.out.println("SPURL Value is " + SPURL);
		driver.get(SPURL);
	}
	public static String loadPropertiesFile(String FileName, String Key) {
		String URL_Value = "";
		File file = new File(System.getProperty("user.dir")
				+ "//src//test//resources//Config_Data_Provider//" + FileName);
		try {
			FileInputStream fis = new FileInputStream(file);
			properties = new Properties();
			properties.load(fis);
			URL_Value = properties.getProperty(Key);
		} catch (Exception e) {

			System.out.println("Exception message is " + e.getMessage());
		}

		return URL_Value;
	}
	
	
	
}
