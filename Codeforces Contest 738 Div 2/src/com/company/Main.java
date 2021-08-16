package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t-->0){
            int n = scan.nextInt();
            long[] arr = new long[n];
            Long max = Long.MIN_VALUE;
            Long min = Long.MAX_VALUE;
            for(int i = 0;i<n;i++){
                arr[i] = scan.nextLong();
                min = Math.min(min, arr[i]);
                max = Math.max(max, arr[i]);
            }
            long ans = Long.MIN_VALUE;
            for(int i = 0;i<n;i++){
                arr[i] = arr[i] & min;
            }
            for(int i = 0;i<n;i++){
                ans = Math.max(arr[i],ans);
            }
            System.out.println(ans);
        }
    }
}
