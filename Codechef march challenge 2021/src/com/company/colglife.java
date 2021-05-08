package com.company;

import java.util.Scanner;

public class colglife {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t>0){
            t--;
            long n =  scan.nextLong();
            long e =  scan.nextLong();
            long h =  scan.nextLong();
            long a =  scan.nextLong();
            long b =  scan.nextLong();
            long c =  scan.nextLong();
            long counter = 0;
            if(e == h){
                counter += e;
            }
            else if(e > h){
                long temp = e-h;
                counter += temp/2;

                counter += e;
//                System.out.println(counter);
            }
            else{
                long temp = h - e;
                counter += temp/3;
                counter += e;
            }
            if(n > counter){
                System.out.println(-1);
            }
            else {
                long ans = (long) helper(n,e,h,a,b,c);
                if(ans < 0 || ans == Long.MAX_VALUE){
                    System.out.println(-1);
                }
                else{
                    System.out.println(ans);
                }
            }
        }
    }

    private static long helper(long n, long e, long h, long a, long b, long c) {

        long cost = Long.MAX_VALUE;
        if(e >= 2*n){
            //only omellettes
            cost = Math.min(n*a, cost);
//            System.out.println("only omellettes: "+ cost);
        }
        if(h >= 3*n){
            //only shakes
            cost = Math.min(n*b, cost);
//            System.out.println("only shakes: "+ cost);
        }
        if(n <= e && n <= h){
            //only cakes
            cost = Math.min(n*c, cost);
//            System.out.println("only cakes: "+ cost);
        }
        if((h-n)/2 >= 1 && (h-n)/2 >= n-e){
            //cakes and shakes
            if(b<c) {
                long temp = Math.min(n - 1, (h - n) / 2);
                cost = Math.min(temp *(b-c) + n*c, cost);
//                System.out.println("cakes and shakes: "+ cost);
            }
            else{
                long temp = Math.max(1, n-e);
                cost = Math.min(cost, temp*(b-c)+n*c);

            }
//            System.out.println("cakes and shakes: "+ cost);
        }
        if(e/2 >= 1 && (3*n-h+2)/3 <= e/2){
            //omellete & shakes
            if(a<b){
                long temp = Math.min(n - 1, e / 2);
                cost = Math.min(temp*(a-b) + n*b, cost);
            }
            else{
                long temp = Math.round(Math.max(1, (3*n - h + 2)/3));
                cost = Math.min(cost, (temp*(a-b) + n*b));
            }
//            System.out.println("omellete and shakes: "+ cost);
        }
        if(e-n>=1 && (e+h) >= 2*n){
            //omelette and cake
            if(a < c){
                long temp = Math.min(n - 1, e - n);
                cost = Math.min(temp*(a-c) + n*c, cost);
            }
            else {
                long temp = Math.max(1, n - h);
                cost = Math.min(cost, temp * (a - c) + n * c);
            }
//            System.out.println("omelette and cake: "+ cost);
        }
        if(n >= 3 && e>= 3 && h >= 4){
            //use all three;
            cost = Math.min(cost,a+b+c+helper(n-3,e-3,h-4,a,b,c));
//            System.out.println("all three: "+ cost);
        }
        return cost;
    }
}
