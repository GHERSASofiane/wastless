package models;

import java.awt.Image;

public class Personne {

	private String username;
	private String userphone;
	private String usermail;
	private String useradresse;
	private String userpassword;
	private Image userProfilePecture;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserphone() {
		return userphone;
	}
	public void setUserphone(String userphone) {
		this.userphone = userphone;
	}
	public String getUsermail() {
		return usermail;
	}
	public void setUsermail(String usermail) {
		this.usermail = usermail;
	}
	public String getUseradresse() {
		return useradresse;
	}
	public void setUseradresse(String useradresse) {
		this.useradresse = useradresse;
	}
	public String getUserpassword() {
		return userpassword;
	}
	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}
	public Image getUserProfilePecture() {
		return userProfilePecture;
	}
	public void setUserProfilePecture(Image userProfilePecture) {
		this.userProfilePecture = userProfilePecture;
	}
	
	
}
