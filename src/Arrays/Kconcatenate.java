package Arrays;
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        int N = scn.nextInt();
        int K = scn.nextInt();
        int[] arr1 = new int[N];
        for(int i=0;i<N;i++){
            arr1[i] = scn.nextInt();
        }
        int[] arr2 = new int[N*K];
        for(int i=0;i<N*K;i++){
            arr2[i]=arr1[i%N];
        }
        System.out.println(kConcatenate(arr2));
        System.out.println(kConcatenateKadane(arr2));
        System.out.println(kConcatenateKadaneKMinusTwo(arr1,K));
    }

    //Brute force. O((m*k)2)=>O(n2)
    public static int kConcatenate(int[]arr){
        int currSum,maxSum= Integer.MIN_VALUE;
        for(int i=0;i<arr.length-1;i++){
            currSum = arr[i];
            for(int j=i+1;j<arr.length;j++){
                currSum+=arr[j];
                if(maxSum<currSum) {
                    maxSum = currSum;
                }
            }

        }
        return maxSum;
    }

    //Kadane's algorithm. O(m*K)=>O(n)
    public static int kConcatenateKadane(int[]arr){
        int currSum=0,maxSum= Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            currSum+=arr[i];
            if(currSum<0) {
                currSum = 0;
            }
            if(maxSum<currSum) {
                maxSum = currSum;
            }

        }

        return maxSum;
    }

    //maxsum of 2 times arr + (k-2)*sum of arr using kadanes in within it. O(

    public static int kConcatenateKadaneKMinusTwo(int[]arr,int K){
        int sumOfArray =0;
        int result;
        for(int i=0;i< arr.length;i++){
            sumOfArray+=arr[i];
        }
        if(K>1){
           int[] arrTwoTimes = new int[2*arr.length];
            for(int i=0;i<arr.length*2;i++){
                arrTwoTimes[i]=arr[i%arr.length];
            }
            if(sumOfArray<0){
                result = kConcatenateKadane(arrTwoTimes);
            }else {
                result = kConcatenateKadane(arrTwoTimes) + (K - 2) * sumOfArray;
            }
        }else{
            result = kConcatenateKadane(arr);
        }
        return result;
    }

}


/*
https://www.geeksforgeeks.org/maximum-subarray-sum-array-created-repeated-concatenation/

You are given an array A with size N (indexed from 0) and an integer K.
Let's define another array B with size N · K as the array that's formed by concatenating K copies of array A.

For example, if A = {1, 2} and K = 3, then B = {1, 2, 1, 2, 1, 2}.

You have to find the maximum subarray sum of the array B.
Fomally, you should compute the maximum value of Bi + Bi+1 + Bi+2 + ... + Bj, where 0 ≤ i ≤ j < N · K.

Input
The first line of the input contains a single integer T denoting the number of test cases. The description of T test cases follows.
The first line of each test case contains two space-separated integers N and K.
The second line contains N space-separated integers A0, A1, ..., AN-1.
Output
For each test case, print a single line containing the maximum subarray sum of B.

Constraints
1 ≤ T ≤ 10
1 ≤ N ≤ 105
1 ≤ K ≤ 105
-106 ≤ Ai ≤ 106 for each valid i
Subtasks
Subtask #1 (18 points): N · K ≤ 105

Subtask #2 (82 points): original constraints

Example
Input:

2
2 3
1 2
3 2
1 -2 1

Output:

9
2
Explanation
Example case 1: B = {1, 2, 1, 2, 1, 2} and the subarray with maximum sum is the whole {1, 2, 1, 2, 1, 2}. Hence, the answer is 9.

Example case 2: B = {1, -2, 1, 1, -2, 1} and the subarray with maximum sum is {1, 1}. Hence, the answer is 2.

 */

