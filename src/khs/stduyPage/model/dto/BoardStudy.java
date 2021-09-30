package khs.stduyPage.model.dto;

public class BoardStudy {
	
	private String stIdx;
	private String stLanguage;
	private String stTitle;
	private String stTilteImg;
	private String stDescription;
	private String stStieLink;
	private int stIsDel;
	
	
	public BoardStudy() {
	}
	
	
	public String getStIdx() {
		return stIdx;
	}
	public void setStIdx(String stIdx) {
		this.stIdx = stIdx;
	}
	public String getStLanguage() {
		return stLanguage;
	}
	public void setStLanguage(String stLanguage) {
		this.stLanguage = stLanguage;
	}
	public String getStTitle() {
		return stTitle;
	}
	public void setStTitle(String stTitle) {
		this.stTitle = stTitle;
	}
	public String getStTilteImg() {
		return stTilteImg;
	}
	public void setStTilteImg(String stTilteImg) {
		this.stTilteImg = stTilteImg;
	}
	public String getStDescription() {
		return stDescription;
	}
	public void setStDescription(String stDescription) {
		this.stDescription = stDescription;
	}
	public String getStStieLink() {
		return stStieLink;
	}
	public void setStStieLink(String stStieLink) {
		this.stStieLink = stStieLink;
	}
	public int getStIsDel() {
		return stIsDel;
	}
	public void setStIsDel(int stIsDel) {
		this.stIsDel = stIsDel;
	}
	
	
	
	
	
	@Override
	public String toString() {
		return "BoardStudy [stIdx=" + stIdx + ", stLanguage=" + stLanguage + ", stTitle=" + stTitle + ", stTilteImg="
				+ stTilteImg + ", stDescription=" + stDescription + ", stStieLink=" + stStieLink + ", stIsDel="
				+ stIsDel + "]";
	}
	
	
	
}