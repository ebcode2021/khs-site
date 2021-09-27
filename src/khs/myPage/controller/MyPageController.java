package khs.myPage.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import khs.common.encrypt.Encrypter;
import khs.common.exception.PageNotFoundException;
import khs.myPage.model.dto.Board;
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
		case "logout":
			logout(request,response);
			break;
			
		default: throw new PageNotFoundException();
		
		}
		
		
	}
	
	


	private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().getAttribute("authentication");
		request.getSession().removeAttribute("authentication");
		request.setAttribute("msg", "로그아웃 되었습니다.");
		request.setAttribute("url", "/login");
		request.getRequestDispatcher("/error/result").forward(request, response);
	}



	private void changePassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId = myPageService.getLoginMemberId(request);
		String newPassword = request.getParameter("newPassword");

		String SHA256Pwd = Encrypter.convertToSHA256(newPassword);

		myPageService.changePassword(userId,SHA256Pwd);
		
		request.setAttribute("msg", "비밀번호 변경이 완료되었습니다.");
		request.setAttribute("url", "/myPage/myPageDetail");
		request.getRequestDispatcher("/error/result").forward(request, response);
	}



	private void updateDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = myPageService.getLoginMemberId(request);
		String nickName = request.getParameter("newNickname");
		String email = request.getParameter("newEmail");
		
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
		String userId = myPageService.getLoginMemberId(request);
		MyPage myPage = myPageService.selectMyPage(userId);
		List<Board> boardList = myPageService.selectMyPosting(userId);
		
		System.out.println(boardList);
		
		request.setAttribute("authentication", myPage);
		request.setAttribute("myPosting", boardList);
		request.getRequestDispatcher("/myPage/myPageMain").forward(request, response);
		
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
