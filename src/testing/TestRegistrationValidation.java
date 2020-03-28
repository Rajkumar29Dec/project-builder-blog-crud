package testing;

///*Uncomment the below code test your application
import static org.junit.Assert.*;
import org.junit.Test;
import businesslogic.RegistrationValidation;

public class TestRegistrationValidation {
	RegistrationValidation rv = new RegistrationValidation();
	
	@Test
	public void testCheckUserDetails() {
		
		assertEquals(true, rv.checkUserDetails("amin@gmail.com", "Amin@556", "Amin@556"));
		assertEquals(false, rv.checkUserDetails("amingmail.com", "Amin@556", "Amin@556"));
		assertEquals(false, rv.checkUserDetails("amin@gmail.com", "Amin556", "Amin@556"));
		assertEquals(false, rv.checkUserDetails("amin@gmail.com", "Amin@556", "Amin556"));
		assertEquals(false, rv.checkUserDetails("amin@gmail.com", "Amin556", "Amin556"));
		assertEquals(false, rv.checkUserDetails("amin@gmail.com", "amin@556", "amin@556"));
		assertEquals(false, rv.checkUserDetails("amin@gmail.com", "Amin@am", "Amin@am"));
		try {
			rv.checkUserDetails(null, null, null);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
//*/
