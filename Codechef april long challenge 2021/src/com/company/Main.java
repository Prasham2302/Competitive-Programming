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
            if(n == 1){
                System.out.println(20);
            }
            else if(n == 2){
                System.out.println(36);
            }
            else if(n == 3){
                System.out.println(51);
            }
            else if(n == 4){
                System.out.println(60);
            }
            else {
                long a = ((long) n/4) * 44;
                if(n%4 == 0)
                    a += 16;
                else if(n%4 == 1)
                    a += 32;
                else if(n%4 == 2)
                    a += 44;
                else if(n%4 == 3)
                    a += 55;
                System.out.println(a);
            }
        }
    }
}
