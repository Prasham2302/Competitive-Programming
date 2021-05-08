package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MEXSTR {
    static List<String> al = new ArrayList<>();
    private static void findsubsequences(String s, String ans){
        if (s.length() == 0) {
            al.add(ans);
            return;
        }
        findsubsequences(s.substring(1), ans + s.charAt(0));
        findsubsequences(s.substring(1), ans);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t>0){
            t--;
            String s = br.readLine();
            findsubsequences(s,"");
            List<Integer> numbers = new ArrayList<>();
            int[] mat = new int[1000001];
            for(int i = 0;i<al.size()-1;i++){
                String curr = al.get(i);
                int num = Integer.parseInt(curr,2);
                mat[num] += 1;
//                System.out.println(num);
            }
//            System.out.println(Arrays.toString(mat));
            int ans = 0;
            for(int i = 0;i<1000001;i++){
                if(mat[i] == 0){
                    ans = i ;
                    break;
                }
            }
            al.clear();
            System.out.println(Integer.toBinaryString(ans));
        }
    }
}
