package khs.join.validator;

import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.Date;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.multipart.FilePart;
import com.oreilly.servlet.multipart.MultipartParser;
import com.oreilly.servlet.multipart.Part;

import khs.common.file.FileDTO;
import khs.common.file.FileUtil;
import khs.common.file.MultiPartParams;
import khs.join.model.dto.Member;
import khs.join.model.service.JoinService;

public class JoinForm {

	private final int MAX_SIZE = 1024*1024*10;
	
	private String userId; 
	private String password; 
	private String passwordCheck;
	private String email;
	private String variCode; 
	private String name; 
	private String nickName;
	private String birth; 
	private String selectKH; 
	
	private HttpServletRequest request;
	private MultiPartParams multiPartParams;
	private JoinService joinService = new JoinService();
	private FileUtil fileUtil = new FileUtil();
	private Map<String, String> failedAttribute = new HashMap<String, String>();
	
	public JoinForm(HttpServletRequest request) {
		this.request = request;
		this.multiPartParams = fileUtil.fileUpload(request);
		this.userId = multiPartParams.getParameterValues("userId")[0];
		this.password = multiPartParams.getParameterValues("password")[0];
		this.passwordCheck = multiPartParams.getParameterValues("passwordCheck")[0];
		this.email = multiPartParams.getParameterValues("email")[0];
		this.variCode = multiPartParams.getParameterValues("emailVali")[0];
		this.name = multiPartParams.getParameterValues("name")[0];
		this.nickName = multiPartParams.getParameterValues("nickName")[0];
		this.birth = multiPartParams.getParameterValues("birth")[0];
		if(multiPartParams.isEmpty("selectKH")) {
			this.selectKH = null;
		} else {
			this.selectKH = multiPartParams.getParameterValues("selectKH")[0];
		}

		
	}
	
	public boolean test() {

		// 1. 최종 검증을 위한 boolean 값을 설정		
		boolean res = true;
		
		// 2. 아이디 검증
		boolean userIdResult = true; 
		if(userId.isEmpty()) {
			System.out.println("값 없음");
			res = false; 
		} else {
			if(isWhiteSpace(userId)) {
				System.out.println("빈칸");
				userIdResult = false; 
			}
			if(isSpecialSymbols(userId)) {
				System.out.println("특문");
				userIdResult = false;
			}
			if(!(testID(userId))) {
				userIdResult = false; 
			}
			if(!(testIDCheck(userId))) {
				userIdResult = false; 
			}
			if( userIdResult == false ) {
				failedAttribute.put("userId", userId);
				res = false; 
			}
		}
		
		// 2. 비밀번호 검증
		boolean userPassword = true; 
		if(password.isEmpty()) {
			res = false; 
		} else {
			if(isWhiteSpace(password)) {
				userPassword = false; 
			}
			if(!(testPassword(password))) {
				userPassword = false; 
			}
			if(!(testPasswordCheck(password))) {
				userPassword = false; 
			}
			if( userPassword == false ) {
				failedAttribute.put("password", password);
				res = false; 
			}
		}
		
		//	3. 이메일 검증
		boolean userEmail = true; 
		if(email.isEmpty()) {
			res = false; 
		} else {
			if(isWhiteSpace(email)) {
				userEmail = false; 
			}
			if(!(testEmail(email))) {
				userEmail = false; 
			}
			if(!(testEmailCode(request, variCode))) {
				userEmail = false; 
			}
			if( userEmail == false ) {
				failedAttribute.put("email", email);
				res = false; 
			}
		}

		
		
		//	4. 이름 검증
		boolean userName = true; 
		if(name.isEmpty()) {
			System.out.println("빈 값");
			res = false; 
		} else {
			if(isWhiteSpace(name)) {
				userName = false; 
			}
			if(isSpecialSymbols(name)) {
				userName = false; 
			}
			if(!(testName(name))) {
				userName = false; 
			}
			if( userName == false ) {
				failedAttribute.put("name", name);
				res = false; 
			}
		}
		
		// 5. 별명 검증
		boolean userNickName = true; 
		if(nickName.isEmpty()) {
			System.out.println("빈 값");
			res = false; 
		} else {
			if(isWhiteSpace(nickName)) {
				System.out.println("공백");
				userNickName = false; 
			}
			if(isSpecialSymbols(nickName)) {
				System.out.println("특수문자");
				userNickName = false; 
			}
			if(!(testNickName(nickName))) {
				System.out.println("정규표현식");
				userNickName = false; 
			}
			if(!(testNickNameCheck(nickName))){
				System.out.println("중복검사 실패");
				userNickName = false;
			}
			if( userNickName == false ) {
				System.out.println("하나라도 실패값 존재");
				failedAttribute.put("nickName", nickName);
				res = false; 
			}
		}
		
		// 6. 생년월일 검증
		if(birth.isEmpty()) {
			res = false; 			
		} 
		
		// 7. KH센터 입력값 검증 
		if(selectKH == null) {
			System.out.println("값 없음");
			res = false; 
		} 

		// 8. 파일 입력값 검증 
		boolean isFileEmpty = multiPartParams.getFilesInfo().isEmpty();
		String variFile = "noFile";  
		if(isFileEmpty) {
			res = false;
			failedAttribute.put("file", "noFile");
		} else {
			variFile = multiPartParams.getFilesInfo().get(0).getSavePath();
		}
		
		System.out.println("----------------ValidatorFilter return 값 : " + res + "----------"); 

		if(!res) {
			request.getSession().setAttribute("joinForm", this);
			request.getSession().setAttribute("joinFailed", failedAttribute);
		} else {
			request.getSession().removeAttribute("joinForm");
			request.getSession().removeAttribute("joinFailed");
		}
		
		
		Member member = new Member();
		if(!birth.isEmpty()) {
			Date sqlDate = Date.valueOf(birth);
			member.setBirthDate(sqlDate);
		}
		
		member.setUserId(userId);
		member.setPassword(password);
		member.setEmail(email);
		member.setName(name);
		member.setNickname(nickName);
		member.setVariFile(variFile);
		member.setKhCenter(selectKH);
		
		System.out.println("--- memberDTO의 값 : " + member.toString());
		
		request.setAttribute("joinCompleteMember", member);
		
		
		return res;
	}

