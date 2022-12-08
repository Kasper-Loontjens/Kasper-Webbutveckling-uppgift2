package model;

public class LoginBean {
	private String username ="";
	private String[] accountNames = {"billy", "john"};
	private String[] passwords = {"bob", "silver" };
	private boolean isLoggedIn = false;
	private String food = "";
	
	public void checkLogin(String accountName, String password) {
		isLoggedIn = false;
		for (int i= 0; i < accountNames.length; i++) {
			if (accountName.equals(accountNames[i]) && password.equals(passwords[i])) {
				isLoggedIn = true;
			}
		}
	}

	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean isLoggedIn() {
		return isLoggedIn;
	}

	public String getFood() {
		return food;
	}

	public void setFood(String food) {
		this.food = food;
	}
	
	
}
