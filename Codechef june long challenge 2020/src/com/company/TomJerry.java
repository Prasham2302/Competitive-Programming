package com.company;

import java.util.Scanner;

public class TomJerry {
    public static long countDivisibles(long B, long A, long M)
    {
        // Add 1 explicitly as A is divisible by M
        if (A % M == 0)
            return (B / M) - (A / M) + 1;

        // A is not divisible by M
        return (B / M) - (A / M);
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t>0){
            t--;
            long ts = scan.nextLong();
            long ans = 0;
            if(ts % 2 == 1){
                //ts is odd
                ans = ts/2;
            }
            else{
                //ts is odd
                long count = 1;
                long temp = ts;
                while(temp%2==0){
                    count*=2;
                    temp/=2;
                }
//                System.out.println(count);
                if(count>ts){
                    ans = 0;
                }
                else {
                    ans = countDivisibles(ts, count, count * 2);
                }
            }
            System.out.println(ans);
        }
    }
}