	private boolean testID(String attribute) {
		boolean result = Pattern.compile("[A-Za-z]{1}[A-Za-z0-9]{3,12}").matcher(attribute).matches();
		return result;
	}

	private boolean testIDCheck(String attribute) {
		if(joinService.checkId(attribute) != null) {
			return false;
		} else {
			return true;
		}
	}

	private boolean testPassword(String attribute) {
		boolean result = Pattern.compile("(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]{8,12}").matcher(attribute).matches();
		return result;
	}
	
	private boolean testPasswordCheck(String attribute) {
		if (!(attribute.equals(passwordCheck)) ) {
			return false; 
		} else {
			return true;
		}
	}
	
	private boolean testEmail(String attribute) {
		boolean result = Pattern.compile("[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}").matcher(attribute).matches();
		return result;
	}
	
	private boolean testEmailCode(HttpServletRequest request, String attribute) {
		String result = joinService.checkVarificationEmail(request, attribute);
		if(result == "valid") {
			return true;
		} else {
			return false;
		}
	}
	
	private boolean testName(String attribute) {
		boolean result = Pattern.compile("[가-힣]{2,4}").matcher(attribute).matches();
		return result;
	}

	private boolean testNickName(String attribute) {
		boolean result = Pattern.compile("[가-힣]{2,4}").matcher(attribute).matches();
		return result;
	}
	
	private boolean testNickNameCheck(String attribute) {
		String result = joinService.checkNickName(nickName);
		if(result == null) {
			return true;
		} else {
			return false;
		}
	}
	
	
	private boolean isWhiteSpace(String attribute) {
		// 공백이 있다면 false 결과 보냄, 없다면 true 
		boolean result = Pattern.compile("\\s").matcher(attribute).find();
		return result;
	}
	
	private boolean isSpecialSymbols(String attribute) {
		// 특수문자 있다면 false 결과 보냄, 없다면 true 
		boolean result = Pattern.compile("[~!@#$%^&*()_+|<>?:{}]").matcher(attribute).find();
		return result;
	}
	
	public String getUserId() {
		return userId;
	}

	public String getPassword() {
		return password;
	}

	public String getPasswordCheck() {
		return passwordCheck;
	}

	public String getEmail() {
		return email;
	}

	public String getVariCode() {
		return variCode;
	}

	public String getName() {
		return name;
	}

	public String getNickName() {
		return nickName;
	}

	public String getBirth() {
		return birth;
	}

	public String getSelectKH() {
		return selectKH;
	}
	
	
	
	
}
