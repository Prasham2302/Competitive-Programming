package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class p1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for(int test = 1;test<=t;test++) {
            int n = scan.nextInt();
            int k = scan.nextInt();
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scan.nextLong();
            }
            long s1 = 0, s2 = 0;
            Arrays.sort(arr);
            if(arr[0] != 1){
                s1 = arr[0] -1;
            }
            ArrayList<Long> temp = new ArrayList<>();
            for(int i = 1;i<n;i++){
                temp.add(arr[i] - arr[i-1] - 1);
            }
            if(arr[n-1] != k){
                s2 = k - arr[n-1];
            }
            long ans1 = Math.max(s1,s2);
            long add1 = 0;
//            System.out.println(temp);
            for(int i  =0;i<temp.size();i++){
                add1 = Math.max(add1,(temp.get(i) + 1)/2);
            }
//            System.out.println(add1);
            ans1+=add1;
            long ans = ans1;
            for(int i = 0;i<temp.size();i++){
                ans = Math.max(ans,temp.get(i));
            }
            String result = String.format("%.6f", ((double) ans / (double) k));
            System.out.println("Case #" + test+": "+result);
        }
    }
}
