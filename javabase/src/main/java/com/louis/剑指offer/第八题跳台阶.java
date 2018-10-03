package com.louis.剑指offer;

public class 第八题跳台阶 {
    public int JumpFloor(int target) {
        if(target ==0 || target == 1) {
            return 1;
        }
        return JumpFloor(target-1) + JumpFloor(target-2);
    }
}
