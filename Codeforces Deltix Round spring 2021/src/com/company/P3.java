package com.company;

import java.util.Scanner;
import java.util.Stack;

public class P3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t>0) {
            t--;
            int n = scan.nextInt();
            int[] arr = new int[n];
            for(int i = 0;i<n;i++){
                arr[i] = scan.nextInt();
            }
            Stack<Integer> stack = new Stack<>();
            stack.push(arr[0]);
            System.out.println(arr[0]);
            for(int i = 1;i<n;i++){
//                System.out.println(stack);
//                System.out.println(arr[i]);

                if(arr[i] != 1){
                    while(stack.peek() != (arr[i]-1)){
                        stack.pop();
                    }
                    stack.pop();
                }
                stack.push(arr[i]);
                print(stack);
            }
        }
    }

    private static void print(Stack<Integer> stack) {
        for(int i = 0;i<stack.size()-1;i++){
            System.out.print(stack.get(i)+".");
        }
        System.out.println(stack.get(stack.size()-1));
    }
}
