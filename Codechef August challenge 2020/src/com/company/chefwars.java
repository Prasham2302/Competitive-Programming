package com.company;

import java.util.Scanner;

public class chefwars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t>0){
            t--;
            double h = (double) scan.nextInt();
            double p = (double) scan.nextInt();
            while(p>0 && h>0){
                h -= p;
                p = Math.floor(p/2);
            }
            if(h <= 0){
                System.out.println(1);
            }
            else{
                System.out.println(0);
            }
        }
    }
}
