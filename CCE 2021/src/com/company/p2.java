package com.company;

import java.util.Scanner;

public class p2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long x = scan.nextLong();
        long y = scan.nextLong();
//        System.out.println(3);
        long curr = x ;
        int count = 0;
        while(curr<=y){
            count++;
            curr *=2;
        }
        System.out.println(count);
    }
}
