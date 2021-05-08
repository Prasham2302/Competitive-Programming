package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void revese(int[] arr, int l, int r){
        int size = (r-l)/2;
        for(int i = 0;i<=size;i++){
            int temp = arr[i+l];
            arr[i+l] = arr[r-i];
            arr[r-i] = temp;
        }
    }
    public static void main(String[] args) {
	// write your code here
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for(int TestNumber = 1; TestNumber <= t;TestNumber++){
            int n = scan.nextInt();
            int[] arr = new int[n];
            for(int i = 0;i<n;i++){
                arr[i] = scan.nextInt();
            }
            int count = 0;
            for(int i = 0;i < n-1;i++){
                int idx = i;
                for(int j = idx;j<n;j++){
                    if(arr[idx] > arr[j]){
                        idx = j;
                    }
                }
                revese(arr,i,idx);
//                System.out.println(Arrays.toString(arr));
                count += idx-i+1;
            }
            System.out.println("Case #" +TestNumber +": "+count);
        }
    }
}
