package phm.test;


import java.io.OutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import data.Bookdata;
import data.Bookdata2;
import data.Bookdata3;
import data.Bookdata4;
import data.Bookdata5;
import data.DVDData;
import data.DVDData2;
import data.DVDData3;
import data.DVDData4;
import data.DVDData5;
import data.GameData;
import data.GameData2;
import data.GameData3;
import data.GameData4;
import data.GameData5;
import data.MemberData;
import data.MemberData2;
import data.MemberData3;
import data.MemberData4;
import data.MemberData5;


public class RentalItemManager {

    Scanner sc;

    //아이템배열 선언
    private ArrayList<RentalItemInfo> items ;
//    private ArrayList<Book> books;
//    private ArrayList<DVD> dvd;
//    private ArrayList<Game> game;


    private RentalItemManager() {
    	this.items = new ArrayList<>();
        this.items = new ArrayList<BOOK>();
        this.dvd = new ArrayList<>();
        this.game = new ArrayList<>();
        sc = new Scanner(System.in);

        //book데이터 객체
//        Bookdata book1 = new Bookdata();
//        Bookdata2 book2 = new Bookdata2();
//        Bookdata3 book3 = new Bookdata3();
//        Bookdata4 book4 = new Bookdata4();
//        Bookdata5 book5 = new Bookdata5();
//
//        this.items.add(book1);
//        this.items.add(book2);
//        this.items.add(book3);
//        this.items.add(book4);
//        this.items.add(book5);
//
//
//        //DVD데이터 객체
//        DVDData dvd1 = new DVDData();
//        DVDData2 dvd2 = new DVDData2();
//        DVDData3 dvd3 = new DVDData3();
//        DVDData4 dvd4 = new DVDData4();
//        DVDData5 dvd5 = new DVDData5();
//
//        this.items.add(dvd1);
//        this.items.add(dvd2);
//        this.items.add(dvd3);
//        this.items.add(dvd4);
//        this.items.add(dvd5);
//
//        //game데이터 객체
//        GameData game1 = new GameData();
//        GameData2 game2 = new GameData2();
//        GameData3 game3 = new GameData3();
//        GameData4 game4 = new GameData4();
//        GameData5 game5 = new GameData5();
//
//        this.items.add(game1);
//        this.items.add(game2);
//        this.items.add(game3);
//        this.items.add(game4);
//        this.items.add(game5);


    }

    
    //어드민매니저 객체 싱글톤 구현
    private static RentalItemManager Items = new RentalItemManager();

    public static RentalItemManager getInstance() {
        return Items;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }


    public ArrayList<DVD> getDvd() {
        return dvd;
    }


    public ArrayList<Game> getGame() {
        return game;
    }

    
    
    
//	■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
    //FIXME 환영 피드백
    public void showBasic(int selectNum) {
    	if(selectNum == 1) {
    		showBookBasic();
    	}else if(selectNum == 2) {
    		showDvdBasic();
    	}else {
    		showGameBasic();
    	}
    }

    //FIXME 환영 피드백
    public int searchInfo(int selectNum, String title) {
    	if(selectNum == 1) {
    		return searchBookInfo(title);
    	}else if(selectNum == 2) {
    		return searchDvdInfo(title);
    	}else {
    		return searchGameInfo(title);
    	}
    }

    //FIXME 환영 피드백
    public RentalItemInfo getData(int selectNum, int index) {
    	
    	if(selectNum == 1) {
    		Book book = getBooks().get(index);
    		book.showAllinfo();
    		return book;
    		
    	}else if(selectNum == 2) {
    		DVD dvd = getDvd().get(index);
    		dvd.showAllinfo();
    		return dvd;
    		
    	}else {
    		Game game = getGame().get(index);
    		game.showAllinfo();
    		return game;
    	}
    }
    

    
    //공백 체크 메소드(String)
    String checkVal() {
        String checkMsg = null;
        while (true) {
            checkMsg = sc.nextLine();
            String p = "^\\s*$";
            boolean m = Pattern.matches(p, checkMsg);
            if (m) {
                System.out.println("공백을 입력하셨습니다. 다시 입력해주세요.");
                continue;
            } else {
                break;
            }
        }
        return checkMsg;
    }
    
    
//	■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
    //책입니다---------------------------------------------

    //자료관리
    //도서 정보보기
    public void showBookInfo() {
        System.out.println("책 전체정보 출력");
        for (int i = 0; i < books.size(); i++) {
            books.get(i).showAllinfo();
            System.out.println("----------------------------------------------------------------------------------------------------");
        }


    }

