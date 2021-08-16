package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class CHFHEIST {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//        Scanner scan = new Scanner(System.in);
        int t = Integer.parseInt(br.readLine());
        while(t>0){
            t--;
            String[] inp = br.readLine().split(" ");
            long D = Integer.parseInt(inp[0]);
            long d = Integer.parseInt(inp[1]);
            long p = Integer.parseInt(inp[2]);
            long q = Integer.parseInt(inp[3]);

            long totalP = D * p;
            long ans = 0;
            long n = (D/d);

            long totalq = n*(n-1)*d*q/2;
            if(D%d != 0) {
                long rem = D % d;
//                System.out.println(totalP +" "+totalq+" "+n);
                totalq += (n * q) * rem;
            }
            ans = totalP + totalq;
            System.out.println(ans);
        }
    }
}
