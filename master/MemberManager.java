package master;

import java.time.LocalDate;
import java.util.ArrayList;

import data.UserList;
import data.UserList10;
import data.UserList11;
import data.UserList12;
import data.UserList13;
import data.UserList14;
import data.UserList15;
import data.UserList16;
import data.UserList2;
import data.UserList3;
import data.UserList4;
import data.UserList5;
import data.UserList6;
import data.UserList7;
import data.UserList8;
import data.UserList9;

public class MemberManager {

	String title = null; // 자료명
	private ArrayList<RentalList> rentalList;

	// 회원리스트, 자료리스트 불러오기
	AdminManager adm = AdminManager.getInstance();

	// 기본생성자, 대여리스트 생성
	public MemberManager() {
		rentalList = new ArrayList<>();

		// 대여리스트 항목 추가
		UserList uList = new UserList();
		UserList2 uList2 = new UserList2();
		UserList3 uList3 = new UserList3();
		UserList4 uList4 = new UserList4();
		UserList5 uList5 = new UserList5();
		UserList6 uList6 = new UserList6();
		UserList7 uList7 = new UserList7();
		UserList8 uList8 = new UserList8();
		UserList9 uList9 = new UserList9();
		UserList10 uList10 = new UserList10();
		UserList11 uList11 = new UserList11();
		UserList12 uList12 = new UserList12();
		UserList13 uList13 = new UserList13();
		UserList14 uList14 = new UserList14();
		UserList15 uList15 = new UserList15();
		UserList16 uList16 = new UserList16();

		this.rentalList.add(uList);
		this.rentalList.add(uList2);
		this.rentalList.add(uList3);
		this.rentalList.add(uList4);
		this.rentalList.add(uList5);
		this.rentalList.add(uList6);
		this.rentalList.add(uList7);
		this.rentalList.add(uList8);
		this.rentalList.add(uList9);
		this.rentalList.add(uList10);
		this.rentalList.add(uList11);
		this.rentalList.add(uList12);
		this.rentalList.add(uList13);
		this.rentalList.add(uList14);
		this.rentalList.add(uList15);
		this.rentalList.add(uList16);

	}

//	■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	// 메인메뉴 1 : 검색/ 대여
	// ㅡ> 도서/DVD/게임 선택 ㅡ> 선택된 자료전체의 기본정보 자동출력 ㅡ> 자료명 선택 ㅡ> 선택한 자료명 상세정보출력 ㅡ> 대여/
	// 예약기능
	void searchItemInfo() {
		int selectNum;

		while (true) {

			System.out.println("1.도서 | 2.DVD | 3. 게임");
			System.out.println("검색하고자 하는 자료의 번호를 입력해주세요.");

			try {

				selectNum = adm.sc.nextInt();
				adm.sc.nextLine();

			} catch (Exception e) { // 생각치 못한 오류발생이 있을 수 있기 때문에.
				System.out.println("잘못된 메뉴입력입니다. \n 확인하시고 다시 입력해주세요");
				adm.sc.nextLine();
				continue;
			}

			switch (selectNum) {
			case 1: // Book 선택시
				System.out.println(
						"===================================================================================================");
				adm.showBookBasic();
				System.out.println();

				System.out.println("찾으시는 도서명을 입력해주세요.");
				this.title = adm.sc.nextLine();

				int index = adm.searchBookInfo(title);

				if (index < 0) {
					System.out.println("검색하신 자료의 정보가 없습니다.");
					continue;
				} else {
					System.out.println(
							"===================================================================================================");

					adm.getBooks().get(index).showAllinfo();

					while (true) {
						System.out.println("1.대여 | 2.예약  | 3.뒤로가기  | 4.메인화면 ");

						try {
							selectNum = adm.sc.nextInt();
							adm.sc.nextLine();
						} catch (Exception e) {
							System.out.println("잘못된 메뉴입력입니다. \n 확인하시고 다시 입력해주세요");
							adm.sc.nextLine();
							continue;
						}

						switch (selectNum) {

						case 1: // 대여
								// 로그인 상태일시 대여메서드 실행
							if (adm.loginCheck()) {
								creatRentalList();
								break;
							} else {
								// 비로그인 시
								System.out.println();
								System.out.println("이용하시려면 로그인을 해 주세요.");
								adm.login();
								creatRentalList();
								break;
							}

						case 2: // 예약
							/* 예약 메서드 */
							break;

						case 3: // 뒤로가기
							searchItemInfo();
							break;

						case 4: // 메인화면
							return;

						default:
							System.out.println("메뉴의 숫자를 입력해주세요.");
							continue;
						} // switch : case1(Book) : switch end

						break;
					} // while end
					break;

				} // switch : case1(Book) : else end

			case 2: // DVD 선택시
				System.out.println(
						"===================================================================================================");
				adm.showDvdBasic();

				System.out.println("찾으시는 DVD명을 입력해주세요.");
				this.title = adm.sc.nextLine();

				index = adm.searchDvdInfo(title);

				if (index < 0) {
					System.out.println("검색하신 자료의 정보가 없습니다.");
					continue;
				} else {

					System.out.println(
							"===================================================================================================");
					adm.getDvd().get(index).showAllinfo();

					while (true) {
						System.out.println("1.대여 | 2.예약  | 3.뒤로가기  | 4.메인화면 ");
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

						case 3: // 뒤로가기
							searchItemInfo();
							break;

						case 4: // 메인화면
							return;

						default:
							System.out.println("메뉴의 숫자를 입력해주세요.");
							continue;
						} // switch : case1(Book) : switch end

						break;
					} // while end
					break;

				} // switch : case1(Book) : else end

			case 3: // Game 선택시
				System.out.println(
						"===================================================================================================");
				adm.showGameBasic();

				System.out.println("찾으시는 Game명을 입력해주세요.");
				this.title = adm.sc.nextLine();

				index = adm.searchGameInfo(title);

				if (index < 0) {
					System.out.println("검색하신 자료의 정보가 없습니다.");
					continue;
				} else {
					System.out.println(
							"===================================================================================================");
					adm.getGame().get(index).showAllinfo();

					while (true) {
						System.out.println("1.대여 | 2.예약  | 3.뒤로가기  | 4.메인화면");
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

						case 3: // 뒤로가기
							searchItemInfo();
							break;

						case 4: // 메인화면
							return;
						default:
							System.out.println("메뉴의 숫자를 입력해주세요.");
							continue;
						} // switch : case1(Book) : switch end

						break;
					} // while end
					break;

				} // switch : case1(Book) : else end
			default:
				System.out.println("메뉴의 숫자를 입력해주세요.");
				continue;

			} // switch end
			break;
		} // while end

	} // showInfo() end

