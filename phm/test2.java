package phm;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class test2 {

	public static void main(String[] args) {
//		문법!
//		// 로컬 컴퓨터의 현재 날짜 정보를 저장한 LocalDate 객체를 리턴
//		LocalDate currentDate = LocalDate.now();
//		// result : 2019-11-13
//
//		// 파라미터로 주어진 날짜 정보를 저장한 LocalDate 객체를 리턴한다.
//		LocalDate targetDate = LocalDate.of(2019,11,12);
//		 //결과 : 2019-11-12
		
//		날짜 차이구하기!
//		LocalDate startDate = LocalDate.now(); 
//		// 결과 : 2019-11-12
//		LocalDate endDate = LocalDate.of(2019,12,13);
//		// 결과 : 2019-12-13
//		ChronoUnit.DAYS.between(startDate, endDate); 
//		// 결과 : 31 (1개월 1일)
		
//		문법! String -> LocalDate
//		LocalDate re=LocalDate.parse("2002-05-09");
		
//		문법! LocalDate -> String
//		LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		
		
		
		
		// 현재날짜
		LocalDate currentDate = LocalDate.now();
		System.out.println("currentDate :"+currentDate);
		
		// 현재날짜 : 	LocalDateTime -> String ... String으로 바꿔서 저장해보기..
		String currentString=LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss"));
		System.out.println("currentString : "+currentString);
		
		
		// String으로 바꾸고 int로 타입바꿔서 저장해보기..
		// int로 바꾸기 전에 날짜형식의 -하으픈 빼기..
		String currentString2=currentString.replace("-", "");
		System.out.println("currentString2 : "+currentString2);
		
		// int로 바꿔보기.. 방법1. valueOf.. 오류로 변환안됨..
		int currentInt1=Integer.valueOf(currentString2);
		System.out.println("currentInt : "+currentInt1);

		// int로 바꿔보기.. 방법2. Integer.parseInt(String).. 오류로 변환안됨..
		Integer currentInt2 = Integer.parseInt(currentString2);
		System.out.println("currentInt : "+currentInt2);

		
		LocalDate myDate = LocalDate.of(2020,5,5); //년,월,일
		System.out.println("myDate:"+myDate);
		
		// 문법 ! 반납일은 대여일 +7
		LocalDate returnDate=currentDate.plusDays(7);
		System.out.println("returnDate:"+returnDate);

		
		
//		 ========아래는 Calendar랑 Date 클래스로 해본건데..복잡해서 위에 있는 LocalDate써서 해보려는중==== 

		
		
		SimpleDateFormat format= new SimpleDateFormat ("yyyy/ MM/ dd/ HH.mm.ss");
		Calendar cal = Calendar.getInstance();
		String currentTime = format.format(cal.getTime());
		System.out.println("currentTime : "+currentTime);   // 일반 포멧으로 출력.

		// 반납일 : 대여일+7일
		cal.add(Calendar.DATE,7);
		String returnDate2=format.format(cal.getTime());
		System.out.println("returnDate2 : "+returnDate2);

		Calendar cal2 = Calendar.getInstance();
		String currentTime2 = format.format(cal2.getTime());
		System.out.println("currentTime2 : "+currentTime2);   // 일반 포멧으로 출력.

		
//		Date currentTime = new Date ( ); // 현재날짜 생성
//		System.out.println("currentTime : "+currentTime);   // 일반 포멧으로 출력.
//		String rentalDate = format.format (currentTime);	// 포멧 변경작업. 
//		System.out.println ("rentalDate : "+ rentalDate );  // 정한 포멧으로 출력.

		
//		cal.add(rentalDate, 7);

		
//		Calendar cal2 = Calendar.getInstance();
		
		// 날짜 지정셋팅하기!
		cal.set(2020, 4, 1);			// month는 지정하는 월에서-1하기.
		Date today=cal.getTime();		// 셋팅한 날짜 Date타입에 변수에 담기.
		System.out.println("today : "+today);	// 일반 포멧으로 출력.
		String today2=format.format(today);		// 포멧변경작업. 
		System.out.println("today2 : "+today2);	// 정한 포멧으로 출력
		
		
		
		
		
		System.out.println("currentTime : "+currentTime);
		
		System.out.println("today : "+today);
		System.out.println("today2 : "+today2);
	

	}

}
