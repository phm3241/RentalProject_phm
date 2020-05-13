package phm;

public class MainLine {

	public static void main(String[] args) {

		AdminManager adm = AdminManager.getInstance();
		MemberManager mem = new MemberManager();

		while (true) {
			System.out.println("메인메뉴");
			System.out.println("1. 검색/대여 | 2.로그인 | 3.이용안내/회원가입 | 4.내 대여내역(반납/연장) | 5.로그아웃 | 6.관리자페이지 | 7.프로그램 종료");

			int selectNum;
			
			try {
				selectNum = adm.sc.nextInt();
				adm.sc.nextLine();
				
			} catch (Exception e) {
				System.out.println("1~7사이 숫자를 입력해 주세요.");
				adm.sc.nextLine();
				continue;
			}

			switch (selectNum) {

			// 1. 검색/대여-----------------------------
			case 1:
				mem.showInfo();
				break;

			// 2. 로그인-----------------------------
			case 2:
				adm.login();

				break;
			// 3.회원가입/이용안내-----------------------------
			case 3:

				System.out.println("1. 이용안내 | 2.회원가입");
				selectNum = adm.sc.nextInt();
				adm.sc.nextLine();
				switch (selectNum) {
				case 1:
					mem.showGuide();
					break;
				case 2:
					adm.addInfo();
					break;
				}
				break;

			// 4. 내 대여내역-----------------------------
			case 4:
				if (adm.loginCheck()) {
					mem.showMyRentalList();
					mem.returnExtends();
					break;
				} else {
					System.out.println("먼저 로그인 해주세요.");

					continue;
				}

				// 5.로그아웃-----------------------------
			case 5:
				adm.logOut();
				break;

			// 6.관리자페이지-----------------------------
			case 6:
				adm.AdminLogin();
				while (true) {
					System.out.println("1. 회원관리 | 2. 도서관리 | 3. DVD관리 | 4. 게임관리 | 5. 대여내역관리 | 6. 로그아웃");
					selectNum = adm.sc.nextInt();
					switch (selectNum) {
					case 1:
						RentalMenu.memeberView();
						continue;
					case 2:
						RentalMenu.bookView();
						continue;
					case 3:
						RentalMenu.dvdView();
						continue;
					case 4:
						RentalMenu.gameView();
						continue;
					case 5:

						continue;
					case 6:
						break;
					default:
						System.out.println("잘못된 입력입니다.");
						continue;
					}
					break;
				} // while end
				continue;
			case 7:
				System.out.println("프로그램이 종료됩니다.");
				System.exit(0);
			default:
				System.out.println("1~7사이 숫자를 입력해 주세요.");
				continue;

			} // switch end
		} // while end
	} // main end
} // class end
