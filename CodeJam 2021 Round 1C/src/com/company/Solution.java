package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for(int test = 1;test<=t;test++){
            int n = scan.nextInt();
            int k = scan.nextInt();
            int[] arr = new int[n+2];
            for(int i = 0;i<n;i++){
                arr[i] = scan.nextInt();
            }
            arr[n] = 1;
            arr[n+1] = k;
            Arrays.sort(arr);
            System.out.println(Arrays.toString(arr));
            int[] diff = new int[n+2];
            for(int i = 1;i<n+2;i++){
                diff[i] = arr[i] - arr[i-1];
            }
            System.out.println(Arrays.toString(diff));
            int a = 1, b =1;
            int max_diff = 0;
            for(int i = 1;i<n+2;i++){
                if(max_diff < diff[i]){
                    a = arr[i-1];
                    b = arr[i];
                    max_diff = diff[i];
                }
            }
            System.out.println(max_diff + " " +a +" "+b);
            System.out.println(b-(a-1));
            if(b-a == 1){
                System.out.println("0.0");
            }
            else {
                double prob = ((double) (b - (a - 1))) / ((double) k);
                System.out.println(prob);
            }
        }
    }
}
