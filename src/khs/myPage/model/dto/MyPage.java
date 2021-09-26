package khs.myPage.model.dto;

import java.util.Date;

public class MyPage {
	private String userId;
	private String password;
	private String email;
	private int isLeave;
	private String name;
	private String nickName;
	private String khCode;
	private Date regDate;
	private String grade;
	private String banGrade;
	private Date birthDate;
	private String variFile;
	private String khCenter;
	private String className;
	private Date startDate;
	private Date finalDate;
	private String instrName;
	
	
	
	
	public String getUserId() {
		return userId;
	}




	public void setUserId(String userId) {
		this.userId = userId;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public int getIsLeave() {
		return isLeave;
	}




	public void setIsLeave(int isLeave) {
		this.isLeave = isLeave;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getNickName() {
		return nickName;
	}




	public void setNickName(String nickName) {
		this.nickName = nickName;
	}




	public String getKhCode() {
		return khCode;
	}




	public void setKhCode(String khCode) {
		this.khCode = khCode;
	}




	public Date getRegDate() {
		return regDate;
	}




	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}




	public String getGrade() {
		return grade;
	}




	public void setGrade(String grade) {
		this.grade = grade;
	}




	public String getBanGrade() {
		return banGrade;
	}




	public void setBanGrade(String banGrade) {
		this.banGrade = banGrade;
	}




	public Date getBirthDate() {
		return birthDate;
	}




	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}




	public String getVariFile() {
		return variFile;
	}




	public void setVariFile(String variFile) {
		this.variFile = variFile;
	}




	public String getKhCenter() {
		return khCenter;
	}




	public void setKhCenter(String khCenter) {
		this.khCenter = khCenter;
	}




	public String getClassName() {
		return className;
	}




	public void setClassName(String className) {
		this.className = className;
	}




	public Date getStartDate() {
		return startDate;
	}




	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}




	public Date getFinalDate() {
		return finalDate;
	}




	public void setFinalDate(Date finalDate) {
		this.finalDate = finalDate;
	}




	public String getInstrName() {
		return instrName;
	}




	public void setInstrName(String instrName) {
		this.instrName = instrName;
	}




	@Override
	public String toString() {
		return "MyPage [userId=" + userId + ", password=" + password + ", email=" + email + ", isLeave=" + isLeave
				+ ", name=" + name + ", nickName=" + nickName + ", khCode=" + khCode + ", regDate=" + regDate
				+ ", grade=" + grade + ", banGrade=" + banGrade + ", birthDate=" + birthDate + ", variFile=" + variFile
				+ ", khCenter=" + khCenter + ", className=" + className + ", startDate=" + startDate + ", finalDate="
				+ finalDate + ", instrName=" + instrName + "]";
	}




	
	
	
	
	
	
	
}
