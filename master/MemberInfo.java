package master;

public class MemberInfo {
	
	public boolean loginCheck;	//로그인
	public String name;			//이름
	public int age;				//나이
	public String phoneNum;		//전화번호
	public String addr;			//주소
	public String email;		//이메일
	
	//인스턴스 변수 초기화
	public MemberInfo(String name,int age, String phoneNum,String addr,String email){
		this.name = name;
		this.age = age;
		this.phoneNum = phoneNum;
		this.addr = addr;
		this.email = email;
		this.loginCheck = false;
				
	}
	public MemberInfo(){
		
	}
	
	void showBasicInfo() {
		System.out.println("이름 : "+name+"\t\t나이 : "+age+"\t\t\t\t전화번호 : "+phoneNum+"\t\t주소 : "+addr+"\t\t이메일 : "+email);
	}
	
	void showAllInfo() {
		
	}
	
	void AllInformation() {
		
		
	}

}
