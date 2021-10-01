//loginForm
package khs.login.validator;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import khs.common.code.ErrorCode;
import khs.common.encrypt.Encrypter;
import khs.common.exception.HandlableException;
import khs.login.model.dto.Member;
import khs.login.model.service.MemberService;

public class LoginForm {

	private String userId;
	private String password;
	private Date date = new Date();
	private HttpServletRequest request;
	private MemberService memberService = new MemberService();
	
	public LoginForm(HttpServletRequest request) {
		this.request = request;
		this.userId = request.getParameter("userId");
		this.password = Encrypter.convertToSHA256(request.getParameter("password"));
	}
	
	public void test() {
		Member member = null;
		member = memberService.memberAuthenticate(userId, password);
		
		//DB에 정보가 없을 경우
		if(member==null) {
			throw new HandlableException(ErrorCode.LOGIN_NOT_VALIDATOR_ERROR);
		}
		
		//탈퇴한 사용자일 경우
		if(member.getIsLeave()==1) {
			throw new HandlableException(ErrorCode.MEMBER_ISLEAVE);
		}
		
		request.getSession().setAttribute("authentication", member);
		long remainder = (member.getFinalDate().getTime()-date.getTime())/(24*60*60*1000);
		request.getSession().setAttribute("remainder", remainder);
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