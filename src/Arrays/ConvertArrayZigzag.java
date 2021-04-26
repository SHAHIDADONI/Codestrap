package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class ConvertArrayZigzag {
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        int N = scn.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scn.nextInt();
        }
//        int[] A = zigZag(arr);
//        for(int i =0;i<A.length;i++){
//            System.out.print(A[i]+" ");
//        }
        zigZag2(arr);
        System.out.println(Arrays.toString(arr));
    }

    //Sorting method O(nlogn)
    public static int[] zigZag(int[]arr){
        Arrays.sort(arr);
        for(int i=1;i<arr.length;i+=2){
            if((i+1)>=arr.length){
                break;
            }
            int temp = arr[i];
            arr[i]=arr[i+1];
            arr[i+1]=temp;
        }
        return arr;
    }

    //flag method O(n). if flag is true then it means arr[i] should be less than next element i.e. arr[i]<arr[i+1]
    // ans flag false means vice versa. At the end of each iteration reverse flag.
    public static void zigZag2(int[] arr)
    {
        boolean flag = true;
        int temp =0;

        for (int i=0; i<=arr.length-2; i++)
        {
            if (flag)
            {
                if (arr[i] > arr[i+1])
                {
                    temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            } else {
                if (arr[i] < arr[i+1])
                {
                    temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }
            flag = !flag; /* flip flag */
        }
    }
}
/*
https://www.geeksforgeeks.org/convert-array-into-zig-zag-fashion/
Convert array into Zig-Zag fashion
Difficulty Level : Easy
Last Updated : 31 Aug, 2020
Given an array of DISTINCT elements, rearrange the elements of array in zig-zag fashion in O(n) time. The converted array should be in form a < b > c < d > e < f.
Example:

Input: arr[] = {4, 3, 7, 8, 6, 2, 1}
Output: arr[] = {3, 7, 4, 8, 2, 6, 1}

Input: arr[] = {1, 4, 3, 2}
Output: arr[] = {1, 4, 2, 3}
 */
