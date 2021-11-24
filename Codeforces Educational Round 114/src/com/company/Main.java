package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        HashMap<Integer, ArrayList<String>> map = new HashMap<>();
        while(t > 0){
            t--;
            int n = scan.nextInt();

            ArrayList<String> ans = new ArrayList<>();
            if(map.containsKey(n)){
                ans = map.get(n);
            }
            else{
                StringBuilder str = new StringBuilder();
                generate(n, str,0,0,ans);
            }

            for(int i = 0;i<n;i++){
                System.out.println(ans.get(i));
            }
        }
    }

    private static void generate(int n, StringBuilder str, int open, int close, ArrayList<String> ans) {
        if(close == n){
            ans.add(str.toString());
        }
        if(ans.size() >= n){
            return;
        }
        if(open < n){
            str.append("(");
            generate(n,str, open+1,close, ans);
            str.deleteCharAt(str.length()-1);
        }
        if(close < open){
            str.append(")");
            generate(n,str, open,close+1, ans);
            str.deleteCharAt(str.length()-1);
        }
    }
}
