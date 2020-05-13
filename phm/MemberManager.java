package phm;

import java.time.LocalDateTime;
import java.util.ArrayList;
//import data.UserList;
//import data.UserList10;
//import data.UserList11;
//import data.UserList12;
//import data.UserList13;
//import data.UserList14;
//import data.UserList15;
//import data.UserList16;
//import data.UserList2;
//import data.UserList3;
//import data.UserList4;
//import data.UserList5;
//import data.UserList6;
//import data.UserList7;
//import data.UserList8;
//import data.UserList9;

public class MemberManager {

	String title = null; // 자료명
//	String rentalDate=null; 	// 대여일#
//	String returnDate=null;		// 반납일#
	public ArrayList<RentalList> rentalList;

	// 회원리스트, 자료리스트 불러오기
	AdminManager adm = AdminManager.getInstance();

	// 기본생성자, 대여리스트 생성
	public MemberManager() {
		rentalList = new ArrayList<>();

		// 대여리스트 항목 추가
//		UserList uList=new UserList();
//		UserList2 uList2=new UserList2();
//		UserList3 uList3=new UserList3();
//		UserList4 uList4=new UserList4();
//		UserList5 uList5=new UserList5();
//		UserList6 uList6=new UserList6();
//		UserList7 uList7=new UserList7();
//		UserList8 uList8=new UserList8();
//		UserList9 uList9=new UserList9();
//		UserList10 uList10=new UserList10();
//		UserList11 uList11=new UserList11();
//		UserList12 uList12=new UserList12();
//		UserList13 uList13=new UserList13();
//		UserList14 uList14=new UserList14();
//		UserList15 uList15=new UserList15();
//		UserList16 uList16=new UserList16();
//		
//		rentalList.add(uList);
//		rentalList.add(uList2);
//		rentalList.add(uList3);
//		rentalList.add(uList4);
//		rentalList.add(uList5);
//		rentalList.add(uList6);
//		rentalList.add(uList7);
//		rentalList.add(uList8);
//		rentalList.add(uList9);
//		rentalList.add(uList10);
//		rentalList.add(uList11);
//		rentalList.add(uList12);
//		rentalList.add(uList13);
//		rentalList.add(uList14);
//		rentalList.add(uList15);
//		rentalList.add(uList16);

	}

//	■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	// 자료검색 ㅡ> 결과출력
	void showInfo() {

		System.out.println("1.도서 | 2.DVD | 3. 게임");

		int selectNum = adm.sc.nextInt();
		adm.sc.nextLine();

		switch (selectNum) {
		case 1: // Book 선택시
			System.out.println("------------------------");
			adm.showBookBasic();
			System.out.println("------------------------");

			System.out.println("찾으시는 도서명을 입력해주세요.");
			this.title = adm.sc.nextLine();

			int index = adm.searchBookInfo(title);

			if (index < 0) {
				System.out.println("검색하신 자료의 정보가 없습니다.");
				break;
			} else {
				adm.getBooks().get(index).showAllinfo();
				System.out.println("1.대여 | 2.예약");
				selectNum = adm.sc.nextInt();
				adm.sc.nextLine();

				switch (selectNum) {

				case 1: // 대여
						// 로그인 상태일시 대여메서드 실행
					if (adm.loginCheck()) {
						creatRentalList();
						break;
					} else {
						// 비로그인 시
						System.out.println("이용하시려면 로그인을 해 주세요.");
						adm.login();
						creatRentalList();
						break;
					}

				case 2: // 예약
					/* 예약 메서드 */
					break;

				} // switch : case1(Book) : switch end
				break;
			} // switch : case1(Book) : else end

		case 2: // DVD 선택시
			System.out.println("------------------------");
			adm.showDvdInfo();
			System.out.println("------------------------");

			System.out.println("찾으시는 DVD명을 입력해주세요.");
			this.title = adm.sc.nextLine();

			index = adm.searchDvdInfo(title);

			if (index < 0) {
				System.out.println("검색하신 자료의 정보가 없습니다.");
				break;
			} else {
				System.out.println("1.대여 | 2.예약");
				adm.getDvd().get(index).showAllinfo();
				selectNum = adm.sc.nextInt();
				adm.sc.nextLine();

				switch (selectNum) {

				case 1: // 대여
						// 로그인 상태일시 대여메서드 실행
					if (adm.loginCheck()) {
						creatRentalList();
						break;
					} else {
						// 비로그인 시
						System.out.println("이용하시려면 로그인을 해 주세요.");
						adm.login();
						creatRentalList();
						break;
					}

				case 2: // 예약
					/* 예약 메서드 */
					break;

				} // switch : case2(DVD) : switch end
				break;
			} // switch : case2(DVD) : else end

		case 3: // Game 선택시
			System.out.println("------------------------");
			adm.showGameInfo();
			System.out.println("------------------------");

			System.out.println("찾으시는 Game명을 입력해주세요.");
			this.title = adm.sc.nextLine();

			index = adm.searchGameInfo(title);

			if (index < 0) {
				System.out.println("검색하신 자료의 정보가 없습니다.");
				break;
			} else {
				System.out.println("1.대여 | 2.예약");
				adm.getGame().get(index).showAllinfo();
				selectNum = adm.sc.nextInt();
				adm.sc.nextLine();

				switch (selectNum) {

				case 1: // 대여
						// 로그인 상태일시 대여메서드 실행
					if (adm.loginCheck()) {
						creatRentalList();
						break;
					} else {
						// 비로그인 시
						System.out.println("이용하시려면 로그인을 해 주세요.");
						adm.login();
						creatRentalList();
						break;
					}

				case 2: // 예약
					/* 예약 메서드 */
					break;

				} // switch : case3(Game) : switch end
				break;
			} // switch : case3(Game) : else end

		} // switch end
	} // showInfo() end


//	■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	// 선택한 자료의 타입을 확인하고 카운트변경 (대여횟수, 재고수, 재고수확인후 대여불가처리)
	void itemRentalCount() {

		int index = 0;
		
		// 입력받은 title이 Book일때!
		if (adm.searchBookInfo(this.title) >= 0) {
		
			// 재고가 있으면, 재고수 -1, 대여횟수 +1
			if(adm.getBooks().get(index).numOfItem > 0) {
				index = adm.searchBookInfo(this.title);
				adm.getBooks().get(index).numOfItem -= 1;
				adm.getBooks().get(index).rentalCount += 1;
			
			// 대여불가여부 확인 : 자료의 재고가 0일때 ㅡ> 자료 예약안내
			}else if(adm.searchBookInfo(this.title)==0) {
				System.out.println("선택하신 자료가 현재 모두 대여중입니다. 대여예약을 진행해주세요.");
				showInfo();
			}
				
		// 입력받은 title이 Dvd일때!	
		}else if (adm.searchDvdInfo(this.title) >= 0) {
			
			// 재고가 있으면, 재고수 -1, 대여횟수 +1
			if(adm.getDvd().get(index).numOfItem > 0) {
				index = adm.searchDvdInfo(this.title);
				adm.getDvd().get(index).numOfItem -= 1;
				adm.getDvd().get(index).rentalCount += 1;
			
			// 대여불가여부 확인 : 자료의 재고가 0일때 ㅡ> 자료 예약안내
			}else if(adm.searchDvdInfo(this.title)==0) {
				System.out.println("선택하신 자료가 현재 모두 대여중입니다. 대여예약을 진행해주세요.");
				showInfo();
			}	
				
		// 입력받은 title이 Game일때!	
		} else if (adm.searchGameInfo(this.title) >= 0) {
			
			// 재고가 있으면, 재고수 -1, 대여횟수 +1
			if(adm.getGame().get(index).numOfItem > 0) {
				index = adm.searchGameInfo(this.title);
				adm.getGame().get(index).numOfItem -= 1;
				adm.getGame().get(index).rentalCount += 1;
			
			// 대여불가여부 확인 : 자료의 재고가 0일때 ㅡ> 자료 예약안내
			}else if(adm.searchDvdInfo(this.title)==0) {
				System.out.println("선택하신 자료가 현재 모두 대여중입니다. 대여예약을 진행해주세요.");
				showInfo();
				
			}
		}
	}
	
//	■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	// 로그인한 id의 정보를 반환하는 메서드
	Member getloginIdInfo() {

		// 로그인한 회원 Id의 인덱스 찾고,
		int index = adm.loginCheckIndex();

		// 그 회원의 정보 반환
		Member loginIdInfo = null;
		loginIdInfo = adm.getMember().get(index);

		return loginIdInfo;
	}

//	■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	// rentalList에 인스턴스 추가
	void addRental(RentalList info) {
		rentalList.add(info);

	}

//	■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	// rentalList 인스턴스 생성
	void creatRentalList() {

		// rentalList 객체 생성
		RentalList info = null;

		// login한 id의 회원정보와 id 가져오기
		Member loginIdInfo = getloginIdInfo();
		String id = loginIdInfo.getId();

		// 1. 대여불가여부 확인 : 만약에 회원의 자료 대여개수가 5개일 때
		if (loginIdInfo.numOfRent == 5) {
			System.out.println("자료 대여가능개수(5개)를 모두 사용중입니다. 자료를 반납하신 후 대여를 이용해 주세요.");


		// 2. 대여가능일때
		} else {

			// 자료 카운트 변경
			itemRentalCount();

			// 회원 카운트 변경 : 로그인한 아이디로 회원정보 받아서 카운트 변경
			loginIdInfo.numOfRent += 1; // 회원정보 : 대여권수 +1

			// 대여일 생성
			LocalDateTime rentalDate = LocalDateTime.now();
			System.out.println();
			String start = rentalDate.toString();

			// 반납일 생성 : 대여일+7일
			LocalDateTime returnDate = rentalDate.plusDays(7);
			String end = returnDate.toString();

			// MemberManager 객체 생성
			info = new RentalList(id, title, start, end);

			// MemberManager 객체 ㅡ> 대여리스트에 추가 메서드 1-1. 호출.
			addRental(info);
			System.out.println(id + "님  < " + title + " > 자료가 대여완료 되었습니다. ");
			System.out.println("대여일 : " + start + " | 반납예정일 : " + end);

		} // else end

	} // creatRentalList() end

//	■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	// 메인에서 4번 눌렀을 떄! ㅡ> 내 대여내역 자동출력, 반납 연장 선택 ㅡ> 반납. 연장 기능
	void returnExtends() {

		// 내 대여내역 자동출력
		showMyRentalList();

		// 내 대여내역에서 반납하거나 연장할 자료를 검색입력
		System.out.println("반납이나 연장하실 자료명을 입력해주세요.");
		String title = adm.sc.nextLine();

		// 검색입력 받은 타이틀이 있는 rentalList의 인덱스
		int index = checkTitle(title);

		// 반납 연장 기능선택
		System.out.println("1. 반납 | 2.연장");

		int selectNum = adm.sc.nextInt();
		adm.sc.nextLine();

		// 선택한 기능 실행
		switch (selectNum) {
		case 1: // 반납 선택시
			itemReturn(index);
			break;

		case 2: // 연장 선택시
			extention(index);
			break;
		}

	}

//	■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	// 전체 rentalList 에서 title로 검색하기 ㅡ> 인덱스 반환
	int searchRentalIndexTitle(String title) {

		int searchRentalIndex = -1;

		for (int i = 0; i < rentalList.size(); i++) {
			if (rentalList.get(i).title.equals(title)) {
				searchRentalIndex = i;
			}
		}
		return searchRentalIndex;
	}

//	■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	// 나의 rentalList 에서 title로 검색하기(내 대여내역) ㅡ> 인덱스 반환
	int checkTitle(String title) {

		int index = adm.loginCheckIndex();

		String id = adm.getMember().get(index).getId();

		int index2 = -1;
		for (int i = 0; i < rentalList.size(); i++) {
			if (rentalList.get(i).id.equals(id) && rentalList.get(i).title.equals(title)) {
				index2 = i;
				break;
			}
		}
		return index2;
	}

//	■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	// rentalList 에서 id로 검색하기(내 대여내역) ㅡ> 인덱스 반환
	void showMyRentalList() {

		int index = adm.loginCheckIndex();

		String id = adm.getMember().get(index).getId();

		for (int i = 0; i < rentalList.size(); i++) {
			if (rentalList.get(i).id.equals(id)) {

				rentalList.get(i).showRentalListInfo();

			}
		}

	}

//	■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	// rentalList 에서 title로 검색하기(관리자사용) ㅡ> 인덱스 반환
	void showTitleRentalList() {

		System.out.println("찾아보실 자료명을 입력해주세요.");
		String title = adm.sc.nextLine();

		for (int i = 0; i < rentalList.size(); i++) {
			if (rentalList.get(i).title.equals(title)) {

				rentalList.get(i).showRentalListInfo();

			}
		}

	}

//	■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	// RentalList 전체 출력
	public void showAllRentalListInfo() {
		for (int i = 0; i < rentalList.size(); i++) {
			rentalList.get(i).showRentalListInfo();
			System.out.println("----------------------------");
		}
	}

//	■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	// 예약
	void reserve() {

		// 반납일 = 현재날짜로 생성
//		LocalDateTime today=LocalDateTime.now();
//		String returnDate=today.toString();
//		System.out.println("returnDate"+returnDate);
//		
//		// 나의 대여리스트 중 해당 인덱스의  반납일이 변경됨.
//		rentalList.get(index).returnDate=returnDate;
//		rentalList.get(index).rentInfo="반납완료";
//		
//		// 대여하고 반납한 자료의 유형찾기 : 책인지. DVD인지. 게임인지.
//		// 찾아서 해당 자료의 rentInfo를 대여가능으로 변경.
//		adm.getBooks().get(index).rentInfo="대여가능";
//		
//		
//		// 나의 대여리스트 중 해당 인덱스 출력. 확인. 
//		rentalList.get(index).showRentalListInfo();

//		RentalItemInfo itemIndex = checkTypeIndex();
//
//		// if 자료의 재고가 있으면, 대여하라고 안내출력
//		if (itemIndex.numOfItem > 0) { // 재고있으면,
//			System.out.println("선택하신 자료의 재고가 있어 대여가 가능합니다. 대여를 진행해주세요.");
//		}
//
//		// else if 만약에 자료의 재고가 없으면, 예약가능
//		// 예약가능절차. 선택한 타이틀(this.title)을 rentalList에서 찾고,
//		// 그 중 가장 반납예정일이 빠른 인덱스에 예약자: 로그인한 id 추가, 예약일 : 반납예정일+1 추가
//		else if (itemIndex.numOfItem == 0) { // 재고없음이면,
//
//			// 예약할 때 받을 정보 ㅡ> 로그인한 회원 Id, 대여할 자료명
//			int index = adm.loginCheckIndex();
//			String reservId = adm.getMember().get(index).getId(); // 로그인한 id

			// rentalList에서 해당 타이틀의 반납일이 가장 빠른 인덱스 찾고

			// 예약자와 예약일 추가
//			rentalList.get(index).returnDate=returnDate;
////			rentalList.get(index).rentInfo="반납완료";
//			
//			
//			// 가장 반납일이 빠른 대여목록 찾기.. 
//			LocalDate today=LocalDate.now();
//			for(int i=0; i<rentalList.size(); i++) {
//				if(searchRentalIndexTitle(this.title)
//
//				System.out.println(title + "이(가) " + reservDate + "일자로 예약 되었습니다.");
//				System.out.println(rentalAvailDate + " 부터 대여 가능합니다.");
//		

//		} 

			// else if 예약불가 상황. 만약에 선택한 타이틀에 예약자가 있으면, 예약불가.

//		}
//
	} // reserve() end

//	■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■

