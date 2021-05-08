package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t>0){
            t--;
            long n = scan.nextLong();
            long m = scan.nextLong();
            long x = scan.nextLong();
            long row = x%n;
            long col = (long) Math.floor(x/n);
//            System.out.println(row +" "+col);
            if(row == 0)
                System.out.println(m*(n-1) + col);
            else{
                row--;
                System.out.println(m*row + col + 1);
            }
        }
    }
}
