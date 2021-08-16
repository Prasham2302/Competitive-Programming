package com.company;

import java.util.Scanner;

public class EITA {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t>0){
            t--;
            int d = scan.nextInt();
            int x = scan.nextInt();
            int y = scan.nextInt();
            int z = scan.nextInt();
            int a = x * 7;
            int b = y * d + (7 - d)*z;
            System.out.println(Math.max(a,b));
        }
    }
}
