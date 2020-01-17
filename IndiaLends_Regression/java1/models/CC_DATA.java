package models;

import java.io.Serializable;

public class CC_DATA implements Serializable{

	private String mobileNo,ofc_name;
    private String pincode;
    private String company,Designation,IsExistingCC,existing_lender;

    private int salary,Eligbility;
    private int Age,ResidentType;
	private int CardType;
    private int empType;
    private int isItr;
    private int Status;	    
    private String guserid,qgid;
	private int mode;
//	private String lender_id;
	private int getlenderid;
	private String lenderid,DOB;
	private int iscardSpecific;
	private int RelationshipwithICICI;
	private int ExistingHDFCAccount,SalarySlip;
	private String Existingcardlimit;
	private String salary_mode;

	
	String leadunique;
	
	public String getLeadunique() {
		return leadunique;
	}

	public void setLeadunique(String leadunique) {
		this.leadunique = leadunique;
	}

			
	public int getMode() {
		return mode;
	}

	public void setMode(int mode) {
		this.mode = mode;
	}
	
	
	public String getofc_name() {
		return ofc_name;
	}

	public void setofc_name(String ofc_name) {
		this.ofc_name = ofc_name;
	}
	
	
	
   public int getResidentType1() {
	  return ResidentType;
    }

    public void setResidentType1(int ResidentType) {
	  this.ResidentType = ResidentType;
   }
	
	
	

	public String getisExistingCC() {
	return IsExistingCC;
	}
	
	public void setisExistingCC(String isExistingCC) {
		this.IsExistingCC = isExistingCC;
	}

	
	
	public int getRelationshipwithICICI() {
		return RelationshipwithICICI;
	}

	public void setRelationshipwithICICI(int RelationshipwithICICI) {
		this.RelationshipwithICICI = RelationshipwithICICI;
	}
	
	
	
	
/*	public String getLender_id() {
		return lender_id;
	}

	public void setLender_id(String lender_id) {
		this.lender_id = lender_id;
	}*/

	
	public int getiscardSpecific() {
		return iscardSpecific;
	}

	public void setiscardSpecific(int iscardSpecific) {
		this.iscardSpecific = iscardSpecific;
	}
	
	public int getGetlenderid() {
		return getlenderid;
	}

	public void setGetlenderid(int getlenderid) {
		this.getlenderid = getlenderid;
	}

	public String getLenderid() {
		return lenderid;
	}

	public void setLenderid(String lenderid) {
		this.lenderid = lenderid;
	}

	public void setAge(int age) {
		Age = age;
	}


    public String getMobileNo() {
			return mobileNo;
		}

		public void setMobileNo(String mobileNo) {
			this.mobileNo = mobileNo;
		}

		
		 public int getEligbility() {
				return Eligbility;
			}

			public void setEligbility(int Eligbility) {
				this.Eligbility = Eligbility;
			}
		
		
		  public String getDesignation() {
				return Designation;
			}

			public void setDesignation(String Designation) {
				this.Designation = Designation;
			}
		
		
		
		public String getPincode() {
			return pincode;
		}

		public void setPincode(String pincode) {
			this.pincode = pincode;
		}

		
		public String getDOB() {
			return DOB;
		}

