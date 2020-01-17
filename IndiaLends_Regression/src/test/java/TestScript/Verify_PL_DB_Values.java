package TestScript;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.testng.annotations.Test;

import Utility.Base;
import Utility.Sendmail;

@Test
public class Verify_PL_DB_Values {

	String dbURL = Base.loadPropertiesFile("DB.properties", "URL");
	String user = Base.loadPropertiesFile("DB.properties", "user");
	String password = Base.loadPropertiesFile("DB.properties", "password");
	String fullname = Base.loadPropertiesFile("PL_Data.properties", "full_name");
	String email = Base.loadPropertiesFile("PL_Data.properties", "email");
	String pincode = Base.loadPropertiesFile("PL_Data.properties", "pincode");
	Short empType = Short.parseShort(Base.loadPropertiesFile("PL_Data.properties", "emptype"));
	String CompanyName = Base.loadPropertiesFile("PL_Data.properties", "company");
	double salary = Double.parseDouble(Base.loadPropertiesFile("PL_Data.properties", "salary"));
	double loanAmt = Double.parseDouble(Base.loadPropertiesFile("PL_Data.properties", "Loan_Amt"));
	String officePincode = Base.loadPropertiesFile("PL_Data.properties", "office_pincode");
	String pancard = Base.loadPropertiesFile("PL_Data.properties", "Pan_no");
	String BnkName = Base.loadPropertiesFile("PL_Data.properties", "bankName");
	String addrOne = Base.loadPropertiesFile("PL_Data.properties", "address");
	String locality = Base.loadPropertiesFile("PL_Data.properties", "locality");
	String officeAddr = Base.loadPropertiesFile("PL_Data.properties", "office_address");
	String officeLocality = Base.loadPropertiesFile("PL_Data.properties", "office_locality");

	String mob = "5266462160";

