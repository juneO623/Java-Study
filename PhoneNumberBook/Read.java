import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Read extends Command {

    ArrayList<String> sortList = new ArrayList<String>();
    String list;

    public Read() throws IOException {
        br = new BufferedReader(new FileReader(phoneList));
    }

    @Override
    protected void CommandExecute() throws IOException {

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
