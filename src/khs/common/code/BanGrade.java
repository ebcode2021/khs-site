package khs.common.code;

public enum BanGrade {
	B01("차단해제", 0), //차단이 되어있지 않은 상태(default)
	B02("1일차단", 1),
	B03("7일차단", 7),
	B04("영구차단", 10000);
	
	public final String banGrade; // 차단등급
	public final int BanDate; // 차단날짜
	
	BanGrade(String banGrade, int BanDate) {
		this.banGrade = banGrade;
		this.BanDate = BanDate;
	}
	
	
}
