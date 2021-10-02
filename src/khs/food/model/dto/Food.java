package khs.food.model.dto;

public class Food {

	private String reIdx; 
	private String khCenter; 
	private String StoreName; 
	private String StoreMenu;
	private String StoreDescription;
	private String StoreImg;
	private int hpIsDel;
	
	private void food() {
		// TODO Auto-generated method stub

	}
	
	public String getReIdx() {
		return reIdx;
	}
	public void setReIdx(String reIdx) {
		this.reIdx = reIdx;
	}
	public String getKhCenter() {
		return khCenter;
	}
	public void setKhCenter(String khCenter) {
		this.khCenter = khCenter;
	}
	public String getStoreName() {
		return StoreName;
	}
	public void setStoreName(String storeName) {
		StoreName = storeName;
	}
	public String getStoreMenu() {
		return StoreMenu;
	}
	public void setStoreMenu(String storeMenu) {
		StoreMenu = storeMenu;
	}
	public String getStoreDescription() {
		return StoreDescription;
	}
	public void setStoreDescription(String storeDescription) {
		StoreDescription = storeDescription;
	}
	public String getStoreImg() {
		return StoreImg;
	}
	public void setStoreImg(String storeImg) {
		StoreImg = storeImg;
	}
	public int getHpIsDel() {
		return hpIsDel;
	}
	public void setHpIsDel(int hpIsDel) {
		this.hpIsDel = hpIsDel;
	}
	@Override
	public String toString() {
		return "Food [reIdx=" + reIdx + ", khCenter=" + khCenter + ", StoreName=" + StoreName + ", StoreMenu="
				+ StoreMenu + ", StoreDescription=" + StoreDescription + ", StoreImg=" + StoreImg + ", hpIsDel="
				+ hpIsDel + "]";
	} 
	
	
	
	
	
	
}
