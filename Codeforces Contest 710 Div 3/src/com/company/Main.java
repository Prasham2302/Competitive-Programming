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
            long col = x%n;
            long row = x/n;
            row++;
            col--;
            if(col == -1){
                col = n;
            }
            System.out.println(row + " "+ col);
            long count = col*m  + row;
            System.out.println(count);
        }
    }
}
