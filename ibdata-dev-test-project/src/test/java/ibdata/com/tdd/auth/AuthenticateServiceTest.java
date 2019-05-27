package ibdata.com.tdd.auth;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AuthenticateServiceTest {
	
	
	private AuthUser authUser;
	private static final String ID[] = { "junseok", "yuongjae", "jiho" };
	
	@Before
	public void setup() {
		authUser = new AuthUser();
	}
	
	// ID 또는 Password가 Null 이면 예외 발생
	@Test(expected=AuthenticateException.class)
	public void exceptionIsThrownIfTheIdOrPwIsNull() {
		
		authUser.setId(null);
		authUser.setPassword(null);
		
		String id = authUser.getId();
		String password = authUser.getPassword();
		
		if(id == null) {
			throw new AuthenticateException("ID를 입력하셔야 합니다.");
		}
		
		if(password == null) {
			throw new AuthenticateException("Password를 입력하셔야 합니다.");
		}
	}
	
	@Test
	public void idMustBeRetrieved() {
		AuthenticateService service = new AuthenticateService();
		String id = service.selectId();

		assertThat("junseok", is(id));
	}
	
	
}
