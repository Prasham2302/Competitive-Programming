package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class spacearr {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t>0){
            t--;
            int n = scan.nextInt();
            int[] arr = new int[n];
            boolean first = false;
            for(int i = 0;i<n;i++){
                arr[i] = scan.nextInt();

            }
            Arrays.sort(arr);
            for(int i = 0;i<n;i++){
                if(arr[i] > (i+1)){
                    first = true;
                }
            }
            if(first == true){
                System.out.println("Second");
            }
            else{
                int sum = 0;
                for(int i = 0;i<n;i++){
                    sum += Math.abs(arr[i] - i - 1);
                }
                if(sum % 2 == 0){
                    System.out.println("Second");
                }
                else{
                    System.out.println("First");
                }
            }
        }
    }
}
