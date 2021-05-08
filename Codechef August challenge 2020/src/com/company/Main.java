package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t>0){
            t--;
            String s = br.readLine();
            String p = br.readLine();

            //creating HashMap of patterns
            HashMap<Character, Integer> map = new HashMap<>();
            for(int i = 0;i<p.length();i++){
                char curr = p.charAt(i);
                map.putIfAbsent(curr,0);
                map.replace(curr,map.get(curr)+1);
            }

            //Building the string with characters of pattern
            StringBuilder without = new StringBuilder();
            for(int i = 0;i<s.length();i++){
                char curr = s.charAt(i);
                if(map.containsKey(curr) && map.get(curr) > 0){
                    map.replace(curr,map.get(curr)-1);
                }
                else{
                    without.append(curr);
                }
            }

            //Sorting the new String
            String newS = without.toString();
            char[] temp = newS.toCharArray();
            Arrays.sort(temp);
            newS = new String(temp);

            //Building final string
            StringBuilder finalS = new StringBuilder();
            char toMatch = p.charAt(0); // searching first character in the sorted final answer
            boolean flag = true;
            for(int i = 0;i<newS.length();i++){
                char curr = newS.charAt(i);
                if(curr > toMatch && flag){
                    flag = false;
                    for(int j = 0;j<p.length();j++) {
                        finalS.append(p.charAt(j));
                    }
                }
                finalS.append(curr);
            }

            //If p is to be added at the last of sorted string
            String ans = finalS.toString();
            if(finalS.length() < s.length()){
                ans += p;
            }


            System.out.println(ans);
        }
    }
}
