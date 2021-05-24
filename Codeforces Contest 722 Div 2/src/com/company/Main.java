package com.company;

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
            int min = Integer.MAX_VALUE;
            for(int i = 0;i<n;i++){
                arr[i] = scan.nextInt();
                min = Math.min(arr[i],min);
            }

            int count = 0;
            for(int i = 0;i<n;i++){
                if(arr[i] > min){
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
