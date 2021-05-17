package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class VPATH {
    static long mod = (long) (Math.pow(10,9)+7);
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t>0){
            t--;
            int n = scan.nextInt();
            ArrayList<Integer>[] nodes = new ArrayList[n+1];
            for(int i = 0;i<n+1;i++){
                nodes[i] = new ArrayList<>();
            }
            for(int i = 0;i<n-1;i++){
                int u = scan.nextInt();
                int v = scan.nextInt();
                nodes[u].add(v);
                nodes[v].add(u);
            }
//            for(int i = 0;i<n;i++){
//                System.out.println(nodes[i]);
//            }
            long[] dp = new long[n+1];
            long[] tot = new long[n+1];
            dfs(nodes,1,1, dp, tot);
            System.out.println(Arrays.toString(tot));
            System.out.println(Arrays.toString(dp));
            long ans = tot[1];
            System.out.println(ans);
        }
    }

    private static void dfs(ArrayList<Integer>[] nodes, int curr, int par, long[] dp, long[] tot) {
        dp[curr] = 1;
        tot[curr] = 1;
        long sum = 0;
        long count = 0;
        ArrayList<Integer> neighbours = nodes[curr];
        for(int i = 0;i<neighbours.size();i++){
            int curr_node = neighbours.get(i);
            if(curr_node != par){
                dfs(nodes,curr_node,curr,dp,tot);
                dp[curr] %= mod;
                count++;
                tot[curr] += tot[curr_node];
                tot[curr] %= mod;
                tot[curr] += dp[curr_node];
                tot[curr] %= mod;
                dp[curr] += 2*dp[curr_node]%mod;
                sum += dp[curr_node];
            }
        }
        for(int i = 0;i<neighbours.size();i++){
            int curr_node = neighbours.get(i);
            if(curr_node != par){
                tot[curr] += (dp[curr_node]*((sum - dp[curr_node])%mod))%mod;
                tot[curr] %= mod;
            }
        }
    }
}
