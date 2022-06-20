import java.io.*;
import java.util.Scanner;

// 이름과 전화번호 등록하기 (등록된 데이터는 파일에 저장 - 데이터베이스 사용 금지)       Add
// 이름으로 전화번호 검색하기 - 이름의 일부분으로 검색 가능해야 하며, 결과가 여러 개일 경우에 모두 보여 줍니다.      Search - By name
// 전화번호의 일부로 전화번호 검색하기 - 결고가 여러 개일 경우에 모두 보여 줍니다.       Search - By Number
// 이름으로 전화번호 삭제하기 - 이름이 중복되었을 경우, 전화번호를 모두 제시한 뒤 특정한 전화번호를 삭제하게 합니다.    Delete - By name
// 전화번호 수정 기능을 구현하지 않아도 됩니다.
// 결과가 여러 개일 경우에 이름 순으로 정렬되어 출력되어야 합니다.

public class Main {

    static String command;
    static File phoneList = new File("C:\\Users\\DGSW\\IdeaProjects\\PhoneNumberBook\\src\\PhoneList.txt");
    static BufferedWriter bw;
    static BufferedReader br;

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);



        if (!phoneList.exists()){
            phoneList.createNewFile();
        }

        while(true) {
            System.out.println("------- 명령어 리스트 --------");
            System.out.println("- /등록, /검색, /삭제 , /종료 -");
            System.out.println("----------------------------");
            System.out.println("명령어를 입력해주세요.");
            command = sc.nextLine();

            switch (command) {
                case "/등록":{
                    new Registration().register();
                    break;
                }

                case "/검색":{
                    new Search().Search();
                    break;
                }

                case "/종료":{
                    System.exit(0);
                }
            }
        }
    }
}
