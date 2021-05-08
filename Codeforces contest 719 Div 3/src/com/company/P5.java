package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t>0){
            t--;
            int len = Integer.parseInt(br.readLine());
            char[] inp = br.readLine().toCharArray();
            int[] arr = new int[len];

            int count = 0;
            for(int i = 0;i<len;i++){
                if(inp[i] == '*'){
                    count++;
                }
            }
            if(count < 2 || count == len){
                System.out.println(0);
            }
            else{

            }
        }
    }
}
