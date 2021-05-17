package com.company;

import java.util.Scanner;

public class P3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t>0){
            t--;
            int n = scan.nextInt();
            int ans = Integer.MAX_VALUE;
            for(int i = 1;i<=Math.sqrt(n);i++){
                ans = Math.min(ans, i - 1 + (n-1)/i);
            }
            System.out.println(ans);
        }
    }
}
