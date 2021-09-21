package khs.myPage.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import khs.common.exception.PageNotFoundException;
import khs.login.model.dto.Member;
import khs.login.model.service.MemberService;
import khs.myPage.model.dto.MyPage;
import khs.myPage.model.service.MyPageService;

/**
 * Servlet implementation class MyPageController
 */
@WebServlet("/myPage/*")
public class MyPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private MyPageService myPageService = new MyPageService();
    
    public MyPageController() {
        super();
        
    }

	
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] uriArr = request.getRequestURI().split("/");
		switch (uriArr[uriArr.length-1]) {
		case "myPageMain":
			myPageMain(request,response);
			break;
		case "myPageDetail":
			myPageDetail(request,response);
			break;
		case "updateDetail":
			updateDetail(request,response);
			break;
		case "changePassword":
			changePassword(request,response);
			break;
		default: throw new PageNotFoundException();
		
		}
		
		
	}


	private void changePassword(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
		
		String userId = myPageService.getLoginMemberId(request);
		String newPassword = request.getParameter("newPassword");
		
		myPageService.changePassword(userId,newPassword);
		
		request.setAttribute("msg", "비밀번호 변경이 완료되었습니다.");
		request.setAttribute("url", "/myPage/myPageDetail");
		request.getRequestDispatcher("/error/result").forward(request, response);
	}



	private void updateDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = myPageService.getLoginMemberId(request);
		String nickName = request.getParameter("nickname");
		String email = request.getParameter("email");
		
		MyPage myPage = new MyPage();
		
		myPage.setUserId(userId);
		myPage.setNickName(nickName);
		myPage.setEmail(email);
		
		myPageService.updateDetail(myPage);
		
		request.setAttribute("msg","회원정보 변경이 완료되었습니다.");
		request.setAttribute("url", "/myPage/myPageDetail");
		request.getRequestDispatcher("/error/result").forward(request, response);
		
		
	}



	private void myPageDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = myPageService.getLoginMemberId(request);
		MyPage myPage = myPageService.selectMyPage(userId);
		request.setAttribute("authentication", myPage);
		request.getRequestDispatcher("/myPage/myPageDetail").forward(request, response);
		
	}



	private void myPageMain(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/myPage/myPageMain").forward(request, response);
		
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
