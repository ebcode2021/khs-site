package khs.myPage.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import khs.board.model.dto.Board;
import khs.common.code.ErrorCode;
import khs.common.encrypt.Encrypter;
import khs.common.exception.HandlableException;
import khs.common.exception.PageNotFoundException;
import khs.common.file.FileDTO;
import khs.common.file.FileUtil;
import khs.common.file.MultiPartParams;
import khs.myPage.model.dto.MyPage;
import khs.myPage.model.dto.ProfileImage;
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
		case "delete-post":
			deletePost(request,response);
			break;
		case "delete-comment":
			deleteComment(request,response);
			break;
		case "delete-account":
			deleteAccount(request,response);
			break;
		case "logout":
			logout(request,response);
			break;
		case "profile-image-upload":
			profileImageUpload(request,response);
			break;
		case "profile-image-delete":
			profileImageDelete(request,response);
			break;
			
		default: throw new PageNotFoundException();
		
		}
		
		
	}
	
	


	private void profileImageDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = myPageService.getLoginMemberId(request);
		
		myPageService.profileImageDelete(userId);
		request.setAttribute("msg", "프로필 사진 삭제 완료");
		request.setAttribute("url", "/myPage/myPageMain");
		request.getRequestDispatcher("/error/result").forward(request, response);
	}



	private void profileImageUpload(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = myPageService.getLoginMemberId(request);
		FileUtil util = new FileUtil();

		MultiPartParams multiPart = util.fileUpload(request);
		
		List<FileDTO> files = multiPart.getFilesInfo();
		
		myPageService.profileImageUpload(userId, files.get(0));
		
		request.setAttribute("msg", "프로필 사진 업로드 성공");
		request.setAttribute("url", "/myPage/myPageDetail");
		request.getRequestDispatcher("/error/result").forward(request, response);
		
	}



	private void deleteAccount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = myPageService.getLoginMemberId(request);
		myPageService.deleteAccount(userId);
		
		request.setAttribute("msg","회원 탈퇴가 완료되었습니다.");
		request.setAttribute("url", "/login");
		request.getSession().removeAttribute("authentication");
		request.getRequestDispatcher("/error/result").forward(request, response);

	}



	private void deleteComment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = myPageService.getLoginMemberId(request);
		String[] cmtIdx = request.getParameterValues("chk_cmt_num");
	
		myPageService.deleteMyComment(userId, cmtIdx);
		
		request.setAttribute("msg", "선택한 댓글이 삭제되었습니다.");
		request.setAttribute("url", "/myPage/myPageMain");
		request.getRequestDispatcher("/error/result").forward(request, response);
		//response.sendRedirect("/myPage/myPageMain");
	}



	private void deletePost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = myPageService.getLoginMemberId(request);
		String[] bdIdx = request.getParameterValues("chk_num");
	
		myPageService.deleteMyPost(userId, bdIdx);
		
		request.setAttribute("msg", "선택한 게시글이 삭제되었습니다.");
		request.setAttribute("url", "/myPage/myPageMain");
		request.getRequestDispatcher("/error/result").forward(request, response);
		//response.sendRedirect("/myPage/myPageMain");
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
		ProfileImage profileImage = myPageService.profileImageDownload(userId);
		
		request.setAttribute("profileImage", profileImage);
		request.setAttribute("authentication", myPage);
		request.getRequestDispatcher("/myPage/myPageDetail").forward(request, response);
		
	}



	private void myPageMain(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = myPageService.getLoginMemberId(request);
		MyPage myPage = myPageService.selectMyPage(userId);
		List<Board> boardList = myPageService.selectMyPost(userId);
		List<Board> commentList = myPageService.selectMyComment(userId);
		ProfileImage profileImage = myPageService.profileImageDownload(userId);
		
		
		
		request.setAttribute("profileImage", profileImage);
		request.setAttribute("authentication", myPage);
		request.setAttribute("boardList", boardList);
		request.setAttribute("commentList", commentList);
		request.getRequestDispatcher("/myPage/myPageMain").forward(request, response);
		
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
