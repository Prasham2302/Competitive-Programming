package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Q2 {

    public static void main(String[] args) {
        // write your code here
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t>0){
            t--;
            int n = scan.nextInt();
            int k = scan.nextInt();
            int[] arr = new int[n];
            HashMap<Integer,Integer> count = new HashMap<Integer, Integer>();
            for(int i = 0;i<n;i++){
                arr[i] = scan.nextInt();
                count.putIfAbsent(arr[i],0);
                count.replace(arr[i],count.get(arr[i])+1);
            }
            //check distinct values
            if(count.values().size()>k){
                System.out.println(-1);
                continue;
            }
            ArrayList<Integer> ans = new ArrayList<>();
            Set<Integer> distinct = count.keySet();
            for(int i = 0;i<n;i++){
                for(Integer j:distinct){
                    ans.add(j);
                }
                for(int j = 0;j<(k-distinct.size());j++){
                    ans.add(1);
                }
            }
            System.out.println(ans.size());
            for(int i = 0;i<ans.size();i++){
                System.out.print(ans.get(i)+" ");
            }
            System.out.println();
        }
        scan.close();
    }
}
