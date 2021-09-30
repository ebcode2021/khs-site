package khs.stduyPage.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/studyPage/*")
public class StudyPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public StudyPageController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] uriArr = request.getRequestURI().split("/");
		switch (uriArr[uriArr.length-1]) {
		case "index": 			//학습게시판 페이지로 접속
			index(request,response);
			break;
		case "studyData": 		//학습자료를 저장
			studyData(request,response);
			break;				
		default: response.setStatus(404);
			break;
		}
	}


	// 학습자료를 저장하는 메서드
	private void studyData(HttpServletRequest request, HttpServletResponse response) {

		
	}

	private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/studyPage/studyPage").forward(request, response);
		
	}

	
	
	
	
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}