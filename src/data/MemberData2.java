package data;

import master.Member;

public class MemberData2 extends Member{
	
	public MemberData2(){
		this.name = "박성민";
		this.age = 12;
		this.phoneNum ="010-8080-9632";
		this.addr = "서울시 종로구 혜화동";
		this.email = "min@naver.com";
		this.loginCheck = false;
		this.setId("min");
		this.setPw("min");
		this.level = 3;
		this.numOfRent = 2;
		this.rentalAvail = 3;
		this.numOfExtens = 0;
		this.overdue = 0;
		this.rentalDate = 7;
		this.returnDate = " ";
		this.rentInfo = "없음";
		this.extenDate = 7;
		
		
	}

}
