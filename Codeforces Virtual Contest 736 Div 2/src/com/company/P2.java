package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class P2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        Scanner scan = new Scanner(System.in);
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(br.readLine());
            char[] enemy = br.readLine().toCharArray();
            char[] us = br.readLine().toCharArray();
            for(int i = 0;i<n;i++){
                if(enemy[i] == '1'){
                    enemy[i] = 'E';
                }
                if(us[i] == '1'){
                    us[i] = 'U';
                }
                if(us[i] == 'U' && enemy[i] != 'E'){
                    enemy[i] = 'U';
                    us[i] = '0';
                }
            }
            for(int i = 0;i<n;i++){
                if(us[i] == 'U'){
                    if(i > 0 && (enemy[i-1] == 'E')){
                        enemy[i-1] = 'U';
                    }
                    else if(i < n-1 && (enemy[i+1] == 'E')){
                        enemy[i+1] = 'U';
                    }
                }
            }
            int count = 0;
            for(int i = 0;i<n;i++){
                if(enemy[i] == 'U'){
                    count++;
                }
            }
            System.out.println(count);

        }
    }
}
