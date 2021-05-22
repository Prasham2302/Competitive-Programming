package com.company;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class P3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t>0){
            t--;
            int n = scan.nextInt();
            int[] w = new int[n];
            for(int i = 0;i<n;i++){
                w[i] = scan.nextInt();
            }
            Arrays.sort(w);
            HashMap<Integer,Integer> map = new HashMap<>();
            //max sum = 2n
            int count = 0;

            for(int target = 1;target<=2*n;target++){
                int curr_count = 0;
                HashSet<String> pair = new HashSet<>();
                for(int i = 0;i<n;i++){
                    for(int j = 0;j<n;j++){
                        if(i == j){
                            continue;
                        }
                        int min = Math.min(i,j);
                        int max = Math.max(i,j);
                        String temp = min +" "+max;
                        if(pair.contains(temp)){
                            continue;
                        }
                        else{
                            pair.add(temp);
                        }
                        if(w[i] + w[j] == target){
                            curr_count++;
                        }
                    }
                }
                count = Math.max(curr_count, count);
            }
            System.out.println(count);
        }
    }
}
