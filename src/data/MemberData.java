package data;

import master.Member;

public class MemberData extends Member{
	
	public MemberData(){
		this.name = "박명훈";
		this.age = 41;
		this.phoneNum ="010-1234-3210";
		this.addr = "서울시 종로구 숭인동";
		this.email = "hoon@naver.com";
		this.loginCheck = false;
		this.setId("hoon");
		this.setPw("hoon");
		this.level = 2;
		this.numOfRent = 2;
		this.rentalAvail = 3;
		this.numOfExtens = 1;
		this.overdue = 0;
		this.rentalDate = 7;
		this.returnDate = " ";
		this.rentInfo = "없음";
		this.extenDate = 7;
		
		
	}

}
