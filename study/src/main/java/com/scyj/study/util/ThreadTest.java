package com.scyj.study.util;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * author ：Hyman
 * date: 2020/4/4 15:52
 * des: 线程的开启方式三：callable,有返回值。
 * version: 1.0
 */
public class ThreadTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //任务执行
        Callable<String>  stringCallable=new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "我是callable";
            }
        };

        //FutureTask是Runnable的子类
        FutureTask<String> futureTask=new FutureTask<String>(stringCallable);
        //开启线程
        new Thread(futureTask).start();
        //获取线程执行的返回值
        System.out.println(futureTask.get());

    }
}
