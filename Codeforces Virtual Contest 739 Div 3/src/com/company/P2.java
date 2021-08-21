package com.company;

import java.util.Scanner;

public class P2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t-- >0){
            int a = scan.nextInt();
            int b = scan.nextInt();
            int c = scan.nextInt();
            int diff = Math.abs(a-b);
            int maxPossible = 2 * diff;

            if(maxPossible < a || maxPossible < b || c > maxPossible){
                System.out.println(-1);
                continue;
            }
            if(c - diff <= 0){
                System.out.println(diff + c);
            }
            else{
                System.out.println(c - diff);
            }

        }
    }
}
