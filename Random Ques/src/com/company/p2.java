package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class p2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t>0){
            t--;
            int n = Integer.parseInt(br.readLine());
            String st = br.readLine();
            int count = 0;
            for(int i = 0;i<n;i++){
                char ch = st.charAt(i);
                if(ch == '0'){
                    count++;
                }
            }
            if(count % 2 == 0 || count == 1){
                System.out.println("BOB");
            }
            else{
                System.out.println("ALICE");
            }

        }
    }
}
