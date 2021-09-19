package khs.login.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import khs.common.exception.PageNotFoundException;
import khs.login.model.dto.Member;
import khs.login.model.service.MemberService;

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
		request.getRequestDispatcher("/login").forward(request, response);
		}
	}

	private void loginCheck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		
		Member member = null;
		
		member = memberService.memberAuthenticate(userId, password);
		
		if(member==null) {
			System.out.println("로그인이 실패");
			response.sendRedirect("/login");
			return;
		}
		
		request.getSession().setAttribute("authentication", member);
		response.sendRedirect("/main/main");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
