package com.company;

import java.util.HashMap;
import java.util.Scanner;

public class p3 {
    public static int generate(int size){
        int num = 1;
        while(size > 0){
            num = num * 10 + 1;
            size--;
        }
        return num;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t>0){
            t--;
            int n = scan.nextInt();
            int len = 3;
            boolean passed = true;
            while(len > 2){
                len = Integer.toString(n).length();
                int num = generate(len);
                if(num > n){
                    num /= 10;
                    n -= num;
                }
                else{
                    if(n%num == 0){
                        passed = true;
                    }
                    else{
                        n %= num;
                    }
                }
            }
            len = Integer.toString(n).length();
            if(passed){
                System.out.println("YES");
            }
            else{
                if(n % generate(len) == 0){
                    System.out.println("YES");
                }
                else{
                    System.out.println("NO");
                }
            }
        }
    }
}
