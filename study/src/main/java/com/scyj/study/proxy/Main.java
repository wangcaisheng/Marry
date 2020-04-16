package com.scyj.study.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * author ：Hyman
 * date: 2020/4/16 23:12
 * des: 动态代理测试类
 * 动态代理原理： 根据传的classLoader、要实现的接口、InvocationHandler生成了代理对象class,
 *    然后反射执行invoke方法。 总体来说就是生成代理类的class，运行期执行。
 *
 * version: 1.0
 */
public class Main {

    public static void main(String[] args){
        final BaoQiang baoQiang=new BaoQiang();

        //使用动态代理
        Iplayer proxy= (Iplayer) Proxy.newProxyInstance(baoQiang.getClass().getClassLoader(),
                new Class[]{Iplayer.class},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                       System.out.println("老宋前期沟通拍电影事宜");
                        baoQiang.paiFilm();
                        return null;
                    }
                });

        proxy.paiFilm();

    }
}
