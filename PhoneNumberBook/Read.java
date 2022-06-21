import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Read extends Main {

    Scanner sc = new Scanner(System.in);

    ArrayList<String> sortList = new ArrayList<String>();
    String list;

    void read() throws IOException {
        br = new BufferedReader(new FileReader(phoneList));

        while ((list = br.readLine()) != null) {
            sortList.add(list);
        }

        Collections.sort(sortList);

        System.out.println("───────────────────────────");
        for (int i=0; i<sortList.size(); i++){
            System.out.println(sortList.get(i));
        }
        System.out.println("───────────────────────────");
        System.out.println();
    }

}
