package com.company;

import java.util.HashMap;
import java.util.Scanner;

public class ISS {
    public static long gcd(long a, long b){
        if(b == 0){
            return a;
        }
        return gcd(b,a%b);
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t>0){
            t--;
            long k = scan.nextLong();
            long count = 0;
            for(int j = 1;j<=2*k;j++){
//                System.out.println(k + j*j);
                count += (gcd(k+j*j, k + (j+1)*(j+1)));

            }
            System.out.println(count);
        }

    }
}
