package com.company;

import java.util.Scanner;

public class P4 {
    public static long sum(long num){
        long sum = 0;
        while(num > 0){
            sum += num%10;
            num /= 10;
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t>0){
            t--;
            long n = scan.nextLong();
            long x = scan.nextLong();

            long mod = 1;
            long multiplier = 1;
            long count = 0;
            while(sum(n) > x){
                long curr = (long) (n / multiplier) % 10;
                long to_add = multiplier * ((10-curr)%10);
                n += to_add;
                mod += 1;
                count += to_add;
                multiplier = multiplier * 10;
            }
            System.out.println(count);
        }
    }
}
