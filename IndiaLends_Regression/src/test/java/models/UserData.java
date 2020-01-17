package models;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class UserData implements Serializable {

	 private String mobileNo;
	    private String pincode;
	    private String company;
	 //  private int salary;
	    private int empType;
	    private int isItr;
	    private int Status;
	    private String dob,guserid,qgid;;
	String Pincode, Company,SalaryMode,Designation,ExistingLenderId,salary;
	
	int Employeetype, Age,Mode,PaySlip,Existing_account;
	String Mobile_no;
	int isITR, LenderId, Cardtype,Icicirelation,Maxlimit,UserId;

	
	
	public int getCardtype() {
		return Cardtype;
	}

	public void setCardtype(int cardtype) {
		this.Cardtype = cardtype;
	}
	
	public int UserId() {
		return UserId;
	}

	public void setUserId(int userId) {
		this.UserId = userId;
	}
		
	
	public int getIcicirelation() {
		return Icicirelation;
	}

	public void setIcicirelation (int icicirelation) {
		this.Icicirelation = icicirelation;
	}
	
	
	public int getPaySlip() {
		return PaySlip;
	}

	public void setPaySlip (int paySlip) {
		this.PaySlip = paySlip;
	}
	
	
	
	public int getExisting_account() {
		return Existing_account;
	}

	public void setExisting_account (int existing_account) {
		this.Existing_account = existing_account;
	}
	
	public int getMode() {
		return Mode;
	}

	public void setMode (int mode) {
		this.Mode = mode;
	}
	
	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		this.Age = age;
	}
	
	public int getLenderId() {
		return LenderId;
	}

	public void setLenderId(int lenderId) {
		this.LenderId = lenderId;
	}

	public String getSalaryMode() {
		return SalaryMode;
	}
	
	public void setSalaryMode(String SalaryMode) {
		SalaryMode = SalaryMode;
	}
	
	public int getMaxlimit() {
		return Maxlimit;
	}
	
	public void setMax_limit(String Maxlimit) {
		Maxlimit = Maxlimit;
	}
	
	
	
	public String getDesignatione() {
		return Designation;
	}

	public void setDesignation(String Designation) {
		Designation = Designation;
	}
	
	public String getExistingLenderId() {
		return ExistingLenderId;
	}

	public void setExistingLenderId(String existingLenderId) {
		ExistingLenderId = existingLenderId;
	}
	
	
	public String getPincode() {
		return Pincode;
	}

	public void setPincode(String pincode) {
		Pincode = pincode;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public int getEmployeetype() {
		return Employeetype;
	}

	public void setEmployeetype(int employeetype) {
		this.Employeetype = employeetype;
	
	}
	
	public int getisITR() {
		return isITR;
	}

	public void setITR(int isITR) {
		isITR = isITR;
	}

	public String getCompany() {
		return Company;
	}

	public void setCompany(String company) {
		Company = company;
	}

	
	public int getMObile() {
		return isITR;
	}

	public void setgetMObile(int getMObile) {
		getMObile = getMObile;
	}
	public UserData(String eligibilityDetails, String eligibilityDetails2, String eligibilityDetails3, int i, int j, int k, int l, String eligibilityDetails4, String pincode, String mobileNo, String company, int salary, int empType, int isItr, int Status, String dob) {
super();
this.mobileNo = mobileNo;
this.pincode = pincode;
this.company = company;
//this.salary = salary;
this.empType=empType;
this.isItr=isItr;
this.Status=Status;
this.dob=dob;

}

public UserData(String eligibilityDetails, String eligibilityDetails2, String eligibilityDetails3, int i, int j, int k, int l, String eligibilityDetails4) {
		// TODO Auto-generated constructor stub
	}

public UserData(String string) {
	// TODO Auto-generated constructor stub
}

public UserData() {
	// TODO Auto-generated constructor stub
}

public String getmobileNo() {
return mobileNo;
}
public void setmobileNo(String mobileNo) {
this.mobileNo = mobileNo;
}
public String getpincode() {
return pincode;
}
public void setpincode(String pincode) {
this.pincode = pincode;
}

public String getMobile_no() {
	// TODO Auto-generated method stub
	return Mobile_no;
}
public void setMobile_no(String Mobile_no) {
this.Mobile_no = Mobile_no;
}
}
