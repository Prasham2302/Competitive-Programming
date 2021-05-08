package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class P2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t>0){
            t--;
            String[] temp = br.readLine().split(" ");
            int a = Integer.parseInt(temp[0]);
            int b = Integer.parseInt(temp[1]);
            char[] input = br.readLine().toCharArray();
            int len = input.length;

            boolean pass = true;
            for(int  i= 0;i<len;i++){
                if(input[i] == '1'){
                    b--;
                }
                if(input[i] == '0'){
                    a--;
                }
            }
            int left = 0;
            int right = len - 1;
            while(left < right){
                if(input[left] == input[right] && input[left] !='?'){

                }
                else{
                    if(input[left] == input[right]){
                        if(a > b){
                            a-= 2;
                            input[left] = '0';
                            input[right] = '0';
                        }
                        else{
                            b-= 2;
                            input[left] = '1';
                            input[right] = '1';
                        }
                    }
                    else if(input[left] == '?'){
                        input[left] = input[right];
                        if(input[left] == '0'){
                            a-=1;
                        }
                        else{
                            b-=1;
                        }
                    }
                    else if(input[right] == '?'){
                        input[right] = input[left];
                        if(input[left] == '0'){
                            a-=1;
                        }
                        else{
                            b-=1;
                        }
                    }
                    else{
                        pass = false;
                        break;
                    }

                }
                left++;
                right--;
            }
            if(input[left] == '?'){
                if(a > 0){
                    input[left] = '0';
                    a--;
                }
                else{
                    input[left] = '1';
                    b--;
                }
            }
            if(a!=0 || b!=0){
                pass = false;
            }
            if(pass){
                System.out.println(String.valueOf(input));
            }
            else{
                System.out.println(-1);
            }

        }
    }
}
