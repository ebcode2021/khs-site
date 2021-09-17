package khs.common.code;

public enum MemberGrade {
	LV01("미인증회원","user",1),
	LV02("인증회원","user",2),
	AD01("관리자","admin",9999);

	public final String GRADE;
	public final String ROLE;
	public final int EXTENDABLE_CNT;
	
	MemberGrade(String GRADE, String ROLE, int EXTENDABLE_CNT) {
		this.GRADE = GRADE;
		this.ROLE = ROLE;
		this.EXTENDABLE_CNT = EXTENDABLE_CNT;
	}
	
	
	
}
