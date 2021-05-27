package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class P3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t>0){
            t--;
            String[] inp = br.readLine().split(" ");
            int n = Integer.parseInt(inp[0]);
            int m = Integer.parseInt(inp[1]);
            inp = br.readLine().split(" ");
            int[] arr = new int[n];
            for(int i = 0;i<n;i++){
                arr[i] = Integer.parseInt(inp[i]);
            }
            char[] dir = new char[n];
            inp = br.readLine().split(" ");
            for(int i = 0;i<n;i++){
                dir[i] = inp[i].charAt(0);
            }
            int[] explosion = new int[n];
            for(int i = 0;i<m;i++){

            }
        }
    }
}
