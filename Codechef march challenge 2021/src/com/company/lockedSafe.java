package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class lockedSafe {
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
            ArrayList<Long> distinct = new ArrayList<>();
            distinct.add(arr[0]);
            for(int i = 1;i<n;i++){
                long curr = arr[i];
                long prev = distinct.get(distinct.size()-1);
                if(prev == 0 && curr == 0){
                    distinct.add(curr);
                }
                else if(prev != curr){
                    distinct.add(curr);
                }
            }
            int zeros = 0;
            for(int i = 0;i<distinct.size();i++){
                if(distinct.get(i) == 0){
                    zeros++;
                }
            }
            int count = distinct.size();
            count = count * (count+1)/2 - (count - zeros);
            System.out.println(count);
        }
    }
}
