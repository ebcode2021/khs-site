package khs.common.code;

public enum BoardSection {
	FREE("자유게시판"),
	STUDY("스터디게시판"),
	NOTICE("공지사항");
	
	public final String section;
	
	BoardSection(String section) {
		this.section = section;
	}
}
