package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t>0){
            t--;
            long r = scan.nextLong();
            long b = scan.nextLong();
            long d = scan.nextLong();
            long x = Math.min(r,b);
            long y= Math.max(r,b);
            if(d == 0){
                if(x == y){
                    System.out.println("YES");
                }
                else{
                    System.out.println("NO");
                }
            }
            else {
                if ((y-x) <= (x*d)) {
                    System.out.println("YES");
                }
                else{
                    System.out.println("NO");
                }
            }

        }
    }
}
