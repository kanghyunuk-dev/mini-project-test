package travelog;

//import java.util.Scanner;

public class DetailPage {
	public static boolean showDetail(int boardNum) {
//		Scanner scan = new Scanner(System.in);
		DB db = new DB();
//        System.out.println("게시글 번호 " + boardNum + "의 내용을 출력합니다.");
//        db.detail(boardNum);
        
        // db.detail(boardNum) 메서드에서 상세 정보 출력 및 성공 여부를 얻음
        boolean success = db.detail(boardNum);
        
        if (success) {
            System.out.println("게시글 번호 " + boardNum + "의 내용을 출력합니다.");
        } else {
            System.out.println("해당 번호의 게시글이 존재하지 않습니다. 다시 입력해주세요.");
        }

        return success;
    }
}
