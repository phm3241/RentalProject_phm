package phm;

public class Admin{
	
	boolean loginCheck;			//로그인
	private String adminId;		//관리자 아이디
	private String adminPw;		//관리자 비번
	
	Admin(String adminId,String adminPw){
		
		this.adminId = adminId;
		this.adminPw = adminPw;
		this.loginCheck = false;
		
	}
	
	boolean checkId(String adminId) {
		return this.adminId.equals(adminId);
	}
	
	boolean checkpw(String adminPw) {
		return this.adminPw.equals(adminPw);
	}

}
