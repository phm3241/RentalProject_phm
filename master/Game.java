package master;

public class Game extends RentalItemInfo{
	
	public String producer;		//제작사
	public int limitAge;		//제한연령
	public String story;		//설명
	public String launchDate;	//출시일
	//public String bestTitle;	//인기자료	null
	public int like;			//관심수		0
	public String returnDate;	//반납예정일	0
	
	//인스턴스 변수 초기화
	public Game(String title, String genre, String localData,String producer,int limitAge,String story,String launchDate) {
		super(title, genre, localData);
		this.producer = producer;
		this.limitAge = limitAge;
		this.story = story;
		this.launchDate = launchDate;
		//this.bestTitle = null;
		this.like = 0;
		this.returnDate = null;
		
	}
	public Game(){
		
	}
	


	@Override
	void showBasicInfo() {
		super.showBasicInfo();
		System.out.println("제작사 : "+producer);
	}
	
	@Override
	void showAllinfo() {
		super.showBasicInfo();
		System.out.println("제한연령 : "+limitAge+"\t\t출시일 : "+launchDate+"\r\n설명 : "+story);
		System.out.println("대여횟수 : "+rentalCount+"\t\t관심수 : "+like);
        System.out.println("----------------------------------------------------------------------------------------------------");

	}



	@Override
	boolean checkTitle(String title) {
		return super.checkTitle(title);
	}

}
