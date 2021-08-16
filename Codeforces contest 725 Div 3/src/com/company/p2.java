package com.company;

import java.util.Scanner;

public class p2 {
    public static void main(String[] args) {
        //        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t>0){
            t--;
            int n = scan.nextInt();
            int[] arr = new int[n];
            int sum = 0;
            for(int i = 0;i<n;i++){
                arr[i] = scan.nextInt();
                sum += arr[i];
            }
            if(sum % n != 0){
                System.out.println("-1");
            }
            else{
                int rem = sum / n;
//                System.out.println(rem);
                int count = 0;
                for(int i = 0;i<n;i++){
                    if(arr[i] > rem){
                        count++;
                    }
                }
                System.out.println(count);
            }
        }

    }
}