    public void showBookBasic() {
        System.out.println("책 기본 정보 출력");
        for (int i = 0; i < books.size(); i++) {
            books.get(i).showBasicInfo();
            System.out.println("----------------------------------------------------------------------------------------------------");
        }
    }

 
    //도서정보수정
    public void editBookInfo() {

        System.out.println("변경하고자하는 책 이름을 입력해주세요");
        String title = checkVal();

        int index = searchBookInfo(title);


        if (index < 0) {
            System.out.println("찾으시는 책의 정보가 존재하지 않습니다.");
        } else {
            String editTitle = books.get(index).title;

            System.out.println("수정 사항을 입력합니다");
            System.out.println("책 이름은: " + editTitle + "입니다");
            System.out.println("자료위치는");
            String localData = checkVal();

            books.get(index).localData = localData;


        }
    }

    //도서정보삭제
    public void deleteBookInfo() {
        System.out.println("삭제하고자 하는 책 이름을 선택하여주세요");
        String title = checkVal();
        int index = searchBookInfo(title);

        if (index < 0) {
            System.out.println("삭제하고자 하는 책이 존재하지 않습니다.");
        } else {
            System.out.println("선택하신 책이 삭제되었습니다.");
            books.remove(index);
        }

    }

    //도서정보 검색
    public int searchBookInfo(String title) {
        //정상적인 index 값은 0~이상의 값, 찾지 못했을 때 구분 값 -1을 사용
        int searchIndex = -1;

        //배열의 반복으로 title값을 비교해서 index 값을 찾는다.
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).title.equals(title)) {
                searchIndex = i;
                break;
            }
        }
        return searchIndex;
    }

    
    
    
    
    
    
//	■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
    //DVD입니다----------------------------------------------
    //DVD정보출력
    public void showDvdInfo() {
        System.out.println("DVD정보 출력\n");
        for (int i = 0; i < dvd.size(); i++) {
            dvd.get(i).showAllinfo();
            System.out.println("----------------------------------------------------------------------------------------------------");
        }
    }

    public void showDvdBasic() {
        System.out.println("DVD 기본 정보 출력\n");
        for (int i = 0; i < dvd.size(); i++) {
            dvd.get(i).showBasicInfo();
            System.out.println("----------------------------------------------------------------------------------------------------");
        }
    }

    //DVD수정
    public void editDvdInfo() {
        System.out.println("변경하고자하는 DVD이름을 입력해주세요");
        String title = checkVal();

        int index = searchDvdInfo(title);

        if (index < 0) {
            System.out.println("찾으시는 DVD의 정보가 존재하지 않습니다.");
        } else {
            String editTitle = dvd.get(index).title;

            System.out.println("수정 사항을 입력합니다");
            System.out.println("DVD 이름은: " + editTitle + "입니다");
            System.out.println("자료위치는");
            String localData = checkVal();

            dvd.get(index).localData = localData;
        }

    }

    //DVD삭제
    public void deleteDvdInfo() {
        System.out.println("삭제하고자 하는 DVD 이름을 선택하여주세요");
        String title = checkVal();
        int index = searchDvdInfo(title);

        if (index < 0) {
            System.out.println("삭제하고자 하는 DVD가 존재하지 않습니다.");
        } else {
            System.out.println("선택하신 DVD가 삭제되었습니다.");
            dvd.remove(index);
        }


    }

    //DVD검색
    public int searchDvdInfo(String title) {
        //정상적인 index 값은 0~이상의 값, 찾지 못했을 때 구분 값 -1을 사용
        int searchIndex = -1;

        //배열의 반복으로 title값을 비교해서 index 값을 찾는다.
        for (int i = 0; i < dvd.size(); i++) {
            if (dvd.get(i).title.equals(title)) {
                searchIndex = i;
                break;
            }
        }
        return searchIndex;
    }


    
    
