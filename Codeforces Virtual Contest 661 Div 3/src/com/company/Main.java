package com.company;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t>0){
            t--;
            int n = scan.nextInt();
            int[] arr = new int[n];
            int[] diff = new int[n];
            for(int i = 0;i<n;i++){
                arr[i] = scan.nextInt();
            }
            Arrays.sort(arr);
            int max = 0;
            for(int i = 1;i<n;i++){
                diff[i] = Math.abs(arr[i] - arr[i-1]);
                max = Math.max(max, diff[i]);
            }
            if(max>1){
                System.out.println("NO");
            }
            else{
                System.out.println("YES");
            }



        }
    }
}
