package phm;

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
		
	}
	
	public RentalItemInfo() {
		// TODO Auto-generated constructor stub
	}
	
	//기본정보 출력 메서드
	void showBasicInfo() {
		System.out.println("자료명 : "+title+"\t\t장르 :"+genre+"\t\t\t자료위치 :"+localData+"\t\t대여상태 :"+rentInfo);
	}
	
	void showAllinfo() {
	
		
	}
	
	boolean checkTitle(String title) {
		return this.title.equals(title);
	}
	

}
