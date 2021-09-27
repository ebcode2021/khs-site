package khs.login.model.dto;

import java.sql.Date;

public class Member {
	private String userId;
	private String password;
	private String email;
	private String grade;
	private Date regDate;
	private String name;
	private String nickname;
	private Date BirthDate;
	private String khCenter;
	private int isLeave;
	private Date startDate;
	private Date finalDate;
	
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

	public Member() {
	}

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
		return BirthDate;
	}

	public void setBirthDate(Date birthDate) {
		BirthDate = birthDate;
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

	@Override
	public String toString() {
		return "Member [userId=" + userId + ", password=" + password + ", email=" + email + ", grade=" + grade
				+ ", regDate=" + regDate + ", name=" + name + ", nickname=" + nickname + ", BirthDate=" + BirthDate
				+ ", khCenter=" + khCenter + ", isLeave=" + isLeave + ", startDate=" + startDate + ", finalDate="
				+ finalDate + "]";
	}

	
	
	
}
