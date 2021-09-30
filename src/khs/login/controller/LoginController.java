package khs.login.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.RequestWrapper;

import khs.common.exception.PageNotFoundException;
import khs.login.model.dto.Member;
import khs.login.model.service.MemberService;
import khs.login.validator.LoginForm;

@WebServlet("/login/*")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MemberService memberService = new MemberService();   
 
  
    public LoginController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] uriArr = request.getRequestURI().split("/");
		
		switch(uriArr[uriArr.length-1]) {
		case "login" :
			request.getRequestDispatcher("/login/login").forward(request, response);
			break;
		case "login-check" :
			loginCheck(request,response);
			break;
		case "kakaoLogin" :
			kakaoLogin(request,response);
			break;
		default : throw new PageNotFoundException();
		}
	}
	
	private void kakaoLogin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println("카카오 로그인 서블릿으로 넘어왔다!!");
		String kakaoCode = request.getParameter("kakaoCode");
		
		LoginForm loginForm = new LoginForm(request);
		
		//member에 kakaoCode가 없다면 회원가입
		if(!loginForm.testKakao(kakaoCode)) {
			request.getRequestDispatcher("/join/join-form").forward(request, response);
		};
		
		//member에 kakaoCode가 있다면 그대로 로그인
		response.sendRedirect("/main");
		
		
		
		
	}
	

	private void loginCheck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LoginForm loginForm = new LoginForm(request);
		loginForm.test();
		
		HttpSession session = request.getSession();
		response.setHeader("set-cookie", "JSESSIONID=" + session.getId() + ";");
		response.sendRedirect("/main");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
