package TestScript;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.jsoup.select.Evaluator.IsEmpty;
import org.testng.annotations.Test;

import Utility.Base;
import Utility.Sendmail;

@Test
public class Verify_CC_SBI_lender_DB_Values {
	
	String dbURL = Base.loadPropertiesFile("DB.properties", "URL");
	String user = Base.loadPropertiesFile("DB.properties", "user");
	String password =Base.loadPropertiesFile("DB.properties", "password");
	String company=Base.loadPropertiesFile("CC_Data.properties","company");
	String email = Base.loadPropertiesFile("CC_Data.properties", "email");
	String hNo=Base.loadPropertiesFile("CC_Data.properties", "houseNo");
	String street=Base.loadPropertiesFile("CC_Data.properties", "street");
	String resArea=Base.loadPropertiesFile("CC_Data.properties","ResArea");
	double salary=Double.parseDouble(Base.loadPropertiesFile("CC_Data.properties", "salary"));
	String dobYr=Base.loadPropertiesFile("CC_Data.properties","DOB_Year");
	String dobMN=Base.loadPropertiesFile("CC_Data.properties","DOB_MN");
	String dobDD=Base.loadPropertiesFile("CC_Data.properties","DOB_DD");
	double MaxLimit=Double.parseDouble(Base.loadPropertiesFile("CC_Data.properties","creditLimit"));
	String pincode=Base.loadPropertiesFile("CC_Data.properties","pincode");
	String officePin=Base.loadPropertiesFile("CC_Data.properties", "offPincode");
	String OfficeNo=Base.loadPropertiesFile("CC_Data.properties", "OfficeNo");
	String OfficeStreet=Base.loadPropertiesFile("CC_Data.properties", "offStreet");
	String OfficeArea=Base.loadPropertiesFile("CC_Data.properties", "offArea");
	String Edu=Base.loadPropertiesFile("CC_Data.properties","Education");
	String acc=Base.loadPropertiesFile("CC_Data.properties","Relation_ac");
	String off_landline=Base.loadPropertiesFile("CC_Data.properties","off_LandlineNo");
	String mob = "5232649262";
	
