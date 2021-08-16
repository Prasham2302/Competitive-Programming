package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class P3 {
    public static void main(String[] args) {
        //        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t>0){
            t--;
            int n = scan.nextInt();
            long[] arr = new long[n];
            long[] pref = new long[n];
            for(int i = 0;i<n;i++){
                arr[i] = scan.nextLong();
            }
            Arrays.sort(arr);
            for(int i = 1;i<n;i++){
                pref[i] += pref[i-1] + arr[i];
            }
            long count = 0;
            for(int i = 2;i<n;i++){
                count += pref[i-2] - (i-1) * arr[i];
            }
            System.out.println(count);

        }
    }
}
