package com.company;

import java.util.*;

public class DenseGraph {
    static ArrayList<Long> pp1 = new ArrayList<>();
    static ArrayList<Long> pp2 = new ArrayList<>();
    public static boolean isinrange(long a, long b){
        for(int i= 0;i<pp1.size();i++){
            if(pp1.get(i)<=b && pp2.get(i)>=a){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t>0){
            t--;
            int n = scan.nextInt();
            int m = scan.nextInt();
            long x = scan.nextLong();
            long y = scan.nextLong();
            long[] a = new long[m];
            long[] b = new long[m];
            long[] c = new long[m];
            long[] d = new long[m];
            for(int i = 0;i<m;i++){
                a[i] = scan.nextLong();
                b[i] = scan.nextLong();
                c[i] = scan.nextLong();
                d[i] = scan.nextLong();
            }
            if(x == y){
                System.out.println("0");
                continue;
            }
            long[] di = new long[m];
            long ans = -1;
            long z = 0;
            ArrayList<Long> q1 = new ArrayList<>();
            ArrayList<Long> q2 = new ArrayList<>();
            q1.add(x);
            q2.add(x);
            while(ans == -1 && q1.size() != 0){
                pp1.clear();
                pp2.clear();
                pp1 = new ArrayList<>(q1);
                pp2 = new ArrayList<>(q2);
                ArrayList<Long> w1 = new ArrayList<>();
                ArrayList<Long> w2 = new ArrayList<>();
                for(int i = 0;i<m;i++){
                    if(di[i] == 0 && isinrange(a[i],b[i])){
                        w1.add(c[i]);
                        w2.add(d[i]);
                        if(c[i] <= y && d[i] >= y){
                            ans = z+1;
                        }
                        di[i] = 1;
                    }
                }
                q1 = w1;
                q2 = w2;
                z++;
            }
            System.out.println(ans);
        }
    }
}
