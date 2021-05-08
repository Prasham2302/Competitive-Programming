package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t>0){
            t--;
            int n = scan.nextInt();
            LinkedList<Integer> arr = new LinkedList<>();
            int curr = 1;
            for(;curr<=n;curr*=2){
                arr.addLast(curr);

                n-=curr;
            }
//            System.out.println(arr);
            if(n>0){
                arr.addLast(n);
                Collections.sort(arr);
            }
            ArrayList<Integer> ans = new ArrayList<>();
//            System.out.println(arr);
            for(int i = 1;i<arr.size();i++){
                ans.add(arr.get(i)-arr.get(i-1));
            }
            System.out.println(ans.size());
            for(Integer i : ans){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}
