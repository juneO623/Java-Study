package kr.hs.dgsw.java.dept23.d0519;

public class ExceptionStudy {
	
	public void method1() throws MyException {
		
		System.out.println("method1 호출됨");;
		
		// 예외를 발생시켜 봅시다.
		MyException exception = new MyException();
		throw exception;
		
	}
	
	public void method2() {
		try {
			method1();
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	// 에러가 발생한 함수 호출에 대한 정보를 출력
		}
	}
	
	public void method3() {
		MyRuntimeException exception = new MyRuntimeException();
		throw exception;
	}
	
	public static void main(String[] args) {
		
		new ExceptionStudy().method2();
		
	}
	
}
