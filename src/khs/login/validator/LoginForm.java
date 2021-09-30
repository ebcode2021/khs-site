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

	public boolean testKakao(String kakaoCode) {
		boolean res=true;
		
		Member member = null;
		member = memberService.memberIsCode(kakaoCode);
		
		if(member==null) {
			return false;
		}
		
		request.getSession().setAttribute("authentication", member);
		long remainder = (member.getFinalDate().getTime()-date.getTime())/(24*60*60*1000);
		request.getSession().setAttribute("remainder", remainder);
		
		// member에서 kakao_token 값이 있는지. 확인. 
		// 있다면 바로 일치하는 member 정보를 불러오고, main 페이지로 redirect
		// 없다면 토큰 값을 포함해서 회원가입 페이지로 넘겨주기.
		
		// 이후에 로그인 할 때는, 토큰 값 일치여부만 확인해서 한 번에 로그인 가능하게.
		// main 페이지로 보내주자
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