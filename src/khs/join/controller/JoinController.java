package khs.join.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import khs.common.code.ErrorCode;
import khs.common.exception.HandlableException;
import khs.common.file.FileDTO;
import khs.common.file.FileUtil;
import khs.common.file.MultiPartParams;
import khs.join.model.dto.Member;
import khs.join.model.service.JoinService;

@WebServlet("/join/*")
public class JoinController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
	private JoinService joinService = new JoinService();
	
    public JoinController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. URI 분리 작업 //
		
		String[] uriArr = request.getRequestURI().split("/");
		switch (uriArr[uriArr.length-1]) {
			// join-form으로 reqeustDispatcher를 통해 재지정시키는 분기점
		case "join-form" : 
			joinForm(request, response);
			break; 
			// join(회원가입) 기능을 수행하는 메서드로 보내는 분기점 
		case "join-Method" : 
			join(request, response);
			break; 
		case "join-send-Vari-Email" :
			joinSendVariEmail(request, response);
			// PageNotFound 404 오류를 던지는 분기점 
		default: response.setStatus(404);
			break;
		}
	}

	

	private void joinForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/join/join-form").forward(request, response);
		
	}
	
	private void join(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 // 1. Multipart-Form DATA 형태로 온 FILE/Parameter를 파싱하기 위해 
		//  미리 만들어둔 fileUtil CLass를 사용한다. 
		// ( 넘어온 Data를 oreilly Library를 사용하여 파싱, Map에 key-value 형태로 담는다. ) 
		 FileUtil fileUtil = new FileUtil();
		 
		 //*************** 예기치 않은 downCasting( 코드분리 숙지 미흡 ) ***********
		 // 더 이상 Map이 반환되는 것이 아닌, map의 map<map, params>인 multipartParams 반환됨 
		 
		 MultiPartParams multiPartParams = fileUtil.fileUpload(request);
		 
		 //2. 파싱된 데이터 중 파일이 아닌 데이터를 꺼낸다. 
		 // ( objectList이므로 자료를 꺼낼 때는 downcasting까지 완료해야 한다. )
		 String userId = multiPartParams.getParameter("userId");	 
		 String password = multiPartParams.getParameter("password");
		 String email = multiPartParams.getParameter("email");
		 String name = multiPartParams.getParameter("name");
		 //String birth = (String) multiPart.get("email").get(0);
		 Date birth = new Date(new java.util.Date().getTime());
		 String nickname = multiPartParams.getParameter("nickName");
		 String selectKH = multiPartParams.getParameter("selectKH");
		 
		 // ********* 기존 기능 주석처리 *********
		 //String selectKH = (String) multiPart.get("selectKH").get(0);
		 
		 System.out.println("아이디 : " + userId);
		 System.out.println("비밀번호 : " + password);
		 
		 //3. 넘어온 file 역시 FileDTO에 넣는다. 
		 // ( file DTO에 대해서는 프로젝트에서 아직 확실하게 TABLE 용도가 정해지지 않음, 일단 )
		 // ( INSERT 문을 사용하는 것은 보류 )
		 // 일단 fileDTO 역시 주석처리 
		 //List<FileDTO> files = multiPart.get("files");
		
		 //4. 모든 Parameter 값을 memeberDTO에 넣는다
		 Member newMember = new Member();
		 newMember.setUserId(userId);
		 newMember.setPassword(password);
		 newMember.setEmail(email);
		 newMember.setName(name);
		 newMember.setNickname(nickname);
		 newMember.setBirthDate(birth);
		 newMember.setKhCenter(selectKH);
		 
		 System.out.println(newMember);
		 //5. Service 단으로 만든 newMember DTO 인스턴스를 보낸다. 
		 joinService.insertMember(newMember);
		 	
	}
	
	private void joinSendVariEmail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}