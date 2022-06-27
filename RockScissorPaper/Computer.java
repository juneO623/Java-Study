package RockScissorPaper;


import java.util.Random;

public class Computer {

    static Random random = new Random();
    static int comHand;
    static int w = 0, d = 0, l = 0;

    public int strToNumConverter(String userHand){
        if (userHand.equals("가위") || userHand.equals("찌")){
            return 0;
        } else if (userHand.equals("바위") || userHand.equals("주먹") || userHand.equals("묵")){
            return 1;
        } else if (userHand.equals("보") || userHand.equals("빠")){
            return 2;
        }
        return -1;
    }

    public String numToStrConverter(int Handnum){
        if (Handnum == 0){
            return "가위";
        } else if (Handnum == 1){
            return "바위";
        } else {
            return "보";
        }
    }

    public void compare(int userHand) {
        comHand = random.nextInt(3);
        if (userHand == -1){
            System.out.println("불법 플레이어 검거 완료\n");
        }
        else {
            if (userHand == comHand){
                d++;
                System.out.printf("무승부 - %s vs %s\n", numToStrConverter(userHand), numToStrConverter(comHand));
                System.out.printf("현재 전적 : %d승 %d무 %d패 \n\n", w, d, l);
            } else if (userHand - comHand == 1 || (userHand == 0 && comHand == 2)) {
                w++;
                System.out.printf("승리 - %s vs %s\n", numToStrConverter(userHand), numToStrConverter(comHand));
                System.out.printf("현재 전적 : %d승 %d무 %d패 \n\n", w, d, l);
            } else {
                l++;
                System.out.printf("패배 - %s vs %s\n", numToStrConverter(userHand), numToStrConverter(comHand));
                System.out.printf("현재 전적 : %d승 %d무 %d패 \n\n", w, d, l);
            }
        }
    }
}