	// public void fetchDbValue(String mob) {
	public void fetchDbValue() {

		try {

			Connection connection = DriverManager.getConnection(dbURL, user, password);
			if (connection != null) {
				System.out.println("Connected to the database");
				System.out.println("Mobile No is:" + mob);
				try {
                    
					String query = "select alo.admin_id,alo.ismobile_verified,alo.l_city_id,alo.l_mobile_no,alo.l_name,alo.l_is_tele_status,alo.l_email_id,"
							+ "alo.l_physical_q_answers,alo.qu_montly_income,alo.qu_companyname,alo.pl_lenders,alo.l_loan_type,"
							+ "alo.l_loan_amount,alo.l_city_name,alo.l_crdate,alo.l_m_date,alo.l_is_tele_verification,alo.u_user_id,alo.golive,"
							+ "alo.l_loan_tenure,alo.qu_id,alo.mv_status,alo.company_listed,alo.xcell_card_type,"
							+ "ui.u_gender,ui.u_email_id,ui.u_emp_tpe,ui.bank_type,ui.p_monthly_income,ui.u_mobile_number,ui.marriage_status,"
							+ "ui.c_address_two,ui.c_city,ui.c_state,ui.u_first_name,ui.u_last_name,ui.u_date_of_birth,ui.p_pancard_id,ui.c_payment_mode,"
							+ "ui.c_address_one,ui.u_user_id,ui.u_g_user_id,ui.u_middle_name,ui.u_display_name,ui.u_business_name,ui.u_phone_number,"
							+ "ui.u_created_date,ui.u_last_modified_date,ui.is_mv,ui.is_loan,ui.refer_code,ui.refer_by,ui.user_from,ui.p_months_in_address,"
							+ "ui.is_itr,ui.years_in_business,ui.c_name,ui.c_current_exp_month,ui.c_total_exp_month,ui.c_company_listed,\r\n"
							+ "cdo.c_current_company_exp,cdo.c_pincode,cdo.c_address_one,cdo.c_address_two,cdo.c_city,cdo.c_state,cdo.c_total_exp,cdo.c_name,"
							+ "cdo.c_company_id,cdo.c_created_date,cdo.c_last_modified_date,\r\n"
							+ "pio.p_ownership,pio.p_years_in_adress,pio.p_edu_qualification,pio.bank_name,pio.p_pincode,pio.p_address_one,pio.p_address_two,pio.p_city,"
							+ "pio.p_state,pio.p_id,pio.p_created_date,pio.p_last_modified_date,pio.admin_user_id,"
							+ "qo.seo_track,qo.seo_track_url,qo.qu_first_name,qo.qu_city,qo.qu_gender,qo.qu_date_of_birth,qo.qu_email_id,qo.qu_mobile_number,"
							+ "qo.qu_employment_type,qo.qu_loan_amount,qo.qu_loan_month,qo.qu_created_date,qo.qu_last_modified_date,qo.q_g_id,qo.qu_pan_number,"
							+ "qo.ip_address,qo.user_device,qo.qu_application_type,qo.qu_payment_mode,"
							+ "cb.q_g_id,cb.loan_amount,cb.gender,cb.dob,cb.pan_number,cb.cr_date,cb.res_add_one,cb.res_add_two,cb.payment_mode,cb.city,cb.state,cb.age,cb.BankName\r\n"
							+ "from user_information (nolock) as ui \r\n"
							+ "inner join admin_Leads_object (nolock) as alo on ui.u_user_id=alo.u_user_id\r\n"
							+ "inner join personalinfo_object(nolock)  as pio on alo.admin_id=pio.admin_id\r\n"
							+ "inner join companydetails_object (nolock) as cdo on alo.admin_id=cdo.admin_id "
							+ "inner join quote_object (nolock) as qo on alo.qu_id=qo.qu_id\r\n"
							+ "inner join cibil_pull_lead_logger cb on qo.q_g_id= cb.q_g_id\r\n"
							+ "where ui.u_mobile_number=" + "'" + mob + "'";

					PreparedStatement pstmtmv = connection.prepareStatement(query);

					ResultSet result = pstmtmv.executeQuery();

					while (result.next()) {

						// =====PL form field db value verified start =====//

						String DbLname = (String) result.getObject("l_name");
						if (DbLname.contains(fullname)) {
							//System.out.println("Name match with DB value");
						} else {
							System.out.println("Name is not match with DB value");
							Sendmail.sendmail("Name is not match with DB value");
						}

						String DbEmail = (String) result.getObject("l_email_id");
						if (DbEmail.contains(email)) {
							//System.out.println("Email match with DB value");
						} else {
							System.out.println("Email is not match with DB value");
							Sendmail.sendmail("Email is not match with DB value");
						}

						String DbPincode = (String) result.getObject("l_physical_q_answers");
						if (DbPincode.contains(pincode)) {
							//System.out.println("Pincode match with DB value");
						} else {
							System.out.println("Pincode is not match with DB value");
							Sendmail.sendmail("Pincode is not match with DB value");
						}

						Short DbEmpType = (Short) result.getObject("u_emp_tpe");
						if (empType == DbEmpType.shortValue()) {
							//System.out.println("Employment type match with db value");
						} else {
							System.out.println("Employment type is not  match with db value");
							Sendmail.sendmail("Employment type is not  match with db value");
						}

						String DbCompanyName = (String) result.getObject("qu_companyname");
						if (DbCompanyName.contains(CompanyName)) {
							//System.out.println("Company name match with db value");
						} else {
							System.out.println("Company name is not match with db value");
							Sendmail.sendmail("Company name is not match with db value");
						}

						BigDecimal DbSalary = (BigDecimal) result.getObject("p_monthly_income");
						if (salary == (DbSalary.doubleValue())) {
							//System.out.println("Salary  match with db value");
						} else {
							System.out.println("Salary is not match with db value");
							Sendmail.sendmail("Salary is not match with db value");
						}

						Object mobileVerify = result.getInt("ismobile_verified");
						if (mobileVerify.equals(1)) {
							//System.out.println("Mobileverify match with db value.");
						} else {
							System.out.println("Mobileverify is not match with db value.");
							Sendmail.sendmail("Mobileverify is not match with db value.");
						}

						BigDecimal DbLoanAmt = (BigDecimal) result.getObject("l_loan_amount");
						if (loanAmt == DbLoanAmt.doubleValue()) {
							//System.out.println("Loan amount match with DB value");
						} else {
							System.out.println("Loan amount is not match with DB value");
							Sendmail.sendmail("Loan amount is not match with DB value");
						}

						int gender = 1;
						int DbGender = (int) result.getInt("u_gender");
						if (gender == DbGender) {
							//System.out.println("Gender  match with db value");
						} else {
							System.out.println("Gender is not match with db value");
							Sendmail.sendmail("Gender is not match with db value");
						}

						if (result.getObject("u_date_of_birth") != null) {
							//System.out.println("u_date_of_birth is exist in db");
						} else {
							System.out.println("u_date_of_birth is not exist in db");
							Sendmail.sendmail("u_date_of_birth is not exist in db");
						}
						
						String DbPancard = (String) result.getObject("p_pancard_id");
						if (DbPancard.contains(pancard)) {
							//System.out.println("Pancard match with DB Value");
						} else {
							System.out.println("Pancard is not match with DB value");
							Sendmail.sendmail("Pancard is not match with DB value");
						}

						String payMode = "bank transfer";
						String DbPayMode = (String) result.getObject("c_payment_mode");
						if (DbPayMode.contains(payMode)) {
							//System.out.println("Payment mode match with DB value");
						} else {
							System.out.println("Payment mode is not match with DB value");
							Sendmail.sendmail("Payment mode is not match with DB value");
						}

						String DbBnkName = (String) result.getObject("bank_name");
						if (DbBnkName.equals(BnkName)) {
							//System.out.println("Bank name match with db value");
						} else {
							System.out.println("Bank name is not match with db value");
							Sendmail.sendmail("Bank name is not match with db value");
						}

						String DbAddrOne = (String) result.getObject("p_address_one");
						if (DbAddrOne.contains(addrOne)) {
                           	//System.out.println("Address one match with db value");
						} else {
							System.out.println("Address one is not match with db value.");
							Sendmail.sendmail("Address one is not match with db value.");
						}

						String DbLocality = (String) result.getObject("p_address_two");
						if (DbLocality.contains(locality)) {
							//System.out.println("Locality value match with db value");
						} else {
							System.out.println("Locality value is not match with db value.");
							Sendmail.sendmail("Locality value is not match with db value.");
						}

						if (result.getObject("p_city") != null) {
							//System.out.println("Additional detail City value exist in DB");
						} else {
							System.out.println("Additional detail City value is NULL in DB");
							Sendmail.sendmail("Additional detail City value is NULL in DB");
						}

						if (result.getObject("p_state") != null) {
							//System.out.println("Additional detail state value exist in DB");
						} else {
							System.out.println("Additional detail state value is null in DB");
							Sendmail.sendmail("Additional detail state value is null in DB");
						}

						if (result.getObject("pl_lenders") != null) {
							//System.out.println("Pl lenders value exist in db");
						} else {
							System.out.println("Pl lenders value is null in db");
							Sendmail.sendmail("Pl lenders value is null in db");
						}

						String edu = "Post Graduate";
						String dbEdu = (String) result.getObject("p_edu_qualification");
						if (dbEdu.contains(edu)) {
							//System.out.println("Qualification match with DB value");
						} else {
							System.out.println("Qualification is not match with DB value");
							Sendmail.sendmail("Qualification is not match with DB value");
						}

						int maritalStatus = 0;
						int DBMStatus = (int) result.getInt("marriage_status");
						if (maritalStatus == DBMStatus) {
							//System.out.println("Marital status is match with db value");
						} else {
							System.out.println("Marital status is not match with db value.");
							Sendmail.sendmail("Marital status is not match with db value.");
						}

						String resType = "Living with Parents";
						String DBResType = (String) result.getObject("p_ownership");
						if (DBResType.contains(resType)) {
							//System.out.println("Residence type is match with db value");
						} else {
							System.out.println("Residence type is not match with db value.");
							Sendmail.sendmail("Residence type is not match with db value.");
						}

						int yrsAddress = 0;
						int DbYrAddress = result.getInt("p_years_in_adress");
						if (yrsAddress == DbYrAddress) {
							//System.out.println("stay year in address match with DB value");
						} else {
							System.out.println("Stay year in address is not match with DB value.");
							Sendmail.sendmail("Stay year in address is not match with DB value.");
						}

						int expCompany = 0;
						int DbExpCompany = result.getInt("c_current_company_exp");
						if (expCompany == DbExpCompany) {
							//System.out.println("Current company exp match with db Value");
						} else {
							System.out.println("Current company exp is not match with db value.");
							Sendmail.sendmail("Current company exp is not match with db value.");
						}

						String DbOffPincode = (String) result.getObject("c_pincode");
						if (DbOffPincode.contains(officePincode)) {
							//System.out.println("Office pincode is match with db value");
						} else {
							System.out.println("Office pincode is not match with db value");
							Sendmail.sendmail("Office pincode is not match with db value");
						}

						
						String dbOfficeAddr = (String) result.getObject("c_address_one");
						if (dbOfficeAddr.contains(officeAddr)) {
							//System.out.println("office address is match with db value");
						} else {
							System.out.println("office address is not match with db value");
							Sendmail.sendmail("office address is not match with db value");
							
						}
						
						String dbOfficeLocality = (String) result.getObject("c_address_two");
						if (dbOfficeLocality.contains(officeLocality)) {
							//System.out.println("Office locality match with db value");
						} else {
							System.out.println("Office locality is not match with db value");
							Sendmail.sendmail("Office locality is not match with db value");
						}

						if (result.getObject("c_city") != null) {
							//System.out.println("Office information City value exist in DB");
						} else {
							System.out.println("Office information City value is NULL in DB");
							Sendmail.sendmail("Office information City value is NULL in DB");
						}

						if (result.getObject("c_state") != null) {
							//System.out.println("Office information state value exist in DB");
						} else {
							System.out.println("Office information state value is null in DB");
							Sendmail.sendmail("Office information state value is null in DB");
						}

						int totalExp = 0;
						int DbTotalExp = result.getInt("c_total_exp");
						if (totalExp == DbTotalExp) {
							//System.out.println("Total exp match with db value");
						} else {
							System.out.println("Total exp is not match with db value");
							Sendmail.sendmail("Total exp is not match with db value");
						}

						int leadComplete = result.getInt("l_is_tele_status");
						if (leadComplete == 2) {
							//System.out.println("Lead completion value is exist in db");
						} else {
							System.out.println("Lead completion value is not exist in db");
							Sendmail.sendmail("Lead completion value is not exist in db");
						}

						// cibil_pull_lead_logger table value verification
						String qgid = (String) result.getObject("q_g_id");
						if (qgid != null) {
							//System.out.println("qgid is coming in cibil_pull_lead_logger table ");
						} else {
							System.out.println("qgid is coming null in cibil_pull_lead_logger table");
							Sendmail.sendmail("qgid is coming null in cibil_pull_lead_logger table");
						}
						
						BigDecimal DbloanAmt = (BigDecimal) result.getObject("loan_amount");
						if (loanAmt == DbloanAmt.doubleValue()) {
							//System.out.println("Loan amount match with DB value");
						} else {
							System.out.println("Loan amount is not match with DB value");
							Sendmail.sendmail("Loan amount is not match with DB value");
						}

						int gndr = 1;
						int DbGndr = (int) result.getInt("gender");
						if (gndr == DbGndr) {
							//System.out.println("Gender  match with db value");
						} else {
							System.out.println("Gender is not match with db value");
							Sendmail.sendmail("Gender is not match with db value");
						}

						if (result.getObject("dob") != null) {
							//System.out.println("dob is coming in cibil_pull_lead_logger table ");
						} else {
							System.out.println("dob is coming null in cibil_pull_lead_logger table");
							Sendmail.sendmail("dob is coming null in cibil_pull_lead_logger table");
						}
						
						String dbPan = (String) result.getObject("pan_number");
						if (dbPan.contains(pancard)) {
							//System.out.println("Pan no is match with DB value");
						} else {
							System.out.println("Pan no is not match with db value");
							Sendmail.sendmail("Pan no is not match with db value");
						}

						if (result.getObject("cr_date") != null) {
							//System.out.println("Cr date is coming in db");
						} else {
							System.out.println("CR date is coming null in db");
							Sendmail.sendmail("CR date is coming null in db");
						}
						
						String dbAddr = (String) result.getObject("res_add_one");
						if (dbAddr.contains(addrOne)) {
							//System.out.println("Address match with db value");
						} else {
							System.out.println("Address is not match with db value");
							Sendmail.sendmail("Address is not match with db value");
						}
						
						String dbloclty = (String) result.getObject("res_add_two");
						if (dbloclty.contains(locality)) {
							//System.out.println("Locality match with db value");
						} else {
							System.out.println("Locality is not match with db value.");
							Sendmail.sendmail("Locality is not match with db value.");
						}

						if (result.getObject("city") != null) {
							//System.out.println("City value exist in DB");
						} else {
							System.out.println("City is NULL in DB");
							Sendmail.sendmail("City is NULL in DB");
						}

						if (result.getObject("state") != null) {
							//System.out.println("state value exist in DB");
						} else {
							System.out.println("state is null in DB");
							Sendmail.sendmail("state is null in DB");
						}

						if (result.getObject("age") != null) {
							//System.out.println("Age is exist in db");
						} else {
							System.out.println("Age is null in db.");
							Sendmail.sendmail("Age is null in db.");
						}
						
						String dbBankName = (String) result.getObject("BankName");
						if (dbBankName.contains(BnkName)) {
							//System.out.println("Bank name match with db value");
						} else {
							System.out.println("Bank name is not match with db value");
							Sendmail.sendmail("Bank name is not match with db value");
						}
						// ======================//PL form field db value verified End//
						// =========================================== //

						// ============================// admin_leads_object table db value verified//
						// ===================================== //

						if (result.getObject("admin_id") != null) {

							//System.out.println("Admin id is exist in db.");
						} else {
							System.out.println("Admin id is not exist in db");
							Sendmail.sendmail("Admin id is not exist in db");
						}
						
						String Dbname = (String) result.getObject("l_name");
						if (Dbname.contains(fullname)) {
							//System.out.println("Name match with db values");
						} else {
							System.out.println("Name is not match with db values");
							Sendmail.sendmail("Name is not match with db values");
						}

						if (result.getObject("l_mobile_no") != null) {
							//System.out.println("Mobile no exist in db");
						} else {
							System.out.println("Mobile no is not exist in db.");
							Sendmail.sendmail("Mobile no is not exist in db.");
						}

						if (result.getObject("l_city_name") != null) {
							//System.out.println("City name exist in db");
						} else {
							System.out.println("City name is not exist in db");
							Sendmail.sendmail("City name is not exist in db");
						}

						if (result.getObject("l_city_id") != null) {
							//System.out.println("l_city_id is exist in db");
						} else {
							System.out.println("l_city_id is not exist in db");
							Sendmail.sendmail("l_city_id is not exist in db");
						}

						if (result.getObject("l_crdate") != null) {
							//System.out.println("l_crdate is exist in db");
						} else {
							System.out.println("l_crdate is not exist in db");
							Sendmail.sendmail("l_crdate is not exist in db");
						}

						if (result.getObject("l_m_date") != null) {
							//System.out.println("l_m_date is exist in db");
						} else {
							System.out.println("l_m_date is not exist in db");
							Sendmail.sendmail("l_m_date is not exist in db");
						}

						if (result.getObject("l_is_tele_verification") != null) {
							//System.out.println("l_is_tele_verification is exist in db");
						} else {
							System.out.println("l_is_tele_verification is not exist in db");
							Sendmail.sendmail("l_is_tele_verification is not exist in db");
						}

						if (result.getObject("u_user_id") != null) {
							//System.out.println("u_user_id is exist in db");
						} else {
							System.out.println("u_user_id is not exist in db");
							Sendmail.sendmail("u_user_id is not exist in db");
						}

						if (result.getObject("golive") != null) {

							//System.out.println("golive value is exist in db");
						} else {
							System.out.println("golive value is not exist in db");
							Sendmail.sendmail("golive value is not exist in db");
						}

						if (result.getObject("l_loan_tenure") != null && result.getInt("l_loan_tenure") != 0) {
							//System.out.println("l_loan_tenure is exist in db");
						} else {
							System.out.println("l_loan_tenure is not exist in db");
							Sendmail.sendmail("l_loan_tenure is not exist in db");
						}

						if (result.getObject("qu_id") != null) {
							//System.out.println("qu_id is exist in db");
						} else {
							System.out.println("qu_id is not exist in db");
							Sendmail.sendmail("qu_id is not exist in db");
						}

						BigDecimal DbSalar = (BigDecimal) result.getObject("qu_montly_income");
						if (salary == (DbSalar.doubleValue())) {
							//System.out.println("Salary  match with db value in ALO table");
						} else {
							System.out.println("Salary is not match with db value in ALO table");
							Sendmail.sendmail("Salary is not match with db value in ALO table");
						}

						if (result.getObject("mv_status") != null) {
							//System.out.println("mv_status is exist in db");
						} else {
							System.out.println("mv_status is not exist in db");
							Sendmail.sendmail("mv_status is not exist in db");
						}

						if (result.getObject("company_listed") != null) {
							//System.out.println("company_listed is exist in db");
						} else {
							System.out.println("company_listed is not exist in db");
							Sendmail.sendmail("company_listed is not exist in db");
						}

						if (result.getObject("xcell_card_type") != null) {
							//System.out.println("xcell_card_type is exist in db");
						} else {
							System.out.println("xcell_card_type is not exist in db");
							Sendmail.sendmail("xcell_card_type is not exist in db");
						}

						// ============================== User_information table extra value verified
						// ===================================//

						if (result.getObject("u_g_user_id") != null) {
							//System.out.println("u_g_user_id ie exist in db");
						} else {
							System.out.println("u_g_user_id is not exist in db");
							Sendmail.sendmail("u_g_user_id is not exist in db");
						}

						String name = Base.loadPropertiesFile("PL_Data.properties", "full_name");
						String[] splitName = name.split(" ");
						String fName = splitName[0];
						String dbName = (String) result.getObject("u_first_name");

						if (dbName.contains(fName)) {
							//System.out.println("Firstname is match with db value in ui table");
						} else {
							System.out.println("Firstname is not match with db value in ui table");
							Sendmail.sendmail("Firstname is not match with db value in ui table");
						}

						String lname = Base.loadPropertiesFile("PL_Data.properties", "full_name");
						String[] splitLname = lname.split(" ");
						String lastName = splitLname[1];
						String dbLastName = (String) result.getObject("u_last_name");

						if (dbLastName.contains(lastName)) {
							//System.out.println("Last name is match with db value ui table");
						} else {
							System.out.println("Last name is not match with db value ui table");
							Sendmail.sendmail("Last name is not match with db value ui table");
						}

						String dbDisplayName = (String) result.getObject("u_display_name");
						if (dbDisplayName.contains(lname)) {
							//System.out.println("Display name match with db value");
						} else {
							System.out.println("Display name is not match with db value");
							Sendmail.sendmail("Display name is not match with db value");
						}

						String dbEmailId = (String) result.getObject("u_email_id");
						if (dbEmailId.contains(email)) {
							//System.out.println("Email id is match with db value");
						} else {
							System.out.println("Email is is not match with db value");
							Sendmail.sendmail("Email is is not match with db value");
						}

						if (result.getObject("u_mobile_number") != null) {
							//System.out.println("Mobile no is exist in db");
						} else {
							System.out.println("Mobile no is not exist in db");
							Sendmail.sendmail("Mobile no is not exist in db");
						}

						String dbUbsnName = (String) result.getObject("u_business_name");
						if (dbUbsnName.contains(CompanyName)) {
							//System.out.println("u_business_name is match with db value");
						} else {
							System.out.println("u_business_name is not match with db value");
							Sendmail.sendmail("u_business_name is not match with db value");
						}

						if (result.getObject("u_phone_number") != null) {
							//System.out.println("u_phone_number is exist in db");
						} else {
							System.out.println("u_phone_number is not exist in db");
							Sendmail.sendmail("u_phone_number is not exist in db");
						}

						if (result.getObject("u_created_date") != null) {
							//System.out.println("u_created_date is exist in db");
						} else {
							System.out.println("u_created_date is not exist in db");
							Sendmail.sendmail("u_created_date is not exist in db");
						}

						if (result.getObject("u_last_modified_date") != null) {
							//System.out.println("u_last_modified_date is exist in db");
						} else {
							System.out.println("u_last_modified_date is not exist in db");
							Sendmail.sendmail("u_last_modified_date is not exist in db");
						}

						if (result.getInt("is_mv") == 1) {
							//System.out.println("is_mv is match with db in ui table");
						} else {
							System.out.println("is_mv is not match with db in ui table");
							Sendmail.sendmail("is_mv is not match with db in ui table");
						}

						if (result.getObject("is_loan") != null) {
							//System.out.println("is_loan is exist in db");
						} else {
							System.out.println("is_loan is not exist in db");
							Sendmail.sendmail("is_loan is not exist in db");
						}

						if (result.getObject("refer_code") != null) {
							//System.out.println("refer_code is exist in db");
						} else {
							System.out.println("refer_code is not exist in db");
							Sendmail.sendmail("refer_code is not exist in db");
						}

						if (result.getString("user_from") != null) {
							//System.out.println("user_from is exist in db");
						} else {
							System.out.println("user_from is not exist in db");
							Sendmail.sendmail("user_from is not exist in db");
						}

						if (result.getObject("p_months_in_address") != null) {
							//System.out.println("p_months_in_address is exist in db");
						} else {
							System.out.println("p_months_in_address is not exist in db");
							Sendmail.sendmail("p_months_in_address is not exist in db");
						}

					/*	if (result.getObject("years_in_business") != null) {
							//System.out.println("years_in_business is exist in db");
						} else {
							System.out.println("years_in_business is not exist in db");
							Sendmail.sendmail("years_in_business is not exist in db");
						}*/
					
						String DbCName = (String) result.getObject("c_name");
						if (DbCName.contains(CompanyName)) {
							//System.out.println("c_name name match with db value");
						} else {
							System.out.println("c_name name is not match with db value");
							Sendmail.sendmail("c_name name is not match with db value");
						}

						if (result.getObject("c_current_exp_month") != null) {
							//System.out.println("c_current_exp_month is exist in db");
						} else {
							System.out.println("c_current_exp_month is not exist in db");
							Sendmail.sendmail("c_current_exp_month is not exist in db");
						}

						if (result.getObject("c_total_exp_month") != null) {
							//System.out.println("c_total_exp_month is exist in db");
						} else {
							System.out.println("c_total_exp_month is not exist in db");
							Sendmail.sendmail("c_total_exp_month is not exist in db");
						}

						if (result.getObject("p_pincode") != null) {
							//System.out.println("p_pincode is exist in db");
						} else {
							System.out.println("p_pincode is not exist in db");
							Sendmail.sendmail("p_pincode is not exist in db");
						}

						if (result.getObject("p_id") != null) {
							//System.out.println("p_id is exist in db");
						} else {
							System.out.println("p_id is not exist in db");
							Sendmail.sendmail("p_id is not exist in db");
						}

						if (result.getObject("p_created_date") != null) {
							//System.out.println("p_created_date  is exist in db");
						} else {
							System.out.println("p_created_date is not exist in db");
							Sendmail.sendmail("p_created_date is not exist in db");
						}

						if (result.getObject("p_last_modified_date") != null) {
							//System.out.println("p_last_modified_date is exist in db");
						} else {
							System.out.println("p_last_modified_date is not exist in db");
							Sendmail.sendmail("p_last_modified_date is not exist in db");
						}

						if (result.getObject("admin_user_id") != null) {
							//System.out.println("admin_user_id is exist in db");
						} else {
							System.out.println("admin_user_id is not exist in db");
							Sendmail.sendmail("admin_user_id is not exist in db");
						}

						if (result.getObject("c_company_id") != null) {
							//System.out.println("c_company_id is exist in db");
						} else {
							System.out.println("c_company_id is not exist in db");
							Sendmail.sendmail("c_company_id is not exist in db");
						}

						if (result.getObject("c_created_date") != null) {
							//System.out.println("c_created_date is exist in db");
						} else {
							System.out.println("c_created_date is not exist in db");
							Sendmail.sendmail("c_created_date is not exist in db");
						}

						if (result.getObject("c_last_modified_date") != null) {
							//System.out.println("c_last_modified_date is exist in db");
						} else {
							System.out.println("c_last_modified_date is not exist in db");
							Sendmail.sendmail("c_last_modified_date is not exist in db");
						}

						String dbNam = (String) result.getObject("qu_first_name");
						if (dbNam.contains(fName)) {
							//System.out.println("Firstname is match with db value in qo table");
						} else {
							System.out.println("Firstname is not match with db value in qo table");
							Sendmail.sendmail("Firstname is not match with db value in qo table");
						}

						String dbLastNam = (String) result.getObject("u_last_name");
						if (dbLastNam.contains(lastName)) {
							//System.out.println("Last name is match with db value qo table");
						} else {
							System.out.println("Last name is not match with db value qo table");
							Sendmail.sendmail("Last name is not match with db value qo table");
						}

						if (result.getObject("qu_city") != null) {
							//System.out.println("qu_city is exist in db");
						} else {
							System.out.println("qu_city is not exist in db");
							Sendmail.sendmail("qu_city is not exist in db");
						}

						if (result.getInt("qu_gender") == 1) {
							//System.out.println("qu_gender is exist in db");
						} else {
							System.out.println("qu_gender is not exist in db");
							Sendmail.sendmail("qu_gender is not exist in db");
						}

						if (result.getObject("qu_date_of_birth") != null) {
							//System.out.println("qu_date_of_birth is exist in db");
						} else {
							System.out.println("qu_date_of_birth is not exist in db");
							Sendmail.sendmail("qu_date_of_birth is not exist in db");
						}

						String Dbmail = (String) result.getObject("qu_email_id");
						if (Dbmail.contains(email)) {
							//System.out.println("Email match with DB value in qo table");
						} else {
							System.out.println("Email is not match with DB value in qo table");
							Sendmail.sendmail("Email is not match with DB value in qo table");
						}

						if (result.getObject("qu_mobile_number") != null) {
							//System.out.println("qu_mobile_number is exist in db");
						} else {
							System.out.println("qu_mobile_number is not exist in db");
							Sendmail.sendmail("qu_mobile_number is not exist in db");
						}

						Short DbEmplType = (Short) result.getObject("qu_employment_type");
						if (empType == DbEmplType.shortValue()) {
							//System.out.println("Employment type match with db value in qo table");
						} else {
							System.out.println("Employment type is not  match with db value in qo table");
							Sendmail.sendmail("Employment type is not  match with db value in qo table");
						}

						BigDecimal DbLonAmt = (BigDecimal) result.getObject("qu_loan_amount");
						if (loanAmt == DbLonAmt.doubleValue()) {
							//System.out.println("Loan amount match with DB value in qo table");
						} else {
							System.out.println("Loan amount is not match with DB value in qo table");
							Sendmail.sendmail("Loan amount is not match with DB value in qo table");
						}

						if (result.getObject("qu_loan_month") != null) {
							//System.out.println("qu_loan_month is exist in db");
						} else {
							System.out.println("qu_loan_month is not exist in db");
							Sendmail.sendmail("qu_loan_month is not exist in db");
						}

						if (result.getObject("qu_created_date") != null) {
							//System.out.println("qu_created_date is exist in db");
						} else {
							System.out.println("qu_created_date is not exist in db");
							Sendmail.sendmail("qu_created_date is not exist in db");
						}

						if (result.getObject("qu_last_modified_date") != null) {
							//System.out.println("qu_last_modified_date is exist in db");
						} else {
							System.out.println("qu_last_modified_date is not exist in db");
							Sendmail.sendmail("qu_last_modified_date is not exist in db");
						}

						if (result.getObject("q_g_id") != null) {
							//System.out.println("q_g_id is exist in db");
						} else {
							System.out.println("q_g_id is not exist in db");
							Sendmail.sendmail("q_g_id is not exist in db");
						}

						String DbPancrd = (String) result.getObject("qu_pan_number");
						if (DbPancrd.contains(pancard)) {
							//System.out.println("Pancard match with DB Value in qo table");
						} else {
							System.out.println("Pancard is not match with DB value in qo table");
							Sendmail.sendmail("Pancard is not match with DB value in qo table");
						}

						if (result.getObject("seo_track_url") != null) {
							//System.out.println("seo_track_url is exist in db");
						} else {
							System.out.println("seo_track_url is not exist in db");
							Sendmail.sendmail("seo_track_url is not exist in db");
						}

						if (result.getObject("seo_track") != null) {
							//System.out.println("seo_track is exist in db");
						} else {
							System.out.println("seo_track is not exist in db");
							Sendmail.sendmail("seo_track is not exist in db");
						}

						if (result.getObject("ip_address") != null) {
							//System.out.println("ip_address is exist in db");
						} else {
							System.out.println("ip_address is not exist in db");
							Sendmail.sendmail("ip_address is not exist in db");
						}

						if (result.getObject("user_device") != null) {
							//System.out.println("user_device is exist in db");
						} else {
							System.out.println("user_device is not exist in db");
							Sendmail.sendmail("user_device is not exist in db");
						}

						if (result.getObject("qu_application_type") != null) {
							//System.out.println("qu_application_type is exist in db");
						} else {
							System.out.println("qu_application_type is not exist in db");
							Sendmail.sendmail("qu_application_type is not exist in db");
						}

						String DbPayMod = (String) result.getObject("qu_payment_mode");
						if (DbPayMod.contains(payMode)) {
							//System.out.println("Payment mode match with DB value in qo table");
						} else {
							System.out.println("Payment mode is not match with DB value in qo table");
							Sendmail.sendmail("Payment mode is not match with DB value in qo table");
						}
						// =============================== All db values verified//
						// =====================================================//
						System.out.println("======================All DB Values Verified ============================");
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

	}

}
