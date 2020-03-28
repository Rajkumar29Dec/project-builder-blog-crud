package testing;

///*Uncomment the below code test your application
import static org.junit.Assert.*;
import org.junit.Test;

import businesslogic.ValidateUser;

public class TestValidateUser {
	ValidateUser vu = new ValidateUser();
	
	@Test
	public void testValidate() {
		assertEquals(false,vu.validate("Amin@gmail.com","Amin@556"));
		assertEquals(false,vu.validate("admin", "admin1"));
		assertEquals(false,vu.validate("admin1", "admin"));
		assertEquals(true,vu.validate("admin", "admin"));
		try {
			vu.validate(null, null);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
//*/
