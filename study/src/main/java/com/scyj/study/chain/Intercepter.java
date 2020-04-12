package com.scyj.study.chain;

/**
 * author ：Hyman
 * date: 2020/4/10 21:37
 * des: 责任链模式学习Demo;定义接口
 * version: 1.0
 */
public interface Intercepter {
    String intercepter(Chain chain);

    /**
     * 接口内部定义接口，作为外部接口方法的参数
     */
    public interface Chain{
        String request();
        String proceed(String request);

    }

}
