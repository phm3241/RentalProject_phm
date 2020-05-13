package data;

import master.RentalList;

public class UserList8 extends RentalList{
	
//	String id;      		// 회원ID
//	String title;			// 자료명
//	String rentInfo;		// 대여상태
//	String rentalDate;		// 대여일#
//	String returnDate;		// 반납예정일#
//	String returnLimit;		// 반납일
//	String reservDate;		// 예약일#
//	String reservId;		// 예약자
//	String extendDate;		// 연장된 반납일#
//	String overdue;			// 연체일
	
	public UserList8(){
		this.id="min";  					// 대여한 회원ID
		this.title="1cm 다이빙";				// 대여한 자료명
		this.rentInfo="대여중";				// 대여상태
		this.rentalDate="2020-05-01"; 		// 대여일#
		this.returnLimit ="2020-05-08";		// 반납예정일#
		this.returnDate=" ";				// 반납일#
		this.reservDate=" ";				// 예약일#
		this.reservId=" ";					// 예약자
		this.extendDate="2020-05-15";		// 연장된 반납일#
		this.overdue=" ";					// 연체기간#
	}

}
