package com.company;

import java.util.Scanner;

public class P2 {
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
            boolean sorted = true;
            for(int i = 1;i<n;i++){
                if(arr[i-1] > arr[i]){
                    sorted = false;
                    break;
                }
            }
            if(sorted){
                System.out.println(0);
            }
            else{
                if(arr[0] == 1 || arr[n-1] == n){
                    System.out.println(1);
                }
                else if(arr[0] == n && arr[n-1] == 1){
                    System.out.println(3);
                }
                else{
                    System.out.println(2);
                }
            }
        }
    }
}
