package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class modeq {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t>0){
            t--;
            int n = scan.nextInt();
            int m = scan.nextInt();
            long count = 0;
            long[] store = new long[n+1];
            Arrays.fill(store,1);
            for(int i = 2;i<=n;i++){
                int x = m % i;
                count += store[x];
                for(int b = x;b <= n;b+=i){
                    store[b]++;
                }
            }
            System.out.println(count);
        }
    }
}
