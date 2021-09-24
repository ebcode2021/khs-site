package khs.login.validator;

import javax.servlet.http.HttpServletRequest;

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
		
		Member member = null;
		member = memberService.memberAuthenticate(userId, password);

		if(member==null) {
			res = false;
		}else {
			request.getSession().setAttribute("authentication", member);
		}
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
