package com.company;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class p3 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t>0){
            t--;
            int x = scan.nextInt();
            if(x>45){
                System.out.println("-1");
            }
            else{
                StringBuilder str = new StringBuilder();
                int curr = 9;
                while(curr > 0){
                    if(curr <= x){
                        str.append(curr);
                        x-=curr;

                    }
                    curr--;
                }
                char[] temp = str.toString().toCharArray();
                Arrays.sort(temp);
                str = new StringBuilder();
                for(char a : temp){
                    str.append(a);
                }
                System.out.println(str.toString());
            }
        }
    }
}
