package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t>0){
            t--;
            int n = scan.nextInt();
            int k = scan.nextInt();
            int[] arr = new int[n];
            for(int i = 0;i<n;i++){
                arr[i] = scan.nextInt();
            }
            int count = 0;
            int[] bits = new int[32];
            for(int i = 0; i<n ; i++){
                StringBuilder num = new StringBuilder(Integer.toBinaryString(arr[i]));
                num = num.reverse();
//                System.out.println(num);
                for(int j = 0;j<num.length();j++){
                    if(num.charAt(j) == '1'){
                        bits[j]++;
                    }
                }
            }
//            System.out.println(Arrays.toString(bits));
            for(int i = 0;i<32;i++){
//                System.out.println(Math.ceil(bits[i] / k));
                count += Math.ceil((float) bits[i] / (float) k);
            }
            System.out.println(count);
        }
    }
}
