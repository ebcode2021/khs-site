package khs.login.validator;


import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import khs.common.code.ErrorCode;
import khs.common.exception.HandlableException;
import khs.login.model.dto.Member;
import khs.login.model.service.MemberService;

public class LoginForm {

	private String userId;
	private String password;
	
	private HttpServletRequest request;
	private MemberService memberService = new MemberService();
	
	public LoginForm(HttpServletRequest request) {
		this.request = request;
		this.userId = request.getParameter("userId");
		this.password = request.getParameter("password");
	}
	
	public boolean test() {
		boolean res = true;
		boolean valid = true;
		
		//아이디나 비밀번호가 양식에 맞지 않는 경우
		//valid = Pattern.matches("{5,}", userId);
		if(!valid) {
			throw new HandlableException(ErrorCode.LOGIN_NOT_VALIDATOR_ERROR);
		}
		//valid = Pattern.matches("(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[^a-zA-Zㄱ-힣0-9]).{8,}", password);
		if(!valid) {
			throw new HandlableException(ErrorCode.LOGIN_NOT_VALIDATOR_ERROR);
		}
		
		//DB에 멤버가 있는지?
		Member member = null;
		member = memberService.memberAuthenticate(userId, password);

		if(member==null) {
			res = false;
		}else {
			request.getSession().setAttribute("authentication", member);
		}
		//db에 존재하지 않는 아이디인 경우
		return res;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}
