package DBValidation;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.testng.annotations.Test;

import Utility.Base;

public class SBILenderDBCrosssell {

		@Test
		public class Verify_CCSBI_DB_Values {

		String dbURL = Base.loadPropertiesFile("DB.properties", "dbURL");
		String user = Base.loadPropertiesFile("DB.properties", "user");
		String password = Base.loadPropertiesFile("DB.properties", "password");
		String mob ="5237264748";

		public void fetchDbValue(String mob) {
	//	public void fetchDbValue() {

		//try {
	
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(dbURL, user, password);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (connection != null) {
		System.out.println("Connected to the database");
		System.out.println("Mobile No is:" + mob);
		try {

		String query = "select alo.admin_id,alo.ismobile_verified,alo.l_city_id,alo.l_name,alo.l_is_tele_status,alo.l_email_id,"
		+ "alo.l_physical_q_answers,alo.qu_montly_income,alo.qu_companyname,alo.pl_lenders,alo.l_loan_type,alo.l_loan_amount,"
		+ "ui.u_gender,ui.u_email_id,ui.u_emp_tpe,ui.bank_type,ui.p_monthly_income,ui.u_mobile_number,ui.marriage_status,"
		+ "UI.c_address_two,UI.c_city,UI.c_state,UI.u_first_name,UI.u_last_name,UI.u_gender,UI.u_date_of_birth,UI.p_pancard_id,UI.c_payment_mode,UI.c_address_one,\r\n"
		+ "cdo.c_current_company_exp,cdo.c_pincode,cdo.c_address_one,cdo.c_address_two,cdo.c_city,cdo.c_state,cdo.c_total_exp,cdo.c_name,\r\n"
		+ "pio.p_ownership,pio.p_years_in_adress,pio.p_edu_qualification,pio.bank_name,pio.p_pincode,pio.p_address_one,pio.p_address_two,pio.p_city,pio.p_state,"
		+ "qo.seo_track,qo.seo_track_url,"
		+ "cb.q_g_id,cb.loan_amount,cb.gender,cb.dob,cb.pan_number,cb.cr_date,cb.res_add_one,cb.res_add_two,cb.payment_mode,cb.city,cb.state,cb.age,cb.BankName\r\n"
		+ "from user_information (nolock) as UI \r\n"
		+ "inner join admin_Leads_object (nolock) as alo on ui.u_user_id=alo.u_user_id\r\n"
		+ "inner join personalinfo_object(nolock)  as pio on alo.admin_id=pio.admin_id\r\n"
		+ "inner join companydetails_object (nolock) as cdo on alo.admin_id=cdo.admin_id "
		+ "inner join quote_object (nolock) as qo on alo.qu_id=qo.qu_id\r\n"
		+ "inner join cibil_pull_lead_logger cb on qo.q_g_id= cb.q_g_id\r\n"
		+ "where ui.u_mobile_number=" + "'" + mob + "'";

		// "select * from admin_leads_object where l_mobile_no= " + "'" + mobile + "'";
	//	PreparedStatement pstmtmv = connection.prepareStatement(query);

		CallableStatement pstmt = connection.prepareCall(query);
		ResultSet result = pstmt.executeQuery();
		ResultSet res = pstmt.getResultSet();
		// ResultSetMetaData rsmd = result.getMetaData();

		// int numberOfColumns = rsmd.getColumnCount();

		while (result.next()) {
		System.out.println("Admin_id is: " + result.getObject("admin_id") + "\n" + "l_city_id:"
		+ result.getObject("l_city_id") + "\n" + "pl_lenders:" + result.getObject("pl_lenders")
		+ "\n" + "seo_track:" + result.getObject("seo_track") + "\n" + "seo_track_url:"
		+ result.getObject("seo_track_url") + "\n" + "l_Name:" + result.getObject("l_name")
		+ "\n" + "u_first_name:" + result.getObject("u_first_name") + "\n" + "u_last_name:"
		+ result.getObject("u_last_name") + "\n" + "u_email_id:"
		+ result.getObject("u_email_id") + "\n" + "p_pincode:" + result.getObject("p_pincode")
		+ "\n" + "u_emp_tpe:" + result.getObject("u_emp_tpe") + "\n" + "c_name:"
		+ result.getObject("c_name") + "\n" + "p_monthly_income:"
		+ result.getObject("p_monthly_income") + "\n" + "u_mobile_number:"
		+ result.getObject("u_mobile_number") + "\n" + "l_loan_amount:"
		+ result.getObject("l_loan_amount") + "\n" + "u_gender:" + result.getInt("u_gender")
		+ "\n" + "u_date_of_birth:" + result.getObject("u_date_of_birth") + "\n"
		+ "p_pancard_id:" + result.getObject("p_pancard_id") + "\n" + "c_payment_mode:"
		+ result.getObject("c_payment_mode") + "\n" + "c_address_one:"
		+ result.getObject("c_address_one") + "\n" + "c_address_two:"
		+ result.getObject("c_address_two") + "\n" + "c_city:" + result.getObject("c_city")
		+ "\n" + "c_state:" + result.getObject("c_state") + "\n" + "p_edu_qualification:"
		+ result.getObject("p_edu_qualification") + "\n" + "marriage_status:"
		+ result.getObject("marriage_status") + "\n" + "l_loan_type:"
		+ result.getObject("l_loan_type") + "\n" + "c_current_company_exp:"
		+ result.getObject("c_current_company_exp") + "\n" + "c_pincode:"
		+ result.getObject("c_pincode") + "\n" + "c_address_one:"
		+ result.getObject("c_address_one") + "\n" + "c_address_two:"
		+ result.getObject("c_address_two") + "\n" + "c_city:" + result.getObject("c_city")
		+ "\n" + "c_state:" + result.getObject("c_state") + "\n" + "c_total_exp:"
		+ result.getObject("c_total_exp") + "\n" + "p_ownership:"
		+ result.getObject("p_ownership") + "\n" + "p_years_in_adress:"
		+ result.getObject("p_years_in_adress") + "\n" + "bank_type:"
		+ result.getObject("bank_type") + "\n");
	
		
	}

		}
		
		catch (SQLException e) {
			System.out.println("Exception is:" + e.getMessage());
			e.printStackTrace();
		}
		}
		}
		}
}