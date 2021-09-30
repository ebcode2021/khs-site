package khs.myPage.validator;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;


public class DeletePostForm {
	
	private HttpServletRequest request;
	private Map<String,String> failedMypageAttr = new HashMap<String, String>();
	
	public DeletePostForm(HttpServletRequest request) {
		this.request = request;
	}
	
	public boolean test() {
		boolean res = true;
		String msg = null;
		
		String[] BdIdx = request.getParameterValues("chk_num");
		
		if(BdIdx==null) {
			msg = "체크된 항목이 없습니다.";
			failedMypageAttr.put("invalidCheckBoxMsg1", msg);
			res = false;
		}
		
		
		if(!res) {
			request.getSession().setAttribute("myPageFailed", failedMypageAttr);
		}else {
			request.getSession().removeAttribute("myPageFailed");
		}
		
		return res;
	}
	
	
}
