package Page_Objects_IndiaLends;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.microsoft.sqlserver.jdbc.SQLServerDataTable;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import com.microsoft.sqlserver.jdbc.SQLServerPreparedStatement;

import Utility.Base;
import models.CC_DATA;
import models.ExperianCreditDetail;

public class Check_CC_Eligibility {

	private static final String OTPval = null;
	private static final int ModeOPT = 0;
	private static final String Eligibilitymode = null;
	public static int Eligibility;
	static String per_street = null;
	static int DiscardSpecific11 = 0;
	public static String u_unique_user_id = "";
	// private static final String ShortMode = null;
	String dbURL = Base.loadPropertiesFile("DB.properties", "dbURL");
	String user = Base.loadPropertiesFile("DB.properties", "user");
	String password = Base.loadPropertiesFile("DB.properties", "password");
	String SPLEADTRCK = Base.loadPropertiesFile("SP.properties", "SPLEADTRCK");
	String SPURLMV = Base.loadPropertiesFile("SP.properties", "SPURLMV");
	String PSTMTINSRT = Base.loadPropertiesFile("SP.properties", "PSTMTINSRT");
	String SPCCLenderEng1 = Base.loadPropertiesFile("SP.properties", "SPCCLenderEng");
	String SPPANFORM1 = Base.loadPropertiesFile("SP.properties", "SPPANFORM");
	static String email_id = Base.loadPropertiesFile("CC_Data.properties", "email_id");
	static String v_code1 = Base.loadPropertiesFile("CC_Data.properties", "v_code");
	static int v_code = Integer.parseInt(v_code1);
	static String Pmode1 = Base.loadPropertiesFile("CC_Data.properties", "Pmode");
	static int Pmode = Integer.parseInt(Pmode1);
	static String Panmode1 = Base.loadPropertiesFile("CC_Data.properties", "Panmode");
	static int Panmode = Integer.parseInt(Panmode1);
	static String DiscardSpecific1 = Base.loadPropertiesFile("CC_Data.properties", "DiscardSpecific");
	static int DiscardSpecific = Integer.parseInt(DiscardSpecific1);

	static String sMode = Base.loadPropertiesFile("CC_Data.properties", "Smode");
	static String Eligibilitymode1 = Base.loadPropertiesFile("CC_Data.properties", "Eligibilitymode");
	static int Eligimode = Integer.parseInt(Eligibilitymode1);

	static String vc1 = Base.loadPropertiesFile("CC_Data.properties", "vc");
	static int vc = Integer.parseInt(vc1);
	static String lender_id = Base.loadPropertiesFile("CC_Data.properties", "lender_id");
	static String pannumber = Base.loadPropertiesFile("CC_Data.properties", "pannumber");
	static String pan_number_encrypt = Base.loadPropertiesFile("CC_Data.properties", "pan_number_encrypt");
	static String ofc_pin_code = Base.loadPropertiesFile("CC_Data.properties", "ofc_pin_code");
	static String splatform_id1 = Base.loadPropertiesFile("CC_Data.properties", "splatform_id");
	static int splatform_id = Integer.parseInt(splatform_id1);
	static String SortMode = Base.loadPropertiesFile("CC_Data.properties", "Sortmode");
	static String is_user_journey1 = Base.loadPropertiesFile("CC_Data.properties", "is_user_journey");
	static int is_user_journey = Integer.parseInt(is_user_journey1);
	static String is_new1 = Base.loadPropertiesFile("CC_Data.properties", "is_new");
	static int is_new = Integer.parseInt(is_new1);
	static String platform_id1 = Base.loadPropertiesFile("CC_Data.properties", "platform_id");
	static int platform_id = Integer.parseInt(platform_id1);
	static String is_cross_sell1 = Base.loadPropertiesFile("CC_Data.properties", "is_cross_sell");
	static int is_cross_sell = Integer.parseInt(is_cross_sell1);
	static String PL_admin_id1 = Base.loadPropertiesFile("CC_Data.properties", "PL_admin_id");
	static int PL_admin_id = Integer.parseInt(PL_admin_id1);
	static String last_admin_id1 = Base.loadPropertiesFile("CC_Data.properties", "last_admin_id");
	static int last_admin_id = Integer.parseInt(last_admin_id1);
	static String is_insert1 = Base.loadPropertiesFile("CC_Data.properties", "is_insert");
	static int is_insert = Integer.parseInt(is_insert1);
	static String Gender1 = Base.loadPropertiesFile("CC_Data.properties", "Gender");
	static int Gender = Integer.parseInt(Gender1);
	static String salary_mode = Base.loadPropertiesFile("CC_Data.properties", "salary_mode");
	static String is_loan_cc = Base.loadPropertiesFile("CC_Data.properties", "is_loan_cc");
	static String iscardSpecific1 = Base.loadPropertiesFile("CC_Data.properties", "iscardSpecific");
	static int iscardSpecific = Integer.parseInt(iscardSpecific1);
	static String Dmarital_status1 = Base.loadPropertiesFile("CC_Data.properties", "Dmarital_status");
	static int marital_status1 = Integer.parseInt(Dmarital_status1);
	static String Deducational_qualification1 = Base.loadPropertiesFile("CC_Data.properties",
			"Deducational_qualification");
	static int educational_qualification = Integer.parseInt(Deducational_qualification1);
	static String res_house_number = Base.loadPropertiesFile("CC_Data.properties", "Dres_house_number");
	static String res_street = Base.loadPropertiesFile("CC_Data.properties", "Dres_street");
	static String res_locality = Base.loadPropertiesFile("CC_Data.properties", "Dres_locality");
	static String res_district = Base.loadPropertiesFile("CC_Data.properties", "Dres_district");
	static String res_city = Base.loadPropertiesFile("CC_Data.properties", "Dres_city");
	static String res_state = Base.loadPropertiesFile("CC_Data.properties", "Dres_state");
	static String ofc_door_number = Base.loadPropertiesFile("CC_Data.properties", "Dofc_door_number");
	static String ofc_street = Base.loadPropertiesFile("CC_Data.properties", "Dofc_street");
	static String ofc_locality = Base.loadPropertiesFile("CC_Data.properties", "Dofc_locality");
	static String ofc_district = Base.loadPropertiesFile("CC_Data.properties", "Dofc_district");
	static String ofc_city = Base.loadPropertiesFile("CC_Data.properties", "Dofc_city");
	static String ofc_state = Base.loadPropertiesFile("CC_Data.properties", "Dofc_state");
	static String is_alternate_contact_no1 = Base.loadPropertiesFile("CC_Data.properties", "Dis_alternate_contact_no");
	static int is_alternate_contact_no = Integer.parseInt(is_alternate_contact_no1);
	static String res_std_code = Base.loadPropertiesFile("CC_Data.properties", "Dres_std_code");

