package com.company;

import java.util.HashMap;
import java.util.Scanner;

public class P2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t>0){
            t--;
            int num = scan.nextInt();
            HashMap<Integer,Integer> map = new HashMap<>();
            int len = Integer.toString(num).length();
            int count = 0;
            StringBuilder str = new StringBuilder();
            for(int i = 1;i<=len;i++){
                str.append('1');
                int curr = Integer.parseInt(str.toString());
                for(int j= 1;j<=9;j++){
                    int temp = curr * j;
                    if(temp <= num){
                        count++;
                    }
                    else{
                        break;
                    }
                }
            }
            System.out.println(count);
        }
    }
}
