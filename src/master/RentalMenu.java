package master;


public class RentalMenu {
	
	public static AdminManager adm = AdminManager.getInstance();
	static MemberManager mem = new MemberManager();
	
	
	//6-1 관리자 페이지-회원관리
	public static void memeberView() {

		while(true) {
        System.out.println("회원관리페이지입니다.");
        System.out.println("1.회원 상세정보 | 2.회원정보 수정 | 3.회원정보 삭제 | 4. 뒤로가기");
        
        int selectNum;
		try {
			selectNum = adm.sc.nextInt();
			adm.sc.nextLine();
		} catch (Exception e) {
			System.out.println("잘못된 입력입니다.\n1~4사이의 숫자를 입력해주세요.");
			adm.sc.nextLine();
			continue;
		}
        switch (selectNum){

            case 1:
                adm.showInfo();
                break;
            case 2:
                adm.editInfo();
                break;
            case 3:
                adm.deleteInfo();
                break;
            case 4:
            	break;
            	default:
            		System.out.println("잘못된 입력입니다.\n1~4사이의 숫자를 입력해주세요.");
            		continue;
        }
        break;
		}
    }
	//6-2 관리자페이지-도서관리
	public static void bookView() {
		
		while(true) {
		System.out.println("도서관리 페이지 입니다.");
		adm.showBookInfo();
		System.out.println("1. 도서 추가 | 2. 도서수정 | 3. 도서삭제 | 4. 뒤로가기");
		
		int selectNum;
		try {
			selectNum = adm.sc.nextInt();
			adm.sc.nextLine();
		} catch (Exception e) {
			System.out.println("잘못된 입력입니다.\n1~4사이의 숫자를 입력해주세요");
			adm.sc.nextLine();
			continue;
		}
		switch(selectNum) {
		
		
			case 1:
				adm.createBookInfo();
				continue;
			case 2:
				adm.editBookInfo();
				continue;
			case 3:
				adm.deleteBookInfo();
				continue;	
			case 4:
				break;
			default:
				System.out.println("잘못된 입력입니다.\n1~4사이의 숫자를 입력해주세요");
				continue;
								
			}
		break;
		}
}
	
	//6-3 관리자페이지-DVD관리
		public static void dvdView() {
			while (true) {
			
			System.out.println("DVD관리 페이지 입니다.");
			adm.showDvdInfo();
			System.out.println("1. DVD추가 | 2. DVD수정 | 3. DVD삭제 | 4. 뒤로가기");
			
			int selectNum;
			try {
				selectNum = adm.sc.nextInt();
				adm.sc.nextLine();
			} catch (Exception e) {
				System.out.println("잘못된 입력입니다.\n1~4사이의 숫자를 입력해주세요");
				adm.sc.nextLine();
				continue;
			}
			switch(selectNum) {
			case 1:
				adm.createDvdInfo();
				continue;
			case 2:
				adm.editDvdInfo();
				continue;
			case 3:
				adm.deleteDvdInfo();
				continue;
			case 4:
				
				break;
				default:
					System.out.println("잘못된 입력입니다.\n1~4사이의 숫자를 입력해주세요");
					continue;
					
			}
			break;
		}
		}
		
		//6-4 관리자페이지-게임관리
		public static void gameView() {
			
			while(true) {
			System.out.println("게임관리 페이지 입니다.");
			adm.showGameInfo();
			System.out.println("1. 게임추가| 2. 게임수정| 3. 게임삭제 |4. 뒤로가기");
			
			int selectNum;
			try {
				selectNum = adm.sc.nextInt();
				adm.sc.nextLine();
			} catch (Exception e) {
				System.out.println("잘못된 입력입니다.\n1~4사이의 숫자를 입력해주세요");
				adm.sc.nextLine();
				continue;
			}
			switch(selectNum) {
			
			case 1:
				adm.CreateGameInfo();
				continue;
			case 2:
				adm.editGameInfo();
				continue;
			case 3:
				adm.deleteGameInfo();
				continue;
			case 4:
				
				break;
			default:
				System.out.println("잘못된 입력입니다.\n1~4사이의 숫자를 입력해주세요");
				continue;	
			}
			break;
		}
	}
		
		//6-4 관리자페이지-대여내역관리
		public static void rentalListView() {
			
			while(true) {
			System.out.println("대여내역관리 페이지 입니다.");
			System.out.println("1. 전체 대여내역보기 | 2. 회원 id로 대여내역보기  | 3. 자료명으로 대여내역보기 | 4. 뒤로가기 ");
			
			
			int selectNum;
			try {
				selectNum = adm.sc.nextInt();
				adm.sc.nextLine();
			} catch (Exception e) {
				System.out.println("잘못된 입력입니다.\n1~4사이의 숫자를 입력해주세요");
				adm.sc.nextLine();
				continue;
			}
			switch(selectNum) {
			
			case 1:
				mem.showAllRentalListInfo();
				break;
			case 2:
				mem.showIDRentalList();
				break;
			case 3:
				mem.showTitleRentalList();
				break;
			case 4:
				break;
			default:
				System.out.println("잘못된 입력입니다.\n1~4사이의 숫자를 입력해주세요");
				continue;
				
			}
			break;
		}
	}
}
	
	
