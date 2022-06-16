package kr.hs.dgsw.java.dept23.d0602;

public class AdderThread implements Runnable {

	private final Calculator calculator;
	
	public AdderThread(Calculator calculator) {
		this.calculator = calculator;
	}
	
	@Override
	public void run() {
		InputValues values = null;
		
		while (true) {
			
			synchronized (calculator) {
				try {
					calculator.wait();
				} catch (InterruptedException e) {
					break;
				}
				
				values = calculator.getInputValues();
			}

			if (values != null) {
				calculateAndPrint(values);
			}
		}
		
	}
	
	public void calculateAndPrint(InputValues values) {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		int result = values.getValue1() + values.getValue2();
		System.out.printf("%d + %d = %d\n", values.getValue1(), 
				values.getValue2(), result);
	}

}
