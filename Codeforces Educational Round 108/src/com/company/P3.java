package com.company;

import java.util.*;

public class P3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t>0){
            t--;
            int n = scan.nextInt();
            int[] univ = new int[n];
            int[] s = new int[n];
            HashSet<Integer> unique = new HashSet<>();
            HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
            for(int i = 0;i<n;i++){
                univ[i] = scan.nextInt();
                map.putIfAbsent(univ[i], new ArrayList<>());
                unique.add(univ[i]);
            }
            for(int i = 0;i<n;i++){
                s[i] = scan.nextInt();
                map.get(univ[i]).add(s[i]);
            }
            int curr = Integer.MIN_VALUE;
            for(Integer i : unique){
                Collections.sort(map.get(i),Collections.reverseOrder());
                curr = Math.max(curr, map.get(i).size());
            }
            HashMap<Integer,Long> ans = new HashMap<>();
            long[][] info = new long[n+1][2]; // int[i][0]: current sum for univ i, int[i][1]: team size for univ i, for which the score was calculated;
            for(int i = 0;i<n;i++){
                if(map.containsKey(i+1)){
                    ArrayList<Integer> list = map.get(i+1);
                    long sum = 0;
                    for(int j = 0;j<list.size();j++){
                        sum+=list.get(j);
                    }
                    info[i+1][0] = sum;
                    info[i+1][1] = list.size();
                }
            }
            while(curr>0){
                long count = 0;
                for(Integer x : unique){
                    ArrayList<Integer> list = map.get(x);
                    if(list.size()>=curr){
                        int i = (int) info[x][1];
                        long currSum = info[x][0];
//                        while(curr <= )
                    }
                }
            }
        }
    }
}
