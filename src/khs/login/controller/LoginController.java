package khs.login.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import khs.common.exception.PageNotFoundException;

@WebServlet("/login/*")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
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
		
		//if(로그인 체크가 안될경우){error메세지 출력해서 main으로 못넘기게 만들어버리기}
		//정상적으로 로그인이 될 경우 /main 페이지로 이동
		request.getRequestDispatcher("/main").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
