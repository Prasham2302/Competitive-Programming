package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class P3 {
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
            boolean isDeacreasing = false;
            int i = n-1;
            while(i >= 1){
//                System.out.println(i);
                if(isDeacreasing) {
                    if (arr[i] >= arr[i - 1]) {
                        //downhill
                        i--;
                    }
                    else{
                        break;
                    }
                }
                else{
                    if(arr[i] > arr[i-1]){
                        isDeacreasing = true;
                        i--;
                    }
                    else{
                        i--;
                    }
                }
            }

            System.out.println((i));
        }
    }
}
