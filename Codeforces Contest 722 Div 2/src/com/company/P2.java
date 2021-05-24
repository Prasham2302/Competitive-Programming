package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class P2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t>0) {
            t--;

            int n = scan.nextInt();
            long[] arr = new long[n];
            long count = 0;

            long zero = 0;
            long positive = 0;
            long negative = 0;
            ArrayList<Long> negs = new ArrayList<>();
            long minPositive = Long.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                arr[i] = scan.nextLong();
                if(arr[i] == 0){
                    zero++;
                }
                else if(arr[i] > 0){
                    positive++;
                    minPositive = Math.min(minPositive, arr[i]);
                }
                else{
                    negs.add(arr[i]);
                    negative++;
                }
            }

            count += negative + zero;
            Collections.sort(negs);
            if(zero < 2 && positive > 0){
                boolean check = true;
                for(int i = 1;i<negs.size();i++){
                    long diff = Math.abs(negs.get(i) - negs.get(i-1));
                    if(diff < minPositive) {
                        check = false;
                    }
                }
                if(check){
                    count++;
                }
            }

            System.out.println(count);
        }
    }
}
