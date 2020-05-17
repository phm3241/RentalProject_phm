package master;


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

public class AdminManager {

    private ArrayList<Member> member;
    Scanner sc;

    //아이템배열 선언
    private ArrayList<Book> books;
    private ArrayList<DVD> dvd;
    private ArrayList<Game> game;


    private AdminManager() {
        this.member = new ArrayList<>();
        this.books = new ArrayList<>();
        this.dvd = new ArrayList<>();
        this.game = new ArrayList<>();
        sc = new Scanner(System.in);

        //book데이터 객체
        Bookdata book1 = new Bookdata();
        Bookdata2 book2 = new Bookdata2();
        Bookdata3 book3 = new Bookdata3();
        Bookdata4 book4 = new Bookdata4();
        Bookdata5 book5 = new Bookdata5();

        this.books.add(book1);
        this.books.add(book2);
        this.books.add(book3);
        this.books.add(book4);
        this.books.add(book5);


        //DVD데이터 객체
        DVDData dvd1 = new DVDData();
        DVDData2 dvd2 = new DVDData2();
        DVDData3 dvd3 = new DVDData3();
        DVDData4 dvd4 = new DVDData4();
        DVDData5 dvd5 = new DVDData5();

        this.dvd.add(dvd1);
        this.dvd.add(dvd2);
        this.dvd.add(dvd3);
        this.dvd.add(dvd4);
        this.dvd.add(dvd5);

        //game데이터 객체
        GameData game1 = new GameData();
        GameData2 game2 = new GameData2();
        GameData3 game3 = new GameData3();
        GameData4 game4 = new GameData4();
        GameData5 game5 = new GameData5();

        this.game.add(game1);
        this.game.add(game2);
        this.game.add(game3);
        this.game.add(game4);
        this.game.add(game5);

        //mamber데이터 객체
        MemberData mem1 = new MemberData();
        MemberData2 mem2 = new MemberData2();
        MemberData3 mem3 = new MemberData3();
        MemberData4 mem4 = new MemberData4();
        MemberData5 mem5 = new MemberData5();

        this.member.add(mem1);
        this.member.add(mem2);
        this.member.add(mem3);
        this.member.add(mem4);
        this.member.add(mem5);
    }

    //어드민매니저 객체 싱글톤 구현
    private static AdminManager manager = new AdminManager();

    public static AdminManager getInstance() {
        return manager;
    }