//	■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	// 로그인한 id의 정보를 반환하는 메서드
	Member getloginIdInfo() {

		// 로그인한 회원 Id의 인덱스 찾고,
		int index = adm.loginCheckIndex();

		// 그 회원의 정보 반환
		Member loginIdInfo = null;
		loginIdInfo = adm.getMember().get(index);

		return loginIdInfo;
	}

//	■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	// rentalList에 인스턴스 추가
	void addRental(RentalList info) {
		rentalList.add(info);

	}

// ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
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
			loginIdInfo.numOfRent += 1; // 회원정보 : 대여자료수 +1
			loginIdInfo.rentalAvail -= 1; // 회원정보 : 대여가능 자료수 +1

			// 대여일 생성
			LocalDate rentalDate = LocalDate.now();
			String start = rentalDate.toString();

			// 반납일 생성 : 대여일+7일
			LocalDate returnDate = rentalDate.plusDays(7);
			String end = returnDate.toString();

			// MemberManager 객체 생성
			info = new RentalList(id, title, start, end);

			// MemberManager 객체 ㅡ> 대여리스트에 추가 메서드 1-1. 호출.
			addRental(info);
			System.out.println(id + "님  < " + title + " > 자료가 대여완료 되었습니다. ");
			System.out.println("대여일 : " + start + " | 반납예정일 : " + end);
			return;

		} // else end

	} // creatRentalList() end

// ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
	// 선택한 자료의 타입을 확인하고 카운트변경 (대여횟수, 재고수, 재고수확인후 대여불가처리)
	void itemRentalCount() {

		int index = 0;

		// 입력받은 title이 Book일때!
		if (adm.searchBookInfo(this.title) >= 0) {

			// 재고가 있으면, 재고수 -1, 대여횟수 +1
			if (adm.getBooks().get(index).numOfItem > 0) {
				index = adm.searchBookInfo(this.title);
				adm.getBooks().get(index).numOfItem -= 1;
				adm.getBooks().get(index).rentalCount += 1;

				// 대여불가여부 확인 : 자료의 재고가 0일때 ㅡ> 자료 예약안내
			} else if (adm.getBooks().get(index).numOfItem == 0) {
				System.out.println("선택하신 자료가 현재 모두 대여중입니다.");
				System.out.println("(...대여예약 기능을 준비중입니다...)");
				searchItemInfo();
			}

			// 입력받은 title이 Dvd일때!
		} else if (adm.searchDvdInfo(this.title) >= 0) {

			// 재고가 있으면, 재고수 -1, 대여횟수 +1
			if (adm.getDvd().get(index).numOfItem > 0) {
				index = adm.searchDvdInfo(this.title);
				adm.getDvd().get(index).numOfItem -= 1;
				adm.getDvd().get(index).rentalCount += 1;

				// 대여불가여부 확인 : 자료의 재고가 0일때 ㅡ> 자료 예약안내
			} else if (adm.getDvd().get(index).numOfItem == 0) {
				System.out.println("선택하신 자료가 현재 모두 대여중입니다.");
				System.out.println("(...대여예약 기능을 준비중입니다...)");
				searchItemInfo();
			}

			// 입력받은 title이 Game일때!
		} else if (adm.searchGameInfo(this.title) >= 0) {

			// 재고가 있으면, 재고수 -1, 대여횟수 +1
			if (adm.getGame().get(index).numOfItem > 0) {
				index = adm.searchGameInfo(this.title);
				adm.getGame().get(index).numOfItem -= 1;
				adm.getGame().get(index).rentalCount += 1;

				// 대여불가여부 확인 : 자료의 재고가 0일때 ㅡ> 자료 예약안내
			} else if (adm.getGame().get(index).numOfItem == 0) {
				System.out.println("선택하신 자료가 현재 모두 대여중입니다.");
				System.out.println("(...대여예약 기능을 준비중입니다...)");
				searchItemInfo();
			}
		}
	}

// ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
	// 예약
	void reserve() {

//		int index = 0;
//		Member loginIdInfo = getloginIdInfo();
//		String reservId = getloginIdInfo().getId();
//
//		// 예약일 = 현재날짜로 생성
//		LocalDate reservDate0 = LocalDate.parse(rentalList.get(index).returnLimit).plusDays(1);
//		String reservDate = reservDate0.toString();
//		System.out.println("예약일 (반납일 다음날) : " + reservDate);
//		
//		// 입력받은 title이 Book일때!
//		if (adm.searchBookInfo(this.title) >= 0) {
//
//			// 재고가 있으면,
//			if (adm.getBooks().get(index).numOfItem > 0) {
//				System.out.println("선택하신 자료는 재고가 있어 대여가 가능합니다. 대여를 진행해주세요.");
//
//			// 재고가 없으면 예약진행
//			// 예약가능절차. 선택한 타이틀(this.title)을 rentalList에서 찾고,
//			// 그 중 가장 반납예정일이 빠른 인덱스에 예약자: 로그인한 id 추가, 예약일 : 반납예정일+1 추가
//			} else if (adm.getBooks().get(index).numOfItem == 0) {
//				// 대여리스트 중 해당 인덱스의 예약일, 예약자가 변경됨.
//				rentalList.get(index).reservDate = reservDate;
//				rentalList.get(index).reservId = reservId;
//
//				// 대여리스트 중 해당 인덱스 출력. 확인.
//				rentalList.get(index).showRentalListInfo();
//				
//				// 오늘날짜
//				LocalDate today=LocalDate.now();   // 기준이 되는 오늘날짜
//				int between=0;
//				int beforeBetween=0;
//				
//				int searchRentalIndex = -1;
//				
//				// rentalList에서 자료명과 일치하는 인덱스 모두 찾기
//				for (int i = 0; i < rentalList.size(); i++) {	
//					if (rentalList.get(i).title.equals(title)) {
//						searchRentalIndex = i;
//						
//						LocalDate returnDate=LocalDate.parse(rentalList.get(i).returnDate);
//						
//						// 인덱스의 반납일을 오늘날짜와 비교하여 차이계산
//						Period period = Period.between(today, returnDate);
//						between=period.getDays();
//
//						// 가장 차이가 적은 인덱스 선택
//						if(between>beforeBetween);
//
//					}
//					System.out.println(title + "이(가) 예약 되었습니다.");
//					System.out.println(reservDate + " 부터 대여 가능합니다.");
//					}
//				
//
//			} // else end
//		} // if book..end

		//
	} // reserve() end

