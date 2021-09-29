package khs.board.model.dto;

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
	
	private String cmtIdx;
	private String cmtContent;
	private Date cmtRegDate;
	private int cmtIsDel;
	
	
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
	public String getCmtIdx() {
		return cmtIdx;
	}
	public void setCmtIdx(String cmtIdx) {
		this.cmtIdx = cmtIdx;
	}
	public String getCmtContent() {
		return cmtContent;
	}
	public void setCmtContent(String cmtContent) {
		this.cmtContent = cmtContent;
	}
	public Date getCmtRegDate() {
		return cmtRegDate;
	}
	public void setCmtRegDate(Date cmtRegDate) {
		this.cmtRegDate = cmtRegDate;
	}
	public int getCmtIsDel() {
		return cmtIsDel;
	}
	public void setCmtIsDel(int cmtIsDel) {
		this.cmtIsDel = cmtIsDel;
	}
	
	@Override
	public String toString() {
		return "Board [bdIdx=" + bdIdx + ", userId=" + userId + ", regDate=" + regDate + ", title=" + title
				+ ", content=" + content + ", bdIsDel=" + bdIsDel + ", bdSection=" + bdSection + ", bdIsBlind="
				+ bdIsBlind + ", cmtIdx=" + cmtIdx + ", cmtContent=" + cmtContent + ", cmtRegDate=" + cmtRegDate
				+ ", cmtIsDel=" + cmtIsDel + "]";
	}
	

	
}
