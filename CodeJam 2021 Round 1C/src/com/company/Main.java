package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int test = 1;test<=t;test++){
            String y = br.readLine();
            while(check(String.valueOf(y+1)));

        }
    }
    private static boolean check(String y) {
        char[] arr = y.toCharArray();
        StringBuilder curr = new StringBuilder();
        for(int i = 1;i<arr.length-1;i++){
            curr.append(arr[i-1]);
            for(int j = i;j<arr.length;j++){


            }
        }
        return false;
    }
}