	static String res_landline_number = Base.loadPropertiesFile("CC_Data.properties", "Dres_landline_number");
	static String ofc_std_code = Base.loadPropertiesFile("CC_Data.properties", "Dofc_std_code");
	static String ofc_landline_number = Base.loadPropertiesFile("CC_Data.properties", "Dofc_landline_number");
	static String is_sbi_relation1 = Base.loadPropertiesFile("CC_Data.properties", "Dis_sbi_relation");
	static int is_sbi_relation = Integer.parseInt(is_sbi_relation1);

	static String sbi_relation_type1 = Base.loadPropertiesFile("CC_Data.properties", "Dsbi_relation_type");
	static int sbi_relation_type = Integer.parseInt(sbi_relation_type1);
	static String account_number = Base.loadPropertiesFile("CC_Data.properties", "Daccount_number");

	static String credit_card_number = Base.loadPropertiesFile("CC_Data.properties", "Dcredit_card_number");
	static String father_first_name = Base.loadPropertiesFile("CC_Data.properties", "Dfather_first_name");
	static String father_last_name = Base.loadPropertiesFile("CC_Data.properties", "Dfather_last_name");
	static String mother_first_name = Base.loadPropertiesFile("CC_Data.properties", "Dmother_first_name");
	static String mother_last_name = Base.loadPropertiesFile("CC_Data.properties", "Dmother_last_name");
	static String pref_mailing_address1 = Base.loadPropertiesFile("CC_Data.properties", "Dpref_mailing_address");
	static int pref_mailing_address = Integer.parseInt(pref_mailing_address1);
	static String adhaar_number = Base.loadPropertiesFile("CC_Data.properties", "Dadhaar_number");
	static String is_address_proof1 = Base.loadPropertiesFile("CC_Data.properties", "Dis_address_proof");
	static int is_address_proof = Integer.parseInt(is_address_proof1);
	static String nationality = Base.loadPropertiesFile("CC_Data.properties", "Dnationality");
	static String is_director1 = Base.loadPropertiesFile("CC_Data.properties", "Dis_director");
	static int is_director = Integer.parseInt(is_director1);
	static String is_document1 = Base.loadPropertiesFile("CC_Data.properties", "Dis_document");
	static int is_document = Integer.parseInt(is_document1);

	static String address_proof = Base.loadPropertiesFile("CC_Data.properties", "Daddress_proof");
	static String id_proof = Base.loadPropertiesFile("CC_Data.properties", "Did_proof");
	static String per_pin_code = Base.loadPropertiesFile("CC_Data.properties", "Dper_pin_code");
	static String per_house_number = Base.loadPropertiesFile("CC_Data.properties", "Dper_house_number");
	static String per_street1 = Base.loadPropertiesFile("CC_Data.properties", "Dper_street");
	static String per_locality = Base.loadPropertiesFile("CC_Data.properties", "Dper_locality");
	static String per_district1 = Base.loadPropertiesFile("CC_Data.properties", "Dper_district");
	static String per_city1 = Base.loadPropertiesFile("CC_Data.properties", "Dper_city");
	static String per_state = Base.loadPropertiesFile("CC_Data.properties", "Dper_state");
	static String dir_name = Base.loadPropertiesFile("CC_Data.properties", "Ddir_name");