//	■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
    //게임입니다---------------------------------------------------
    //게임보기
    public void showGameInfo() {
        System.out.println("게임정보 출력\n");
        for (int i = 0; i < game.size(); i++) {
            game.get(i).showAllinfo();
            System.out.println("----------------------------------------------------------------------------------------------------");
        }

    }

    public void showGameBasic() {
        System.out.println("게임 기본 정보 출력\n");
        for (int i = 0; i < game.size(); i++) {
            game.get(i).showBasicInfo();
            System.out.println("----------------------------------------------------------------------------------------------------");
        }
    }


    //게임수정
    public void editGameInfo() {
        System.out.println("변경하고자하는 게임 이름을 입력해주세요");
        String title = checkVal();

        int index = searchGameInfo(title);


        if (index < 0) {
            System.out.println("찾으시는 게임의 정보가 존재하지 않습니다.");
        } else {
            String editTitle = game.get(index).title;

            System.out.println("수정 사항을 입력합니다");
            System.out.println("게임 이름은: " + editTitle + "입니다");
            System.out.println("자료위치는");
            String localData = checkVal();
            game.get(index).localData = localData;

        }

    }

    //게임삭제
    public void deleteGameInfo() {
        System.out.println("삭제하고자 하는 게임이름을 선택하여주세요");
        String title = checkVal();
        int index = searchGameInfo(title);

        if (index < 0) {
            System.out.println("삭제하고자 하는 게임이 존재하지 않습니다.");
        } else {
            System.out.println("선택하신 게임이 삭제되었습니다.");
            game.remove(index);
        }


    }

    //게임검색
    public int searchGameInfo(String title) {
        //정상적인 index 값은 0~이상의 값, 찾지 못했을 때 구분 값 -1을 사용
        int searchIndex = -1;

        //배열의 반복으로 title값을 비교해서 index 값을 찾는다.
        for (int i = 0; i < game.size(); i++) {
            if (game.get(i).title.equals(title)) {
                searchIndex = i;
                break;
            }
        }
        return searchIndex;
    }

    
    //정보 입력단계------------------------------------------------------
    //책 정보 입력
    public Book createBookInfo() throws InputMismatchException {

        Book info = null;
        String title = null;
        String genre = null;
        String localData = null;
        String author = null;
        int limitAge = 0;
        String story = null;
        String launchDate = null;
        // 기본정보 수집: 책이름, 장르, 책위치, 저자, 연령제한, 설명, 출판일


        System.out.println("책이름을 입력해주세요.");
        title = checkVal();

        System.out.println("장르을 입력해주세요.");
        genre = checkVal();

        System.out.println("자료위치를 입력해주세요.");
        localData = checkVal();

        System.out.println("저자를 입력해주세요");
        author = checkVal();
        while (true) {
            try {
                System.out.println("연령제한 입력해주세요");
                limitAge = sc.nextInt();
                sc.nextLine();

            } catch (InputMismatchException e) {
                System.out.println("연령제한을 잘못입력했습니다. \n다시 입력해주세요.(숫자입력)");
                sc.nextLine();
                continue;
            }

            System.out.println("설명을 입력해주세요");
            story = checkVal();    //설명
            System.out.println("출판일을 입력해주세요");
            launchDate = checkVal();    //출판일

            info = new Book(title, genre, localData,
                    author, limitAge, story, launchDate);

            //배열에 추가
            books.add(info);
            return info;
        }
    }

    //DVD 정보 입력
    public DVD createDvdInfo() {
        DVD info = null;
        String title = null;
        String genre = null;
        String localData = null;
        String foreman = null;
        String runingTime = null;
        int limitAge = 0;
        String story = null;
        String launchDate = null;


        // 기본정보 수집: DVD이름, 장르, DVD위치, 감독, 상영시간, 연령제한, 설명, 출판일

        System.out.println("DVD이름을 입력해주세요.");
        title = checkVal();

        System.out.println("장르을 입력해주세요.");
        genre = checkVal();

        System.out.println("자료위치를 입력해주세요.");
        localData = checkVal();

        System.out.println("감독를 입력해주세요");
        foreman = checkVal();

        System.out.println("상영시간을 입력해주세요");
        runingTime = checkVal();

        while (true) {
            try {
                System.out.println("연령제한 입력해주세요");
                limitAge = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("연령제한을 잘못입력했습니다. \n 다시 입력해주세요");
                sc.nextLine();
            }

            System.out.println("설명을 입력해주세요");
            story = checkVal();    //설명

            System.out.println("출판일을 입력해주세요");
            launchDate = checkVal();    //출판일


            //DVD 클래스로 인스턴스생성
            info = new DVD(title, genre, localData, foreman,
                    runingTime, limitAge, story, launchDate);

            //배열에 추가
            dvd.add(info);

            return info;
        }
    }

    //Game 정보 입력
    public Game CreateGameInfo() {
        Game info = null;
        String title = null;
        String genre = null;
        String localData = null;
        String producer = null;
        int limitAge = 0;
        String story = null;
        String launchDate = null;
        // 기본정보 수집: 게임이름, 장르, 게임위치, 제작자, 연령제한, 설명, 출판일

        System.out.println("게임이름을 입력해주세요.");
        title = checkVal();

        System.out.println("장르을 입력해주세요.");
        genre = checkVal();

        System.out.println("게임위치를 입력해주세요.");
        localData = checkVal();

        System.out.println("제작자를 입력해주세요");
        producer = checkVal();


        while (true) {
            try {
                System.out.println("연령제한 입력해주세요");
                limitAge = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("연령제한을 잘못입력했습니다. \n 다시 입력해주세요.");
                sc.nextLine();
            }

            System.out.println("설명을 입력해주세요");
            story = checkVal();    //설명

            System.out.println("출판일을 입력해주세요");
            launchDate = checkVal();    //출판일


            //2.2.3 Book 클래스로 인스턴스생성
            info = new Game(title, genre, localData,
                    producer, limitAge, story, launchDate);

            //배열에 추가
            game.add(info);
            return info;
        }
    }


}
