package com.louis.剑指offer;

public class 第八题跳台阶拓展 {
    public int JumpFloorII(int target) {
        if (target==0 || target ==1) {
            return 1;
        }
        return 2*JumpFloorII(target-1);
    }
}