	static String dir_bank_name = Base.loadPropertiesFile("CC_Data.properties", "Ddir_bank_name");
	static String dir_relationship = Base.loadPropertiesFile("CC_Data.properties", "Ddir_relationship");
	static String agent_id1 = Base.loadPropertiesFile("CC_Data.properties", "Dagent_id");
	static int agent_id = Integer.parseInt(agent_id1);

	static String existing_account1 = Base.loadPropertiesFile("CC_Data.properties", "Dexisting_account");
	static int existing_account = Integer.parseInt(existing_account1);
	static String occupation_industry1 = Base.loadPropertiesFile("CC_Data.properties", "Doccupation_industry");
	static int occupation_industry = Integer.parseInt(occupation_industry1);
	static String industryType1 = Base.loadPropertiesFile("CC_Data.properties", "DindustryType");
	static int industryType = Integer.parseInt(industryType1);
	static String totalWorkExperience1 = Base.loadPropertiesFile("CC_Data.properties", "DtotalWorkExperience");
	static int totalWorkExperience = Integer.parseInt(totalWorkExperience1);
	static String departmentName = Base.loadPropertiesFile("CC_Data.properties", "DdepartmentName");

	private static boolean size;

	public <T> void nameOf(T value, String key, CallableStatement pstmt) throws SQLException {
		pstmt.setObject(key, value);

	}

