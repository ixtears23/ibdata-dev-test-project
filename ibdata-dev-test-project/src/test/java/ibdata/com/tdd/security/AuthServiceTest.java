package ibdata.com.tdd.security;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import ibdata.com.tdd.security.AuthServiceTest.NonExistingUserException;

public class AuthServiceTest {

	private static final String NO_USER_ID = "noUserId";

	public class NonExistingUserException extends RuntimeException {
		
	}

	private static final String USER_ID = "userId";
	private static final String USER_PASSWORD = "userPassword";
	private AuthService authService;

	public class AuthService {

		public void authenticate(String id, String password) {
			if (id == null || id.isEmpty()) throw new IllegalArgumentException();
			if (password == null || password.isEmpty()) throw new IllegalArgumentException();
			
			User user = findUserById(id);
			if (user == null)
				throw new NonExistingUserException();
			
			throw new WrongPasswordExcpetion();
		}

		private User findUserById(String id) {
			if (id.equals("userId"))
				return new User(id, "1234");
			return null;
		}

	}
	
	@Test
	public void whenUserFoundButWrongPw_throwWrongPasswordEx() {
		givenUserExists("userId", USER_PASSWORD);
		assertExceptionThrown("userUd", "wrongPassword", WrongPasswordExcpetion.class);
		verifyUserFound("userId");
	}
	
	private void verifyUserFound(String string) {
		// TODO Auto-generated method stub
		
	}

	private void givenUserExists(String string, String userPassword) {
		// TODO Auto-generated method stub
		
	}

	@Test
	public void whenUserNotFound_throwNonExistingUserEx() {
		assertExceptionThrown(NO_USER_ID, USER_PASSWORD, NonExistingUserException.class);
		for (int i = 0; i <= 100; i++) {
			assertExceptionThrown(NO_USER_ID + i, USER_PASSWORD, NonExistingUserException.class);
		}
	}

	private void assertIllegalArgExThrown(String id, String password) {
		Class<? extends Exception> type = IllegalArgumentException.class;
		
		assertExceptionThrown(id, password, IllegalArgumentException.class);
	}

	@Test
	public void givenInvalidId_throwIllegalArgEx() {
		assertIllegalArgExThrown(null, USER_PASSWORD);
		assertIllegalArgExThrown("", USER_PASSWORD);
		assertIllegalArgExThrown(USER_ID, null);
		assertIllegalArgExThrown(USER_ID, "");
	}

	private void assertExceptionThrown(String id, String password, Class<? extends Exception> type) {
		Exception thrownEx = null;
		
		try {
			authService.authenticate(id, password);
		} catch (Exception e) {
			thrownEx = e;
		}
		assertThat(thrownEx, instanceOf(type));
	}

	@Before
	public void setUp() {
		authService = new AuthService();
	}
}
