package com.scyj.study.util;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * author ：Hyman
 * date: 2020/4/2 17:31
 * des:  用可重入锁写 阻塞队列
 * version: 1.0
 */
public class BlockQueue<T> {
    private int size;
    private List queue;

    private Lock lock = new ReentrantLock();
    private Condition full = lock.newCondition();
    private Condition empty = lock.newCondition();

    public BlockQueue() {
        this(3);
    }

    public BlockQueue(int size) {
        this.size = size;
        queue = new LinkedList();
    }

    public void push(T element) throws InterruptedException {
        lock.lock();
        try {
            while (queue.size() == size) {
                System.out.println("队列满。。。");
                full.await();
            }
            queue.add(element);
            empty.signal();
        } finally {
            lock.unlock();
        }
    }

    public T pop() throws InterruptedException {
        lock.lock();
        try {
            while (queue.size() == 0) {
                System.out.println("队列空。。。");
                empty.await();
            }
            full.signal();
            return (T) queue.remove(0);
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final BlockQueue<Integer> blockQueue = new BlockQueue<Integer>(3);
        blockQueue.push(1);
        blockQueue.push(1);
//        blockQueue.push(1);
//        blockQueue.push(1);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    blockQueue.pop();
                    blockQueue.pop();
                    blockQueue.pop();
//                    blockQueue.pop();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
//        System.out.println(blockQueue.pop());
//        blockQueue.push(2);
//        System.out.println(blockQueue.pop());
//        blockQueue.push(3);
//        System.out.println(blockQueue.pop());
//
//        blockQueue.push(5);
//        blockQueue.push(5);
//        System.out.println(blockQueue.pop());
    }
}
