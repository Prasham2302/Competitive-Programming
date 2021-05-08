//package com.company;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Frogs {
    public static boolean check(HashMap<Integer,Integer> pos, int curr){
        int count = 0;
        for(Integer i : pos.keySet()){
//            System.out.println(i+" "+count);
            if(pos.get(i) < pos.get(curr) && i < curr){
                count++;
            }
        }
        if(count >= curr-1)
            return true;
        else
            return false;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t>0){
            t--;
            int n = scan.nextInt();
            int[] w = new int[n];
            int[] l = new int[n];
            //stores the current location of frogs
            HashMap<Integer,Integer> pos = new HashMap<>();
            HashMap<Integer,Integer> step = new HashMap<>();
            for(int i = 0;i<n;i++){
                w[i] = scan.nextInt();
                pos.put(w[i],i);
            }
            for(int i = 0;i<n;i++){
                l[i] = scan.nextInt();
                step.put(w[i],l[i]);
            }
            Arrays.sort(w);
//            System.out.println(Arrays.toString(w));
//            for(int i = 0;i<n;i++){
//                System.out.print(pos.get(w[i])+" ");
//            }
//            System.out.println();
//            for(int i = 0;i<n;i++){
//                System.out.print(step.get(w[i])+" ");
//            }
            int count = 0;
            for(int i = 1;i<n;i++){
                int curr_weight = w[i];
                int curr_pos = pos.get(curr_weight);
                int curr_step = step.get(curr_weight);
//                System.out.println(curr_weight+" "+curr_pos+" "+curr_step);
                while(check(pos,curr_weight) == false){
//                    for(int k = 0;k<n;k++){
//                        System.out.print(pos.get(w[k])+" ");
//                    }
//                    System.out.println();

                    curr_pos += curr_step;
                    pos.replace(curr_weight,curr_pos);
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