//	■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	// 메인메뉴 4 : 내 대여내역/ 반납 연장
	// ㅡ> 내 대여내역 자동출력, 반납 연장 선택 ㅡ> 반납. 연장 기능
	void returnExtends() {

		// 내 대여내역 자동출력
		showMyRentalList();

		// 만약에 대여중인 자료가 없으면, 반납이나 연장 출력X
		Member loginIdInfo = getloginIdInfo();
		if (loginIdInfo.numOfRent == 0) {
			System.out.println("현재 대여중인 자료가 없습니다.");
			return;

		} else {

			// 검색입력 받은 타이틀이 있는 rentalList의 인덱스
			String title = null;
			int index = 0;
			int selectNum = 0;

			while (true) {
				// 내 대여내역에서 반납하거나 연장할 자료를 검색입력
				System.out.println("반납이나 연장하실 자료명을 입력해주세요.");

				try {
					title = adm.sc.nextLine();
					index = checkTitle(title);
					if (checkTitle(title) < 0) {
						// 강제예외발생 : 자료명 검색이 잘 못되었을때,
						BadTitleInputException e = new BadTitleInputException("일치하는 자료명이 없습니다.");
						throw e;
					}

				} catch (BadTitleInputException e) { // 생각치 못한 오류발생이 있을 수 있기 때문에.
					System.out.println("일치하는 자료명이 없습니다. \n 확인하시고 다시 입력해주세요");
					continue;
				} catch (Exception e) { // 생각치 못한 오류발생이 있을 수 있기 때문에.
					System.out.println("잘못된 메뉴입력입니다. \n 확인하시고 다시 입력해주세요");
					continue;
				}
				break;
			} // while end

			while (true) {
				// 반납 연장 기능선택
				System.out.println("1. 반납 | 2.연장 | 3.메인화면");

				try {
					selectNum = adm.sc.nextInt();
					adm.sc.nextLine();

				} catch (Exception e) { // 생각치 못한 오류발생이 있을 수 있기 때문에.
					System.out.println("잘못된 메뉴입력입니다. \n 확인하시고 다시 입력해주세요");
					adm.sc.nextLine();
					continue;
				}

				// 선택한 기능 실행
				switch (selectNum) {
				case 1: // 반납 선택시
					itemReturn(index);
					System.out.println("");
					continue;

				case 2: // 연장 선택시
					extention(index);
					continue;

				case 3: // 메인화면
					break;
					
				default:
					System.out.println("메뉴의 숫자를 입력해주세요.");
					continue;
				} // switch end
				break;
			} // while end
		} // else end

	} // returnExtends() end

