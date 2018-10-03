package com.louis.algorithm.sort;

import java.util.Arrays;
/**
 * https://www.cnblogs.com/SkyeAngel/p/8715987.html
 * 使用归并排序解决两小和问题
 *
 * */
public class 小数和 {
    public static void main(String []args){
        int []arr = {3,3,4,2,5};
        System.out.println(sort(arr));
    }

    public static int sort(int []arr){
        int []temp = new int[arr.length];//在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
        return sort(arr,0,arr.length-1,temp);
    }
    private static int sort(int[] arr,int left,int right,int []temp){
        if (left == right ){
            return 0;
        }
        int mid = (left+right)/2;
        return sort(arr,left,mid,temp)+
                sort(arr,mid+1,right,temp)+
                merge(arr,left,mid,right,temp);//将两个有序子数组合并操作
    }
    private static int merge(int[] arr,int left,int mid,int right,int[] temp){
        int i = left;//左序列指针
        int j = mid+1;//右序列指针
        int t = 0;//临时数组指针
        int res = 0 ;
        while (i<=mid && j<=right){
            if(arr[i]<arr[j]){
                res = res + arr[i]*(right-j+1);
                temp[t++] = arr[i++];
            }else {
                temp[t++] = arr[j++];
            }
//            res += arr[i] < arr[j] ? (right - j + 1) * arr[i] : 0;
//            temp[t++] = arr[i] < arr[j] ? arr[i++] : arr[j++];
        }
        while(i<=mid){//将左边剩余元素填充进temp中
            temp[t++] = arr[i++];
        }
        while(j<=right){//将右序列剩余元素填充进temp中
            temp[t++] = arr[j++];
        }
        t = 0;
        //将temp中的元素全部拷贝到原数组中
        while(left <= right){
            arr[left++] = temp[t++];
        }
        return res;
    }
}
