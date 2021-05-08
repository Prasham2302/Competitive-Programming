package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MEXSTR2 {
    static int maxn = (int) Math.pow(10,6);
    static int[] dp = new int[maxn+2];
    static int[] dp1 = new int[maxn+2];
    static int[] next0 = new int[maxn];
    static int[] next1 = new int[maxn];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t>0){
            t--;
            String s = br.readLine();
            int n = s.length();
            int last_pos = -1;
            for(int i = 0;i<n;i++){
                if(s.charAt(i) == '0'){
                    for(int j = last_pos+1;j<=i;j++){
                        next0[j] = i;
                    }
                    last_pos = i;
                }
            }
            for(int i = last_pos+1;i<n;i++) {
                next0[i] = n;
            }
            if(next0[0] == n){
                System.out.println("0");
                continue;
            }
            last_pos = -1;
            for(int i = 0;i<n;i++){
                if(s.charAt(i) == '1'){
                    for(int j=last_pos+1;j<=i;++j) {
                        next1[j] = i;
                    }
                    last_pos = i;
                }
            }
            for(int i = last_pos + 1;i<n;++i) {
                next1[i] = n;
            }
            dp[n]  = 0;
            dp[n+1] = 0;
            dp1[n]  = 0;
            dp1[n + 1] = 0;
            for (int i = n - 1; i >= 0; --i) {
                dp[i] = dp[i + 1];
                if (s.charAt(i) == '0' && next1[i] < n) {
                    dp[i] = Math.max(dp[i], dp[next1[i] + 1] + 1);
                }
                if (s.charAt(i) == '1' && next0[i] < n) {
                    dp[i] = Math.max(dp[i], dp[next0[i] + 1] + 1);
                }
                dp1[i] = dp1[i + 1];
                if (next1[i] < n) {
                    dp1[i] = Math.max(dp1[i], dp[next1[i] + 1] + 1);
                }
            }


            int len = dp1[0]+1;
            int curind = next1[0] + 1;
            StringBuilder ans = new StringBuilder("1");
            for(int i = 1;i<len;i++){
                if(curind >= n){
                    ans.append('0');
                    continue;
                }
                if(next0[curind] >= n){
                    ans.append('0');
                    curind = next0[curind] + 1;
                    continue;
                }
                if(dp[next0[curind]+1] < len-i-1){
                    ans.append('0');
                    curind = next0[curind]+1;
                }
                else{
                    ans.append('1');
                    curind = next1[curind]+1;
                }
            }
            System.out.println(ans.toString());
        }
    }
}
