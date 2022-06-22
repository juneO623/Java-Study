import java.io.*;
import java.util.ArrayList;

public class Remove extends Command {

    String list;
    private ArrayList<String> newList = new ArrayList();
    private ArrayList<String> deleteList = new ArrayList();
    private int cnt = 0;
    private ArrayList<String> allList = new ArrayList<String >();

    public Remove() throws IOException {
        br = new BufferedReader(new FileReader(phoneList));
    }

    @Override
    protected void CommandExecute() throws IOException {

        System.out.print("전화번호를 삭제할 이름을 입력하세요 : ");
        String rmName = sc.nextLine();

        while ((list = br.readLine()) != null) {     // 파일 목록 읽고,
            if (list.contains(rmName)) {             // 입력한 이름과 중복되는 것은 삭제 리스트,
                deleteList.add(list);
                System.out.println(list);
            } else {
                newList.add(list);                    // 나머지는 새로 써줄 리스트에 넣기
            }
        }

        for (int i=0; i< newList.size(); i++){          // 두 리스트 모두 다 합치면
            allList.add(newList.get(i));
        }
        for (int i=0; i< deleteList.size(); i++){       // 처음에 읽은 리스트 정보와 동일하므로
            allList.add(deleteList.get(i));             // 전체 리스트에 넣어주기
        }

        if (deleteList.size() <= 0){                                    // 삭제 리스트의 사이즈가 0보다 작다면
            System.out.println("그런 이름을 가진 사람은 없습니다.");         //  입력한 이름와 같은 이름이 없는 것이므로
            System.out.println();
        }
        else {
            bw = new BufferedWriter(new FileWriter(phoneList));     // 처음부터 쓰기, 선언하자마자 파일 내용 사라져서
                                                                    // 내용 읽은 후, 아래에서 선언
            System.out.println("삭제할 번호를 입력하세요 ('-'까지 정확하게 입력해주세요) 예 010-1234-5678 ");
            String phoneNum = sc.nextLine();                                        // 삭제할 번호 입력받음

            for (String list : deleteList){                                         // 삭제리스트를 보면서 같은 번호를 찾음
                String[] peopleInfo = list.split(" ");
                if (peopleInfo[1].equals(phoneNum)){                                // 삭제는 중요한 기능이므로
                    System.out.print("정말로 이 번호를 삭제하시겠습니까? (y / n) : ");    // 한 번 더 물어보고 삭제함
                    String answer = sc.nextLine();
                    if (answer.equals("y") || answer.equals("Y")){
                        continue;
                    }
                    else{
                        System.out.println("번호 삭제에 실패하였습니다.");
                        newList.add(list);
                    }
                } else {                    // 같지 않다면 삭제리스트에 있던 것은 새로 써줄 리스트에 추가
                    newList.add(list);
                    cnt++;
                }
            }
            if (cnt == deleteList.size()){  // 같은 번호가 아닌 수가 삭제리스트에 있는 수와 같다면
                System.out.println("이런 번호는 없습니다.");
            }
            if (allList.size() != newList.size()){      // 처음 전체 리스트와 새로 쓰려는 리스트의 수가 다르다면 삭제된 것이므로 번호 삭제 성공
                System.out.println("번호 삭제에 성공했습니다.");
            }
            for (int i=0; i<newList.size(); i++){
                bw.write(newList.get(i) + "\n");    // 새로 쓰려는 리스트의 정보들을 한줄 씩 쓰기
            }
            bw.close();
        }
        br.close();
    }
}
