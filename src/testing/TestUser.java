package testing;

///*Uncomment the below code test your application
import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.Test;

import model.User;

public class TestUser {
	LocalDateTime ld = LocalDateTime.of(2005, 4, 9, 22, 05, 12);
	User user = new User ( "amin@gmail.com","Amin@556",ld);
	
	@Test
	public void testSetterGetter() {
		user.setDate(ld);
		user.setEmail("amin@gmail.com");
		user.setPassword("Amin@556");
		assertEquals("amin@gmail.com",user.getEmail());
		assertEquals("Amin@556",user.getPassword());
		assertEquals(ld,user.getDate());
		try {
			user.setDate(null);
			user.setEmail(null);
			user.setPassword(null);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
//*/
