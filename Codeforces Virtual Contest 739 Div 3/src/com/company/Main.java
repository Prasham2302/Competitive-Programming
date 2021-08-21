package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t-- >0){
            int k = scan.nextInt();
            int num = 1;
            int count = 1;
            while(count < k){
                num++;
                if(num%3==0 || num%10 == 3){
                    continue;
                }
                count++;
            }
            System.out.println(num);
        }
    }
}
