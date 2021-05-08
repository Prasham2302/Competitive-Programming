package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BoolGame {

    public static long score(String s, long[] g, int[][] intervals){
        int n = s.length();
        long count = 0;
        for(int i = 0;i<n;i++){
            if(s.charAt(i) == '1')
                count += g[i];
        }
        for(int i = 0;i<intervals.length;i++){
            int u = intervals[i][0]-1;
            int v = intervals[i][1]-1;
            boolean toAdd = true;
            for(int j = u;j<=v;j++){
                if(s.charAt(j) == '0'){
                    toAdd = false;
                    break;
                }
            }
            if(toAdd){
                count += intervals[i][2];
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t>0){
            t--;
            int n = scan.nextInt();
            int m = scan.nextInt();
            long k = scan.nextLong();
            long[] arr = new long[n];
            int[][] intervals = new int[m][3];
            for(int i= 0;i<n;i++){
                arr[i] = scan.nextInt();
            }
            for(int i = 0;i<m;i++){
                intervals[i][0] = scan.nextInt();
                intervals[i][1] = scan.nextInt();
                intervals[i][2] = scan.nextInt();
            }
            ArrayList<Long> scores = new ArrayList<>();
            for(int i = 0;i<Math.pow(2,n);i++){
                StringBuilder curr = new StringBuilder(Integer.toBinaryString(i));
                while(curr.length() != n){
                 curr.insert(0,'0');
                }
                long score = score(curr.toString(),arr,intervals);
                scores.add(score);
            }
            Collections.sort(scores,Collections.reverseOrder());
            for(int i = 0;i<k;i++){
                System.out.print(scores.get(i) + " ");
            }
            System.out.println();
        }
    }
}