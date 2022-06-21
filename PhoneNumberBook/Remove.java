import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Remove extends Main {

    String list;
    private ArrayList<String> newList = new ArrayList();
    private ArrayList<String> deleteList = new ArrayList();
    private int cnt = 0;
    private ArrayList<Integer> arrNum = new ArrayList<Integer>();
    private ArrayList<String> allList = new ArrayList<String >();

    public void remove() throws IOException {

        br = new BufferedReader(new FileReader(phoneList));

        Scanner sc = new Scanner(System.in);

        System.out.print("전화번호를 삭제할 이름을 입력하세요 : ");
        String rmName = sc.nextLine();

        while ((list = br.readLine()) != null) {     // 파일 목록 읽고,
            if (list.contains(rmName)) {             // 입력한 이름과 중복되는 이름 리스트,
                deleteList.add(list);
                System.out.println(list);
            } else {
                newList.add(list);                    // 나머지 리스트 만들기기            }
            }
        }

        for (int i=0; i< newList.size(); i++){
            allList.add(newList.get(i));
        }
        for (int i=0; i< deleteList.size(); i++){
            allList.add(deleteList.get(i));
        }

        if (deleteList.size() <= 0){
            System.out.println("그런 이름을 가진 사람은 없습니다.");
            System.out.println();
        }
        else {
            bw = new BufferedWriter(new FileWriter(phoneList));     // 처음부터 쓰기, 선언하자마자 파일 내용 사라져서 아래에서 선언

            System.out.println("삭제할 번호를 입력하세요 ('-'까지 정확하게 입력해주세요) 예 010-1234-5678 ");
            String phoneNum = sc.nextLine();

            for (String list : deleteList){
                String[] peopleInfo = list.split(" ");
                if (peopleInfo[1].equals(phoneNum)){
                    System.out.print("정말로 이 번호를 삭제하시겠습니까? (y / n) : ");
                    String answer = sc.nextLine();
                    if (answer.equals("y") || answer.equals("Y")){
                        continue;
                    }
                    else{
                        System.out.println("번호 삭제에 실패하였습니다.");
                        newList.add(list);
                    }
                } else {
                    newList.add(list);
                }
            }
            if (allList.size() != newList.size()){
                System.out.println("번호 삭제에 성공했습니다.");
            }
            for (int i=0; i<newList.size(); i++){
                bw.write(newList.get(i));
                bw.write("\n");
            }
            bw.close();
        }
        br.close();
    }
}
