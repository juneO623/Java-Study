import java.io.*;
import java.util.Scanner;

public class Registration extends Main {

    Scanner sc = new Scanner(System.in);

    public void register() throws IOException {
        String Info, name, number, resultInfo;
        while (true){
            bw = new BufferedWriter(new FileWriter(phoneList, true));   // 뒤에 true를 붙여주면 이어쓰기
            System.out.println("등록할 이름, 전화번호를 입력하세요. ex)이름 010-1234-5678");
            Info = sc.nextLine();
            if (Info.contains(" ")){
                name = Info.split(" ", 2)[0];
                number = Info.split(" ", 2)[1];
                if (number.contains(" ")) {              // 전화번호에 " "이 있다면
                    System.out.println("전화번호를 다시 입력해주세요.");
                    continue;
                }
                else if (!number.contains("-")) {        // 전화번호에 "-"이 없다면
                    number = number.substring(0, 3) + "-"
                            + number.substring(3, 7) + "-"
                            + number.substring(7);
                }
                resultInfo = name + " " + number + "\n";

                bw.write(resultInfo);
                bw.close();
                break;
            }
            else{
                System.out.println("다시 입력해주세요.");
            }
        }
    }

}
