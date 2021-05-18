package com.company;

import java.util.Scanner;

public class P2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t>0){
            t--;
            long a = scan.nextLong();
            long b = scan.nextLong();
            long x = scan.nextLong();
            long y = scan.nextLong();
            long n = scan.nextLong();
            if(b == y && a == x){
                System.out.println(a*b);
            }
            else{
                long a1 = Math.max(a-n,x);
                long b1 = Math.max(b-n+a-a1, y);
                long b2 = Math.max(b-n,y);
                long a2 = Math.max(a-n+b-b2, x);
                System.out.println(Math.min(a1*b1, a2*b2));
            }

        }
    }
}
