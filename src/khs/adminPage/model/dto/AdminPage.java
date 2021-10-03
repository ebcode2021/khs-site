package khs.adminPage.model.dto;

import java.util.Date;

public class AdminPage {

	
	
	// MEMBER 테이블 관련 DTO
	// 어드민게시판 : 회원정보조회 게시판
	// 어드민게시판 : 차단된 회원 관리 게시판
	private String userId;
	private String khCode;
	private String banGrade;
	private String password;
	private String email;
	private String grade;
	private Date regDate;
	private String name;
	private String nickname;
	private Date birthDate;
	private Date banDate;
	private int isLeave;
	private String variFile;
	
	public Date getBanDate() {
		return banDate;
	}
	public void setBanDate(Date banDate) {
		this.banDate = banDate;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getKhCode() {
		return khCode;
	}
	public void setKhCode(String khCode) {
		this.khCode = khCode;
	}
	public String getBanGrade() {
		return banGrade;
	}
	public void setBanGrade(String banGrade) {
		this.banGrade = banGrade;
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
	public int getIsLeave() {
		return isLeave;
	}
	public void setIsLeave(int isLeave) {
		this.isLeave = isLeave;
	}
	public String getVariFile() {
		return variFile;
	}
	public void setVariFile(String variFile) {
		this.variFile = variFile;
	}
	@Override
	public String toString() {
		return "AdminPage [userId=" + userId + ", khCode=" + khCode + ", banGrade=" + banGrade + ", password="
				+ password + ", email=" + email + ", grade=" + grade + ", regDate=" + regDate + ", name=" + name
				+ ", nickname=" + nickname + ", birthDate=" + birthDate + ", banDate=" + banDate + ", isLeave="
				+ isLeave + ", variFile=" + variFile + "]";
	}

	
	
	
	
	
	
}