	public void fetchCCDBvalues(String mob) {
	//public void fetchCCDBvalues(String mob2) {
		
		try {

			Connection connection = DriverManager.getConnection(dbURL, user, password);
			if (connection != null) {
				System.out.println("**************Connected to the database******************");
				System.out.println("Mobile No is:" + mob);
				try {
                    
					String query = "select\r\n" + 
							"ui.u_user_id,ui.u_g_user_id,ui.u_first_name,ui.u_middle_name,ui.u_last_name,ui.u_display_name,ui.u_email_id,ui.u_gender,\r\n" + 
							"ui.u_mobile_number,ui.u_date_of_birth,ui.u_business_name,ui.u_phone_number,ui.u_created_date,ui.u_last_modified_date,\r\n" + 
							"ui.u_status,ui.marriage_status,ui.u_emp_tpe,ui.is_mv,ui.user_from,ui.p_pancard_id,ui.p_address_one,ui.p_address_two,ui.p_city,\r\n" + 
							"ui.p_state,ui.p_monthly_income,ui.c_name,ui.c_address_one,ui.c_address_two,ui.c_city,ui.c_state,ui.c_pincode,ui.p_pincode,\r\n" + 
							"ui.c_payment_mode,ui.p_edu_qualification,\r\n" + 
							"udo.u_user_id,udo.u_g_user_id,udo.u_first_name,udo.u_middle_name,udo.u_last_name,udo.u_display_name,udo.u_email_id,udo.u_gender,\r\n" + 
							"udo.u_mobile_number,udo.u_date_of_birth,udo.u_type,udo.u_business_name,udo.u_phone_number,udo.u_created_date,udo.u_last_modified_date,\r\n" + 
							"udo.u_status,udo.marriage_status,udo.u_emp_tpe,udo.is_mv,udo.user_from,\r\n" + 
							"ld.lead_id,ld.created_date,ld.il_user_id,ld.completed_by,ld.is_complete,ld.is_archive,ld.is_sbi_relation,ld.sbi_relation_type,\r\n" + 
							"ld.account_number,ld.application_status,ld.application_complete_date,ld.lead_track_id,ld.modified_date,ld.user_last_activity,\r\n" + 
							"ld.is_eligible,ld.pl_to_cc,ld.is_pq,ld.stepperId,\r\n" + 
							"ltd.lead_track_id,ltd.created_date,ltd.lead_unique_id,ltd.first_name,ltd.last_name,ltd.middle_name,ltd.email_id,ltd.mobile_number,\r\n" + 
							"ltd.res_pin_code,ltd.monthly_salary,ltd.card_type,ltd.mobile_verified,ltd.campaign,ltd.track_url,ltd.ip_address,ltd.platform_id,\r\n" + 
							"ltd.modified_date,ltd.employment_status,ltd.ofc_name,\r\n" + 
							"rs.res_details_id,rs.created_date,rs.lead_id,rs.res_pin_code,rs.res_house_number,rs.res_street,rs.res_landmark,rs.res_locality,\r\n" + 
							"rs.res_district,rs.res_city,rs.res_state,rs.res_std_code,rs.res_landline_number,rs.modified_date,\r\n" + 
							"od.ofc_details_id,od.created_date,od.lead_id,od.ofc_name,od.ofc_pin_code,od.ofc_door_number,od.ofc_street,od.ofc_landmark,od.ofc_locality,\r\n" + 
							"od.ofc_district,od.ofc_city,od.ofc_state,od.ofc_std_code,od.ofc_landline_number,od.modified_date,od.salary_mode,\r\n" + 
							"pd.personal_id,pd.crdate,pd.lead_id,pd.marital_status,pd.educational_qualification,pd.pan_number,pd.modified_date,\r\n" + 
							"npd.nbfc_process_id,npd.process_date,npd.lead_id,npd.is_eligible,npd.is_api_hit,npd.is_api_hit_success,npd.application_id,npd.reference_number,npd.\r\n" + 
							"application_status,npd.process_status,npd.status_comments,npd.modified_date,npd.is_error,\r\n" + 
							"srlo.sl_id,srlo.sl_admin_id,srlo.sl_request,srlo.sl_response,srlo.sl_created_date,\r\n" + 
							"cald.id,cald.lead_id,cald.u_user_id,cald.is_existing_cc,cald.existing_lender_id,cald.max_limit,cald.createdDate,\r\n" + 
							"cald.is_alternate_contact_no,cald.modifiedDate\r\n" + 
							"from user_information ui\r\n" + 
							"inner join Userdetails_object udo on udo.u_user_id=ui.u_user_id\r\n" + 
							"inner join lead_details ld on ld.il_user_id=ui.u_user_id\r\n" + 
							"inner join lead_tracking_details ltd on ltd.lead_track_id=ld.lead_track_id\r\n" + 
							"inner join residential_details rs on rs.lead_id=ld.lead_id\r\n" + 
							"inner join office_details od on od.lead_id=ld.lead_id\r\n" + 
							"inner join personal_details pd on pd.lead_id=ld.lead_id\r\n" + 
							"inner join cc_additional_lead_details cald on cald.lead_id=ld.lead_id\r\n" + 
							"inner join nbfc_process_details npd on npd.lead_id=ld.lead_id\r\n" + 
							"inner join sbi_response_log_object srlo on srlo.sl_admin_id=ld.lead_id\r\n" + 
							"where ui.u_mobile_number=" + "'" + mob + "'";

					PreparedStatement pstmtmv = connection.prepareStatement(query);

					ResultSet result = pstmtmv.executeQuery();

					while (result.next()) {

						//System.out.println("User id is: " +result.getObject("u_user_id")+ " u_g_user_id is: "+result.getObject("u_g_user_id") + " u_first_name is:"+result.getObject("u_first_name"));

					     if(result.getObject("u_user_id") !=null) {
					    	 //System.out.println("u_user_id exist in db");	 
					     }else {
					    	 System.out.println("u_user_id is not exist in db");
					    	 //SendMail.sendmail("u_user_id is not exist in db");
					     }
                         
					     if(result.getObject("u_g_user_id") !=null) {
					    	 //System.out.println("u_g_user_id is exist in db");
					     }else {
					    	 System.out.println("u_g_user_id is not exist in db");
					    //	 SendMail.sendmail("u_g_user_id is not exist in db");
					     }
					     
					     String fullname=Base.loadPropertiesFile("CC_Data.properties", "full_name");
					     String[] splitLname = fullname.split(" ");
						 String frstName = splitLname[0];
						 String dbFrstName = (String) result.getObject("u_first_name");
						
					     if(dbFrstName.contains(frstName) ) {
					    	 
					    	 //System.out.println("u_first_name exist in db");
					     }else {
					    	 System.out.println("u_first_name is not exist in db");
					    //	 SendMail.sendmail("u_first_name is not exist in db");
					     }
					     
					     String middleName=splitLname[1];
					     String dbMiddleName=(String) result.getObject("u_middle_name");
					    // System.out.println("m Name"+middleName);
					     if(dbMiddleName.contains(middleName)) {
					    	 //System.out.println("u_middle_name is exist in db");
					     }else {
					    	 System.out.println("u_middle_name is not exist in db");
					    	// SendMail.sendmail("u_middle_name is not exist in db");
					     }
					     
					     String lastName=splitLname[2];
					     String dbLastName=(String) result.getObject("u_last_name");
					    // System.out.println(lastName);
					     if(dbLastName.contains(lastName)) {
					    	 //System.out.println("Last Name exist in db");
					     }else {
					    	 System.out.println("Last name is not exist in db");
					    	// SendMail.sendmail("Last name is not exist in db");
					     }
						
					     String dbDisplayName=(String) result.getObject("u_display_name");
					     String dbTrim=dbDisplayName.replaceAll("\\s+", " ");
					     
					     if(dbTrim.contains(fullname)) {
					    	 //System.out.println("u_display_name is exist in db");
					     }else {
					    	 System.out.println("u_display_name is not exist in db");
					    	 Sendmail.sendmail("u_display_name is not exist in db");
					     }
					    
					     String dbEmail=(String) result.getObject("u_email_id");
					     
					     if(dbEmail.contains(email)) {
					    	 //System.out.println("u_email_id is exist in db");
					     }else {
					    	 System.out.println("u_email_id is not exist in db");
					    	 Sendmail.sendmail("u_email_id is not exist in db");
					     }
					     
					     if(result.getObject("u_gender") !=null) {
					    	 //System.out.println("u_gender is exist in db");
					     }else {
					    	 System.out.println("u_gender is not exist in db");
					    	 Sendmail.sendmail("u_gender is not exist in db");
					     }
					     
					     String DbUmob=(String) result.getObject("u_mobile_number");
					     if(DbUmob.contains(mob)) {
					    	 //System.out.println("u_mobile_number is exist in db");
					     }else {
					    	 System.out.println("u_mobile_number is not exist in db");
					    	 Sendmail.sendmail("u_mobile_number is not exist in db");
					     }
					     
					     String dobT="00:00:00.0";
					     String db=dobYr+"-"+dobMN+"-"+dobDD+" "+dobT;
					    // System.out.println(db);
					     //System.out.println(result.getObject("u_date_of_birth"));
					     String DBdob=(String) result.getObject("u_date_of_birth").toString();
					     if(DBdob.contains(db)) {
					    	 //System.out.println("u_date_of_birth is exist in db");
					     }else {
					    	 System.out.println("u_date_of_birth is not exist in db");
					    	 Sendmail.sendmail("u_date_of_birth is not exist in db");
					     }
					     
					     String dbBusinessName=(String) result.getObject("u_business_name");
					    // System.out.println(company);
					     if(dbBusinessName !=null) {
					    	 //System.out.println("u_business_name is exist in db");
					     }else {
					    	 System.out.println("u_business_name is not exist in db");
					    	 Sendmail.sendmail("u_business_name is not exist in db");
					     }
					     
					     String DbUphn=(String) result.getObject("u_phone_number");
					     
					     if(DbUphn.contains(mob)) {
					    	// System.out.println("u_phone_number is exist in db");
					     }else {
					    	 System.out.println("u_phone_number is not exist in db");
					    	 Sendmail.sendmail("u_phone_number is not exist in db");
					     }
					     
					     if(result.getObject("u_created_date") !=null) {
					    	 //System.out.println("u_created_date is exist in db");
					     }else {
					    	 System.out.println("u_created_date is not exist in db");
					    	 Sendmail.sendmail("u_created_date is not exist in db");
					     }
					     
					     if(result.getObject("u_last_modified_date") !=null) {
					    	// System.out.println("u_last_modified_date is exist in db");
					     }else {
					    	 System.out.println("u_last_modified_date is not exist in db");
					    	 Sendmail.sendmail("u_last_modified_date is not exist in db");
					     }
					     
					     if(result.getObject("marriage_status") !=null) {
					    	// System.out.println("marriage_status is exist in db");
					     }else {
					    	 System.out.println("marriage_status is not exist in db");
					    	 Sendmail.sendmail("marriage_status is not exist in db");
					     }
					     
					     if(result.getObject("u_emp_tpe") !=null) {
					    	 //System.out.println("u_emp_tpe is exist in db");
					     }else {
					    	 System.out.println("u_emp_tpe is not exist in db");
					    	 Sendmail.sendmail("u_emp_tpe is not exist in db");
					     }
					     
					     Short mv=(Short) result.getObject("is_mv");
					     Short MVdata=1;
					     if( MVdata == mv.shortValue() ){
					    	 //System.out.println("is_mv is exist in db");
					     }else {
					    	 System.out.println("is_mv is not exist in db");
					    	 Sendmail.sendmail("is_mv is not exist in db");
					     }
					     
					     String usrFrm=(String) result.getObject("user_from");
					     if(usrFrm.contains("W")) {
					    	// System.out.println("user_from is exist in db");
					     }else {
					    	 System.out.println("user_from is not exist in db");
					    	 Sendmail.sendmail("user_from is not exist in db");
					     }
					     
					     if(result.getObject("p_pancard_id") !=null) {
					    	// System.out.println("p_pancard_id is exist in db");
					     }else {
					    	 System.out.println("p_pancard_id is not exist in db");
					    	 Sendmail.sendmail("p_pancard_id is not exist in db");
					     }
					     
					    String addrOne=hNo.concat(",").concat(street);
					    String DBAddrOne=(String) result.getObject("p_address_one");
					    
					    if(DBAddrOne.contains(addrOne)) {
					    	//System.out.println("p_address_one is exist in db");
					    }else {
					    	System.out.println("p_address_one is not exist in db");
					    	Sendmail.sendmail("p_address_one is not exist in db");
					    }
					    
					    String DBaddrTwo=(String) result.getObject("p_address_two");
					    if(DBaddrTwo.contains(resArea)) {
					    	//System.out.println("p_address_two is exist in db");
					    }else {
					    	System.out.println("p_address_two is not exist in db");
					    	Sendmail.sendmail("p_address_two is not exist in db");
					    }
					    
					    if(result.getObject("p_city") !=null) {
					    	//System.out.println("p_city is exist in db");
					    }else {
					    	System.out.println("p_city is not exist in db");
					    	Sendmail.sendmail("p_city is not exist in db");
					    }
					    
					    if(result.getObject("p_state") !=null) {
					    	//System.out.println("p_state is exist in db ");
					    }else {
					    	System.out.println("p_state is not exist in db");
					    	Sendmail.sendmail("p_state is not exist in db");
					    }
					    
					    BigDecimal DBSalary=(BigDecimal) result.getObject("p_monthly_income");
					     if(salary == (DBSalary.doubleValue())) {
					    	//System.out.println("Salary is exist in db");
					    }else {
					    	System.out.println("Salary is not exist in db");
					    	Sendmail.sendmail("Salary is not exist in db");
					    }
					     
					     if(result.getObject("c_name") !=null) {
					    	 //System.out.println("c_name is exist in db");
					     }else {
					    	 System.out.println("c_name is not exist in db");
					    	 Sendmail.sendmail("c_name is not exist in db");
					     }
					     
					     String DBcAddrOne=(String) result.getObject("c_address_one");
					     
					     if(DBcAddrOne.contains(addrOne)) {
					    	 //System.out.println("c_address_one is exist in db");
					     }else {
					    	 System.out.println("c_address_one is not exist in db");
					    	 Sendmail.sendmail("c_address_one is not exist in db");
					     }
					     
					     String DBcAddrTwo=(String) result.getObject("c_address_two");
					     
					     if(DBcAddrTwo.contains(resArea)) {
					    	 //System.out.println("c_address_two is exist in db");
					     }else {
					    	 System.out.println("c_address_two is not exist in db");
					    	 Sendmail.sendmail("c_address_two is not exist in db");
					     }
					     
					     if(result.getObject("c_city") !=null) {
					    	 //System.out.println("c_city is exist in db");
					     }else {
					    	 System.out.println("c_city is not exist in db");
					    	 Sendmail.sendmail("c_city is not exist in db");
					     }
					     
					     if(result.getObject("c_state") !=null) {
					    	 //System.out.println("c_state is exist in db");
					     }else {
					    	 System.out.println("c_state is not exist in db");
					    	 Sendmail.sendmail("c_state is not exist in db");
					     }
					     
					     String dbPincode=(String) result.getObject("c_pincode");
					     if(dbPincode.contains(pincode)) {
					    	 //System.out.println("c_pincode is exist in db");
					     }else {
					    	 System.out.println("c_pincode is not exist in db");
					    	 Sendmail.sendmail("c_pincode is not exist in db");
					     }
					     
					     String dbPincod=(String) result.getObject("p_pincode");
					     
					     if(dbPincod.contains(pincode)) {
					    	 //System.out.println("p_pincode is exist in db");
					     }else {
					    	 System.out.println("p_pincode is not exist in db");
					    	 Sendmail.sendmail("p_pincode is not exist in db");
					     }
					     
					     if(result.getObject("c_payment_mode") !=null) {
					    	// System.out.println("c_payment_mode is exist in db");
					     }else {
					    	 System.out.println("c_payment_mode is not exist in db");
					    	 Sendmail.sendmail("c_payment_mode is not exist in db");
					     }
					     
					     String dbEdu=(String) result.getObject("p_edu_qualification");
					    
					     if(dbEdu !=null){
					    	// System.out.println("p_edu_qualification is exist in db");
					     }else {
					    	 System.out.println("p_edu_qualification is not exist in db");
					    	 Sendmail.sendmail("p_edu_qualification is not exist in db");
					     }
					     
					     if(result.getObject("u_type") !=null) {
					    	// System.out.println("u_type is exist in db");
					     }else {
					    	 System.out.println("u_type is not exist in db");
					    	 Sendmail.sendmail("u_type is not exist in db");
					     }
					     
					     if(result.getObject("lead_id") !=null) {
					    	 //System.out.println("lead_id is exist in db");
					     }else {
					    	 System.out.println("lead_id is not exist in db");
					    	 Sendmail.sendmail("lead_id is not exist in db");
					     }
					     
					     if(result.getObject("created_date") !=null) {
					    	// System.out.println("created_date is exist in db");
					     }else {
					    	 System.out.println("created_date is not exist in db");
					    	 Sendmail.sendmail("created_date is not exist in db");
					     }
					     
					     if(result.getObject("il_user_id") !=null) {
					    	// System.out.println("il_user_id is exist in db");
					     }else {
					    	 System.out.println("il_user_id is not exist in db");
					    	 Sendmail.sendmail("il_user_id is not exist in db");
					     }
					     
					     if(result.getObject("completed_by") !=null) {
					    	 //System.out.println("completed_by is exist in db");
					     }else {
					    	 System.out.println("completed_by is not exist in db");
					    	 Sendmail.sendmail("completed_by is not exist in db");
					     }
					     
					     if(result.getObject("is_complete") !=null) {
					    	 //System.out.println("is_complete is exist in db");
					     }else {
					    	 System.out.println("is_complete is not exist in db");
					    	 Sendmail.sendmail("is_complete is not exist in db");
					     }
					     
					     if(result.getObject("is_sbi_relation") !=null) {
					    	 //System.out.println("is_sbi_relation is exist in db");
					     }else {
					    	 System.out.println("is_sbi_relation is not exist in db");
					    	 Sendmail.sendmail("is_sbi_relation is not exist in db");
					     }
					     
					     if(result.getObject("application_status") !=null) {
					    	// System.out.println("application_status is exist in db");
					     }else {
					    	 System.out.println("application_status is not exist in db");
					    	 Sendmail.sendmail("application_status is not exist in db");
					     }
					     
					     if(result.getObject("application_complete_date") !=null) {
					    	 //System.out.println("application_complete_date is exist in db");
					     }else {
					    	 System.out.println("application_complete_date is not exist in db");
					    	 Sendmail.sendmail("application_complete_date is not exist in db");
					     }
					     
					     if(result.getObject("lead_track_id") !=null) {
					    	// System.out.println("lead_track_id is exist in db");
					     }else {
					    	 System.out.println("lead_track_id is not exist in db");
					    	 Sendmail.sendmail("lead_track_id is not exist in db");
					     }
					     
					     if(result.getObject("modified_date") !=null) {
					    	 //System.out.println("modified_date is exist in db");
					     }else {
					    	 System.out.println("modified_date is not exist in db");
					    	 Sendmail.sendmail("modified_date is not exist in db");
					     }
					     
					     if(result.getObject("user_last_activity") !=null) {
					    	// System.out.println("user_last_activity is exist in db");
					     }else {
					    	 System.out.println("user_last_activity is not exist in db");
					    	 Sendmail.sendmail("user_last_activity is not exist in db");
					     }
					     
					     if(result.getObject("is_eligible") !=null) {
					    	// System.out.println("is_eligible is exist in db");
					     }else {
					    	 System.out.println("is_eligible is not exist in db");
					    	 Sendmail.sendmail("is_eligible is not exist in db");
					     }
					     
					     if(result.getObject("is_pq") !=null) {
					    	 //System.out.println("is_pq is exist in db");
					     }else {
					    	 System.out.println("is_pq is not exist in db");
					    	 Sendmail.sendmail("is_pq is not exist in db");
					     }
					     
					     if(result.getObject("stepperId") !=null) {
					    	 //System.out.println("stepperId is exist in db");
					     }else {
					    	 System.out.println("stepperId is not exist in db");
					    	 Sendmail.sendmail("stepperId is not exist in db");
					     }
					     
					     if(result.getObject("lead_unique_id") !=null) {
					    	 //System.out.println("lead_unique_id is exist in db");
					     }else {
					    	 System.out.println("lead_unique_id is not exist in db");
					    	 Sendmail.sendmail("lead_unique_id is not exist in db");
					     }
					     
					     String DBfstName=(String) result.getObject("first_name");
					     
					     if(DBfstName.contains(frstName)) {
					    	 //System.out.println("first_name is exist in db");
					     }else {
					    	 System.out.println("first_name is not exist in db");
					    	 Sendmail.sendmail("first_name is not exist in db");
					     }
					     
					     String DbMidName=(String) result.getObject("middle_name");
					     
					     if(DbMidName.contains(middleName)) {
					    	// System.out.println("middle_name is exist in db");
					     }else {
					    	 System.out.println("middle_name is not exist in db");
					    	 Sendmail.sendmail("middle_name is not exist in db");
					     }
					     
					     String DBLstName=(String) result.getObject("last_name");
					     
					     if(DBLstName.contains(lastName)) {
					    	 //System.out.println("last_name is exist in db");
					     }else {
					    	 System.out.println("last_name is not exist in db");
					    	// SendMail.sendmail("last_name is not exist in db");
					     }
					     
					     //Encrypt value can't verfiy because of certificate issuee
					  /*   if(result.getObject("email_id") !=null) {
					    	 System.out.println("email_id is exist in db");
					     }else {
					    	 System.out.println("email_id is not exist in db");
					     }
					     
					     if(result.getObject("mobile_number") !=null) {
					    	 System.out.println("mobile_number is exist in db");
					     }else {
					    	 System.out.println("mobile_number is not exist in db");
					     }*/
					     
					  String DBresPinCode=(String) result.getObject("res_pin_code");
					  if(DBresPinCode.contains(pincode)) {
						  //System.out.println("res_pin_code is exist in db");
					  }else {
						  System.out.println("res_pin_code is not exist in db");
						  Sendmail.sendmail("res_pin_code is not exist in db");
					  }
					    
					  BigDecimal DBSalry=(BigDecimal) result.getObject("monthly_salary");
					 
					     if(salary == (DBSalry.doubleValue())) {
					    	//System.out.println("monthly_salary is exist in db");
					    }else {
					    	System.out.println("monthly_salary is not exist in db");
					    	Sendmail.sendmail("monthly_salary is not exist in db");
					    }
					     
					   if(result.getObject("card_type") !=null) {
						   //System.out.println("card_type is exist in db");
					   }else {
						   System.out.println("card_type is not exist in db");
						   Sendmail.sendmail("card_type is not exist in db");
					   }
					   
					   if(result.getObject("mobile_verified") !=null) {
						   //System.out.println("mobile_verified is exist in db");
					   }else {
						   System.out.println("mobile_verified is not exist in db");
						   Sendmail.sendmail("mobile_verified is not exist in db");
					   }
					   
					   if(result.getObject("campaign") !=null) {
						  // System.out.println("campaign is exist in db");
					   }else {
						   System.out.println("campaign is not exist in db");
						   Sendmail.sendmail("campaign is not exist in db");
					   }
					   
					   if(result.getObject("track_url") !=null) {
						   //System.out.println("track_url is exist in db");
					   }else {
						   System.out.println("track_url, is not exist in db");
						   Sendmail.sendmail("track_url, is not exist in db");
					   }
					   
					   if(result.getObject("ip_address") !=null) {
						  // System.out.println("ip_address is exist in db");
					   }else {
						   System.out.println("ip_address is not exist in db");
						   Sendmail.sendmail("ip_address is not exist in db");
					   }
					   
					   if(result.getObject("platform_id") !=null) {
						   //System.out.println("platform_id is exist in db");
					   }else {
						   System.out.println("platform_id is not exist in db");
						   Sendmail.sendmail("platform_id is not exist in db");
					   }
					   
					   if(result.getObject("employment_status") !=null) {
						   //System.out.println("employment_status is exist in db");
					   }else {
						   System.out.println("employment_status is not exist in db");
						   Sendmail.sendmail("employment_status is not exist in db");
					   }
					   
					   if(result.getObject("ofc_name") !=null) {
						   //System.out.println("ofc_name is exist in db");
					   }else {
						   System.out.println("ofc_name is not exist in db");
						   Sendmail.sendmail("ofc_name is not exist in db");
					   }
					   
					   if(result.getObject("res_details_id") !=null) {
						   //System.out.println("res_details_id is exist in db");
					   }else {
						   System.out.println("res_details_id is not exist in db");
						   Sendmail.sendmail("res_details_id is not exist in db");
					   }
					   
					   String dbRespIN=(String) result.getObject("res_pin_code");
					   if(dbRespIN.contains(pincode)) {
						  //System.out.println("res_pin_code is exist in db"); 
					   }else {
						   System.out.println("res_pin_code is not exist in db");
						   Sendmail.sendmail("res_pin_code is not exist in db");
					   }
					   
					   String DbreHno=(String) result.getObject("res_house_number");
					   if(DbreHno.contains(hNo)){
						   //System.out.println("res_house_number is exist in db");
					   }else {
						   System.out.println("res_house_number is not exist in db");
						   Sendmail.sendmail("res_house_number is not exist in db");
					   }
					   
					   String DbreStreet=(String) result.getObject("res_street");
					   
					   if(DbreStreet.contains(street)) {
						   //System.out.println("res_street is exist in db");
					   }else {
						  System.out.println("res_street is not exist in db"); 
						  Sendmail.sendmail("res_street is not exist in db");
					   }
					   
					   String DbResLocality=(String) result.getObject("res_locality");
					   if(DbResLocality.contains(resArea)) {
						   //System.out.println("res_locality is exist in db");
					   }else {
						   System.out.println("res_locality is not exist in db");
						   Sendmail.sendmail("res_locality is not exist in db");
					   }
					   
					   if(result.getObject("res_district") !=null) {
						   //System.out.println("res_district is exist in db");
					   }else {
						   System.out.println("res_district is not exist in db");
						   Sendmail.sendmail("res_district is not exist in db");
					   }
					   
					   if(result.getObject("res_city") !=null) {
						  // System.out.println("res_city is exist in db");
					   }else {
						   System.out.println("res_city is not exist in db");
						   Sendmail.sendmail("res_city is not exist in db");
					   }
					   
					   if(result.getObject("res_state") !=null) {
						  // System.out.println("res_state is exist in db");
					   }else {
						   System.out.println("res_state is not exist in db");
						   Sendmail.sendmail("res_state is not exist in db");
					   }
					   
					   if(result.getObject("ofc_details_id") !=null) {
						   //System.out.println("ofc_details_id is exist in db");
					   }else {
						   System.out.println("ofc_details_id is not exist in db");
						   Sendmail.sendmail("ofc_details_id is not exist in db");
					   }
					   
					   String DBOffPin=(String) result.getObject("ofc_pin_code");
					   
					   if(DBOffPin.contains(officePin)) {
						   //System.out.println("ofc_pin_code is exist in db");
					   }else {
						   System.out.println("ofc_pin_code is not exist in db");
						   Sendmail.sendmail("ofc_pin_code is not exist in db");
					   }
					   
					   String DbOfficeNo=(String) result.getObject("ofc_door_number");
					   
					   if(DbOfficeNo.contains(OfficeNo)) {
						   //System.out.println("ofc_door_number is exist in  db");
					   }else {
						   System.out.println("ofc_door_number is not exist in db");
						   Sendmail.sendmail("ofc_door_number is not exist in db");
					   }
					   
					   String DbofficeStreet=(String) result.getObject("ofc_street");
					   
					   if(DbofficeStreet.contains(OfficeStreet)) {
						  // System.out.println("ofc_street is exist in db");
					   }else {
						   System.out.println("ofc_street is not exist in db");
						   Sendmail.sendmail("ofc_street is not exist in db");
					   }
					   
					   String DbOfficeArea=(String) result.getObject("ofc_locality");
					   
					   if(DbOfficeArea.contains(OfficeArea)) {
						   //System.out.println("ofc_locality is exist in db");
					   }else {
						   System.out.println("ofc_locality is not exist in db");
						   Sendmail.sendmail("ofc_locality is not exist in db");
					   }
			   
					   if(result.getObject("ofc_district") !=null) {
						  // System.out.println("ofc_district is exist in db");
					   }else {
						   System.out.println("ofc_district is not exist in db");
						   Sendmail.sendmail("ofc_district is not exist in db");
					   }
					   
					   if(result.getObject("ofc_city") !=null) {
						   //System.out.println("ofc_city is exist in db");
					   }else {
						   System.out.println("ofc_city is not exist in db");
						   Sendmail.sendmail("ofc_city is not exist in db");
					   }
					   
					   if(result.getObject("ofc_state") !=null) {
						   //System.out.println("ofc_state is exist in db");
					   }else {
						   System.out.println("ofc_state is not exist in db");
						   Sendmail.sendmail("ofc_state is not exist in db");
					   }
					   
					   if(result.getObject("ofc_std_code") !=null) {
						   //System.out.println("ofc_std_code is exist in db");
					   }else {
						   System.out.println("ofc_std_code is not exist in db");
						   Sendmail.sendmail("ofc_std_code is not exist in db");
					   }
					   
					   if(result.getObject("salary_mode") !=null) {
						   //System.out.println("salary_mode is exist in db");
					   }else {
						   System.out.println("salary_mode is not exist in db");
						   Sendmail.sendmail("salary_mode is not exist in db");
					   }
					   
					   if(result.getObject("personal_id") !=null) {
						   //System.out.println("personal_id is exist in db");
					   }else {
						   System.out.println("personal_id is not exist in db");
						   Sendmail.sendmail("personal_id is not exist in db");
					   }
					   
					   if(result.getObject("crdate") !=null) {
						   //System.out.println("crdate is exist in db");
					   }else {
						   System.out.println("crdate is not exist in db");
						   Sendmail.sendmail("crdate is not exist in db");
					   }
					   
					   if(result.getObject("marital_status") !=null) {
						   //System.out.println("marital_status is exist in db");
					   }else {
						   System.out.println("marital_status is not exist in db");
						   Sendmail.sendmail("marital_status is not exist in db");
					   }
					   
					   if(result.getObject("educational_qualification") !=null) {
						   //System.out.println("educational_qualification is exist in db");
					   }else {
						   System.out.println("educational_qualification is not exist in db");
						   Sendmail.sendmail("educational_qualification is not exist in db");
					   }
					   
					   if(result.getObject("id") !=null) {
						  // System.out.println("id is exist in db");
					   }else {
						   System.out.println("id is not exist in db");
						   Sendmail.sendmail("id is not exist in db");
					   }
					   
					   if(result.getObject("is_existing_cc") !=null) {
						   //System.out.println("is_existing_cc is exist in db");
					   }else {
						   System.out.println("is_existing_cc is not exist in db");
						   Sendmail.sendmail("is_existing_cc is not exist in db");
					   }
					   
					   if(result.getObject("createdDate") !=null) {
						  // System.out.println("createdDate is exist in db");
					   }else {
						   System.out.println("createdDate is not exist in db");
						   Sendmail.sendmail("createdDate is not exist in db");
					   }
					   
					   if(result.getObject("modifiedDate") !=null) {
						   //System.out.println("modifiedDate is exist in db");
					   }else {
						   System.out.println("modifiedDate is not exist in db");
						   Sendmail.sendmail("modifiedDate is not exist in db");
					   }
					   
					   if(result.getObject("nbfc_process_id") !=null) {
						  // System.out.println("nbfc_process_id is exist in db");
					   }else {
						   System.out.println("nbfc_process_id is not exist in db");
						   Sendmail.sendmail("nbfc_process_id is not exist in db");
					   }
					   
					   if(result.getObject("process_date") !=null) {
						  // System.out.println("process_date is exist in db");
					   }else {
						   System.out.println("process_date is not exist in db");
						   Sendmail.sendmail("process_date is not exist in db");
					   }
					   
					   if(result.getObject("is_api_hit") !=null) {
						   //System.out.println("is_api_hit is exist in db");
					   }else {
						   System.out.println("is_api_hit is not exist in db");
						   Sendmail.sendmail("is_api_hit is not exist in db");
					   }
					   
					   if(result.getObject("is_api_hit_success") !=null) {
						   //System.out.println("is_api_hit_success is exist in db");
					   }else {
						   System.out.println("is_api_hit_success is not exist in db");
						   Sendmail.sendmail("is_api_hit_success is not exist in db");
					   }
					   
					   if(result.getObject("reference_number") !=null) {
						   //System.out.println("reference_number is exist in db");
					   }else {
						   System.out.println("reference_number is not exist in db");
						   Sendmail.sendmail("reference_number is not exist in db");
					   }
					   
					   if(result.getObject("process_status") !=null) {
						  // System.out.println("process_status is exist in db");
					   }else {
						   System.out.println("process_status is not exist in db");
						   Sendmail.sendmail("process_status is not exist in db");
					   }
					   
					   if(result.getObject("status_comments") !=null) {
						   //System.out.println("status_comments is exist in db");
					   }else {
						   System.out.println("status_comments is not exist in db");
						   Sendmail.sendmail("status_comments is not exist in db");
					   }
					   
					   if(result.getObject("is_error") !=null) {
						   //System.out.println("is_error is exist in db");
					   }else {
						   System.out.println("is_error is not exist in db");
						   Sendmail.sendmail("is_error is not exist in db");
					   }
					   
					   if(result.getObject("sl_id") !=null) {
						   //System.out.println("sl_id is exist in db");
					   }else {
						   System.out.println("sl_id is not exist in db");
						   Sendmail.sendmail("sl_id is not exist in db");
					   }
					   
					   if(result.getObject("sl_admin_id") !=null) {
						   //System.out.println("sl_admin_id is exist in db");
					   }else {
						   System.out.println("sl_admin_id is not exist in db");
						   Sendmail.sendmail("sl_admin_id is not exist in db");
					   }
					   
					   if(result.getObject("sl_request") !=null) {
						  // System.out.println("sl_request is exist in db");
					   }else {
						   System.out.println("sl_request is not exist in db");
						   Sendmail.sendmail("sl_request is not exist in db");
					   }
					   
					   if(result.getObject("sl_response") !=null) {
						   //System.out.println("sl_response is exist in db");
					   }else {
						   System.out.println("sl_response is not exist in db");
						   Sendmail.sendmail("sl_response is not exist in db");
					   }
					   
					   if(result.getObject("sl_created_date") !=null) {
						   
						   //System.out.println("sl_created_date is exist in db");
					   }else {
						   System.out.println("sl_created_date is not exist in db");
						   Sendmail.sendmail("sl_created_date is not exist in db");
					   }
					   
					   //Optional DB value verification
					   
					   if(result.getObject("sbi_relation_type") !=null) {
						   //System.out.println("sbi_relation_type value exist in db");
					   }else {
						   System.out.println("sbi_relation_type value is showing NUll");
						   Sendmail.sendmail("sbi_relation_type value is showing NUll");
					   }
					   
					   String dbAccount=(String) result.getObject("account_number");
					   if(dbAccount.contains(acc)) {
						  // System.out.println("Account no is exist in db");
					   }else {
						   System.out.println("Account no is not exist in db");
						   Sendmail.sendmail("Account no is not exist in db");
					   }
					   
					   if(result.getObject("res_std_code") ==null) {
						   System.out.println("res_std_code value is exist in db");
					   }else {
						   System.out.println("res_std_code value is not exist in db");
					   }
					   
					   if(result.getObject("res_landline_number") !=null) {
						   System.out.println("res_landline_number value is exist in db");
					   }else {
						   System.out.println("res_landline_number value is not exist in db");
					   }
					   
					   String dbOffNo=(String) result.getObject("ofc_landline_number");
					   if(dbOffNo.contains(off_landline)) {
						   //System.out.println("ofc_landline_number is exist in db");
					   }else {
						   System.out.println("ofc_landline_number is not exist in db");
						   Sendmail.sendmail("ofc_landline_number is not exist in db");
					   }
					   
					   if(result.getObject("existing_lender_id") !=null) {
						   //System.out.println("existing_lender_id exist in db");
					   }else {
						   System.out.println("existing_lender_id is not exist in db");
						   Sendmail.sendmail("existing_lender_id is not exist in db");
					   }
					   
					   BigDecimal DbMaxlimit=(BigDecimal) result.getObject("max_limit");
					   
					   if( MaxLimit ==(DbMaxlimit.doubleValue())) {
						   //System.out.println("max_limit value is exist in db");
					   }else {
						   System.out.println("max_limit value is not exist in db");
						   Sendmail.sendmail("max_limit value is not exist in db");
					   }
					   										   
					   if(result.getObject("is_alternate_contact_no") !=null) {
						  // System.out.println("is_alternate_contact_no is exist in db");
					   }else {
						   System.out.println("is_alternate_contact_no is not exist in db");
						   Sendmail.sendmail("is_alternate_contact_no is not exist in db");
					   }
					   
					   System.out.println("*************DB Value verified successfully=================");
					   // Optional DB value verification end //
					   
					  
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
