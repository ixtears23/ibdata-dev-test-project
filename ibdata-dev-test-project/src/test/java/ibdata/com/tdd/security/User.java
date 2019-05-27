package ibdata.com.tdd.security;

public class User {
	
	public User(String id, String apssword) {
		super();
		this.id = id;
		this.apssword = apssword;
	}

	private String id;
	
	private String apssword;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getApssword() {
		return apssword;
	}

	public void setApssword(String apssword) {
		this.apssword = apssword;
	}
}
