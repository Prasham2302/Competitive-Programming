package com.company;

import java.util.Scanner;

public class Main {

    public static long modularExponentiation(long x, long y, long mod){
        long res = 1;
        x = x % mod;
        if(x == 0){
            return 0;
        }
        while(y>0){
            if((y & 1) != 0){
                res = (res * x) % mod;
            }
            y = y >> 1;
            x = (x * x) % mod;
        }
        return res;
    }
    public static void main(String[] args) {
	// write your code here
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t>0){
            t--;
            int n = scan.nextInt();
            long mod = (long) (Math.pow(10,9) + 7);
            long ans = modularExponentiation(2,n-1,mod);
            System.out.println(ans);
        }
    }
}
