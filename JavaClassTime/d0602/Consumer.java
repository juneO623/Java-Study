package kr.hs.dgsw.java.dept23.d0602;

public class Consumer implements Runnable {
    private final Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
                try {
                	synchronized (buffer) {
                		buffer.wait();
                        int value = buffer.get();
                        System.out.println("숫자 " + value + "을 처리합니다.");
					}
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
    }
}
