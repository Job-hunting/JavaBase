package com.louis.剑指offer;

public class 第三十题连续子数组的最大和 {
    public static int FindGreatestSumOfSubArray(int[] array) {
        if(array==null||array.length==0){
            return 0;
        }
        int curSum=0;//从某个位置开始到当前位置为止，保留的最大值。
        int greatSum=Integer.MIN_VALUE;//从开始位置到当前位置，存下的最大值。
        for(int i=0;i<array.length;i++){
            if(curSum<=0){//到当前位置为止，如果curSum为负数，无论是array[i]为正负，
                // 加上当前元素后，curSum都会比array[i]小，所以不如将curSum设为array[i]
                curSum=array[i];
            }else{
                curSum+=array[i];//如果array[i]为正，curSum会变大，下一步将被保存greatSum中，
                // 但如果array[i]为负，上一次循环greatSum已经保存了，所以尽可放心；
            }
            if(curSum>greatSum){
                greatSum=curSum;
            }
        }
        return greatSum;
    }
    public static void main(String[] args) {
        int[] array = new int[]{2,-1};
        System.out.println(FindGreatestSumOfSubArray(array));
    }

}
