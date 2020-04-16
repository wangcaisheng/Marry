package com.scyj.study.util;

import android.os.Handler;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.logging.LogRecord;

/**
 * author ：Hyman
 * date: 2020/4/4 15:52
 * des: 线程的开启方式三：callable,有返回值。
 * version: 1.0
 */
public class ThreadTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

//        //任务执行
//        Callable<String>  stringCallable=new Callable<String>() {
//            @Override
//            public String call() throws Exception {
//                return "我是callable";
//            }
//        };
//
//        //FutureTask是Runnable的子类
//        FutureTask<String> futureTask=new FutureTask<String>(stringCallable);
//        //开启线程
//        new Thread(futureTask).start();
//        //获取线程执行的返回值
//        System.out.println(futureTask.get());

        threadRun();

    }


    static volatile int sun = 0;

    public static void threadRun() {
        new Thread(new MyRunable(5), "main").start();
        new Thread(new MyRunable(1), "Thread1").start();
        new Thread(new MyRunable(2), "Thread2").start();

    }

    public static class MyRunable implements Runnable {

        int time = 0;

        public MyRunable(int mtime) {
            time = mtime;
        }

        @Override
        public void run() {

            String name = Thread.currentThread().getName();

            if (name.equals("Thread1")) {
                try {
                    Thread.sleep(1000);
                    while (sun < 1000) {

                        synchronized (MyRunable.class) {
                            System.out.println("ThreadNmae" + Thread.currentThread().getName() + "前  sun=" + sun);
                            sun++;
                            System.out.println("ThreadNmae" + Thread.currentThread().getName() + "后  sun=" + sun);
                        }
                       wait(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (name.equals("Thread2")) {
                try {
                    while (sun < 1000) {
                        synchronized (MyRunable.class) {
                            System.out.println("ThreadNmae" + Thread.currentThread().getName() + "前  sun=" + sun);
                            sun++;
                            System.out.println("ThreadNmae" + Thread.currentThread().getName() + "后  sun=" + sun);
                        }
                        wait(2000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            while (name.equals("main")) {
                try {
                    synchronized (MyRunable.class) {
                        System.out.println("ThreadNmae " + Thread.currentThread().getName() + "  sun=" + sun);
                        wait(5000);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }


        }
    }


    public void sendMessage() {

        //每1秒
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {

            }
        }, 0, 1000);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {

            }
        }, 0, 2000);


        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {

            }
        }, 0, 5000);
    }


}
