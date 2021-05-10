package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class P3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t > 0) {
            t--;
            int n = scan.nextInt();
            int[] arr = new int[n];
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                arr[i] = scan.nextInt();
            }
            ArrayList<Integer> no_consecutives = new ArrayList<>();
            no_consecutives.add(arr[0]);
            int prev = arr[0];
            for(int i = 1;i<n;i++){
                if(prev != arr[i]){
                    no_consecutives.add(arr[i]);
                    prev = arr[i];
                }
            }
            n = no_consecutives.size();
            for(int i = 0;i<n;i++){
                map.putIfAbsent(no_consecutives.get(i), 1);
                map.put(no_consecutives.get(i)  , map.get(no_consecutives.get(i)) + 1);
                if(i == 0 || i == n-1){
                    map.put(no_consecutives.get(i)  , map.get(no_consecutives.get(i)) - 1);
                }
            }
            int ans = Integer.MAX_VALUE;
            for(Integer x : map.values()){
                ans = Math.min(x,ans);
            }
            if(map.size() == 1){
                System.out.println(0);
            }
            else{
                System.out.println(ans);
            }

        }
    }
}
