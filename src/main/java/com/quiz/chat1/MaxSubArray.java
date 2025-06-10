package com.quiz.chat1;

/**
 *  1: Arrays
 Write a function that takes an array of integers and returns the maximum sum of any contiguous subarray.
 */
public class MaxSubArray {

    public static int getMaxSub(int [] nums){
        //數組為空的處理
        if(nums.length==0){
            return 0;
        }
        // 初始化当前连续子数组的最大和为数组第一个元素
        int currentMax=nums[0]; //
        int globalMax=nums[0];  //初始化全局最大子数组和为数组第一个元素
        for (int i=1;i<nums.length;i++){
            int currentNode=nums[i]; //
            // 计算当前子数组和：将当前元素加到之前的最大连续子数组和上
            int temp=currentMax+currentNode;
            // 判断是否应该延续之前的子数组，还是以当前元素重新开始
            if(temp>currentNode){
                currentMax=temp;// 如果加上当前元素后的和比当前元素大，则延续子数组
            }else {
                currentMax=currentNode;// 否则，从当前元素开始新的子数组
            }
            // 更新全局最大子数组和
            if(currentMax>globalMax){
                globalMax=currentMax;
            }
        }
        return globalMax;
    }

    public static void main(String[] args) {
        int[] arr1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(getMaxSub(arr1));  // 输出: 6

        int[] arr2 = {-1, -2, -3, -4};
        System.out.println(getMaxSub(arr2));  // 输出: -1

        int[] arr3 = {1, 2, 3, 4};
        System.out.println(getMaxSub(arr3));  // 输出: 10

        int[] arr4 = {};
        System.out.println(getMaxSub(arr4));  // 输出: 0
    }

}