	// 반납
	void itemReturn(int index) {
		
		// 반납일 = 현재날짜로 생성
		LocalDateTime today = LocalDateTime.now();
		String returnDate = today.toString();
		System.out.println("returnDate" + returnDate);

		// 나의 대여리스트 중 해당 인덱스의 반납일이 변경됨.
		rentalList.get(index).returnDate = returnDate;
		rentalList.get(index).rentInfo = "반납완료";

		// 나의 대여리스트 중 해당 인덱스 출력. 확인.
		rentalList.get(index).showRentalListInfo();
		
		// 회원 카운트 변경 : 로그인한 아이디로 회원정보 받아서 카운트 변경
		Member loginIdInfo = getloginIdInfo();
		loginIdInfo.numOfRent -= 1; // 회원정보 : 대여권수 -1
		
		// 자료 카운트 변경
		int itemIndex=0;
		
		// 자료가 책이면, 
		if (adm.searchBookInfo(this.title) >= 0) { 
			itemIndex = adm.searchBookInfo(this.title);
			adm.getBooks().get(itemIndex).numOfItem += 1;
		
		// 자료가 DVD면,
		}else if (adm.searchDvdInfo(this.title) >= 0) {
			itemIndex = adm.searchDvdInfo(this.title);
			adm.getDvd().get(itemIndex).numOfItem += 1;
		
		
		// 자료가 Game이면,
		} else if (adm.searchGameInfo(this.title) >= 0) {
			itemIndex = adm.searchGameInfo(this.title);
			adm.getGame().get(itemIndex).numOfItem -= 1;
		}
		
		
		

//	 System.out.println(gap+"일");
//
//	        if( gap > 7) {	 // 연체.
//				
//				
//	        	adm.getMember().get(adm.loginCheckIndex()).rentalAvail = 0;		// 대여가능권수
//	        	adm.getMember().get(adm.loginCheckIndex()).numOfExtens = 0;		// 연장가능횟수
//				//numOfRent = ??		// 대여권수, 빌려간게 더 있을수도 있고 없을수도있고.	??
//			
//				System.out.println(title + "연체일수가 있습니다.");
//				System.out.println(title + "연체일수는 " + gap + " 입니다.");
//				System.out.println(overdue + "일 동안 자료를 대여하실 수 없습니다.");
//				System.out.println("처리 : " + today);	
//			}else if(gap < 7) {	// 연체 없음.
//				
//				returnDate = today;						
//					
//				System.out.println(title+"자료가 정상적으로 반납되었습니다.");
//				System.out.println("처리 : " + today);	
//				
//				adm.getMember().get(adm.loginCheckIndex()).numOfRent --;			// 대여권수
//				adm.getMember().get(adm.loginCheckIndex()).rentalAvail ++;		// 대여가능권수
//				adm.getMember().get(adm.loginCheckIndex()).numOfExtens = 1;		// 연장가능횟수
//				
//			}
//			
//			// 대여가능으로 바꾼다.
//			rentalList.get(index).title
//			rentInfo = "대여가능";
//
//		}

	} // itemReturn(index) end

//	■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	// 연장.
	void extention(int index) {

		// 만약에 연장하려는 내 대여내역에 예약자가 있으면, 연장불가.
		// 만약에 내 연장횟수가 0이면, 연장불가

		// 연장된 반납일 생성 : 나의 대여리스트 중 해당 인덱스의 반납예정일 + 7
		LocalDateTime returnLimit0 = LocalDateTime.parse(rentalList.get(index).returnLimit);
		LocalDateTime extendDate1 = returnLimit0.plusDays(7);
		String extendDate = extendDate1.toString();

		// 나의 대여리스트 중 해당 인덱스의 연장된 반납일 ㅡ > 연장된 반납일로 수정
		rentalList.get(index).extendDate = extendDate;
		rentalList.get(index).rentInfo = "연장완료";

		// 나의 대여리스트 중 해당 인덱스 출력. 확인.
		rentalList.get(index).showRentalListInfo();
	}

//			
//	        
//	        long gap = startDate1.getTime() - endDate1.getTime() / (24*60*60*1000);
//            gap = Math.abs(gap);
//	        
//	        if((int)gap > 7) { //연체 있을때.
//				System.out.println(title + "연체일수가 " + gap + " 일 입니다.");
//				System.out.println(gap + " 기간동안 연장하실 수 없습니다.");
//				System.out.println("처리 : " + today);
//				
//				adm.getMember().get(adm.loginCheckIndex()).rentalAvail = 0;		// 대여가능권수
//				adm.getMember().get(adm.loginCheckIndex()).numOfExtens = 0;		// 연장가능횟수
//				
//			}else if((int)gap < 7) {	// 연체 없을때
//				
//			    returnDate = format.format(cal.getTime());
//				cal.add(Calendar.DATE, 7);
//				String extenDate = format.format(cal.getTime());
//				
//	
//				System.out.println(title + "자료가 정상적으로 7일 연장되었습니다.");
//				System.out.println(returnDate + " 까지 반납하세요.");
//				System.out.println("처리 : " + today);
//				
//				//admManager.getMember().get(admManager.loginCheckIndex()).numOfRent ??? 			// 대여권수, 빌렸던 책이니까 유지	???
//				//admManager.getMember().get(admManager.loginCheckIndex()).rentalAvail ???			// 대여가능권수, ???
//				adm.getMember().get(adm.loginCheckIndex()).numOfExtens = 0;		// 연장가능횟수, 연장을 썼으니까 0으로 바꿔준다.
//			
//				
//			}
//		}
////			rentInfo = "대여중";		// 대여상태 대여중으로 바꾼다.
//			
//			// 연장기간
//			//dateOfExtens = returnDate + 7;
//
//		
//	} //extention 끝./
//	
//	

	void showGuide() {
		System.out.println("=====이용안내=====");
		System.out.println();
		System.out.println("대여자료 : 도서 / DVD / 게임");
		System.out.println("대여가능 자료수 : id당 5개");
		System.out.println("대여기간 : 자료당 7일");
		System.out.println();
		System.out.println("연장가능 횟수 : id당 1회");
		System.out.println("연장가능 일수 : 7일");
		System.out.println("연체시 연체일수만큼 대여불가");

	}

} // class end