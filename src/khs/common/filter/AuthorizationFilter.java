package khs.common.filter;

import java.io.IOException;
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
        // TODO Auto-generated constructor stub
    }

	
	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		
		String[] uriArr = httpRequest.getRequestURI().split("/");
		
		if(uriArr.length != 0) {
			
			switch (uriArr[1]) {
//				case "login" :
//					loginAuthorize(httpRequest,httpResponse,uriArr);
//					break;
				case "myPage":
					myPageAuthorize(httpRequest, httpResponse, uriArr);
					break;
				default: 
					break;
			}
		
		}
		
		chain.doFilter(request, response);

	}


//	private void loginAuthorize(HttpServletRequest httpRequest, HttpServletResponse httpResponse, String[] uriArr) {
//		HttpSession session = httpRequest.getSession();
//		Member member = (Member)session.getAttribute("authentication");
//		
//		switch(uriArr[2]) {
//			case "login-check" :
//				//차단된 사용자인지 아닌지에 따라서 접근권한 막는 코드 작성하기
//				break;
//			default :
//				break;
//		}
//		
//	}


	private void myPageAuthorize(HttpServletRequest httpRequest, HttpServletResponse httpResponse, String[] uriArr) {
		HttpSession session = httpRequest.getSession();
		Member member = (Member) session.getAttribute("authentication");
		
		if(member == null) {
			throw new HandlableException(ErrorCode.REDIRECT.setURL("/login"));
		}

		
		
	}


	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