		public void setDOB(String DOB) {
			this.DOB = DOB;
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
		
		public int getmode() {
			return mode;
		}

		public void setmode(int mode) {
			this.mode = mode;
		}
		
		
		public int getCardType() {
			return CardType;
		}

		public void setCardType(int CardType) {
			this.CardType = CardType;
		}
		
		

		public int getIsItr() {
			return isItr;
		}

		public void setIsItr(int isItr) {
			this.isItr = isItr;
		}

		public int getAge() {
			return Age;
		}

		public void setAge1(int Age) {
			this.Age = Age;
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

		
		public String getlenderid() {
			return lenderid;
		}

		public void setlenderid(String lenderid) {
			this.lenderid = lenderid;
		}
		
		
		
		public CC_DATA(String mobileNo, String pincode, 
	                      int salary,int empType,int Age,int Card_Type,int isItr, String lenderid, String DOB, String Designation, String Company,int iscardSpecific
,int RelationshipwithICICI,int ExistingHDFCAccount,int SalarySlip,String Existingcardlimit,String salary_mode,String isExistingCC,String existing_lender,
int ResidentType,String ofc_name) {
	        super();
	        this.mobileNo = mobileNo;
	        this.pincode = pincode;
	        this.salary = salary;
	        this.empType=empType;
	        this.Age = Age;
	        this.CardType=Card_Type;
	        this.isItr=isItr;
	        this.company = Company;
	        this.lenderid=lenderid;
	        this.DOB = DOB;
	        this.Designation = Designation;
	        this.Eligbility =Eligbility;
	     //   this.lender_id = lender_id;
	        this.iscardSpecific = iscardSpecific;
	       this.RelationshipwithICICI = RelationshipwithICICI;
	       this.Existingcardlimit = Existingcardlimit;
	       this.SalarySlip = SalarySlip;
	       this.ExistingHDFCAccount = ExistingHDFCAccount;
	       this.salary_mode = salary_mode;
	       this.existing_lender = existing_lender;
	       this.IsExistingCC = isExistingCC;
	       this.ResidentType =ResidentType;
	       this.ofc_name = ofc_name;
	        
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
	   /*
	    public String getDOB() {
	        return DOB;
	    }
	    public void setDOB1(String DOB) {
	        this.DOB = DOB;
	    }*/
	    
	    
	    
	    
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
	    
	    public String getcompany() {
	        return company;
	    }
	    public void setcompany(String company) {
	        this.company = company;
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
	  /* public int getAge1() {
	        return Age;
	    }
	    public void setAge11(int Age) {
	        this.Age = Age;
	    }
	 */
	    
	  /* public String getLender_id1() {
			return lender_id;
		}

		public void setLender_id1(String lender_id) {
			this.lender_id = lender_id;
		}*/

		
		/*public int getiscardSpecific() {
			return iscardSpecific;
		}

		public void setiscardSpecific(int iscardSpecific) {
			this.iscardSpecific = iscardSpecific;
		}*/
	    
	      
	    @Override
	    public String toString() {
	        return "Employee [mobileNo=" + mobileNo + ", pincode=" + pincode
	                + ", salary=" + salary + ", empType=" + empType +",Age=" + Age +",isItr="+isItr+",CardTyp=" + CardType+""
	             + ",lenderid="+lenderid+", DOB="+DOB+",Designation="+Designation+",Company=" +company+",iscardSpecific=" + iscardSpecific+","
	       	+ "RelationshipwithICICI=" + RelationshipwithICICI+",ExistingHDFCAccount=" +ExistingHDFCAccount+",SalarySlip="+SalarySlip+",Existingcardlimit="+Existingcardlimit+",salary_mode="
	             +salary_mode+",isExistingCC="+IsExistingCC+",existing_lender="+existing_lender+",ResidentType="+ResidentType+",ofc_name="+ofc_name+"]";
	    }

		public int getExistingHDFCAccount() {
			return ExistingHDFCAccount;
		}

		public void setExistingHDFCAccount(int existingHDFCAccount) {
			ExistingHDFCAccount = existingHDFCAccount;
		}

		public int getSalarySlip() {
			return SalarySlip;
		}

		public void setSalarySlip(int salarySlip) {
			SalarySlip = salarySlip;
		}

		public String getExistingcardlimit() {
			return Existingcardlimit;
		}

		public void setExistingcardlimit(String existingcardlimit) {
			Existingcardlimit = existingcardlimit;
		}

		public String getSalary_mode() {
			return salary_mode;
		}

		public void setSalary_mode(String salary_mode) {
			this.salary_mode = salary_mode;
		}

		public String getIsExistingCC() {
			return IsExistingCC;
		}

		public void setIsExistingCC(String isExistingCC) {
			this.IsExistingCC = isExistingCC;
		}

		public String getExisting_lender() {
			return existing_lender;
		}

		public void setExisting_lender(String existing_lender) {
			this.existing_lender = existing_lender;
		}

		public int getResidentType() {
			return ResidentType;
		}

		public void setResidentType(int residentType) {
			ResidentType = residentType;
		}

		public String getOfc_name() {
			return ofc_name;
		}

		public void setOfc_name(String ofc_name) {
			this.ofc_name = ofc_name;
		}

		

		

}
