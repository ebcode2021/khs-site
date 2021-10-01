package khs.common.code;

public enum Config {
	//DOMAIN("https://pclass.ga"), // 이건 배포용 도메인
	DOMAIN("http://localhost:9090"),
	COMPANY_EMAIL("KHsemiPro04@gmail.com"),//회사이메일을 적으면되는부분.
	SMTP_AUTHENTICATION_ID("KHsemiPro04@gmail.com"),
	SMTP_AUTHENTICATION_PASSWORD("dlftjrtkwh04"),
	//UPLOAD_PATH("C:\\CODE\\upload\\"); //이건 배포 경로
	UPLOAD_PATH("C:\\SEMI\\upload\\");
	
	public final String DESC;
	
	Config(String desc){
		this.DESC = desc;
	}
}
