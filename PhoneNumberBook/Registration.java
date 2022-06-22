import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Registration extends Command {

    public Registration() throws IOException {
        bw = new BufferedWriter(new FileWriter(phoneList, true));   // 뒤에 true를 붙여주면 이어쓰기
    }

    @Override
    protected void CommandExecute() throws IOException {
        String Info, name, number, resultInfo;
        while (true){
            System.out.println("등록할 이름, 전화번호를 입력하세요. ex)이름 010-1234-5678");
            Info = sc.nextLine();
            if (Info.contains(" ")){
                name = Info.split(" ", 2)[0];
                number = Info.split(" ", 2)[1];
//                if (number.contains(" ") || number.length() < 11) {              // 전화번호에 " "이 있거나 01012345678 11자리도 입력하지 않았을 때
//                    System.out.println("전화번호를 다시 입력해주세요.");
//                    continue;
//                }
                if (!number.contains("-") && number.length() == 11) {        // 전화번호에 "-"이 없을 때
                    number = number.substring(0, 3) + "-"
                            + number.substring(3, 7) + "-"
                            + number.substring(7);
                }
                else if (number.length() == 13){
                    ;
                }
                else {
                    System.out.println("전화번호를 다시 입력해주세요.");
                    continue;
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
        System.out.println("전화번호가 등록되었습니다.");
    }
}
