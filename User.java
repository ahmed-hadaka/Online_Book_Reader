package projects.onlineBookReader;

public abstract class User {

	private final String Name;
	private final String UserName;
	private final String Password;
	private final String Email;

	public User(String name, String userName, String passWord, String email) {
		Name = name;
		UserName = userName;
		Password = passWord;
		Email = email;
	}

	public String getName() {
		return Name;
	}

	public String getUserName() {
		return UserName;
	}

	public String getPassword() {
		return Password;
	}

	public String getEmail() {
		return Email;
	}

	public void viewProfile() {
		System.out.println("[Name=" + Name + ", UserName=" + UserName + ", Email=" + Email + "]");
	}
}
