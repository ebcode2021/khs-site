package khs.myPage.validator;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import khs.myPage.model.service.MyPageService;



public class ChangePasswordForm {

	private String password;
	private String newPassword;
	private String newPassword2;
	private HttpServletRequest request;
	private Map<String,String> failedAttribute = new HashMap<String, String>();
	private MyPageService myPageService = new MyPageService();
	
	public ChangePasswordForm(HttpServletRequest request) {
		this.request = request;
		this.password = request.getParameter("password");
		this.newPassword = request.getParameter("newPassword");
		this.newPassword2 = request.getParameter("newPassword2");
	}
	
	public boolean test() {
		String userId = "carinae4717";
		boolean res = true;
		boolean valid = true;
		boolean valid2 = true;
		String msg = null;
		String originPassword = myPageService.selectMyPage(userId).getPassword();
		String  passwordRegEx = "(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[^a-zA-Zㄱ-힣0-9]).{8,}";
		
		
		valid = Pattern.matches(passwordRegEx, newPassword);
		valid2 = Pattern.matches(passwordRegEx, newPassword2);
		
		
		
		if(!(password.equals(originPassword))){
			msg = "비밀번호를 잘 못 입력하셨습니다.";
			failedAttribute.put("errorMsg1", msg);
			res = false;
		}
		
		
		
		if(!(newPassword.equals(newPassword2))){
			msg = "두 비밀번호가 일치하지 않습니다.";
			failedAttribute.put("errorMsg2", msg);
			res = false;
		}
		
		if(!(valid && valid2)) {
			msg = "비밀번호는 영어,숫자,특수문자 조합의 8글자 이상의 문자열입니다.";
			failedAttribute.put("errorMsg3", msg);
			res = false;
		}
		
		
		if(newPassword.equals(originPassword)){
			msg = "기존의 비밀번호와 동일합니다.";
			failedAttribute.put("errorMsg4", msg);
			res = false;
		}
		
		
		
		if(!res) {
			failedAttribute.put("password", password);
			failedAttribute.put("newPassword", newPassword);
			failedAttribute.put("newPassword2", newPassword2);
			request.getSession().setAttribute("changePasswordFailed", failedAttribute);
			request.getSession().setAttribute("changePasswordForm", this);
		}else {
			request.getSession().removeAttribute("changePasswordFailed");
			request.getSession().removeAttribute("changePasswordForm");
		}
		
		return res;
	}
	


	public String getPassword() {
		return password;
	}
	
	public String getNewPassword() {
		return newPassword;
	}
	
	public String getNewPassword2() {
		return newPassword2;
	}
	




}
