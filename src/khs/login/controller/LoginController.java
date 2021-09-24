package khs.login.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		if(uriArr[uriArr.length-1].equals("login-check")) {
			loginCheck(request,response);
		}else {
			request.getRequestDispatcher("/login/login").forward(request, response);
		}
		
	
	}

	private void loginCheck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LoginForm loginForm = new LoginForm(request);
		
		if(!loginForm.test()) {
			System.out.println("DB에 계정이 없는 경우");
			response.sendRedirect("/login");
			return;
		}
		
		HttpSession session = request.getSession();
		String userId = request.getParameter("userId");
		response.setHeader("set-cookie", "JSESSIONID=" + session.getId() + ";");
		session.setAttribute("memberId", userId);
		response.sendRedirect("/main");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
