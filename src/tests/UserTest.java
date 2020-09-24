package tests;

import org.junit.Test;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import models.User;

public class UserTest {
	
	//Expects a null in not assigned dates
	@Test
	public void testGetUserDateNull() {
		//STEP 1: create the User object
		User u1 = new User();
		  
		//STEP2: check the object and its attributes
		assertNull("The user CreatedAt date is not null", u1.getCreated_atDate());      
		assertNull("The user UpdatedAt date is not null", u1.getUpdated_atDate());      

	}
	
	//Expects a User with some altered attributes
	@Test
	public void testGetUserModified() {
		String userName = "Carlos";
		String userEmail = "carlos.perez@gmail.com";
		char userGender = 'M';
		Boolean userStatus = true;
		
		//STEP 1: create the User object
		User u1 = new User();
		u1.setName(userName);
		u1.setEmail(userEmail);
		u1.setGender(userGender);
		u1.setStatus(true);
		
		//STEP2: alter the user attributes
		u1.getModified();
		  
		//STEP3: check the object and its attributes
		assertNotEquals("The user Name is the same", u1.getName(), userName);      
		assertNotEquals("The user Email is the same", u1.getEmail(), userEmail);        
		assertNotEquals("The user Gender is the same", u1.getGender(), userGender);
		assertNotEquals("The user Status is the same", u1.getStatus(), userStatus);
	}

}
