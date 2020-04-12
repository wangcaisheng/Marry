package com.scyj.study.mvvm;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.library.baseAdapters.BR;

import com.scyj.study.R;
import com.scyj.study.databinding.ActivityMvvmBinding;

/**
 * author ：Hyman
 * date: 2020/4/11 12:48
 * des: 用DataBinding 的方式写MVVM.
 * 目前：怎么写MVVM？
 * version: 1.0
 */
public class MvvmActivity extends AppCompatActivity {

    //编译自动生成的帮助类
    ActivityMvvmBinding binding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_mvvm);
        binding= DataBindingUtil.setContentView(this, R.layout.activity_mvvm);
        Book book=new Book("红楼梦",100);
//        binding.setBook(book);
        binding.setVariable(BR.book,book);

    }
}
