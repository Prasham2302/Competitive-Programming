package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class xystr {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t>0){
            t--;
            String s = br.readLine();
            int count = 0;
            int i = 0;
            while(i<s.length()-1){
                if(s.charAt(i) == 'x' && s.charAt(i+1)=='y'){
                    count++;
                    i++;
                }
                else if(s.charAt(i) == 'y' && s.charAt(i+1) == 'x'){
                    count++;
                    i++;
                }
                i++;
            }
            System.out.println(count);
        }

    }
}
