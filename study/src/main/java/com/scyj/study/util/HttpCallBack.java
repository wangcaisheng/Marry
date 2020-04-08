package com.scyj.study.util;

import com.scyj.study.BuildConfig;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.FutureTask;

/**
 *
 * 此Demo 现在不正确
 *
 *
 * author ：Hyman
 * date: 2020/4/2 20:53
 * des: 根据传入的泛型T，获取它具体代理的类的类名
 * version: 1.0
 */
public class HttpCallBack<T> {

    //通过反射的方式获取类型
    public  Class<?> analizeClassInfo(T object) {
       Type getType= object.getClass().getGenericSuperclass();
       Type[] params= ((ParameterizedType)getType).getActualTypeArguments();
       return (Class<?>) params[0];

    }

    public static void main(String[] args){
//        analizeClassInfo(new Person());
        HttpCallBack callBack=new HttpCallBack<Person>();
//        System.out.print(callBack.analizeClassInfo() );


    }

    static class Person{

    }
}
