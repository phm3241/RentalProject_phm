package phm;

import java.time.LocalDateTime;

import Manager.ItemManager;

public class RentalList {
	
	String id;      		// 회원ID
	String title;			// 자료명
	String rentInfo;		// 대여상태
	String rentalDate;		// 대여일#
	String returnDate;		// 반납예정일#
	String returnLimit;		// 반납일#
	String reservDate;		// 예약일#
	String reservId;		// 예약자
	String extendDate;		// 연장된 반납일#
	String overdue;			// 연체일
	
	ItemManager admManager=ItemManager.getInstance();
	
	RentalList(String id, String title, String start, String end){
		
		this.id=id;      				// 대여한 회원ID
		this.title=title;				// 대여한 자료명
		this.rentInfo="대여중";			// 대여상태-----------
		this.rentalDate=start; 			// 대여일#
		this.returnLimit=end;			// 반납예정일#
		this.returnDate=" ";			// 반납일#-------------
		this.reservDate=" ";			// 예약일#
		this.reservId=" ";				// 예약자
		this.extendDate=" ";			// 연장된 반납일#
		this.overdue=" ";				// 연체기간#----------------
	
	}
	
	public RentalList(){
		
	}
	

	
	
	public void showRentalListInfo() {
		System.out.println("대여 ID : "+id+"\t\t대여 자료명 : "+title+"\t\t대여상태 :"+rentInfo);
		System.out.println("대여일: :"+rentalDate+"\t\t반납예정일 :"+returnLimit+"\t\t반납일 :"+returnDate);
		System.out.println("예약일: :"+reservDate+"\t\t예약자 :"+reservId);
		System.out.println("연장기간 : "+extendDate+"\t\t연체기간: :"+overdue);
		System.out.println("--------------------------------------------------------------");  

    }
}
