package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class P2 {
    static int binary(int X, ArrayList<Integer> a){
        int L = 0, H = a.size()-1;
        while(L <= H){
            int mid = L + (H-L)/2;
            if(a.get(mid) <= X){
                L = mid+1;
            }
            else{
                H = mid-1;
            }
        }
        return H;
    }

    static boolean isPrime[];
    static int max = 200000;
    static void seive(){
        for(int i = 2; (long)i*i < max; i++){
            for(int j = i*i; j < max; j+=i){
                isPrime[j] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        isPrime = new boolean[max];
        Scanner scan = new Scanner(System.in);
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = scan.nextInt();
        Arrays.fill(isPrime, true);
        ArrayList<Integer> prime_list = new ArrayList<>();
        seive();
        for(int i = 2;i<max;i++){
            if(isPrime[i]){
                prime_list.add(i);
            }
        }
        while(t>0) {
            t--;
            int d = scan.nextInt();

            int idx = binary(d, prime_list);
            int num1 = prime_list.get(idx+1);
            int idx2 = binary(num1+d, prime_list);
            long num2 = prime_list.get(idx2);
            long ans = 1;
            if(num2-num1 < d)
                num2 = prime_list.get(idx2+1);
            ans = num1*num2;
            System.out.println(ans);

        }
    }
}
