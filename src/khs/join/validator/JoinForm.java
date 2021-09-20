package khs.join.validator;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import khs.join.model.service.JoinService;

public class JoinForm {

	private String userId; 
	private String password; 
	private String email;
	private String tell; 
	private JoinService joinService; 
	private HttpServletRequest request; 
	
	private Map<String, String> failedAttribute = new HashMap<String, String>();
	
	public JoinForm(HttpServletRequest request) {
		System.out.println("5. joinForm의 객체 생성");
		this.request = request;
		this.userId = request.getParameter("userId");
		this.password = request.getParameter("password");
		this.email = request.getParameter("email");
		this.tell = request.getParameter("tell");
	}
	
	public boolean test() {
		
		boolean res = true; 
		
		// java에서는 Pattern, String 객체를 통해서 정규표현식을 사용할 수 있다. 
		// Pattern의 static method를 통해 비교가능 
		if(joinService.searchById(userId) != null) {
			failedAttribute.put("userId", userId);
			res = false;
		} 
		// 비밀번호가 영수특수문자 조합의 8자리 이상 문자열 
		boolean valid = Pattern.matches("(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[^a-zA-Zㄱ-힣0-9]).{8,}", password);
		if(!valid) {
			failedAttribute.put("password", password);
			res = false;			
		}
		// 전화번호가 9-11자리의 숫자
		valid = Pattern.matches("^\\d{9,11}$", tell);
		if(!valid) {
			failedAttribute.put("tell", tell);
			res = false;
		}
		
		if(!res) {
			request.getSession().setAttribute("joinFailed", failedAttribute);
			request.getSession().setAttribute("joinForm", this);
		} else {
			request.getSession().removeAttribute("joinFailed");
			request.getSession().removeAttribute("joinForm");
		}
		return res;
	}

	public String getUserId() {
		return userId;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public String getTell() {
		return tell;
	}
	
	
	
}
