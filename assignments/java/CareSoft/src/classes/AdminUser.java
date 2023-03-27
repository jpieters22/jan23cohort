package classes;

import java.util.ArrayList;
import java.util.Date;

import com.caresoft.clinicapp.HIPAACompliantAdmin;
import com.caresoft.clinicapp.HIPAACompliantUser;

public class AdminUser extends User implements HIPAACompliantUser, HIPAACompliantAdmin {

	private Integer employeeID;
	private String role;
	private ArrayList<String> securityIncidents;
	
	public AdminUser(Integer id, String role) {
		super(id);
		this.role = role;
		this.securityIncidents = new ArrayList<String>();
	}

	@Override
	public ArrayList<String> reportSecurityIncidents() {
		// TODO Auto-generated method stub
		return this.securityIncidents;
	}

	@Override
	public boolean assignPin(int pin) {
		if(pin < 100000) {
			return false;
		}
		this.pin = pin;
		return true;
	}

	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		if(this.id.equals(confirmedAuthID)) {
			return true;
		}
		this.authIncident();
		return false;
	}
	
	public void newIncident(String notes) {
		String report = String.format("Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", new Date(),this.id, notes);
		this.securityIncidents.add(report);
	}
	
	public void authIncident() {
		String report = String.format("Datetime Submitted: %s \n,  ID: %d\n Notes: %s \n", new Date(), this.id,"AUTHORIZATION ATTEMPT FAILED FOR THIS USER");
		this.securityIncidents.add(report);
	}

	public Integer getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(Integer employeeID) {
		this.employeeID = employeeID;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public ArrayList<String> getSecurityIncidents() {
		return securityIncidents;
	}

	public void setSecurityIncidents(ArrayList<String> securityIncidents) {
		this.securityIncidents = securityIncidents;
	}
	
	
	
}
