import test.TestRegistration;

import java.io.IOException;
import java.io.Serial;

public class CommandMain extends Command {

    static String command;


    public static void main(String[] args) throws IOException {
        new CommandMain().CommandExecute();
    }

    @Override
    protected void CommandExecute() throws IOException {
        while (true) {

            if (!phoneList.exists()) {
                phoneList.createNewFile();
            }
            System.out.println("┌───────── 명령어 리스트 ──────────┐");
            System.out.println("│ /등록, /검색, /삭제, /목록, /종료  │");
            System.out.println("└────────────────────────────────┘");
            System.out.println("명령어를 입력해주세요.");
            command = sc.nextLine();

            if (command.startsWith("/등록")) {
                new Registration().CommandExecute();
            } else if (command.startsWith("/검색")) {
                new Search().CommandExecute();
            } else if (command.startsWith("/삭제")) {
                new Remove().CommandExecute();
            } else if (command.startsWith("/목록")) {
                new Read().CommandExecute();
            } else if (command.startsWith("/종료")) {
                System.exit(0);
            } else {
                System.out.println("잘못된 명령어 입니다.");
                System.out.println("명령어 리스트를 보고 올바르게 입력해주세요.");
                System.out.println();
            }
        }

    }
}
