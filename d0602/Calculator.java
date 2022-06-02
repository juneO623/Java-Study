package kr.hs.dgsw.java.dept23.d0602;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Calculator {
	
	private final Queue<InputValues> queue = 
			new LinkedList<InputValues>();
	
	private final List<Thread> threadPool = 
			new LinkedList<Thread>();
	
	
	public void notifyInputTerminated() {
		for (Thread thread : threadPool) {
			thread.interrupt();
		}
	}
	
	public void makeAdderThreads() {
		AdderThread adderThread = new AdderThread(this);
		Thread thread = new Thread(adderThread);
		
		threadPool.add(thread);
		
		thread.start();
	}
	
	public synchronized void addValues(InputValues values) {
			queue.add(values);
			notify();
	}
	
	public InputValues getInputValues() {
		synchronized (queue) {
			if (queue.size() > 0) {
				return queue.poll();
			} else {
				return null;
			}
		}
	}
	
	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		
		InputThread inputThread = new InputThread(calculator);
		new Thread(inputThread).start();
		
		calculator.makeAdderThreads();
		calculator.makeAdderThreads();
		calculator.makeAdderThreads();
		calculator.makeAdderThreads();
		calculator.makeAdderThreads();
		calculator.makeAdderThreads();
		calculator.makeAdderThreads();
		
	}
}
