package Manager;


import phm.Member;
import phm.MemberInfo;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import data.MemberData;
import data.MemberData2;
import data.MemberData3;
import data.MemberData4;
import data.MemberData5;

public class MemberManager{

    private ArrayList<Member> member;
    Scanner sc;

    private MemberManager() {
        this.member = new ArrayList<>();
        sc = new Scanner(System.in);

        //member데이터 객체
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
    private static MemberManager manager = new MemberManager();

    public static MemberManager getInstance() {
        return manager;
    }


    public ArrayList<Member> getMember() {
        return member;
    }

    //회원정보보기
    //객체 전체 목록 출력
    public void showInfo() {
        for (int i = 0; i < member.size(); i++) {
            member.get(i).showAllInfo();
            System.out.println("----------------------------");
        }
    }

    public void addInfo() {
        String id = null, pw = null, pw2 = null, name = null, phoneNum = null, addr = null, email = null;
        int age = 0;

        //비밀번호 확인 루프를 위한 변수
        boolean checkPw = true;

        System.out.println("회원가입을 시작합니다.");
        System.out.println("사용하실 아이디를 입력해 주세요.");
        id = sc.nextLine();

        while (checkPw) {
            System.out.println("비밀번호를 입력해 주세요.");
            pw = sc.nextLine();
            System.out.println("다시한번 입력해 주세요.");
            pw2 = sc.nextLine();
            if (pw.equals(pw2)) {
                System.out.println("이름을 입력해 주세요.");
                name = sc.nextLine();

                while (true) {
                   
                        System.out.println("나이를 입력 해주세요.");
                        try {
                        	
                        age = sc.nextInt();
                        sc.nextLine();

                    } catch (InputMismatchException e) {
                        System.out.println("숫자를 입력해 주세요.");
                        sc.nextLine();
                        continue;
                    }


                    System.out.println("전화번호를 입력해 주세요.");
                    phoneNum = sc.nextLine();

                    System.out.println("주소를 입력해 주세요.");
                    addr = sc.nextLine();

                    System.out.println("이메일을 입력해 주세요.");
                    email = sc.nextLine();

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

    public void editInfo() {

        System.out.println("수정하실 분의 아이디를 선택해 주세요.");
        String id = sc.nextLine();

        int index = searchIndex(id);

        if(index > 0) {
            MemberInfo info = null;

            while(true) {
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
                        System.out.println("변경하실 비밀번호를 입력해 주세요.");
                        String pw1 = sc.nextLine();

                        System.out.println("다시 입력해주세요.");
                        String pw2 = sc.nextLine();

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
                    System.out.println("변경하실 전화번호를 입력해 주세요.");
                    String phoneNumber = sc.nextLine();

                    member.get(index).phoneNum = phoneNumber;
                    System.out.println("전화번호 변경이 완료되었습니다.");
                    break;
                case 3:
                    System.out.println("변경하실 주소를 입력해 주세요.");
                    String addr = sc.nextLine();

                    member.get(index).addr = addr;
                    System.out.println("주소 변경이 완료되었습니다.");
                    break;
                case 4:
                    System.out.println("변경하실 이메일을 입력해 주세요.");
                    String email = sc.nextLine();

                    member.get(index).email = email;
                    System.out.println("이메일 변경이 완료되었습니다.");
                    break;
                case 5:
                	break;
                	default:				
                		System.out.println("1~5사이의 숫자를 입력해주세요");
                		continue;
            }
            }
        } else {
            System.out.println("찾으시는 아이디가 없습니다.");

        }
    }
    
    public void deleteInfo() {
        System.out.println("삭제하실분의 아이디를 입력해 주세요.");
        String id = sc.nextLine();

        int index = searchIndex(id);
        System.out.println("아이디가 삭제되었습니다.");
        member.remove(index);

    }


    //로그인
    public void login() {

        if (loginCheck() == false) {
            boolean check = true;
            while (check) {
                System.out.println("아이디를 입력해 주세요.");
                String id = sc.nextLine();

                int index = searchIndex(id);
                if (index >= 0) {
                    System.out.println("비밀번호를 입력해 주세요.");
                    String pw = sc.nextLine();
                    if (member.get(index).getPw().equals(pw)) {
                        System.out.println("로그인이 완료되었습니다.");
                        member.get(index).loginCheck = true;
                        //System.out.println(member.get(index).loginCheck);
                        check = false;
                        break;
                    } else {
                        System.out.println("비밀번호를 다시 입력해 주세요.");
                        continue;
                    }
                } else {
                    System.out.println("입력하신 아이디가 없습니다. 다시 입력해주세요.");
                    continue;
                }
            }
        } else {
            System.out.println("이미 로그인 중입니다.");
        }
    }

    //관리자 로그인
    public void AdminLogin() {
        String loginPw = "0000";
        boolean loginCheck = true;
        int failCnt = 0;

        System.out.println("관리자 페이지 입니다.");
        System.out.println("");


        while (loginCheck) {
            System.out.println("비밀번호를 입력해주세요");
            String adminPw = sc.nextLine();
            

            if (loginPw.equals(adminPw)) {
                System.out.println("관리자로 로그인 하였습니다.");
                loginCheck = false;
                break;
            } else {
                System.out.println("비밀번호가 틀립니다. 다시 입력해 주세요.");
                failCnt++;

                if (failCnt == 3) {
                    System.out.println("너무 많이 틀리셨습니다. 메인 페이지로 돌아갑니다.");
                    break;
                }
                continue;

            }
        }
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


    public void adminLogOut() {
        for (int i = 0; i < member.size(); i++) {
            if (member.get(i).loginCheck == true) {
                member.get(i).loginCheck = false;
                System.out.println("로그아웃 되었습니다.");
                break;
            } else {
                System.out.println("로그인된 계정이 없습니다.");
                break;
            }
        }

    }

    }


