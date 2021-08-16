package com.company;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class P2 {
    public static void main(String[] args) {
        //        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t>0){
            t--;
            int n = scan.nextInt();
            int[] arr = new int[n];
            HashMap<Integer,Integer> map = new HashMap<>();
            for(int i = 0;i<n;i++){
                arr[i] = scan.nextInt();
                map.put(arr[i],i+1);
            }
            Arrays.sort(arr);
            int count = 0;
            for(int i = 0;i<n;i++){
                for(int j = 0;j<n;j++){
//                    System.out.print(arr[i] +" "+ arr[j]+" ");
                    if(i == j){
                        continue;
                    }
                    if(arr[i] * arr[j] > 2 * n){
                        break;
                    }
                    if(arr[i] * arr[j] == map.get(arr[i]) + map.get(arr[j])){
//                        System.out.print("pair");
                        count++;
                    }
//                    System.out.println();
                }
            }
//            System.out.println(count);
            System.out.println(count/2);
        }
    }
}
