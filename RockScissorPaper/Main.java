package RockScissorPaper;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Computer computer = new Computer();
        Scanner sc = new Scanner(System.in);
        String userHandstr;

        System.out.println("\n가위바위보 게임을 시작하지\n");
        while (true) {
            System.out.printf("당신의 선택은?  ");
            userHandstr = sc.nextLine();

            if (userHandstr.equals("quit")){
                System.out.println("프로그램이 종료되었습니다.");
                break;
            }

            computer.compare(computer.strToNumConverter(userHandstr));

        }

    }

}
