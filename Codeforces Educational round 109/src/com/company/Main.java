package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t>0){
            t--;
            int k = scan.nextInt();
            int temp = gcd(100,k);
            System.out.println(100/temp);
        }
    }

    private static int gcd(int i, int k) {
        if( k == 0){
            return i;
        }
        return gcd(k, i%k);
    }
}
