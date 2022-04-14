package kr.hs.dgsw.java.dept23.d0317;

public class DataTypeStudy {
	/*
	 *  ÀÚ¹ÙÀÇ µ¥ÀÌÅÍ Å¸ÀÔ¿¡´Â ±âº» µ¥ÀÌÅÍ Å¸ÀÔ°ú ÂüÁ¶ µ¥ÀÌÅÍ Å¸ÀÔÀÌ ÀÖµû.
	 *  Á¤¼öÇü µ¥ÀÌÅÍ Å¸ÀÔ°ú ½Ç¼öÇü µ¥ÀÌÅÍ Å¸ÀÔÀÌ µû·Î ÀÖ´Ù.
	 *  int byte short long char float double boolean
	 *  Á¤¼öÅ¸ÀÔ int, long, short, byte, char
	 *  ½Ç¼öÅ¸ÀÔ float, double
	 *  ³í¸®Å¸ÀÔ boolean
	 */	
	public void studyInteger() {
		byte byteValue = 127;
		short shortValue = 32767;
		int intValue = 2100000000;
		long longValue = 3000000001L;
		// 21¾ïº¸´Ù Å« ¼ö¸¦ ÀÔ·ÂÇÏ°Ô µÇ¸é ÀÚ¹Ù°¡ ¸ð¸£´Â ¼ýÀÚ¿©¼­ ¿¡·¯°¡ ¹ß»ýÇÔ
		// µû¶ó¼­ 21¾ïº¸´Ù Å« ¼ö¸¦ ÀÔ·ÂÇÒ ¶§´Â µÚ¿¡ LÀ» ºÙÀÌ±â 
	}
	
	public void studyReal() {
		double doubleValue = 1234567890.1234567890;
		float floatValue = 3.1415926F;
		// doubleÀÌ floatº¸´Ù Á¤¹Ðµµ°¡ ´õ ³ôÀ½
		// Áß¿äÇÑ °è»êÀÌ¶ó¸é Á¤¼ö·Î º¯È¯ÇÏ°í °è»êÇÏ°í
		// ´Ù½Ã double·Î
		System.out.println(doubleValue);
		System.out.println(floatValue);
	}
	
	public void studyBoolean() {
		boolean bool1 = (3>2);
		boolean bool2= ((1241 * 24) > (2452 * 16));
		
		if (true) {
			// TODO
		}
	}
	
	public void studyChar() {
		char ch = 'A';
		char ch2 = 65;	// ASCII CODE 'A'
		char ch3 = 97;	// ASCII CODE 'a'
		char ch4 = 48;	// ASCII CODE '0'
		
		for (char i=0; i<256; i++) {
			// System.out.printf("%d - %c \n", (int)i, i);
			System.out.printf("%04x  %d - %c \n", (int)i, (int)i, i);
		}
		
		int h1 = '°¡';
		// ÀÛÀº µû¿ÈÇ¥¸¦ ¾²¸é Á¤¼ö·Î Ã³¸®µÈ´Ù.
		System.out.println(h1);
		
		int hanja1 = 'ìé';
		int hanja2 = 'ðè';
		int hanja3 = 'ìý';
		int hanja4 = 'Õô';
		
		System.out.println(hanja1+" "+hanja2+" "+hanja3+" "+hanja4);
		
//		int count = 'ÆR' - '°¡' + 1;
//		System.out.println(count);
		
//		for (int i ='°¡'; i<'°¼'; i++) {
//			System.out.printf("%d - %c\n", i, (char)i);
//		}
//		
	}
	
	public static void main(String[] args) {
		DataTypeStudy study = new DataTypeStudy();
		study.studyReal();
		study.studyChar();
	}
}
