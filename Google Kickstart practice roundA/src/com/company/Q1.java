package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Q1 {
    static int k;
    static int n;
    static int[][] stacks;
    public static  int rec(int idx, int taken){
        for(int i = 0;i<=k;i++){

        }
        return 0;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = scan.nextInt();
        for(int p = 1;p<=t;p++){
            n = scan.nextInt();
            k = scan.nextInt();
            int plates = scan.nextInt();
            stacks = new int[n][k];
            for(int i = 0;i<n;i++){
                for(int j = 0;j<k;j++){
                    stacks[i][j] = scan.nextInt();
                }
            }

        }
    }
}
