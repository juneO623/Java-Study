import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public abstract class Command {

    protected Scanner sc = new Scanner(System.in);
    protected File phoneList = new File("C:\\Users\\DGSW\\IdeaProjects\\PhoneNumberBook\\src\\PhoneList.txt");

    protected abstract void CommandExecute() throws IOException;    // 각 명령어 마다 구현할 함수 선언

    protected BufferedWriter bw;
    protected BufferedReader br;

}
