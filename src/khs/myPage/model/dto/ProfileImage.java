package khs.myPage.model.dto;

import java.util.Date;

public class ProfileImage {
	private String prFlIdx;
	private String userId;
	private String originFileName;
	private String renameFileName;
	private String savePath;
	private int fileIsDel;
	private Date regDate;
	public String getPrFlIdx() {
		return prFlIdx;
	}
	public void setPrFlIdx(String prFlIdx) {
		this.prFlIdx = prFlIdx;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getOriginFileName() {
		return originFileName;
	}
	public void setOriginFileName(String originFileName) {
		this.originFileName = originFileName;
	}
	public String getRenameFileName() {
		return renameFileName;
	}
	public void setRenameFileName(String renameFileName) {
		this.renameFileName = renameFileName;
	}
	public String getSavePath() {
		return savePath;
	}
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
	public int getFileIsDel() {
		return fileIsDel;
	}
	public void setFileIsDel(int fileIsDel) {
		this.fileIsDel = fileIsDel;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	
	@Override
	public String toString() {
		return "ProfileImage [prFlIdx=" + prFlIdx + ", userId=" + userId + ", originFileName=" + originFileName
				+ ", renameFileName=" + renameFileName + ", savePath=" + savePath + ", fileIsDel=" + fileIsDel
				+ ", regDate=" + regDate + "]";
	}

	
}
