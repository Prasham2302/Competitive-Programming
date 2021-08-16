package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class P5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while(q > 0){
            q--;
            int n = scan.nextInt();
            int k = scan.nextInt();
            int[] idx = new int[k];
            for(int i = 0;i<k;i++){
                idx[i] = scan.nextInt();
            }
            int[] ac = new int[k];
            for(int i = 0;i<k;i++){
                ac[i] = scan.nextInt();
            }
            int[] ans = new int[n];
            int[] pref = new int[n];
            int[] suf = new int[n];
            for(int i = 0;i<k;i++){
                pref[idx[i]-1] = ac[i];
                suf[idx[i]-1] = ac[i];
            }
            for(int i = 0;i<n;i++){
                pref[i] = pref[i] == 0 ? Integer.MAX_VALUE: pref[i];
                suf[i] = suf[i] == 0 ? Integer.MAX_VALUE: suf[i];
            }
            int currmin = Integer.MAX_VALUE;
            for(int i = 0;i<n;i++){
                if(pref[i] != Integer.MAX_VALUE){
                    if(currmin == Integer.MAX_VALUE){
                        currmin = pref[i];
                    }
                    else{
                        currmin = Math.min(currmin + 1, pref[i]);
                        pref[i] = Math.min(currmin,pref[i]);

                    }
                }
                else{
                    //pref[i] = maxvalue
                     if(currmin == Integer.MAX_VALUE){
                        continue;
                    }
                    else{
                        pref[i] = currmin + 1;
                        currmin++;
                    }
                }
            }
            for(int i = n-1;i>=0;i--){
                if(suf[i] != Integer.MAX_VALUE){
                    if(currmin == Integer.MAX_VALUE){
                        currmin = suf[i];
                    }
                    else{
                        currmin = Math.min(currmin + 1, suf[i]);
                        suf[i] = Math.min(currmin,suf[i]);

                    }
                }
                else{
                    //pref[i] = maxvalue
                    if(currmin == Integer.MAX_VALUE){
                        continue;
                    }
                    else{
                        suf[i] = currmin + 1;
                        currmin++;
                    }
                }
            }
            System.out.println(Arrays.toString(pref));
            for(int i = 0;i<n;i++){
                ans[i] = Math.min(suf[i],pref[i]);
            }
            for(int i = 0;i<n;i++){
                System.out.print(ans[i]+" ");
            }
//            System.out.println();
        }
    }
}
