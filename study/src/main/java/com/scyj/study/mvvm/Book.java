package com.scyj.study.mvvm;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.scyj.study.BR;

/**
 * author ：Hyman
 * date: 2020/4/11 15:14
 * des:
 * version: 1.0
 */
public class Book extends BaseObservable {
    public Book(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String name;

    public int price;

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
        //同步数据
        notifyPropertyChanged(BR.name);
    }

    /**
     * 在get方法上加注解
     * @return
     */
    @Bindable
    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
