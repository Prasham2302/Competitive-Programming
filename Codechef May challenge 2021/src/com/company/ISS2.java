package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader()
    {
        br = new BufferedReader(
                new InputStreamReader(System.in));
    }

    String next()
    {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt() { return Integer.parseInt(next()); }

    long nextLong() { return Long.parseLong(next()); }

    double nextDouble()
    {
        return Double.parseDouble(next());
    }

    String nextLine()
    {
        String str = "";
        try {
            str = br.readLine();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}

public class ISS2 {
    public static void main(String[] args) throws IOException {
        int n = 4000005;
        long[] dp = new long[n];
        long[] ans = new long[n];
        for(int i = 0; i < n; i++){
            dp[i] = i;
        }
        for(int i = 2;i<n;i++){
            if(dp[i] == i) {
                dp[i] = i - 1;
                for (int j = 2 * i; j < n; j += i) {
                    dp[j] = (dp[j] / i) * (i - 1);
                }
            }
        }
        for(int i = 1 ; i < n ; i++){
            ans[i] += i-1;
            for(int j = 2 * i ; j < n ; j += i){
                ans[j] += i * ((1 + dp[j / i]) / 2);
            }
        }
        FastReader s  = new FastReader();
        int t = s.nextInt();
        while(t>0){
            t--;
            int k = s.nextInt();
            System.out.println(ans[4 * k + 1]);
        }
    }
}
