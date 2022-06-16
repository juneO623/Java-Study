package kr.hs.dgsw.java.dept23.d0616;
// int byte short long float double boolean char
public class Simple<T, Q> {
	
	private T value;
	
	private Q data;
	
	public T getValue() {
		return value;
	}
	
	public void setValue(T value) {
		this.value = value;
	}
	
	public Q getData() {
		return data;
	}
	
	public static void main(String[] args) {
		Simple<Integer, String> simple = new Simple<Integer, String>();
		simple.setValue(1311);
		
		Simple<String, String> simple2 = new Simple<String, String>();
		simple2.setValue("hello");
		
		Integer intValue = 3;
		
		Simple raw = new Simple();
//		Integer value = (Integer)raw.getValue();	// null
//		int value = (Integer)raw.getValue();		// null을 int로 바꾸는 도중에 널포인트Exception발생
		
		
	}
	
	
	
}
