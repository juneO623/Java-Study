package kr.hs.dgsw.java.dept23.d0407;

import java.util.Arrays;

public class ArrayStudy {
	
	public void studyArray() {
		
		int array2[];
		
		String[] names = new String[5];
		
		int[] array1 = new int[10];
		int[] values = {1, 2, 3, 4, 5};
		
		//TODO colors 라는 문자열 타입의 배열을 선언하고, 값을 초기화 해보세요.
		String[] colors = {"빨강", "노랑", "파랑", "초록", "보라"};
		
		System.out.println(colors[1]);
		colors[4] = "분홍";
		
		printLastValue(colors);
		
		printColors(colors);
		
//		String myColor = colors[5];
//		System.out.println("myColor : " + myColor);
		
		String[] colors2 = colors;	// colors의 배열의 주소 값을 가짐
		
		colors2[2] = "blue";
		System.out.println(colors[2]);	// blue
		System.out.println(colors2[2]);	// blue
		
		ArrayCopy arrayCopy = new ArrayCopy();
		String[] colors3 = arrayCopy.copy(colors);
		colors3[3] = "green";
//		System.out.println(colors[3]);
		
		System.out.println("colors : " + Arrays.toString(colors));
		System.out.println("colors2 : " + Arrays.toString(colors2));
		System.out.println("colors3 : " + Arrays.toString(colors3));

		
		int[] intArray = {1, 2, 3, 4, 5};
		int[] copyIntArray = arrayCopy.copy(intArray);
		intArray[2] = 1;
		System.out.println("intArray : " + Arrays.toString(intArray));
		System.out.println("copyIntArray : " + Arrays.toString(copyIntArray));
	}
	
	public void printColors(String[] colors) {
		// TODO colors에 들어있는 값을 인덱스 - 값 형식으로 모두 출력해 보세요.
		for (int i=0; i<colors.length; i++) {
			System.out.println(i+" - "+colors[i]);
		}
		
		for (String color : colors) {
			System.out.println(color);
		}
		// 부분만 출력하는 것이 아니라면 타이핑 양도 적고,
		// 아래코드가 더 편하다
		// 하지만 i값을 알아야하면 위에 방법이 더 좋다
	}
	
	
	public void printLastValue(String[] values) {
		
//		int length = values.length;
//		System.out.println(values[length-1]);
		System.out.println(values[values.length-1]);
	}
	
	
	public static void main(String[] args) {
		
		ArrayStudy study = new ArrayStudy();
		study.studyArray();
		
		
	}
}
