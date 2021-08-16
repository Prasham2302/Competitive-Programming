package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BITTUP {
    public static long powerMod(long a, long b, long mod){
        long result = 1;
        a  = a%mod;
        b = b%mod;
        if(a == 0 ){
            return 0;
        }
        while(b != 0){
            if((b&1) != 0) {
                result = (result * a) % mod;
            }
            b = b/2;
            a = (a * a)%mod;
        }
            return result;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//        Scanner scan = new Scanner(System.in);
        int t = Integer.parseInt(br.readLine());
        while(t>0) {
            t--;
            String[] inp = br.readLine().split(" ");
            long n = Long.parseLong(inp[0]);
            long m = Long.parseLong(inp[1]);

            long mod = (long) (Math.pow(10,9) + 7);

            long ans = (long) ((powerMod(2,n,mod)%mod - 1) % mod);
            ans = (long) (powerMod(ans,m,mod) % mod);
            System.out.println(ans);
        }
    }
}
