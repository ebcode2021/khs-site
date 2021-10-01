 package khs.common.filter;

import java.io.IOException;

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
		
		/*
		 * //로그인 없이 접근할 경우 if(member==null) { throw new
		 * HandlableException(ErrorCode.NEED_LOGIN.setURL("/login")); }
		 */
		//차단회원인 경우
				if(!member.getBanGrade().equals("B01")) {
					switch(member.getBanGrade()) {
						case "B02" :
							throw new HandlableException(ErrorCode.BAN_USER2);
						case "B03" :
							throw new HandlableException(ErrorCode.BAN_USER3);
						case "B04" :
							throw new HandlableException(ErrorCode.BAN_USER4);
					}
					
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