//	■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	// 반납
	void itemReturn(int index) {

		// 만약에 대여내역에 같은 자료명이 한개 이상일 때, 
		// 
		// 반납일이 null이고, 
		
		// 반납일 = 현재날짜로 생성
		LocalDate today = LocalDate.now();
		String returnDate = today.toString();

		// 나의 대여리스트 중 해당 인덱스의 반납일이 변경됨.
		rentalList.get(index).returnDate = returnDate;
		rentalList.get(index).rentInfo = "반납완료";

		// 나의 대여리스트 중 해당 인덱스 출력. 확인.
		rentalList.get(index).showRentalListInfo();

		// 회원 카운트 변경 : 로그인한 아이디로 회원정보 받아서 카운트 변경
		Member loginIdInfo = getloginIdInfo();
		loginIdInfo.numOfRent -= 1; // 회원정보 : 대여한 자료수 -1
		loginIdInfo.rentalAvail += 1; // 회원정보 : 대여가능 자료수 +1

		// 자료 카운트 변경 : 반납했으니 다시 재고 +1
		int itemIndex = 0;

		// 자료가 책이면,
		if (adm.searchBookInfo(this.title) >= 0) {
			itemIndex = adm.searchBookInfo(this.title);
			adm.getBooks().get(itemIndex).numOfItem += 1;

			// 자료가 DVD면,
		} else if (adm.searchDvdInfo(this.title) >= 0) {
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

// ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
	// 연장.
	void extention(int index) {

		Member loginIdInfo = getloginIdInfo();
		System.out.println(rentalList.get(index).reservId);

		// 만약에 내 연장횟수가 0이면, 연장불가
		if (loginIdInfo.numOfExtens == 0) {
			System.out.println("연장가능 횟수가 0입니다.");

			// 만약에 연장하려는 내 대여내역에 예약자가 있으면, 연장불가.
		} else if (rentalList.get(index).reservId != " ") {
			System.out.println("예약자가 있어 연장할 수 없습니다. ");

			// 연체가 있으면, 연장불가
		} else if (loginIdInfo.overdue > 0) {
			System.out.println("대여하신 자료 중 연체가 있어 연장을 할 수 없습니다.");

			// 연장이 되면ㅡ> 연장된 반납일 생성. 카운트 변경
		} else {
			// 연장된 반납일 생성 : 나의 대여리스트 중 해당 인덱스의 반납예정일 + 7
			LocalDate returnLimit0 = LocalDate.parse(rentalList.get(index).returnLimit);
			LocalDate extendDate1 = returnLimit0.plusDays(7);
			String extendDate = extendDate1.toString();

			// 나의 대여리스트 중 해당 인덱스의 연장된 반납일 ㅡ > 연장된 반납일로 수정
			rentalList.get(index).extendDate = extendDate;
			rentalList.get(index).rentInfo = "연장완료";

			// 회원 카운트 변경 : 로그인한 아이디로 회원정보 받아서 카운트 변경
			loginIdInfo.numOfExtens -= 1; // 회원정보 : 연장가능 횟수 -1

			// 나의 대여리스트 중 해당 인덱스 출력. 확인.
			System.out.println(
					"--------------------------------------------------------------------------------------------------");
			rentalList.get(index).showRentalListInfo();
		}
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
//	} //extention 끝./
//	
//	
//	■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	// RentalList 전체 출력
	public void showAllRentalListInfo() {
		for (int i = 0; i < rentalList.size(); i++) {
			rentalList.get(i).showRentalListInfo();
			System.out.println(
					"----------------------------------------------------------------------------------------------------");
		}
	}

// ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
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

// ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
	// 나의 rentalList 에서 title로 검색하기(내 대여내역) ㅡ> 인덱스 반환
	int checkTitle(String title) {

		String id = getloginIdInfo().getId();

		int index2 = -1;
		for (int i = 0; i < rentalList.size(); i++) {
			if (rentalList.get(i).id.equals(id) && rentalList.get(i).title.equals(title)) {
				index2 = i;
				break;
			}
		}
		return index2;
	}

// ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
	// rentalList 에서 id로 검색하기(내 대여내역) ㅡ> 인덱스 반환
	void showMyRentalList() {
		Member loginIdInfo = getloginIdInfo();
		String id = getloginIdInfo().getId();

		System.out.println("나의 대여 내역 ");
		System.out.println("대여중인 자료수 : " + loginIdInfo.numOfRent + " | 대여가능 자료수 : " + loginIdInfo.rentalAvail
				+ " | 연장가능 횟수 : " + loginIdInfo.numOfExtens + " | 연체일수 : " + loginIdInfo.overdue);
		System.out.println(
				"==================================================================================================");

		for (int i = 0; i < rentalList.size(); i++) {
			if (rentalList.get(i).id.equals(id)) {

				rentalList.get(i).showRentalListInfo();
			}
		}
	}

// ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
	// rentalList 에서 id로 검색하기(관리자사용) ㅡ> 대여내역 출력
	void showIDRentalList() {

		System.out.println("찾아보실 회원id을 입력해주세요.");
		String id = adm.sc.nextLine();

		for (int i = 0; i < rentalList.size(); i++) {
			if (rentalList.get(i).id.equals(id)) {

				rentalList.get(i).showRentalListInfo();
			}
		}
	}

// ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
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

// ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
	// 이용안내
	void showGuide() {
		System.out.println("====================\t\t이\t용\t안\t내\t\t========================");
		System.out.println();
		System.out.println("1. 비회원은 대여 검색을 하여 대여 가능한 목록을 볼수 있으며, 대여 하기위해서는 회원가입을 해야지만 대여 가능합니다.");
		System.out.println("2. 회원가입은 이름, 나이, 전화번호, 주소, 이메일 그리고 아이디와 패스워드 입력을 통해서 회원가입이 합니다.");
		System.out.println("3. 회원가입이 완료 되었으면 로그인을 하고 도서, DVD, 게임 중 목록을 보고 선택하여 대여를 할수 있습니다.");
		System.out.println("4. 개인회원은 도서, DVD, 게임 품목은 기본정보와 대여가능횟수, 관심수, 재고, 반납예정일을 화면상에서 확인 할수 있습니다.");
		System.out.println();
		System.out.println();
		System.out.println("대여자료 : 도서 / DVD / 게임");
		System.out.println("대여가능 자료수 : id당 5개");
		System.out.println("대여기간 : 자료당 7일");
		System.out.println();
		System.out.println("연장가능 횟수 : id당 1회");
		System.out.println("연장가능 일수 : 7일");
		System.out.println("연체시 연체일수만큼 대여불가");

		System.out.println(
				"==================================================================================================");

	}
} // class end
