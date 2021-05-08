package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static boolean palindrome(String s, int n){
        boolean ans = true;
        int l = 0, r = n-1;
        while(l<r){
            if(s.charAt(l) == s.charAt(r)){
                l++;
                r--;
            }
            else{
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t>0){
            t--;
            String[] s = br.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);
            String st = br.readLine();
            if(k == 0){
                System.out.println("YES");
            }
            else if(2*k +1 > n){
                System.out.println("NO");
            }
            else if(palindrome(st,n)){
                    System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }
    }
}
