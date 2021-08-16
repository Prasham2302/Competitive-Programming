package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class p3 {

    public static void main(String[] args) {
        //        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t>0){
            t--;
            int n = scan.nextInt();
            int l = scan.nextInt();
            int r = scan.nextInt();
            int[] arr = new int[n];
            for(int i = 0;i<n;i++){
                arr[i] = scan.nextInt();
            }
            int count = 0;
            Arrays.sort(arr);
            int left = 0;
            int right = arr.length-1;

            System.out.println(count);
        }

    }
}
