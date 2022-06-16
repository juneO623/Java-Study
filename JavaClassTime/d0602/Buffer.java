package kr.hs.dgsw.java.dept23.d0602;

import java.util.LinkedList;
import java.util.Queue;

public class Buffer {
    private final Queue<Integer> queue = new LinkedList<>();

    public synchronized void add(int value) {
        queue.add(value);

        notify();		// wait 하고 있는 애 한테 알려줌
    }

    public Integer get() {
        return queue.poll();
    }

    public static void main(String[] args) {
        Buffer buffer = new Buffer();

        Producer producer = new Producer(buffer);
        Thread producerThread = new Thread(producer);
        producerThread.start();

        Consumer consumer = new Consumer(buffer);
        Thread consumerThread = new Thread(consumer);
        consumerThread.start();
    }
}
