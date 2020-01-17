package CSV_Reader;

import java.io.Serializable;

public class PL_DATA implements Serializable
{
    private String mobileNo;
    private String pincode,resType;
    private String company;
    private int salary;
    private int empType;
    private int isItr,l_city_id;
    private int Status;
    private String dob,guserid,qgid;;
    private String SalaryMode;
    private int PanStatus,CrExpYr,CrExpMonth,totalExpYr,totalExpMonth,yrAddress,monthAddress,FinalStatus;
    
    			
    public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getEmpType() {
		return empType;
	}

	public void setEmpType(int empType) {
		this.empType = empType;
	}

	public int getIsItr() {
		return isItr;
	}

	public void setIsItr(int isItr) {
		this.isItr = isItr;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGuserid() {
		return guserid;
	}

	public void setGuserid(String guserid) {
		this.guserid = guserid;
	}

	public String getQgid() {
		return qgid;
	}

	public void setQgid(String qgid) {
		this.qgid = qgid;
	}
	public String getSalaryMode() {
		return SalaryMode;
	}

	public void setSalaryMode(String SalaryMode) {
		this.SalaryMode = SalaryMode;
	}
	public int getPanStatus() {
		return PanStatus;
	}

	public void setPanStatus(int PanStatus) {
		this.PanStatus = PanStatus;
	}
	public int getCrExpYr() {
		return CrExpYr;
	}

	public void setCrExpYr(int CrExpYr) {
		this.CrExpYr = CrExpYr;
	}
	public int getCrExpMonth() {
		return CrExpMonth;
	}

	public void setCrExpMonth(int CrExpMonth) {
		this.CrExpMonth = CrExpMonth;
	}
	public int gettotalExpYr() {
		return totalExpYr;
	}

	public void settotalExpYr(int totalExpYr) {
		this.totalExpYr = totalExpYr;
	}
	public int gettotalExpMonth() {
		return totalExpMonth;
	}

	public void settotalExpMonth(int totalExpMonth) {
		this.totalExpMonth = totalExpMonth;
	}
	public String getresType() {
		return resType;
	}

	public void setresType(String resType) {
		this.resType = resType;
	}
	public int getyrAddress() {
		return yrAddress;
	}

	public void setyrAddress(int yrAddress) {
		this.yrAddress = yrAddress;
	}
	public int getmonthAddress() {
		return monthAddress;
	}

	public void setmonthAddress(int monthAddress) {
		this.monthAddress = monthAddress;
	}
	public int getFinalStatus() {
		return FinalStatus;
	}

	public void setFinalStatus(int FinalStatus) {
		this.FinalStatus = FinalStatus;
	}
	public PL_DATA(String mobileNo, String pincode, 
                     String company, int salary,int empType,int isItr,int Status,String dob,String SalaryMode,int PanStatus,
                     int CrExpYr,int CrExpMonth,int totalExpYr,int totalExpMonth,String resType,int yrAddress,int monthAddress,int FinalStatus) {
        super();
        this.mobileNo = mobileNo;
        this.pincode = pincode;
        this.company = company;
        this.salary = salary;
        this.empType=empType;
        this.isItr=isItr;
        this.Status=Status;
        this.dob=dob;
        this.SalaryMode=SalaryMode;
        this.PanStatus=PanStatus;
        this.CrExpYr=CrExpYr;
        this.CrExpMonth=CrExpMonth;
        this.totalExpYr=totalExpYr;
        this.totalExpMonth=totalExpMonth;
        this.resType=resType;
        this.yrAddress=yrAddress;
        this.monthAddress=monthAddress;
        this.FinalStatus=FinalStatus;
        
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
    public String getcompany() {
        return company;
    }
    public void setcompany(String company) {
        this.company = company;
    }
    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
    public int getempType() {
        return empType;
    }
    public void setempType(int empType) {
        this.empType = empType;
    }
    public int getisItr() {
        return isItr;
    }
    public void setisItr(int isItr) {
        this.isItr = isItr;
    }
    public int getStatus() {
        return Status;
    }
    public void setStatus(int Status) {
        this.Status = Status;
    }
    public String getdob() {
        return dob;
    }
    public void setdob(String dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Employee [mobileNo=" + mobileNo + ", pincode=" + pincode
                + ", company=" + company + ", salary=" + salary + ", empType=" + empType +",isItr="+isItr+",Status="+Status+" ,"
                		+ "dob="+dob+",SalaryMode="+SalaryMode+",PanStatus="+PanStatus+",CrExpYr="+CrExpYr+",CrExpMonth="+CrExpMonth+","
                				+ "totalExpYr="+totalExpYr+",totalExpMonth="+totalExpMonth+",resType="+resType+",yrAddress="+yrAddress+""
                						+ ",monthAddress="+monthAddress+",FinalStatus="+FinalStatus+"]";
    }

	public int getL_city_id() {
		return l_city_id;
	}

	public void setL_city_id(int l_city_id) {
		this.l_city_id = l_city_id;
	}
}