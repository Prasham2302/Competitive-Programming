package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class P4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
//        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
//        int t = Integer.parseInt(br.readLine());
        int t = scan.nextInt();
        while(t>0) {
            t--;
            int n = scan.nextInt();
            int[] arr = new int[n];
            HashSet<Integer> set = new HashSet<>();
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                arr[i] = scan.nextInt();
                max = Math.max(max,arr[i]);
                min = Math.min(min,arr[i]);
            }
            if(max == min){
                System.out.println("NO");
                continue;
            }
            boolean[] visited = new boolean[n];
            ArrayList<String> ans = new ArrayList<>();
            int left = 0;
            visited[left] = true;
            int diff = 0;
            for(int i = 1;i<n;i++){
                if(arr[i] != arr[left]){
                    String toAdd = (left+1) +" "+(i+1);
                    ans.add(toAdd);
                    diff = i;
                    visited[i] = true;
                }
            }
            for(int i = 1;i<n;i++){
                if(arr[i] == arr[left]){
                    String toAdd = (i+1) +" "+(diff+1);
                    ans.add(toAdd);
                }
            }
            System.out.println("YES");
            for(int i = 0;i<ans.size();i++){
                System.out.println(ans.get(i));
            }

        }
    }
}
