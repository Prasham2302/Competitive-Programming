package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t>0){
            t--;
            int a = scan.nextInt();
            int b = scan.nextInt();
            int diff = Math.abs(b - a);
            int count = diff / 10;
            if(diff%10 != 0){
                count++;
            }
            System.out.println(count);
        }
    }
}
