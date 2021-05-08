package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SUMXOR {

    static long power(long x, long y,long p)
    {
        long res = 1;
        x = x % p;
        while (y > 0) {
            if (y % 2 == 1)
                res = (res * x) % p;

            y = y >> 1; // y = y/2
            x = (x * x) % p;
        }
        return res;
    }
    static long modInverse(long n, long p)
    {
        return power(n, p - 2, p);
    }
    static long nCrModPFermat(int n, int r, long p)
    {
        if (n<r)
            return 0;

        if (r == 0)
            return 1;
        long[] fac = new long[n + 1];
        fac[0] = 1;
        for (int i = 1; i <= n; i++)
            fac[i] = (fac[i - 1] * i) % p;
        return (fac[n] * modInverse(fac[r], p)
                % p * modInverse(fac[n - r], p)
                % p)
                % p;
    }

    public static void countBits(long num, int[] ones, int[] zeros,int maxbits){
        String binary = Long.toBinaryString(num);
//        System.out.println(num+" = "+binary);
        int j = 0;
        for(int i = binary.length()-1;i>=0;i--){
            char ch = binary.charAt(i);
            if(ch == '1'){
                ones[j]++;
            }
            else{
                zeros[j]++;
            }
            j++;
        }
        while(j<maxbits){
            zeros[j]++;
            j++;
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        long[] arr = new long[n];
        long sum = 0;
        long p = 998244353;
        long maximum = Long.MIN_VALUE;
        for(int i = 0;i<n;i++){
            arr[i] = scan.nextLong();
            sum = (sum + arr[i])%p;
            maximum = Math.max(maximum,arr[i]);
        }
        int maxbits = Long.toBinaryString(maximum).length();
//        System.out.println(maxbits);
        int[] ones = new int[maxbits+1];
        int[] zeros = new int[maxbits+1];

        for(int i = 0;i<n;i++){
            countBits(arr[i],ones,zeros,maxbits);
        }
        System.out.println(Arrays.toString(ones));
        System.out.println(Arrays.toString(zeros));
        ArrayList<Long> store = new ArrayList<>();
        store.add(sum);
        int q = scan.nextInt();

        while(q>0){
            q--;
            int m = scan.nextInt();
            if(m<store.size()){
                System.out.println(store.get(m-1));
            }
            else{
                while(store.size()<m){
                    long count = 0;
                    for(int i = 0;i<maxbits;i++){
                        System.out.println("nCr MODS "+ ones[i] + " "+zeros[i]);
                        System.out.println(nCrModPFermat(ones[i],1,p));
                        System.out.println(nCrModPFermat(zeros[i],1,p));
                        long temp = (ones[i]%p * zeros[i]%p)%p;
                        temp = (temp * power(2,i,p))%p;
//                        System.out.println("temp "+temp);
                        count = (count+temp)%p;
                    }
//                    System.out.println(count);
                    long prev = store.get(store.size()-1);
                    store.add((count+prev)%p);
                }
                System.out.println(store.get(m-1));

            }

        }

    }
}
