package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class P3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t>0){
            t--;
            int n = scan.nextInt();
            int x = scan.nextInt();
            int y = scan.nextInt();
            int max = Math.max(x,y);
            int min = Math.min(x,y);
            int diff = max - min;
            ArrayList<Integer> finalans = new ArrayList<>();
            ArrayList<Integer> shot = new ArrayList<>();
            boolean checkMin = false;
            boolean checkMax = false;
            int overAll = Integer.MAX_VALUE;
            for(int start = 1;start<=51;start++){
                boolean finalise = false;
                for(int k = 1;k<=diff;k++){
                    for(int i = 0;i<n;i++){
                        int curr = start + k * i;
                        shot.add(curr);
                        if(curr == min){
                            checkMin = true;
                        }
                        if(curr == max){
                            checkMax = true;
                        }
                    }
                    if(checkMax == true && checkMin == true && shot.size() == n){
                        int curr_max = shot.get(n-1);
                        if(curr_max < overAll){
                            finalans = new ArrayList<>(shot);
                            overAll = curr_max;
                        }
                    }
                    checkMax = false;
                    checkMin = false;
                    shot.clear();
                }
            }
            for(int i = 0;i<n;i++){
                System.out.print(finalans.get(i)+" ");
            }
            System.out.println();
        }
    }
}
