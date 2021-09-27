package khs.adminPage.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/adminPage")
public class adminPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public adminPageController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] uriArr = request.getRequestURI().split("/");
		switch (uriArr[uriArr.length-1]) {
		//1. 메인페이지에서 회원정보 조회 페이지로 들어갈 경우! 
		case "adminPage": 
			adminPage(request,response);
			break;
		//2. 메인페이지에서 차단된 회원관리 페이지로 들어갈 경우
		case "memberBlock":
			break;
		//3. 메인페이지에서 자유게시판 관리 페이지로 들어갈 경우
		case "freeChart":
			break;
		default:
			break;
		}
	}

	private void adminPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/adminPage/adminPage-index").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
