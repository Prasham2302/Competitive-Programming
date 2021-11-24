package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class LinearKeyboard {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t > 0){
            t--;
            String str = br.readLine();
            String word = br.readLine();
            HashMap<Character, Integer> map = new HashMap<>();
            for(int i = 0;i<26;i++){
                char ch = str.charAt(i);
                map.put(ch,i);
            }
            int sum = 0;
            int prev = map.get(word.charAt(0));
            for(int i = 1;i<word.length();i++){
                char ch = word.charAt(i);
                int curr = map.get(ch);
                sum += Math.abs(curr - prev);
                prev = curr;
            }
            System.out.println(sum);
        }
    }
}
