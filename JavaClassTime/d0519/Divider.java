package kr.hs.dgsw.java.dept23.d0519;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Divider {
	
	private Scanner sc;
	
	public Divider() {
		sc = new Scanner(System.in);
	}
	
	public int calculate(int value1, int value2) {
		return value1 / value2;
	}
	
//	private void saveResult(String filePath, int v1, int v2, int result) throws IOException {
//		
//		// 파일 객체 생성
//		File file = new File(filePath+"/writeTest.txt");
//		
//		
//		if (file.exists()) {
//			file.createNewFile();
//		}
//		
//		FileWriter fw = new FileWriter(file, true);
//		PrintWriter writer = new PrintWriter(fw);
//		
//		writer.println("%d / %d = %d".formatted(v1, v2, result));
//		
//		writer.close();		
//	}
	
	private boolean saveResult(String filePath, int value1, int value2, int result) {
		
		String str = String.format("%d / %d = %d\n", value1, value2, result);
		
		OutputStream os = null;
		
		try {
			File file = new File(filePath+"/writeTest.txt");		
			
			os = new FileOutputStream(file, true);	// true를 쓰게되면 없으면 만들어서 쓰고 있으면 이어서 씀
			os.write(str.getBytes());
			
			return true;
		} catch (Exception e) {
			System.out.println("파일에 저장할 수 없습니다.");
		} finally {	// return 하게되면 파일이 끝나버리기 때문에 finally를 써서 return 하기 전에 finally문을 실행함
			if (os != null) {
				try {
					os.close();
				} catch(IOException e) {}
			}
		}
		
		
				
		return true;
	}
	
	public void execute() {
		
		try {

			System.out.println("두 정수를 입력하세요.");
			
			int value1 = sc.nextInt();
			int value2 = sc.nextInt();
			
			int result = calculate(value1, value2);
			System.out.printf("%d / %d = %d\n", value1, value2, result);
			
			// 계산 식과 결과를 파일로 저장한다.
			boolean saved = saveResult("C:/Users/DGSW/eclipse-workspace/새 폴더/javaFirst/src/kr/hs/dgsw/java/dept23/d0519", value1, value2, result);
			
			System.out.println("파일 저장 결과 : " + saved);
			
			
			 
			System.out.println("프로그램을 종료합니다.");
			
		} catch (InputMismatchException e) {
			System.out.println("문자가 아닌 숫자를 입력하세요.");
		} catch (ArithmeticException e) {
			System.out.println("0으로 나눌 수 없습니다.");
		} finally {
			sc.close();
		}
		
		/* catch (IOException e) {
			System.out.println("파일에 저장할 수 없습니다.");
			e.printStackTrace();
		} */
		
		/* catch (Exception e) {
			System.out.println("예외가 발생하였습니다. " + e);
			
			if (e instanceof InputMismatchException) {
				System.out.println("문자가 아닌 숫자를 입력하세요.");
			} else if (e instanceof ArithmeticException) {
				System.out.println("0으로 나눌 수 없습니다.");
			}
			
		} */
		
		
	}
	
	public static void main(String[] args) {
		new Divider().execute();
	}
	
}
