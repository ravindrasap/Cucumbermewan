package models;
import java.io.Serializable;

@SuppressWarnings("serial")
public class SSL_DATA implements Serializable{

	private String Domainname,SerialNumber,Status;
    private String Certificateused;
    private String Validfrom;
	private String Validto;

    public String getDomainname() {
	return Domainname;
	}

	public void setDomainname(String domainname) {
		this.Domainname = domainname;
	}

	public String getSerialNumber() {
		return SerialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.SerialNumber = serialNumber;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		this.Status = status;
	}

	public String getCertificateused() {
		return Certificateused;
	}

	public void setCertificateused(String certificateused) {
		this.Certificateused = certificateused;
	}

	public String getValidfrom() {
		return Validfrom;
	}

	public void setValidfrom(String validfrom) {
		this.Certificateused = validfrom;
	}

	public String getValidto() {
		return Validto;
	}

	public void setValidto(String validto) {
		this.Validto = validto;
	}

	
	public SSL_DATA(String Domainname, String Certificateused, 
            String Validfrom,String Validto, String SerialNumber, String Status) {
super();
this.Domainname = Domainname;
this.Certificateused = Certificateused;
this.Validfrom = Validfrom;
this.Validto = Validto;
this.SerialNumber = SerialNumber;
this.Status = Status;
	}

@Override
public String toString() {
    return "Employee [Domainname=" + Domainname + ", Certificateused=" + Certificateused
            + ", Validfrom=" + Validfrom + ", Validto=" + Validto +",SerialNumber=" + SerialNumber +",Status="+Status+"]";
}



public String getdomainname() {
	return Domainname;
}

public void setdDomainname (String Domainname) {
	this.Domainname = Domainname;
}

public String getcertificateused() {
	return Certificateused;
}

public void setcertificateused(String Certificateused) {
	this.Certificateused = Certificateused;
}

public String getvalidfrom() {
	return Validfrom;
}

public void setvalidfrom (String Validfrom) {
	this.Validfrom = Validfrom;
}
public String getvalidto() {
	return Validto;
}

public void setvalidto(String Validto) {
	this.Validto = Validto;
}
public String getserialNumber() {
	return SerialNumber;
}

public void setserialNumber(String SerialNumber) {
	this.SerialNumber = SerialNumber;
}
public String getstatus() {
	return Status;
}

public void setStatusd(String Status) {
	this.Status = Status;
}

}

