package Arrays;
import java.sql.SQLOutput;
import java.util.*;
import java.lang.*;
import java.io.*;

public class CicularMaxSubarraySum {
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        int N = scn.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println(circularMaxSubarraySum(arr));
    }
    public static int circularMaxSubarraySum(int[] arr){
        int maximumSum=Integer.MIN_VALUE,currMax=0,minimumSum=Integer.MAX_VALUE,currMin=0,sumOfArray=0;
        for(int i=0;i<arr.length;i++){
            sumOfArray+=arr[i];
            currMax+=arr[i];
            if(currMax<0) {
                currMax = 0;
            }
            if(maximumSum<currMax) {
                maximumSum = currMax;
            }
            currMin+= arr[i];
            if(currMin>0) {
                currMin = 0;
            }
            if(minimumSum>currMin) {
                minimumSum = currMin;
            }
        }
        if(sumOfArray==minimumSum){
            return maximumSum;
        }else{
            return Math.max(maximumSum,(sumOfArray-minimumSum));
        }
    }
}
/*
7
8 -8 9 -9 10 -11 12
8
10 -3 -4 7 6 5 -4 -1
8
-1 40 -14 7 6 5 -4 -1
https://www.youtube.com/watch?v=Q1TYVUEr-wY
https://www.geeksforgeeks.org/maximum-contiguous-circular-sum/
Maximum circular subarray sum
Difficulty Level : Hard
Last Updated : 14 Apr, 2021
Given n numbers (both +ve and -ve), arranged in a circle, fnd the maximum sum of consecutive number.
Examples:

Input: a[] = {8, -8, 9, -9, 10, -11, 12}
Output: 22 (12 + 8 - 8 + 9 - 9 + 10)

Input: a[] = {10, -3, -4, 7, 6, 5, -4, -1}
Output:  23 (7 + 6 + 5 - 4 -1 + 10)

Input: a[] = {-1, 40, -14, 7, 6, 5, -4, -1}
Output: 52 (7 + 6 + 5 - 4 - 1 - 1 + 40)
 */