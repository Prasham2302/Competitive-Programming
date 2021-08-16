package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t>0){
            t--;
            int xa = scan.nextInt();
            int xb = scan.nextInt();
            int XA = scan.nextInt();
            int XB = scan.nextInt();
            int count = (int) Math.ceil(XA/xa);
            count += Math.ceil(XB/xb);
            System.out.println(count);

        }
    }
}
