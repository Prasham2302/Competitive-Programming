package com.company;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t>0){
            t--;
            int n = scan.nextInt();

            int[] arr = new int[n];
            HashMap<Integer,Integer> map = new HashMap<>();
            for(int i = 0;i<n;i++){
                arr[i] = scan.nextInt();
                map.putIfAbsent(arr[i],0);
                map.put(arr[i],map.get(arr[i]) + 1);
            }
            int ans = arr[0];
            for(Integer a: map.keySet()){
                if(map.get(a) == 1){
                    ans = a;
                }
            }
            for(int i = 0;i<n;i++){
                if(arr[i] == ans){
                    System.out.println(i+1);
                }
            }


        }
    }
}
