package master;

public class Book extends RentalItemInfo{
	
	public String author;		//저자
	public int limitAge;		//제한연령
	public String story;		//설명
	public String launchDate;	//출판일
	//public String bestTitle;	//인기자료	null
	public int like;			//관심수 		0
	public String returnDate;	//반납예정일 	0
	

	//인스턴스 변수 초기화
	public Book(String title, String genre, String localData,String author,int limitAge,String story,String launchDate) {
		super(title, genre, localData);
		this.author = author;
		this.limitAge = limitAge;
		this.story = story;
		this.launchDate = launchDate;
		this.like = 0;
		this.returnDate = null;
		
	}
	public Book(){}
	
	
	@Override
	void showBasicInfo() {
		super.showBasicInfo();
		System.out.println("저  자 : "+author);

	}
	
	
	@Override
	void showAllinfo() {
		super.showBasicInfo();
		System.out.println("제한연령 : "+limitAge+"\t\t출판일 : "+launchDate+"\r\n설명 : "+story);
		System.out.println("대여횟수 : "+rentalCount+"\t\t관심수 : "+like);
        System.out.println("----------------------------------------------------------------------------------------------------");

		
	}


	@Override
	boolean checkTitle(String title) {
		return super.checkTitle(title);
	}

	
}
