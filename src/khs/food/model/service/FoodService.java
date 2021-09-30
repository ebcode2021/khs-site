package khs.food.model.service;

public class FoodService {
	
	String hpIdx; 
	String khCenter; 
	String stImg; 
	String stName; 
	String Menu; 
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
	public String getMenu() {
		return Menu;
	}
	public void setMenu(String menu) {
		Menu = menu;
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
		return "FoodService [hpIdx=" + hpIdx + ", khCenter=" + khCenter + ", stImg=" + stImg + ", stName=" + stName
				+ ", Menu=" + Menu + ", stDescription=" + stDescription + ", hipIsDel=" + hipIsDel + "]";
	} 

	
	
}
