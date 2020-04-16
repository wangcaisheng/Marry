package com.scyj.study.util;

import java.util.Arrays;

/**
 * author ：Hyman
 * date: 2020/4/16 21:39
 * des:  排序算法
 * version: 1.0
 */
public class SortClass {


    public static void main(String[] args) {
        int[] a= {3,6,5,7,9,4};
//        insertSort(a);
        quick(a);
        System.out.println(Arrays.toString(a));
    }

    /**
     * 插入排序
     */
    public static void insertSort(int[] a){
        int length = a.length; //求取出length是为了提高速度
        int insertNum ;
        for(int i=1;i<length;i++){//要插入的数
            insertNum = a[i];
            int j = i-1;
            while(j>=0&&insertNum<a[j]){
                a[j+1] = a[j];
                j--;
            }
            //比如3 6 5，此时找到j为3，则在j+1的位置插入5。
            a[j+1]=insertNum;
        }
    }

    /**
     * 快速排序
     */
    public static void quick(int[] numbers){
        if(numbers.length > 0){ //查看数组是否为空{
            quickSort(numbers, 0, numbers.length-1);
        }
    }

    public static void quickSort(int[] numbers,int low,int high){
        if(low < high){
            int middle = getMiddle(numbers,low,high); //将numbers数组进行一分为二
            System.out.println(middle);
            quickSort(numbers, low, middle-1); //对低字段表进行递归排序
            quickSort(numbers, middle+1, high); //对高字段表进行递归排序
        }
    }

    public static int getMiddle(int[] numbers, int low,int high){
        int temp = numbers[low]; //数组的第一个作为中轴
        while(low < high){
            while(low < high && numbers[high] > temp){
                high--;
            }
            if(low<high){
                numbers[low++] = numbers[high];//强制塞值并向前移一位
            }
            while(low < high && numbers[low] < temp){
                low++;
            }
            if(low<high){
                numbers[high--] = numbers[low] ; //强制塞值并向前移一位
            }
        }
        numbers[low] = temp ; //中轴记录到尾
        return low ; // 返回中轴的位置
    }


}
