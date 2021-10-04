package khs.common.code;

public enum BoardSection {
	FREE("자유게시판"),
	STUDY("스터디게시판"),
	ALERT("공지사항"),
	HOT("스터디게시판");
	
	public final String section;
	
	BoardSection(String section) {
		this.section = section;
	}
}
