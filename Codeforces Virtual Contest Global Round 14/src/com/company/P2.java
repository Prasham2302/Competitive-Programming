package com.company;

import java.util.Scanner;

public class P2 {
    public static boolean isPowerOfTwo(long x){
        return x!= 0 && ((x & (x-1))==0);
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t>0){
            t--;
            long x = scan.nextLong();
            if(x % 2 != 0){
                System.out.println("NO");
            }
            else{
                boolean ans = false;
                if(x % 2 == 0){
                    long temp = x/2;
                    long sqrt = (long) Math.floor(Math.sqrt(temp));
                    if(sqrt*sqrt == temp){
                        ans = true;
                    }
                }
                if(x%4 == 0){
                    long temp = x/4;
                    long sqrt = (long) Math.floor(Math.sqrt(temp));
                    if(sqrt*sqrt == temp){
                        ans = true;
                    }
                }
                if(ans){
                    System.out.println("YES");
                }
                else{
                    System.out.println("NO");
                }
            }
        }
    }
}
