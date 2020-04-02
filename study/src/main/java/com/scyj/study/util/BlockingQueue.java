package com.scyj.study.util;

import java.util.LinkedHashMap;
import java.util.LinkedList;

/**
 * author ：Hyman
 * date: 2020/4/2 16:48
 * des: 手写阻塞队列，面试题
 * version: 1.0
 */
public class BlockingQueue {

    LinkedList<Object> queue=new LinkedList<>();
    private int maxSize=3;
    private int minSize=0;

    private BlockingQueue(){}
    static BlockingQueue mInstance;
    public static BlockingQueue getInstance(){
        if(mInstance==null){
            synchronized (BlockingQueue.class){
                if(mInstance==null){
                    mInstance=new BlockingQueue();
                }
            }

        }
        return mInstance;
    }

    synchronized void enQueue(Object obj)throws InterruptedException{
        //当队列元素达到最大容量时阻塞
        while(queue.size()==maxSize){
          System.out.println("线程名："+Thread.currentThread().getName()+"  队列满：");
          wait();
        }
        if(queue.size()==minSize){
          notifyAll();
        }
        queue.add(obj);

    }

    synchronized Object dequeue() throws InterruptedException{

        if (queue.size()==maxSize){
            notifyAll();
        }
        while (queue.size()==minSize){
            System.out.println("线程名："+Thread.currentThread().getName()+"  队列空");
            wait();
        }
        return queue.remove(0);
    }

    public static void main(String[] args) throws InterruptedException{
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <4 ; i++) {
                    try {
                        BlockingQueue.getInstance().enQueue(i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Runnable runnable1=new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <20 ; i++) {
                    try {
                        BlockingQueue.getInstance().dequeue();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Thread thread1=new Thread(runnable,"1");
        thread1.start();
//        Thread.currentThread().wait(10);
//        Thread thread2=new Thread(runnable1,"2");
//        thread2.start();
    }
}
