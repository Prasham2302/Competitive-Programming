package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class P2 {
    public static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t>0){
            t--;
            int n = scan.nextInt();
            int[] arr = new int[n];
            int max = Integer.MIN_VALUE;
            for(int i = 0;i<n;i++){
                arr[i] = scan.nextInt();
                max = Math.max(max, arr[i]);
            }
            ArrayList<String> ans = new ArrayList<>();
            for(int i = 1;i<n;i++){
                while(gcd(arr[i],arr[i-1]) != 1){
                    if(arr[i] < arr[i-1]){
                        arr[i-1] = max + 1;
                        max++;
                    }
                    else{
                        arr[i] = max + 1;
                        max++;
                    }
                    ans.add((i+1) +" "+ (i) +" "+arr[i] +" "+(arr[i-1]));
                }
            }
            if(ans.size() == 0){
                System.out.println(0);
            }
            else {
                System.out.println(ans.size());
                for (int i = 0; i < ans.size(); i++) {
                    System.out.println(ans.get(i));
                }
            }

        }
    }
}
