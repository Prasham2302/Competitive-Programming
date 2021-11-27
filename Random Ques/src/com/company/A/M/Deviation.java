package com.company.A.M;

import java.util.Arrays;
import java.util.Scanner;

public class Deviation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t>0){
            t--;
            long[] arr = new long[3];
            boolean isOdd = false;
            for(int i = 0;i<3;i++){
                arr[i] = scan.nextLong();
                if(arr[i] % 2 == 1){
                    isOdd = true;
                }
            }
            long curr = Math.abs(arr[0] + arr[2] - 2 * arr[1]);
            if(curr % 3 == 0){
                System.out.println(0);
            }
            else{
                System.out.println(1);
            }
        }
    }
}
