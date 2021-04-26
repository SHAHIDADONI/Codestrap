package Arrays;

import java.util.Scanner;

public class EquilibriumIndex {
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        int N = scn.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println(equilibriumIndexBrute(arr,N));
        System.out.println(equilibriumIndex(arr));
        System.out.println(equilibriumIndex2(arr));
    }
    //Brute force O(n2)
    public static int equilibriumIndexBrute(int arr[], int n)
    {
        int i, j;
        int leftsum, rightsum;

        for (i = 0; i < n; ++i) {
            leftsum = 0;
            for (j = 0; j < i; j++)
                leftsum += arr[j];

            rightsum = 0;
            for (j = i + 1; j < n; j++)
                rightsum += arr[j];

            if (leftsum == rightsum)
                return i;
        }

        return -1;
    }
    //Calculate sumofarray then in next for loop minus this sumofarray with the current index i.e. we have right sum in the form of sumofarray
    // and calculate left sum by adding current index to leftsum. Atlast check sumofarray with leftsum.O(n+n)=O(2n)=O(n).
    private static int equilibriumIndex(int[] arr) {
        int leftSum = 0,sumOfarray = 0;
        for(int i=0;i<arr.length;i++){
            sumOfarray+=arr[i];
        }
        for(int i=0;i<arr.length;i++){
            sumOfarray-=arr[i];

            if(sumOfarray==leftSum){
                return i;
            }
            leftSum+=arr[i];
        }
        return -1;
    }

    //same approach as last but with O(n) space and O(n) TC. Creating sum array and performing sum[i] minus arr[i] for left sum
    //and sum[n]-sum[i] for right sum at particular index i.
    private static int equilibriumIndex2(int[] arr) {
        int [] sum = new int[arr.length];
        int leftSum = 0,rightSum=0,sumOfarray = 0;
        for(int i=0;i<arr.length;i++){
            sumOfarray+=arr[i];
            sum[i]=sumOfarray;
        }
        for(int i=0;i<arr.length;i++){
            leftSum=sum[i]-arr[i];
            rightSum=sum[arr.length-1]-sum[i];

            if(rightSum==leftSum){
                return i;
            }
        }
        return -1;
    }
}
/*
https://www.geeksforgeeks.org/equilibrium-index-of-an-array/
Equilibrium index of an array
Difficulty Level : Easy
Last Updated : 07 Apr, 2021
Equilibrium index of an array is an index such that the sum of elements at lower indexes is equal to the sum of elements at higher indexes. For example, in an array A:

Example :

Input: A[] = {-7, 1, 5, 2, -4, 3, 0}
Output: 3
3 is an equilibrium index, because:
A[0] + A[1] + A[2] = A[4] + A[5] + A[6]

Input: A[] = {1, 2, 3}
Output: -1
 */
