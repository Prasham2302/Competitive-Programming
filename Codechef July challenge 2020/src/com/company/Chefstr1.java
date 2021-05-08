package com.company;

import java.util.Scanner;

public class Chefstr1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t>0){
            t--;
            int n = scan.nextInt();
            int[] arr = new int[n];
            for(int i = 0;i<n;i++){
                arr[i] = scan.nextInt();
            }
            long count = 0;
            for(int i = 0;i<n-1;i++){
                int temp = Math.abs(arr[i]-arr[i+1]);
                temp--;
                count+=temp;
            }
            System.out.println(count);
        }
    }
}
