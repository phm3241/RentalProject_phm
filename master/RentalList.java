package master;

import java.time.LocalDateTime;

public class RentalList {
	
	public String id;      		// 회원ID
	public String title;			// 자료명
	public String rentInfo;		// 대여상태
	public String rentalDate;		// 대여일#
	public String returnDate;		// 반납예정일#
	public String returnLimit;		// 반납일#
	public String reservDate;		// 예약일#
	public String reservId;		// 예약자
	public String extendDate;	 	// 연장된 반납일#
	public String overdue;			// 연체일
	
	
	AdminManager admManager=AdminManager.getInstance();
	
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
		System.out.println("대여 ID : "+id+"\t\t대여 자료명 : "+title+"\t\t대여상태 : "+rentInfo);
		System.out.println("대여일    : "+rentalDate+"\t\t반납예정일 : "+returnLimit+"\t\t반납일 : "+returnDate);
		System.out.println("연체기간: "+overdue+"\t\t연장기간 : "+extendDate);
		System.out.println("예약일    : "+reservDate+"\t\t예약자 : "+reservId);
        System.out.println("--------------------------------------------------------------------------------------------------");

    }
}
