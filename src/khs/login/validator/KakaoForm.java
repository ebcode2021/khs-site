package khs.login.validator;


import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import khs.login.model.dto.Member;
import khs.login.model.service.MemberService;

public class KakaoForm {
	private String kakaoCode;
	private HttpServletRequest request;
	private MemberService memberService = new MemberService();
	private Date date = new Date();
	
	public KakaoForm(HttpServletRequest request) {
		this.request = request;
		this.kakaoCode = request.getParameter("kakaoCode");
		
	}
	
	public boolean testKakao(String kakaoCode) {
		boolean res=true;
		
		Member member = null;
		member = memberService.memberIsCode(kakaoCode);
		
		if(member==null) {//kakaoCode가 member테이블에서 검색되지 않는다면 바로 리턴
			return false;
		}
		
		request.getSession().setAttribute("authentication", member);
		long remainder = (member.getFinalDate().getTime()-date.getTime())/(24*60*60*1000);
		request.getSession().setAttribute("remainder", remainder);
		
		// 있다면 바로 일치하는 member 정보를 불러오고, main 페이지로 redirect
		// 없다면 토큰 값을 포함해서 회원가입 페이지로 넘겨주기.
		
		// 이후에 로그인 할 때는, 토큰 값 일치여부만 확인해서 한 번에 로그인 가능하게.
		// main 페이지로 보내주자
		return res;
	}

	public String getKakaoCode() {
		return kakaoCode;
	}

	public void setKakaoCode(String kakaoCode) {
		this.kakaoCode = kakaoCode;
	}
	
	

}
