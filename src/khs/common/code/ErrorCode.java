package khs.common.code;

import khs.login.model.dto.Member;

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
	BAN_USER(""),
	NEED_LOGIN("로그인을 해주세요."),
	ADMIN_PAGE("접근 권한이 없습니다.");
	
	public String MESSAGE; //기존에 final
	public String URL;

	
	private ErrorCode(String msg) {
		this.MESSAGE=msg;
		this.URL = "/login";
	}
	
	private ErrorCode(String msg, String url) {
		this.MESSAGE = msg;
		this.URL = url;
	}
	
	public ErrorCode setMSG(String msg) {
		this.MESSAGE = msg;
		this.URL="/login";
		return this;
	}

	
	public ErrorCode setURL(String uRL) {
		URL = uRL;
		return this;
	}
	
	
}
