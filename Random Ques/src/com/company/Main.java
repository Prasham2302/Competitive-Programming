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
            boolean isNeg = false;
            int[] arr = new int[n];
            for(int i = 0;i<n;i++){
                arr[i] = scan.nextInt();
                if(arr[i]<0){
                    isNeg = true;
                }
            }
            if(isNeg){
                System.out.println("NO");
            }
            else{
                System.out.println("YES");
                System.out.println(101);
                for(int i = 0;i<=100;i++){
                    System.out.print(i+" ");
                }
                System.out.println();
            }
        }
    }
}
