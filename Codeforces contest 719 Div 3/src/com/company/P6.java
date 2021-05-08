package com.company;

import java.util.Scanner;

public class P6 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
            int n = scan.nextInt();
            int t = scan.nextInt();
            int k = scan.nextInt();
            int left = 1;
            int right = n;
            while(left < right){
                int mid = (left + right)/2;
                System.out.println("? " + left +" "+mid);
                System.out.flush();
                int inp = scan.nextInt();
                if(mid - left - inp + 1>= k){
                    right = mid;
                }
                else{
                    left = mid + 1;
                    k -= (mid - left - inp + 1);
                }
            }
            System.out.println("! "+left);

    }
}
