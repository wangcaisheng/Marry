package com.scyj.study;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.graphics.ColorSpace;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Queue;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        SparseArray sparseArray=new SparseArray();
//        sparseArray.u

        SharedPreferences sharedPreferences=getSharedPreferences("",0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.apply();


    }


}
