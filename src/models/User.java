package models;

import java.text.ParseException;
import java.text.SimpleDateFormat;  
import java.util.Date;  

public class User {
	
	private int id;
	private String name;
    private String email;
    private String gender;
    private String status;
    private String created_at;
    private String updated_a;
    
    public int getId() {
		return id;
	}
    
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setGender(String gender) {;
		this.gender = gender;
	}
	
	public char getGender() {
		char res = ' ';
		if (gender.equals("Female")) res = 'F';
		if (gender.equals("Male")) res = 'M';

		return res;
	}
	
	public void setGender(char gender) {
		if (gender == 'F') this.gender = "Female";
		if (gender == 'M') this.gender = "Male";
	}
	
	public Boolean getStatus() {
		Boolean res = false;
		if (status == "Active") res = true;
		
		return res;
	}
	
	public void setStatus(Boolean status) {
		if (status) this.status = "Active";
		else this.status = "Inactive";
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getCreated_at() {
		return created_at;
	}
	
	public Date getCreated_atDate() {
		Date date = null;
		
		try {
			date = getDateFromString(created_at);
		}
		catch(ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	
	public String getUpdated_at() {
		return updated_a;
	}
	
	public Date getUpdated_atDate() {
		Date date = null;
		
		try {
			date = getDateFromString(updated_a);
		}
		catch(ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	public void setUpdated_at(String updated_a) {
		this.updated_a = updated_a;
	}
	
	//Applies some modification to the current user
	public void getModified() {		
		this.setName("My name is " + this.name);
		this.setEmail("My email is " + this.email);
		if (this.getGender() == 'M') {
			this.setGender('F');
		}
		else {
			this.setGender('M');
		}
		if (!this.getStatus()) {
			this.setStatus(true);
		}
		this.setCreated_at(this.getCreated_at());
		this.setUpdated_at(this.getUpdated_at());
	}
	
	//returns the Date object from the string in 'dd/MM/yyyy' format
	private Date getDateFromString(String strDate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date date = sdf.parse(strDate);
		return date;		
	}
}
