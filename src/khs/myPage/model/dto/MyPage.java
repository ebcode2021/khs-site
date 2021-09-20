package khs.myPage.model.dto;

import java.util.Date;

public class MyPage {
	private String userId;
	private String password;
	private String email;
	private int isLeave;
	private String name;
	private String nickName;
	private String khCenter;
	private Date regDate;
	private String grade;
	private int isBan;
	private Date birthDate;
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
	public String getKhCenter() {
		return khCenter;
	}
	public void setKhCenter(String khCenter) {
		this.khCenter = khCenter;
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
	public int getIsBan() {
		return isBan;
	}
	public void setIsBan(int isBan) {
		this.isBan = isBan;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	@Override
	public String toString() {
		return "MyPage [userId=" + userId + ", password=" + password + ", email=" + email + ", isLeave=" + isLeave
				+ ", name=" + name + ", nickName=" + nickName + ", khCenter=" + khCenter + ", regDate=" + regDate
				+ ", grade=" + grade + ", isBan=" + isBan + ", birthDate=" + birthDate + "]";
	}

	
	
	
	
	
	
	
}
