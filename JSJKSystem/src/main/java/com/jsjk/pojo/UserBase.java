package com.jsjk.pojo;

public class UserBase {
	
	private int userId;
	private String userName;
	private String userPassword;
	private String userRealname;
	private int gender; 
	private int userBirthYear;
	private int userHeight;
	private double userWeight;
	private String userPhone;
	private String emergencyName;
	private String emergencyPhone;
	
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

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserRealname() {
		return userRealname;
	}

	public void setUserRealname(String userRealname) {
		this.userRealname = userRealname;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public int getUserBirthYear() {
		return userBirthYear;
	}

	public void setUserBirthYear(int userBirthYear) {
		this.userBirthYear = userBirthYear;
	}

	public int getUserHeight() {
		return userHeight;
	}

	public void setUserHeight(int userHeight) {
		this.userHeight = userHeight;
	}

	public double getUserWeight() {
		return userWeight;
	}

	public void setUserWeight(double userWeight) {
		this.userWeight = userWeight;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getEmergencyName() {
		return emergencyName;
	}

	public void setEmergencyName(String emergencyName) {
		this.emergencyName = emergencyName;
	}

	public String getEmergencyPhone() {
		return emergencyPhone;
	}

	public void setEmergencyPhone(String emergencyPhone) {
		this.emergencyPhone = emergencyPhone;
	}

	/**
	 * user中各参数的非空验证
	 * @return
	 */
	public boolean notNullValidation() {
		return (notNullOrEmpyt(userName)) && notNullOrEmpyt(userRealname) && notNullOrEmpyt(userPassword) && (userBirthYear != 0) && (userHeight != 0) && (userWeight != 0) && notNullOrEmpyt(userPhone);
	}
	
	/**
	 * 去掉string的空格
	 */
	public void trimSpace() {
		userName = userName.trim();
		userRealname = userRealname.trim();
		userPhone = userPhone.trim();
	}
	
	/**
	 * 验证字符串非空
	 * @param str
	 * @return
	 */
	private boolean notNullOrEmpyt(String str) {
		return (str != null && !str.isEmpty());
	}

}
