package phm.test;

public class RentalItemInfo {
	
	public String title;		//자료명
	public String genre;		//장르
	public String localData;	//자료위치
	public String rentInfo;		//대여상태
	public int numOfItem;		// 자료의 재고
	public int rentalCount; 	// 자료의 대여횟수
	
	
	//인스턴스 변수 초기화
	public RentalItemInfo(String title,String genre,String localData){
		this.title = title;
		this.genre = genre;
		this.localData = localData;
		this.rentInfo = "대여가능" ;
		this.numOfItem = 5;
		this.rentalCount = 0;
		
	}
	
	public RentalItemInfo() {
		// TODO Auto-generated constructor stub
	}
	
	//기본정보 출력 메서드
	public void showBasicInfo() {
		System.out.println("자료명 : "+title+"\t\t장르 : "+genre+"\t\t재고 : "+numOfItem+"\t\t자료위치 : "+localData);
	}
	
	public void showAllinfo() {
	
		
	}
	
	public boolean checkTitle(String title) {
		return this.title.equals(title);
	}
	
	
	// 대여시 자료 카운트 변경 
	public void countMinus() {
		numOfItem -= 1;  		// 자료 재고 -1
		rentalCount += 1;		// 자료 대여횟수 +1
		rentInfo = "대여중" ;		// 자료 대여상태  
	}
	
	// 반납시 자료 카운트 변경
	public void countPlus() {
		numOfItem += 1;  		// 자료 재고 +1
		rentInfo = "대여가능" ;	// 자료 대여상태  
	}
	
	
	

}