	@SuppressWarnings("unused")
	public void execute(List<CC_DATA> empList) throws Exception {

		String first_name = Base.loadPropertiesFile("CC_Data.properties", "first_name");
		String last_name = Base.loadPropertiesFile("CC_Data.properties", "last_name");
		String email_id = Base.loadPropertiesFile("CC_Data.properties", "email_id");
		String ofc_name = Base.loadPropertiesFile("CC_Data.properties", "ofc_name");
		// String company = Base.loadPropertiesFile("CC_Data.properties", "company");
		String campaign = Base.loadPropertiesFile("CC_Data.properties", "campaign");
		String URL = Base.loadPropertiesFile("CC_Data.properties", "URL");
		String ip_address = Base.loadPropertiesFile("CC_Data.properties", "ip_address");
		String platform_id1 = Base.loadPropertiesFile("CC_Data.properties", "platform_id");
		int platform_id = Integer.parseInt(platform_id1);
		String lead_type1 = Base.loadPropertiesFile("CC_Data.properties", "lead_type");
		int lead_type = Integer.parseInt(lead_type1);
		String employment_status1 = Base.loadPropertiesFile("CC_Data.properties", "employment_status");
		int employment_status = Integer.parseInt(employment_status1);

		String Mobileverificationmode = Base.loadPropertiesFile("CC_Data.properties", "Mobileverificationmode");
		int ModeOPT = Integer.parseInt(Mobileverificationmode);

		String mobile_verified1 = Base.loadPropertiesFile("CC_Data.properties", "mobile_verified");
		int mobile_verified = Integer.parseInt(mobile_verified1);

		String session_track_id = Base.loadPropertiesFile("CC_Data.properties", "session_track_id");
		String created_by1 = Base.loadPropertiesFile("CC_Data.properties", "created_by");
		int created_by = Integer.parseInt(created_by1);
		String comments = Base.loadPropertiesFile("CC_Data.properties", "comments");

		String ga_client_id = Base.loadPropertiesFile("DB.properties", "ga_client_id");
		String xsell1 = Base.loadPropertiesFile("CC_Data.properties", "xsell");
		int xsell = Integer.parseInt(xsell1);
		String advert_id = Base.loadPropertiesFile("CC_Data.properties", "advert_id");

		// System.out.println("test");
		/// Ensert the details ==========

		try {
			// String SPLEADTRCK = Base.loadPropertiesFile("SP.properties", "SPLEADTRCK");

			Connection connection = DriverManager.getConnection(dbURL, user, password);
			if (connection != null) {
				// System.out.println("Connected to the database");
				try {
					for (CC_DATA data : empList) {
						CallableStatement pstmt = connection.prepareCall(SPLEADTRCK);

						pstmt.registerOutParameter("lead_track_id", java.sql.Types.VARCHAR); /// Data read from DB ///
																								/// output

						pstmt.registerOutParameter("lead_unique_id", java.sql.Types.VARCHAR);// @lead_unique_id output,
						pstmt.setString("first_name", first_name);
						pstmt.setString("last_name", last_name);
						pstmt.setString("middle_name", "");
						pstmt.setString("email_id", email_id); // email id
						pstmt.setString("mobile_number", data.getmobileNo()); // -- mobile no
						// System.out.println(data.getmobileNo());
						pstmt.setString("res_pin_code", data.getpincode());
						// pstmt.setString("ofc_name", ofc_name);
						pstmt.setString("ofc_name", data.getofc_name());
						pstmt.setInt("monthly_salary", data.getSalary());
						pstmt.setInt("card_type", data.getCardType());
						pstmt.setString("campaign", campaign);
						pstmt.setString("track_url", URL);
						pstmt.setString("ip_address", ip_address);
						pstmt.setInt("platform_id", platform_id);
						pstmt.setInt("lead_type", lead_type);
						// pstmt.setInt("employment_status", employment_status);

						// pstmt.setInt("employment_status", employment_status);
						pstmt.setInt("employment_status", data.getEmpType());

						pstmt.setInt("mobile_verified", mobile_verified);
						pstmt.setString("session_track_id", "");
						pstmt.setInt("created_by", created_by);
						pstmt.setString("comments", "");
						pstmt.setInt("is_itr", data.getIsItr());
						pstmt.setString("ga_client_id", "ga_client_id");
						pstmt.setInt("xsell", xsell);
						pstmt.setString("advert_id", "advert_id");
						boolean result = pstmt.execute();
						String leadunique = pstmt.getString("lead_unique_id");
						data.setLeadunique(leadunique);
					//	System.out.println(leadunique);
						while (result || true) {
							// System.out.println("insert the Short form details");
							break;
						}

					}
					// pstmt.close();

				} finally {
					connection.close();
				}

			} else {
				System.out.println("not able to Connect database");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		MobileOtpcreation(dbURL, user, password, SPURLMV, empList);
		// OTPreader(empList);
		MobileOtpVerification(dbURL, user, password, SPURLMV, empList);
		Usercreation(dbURL, user, password, empList);
		Insert_Lead_Details(dbURL, user, password, PSTMTINSRT, empList);
		EligbilityProcess(dbURL, user, password, u_unique_user_id, empList);
		PANFormDetails(dbURL, user, password, u_unique_user_id, empList);
		Verify_Pan_result(dbURL, user, password, u_unique_user_id, empList);
		Detailsform(dbURL, user, password, u_unique_user_id, empList);
		Verify_Detail_result(dbURL, user, password, u_unique_user_id, empList);

	}

	//////////// Details form Eligibility verification /////////////////////////

	private void Verify_Detail_result(String dbURL, String user, String password, String u_unique_user_id,
			List<CC_DATA> empList) {

		String SPEligbility = Base.loadPropertiesFile("SP.properties", "SPDetailsFormEligibility");
		try {
			Connection connection = DriverManager.getConnection(dbURL, user, password);

			if (connection != null) {
				try {
					for (CC_DATA data : empList) {
						CallableStatement pstmt = connection.prepareCall(SPEligbility);

						pstmt.setObject("mode", Eligimode); // Eligimode
						pstmt.setString("lead_unique_id", data.getLeadunique());
						// pstmt.setString("lender_id", lender_id);
						pstmt.setString("lender_id", data.getLenderid());
						pstmt.setInt("card_type", data.getCardType());
						pstmt.setString("u_g_user_id", u_unique_user_id);// how to get the G_user Id
						pstmt.setInt("is_cross_sell", is_cross_sell);
						pstmt.setInt("platform_id", splatform_id);
						pstmt.setInt("vc", vc);
						pstmt.setInt("is_insert", is_insert);
						pstmt.setInt("iscardSpecific", DiscardSpecific);
						pstmt.setString("old_flow_sf", "");
						// }
						// boolean rs = pstmt.execute();
						boolean isResultSet = pstmt.execute();

						if (!isResultSet) {
							System.out.println("The first result is not a ResultSet.");
							return;
						}

						ResultSet res = pstmt.getResultSet();

						while (res.next()) {

							// System.out.println("lender_id"+res.getObject(1)+"card_type"+res.getObject(2)+"is_eligible"+res.getObject(3));
							int Eligibility = (res.getInt("is_eligible"));

							// System.out.println(Eligibility);
							// }

							if (Eligibility == 1) {

								System.out.println("Final Eligbility :" + Eligibility + "Status " + "PASS"
										+ " Mobile NO :" + data.getmobileNo());

							} else {

								System.out.println("Final Eligbility :" + Eligibility + "Status " + "FAIL"
										+ " Mobile NO :" + data.getmobileNo());

							}
						}

						/*
						 * res.close(); isResultSet = pstmt.getMoreResults();
						 * 
						 * if (!isResultSet) { // while (res1== true){
						 * System.out.println("The next result is not a ResultSet."); return; }
						 */

						res.close();

						pstmt.close();
					}
				} finally {
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

	//////////// PAN form Eligibility verification /////////////////////////

	public static void Verify_Pan_result(String dbURL, String user, String password, String u_unique_user_id,
			List<CC_DATA> empList) {

		String SPEligbility = Base.loadPropertiesFile("SP.properties", "PanEligbility");
		try {
			Connection connection = DriverManager.getConnection(dbURL, user, password);

			if (connection != null) {
				try {
					for (CC_DATA data : empList) {
						CallableStatement pstmt = connection.prepareCall(SPEligbility);
						pstmt.setObject("mode", Panmode); //
						pstmt.setString("lead_unique_id", data.getLeadunique());
						pstmt.setString("lender_id", lender_id);
						pstmt.setInt("card_type", data.getCardType());
						// System.out.println(data.getlenderid());
						pstmt.setString("u_g_user_id", u_unique_user_id);// how to get the G_user Id
						pstmt.setInt("is_cross_sell", is_cross_sell);
						pstmt.setInt("platform_id", splatform_id);
						pstmt.setInt("vc", vc);
						pstmt.setInt("is_insert", is_insert);
						pstmt.setInt("iscardSpecific", data.getiscardSpecific());
						pstmt.setString("old_flow_sf", "");
						// }

						boolean isResultSet = pstmt.execute();

						if (!isResultSet) {
							// System.out.println("The first result is not a ResultSet.");
							return;
						}

						ResultSet res = pstmt.getResultSet();

						while (res.next()) {
							// int Eligibility = (res.getInt("is_card_eligible")); // 03-09-2019
							// System.out.println(Eligibility);
						}
						res.close();
						isResultSet = pstmt.getMoreResults();
						if (!isResultSet) {
							System.out.println("The next result is not a ResultSet.");
							return;
						}

						// Second ReulstSet object

						res = pstmt.getResultSet();

						while (res.next()) {

							int Eligibility = (res.getInt("is_card_eligible"));

							if (Eligibility == 1) {
								// System.out.println("PAN From Eligbility :" + Eligibility + " Card Type
								// :"+data.getCardType() +" Mobile NO :"+data.getmobileNo());
								System.out.println("PAN From Eligbility :" + Eligibility + "Status " + "PASS"
										+ " Mobile NO :" + data.getmobileNo());
							} else {

								System.out.println("PAN From Eligbility :" + Eligibility + "Status " + "FAIL"
										+ " Mobile NO :" + data.getmobileNo());

							}

						}
						res.close();

						pstmt.close();

					}
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

	//////////// Third from Details /////////////////////////

	public static void Detailsform(String dbURL, String user, String password, String u_unique_user_id2,
			List<CC_DATA> empList) {
		String SPThirdform1 = Base.loadPropertiesFile("SP.properties", "SPThirdform");
		try {
			Connection connection = DriverManager.getConnection(dbURL, user, password);

			if (connection != null) {
				try {
					for (CC_DATA data : empList) {
						CallableStatement pstmt = connection.prepareCall(SPThirdform1);

						pstmt.setString("lead_unique_id", data.getLeadunique());
						pstmt.setInt("marital_status", marital_status1);
						pstmt.setInt("educational_qualification", educational_qualification);
						pstmt.setString("res_house_number", res_house_number);
						pstmt.setString("res_street", res_street);
						pstmt.setString("res_locality", res_locality);
						pstmt.setString("res_district", res_district);
						pstmt.setString("res_city", res_city);
						pstmt.setString("res_state", res_state);
						pstmt.setString("ofc_door_number", ofc_door_number); //
						pstmt.setString("ofc_street", ofc_street);
						pstmt.setString("ofc_locality", ofc_locality);
						pstmt.setString("ofc_district", ofc_district);
						pstmt.setString("ofc_city", ofc_city);
						pstmt.setString("ofc_state", ofc_state);
						pstmt.registerOutParameter("web_view_url", java.sql.Types.VARCHAR);
						pstmt.setInt("is_alternate_contact_no", is_alternate_contact_no);
						pstmt.setString("res_std_code", res_std_code);
						pstmt.setString("res_landline_number", res_landline_number);
						pstmt.setString("ofc_std_code", ofc_std_code);
						pstmt.setString("ofc_landline_number", ofc_landline_number);
						pstmt.setInt("is_sbi_relation", is_sbi_relation);
						pstmt.setInt("sbi_relation_type", data.getRelationshipwithICICI());
						// pstmt.setInt("sbi_relation_type", sbi_relation_type);
						pstmt.setString("account_number", account_number);
						pstmt.setString("credit_card_number", credit_card_number);
						pstmt.setString("father_first_name", father_first_name);
						pstmt.setString("father_last_name", father_last_name);
						pstmt.setString("mother_first_name", mother_first_name);
						pstmt.setString("mother_last_name", mother_last_name);
						pstmt.setString("designation", data.getDesignation());
						pstmt.setInt("pref_mailing_address", pref_mailing_address);
						pstmt.setString("adhaar_number", adhaar_number);
						pstmt.setInt("is_address_proof", is_address_proof);
						pstmt.setString("nationality", nationality);
						pstmt.setInt("is_director", is_director);
						pstmt.setInt("is_document", is_document);
						pstmt.setString("address_proof", address_proof);
						pstmt.setString("id_proof", id_proof);
						pstmt.setString("per_pin_code", per_pin_code);
						pstmt.setString("per_house_number", per_house_number);
						pstmt.setString("per_street", per_street1);
						String per_landmark = null;
						pstmt.setString("per_landmark", per_landmark);
						pstmt.setString("per_locality", per_locality);
						String per_district = null;
						pstmt.setString("per_district", per_district);
						String per_city = null;
						pstmt.setString("per_city", per_city);
						pstmt.setString("per_state", per_state);
						pstmt.setString("dir_name", dir_name);
						// System.out.print(dir_name);
						pstmt.setString("dir_bank_name", dir_bank_name);
						pstmt.setString("dir_relationship", dir_relationship);
						pstmt.setInt("agent_id", agent_id);
						// pstmt.setInt("existing_account", existing_account);
						pstmt.setInt("existing_account", data.getExistingHDFCAccount());
					//	int occupation_type = 0;
					//	pstmt.setInt("occupation_type", occupation_type);
					//	pstmt.setInt("occupation_industry", occupation_industry);
					//	pstmt.setInt("industryType", industryType);
					//	pstmt.setInt("totalWorkExperience", totalWorkExperience);
					//	pstmt.setString("departmentName", departmentName);
					//	pstmt.setInt("residenceType", data.getResidentType());

						// }

						boolean result = pstmt.execute();
						while (result || true) {
							// System.out.println("Details form ");
							break;
						}

						pstmt.close();
					}
				} finally {
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

	//////////// Short form Eligibility verification /////////////////////////

	public static void EligbilityProcess(String dbURL, String user, String password, String u_unique_user_id,
			List<CC_DATA> empList) throws SQLException {

		String SPEligbility = Base.loadPropertiesFile("SP.properties", "SPEligbility");
		try {
			Connection connection = DriverManager.getConnection(dbURL, user, password);

			if (connection != null) {
				try {
					for (CC_DATA data : empList) {

					//	SQLServerPreparedStatement pstmt = (SQLServerPreparedStatement)connection.prepareStatement(SPEligbility);
		
						
						 CallableStatement pstmt = connection.prepareCall(SPEligbility);
							/*pstmt.setString("mode", sMode); //
							pstmt.setString("lead_unique_id", data.getLeadunique());
							pstmt.setString("lender_id", "0");
						//	pstmt.setString("lender_id", data.getlenderid());
							pstmt.setInt("card_type", 0);						
							pstmt.setString("u_g_user_id", "u_g_user_id");// how to get the G_user Id
							pstmt.setInt("is_cross_sell", 0);
							pstmt.setInt("platform_id", splatform_id);
							pstmt.setInt("vc", vc);
							pstmt.setInt("is_insert", is_insert);
							pstmt.setObject("iscardSpecific", null); //
											
							pstmt.setString("old_flow_sf", null);*/
						
							
						
						
						
						
						// this is for all flow =========================

						
						  pstmt.setString("mode", sMode); 
						 pstmt.setString("lead_unique_id", data.getLeadunique());
						   pstmt.setString("lender_id", lender_id);
						  pstmt.setInt("card_type", data.getCardType());
						   pstmt.setString("u_g_user_id", u_unique_user_id);// how to get the G_user Id 
						   pstmt.setInt("is_cross_sell",is_cross_sell); 
						   pstmt.setInt("platform_id", splatform_id); 
						   pstmt.setInt("vc",vc);
						    pstmt.setInt("is_insert", is_insert);
						     pstmt.setInt("iscardSpecific",data.getiscardSpecific());
						      pstmt.setString("old_flow_sf", "");
						
						// }

						// this is for the only YES bank new recco for the lender based

						/*pstmt.setString(1, sMode); //
						pstmt.setString(2, data.getLeadunique());
						pstmt.setString(3, lender_id);
						pstmt.setInt(4, data.getCardType());
						pstmt.setString(5, u_unique_user_id);// how to get the G_user Id
						pstmt.setInt(6, is_cross_sell);
						pstmt.setInt(7, splatform_id);
						pstmt.setInt(8, vc);
						pstmt.setInt(9, is_insert);
						pstmt.setInt(10, data.getiscardSpecific());
						pstmt.setString(11, "");
						pstmt.setObject(12, "UdtExperianCreditDetail");
						SQLServerDataTable ruleDataTable = getRuleDataTableCC();
						pstmt.setStructured(12, "dbo.PqCCLogsType", ruleDataTable);
						pstmt.setString(13, "");
						pstmt.setString(14, "");
*/
						boolean isResultSet = pstmt.execute();

						/*
						 * if (!isResultSet) {
						 * System.out.println("The first result is not a ResultSet."); return; }
						 */
						ResultSet res = pstmt.getResultSet();

						/*
						 * while (res.next()) { //
						 * System.out.println(" lender_id "+res.getInt("lender_id") } res.close();
						 */
						isResultSet = pstmt.getMoreResults();
						/*
						 * if (!isResultSet) {
						 * 
						 * return; }
						 */

						////////////// Second ReulstSet object /////////////////////

						res = pstmt.getResultSet();

						while (res.next()) {

							// System.out.println("lender_id"+res.getObject(1)+"card_type"+res.getObject(2)+"card_eligibile"+res.getObject(3));
							int Eligibility = (res.getInt("is_card_eligible"));

							if (Eligibility == 1) {

								System.out.println("Short Form Eligbility :" + Eligibility + "Status " + "PASS"
										+ " Mobile NO :" + data.getmobileNo());
							} else {

								System.out.println("Short Form Eligbility :" + Eligibility + "Status " + "FAIL"
										+ " Mobile NO :" + data.getmobileNo());
							}
						}
						res.close();
						pstmt.close();
					}
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
	
	
	

	public static SQLServerDataTable getRuleDataTableCC() throws SQLServerException {
		SQLServerDataTable ruleDt = new SQLServerDataTable();
		ruleDt.addColumnMetadata("SubscriberName", java.sql.Types.VARCHAR);
		ruleDt.addColumnMetadata("AccountType", java.sql.Types.INTEGER);
		ruleDt.addColumnMetadata("OpenDate", java.sql.Types.DATE);
		ruleDt.addColumnMetadata("DateClosed", java.sql.Types.DATE);
		ruleDt.addColumnMetadata("DateReported", java.sql.Types.INTEGER);
		ruleDt.addColumnMetadata("IdentificationNumber", java.sql.Types.VARCHAR);
		ruleDt.addColumnMetadata("DateOfLastPayment", java.sql.Types.DATE);
		ruleDt.addColumnMetadata("AccountNumber", java.sql.Types.VARCHAR);
		ruleDt.addColumnMetadata("MissedPayments12Months", java.sql.Types.INTEGER);
		
//		for (RuleModel rule : rules)
		{
			ruleDt.addRow("SubscriberName","AccountType","OpenDate","DateClosed","DateReported"
					,"IdentificationNumber","DateOfLastPayment","AccountNumber","MissedPayments12Months");			

		}
		
		
		return ruleDt;
	}

	
	public SQLServerDataTable getRuleDataTableCC(ArrayList<ExperianCreditDetail> rules) throws SQLServerException {
		SQLServerDataTable ruleDt = new SQLServerDataTable();
		ruleDt.addColumnMetadata("SubscriberName", java.sql.Types.VARCHAR);
		ruleDt.addColumnMetadata("AccountType", java.sql.Types.INTEGER);
		ruleDt.addColumnMetadata("OpenDate", java.sql.Types.DATE);
		ruleDt.addColumnMetadata("DateClosed", java.sql.Types.DATE);
		ruleDt.addColumnMetadata("DateReported", java.sql.Types.INTEGER);
		ruleDt.addColumnMetadata("IdentificationNumber", java.sql.Types.VARCHAR);
		ruleDt.addColumnMetadata("DateOfLastPayment", java.sql.Types.DATE);
		ruleDt.addColumnMetadata("AccountNumber", java.sql.Types.VARCHAR);
		ruleDt.addColumnMetadata("MissedPayments12Months", java.sql.Types.INTEGER);
		ruleDt.addRow("SubscriberName",1,"20171122","20171122",1
				,"IdentificationNumber","20171122","32432324324",1);	
		return ruleDt;
		
		
	}
		
		
	
	public static void PANFormDetails(String dbURL, String user, String password, String u_unique_user_id,
			List<CC_DATA> empList) {
		String SPPANFORM1 = Base.loadPropertiesFile("SP.properties", "SPPANFORM");
		try {
			Connection connection = DriverManager.getConnection(dbURL, user, password);

			if (connection != null) {
				try {
					for (CC_DATA data : empList) {
						CallableStatement pstmt = connection.prepareCall(SPPANFORM1);
						pstmt.setString("lead_unique_id", data.getLeadunique());
						pstmt.setString("u_g_user_id", u_unique_user_id);// how to get the G_user Id
						pstmt.setInt("gender", Gender);
						pstmt.setString("date_of_birth", data.getDOB());
						pstmt.setString("salary_mode", data.getSalary_mode());
						// pstmt.setString("is_loan_cc", is_loan_cc); // is existing CC
						pstmt.setString("is_loan_cc", data.getIsExistingCC());
						// pstmt.setString("existing_lender", " ");
						pstmt.setString("existing_lender", data.getExisting_lender());
						// pstmt.setString("max_limit", " ");
						pstmt.setString("max_limit", data.getExistingcardlimit());
						pstmt.setString("ofc_pin_code", ofc_pin_code);
						pstmt.setString("pan_number", pannumber); //
						pstmt.setInt("platform_id", splatform_id);
						pstmt.setString("pan_number_encrypt", pan_number_encrypt);
						// }

						boolean result = pstmt.execute();
						while (result || true) {
							break;
						}

						pstmt.close();
					}
				} finally {
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

	public static void Insert_Lead_Details(String dbURL, String user, String password, String PSTMTINSRT,
			List<CC_DATA> empList) throws SQLException {
		String PSUSRIN = Base.loadPropertiesFile("SP.properties", "PSTMTINSRT");
		try {
			Connection connection = DriverManager.getConnection(dbURL, user, password);

			if (connection != null) {
				try {
					for (CC_DATA data : empList) {
						CallableStatement pstmt = connection.prepareCall(PSUSRIN);
						pstmt.registerOutParameter("u_unique_user_id", java.sql.Types.VARCHAR);
						pstmt.setString("lead_unique_id", PSTMTINSRT);
						pstmt.setInt("card_type", data.getCardType());
						pstmt.setString("mobile_number_plain", data.getmobileNo());
						pstmt.setInt("platform_id", platform_id);
						pstmt.setInt("is_cross_sell", is_cross_sell);
						pstmt.setInt("PL_admin_id", PL_admin_id);
						pstmt.setInt("last_admin_id", last_admin_id);
						pstmt.setInt("is_new", is_new);
						pstmt.setInt("is_user_journey", is_user_journey);
						// }
						boolean result = pstmt.execute();
						u_unique_user_id = pstmt.getString("u_unique_user_id");

						// System.out.println(u_unique_user_id);
						while (result || true) {

							break;

						}

						pstmt.close();
					}
				} finally {
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

	public static void Usercreation(String dbURL, String user, String password, List<CC_DATA> empList)
			throws SQLException {
		// TODO Auto-generated method stub
		String SPURSER = Base.loadPropertiesFile("SP.properties", "PSUSERCR");
		try {
			Connection connection = DriverManager.getConnection(dbURL, user, password);

			if (connection != null) {
				try {
					for (CC_DATA data : empList) {
						CallableStatement pstmt = connection.prepareCall(SPURSER);
						pstmt.setString("u_mobile_number", data.getmobileNo());
						pstmt.setString("g_lead_id", data.getLeadunique());
						pstmt.setString("email_id_plain", email_id);

						// }
						boolean result = pstmt.execute();

						while (result || true) {
							// System.out.println("user");
							break;
						}
						pstmt.close();
					}
				} finally {
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

	public static void MobileOtpVerification(String dbURL, String user, String password, String SPURLMV,
			List<CC_DATA> empList) throws SQLException {

		try {
			Connection connection = DriverManager.getConnection(dbURL, user, password);

			if (connection != null) {
				try {
					for (CC_DATA data : empList) {
						CallableStatement pstmtMv = connection.prepareCall(SPURLMV);

						pstmtMv.setString("mobileno", data.getmobileNo());
						pstmtMv.setString("u_mobile_number", data.getmobileNo());
						pstmtMv.setInt("v_code", v_code);
						pstmtMv.setInt("mode", ModeOPT);
						pstmtMv.setInt("p_mode", Pmode);
						pstmtMv.setString("emailid", email_id);

						// }
						boolean result = pstmtMv.execute();

						while (result || true) {

							// System.out.println("OTP");

							break;

						}

						pstmtMv.close();
					}
				} finally {
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

	public static void OTPreader(List<CC_DATA> empList) throws IOException {

		for (CC_DATA data : empList) {
			String MobileNO = data.getmobileNo();
			URL urlForGetRequest = new URL(
					"https://uatweb.indialends.com/internal/a/get_otp_mail_verify_api.ashx?mobileno=" + MobileNO
							+ "&mode=0");
			String readLine = null;
			HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
			conection.setRequestMethod("GET");
			int responseCode = conection.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) {
				BufferedReader in = new BufferedReader(new InputStreamReader(conection.getInputStream()));
				StringBuffer response = new StringBuffer();
				while ((readLine = in.readLine()) != null) {
					response.append(readLine);
				}
				in.close();
				String value = response.toString();
				String[] otp = value.split("otp_code");
				String value1 = otp[1];
				String numberOnly = value1.replaceAll("[^0-9]", "");
				System.out.println(numberOnly);

			} else {
				System.out.println("GET NOT WORKED");
			}
		}

	}

	public void MobileOtpcreation(String dbURL, String user, String password, String SPURLMV, List<CC_DATA> empList)
			throws SQLException {

		try {
			Connection connection = DriverManager.getConnection(dbURL, user, password);

			if (connection != null) {
				try {
					for (CC_DATA data : empList) {
						CallableStatement pstmtMv = connection.prepareCall(SPURLMV);
						pstmtMv.setString("mobileno", data.getmobileNo());
						pstmtMv.setString("u_mobile_number", data.getmobileNo());
						pstmtMv.setInt("v_code", v_code); // need to discusssed with yogesh
						pstmtMv.setInt("mode", data.getmode());
						pstmtMv.setInt("p_mode", Pmode);
						pstmtMv.setString("emailid", email_id);
						// }
						boolean result = pstmtMv.execute();

						while (result || true) {

							// System.out.println("RAVindra");

							break;

						}

						pstmtMv.close();
					}
				} finally {
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
