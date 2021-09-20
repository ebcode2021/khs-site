package khs.common.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import khs.join.validator.JoinForm;

//import khs.common.code.ErrorCode;
/*import khs.common.exception.HandlableException;
import khs.common.exception.PageNotFoundException;
import khs.member.validator.JoinForm;*/

///////////////////toy-project보고 참조하기
public class ValidatorFilter implements Filter {

	
    public ValidatorFilter() {
        System.out.println("1. validatorFilter 작동");
    }

	public void destroy() {
	
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		System.out.println("2. validatorFilter doFilter 작동");
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		String[] uriArr = httpRequest.getRequestURI().split("/");
		
		
		if(uriArr.length != 0) {
			String redirectUrl = null;
			switch (uriArr[1]) {
			case "member":
				redirectUrl = memberValidation(httpRequest,uriArr);
				break;
			case "join":
				System.out.println("3. join-루트로 들어옴");
				redirectUrl = memberValidation(httpRequest,uriArr);
				break;	
			}
			
			if(redirectUrl!=null) {
				httpResponse.sendRedirect(redirectUrl);
				return;
			}
		}
		chain.doFilter(request,response);
	}

	private String memberValidation(HttpServletRequest httpRequest, String[] uriArr) {
		
		String redirectUrl=null;
		
		switch(uriArr[2]) { //여기에 계속 추가
		case "join-Method" :
			System.out.println("4. join-method 루트로 들어옴");
			JoinForm joinform = new JoinForm(httpRequest);
			if(!joinform.test()) {
				redirectUrl = "/member/join-form";
			}
			break;
		}
		return redirectUrl;
	}
	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
