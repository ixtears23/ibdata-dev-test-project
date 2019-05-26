package ibdata.com.tdd.auth;

public class AuthenticateException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public AuthenticateException(String exceptionMessage) {
		super(exceptionMessage);
	}

	
}
