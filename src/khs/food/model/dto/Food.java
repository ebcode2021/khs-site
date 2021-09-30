package khs.food.model.dto;

public class Food {
	String hpIdx; 
	String khCenter; 
	String stImg; 
	String stName; 
	String stMenu; 
	String stDescription;
	int hipIsDel;
	public String getHpIdx() {
		return hpIdx;
	}
	public void setHpIdx(String hpIdx) {
		this.hpIdx = hpIdx;
	}
	public String getKhCenter() {
		return khCenter;
	}
	public void setKhCenter(String khCenter) {
		this.khCenter = khCenter;
	}
	public String getStImg() {
		return stImg;
	}
	public void setStImg(String stImg) {
		this.stImg = stImg;
	}
	public String getStName() {
		return stName;
	}
	public void setStName(String stName) {
		this.stName = stName;
	}
	public String getStMenu() {
		return stMenu;
	}
	public void setStMenu(String stMenu) {
		this.stMenu = stMenu;
	}
	public String getStDescription() {
		return stDescription;
	}
	public void setStDescription(String stDescription) {
		this.stDescription = stDescription;
	}
	public int getHipIsDel() {
		return hipIsDel;
	}
	public void setHipIsDel(int hipIsDel) {
		this.hipIsDel = hipIsDel;
	}
	@Override
	public String toString() {
		return "Food [hpIdx=" + hpIdx + ", khCenter=" + khCenter + ", stImg=" + stImg + ", stName=" + stName
				+ ", stMenu=" + stMenu + ", stDescription=" + stDescription + ", hipIsDel=" + hipIsDel + "]";
	}

	
	
}
