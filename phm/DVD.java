package phm;

public class DVD extends RentalItemInfo{
	
	public String foreman;		//감독
	public String runingTime;	//상영시간
	public int limitAge;		//제한연령
	public String story;		//설명
	public String launchDate;	//출시일
	//public String bestTitle;	//인기자료	null
	public int rentalCount;		//대여횟수	0
	public int like;			//관심수		0
	public int numOfItem;		//재고		5
	public String returnDate;	//반납예정일	0

	//인스턴스 변수 초기화
	public DVD(String title, String genre, String localData,String foreman,String runingTime,int limitAge,String story,String launchDate) {
		super(title, genre, localData);
		this.foreman = foreman;
		this.runingTime = runingTime;
		this.limitAge = limitAge;
		this.story = story;
		this.launchDate = launchDate;
		//this.bestTitle = null;
		this.rentalCount = 0;
		this.like = 0;
		this.numOfItem = 5;
		this.returnDate = null;
	}
	public DVD() {
		
	}
	


	@Override
	void showBasicInfo() {
		super.showBasicInfo();
		System.out.println("감독 :"+foreman);
	}
	
	@Override
	void showAllinfo() {
		super.showBasicInfo();
		System.out.println("제한연령 :"+limitAge+"\t\t출판일 :"+launchDate+"\t\t상영시간 :"+runingTime+"\r\n설명 :"+story);
		System.out.println("대여횟수 :"+rentalCount+"\t\t관심수 :"+like+"\t\t\t\t재고 :"+numOfItem+"\t\t\t반납예정일 :"+returnDate);
	}



	@Override
	boolean checkTitle(String title) {
		return super.checkTitle(title);
	}
	
	
	
	

}
