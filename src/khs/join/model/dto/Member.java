package khs.join.model.dto;

import java.sql.Date;

public class Member {

	private String userId; 
	private String password; 
	private String email; 
	private String grade; 
	private Date regDate; 
	private String name; 
	private String nickname; 
	private Date birthDate; 
	private String khCenter; 
	private int isLeave; 
	private int isBan;
	private String variFile;
	private String kakaoCode; 
	
	public String getUserId() {
		return userId;
	}
	public String getKakaoCode() {
		return kakaoCode;
	}
	public void setKakaoCode(String kakaoCode) {
		this.kakaoCode = kakaoCode;
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
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public String getKhCenter() {
		return khCenter;
	}
	public void setKhCenter(String khCenter) {
		this.khCenter = khCenter;
	}
	public int getIsLeave() {
		return isLeave;
	}
	public void setIsLeave(int isLeave) {
		this.isLeave = isLeave;
	}
	public int getIsBan() {
		return isBan;
	}
	public void setIsBan(int isBan) {
		this.isBan = isBan;
	}
	public String getVariFile() {
		return variFile;
	}
	public void setVariFile(String variFile) {
		this.variFile = variFile;
	}
	@Override
	public String toString() {
		return "Member [userId=" + userId + ", password=" + password + ", email=" + email + ", grade=" + grade
				+ ", regDate=" + regDate + ", name=" + name + ", nickname=" + nickname + ", birthDate=" + birthDate
				+ ", khCenter=" + khCenter + ", isLeave=" + isLeave + ", isBan=" + isBan + ", variFile=" + variFile
				+ ", kakaoCode=" + kakaoCode + "]";
	}

	
	
}
