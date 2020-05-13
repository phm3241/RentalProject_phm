package phm;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class ReturnExtends extends MemberManager0 {

	// 메인에서 4번 눌렀을 떄!
	// ㅡ> 내 대여내역 자동출력, 반납 연장 선택 ㅡ> 반납. 연장 기능
	void returnExtends() {

		// 내 대여내역 자동출력
		showMyRentalList();

		// 내 대여내역에서 반납하거나 연장할 자료를 검색입력
		System.out.println("반납이나 연장하실 자료명을 입력해주세요.");
		String title = adm.sc.nextLine();

		// 검색입력 받은 타이틀이 있는 rentalList의 인덱스
		int index = checkTitle(title);
//			rentalList.get(index).showRentalListInfo();  // 확인용. 선택한 타이틀이 있는 나의 대여내역 출력 

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
//			extention(index);
			break;
		}

	}

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
		
		// 자료 카운트 변경
		RentalItemInfo itemIndex=checkTypeIndex();
		itemIndex.numOfItem += 1; // 자료정보 : 재고 += numOfItem
		
		// 회원 카운트 변경
		Member loginIdInfo =getloginIdInfo();
		loginIdInfo.numOfRent -= 1;
		loginIdInfo.rentalAvail += 1;
		
		
//	■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	// 연체확인
//	void checkoverdue() {		
		

//		 System.out.println(gap+"일");
//
//		        if( gap > 7) {	 // 연체.
//					
//					
//		        	adm.getMember().get(adm.loginCheckIndex()).rentalAvail = 0;		// 대여가능권수
//		        	adm.getMember().get(adm.loginCheckIndex()).numOfExtens = 0;		// 연장가능횟수
//					//numOfRent = ??		// 대여권수, 빌려간게 더 있을수도 있고 없을수도있고.	??
//				
//					System.out.println(title + "연체일수가 있습니다.");
//					System.out.println(title + "연체일수는 " + gap + " 입니다.");
//					System.out.println(overdue + "일 동안 자료를 대여하실 수 없습니다.");
//					System.out.println("처리 : " + today);	
//				}else if(gap < 7) {	// 연체 없음.
//					
//					returnDate = today;						
//						
//					System.out.println(title+"자료가 정상적으로 반납되었습니다.");
//					System.out.println("처리 : " + today);	
//					
//					adm.getMember().get(adm.loginCheckIndex()).numOfRent --;			// 대여권수
//					adm.getMember().get(adm.loginCheckIndex()).rentalAvail ++;		// 대여가능권수
//					adm.getMember().get(adm.loginCheckIndex()).numOfExtens = 1;		// 연장가능횟수
//					
//				}
//				
//				// 대여가능으로 바꾼다.
//				rentalList.get(index).title
//				rentInfo = "대여가능";

			

//	} // itemReturn(index) end

//	■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	// 연장.
//	void extention(int index) {
//
//		// 만약에 연장하려는 내 대여내역에 예약자가 있으면, 연장불가.
//		// 만약에 내 연장횟수가 0이면, 연장불가
//
//		// 연장된 반납일 생성 : 나의 대여리스트 중 해당 인덱스의 반납예정일 + 7
//		LocalDateTime returnLimit0 = LocalDateTime.parse(rentalList.get(index).returnLimit);
//		LocalDateTime extendDate1 = returnLimit0.plusDays(7);
//		String extendDate = extendDate1.toString();
//
//		// 나의 대여리스트 중 해당 인덱스의 연장된 반납일 ㅡ > 연장된 반납일로 수정
//		rentalList.get(index).extendDate = extendDate;
//		rentalList.get(index).rentInfo = "연장완료";
//
//		// 나의 대여리스트 중 해당 인덱스 출력. 확인.
//		rentalList.get(index).showRentalListInfo();
//	}

//				
//		        
//		        long gap = startDate1.getTime() - endDate1.getTime() / (24*60*60*1000);
//	            gap = Math.abs(gap);
//		        
//		        if((int)gap > 7) { //연체 있을때.
//					System.out.println(title + "연체일수가 " + gap + " 일 입니다.");
//					System.out.println(gap + " 기간동안 연장하실 수 없습니다.");
//					System.out.println("처리 : " + today);
//					
//					adm.getMember().get(adm.loginCheckIndex()).rentalAvail = 0;		// 대여가능권수
//					adm.getMember().get(adm.loginCheckIndex()).numOfExtens = 0;		// 연장가능횟수
//					
//				}else if((int)gap < 7) {	// 연체 없을때
//					
//				    returnDate = format.format(cal.getTime());
//					cal.add(Calendar.DATE, 7);
//					String extenDate = format.format(cal.getTime());
//					
	//
//					System.out.println(title + "자료가 정상적으로 7일 연장되었습니다.");
//					System.out.println(returnDate + " 까지 반납하세요.");
//					System.out.println("처리 : " + today);
//					
//					//admManager.getMember().get(admManager.loginCheckIndex()).numOfRent ??? 			// 대여권수, 빌렸던 책이니까 유지	???
//					//admManager.getMember().get(admManager.loginCheckIndex()).rentalAvail ???			// 대여가능권수, ???
//					adm.getMember().get(adm.loginCheckIndex()).numOfExtens = 0;		// 연장가능횟수, 연장을 썼으니까 0으로 바꿔준다.
//				
//					
//				}
//			}
////				rentInfo = "대여중";		// 대여상태 대여중으로 바꾼다.
//				
//				// 연장기간
//				//dateOfExtens = returnDate + 7;
	//
//			
//		} //extention 끝.
	//
	//

} // class end

}
