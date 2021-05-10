package com.company;

import java.util.HashMap;
import java.util.Scanner;

public class P2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t > 0) {
            t--;
            int n = scan.nextInt();
            int[] arr = new int[n];
            HashMap<Integer,Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                arr[i] = scan.nextInt();
                map.putIfAbsent(arr[i], 0);
                map.put(arr[i], map.get(arr[i])+1);
            }
            int ans = Integer.MAX_VALUE;
            for(Integer x: map.keySet()){
                if(map.get(x) == 1){
                    ans = Math.min(ans, x);
                }
            }
            if(ans == Integer.MAX_VALUE){
                System.out.println(-1);
            }
            else{
                int idx = -1;
                for(int i = 0;i<n;i++){
                    if(arr[i] == ans){
                        idx = i+1;
                        break;
                    }
                }
                System.out.println(idx);
            }
        }
    }
}
