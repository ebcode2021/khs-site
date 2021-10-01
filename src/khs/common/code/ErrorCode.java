package khs.common.code;

public enum ErrorCode {
	DATABASE_ACCESS_ERROR("데이터베이스와 통신 중 에러가 발생하였습니다."), // 뒤에 ,"/MEMBER/FORM/"뭐이런식으로 경로도 지정해줄 수 있음
	VALIDATOR_FAIL_ERROR("부적절한 양식의 데이터 입니다."),
	MAIL_SEND_FAIL_ERROR("이메일 발송 중 에러가 발생하였습니다."),
	HTTP_CONNECT_ERROR("HTTP 통신 중 에러가 발생하였습니다."),
	AUTHENTICATION_FAILED_ERROR("유효하지 않은 인증입니다."),
	UNAUTHORIZED_PAGE_ERROR("접근 권한이 없는 페이지 입니다."),
	FAILED_FILE_UPLOAD_ERROR("파일업로드에 실패하였습니다."),
	REDIRECT(""),
	LOGIN_NOT_VALIDATOR_ERROR("아이디나 비밀번호를 다시 확인해주세요."),
	MEMBER_ISLEAVE("탈퇴한 아이디입니다."),
	BAN_USER2("차단된 사용자 입니다.\n차단 기간 : 1일 차단\n차단 사유:커뮤니티 규정 위반"),
	BAN_USER3("차단된 사용자 입니다.\n차단 기간 : 7일 차단\n차단 사유:커뮤니티 규정 위반"),
	BAN_USER4("차단된 사용자 입니다.\n차단 기간 : 영구 차단\n차단 사유:커뮤니티 규정 위반"),
	NEED_LOGIN("로그인을 해주세요.");
	
	public final String MESSAGE;
	public String URL;
	
	
	private ErrorCode(String msg) {
		this.MESSAGE=msg;
		this.URL = "/login";
	}
	
	private ErrorCode(String msg, String url) {
		this.MESSAGE = msg;
		this.URL = url;
	}

	public ErrorCode setURL(String uRL) {
		URL = uRL;
		return this;
	}
	
	
}
