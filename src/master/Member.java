package master;

public class Member extends MemberInfo{

	public boolean loginCheck;		//로그인
	private String id;				//회원 아이디
	private String pw;				//회원 비밀번호
	public int level;				//대여 등급 1 -> 2 -> 3
	public int numOfRent;			//대여권수 0
	public int rentalAvail;			//대여가능횟수 5
	public int numOfExtens;			//연장가능횟수 1
	public int overdue;				//연체 0
	public int rentalDate;			//대여일 7
	public String returnDate;		//반납예정일 
	public String rentInfo;			//대여상태 
	public int extenDate;		//연장된 반납일 = 반납예정일 +7
	
	
	
	//인스턴스 변수 초기화
	public Member(String name, int age, String phoneNum, String addr, String email,String id,String pw) {
		super(name, age, phoneNum, addr, email);
		this.loginCheck = false;
		this.id = id;
		this.pw = pw;
		this.level = 1;
		this.numOfRent = 0;
		this.rentalAvail = 5;
		this.numOfExtens = 1;
		this.overdue = 0;
		this.rentalDate = 7;
		this.extenDate = 7;
	
	}
	public Member() {
		
	}
	

	@Override
	void showAllInfo() {
		super.showBasicInfo();
		System.out.println("등급 : "+level+"\t\t\t대여권수 : "+numOfRent+"\t\t\t\t대여가능권수 : "+rentalAvail+"\t\t\t연장가능횟수 : "+numOfExtens+"\t\t\t연체 : "+overdue);
		System.out.println("아이디 : "+id);
		
	}
	

	@Override
	void AllInformation() {
		super.showBasicInfo();
		System.out.println("등급 : "+level+"\t\t\t대여권수 : "+numOfRent+"\t\t\t\t대여가능권수 : "+rentalAvail+"\t\t\t연장가능횟수 : "+numOfExtens+"\t\t\t연체 : "+overdue);
		System.out.println("대여일 : "+rentalDate+"\t반납예정일 : "+returnDate+"\t\t\t대여상태 : "+rentInfo+"\t\t\t연장된 반납일 : "+extenDate);
	}
	
	boolean checkId(String id) {
		return this.id.equals(id);
	}
	boolean checkPw(String pw) {
		return this.pw.equals(pw);
	}

	public String getId() {
		return id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}
