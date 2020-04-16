package com.scyj.study.proxy;

/**
 * author ：Hyman
 * date: 2020/4/16 23:12
 * des: 被代理类
 * version: 1.0
 */
public class BaoQiang implements Iplayer{
    @Override
    public void paiFilm() {
        System.out.println("宝强我在拍  泰囧");
    }

    @Override
    public void paiGg() {
        System.out.println("宝强我在拍  旅游广告");
    }
}
