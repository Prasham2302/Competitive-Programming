package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class P3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t>0) {
            t--;
            int n = scan.nextInt();
            int[] arr = new int[n];
            for(int i = 0;i<n;i++){
                arr[i] = scan.nextInt();
            }
            int ans = Integer.MIN_VALUE;
            int[] dp = new int[n];
            for(int i = n-1;i>=0;i--){
                if(arr[i] + i >= n){
                    dp[i] = arr[i];
                }
                else{
                    dp[i] = dp[arr[i] + i] + arr[i];
                }
                ans = Math.max(dp[i],ans);
            }
            System.out.println(ans);
        }
    }
}
