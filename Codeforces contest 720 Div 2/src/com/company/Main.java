package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scan = new Scanner(System.in);
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = scan.nextInt();
        while(t>0){
            t--;
            long a = scan.nextLong();
            long b = scan.nextLong();
            long z = a*b*2;
            long x = a*(b-1);
            long y = z - x;
            if(x == z || y == z){
                System.out.println("NO");
            }
            else {
                System.out.println("YES");
                System.out.println(x + " " + y + " " + z);
            }

        }
    }
}
