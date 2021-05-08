package com.company;

import javafx.util.Pair;

import java.util.*;


public class maxTopp {
    private static final int MOD = 1000000007;
    static int n;
    static int N = (int)5*100000+5;
    static int[] factorialNumInverse = new int[N+1];
    static int[] naturalNumInverse = new int[N+1];
    static int[] fact = new int[N+1];
    public static void InverseofNumber(int p){
        naturalNumInverse[0] = naturalNumInverse[1] = 1;
        for(int i = 2;i<=N;i++){
            naturalNumInverse[i] = naturalNumInverse[p%i] * (p-p/i)%p;
        }
    }
    public static void InverseofFactorial(int p){
        factorialNumInverse[0] = factorialNumInverse[1] = 1;
        for (int i = 2; i <= N; i++)
            factorialNumInverse[i] = (naturalNumInverse[i] * factorialNumInverse[i - 1]) % p;
    }
    public static void factorial(int p){
        fact[0] = 1;
        for (int i = 1; i <= N; i++) {
            fact[i] = (fact[i - 1] * i) % p;
        }
    }
    public static int Binomial(int N, int R, int p){
        if(R>N) return 0;
        if(R==N) return 1;
        int ans = ((fact[N] * factorialNumInverse[R]) % p * factorialNumInverse[N - R]) % p;
        return ans;
    }
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
//    static ArrayList<Integer> vis = new ArrayList<>();
//    static ArrayList<Integer> temp_ways = new ArrayList<>();
//    static ArrayList<Integer> sub_trees = new ArrayList<>();
    static Vector<Integer> vis = new Vector<>();
    static Vector<Integer> temp_ways = new Vector<>();
    static Vector<Integer> sub_trees = new Vector<>();
//    static Vector<Integer> vis = new Vector<>();

    public static int dfs(int node){
        vis.set(node,1);
        int ans = 1, subtree = 0;
        for(Integer x: adj.get(node)){
            if(vis.get(x) == 0){
                int curr_s = dfs(x);
                subtree += curr_s;
                ans *= Binomial(subtree,curr_s,MOD);
                ans %= MOD;
                ans *= temp_ways.get(x);
                ans%= MOD;
            }
        }
        ans%=MOD;
        temp_ways.set(node,ans);
        return subtree + 1;
    }
    static Vector<Pair<Integer,Pair<Integer,Integer>>> AA = new Vector<>();
    public static int getNode(int node){
        vis.set(node,1);
        int subtree = 0, curr;
        for(Integer x: adj.get(node)){
            if(vis.get(x) == 0){
                curr = getNode(x);
                subtree += curr;
                int abcd = Math.min(curr,(n-curr));
                Pair<Integer,Integer> temp1 = new Pair<>(x,node);
                Pair<Integer, Pair<Integer,Integer>> temp2 = new Pair<>(abcd,temp1);
            }
        }
        sub_trees.set(node,subtree+1);
        return subtree+1;
    }
    public static void main(String[] args) {
        factorial(MOD);
        InverseofNumber(MOD);
        InverseofFactorial(MOD);
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t>0){
            t--;
            n = scan.nextInt();
            int k = scan.nextInt();
            int m = n-1;
            adj.clear();vis.clear();temp_ways.clear();

            for(int i = 0;i<n-1;i++){
                int u = scan.nextInt();
                int v = scan.nextInt();
                adj.get(u - 1).add(v-1);
                adj.get(v-1).add(u-1);
            }
            if(n == 1){
                int k1 = 0, k2 = 0;
                if(k == 1){
                    vis.clear();temp_ways.clear();
                    dfs(k1);
                    System.out.println((k1+1) +" " + (temp_ways.get(k1)%MOD));
                }
                else{
                    vis.clear(); temp_ways.clear();
                    dfs(k2);
                    System.out.println((k2+1) +" " + (temp_ways.get(k2)%MOD));
                }
                continue;
            }
            AA.clear();sub_trees.clear();
            getNode(0);
            int idx = 1;
            Collections.sort(AA);

        }
    }
}
