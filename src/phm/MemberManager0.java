package phm;

import java.util.ArrayList;

import Manager.ItemManager;

public class MemberManager0 {

	String title = null; // 자료명
//	String rentalDate=null; 	// 대여일#
//	String returnDate=null;		// 반납일#
	public ArrayList<RentalList> rentalList;

	// 회원리스트, 자료리스트 불러오기
	public ItemManager adm = ItemManager.getInstance();

	// 기본생성자, 대여리스트 생성
	public MemberManager0() {
		rentalList = new ArrayList<>();
	}
	
		
//	■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	// 선택한 자료의 타입을 확인하고 아이템인덱스 반환
	RentalItemInfo checkTypeIndex() {

		int index = 0;
		RentalItemInfo itemIndex = null;

		if (adm.searchBookInfo(this.title) >= 0) {
			index = adm.searchBookInfo(this.title);
			itemIndex = adm.getBooks().get(index);
			return itemIndex;

		} else if (adm.searchDvdInfo(this.title) >= 0) {
			index = adm.searchDvdInfo(this.title);
			itemIndex = adm.getDvd().get(index);
			return itemIndex;

		} else if (adm.searchGameInfo(this.title) >= 0) {
			index = adm.searchGameInfo(this.title);
			itemIndex = adm.getGame().get(index);
			return itemIndex;
		}
		return itemIndex;
	}

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
	protected int checkTitle(String title) {

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
	protected void showMyRentalList() {

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
	
	
	
	
	
} //class end
