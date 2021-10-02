 package khs.common.filter;

import java.io.IOException;
import java.util.Date;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import khs.common.code.BanGrade;
import khs.common.code.ErrorCode;
import khs.common.exception.HandlableException;
//import khs.member.model.dto.Member;
import khs.login.model.dto.Member;


public class AuthorizationFilter implements Filter {

  
    public AuthorizationFilter() {
    }

	
	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		
		String[] uriArr = httpRequest.getRequestURI().split("/");
		
		if(uriArr.length != 0) {
			
			switch (uriArr[1]) {
				case "myPage":
					myPageAuthorize(httpRequest, httpResponse, uriArr);
					break;
				case "main" :
					mainAuthorize(httpRequest, httpResponse, uriArr);
					break;
				default: 
					break;
			}
		
		}
		
		chain.doFilter(request, response);

	}

	private void myPageAuthorize(HttpServletRequest httpRequest, HttpServletResponse httpResponse, String[] uriArr) {
		HttpSession session = httpRequest.getSession();
		Member member = (Member) session.getAttribute("authentication");
		
		if(member == null) {
			throw new HandlableException(ErrorCode.REDIRECT.setURL("/login"));
		}

		
		
	}


	private void mainAuthorize(HttpServletRequest httpRequest, HttpServletResponse httpResponse, String[] uriArr) throws ServletException, IOException {
		HttpSession session = httpRequest.getSession();
		Member member = (Member) session.getAttribute("authentication");
		Date date = new Date();
		
		  //로그인 없이 접근할 경우 
		if(member==null) { 
			throw new HandlableException(ErrorCode.NEED_LOGIN.setURL("/login")); }
		
		// 차단회원인 경우
		if (!member.getBanGrade().equals("B01") && member.getBanDate().after(date)) { //차단이 되었던 기록이 있으면서, 그 차단 날짜가 남았을 경우
			int banDate = BanGrade.valueOf(member.getBanGrade()).BanDate;
			throw new HandlableException(ErrorCode.BAN_USER
					.setMSG("커뮤니티 규정 위반으로  " + banDate + "일 차단 되셨습니다." + "\\n차단 만료 일자 : " + member.getBanDate() 
							+ "\\n문의 메일 : KHsemiPro04@gmail.com"));
		}
						
		//탈퇴회원인 경우
		if(member.getIsLeave()==1) {
			throw new HandlableException(ErrorCode.MEMBER_ISLEAVE.setURL("/login"));
		}
		
		
	
		
	}
	
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
