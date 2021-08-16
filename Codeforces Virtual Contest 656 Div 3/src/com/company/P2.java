package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class P2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t>0){
            t--;
            int n = scan.nextInt();
            int[] arr = new int[2*n];
            for(int i = 0;i<2*n;i++){
                arr[i] = scan.nextInt();
            }
            ArrayList<Integer> ans = new ArrayList<>();
            HashSet<Integer> set = new HashSet<>();
            for(int i = 0;i<2*n;i++){
                if(set.contains(arr[i])){
                    continue;
                }
                set.add(arr[i]);
                ans.add(arr[i]);
            }
            for(int i = 0;i<n;i++){
                System.out.print(ans.get(i) +" ");
            }
            System.out.println();
        }
    }
}
