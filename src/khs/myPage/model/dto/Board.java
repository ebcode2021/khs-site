package khs.myPage.model.dto;

import java.util.Date;

public class Board {
	
	private String bdIdx;
	private String userId;
	private Date regDate;
	private String title;
	private String content;
	private int bdIsDel;
	private String bdSection;
	private int bdIsBlind;
	public String getBdIdx() {
		return bdIdx;
	}
	public void setBdIdx(String bdIdx) {
		this.bdIdx = bdIdx;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getBdIsDel() {
		return bdIsDel;
	}
	public void setBdIsDel(int bdIsDel) {
		this.bdIsDel = bdIsDel;
	}
	public String getBdSection() {
		return bdSection;
	}
	public void setBdSection(String bdSection) {
		this.bdSection = bdSection;
	}
	public int getBdIsBlind() {
		return bdIsBlind;
	}
	public void setBdIsBlind(int bdIsBlind) {
		this.bdIsBlind = bdIsBlind;
	}
	
	@Override
	public String toString() {
		return "Board [bdIdx=" + bdIdx + ", userId=" + userId + ", regDate=" + regDate + ", title=" + title
				+ ", content=" + content + ", bdIsDel=" + bdIsDel + ", bdSection=" + bdSection + ", bdIsBlind="
				+ bdIsBlind + "]";
	}
	

	
	
	
	
	
}
