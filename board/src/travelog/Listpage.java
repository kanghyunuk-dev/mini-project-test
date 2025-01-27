package travelog;

import java.util.Scanner;

public class Listpage {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		DB db = new DB();
		System.out.println("_____________________    _________   _______________.____    ________    ________ \r\n"
				+ "\\__    ___/\\______   \\  /  _  \\   \\ /   /\\_   _____/|    |   \\_____  \\  /  _____/ \r\n"
				+ "  |    |    |       _/ /  /_\\  \\   Y   /  |    __)_ |    |    /   |   \\/   \\  ___ \r\n"
				+ "  |    |    |    |   \\/    |    \\     /   |        \\|    |___/    |    \\    \\_\\  \\\r\n"
				+ "  |____|    |____|_  /\\____|__  /\\___/   /_______  /|_______ \\_______  /\\______  /\r\n"
				+ "                   \\/         \\/                 \\/         \\/       \\/        \\/ \r\n"
				+ "  ______   ______   ______   ______   ______   ______   ______   ______   ______  \r\n"
				+ "                                                                                  ");
		
		db.select(); // 게시글목록
		while (true) {
            System.out.println("메뉴를 선택하세요:");
            System.out.println("1. 게시글 카테고리 검색 > (경상도 경기도 충청도 강원도 경상도)");
            System.out.println("2. 게시글 선택");
            System.out.println("3. 게시글 등록");
            System.out.println("4. 메인 화면으로 이동");

            int choice = scan.nextInt();
            scan.nextLine();  // 개행 문자 처리

            switch (choice) {
                case 1:
                	// 카테고리 선택
                	boolean check = false;
                    String cate;
                    do {
                        System.out.println("카테고리를 입력해주세요.");
                        System.out.println("경상도 충청도 전라도 강원도 경기도");
                        cate = scan.nextLine();
                        if (isValidCategory(cate)) {
                            check = true;
                        } else {
                            System.out.println("카테고리를 다시 입력하세요.");
                        }
                    } while (!check); // false 가 되면 종료 - true면 계속 실행
                    db.cateSelect(cate);
                    break;
                case 2:
                	boolean checkNum = false;
                	// 게시글 선택
//                    System.out.println("게시글 번호를 입력하세요:");
//                    int boardNum = scan.nextInt();
                    // 상세페이지 클래스 호출 및 선택한 게시글 번호 전달
//                    DetailPage.showDetail(boardNum);
                    do {
                        System.out.println("게시글 번호를 입력하세요:");
                        int boardNum = scan.nextInt();
                        scan.nextLine();  // 개행 문자 처리
                        if (DetailPage.showDetail(boardNum)) {
//                        	System.out.println(db.detail(boardNum));
                        	System.out.println(DetailPage.showDetail(boardNum));
                            checkNum = true;
                        } else {
                            System.out.println("조회 되지 않는 게시물입니다.");
                        }
                    } while (!checkNum); // false 가 되면 종료 - true면 계속 실행
                    break;
                case 3:
                    // 게시글등록
                    break;
                case 4:
                	// 메인화면이동
                    System.out.println("메인 화면으로 이동합니다.");
                    return;  // 프로그램 종료
                default:
                    System.out.println("올바른 메뉴를 선택하세요.");
            }
            
        }
		
		
		
//		System.out.println("원하는 카테고리를 선택해주세요");
//		while(true) {
//			
//		}
//		while(true) {
//			String input = scan.nextLine();
//			if(input.equals("1")) {
//				System.out.println("게시물 선택");
//			} else {
//				System.out.println("종료");
//			}
//		}
		
	}
	private static boolean isValidCategory(String category) {
	    // 유효한 카테고리인지 확인하는 메서드
	    return category.equals("경상도") || category.equals("충청도") || category.equals("전라도")
	            || category.equals("강원도") || category.equals("경기도");
	}
}

