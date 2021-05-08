package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        // write your code here
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t>0){
            t--;
            int n = scan.nextInt();
            int a = 0;
            int b = 0;
            int curr = 1;
            ArrayList<Integer> arr = new ArrayList<>();
            for(int i = 0;i<n;i++){
                curr = curr*2;
                arr.add(curr);
//                System.out.println("curr "+curr);
            }
            for(int i = 0;i<arr.size();i++){
                if(i<n/2-1){
                    a+=arr.get(i);
                }
                else if(i<arr.size()-1){
                    b+=arr.get(i);
                }
                else{
                    a+=arr.get(i);
                }
            }
//            System.out.println(a+" "+b);
            System.out.println(Math.abs(a-b));
        }
    }
}
