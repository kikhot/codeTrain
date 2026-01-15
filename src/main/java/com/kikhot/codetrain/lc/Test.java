package com.kikhot.codetrain.lc;

public class Test {
    public static void main(String[] args) {
        System.out.println("hello World!");
    }
    //冒泡排序
    public static int[] bubbleSort(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }

        return arr;
    }

    //快速排序
}
