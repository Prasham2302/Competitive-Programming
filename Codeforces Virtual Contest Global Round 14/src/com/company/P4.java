package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class P4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t>0){
            t--;
            int n = scan.nextInt();
            int l = scan.nextInt();
            int r = scan.nextInt();
            ArrayList<Integer> left = new ArrayList<>();
            boolean[] leftCheck = new boolean[l];
            ArrayList<Integer> right = new ArrayList<>();
            boolean[] rightCheck = new boolean[r];
            for(int i = 0;i<n;i++){
                int temp = scan.nextInt();
                if(i<l){
                    left.add(temp);

                }
                else{
                    right.add(temp);

                }
            }
            Collections.sort(right);
            Collections.sort(left);
            int i = 0, j = 0;
            while(i < l && j < r){
                if(left.get(i) == right.get(j)){
                    leftCheck[i] = true;
                    rightCheck[j] = true;
                    i++;
                    j++;
                }
                if(left.get(i) < right.get(j)){
                    i++;
                }
                else{
                    j++;
                }
            }
            int countLeft = 0;
            int countRight = 0;
            int total = 0;
            for(int k = 0;k<l;k++){

                if(!leftCheck[k]){
                    countLeft++;
                    total++;
                }
            }
            for(int k = 0;k<r;k++){
                if(!rightCheck[k]){
                    countRight++;
                    total++;
                }
            }
            int shift = (Math.max(countRight,countLeft) - Math.min(countLeft,countRight));
            int ans = shift;
            ans += (total)/2 - shift;
            System.out.println(ans);

        }
    }
}
