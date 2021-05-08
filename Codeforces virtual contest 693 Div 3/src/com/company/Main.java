package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scan = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = scan.nextInt();
        while(t>0){
            t--;
            int w = scan.nextInt();
            int h = scan.nextInt();
            int n = scan.nextInt();
            long count = 1;
            while(w%2 == 0 || h%2==0){
                if(w%2 == 0){
                    w = w/2;
                    count *= 2;
                }
                if(h%2 == 0){
                    h = h/2;
                    count *= 2;
                }
            }
            if(count >= n){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }
    }
}
