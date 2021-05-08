//package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here

        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t>0) {
            t--;
            String[] str = br.readLine().split(" ");
            int n = Integer.parseInt(str[0]);
            int k = Integer.parseInt(str[1]);
            String s = br.readLine();

            char tempArray[] = s.toCharArray();
            Arrays.sort(tempArray);
            s = new String(tempArray);

            String ans = String.valueOf(s.charAt(0));

            if(s.charAt(k) == s.charAt(n-1)){
                for(int i = 0;i<((n-1/k));i++){
                    ans += String.valueOf(s.charAt(n-1));
                }
            }
            else{
                ans += s.substring(k);
            }

            if(s.charAt(0) == s.charAt(k-1))
                System.out.println(ans);
            else{
                System.out.println(String.valueOf(s.charAt(k-1)));
            }

        }
    }
}
