package com.company;

import java.util.Scanner;

public class Main {
    public static long mod = 12*60*60;
    public static long num =  Long.parseLong("15709090909091");

    public static boolean function(int number, long a, long b, long c){
        long t = ((((b-a) * num) % mod + mod)%mod);
        if((708 * t-c+b) % mod == 0){
            long n = t % (long) Math.pow(10,9);
            t /= (long) Math.pow(10,9);
            long s = t%60;
            long m = t %60;
            long h = t/60;
            System.out.println("Case #" + number+": "+h+" "+m+" "+s+" "+n);
            return true;
        }
        else
            return false;
    }

    public static void main(String[] args) {
	// write your code here
        Scanner scan = new Scanner(System.in);
        int test = scan.nextInt();
        for(int testnumber = 1;testnumber<=test;testnumber++){
            long a = scan.nextLong();
            long b = scan.nextLong();
            long c = scan.nextLong();
            if(function(testnumber,a,b,c) || function(testnumber,a,c,b) || function(testnumber,b,a,c) || function(testnumber,b,c,a) || function(testnumber,c,a,b) || function(testnumber,c,b,a))
            {

            }

//            double tickConst = Math.pow(0.1,10)/12;
//
//            double hourDegree = (long) (a * tickConst);
//            double minuteDegree =  (b * tickConst);
//            double secondDegree = (long) (c * tickConst);
////            System.out.println((double) Math.round(minuteDegree)/360 +" "+secondDegree);
//
//            double hour = ((double) Math.round(hourDegree) / 360)*12;
//            double minute =  ((double) Math.round(minuteDegree) / 360)*60;
//            double second = ((double) Math.round(secondDegree) / 360)*60;
//            double nanosecond = ((double) Math.round(secondDegree) / 360)*720;
//            System.out.println("Case #" + testnumber+": "+hour+" "+minute+" "+second);
        }
    }
}
