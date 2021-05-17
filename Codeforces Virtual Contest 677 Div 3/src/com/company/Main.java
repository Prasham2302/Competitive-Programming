package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        Scanner scan = new Scanner(System.in);
//        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
//        int t = Integer.parseInt(br.readLine());
        int t = scan.nextInt();
        while(t>0){
            t--;
            int n = scan.nextInt();
            int len = Integer.toString(n).length();
            int a = (int) (10*(n%10 - 1) + Math.floor(len*(len+1)/2));
            System.out.println(a);
        }
    }
}
