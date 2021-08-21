package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class P4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t-- > 0){
            long p =scan.nextLong();
            ArrayList<Long> arr = new ArrayList<>();
            for(int i = 0;i<p;i++){
                arr.add(scan.nextLong());
            }
            if(p <= 2){
                System.out.println(p);
                continue;
            }
            Collections.sort(arr);
            System.out.println(arr);
            HashSet<Long> diff = new HashSet<>();
            for(int i = 1;i<p;i++){
                diff.add(Math.abs(arr.get(i) - arr.get(i-1)));
            }
            diff.remove(1);
            diff.remove(0);
            int ans = 2;
            for(Long x : diff){
                if(x < 2){
                    continue;
                }
                int count = 0;
                for(int i = 0;i<p;i++){
                    if(arr.get(i) % x == 0){
                        count++;
                    }
                }
                ans = Math.max(count, ans);
            }

            System.out.println(ans);
        }
    }
}
