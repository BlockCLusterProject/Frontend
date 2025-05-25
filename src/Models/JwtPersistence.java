package Models;

public class JwtPersistence {
	private static JwtPersistence instance;
	private String token;
	
	private JwtPersistence() {}
	
	public static JwtPersistence getInstance() {
		if(instance == null) {
			instance = new JwtPersistence();
		}
		
		return instance;
	}
	
	public void setToken(String token) {
		this.token = token;
	}
	
	public String getToken() {
		return token;
	}
	
	public void closeSesion() {
		instance = null;
	}

}
