import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Search extends Main {

    Scanner sc = new Scanner(System.in);

    private String list;
    private ArrayList newList = new ArrayList();
    private String str;
    private int flag = 0;

    public void search() throws IOException {

        br = new BufferedReader(new FileReader(phoneList));

        System.out.println("검색할 이름이나 전화번호의 일부를 입력하세요.");
        str = sc.nextLine();

        while ((list = br.readLine()) != null){

            if (list.contains(str)){
                flag += 1;
                newList.add(list);
            }
        }

        if (flag == 0){
            System.out.println("전화번호부에 존재하지 않는 문자열 입니다.");
        } else{
            Collections.sort(newList);
            for (int i=0; i<newList.size(); i++){
                System.out.println(newList.get(i));
            }
        }

        System.out.println();

    }

}
