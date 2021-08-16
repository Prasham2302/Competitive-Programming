package com.company;

import java.util.Scanner;
import java.util.Stack;

public class P4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t>0){
            t--;
            int n = scan.nextInt();
            long[] arr = new long[n];
            for(int i = 0;i<n;i++){
                arr[i] = scan.nextLong();
            }
            long curr = arr[0] ^ 0;
            long[] ans = new long[n];
            Stack<Long> stack = new Stack<>();
            stack.push(arr[0]);
            for(int i = 1;i<n;i++){
                if((stack.peek() & arr[i]) == stack.peek()){
                    stack.push(arr[i]);
                    ans[i] = 0;
                }
                else{
                    long a = stack.peek();
                    long b = arr[i];
                    long req = 0;
                    long shift = 0;
                    while(a > 0){
                        long temp = a & b & 1;
                        if(temp == 0){
                            if(b % 2 == 0 && a % 2 != 0){
                                req += (1 << shift);
                            }
                        }
                        shift++;
                        a >>= 1;
                        b >>= 1;
                    }
                    ans[i] = req;
                    stack.push(arr[i] ^ req);
                }
            }
            for(int i = 0;i<n;i++){
                System.out.print(ans[i]+" ");
            }
            System.out.println();
        }
    }
}
