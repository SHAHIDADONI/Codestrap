package Arrays;
import java.util.*;
import java.lang.*;
import java.io.*;

class SubarrayWithGivenSum {
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        int N = scn.nextInt();
        int givenSum = scn.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scn.nextInt();
        }
        //subarrayGivenSum(arr,givenSum);
        subarrayGivenSumSlidingWindow(arr,givenSum);
    }

    //Brute force O(n2)
    public static void subarrayGivenSum(int[] arr,int givenSum){
        for(int i=0;i<arr.length;i++){
            int currSum=arr[i];
            for(int j=i+1;j<=arr.length;j++) {
                if (currSum == givenSum) {
                    System.out.println(i + "-->" + (j - 1));
                    return ;
                }
                if (currSum > givenSum) {
                    break;
                }
                currSum += arr[j];
            }
        }
        System.out.println("No subarray with given sum");
        return ;
    }

    //Sliding Window O(n)
    public static void subarrayGivenSumSlidingWindow(int[] arr,int givenSum){
        int l=0,r,currSum = arr[0];
        for( r=1;r<=arr.length;r++){

            while(currSum>givenSum && l<r-1){
                currSum-=arr[l];
                l++;
            }
            if (currSum == givenSum) {
                System.out.println( l+ "-->" + (r - 1));
                return ;
            }
            if(r<arr.length) {
                currSum += arr[r];
            }
        }
        System.out.println("No subarray with given sum");
        return ;

    }

}



/*
Given an unsorted array of non-negative integers, find a continuous subarray which adds to a given number.
Examples :

Input: arr[] = {1, 4, 20, 3, 10, 5}, sum = 33
Output: Sum found between indexes 2 and 4
Sum of elements between indices
2 and 4 is 20 + 3 + 10 = 33

Input: arr[] = {1, 4, 0, 0, 3, 10, 5}, sum = 7
Output: Sum found between indexes 1 and 4
Sum of elements between indices
1 and 4 is 4 + 0 + 0 + 3 = 7

Input: arr[] = {1, 4}, sum = 0
Output: No subarray found
There is no subarray with 0 sum
 */
