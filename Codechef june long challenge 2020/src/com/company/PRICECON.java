package com.company;

import java.util.Scanner;

public class PRICECON {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t>0){
            t--;
            int n = scan.nextInt();
            int k = scan.nextInt();
            int[] arr = new int[n];
            int sum = 0;
            int count = 0;
            for(int i = 0;i<n;i++){
                arr[i] = scan.nextInt();
                count+=arr[i];
                if(arr[i]>k){
                    arr[i] = k;
                }
                sum+=arr[i];
            }
            System.out.println(count-sum);

        }
    }
}
