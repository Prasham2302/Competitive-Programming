package com.company;

import java.util.*;

//class Pair{
//    int first;
//    int second;
//    Pair(int a, int b){
//        first = a;
//        second = b;
//    }
//
//    public int getFirst() {
//        return first;
//    }
//
//    public int getSecond() {
//        return second;
//    }
//
//}
//class sort implements Comparator<Pair>{
//
//    @Override
//    public int compare(Pair pair, Pair t1) {
//        return pair.second > t1.second ? 1 : -1;
//    }
//}
public class Thouses {
//    static long mod = (long) (Math.pow(10,9)+7);
//    static int maxn = (int) (3*Math.pow(10,5) + 5);
//    static int[] adj = new int[maxn];
//    static int[] subval = new int[maxn];
//    static int[] val = new int[maxn];
//    ArrayList<pair> ch = new ArrayList<>();

//    public static void dfs(int now, int lst){
//
//    }
    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        int t = scan.nextInt();
//        while(t>0) {
//            t--;
//            int n = scan.nextInt();
//            long x = scan.nextLong();
//            HashMap<Integer, ArrayList<Integer>> d = new HashMap<>();
//            for (int i = 2; i < n ; i++) {
//                int u = scan.nextInt();
//                u--;
//                int v = scan.nextInt();
//                v--;
//                d.putIfAbsent(u, new ArrayList<>());
//                d.get(u).add(v);
//            }
//            for(Integer i : d.keySet()){
//                ArrayList<Pair> d_new = new ArrayList<>();
//                ArrayList<Integer> v = d.get(i);
//                for(int j = 0;j<v.size();j++){
//                    int c = 0;
//                    if(d.containsKey(j)){
//                        c = d.get(j).size();
//                    }
//                    else{
//                        c = 0;
//                    }
//                    d_new.add(new Pair(j,c));
//                }
//                Collections.sort(d_new,new sort());
//                ArrayList<Integer> l = new ArrayList<>();
//                for(Pair it: d_new){
//                    l.add(it.getFirst());
//                }
//                d.put(i,l);
//            }
//            HashMap<Integer,Integer> dl = new HashMap<>();
//            for(int i = 1;i<n+1;i++){
//                if((d.containsKey(i))){
//                    int num = 0;
//                    if(i == 1){
//                        num = (int) x;
//                    }
//                    else{
//                        num = dl.get(i);
//                    }
//                    int j = 1;
//
//                    for(Integer itr : d.get(i)){
//                        dl.put(itr, num*j);
//                        j++;
//                    }
//                }
//            }
//            long sum = x;
//            for(Integer itr : dl.keySet()){
//                sum += dl.get(itr);
//                sum = sum%mod;
//            }
//            System.out.println(sum%mod);
//        }
    }
}
