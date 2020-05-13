package phm.data;

import phm.Member;

public class MemberData extends Member{
	
	public MemberData(){
		this.name = "박명훈";
		this.age = 20;
		this.phoneNum ="010-1234-3210";
		this.addr = "서울시 종로구 숭인동";
		this.email = "qkraudgns@naver.com";
		this.loginCheck = false;
		this.setId("qkraudgns");
		this.setPw("qkraudgns111");
		this.level = 2;
		this.numOfRent = 0;
		this.rentalAvail = 5;
		this.numOfExtens = 1;
		this.overdue = 0;
		this.rentalDate = 7;
		this.returnDate = "0";
		this.rentInfo = "없음";
		this.dataOfExtens = 7;
		
		
	}

}
