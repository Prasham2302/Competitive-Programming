package com.company;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        Scanner scan = new Scanner(System.in);
        long t = scan.nextInt();
        for(long TestNumber = 1;TestNumber<=t;TestNumber++){
            int n = scan.nextInt();
            BigInteger[] bigarr = new BigInteger[n];
            long[] arr = new long[n];
            for(int i = 0;i<n;i++){
                arr[i] = scan.nextLong();
                bigarr[i] = BigInteger.valueOf(arr[i]);
            }
            long count = 0;
            BigInteger prev = bigarr[0];
            for(int i = 1;i<n;i++){
                BigInteger curr = bigarr[i];
//                System.out.println(curr);
                if(curr.equals(prev)){
                    count++;
                    curr = curr.multiply(BigInteger.valueOf(10));
                    if(curr == prev){
                        curr.add(BigInteger.valueOf(1));
                    }
                    bigarr[i] = curr;
                }
                else if(curr.compareTo(prev) < 0){
                    BigInteger temp = prev.add(BigInteger.valueOf(1));
                    String diff = temp.toString();
                    String curr_str = curr.toString();
                    boolean append = false;
//                    System.out.println(diff);
                    for(int j = 0;j<Math.min(diff.length(),curr_str.length());j++){
                        if(curr_str.charAt(j) != diff.charAt(j)){
//                            System.out.println("in append");
                            append = true;
                            break;
                        }
                    }
                    if(append == false){
                        count += diff.length() - curr_str.length();
                        curr = new BigInteger(diff);
                    }
                    else{
                        while(curr.compareTo(prev) < 0){
                            curr = curr.multiply(BigInteger.valueOf(10));
//                            System.out.println(curr);
                            count++;
                        }
                    }
                }
                bigarr[i] = curr;
                prev = curr;
            }
//            System.out.println(Arrays.toString(bigarr));

            System.out.println("Case #"+TestNumber+": "+count);
        }

    }
}
