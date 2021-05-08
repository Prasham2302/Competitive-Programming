package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t>0){
            t--;
//            System.out.println(t);
            String[] inp = br.readLine().split(" ");
            int n = Integer.parseInt(inp[0]);
            int k = Integer.parseInt(inp[1]);
            char[] arr = br.readLine().toCharArray();
            int count = 0;

            int curr = 0;

            while(arr[curr] != '*') {
                curr++;
            }
            arr[curr] = 'x';
            int right = n-1;
            while(right >= curr+k && arr[right] != '*'){
                right--;
            }


            System.out.println(count);
        }
    }
}
