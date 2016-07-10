import static org.junit.Assert.*;

import org.junit.Test;

public class AuthenticationServiceTest {

	@Test public void 
	username_existed() {
		AuthenticationService authenticationService = new AuthenticationService(new SuccessUserDao());
		assertTrue(authenticationService.isUsernameExisted("SOMKIAT"));
	}

	@Test public void 
	username_not_existed() {
		AuthenticationService authenticationService = new AuthenticationService(new NullUserDao());
		assertTrue(authenticationService.isUsernameExisted("SOMKIAT"));
	}
	
}

class SuccessUserDao implements UserDao {

	public User searchByUsername(String username) {
		return new User();
	}
	
}

class NullUserDao implements UserDao {

	public User searchByUsername(String username) {
		return null;
	}
	
}