    public ArrayList<Member> getMember() {
        return member;
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


    //회원정보보기
    //객체 전체 목록 출력
    public void showInfo() {
        for (int i = 0; i < member.size(); i++) {
            member.get(i).showAllInfo();
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------");
        }
    }

    public void addInfo() {
        String id = null, pw = null, pw2 = null, name = null, phoneNum = null, addr = null, email = null;
        int age = 0;

        //비밀번호 확인 루프를 위한 변수
        boolean checkPw = true;

        System.out.println("회원가입을 시작합니다.");
        System.out.println("사용하실 아이디를 입력해 주세요.(숫자와 영문만 입력가능합니다.)");
        id = checkEnN();

        while (checkPw) {
            System.out.println("비밀번호를 입력해 주세요.(숫자와 영문만 가능합니다.)");
            pw = checkEnN();
            System.out.println("다시한번 입력해 주세요.(숫자와 영문만 가능합니다.)");
            pw2 = checkEnN();
            if (pw.equals(pw2)) {
                System.out.println("이름을 입력해 주세요.(한글만 입력 가능합니다)");
                name = checkKorean();

                while (true) {

                    System.out.println("나이를 입력 해주세요.(숫자만 입력 가능합니다.)");
                    try {

                        age = sc.nextInt();
                        sc.nextLine();

                    } catch (InputMismatchException e) {
                        System.out.println("숫자를 입력해 주세요.");
                        sc.nextLine();
                        continue;
                    }


                    System.out.println("전화번호를 입력해 주세요.(전화번호형식 000-0000-0000 입력만 가능합니다.)");
                    phoneNum = checkPhoneNum();

                    System.out.println("주소를 입력해 주세요. (숫자와 한글만 입력가능합니다.)");
                    addr = checkKnN();

                    System.out.println("이메일을 입력해 주세요.(이메일형식 xxx@xxx.xxx식으로 입력해주세요.)");
                    email = checkEmail();

                    //입력받은 데이터 저장
                    Member info = new Member(name, age, phoneNum, addr, email, id, pw);
                    member.add(info);

                    System.out.println("회원가입이 정상적으로 완료되었습니다.");
                    //저장후 무한루프를 빠져나오기 위해 checkPw를 false로 변경
                    //System.out.println(member.get(0));
                    checkPw = false;
                    break;
                }
            } else {
                System.out.println("입력하신 비밀번호가 다릅니다. 다시 입력해 주세요.");
                continue;
            }
        }

    }




    public void editInfo() {

        System.out.println("수정하실 분의 아이디를 선택해 주세요.");
        String id = checkVal();

        int index = searchIndex(id);

        if (index > 0) {
            MemberInfo info = null;

            while (true) {
                System.out.println("1. 비밀번호 | 2. 전화번호 | 3.주소 | 4. 이메일 |5. 뒤로가기");

                int selectNum;
                try {
                    selectNum = sc.nextInt();
                    sc.nextLine();
                } catch (Exception e) {
                    System.out.println("1~5사이의 숫자를 입력해주세요");
                    sc.nextLine();
                    continue;
                }
                switch (selectNum) {
                    case 1:
                        boolean check = true;
                        while (check) {
                            System.out.println("변경하실 비밀번호를 입력해 주세요.(영어와 숫자만 입력가능)");
                            String pw1 = checkEnN();

                            System.out.println("다시 입력해주세요.");
                            String pw2 = checkEnN();

                            //아이디,비밀번호정보 받고 수정해야함
                            if (pw1.equals(pw2)) {
                                member.get(index).setPw(pw1);
                                System.out.println("비밀번호 변경이 완료되었습니다.");
                                check = false;
                                break;
                            } else {
                                System.out.println("비밀번호가 맞지 않습니다. 다시 입력해 주세요.");
                                continue;
                            }
                        }
                        break;
                    case 2:
                        System.out.println("변경하실 전화번호를 입력해 주세요.(xxx-xxx(x)-xxxx 형식으로 가능)");
                        String phoneNumber = checkPhoneNum();

                        member.get(index).phoneNum = phoneNumber;
                        System.out.println("전화번호 변경이 완료되었습니다.");
                        break;
                    case 3:
                        System.out.println("변경하실 주소를 입력해 주세요.(한글과 숫자만 입력 가능)");
                        String addr = checkKnN();

                        member.get(index).addr = addr;
                        System.out.println("주소 변경이 완료되었습니다.");
                        break;
                    case 4:
                        System.out.println("변경하실 이메일을 입력해 주세요.(xxx@xxxx.xxx형식으로 가능)");
                        String email = checkEmail();

                        member.get(index).email = email;
                        System.out.println("이메일 변경이 완료되었습니다.");
                        break;
                    case 5:
                        break;
                    default:
                        System.out.println("1~5사이의 숫자를 입력해주세요");
                        continue;
                }
                break;
            }
        } else {
            System.out.println("찾으시는 아이디가 없습니다.");

        }
    }


    //회원정보 삭제
    public void deleteInfo() {
        System.out.println("삭제하실분의 아이디를 입력해 주세요.");
        String id = checkVal();

        int index = searchIndex(id);
        if (index < 0) {
            System.out.println("삭제하고자하는 아이디가 존재하지 않습니다");
        } else {
            System.out.println("아이디가 삭제되었습니다.");
            member.remove(index);
        }
    }


    //로그인
    public void login() {

        if (loginCheck() == false) {
            boolean check = true;
            int loginCnt = 0;
            int pwCnt = 0;

            while (check) {
                System.out.println("아이디를 입력해 주세요.");
                String id = checkVal();
                int index = searchIndex(id);
                if (index >= 0) {
                    System.out.println("비밀번호를 입력해 주세요.");
                    String pw = checkVal();
                    if (member.get(index).getPw().equals(pw)) {
                        System.out.println("로그인이 완료되었습니다.");
                        member.get(index).loginCheck = true;
                        //System.out.println(member.get(index).loginCheck);
                        check = false;
                        break;
                    } else {
                        System.out.println("비밀번호가 다릅니다.");
                        System.out.println("--------------------");
                        pwCnt++;
                        if(pwCnt == 3){
                            System.out.println("3회 잘못 입력 하셨습니다. 메인으로 돌아갑니다.");
                            break;
                        }
                        continue;
                    }
                } else {
                    System.out.println("입력하신 아이디가 없습니다. 다시 입력해주세요.");
                    loginCnt++;
                    if(loginCnt == 3){
                        System.out.println("3회 잘못 입력 하셨습니다. 메인으로 돌아갑니다.");
                        break;
                    }
                    continue;
                }
            }
        } else {
            System.out.println("이미 로그인 중입니다.");
        }
    }

    //관리자 로그인
    public boolean AdminLogin() {
        String loginPw = "0000";
        boolean loginCheck = true;
        int failCnt = 0;
        System.out.println("-----------------------");
        System.out.println("관리자페이지 입니다.");

        while (loginCheck) {

            System.out.println("비밀번호를 입력해주세요..>>");
            System.out.println("-----------------------");
            String adminPw = sc.nextLine();

            if (loginPw.equals(adminPw)) {
                loginCheck = false;
                break;
            } else {
                System.out.println("비밀번호가 틀립니다. 다시 입력해 주세요.");
                failCnt++;
                if (failCnt == 3) {
                    break;
                }
                continue;
            }
        }
        return loginCheck;
    }

    public void logOut() {
        if (loginCheck()) {
            for (int i = 0; i < member.size(); i++) {
                if (member.get(i).loginCheck == true) {
                    member.get(i).loginCheck = false;
                    System.out.println("로그아웃 되었습니다.");
                    break;
                }
            }
        } else {
            System.out.println("로그인된 계정이 없습니다.");
        }
    }


// 체크 메소드들    
//====================================================================================================


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

    //한글만 입력받는 메소드
    String checkKorean() {
        String checkMsg = null;
        while (true) {
            checkMsg = checkVal();
            String p = "^[가-힣]*$";
            boolean m = Pattern.matches(p, checkMsg);
            if (m==false) {
                System.out.println("한글만 입력가능합니다.");
                continue;
            } else {
                break;
            }
        }
        return checkMsg;
    }

    //영어와 숫자만 받는 메소드(id)
    String checkEnN() {
        String checkMsg = null;
        while (true) {
            checkMsg = checkVal();
            String p = "^[a-zA-Z0-9]*$";
            boolean m = Pattern.matches(p, checkMsg);
            if (m==false) {
                System.out.println("영어와 숫자의 조합만 입력가능합니다.");
                continue;
            } else {
                break;
            }
        }
        return checkMsg;
    }

    //한글과 숫자만 받는 메소드
    String checkKnN() {
        String checkMsg = null;
        while (true) {
            checkMsg = checkVal();
            String p = "^[가-힣0-9]*$";
            boolean m = Pattern.matches(p, checkMsg);
            if (m==false) {
                System.out.println("한글과 숫자의 조합만 입력가능합니다.");
                continue;
            } else {
                break;
            }
        }
        return checkMsg;
    }

    //전화번호 입력받는 메소드
    String checkPhoneNum() {
        String checkMsg = null;
        while (true) {
            checkMsg = checkVal();
            String p = "^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$";
            boolean m = Pattern.matches(p, checkMsg);
            if (m == false) {
                System.out.println("전화번호 형식 (000-0000-0000) 으로 입력해 주세요.");
                continue;
            } else {
                break;
            }
        }
        return checkMsg;
    }


    //이메일 입력받는 메소드
    String checkEmail() {
        String checkMsg = null;
        while (true) {
            checkMsg = checkVal();
            String p = "^[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z]{2,6}$";
            boolean m = Pattern.matches(p, checkMsg);
            if (m == false) {
                System.out.println("이메일 형식(xxx@xxx.xxx)으로 입력하여 주세요.");
                continue;
            } else {
                break;
            }
        }
        return checkMsg;
    }


    // 로그인체크해서 로그인상태인지 아닌지 반환
    boolean loginCheck() {
        boolean loginCheck = false;
        for (int i = 0; i < this.member.size(); i++) {
            if ((this.member.get(i).loginCheck) == true) {
                loginCheck = true;
                break;
            }
        }
        return loginCheck;
    }

    // 로그인체크해서 인덱스 반환
    int loginCheckIndex() {
        int loginCheckIndex = -1;
        for (int i = 0; i < this.member.size(); i++) {
            if (this.member.get(i).loginCheck == true) {
                loginCheckIndex = i;
                break;
            }
        }
        return loginCheckIndex;
    }

    int searchIndex(String id) {
        //정상적인 index 값은 0~이상의 값, 찾지 못했을 때 구분 값 -1을 사용
        int searchIndex = -1;
        //배열의 반복으로 id값을 비교해서 index 값을 찾는다.
        for (int i = 0; i < member.size(); i++) {
            if (member.get(i).checkId(id)) {
                searchIndex = i;
                break;
            }
        }
        return searchIndex;
    }



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
    
    //create로 이동
//	@Override
    //도서 정보넣기
//	public void addBookInfo(Book info) {
//		//배열에 추가
//		books.add(info);
//
//
//	}
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
    //create로 이동
//DVD추가
//	@Override
//	public void addDvdInfo(DVD info) {
//		dvd.add(info);
//
//	}

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

    //create쪽으로 넣음
//게임추가
//	@Override
//	public void addGameInfo(Game info) {
//		game.add(info);
//
//	}
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
