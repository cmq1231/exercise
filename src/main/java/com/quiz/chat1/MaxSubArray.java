package com.quiz.chat1;

/**
 *  1: Arrays
 Write a function that takes an array of integers and returns the maximum sum of any contiguous subarray.
 */
public class MaxSubArray {

    public static int getMaxSub(int [] arrays){
        if(arrays.length==0){
            return 0;
        }
        int currentMax=arrays[0];
        int globalMax=arrays[0];
        for (int i=1;i<arrays.length;i++){
            int currentNode=arrays[i];
            int temp=currentMax+currentNode;
            if(temp>currentNode){
                currentMax=temp;
            }else {
                currentMax=currentNode;
            }
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
