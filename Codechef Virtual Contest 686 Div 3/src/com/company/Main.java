package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t > 0){
            t--;
            int n = scan.nextInt();
            int[] arr = new int[n];
            int count = n;
            for(int i = 0;i<n;i++){
                arr[i] = count;
                count--;
            }
            for(int i = 0;i<n;i++){
                if(arr[i] == i+1){
                    arr[i] = arr[n-1];
                    arr[n-1] = i+1;
                }
            }
            for(int i = 0;i<n;i++){
                System.out.print(arr[i] +" ");
            }
            System.out.println();
        }

    }
}
