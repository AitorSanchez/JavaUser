package tests;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import controllers.MainController;
import models.User;

public class MainControllerTest {
	
	//Expects no errors in the attributes checking
	@Test
   public void testGetUserOk() throws ParseException {
	  //STEP 1: get the User object
      MainController mainController = new MainController();
      User u1 = mainController.getUserById(8);
      
      //STEP2: generate Date values for checking
      SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	  Date createdDate = sdf.parse("2020-09-24T03:50:04.902+05:30");
	  Date updatedDate = sdf.parse("2020-09-24T03:50:04.902+05:30");
      
      //STEP3: check the object and its attributes
      assertNotNull("The user Obj. is null", u1);
      if (u1 != null) {
    	  assertEquals("Id attr. is not correct", u1.getId(), 29);
    	  assertEquals("Name attr. is not correct", u1.getName(), "My name is Amb. Aanandinii Embranthiri");
    	  assertEquals("Email attr. is not correct", u1.getEmail(), "My email is embranthiri_amb_aanandinii@rosenbaum.name");
    	  assertEquals("Gender attr. is not correct", u1.getGender(), 'F');
    	  assertTrue("Status attr. is not correct", u1.getStatus());
    	  assertEquals("CreatedAt attr. is not correct", u1.getCreated_at(), "2020-09-24T03:50:04.902+05:30");
    	  assertEquals("CreatedAt attr. is not correct", u1.getCreated_atDate(), createdDate);
    	  assertEquals("UpdatedAt attr. is not correct", u1.getUpdated_at(), "2020-09-24T03:50:04.902+05:30");
    	  assertEquals("UpdatedAt attr. is not correct", u1.getUpdated_atDate(), updatedDate);
      }
   }
	
	//Expects a null user as response
	@Test
	public void testGetUserNull() {
		//STEP 1: get the User object
		MainController mainController = new MainController();
		User u1 = mainController.getUserById(1);
		  
		//STEP2: check the object and its attributes
		assertNull("The user Obj. is not null", u1);      
	}
	
}
