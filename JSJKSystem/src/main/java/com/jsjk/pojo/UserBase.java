package com.jsjk.pojo;

public class UserBase {
	
	private int userId;
	private String userName;
	private String userNickname;
	private String userPassword;
	private int userBirthYear;
	private int userHeight;
	private int userWeight;
	private String userPhone;
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return userName;
	} 
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getUserNickname() {
		return userNickname;
	}
	
	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}
	public String getUserPassword() {
		return userPassword;
	}
	
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	public int getUserBirthYear() {
		return userBirthYear;
	}
	
	public void setUserBirthYear(int userbirthYear) {
		this.userBirthYear = userbirthYear;
	}
	
	public int getUserHeight() {
		return userHeight;
	}
	
	public void setUserWeight(int userWeight) {
		this.userWeight = userWeight;
	}
	
	public int getUserWeight() {
		return userWeight;
	}
	
	public void setUserHeight(int userHeight) {
		this.userHeight = userHeight;
	}
	
	public String getUserPhone() {
		return userPhone;
	}
	
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	@Override
	public String toString() {
		return "UserBase [userId=" + userId + ", userName=" + userName + ", userNickname=" + userNickname
				+ ", userPassword=" + userPassword + ", userBirthYear=" + userBirthYear + ", userHeight=" + userHeight
				+ ", userPhone=" + userPhone + "]";
	}
	
	/**
	 * user中各参数的非空验证
	 * @return
	 */
	public boolean notNullValidation() {
		return (userName != null) && (userNickname != null) && (userPassword != null) && (userBirthYear != 0) && (userHeight != 0) && (userWeight != 0) && (userPhone != null);
	}

}
