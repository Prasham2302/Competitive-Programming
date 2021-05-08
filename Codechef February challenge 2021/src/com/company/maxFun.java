package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class maxFun {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t>0){
            t--;
            int n = scan.nextInt();
            long[] arr = new long[n];
            for(int i = 0;i<n;i++){
                arr[i] = scan.nextLong();
            }
            Arrays.sort(arr);
            long x = arr[0];
            long y = arr[1];
            long z = arr[arr.length-1];
            long ans = Math.abs(x-y) + Math.abs(z-x) + Math.abs(y-z);
            System.out.println(ans);
        }
    }
}
