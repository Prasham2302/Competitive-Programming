//package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class TeamName {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t>0){
            t--;
            int n = Integer.parseInt(br.readLine());
            String[] names = br.readLine().split(" ");
            HashMap<String, ArrayList<Character>> body = new HashMap<>();
            for(int i = 0;i<n;i++){
                String curr_body = names[i].substring(1);
                if(body.containsKey(curr_body)){
                    body.get(curr_body).add(Character.valueOf(names[i].charAt(0)));
                }
                else {
                    ArrayList<Character> temp = new ArrayList<>();
                    temp.add(Character.valueOf(names[i].charAt(0)));
                    body.put(curr_body,temp);
                }
            }

            Set<String> set = body.keySet();
//            System.out.println(set);
//            System.out.println(body.values());
            ArrayList<String> body1 = new ArrayList<>();
            for(String i : set){
                body1.add(i);
            }
            int count = 0;
            for(int i = 0;i<body.size();i++){
                for(int j = i+1;j<body.size();j++){
                    ArrayList<Character> a = new ArrayList<>(body.get(body1.get(i)));
                    ArrayList<Character> b = new ArrayList<>(body.get(body1.get(j)));
                    a.addAll(b);
//                    System.out.println(a);
                    Set<Character> set1 = new HashSet<>(a);
//                    System.out.println(body.get(body1.get(i)).size());
                    count+=(set1.size() - body.get(body1.get(i)).size())*(set1.size() - body.get(body1.get(j)).size());
                }
            }
            System.out.println(2*count);
        }
    }
}
