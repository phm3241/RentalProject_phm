package phm;

import java.time.LocalDateTime;


public class RentManager extends MemberManager {
	
	
	// 메인에서 1번 눌렀을 떄!
	// ㅡ> 도서/DVD/게임 선택 ㅡ> 기본정보출력, 대여 예약 선택 ㅡ> 대여 예약 기능
	public void showInfo() {

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
				System.out.println("1.대여 | 2.예약");
				adm.getBooks().get(index).showAllinfo();
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
				adm.getDvd().get(index).showAllinfo();
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
				adm.getGame().get(index).showAllinfo();
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

				} // switch : case3(Game) : switch end
				break;
			} // switch : case3(Game) : else end

		} // switch end
	} // showInfo() end

//	■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	// rentalList에 인스턴스 추가
	public void addRental(RentalList info) {
		rentalList.add(info);

	}

//	■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	// rentalList 인스턴스 생성
	public void creatRentalList() {

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
	// 선택한 자료의 타입을 확인하고 카운트변경 (대여횟수, 재고수, 재고수확인후 대여불가처리)
	public void itemRentalCount() {

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
	// 예약
	public void reserve() {

		
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
		
		
		
		
		
		
//		RentalItemInfo itemIndex=checkTypeIndex();
//		
//		// if 자료의 재고가 있으면, 대여하라고 안내출력
//		if (itemIndex.numOfItem>0) { // 재고있으면,
//			System.out.println("선택하신 자료의 재고가 있어 대여가 가능합니다. 대여를 진행해주세요.");
//		}
//
//		// else if 만약에 자료의 재고가 없으면, 예약가능 
//		// 예약가능절차. 선택한 타이틀(this.title)을 rentalList에서 찾고, 
//		// 그 중 가장 반납예정일이 빠른 인덱스에 예약자: 로그인한 id 추가, 예약일 : 반납예정일+1 추가
//		else if (itemIndex.numOfItem==0) {  // 재고없음이면,
//
//			// 예약할 때 받을 정보 ㅡ> 로그인한 회원 Id, 대여할 자료명
//			int index = adm.loginCheckIndex();
//			String reservId = adm.getMember().get(index).getId(); // 로그인한 id
//			
//			// rentalList에서 해당 타이틀의 반납일이 가장 빠른 인덱스 찾고
//			LocalDate today=LocalDate.now();
//			for(int i=0; i<rentalList.size(); i++) {
//				if(searchRentalIndexTitle(this.title);
//				
//				System.out.println(title + "이(가) " + reservDate + "일자로 예약 되었습니다.");
//				System.out.println(rentalAvailDate + " 부터 대여 가능합니다.");
//			
//			
//			//예약자와 예약일 추가
//			rentalList.get(index).returnDate=returnDate;
////			rentalList.get(index).rentInfo="반납완료";
//			
//			
//
//				
//
//		} 
//		
//		// else if 예약불가 상황. 만약에 선택한 타이틀에 예약자가 있으면, 예약불가.
//		
//
//	} 
//
//	
		
		
	} // reserve() end

	@Override
	public void showGuide() {
		super.showGuide();
	}

}
