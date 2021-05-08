package com.company;

import java.util.HashMap;
import java.util.Scanner;

public class P4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t>0){
            t--;
            int n = scan.nextInt();
            long[] arr = new long[n];
            for(int i = 0;i<n;i++){
                arr[i] = scan.nextLong();
            }
            long count = 0;
            HashMap<Long,Long> map = new HashMap<>();
            for(int i = 0;i<n;i++){
                map.putIfAbsent(arr[i] - i, (long) 0);
                map.put(arr[i]-i,map.get(arr[i]-i)+1);
            }
            for(Long x : map.values()){
//                System.out.println(x);
                count += (x *(x-1))/2;
            }
            System.out.println(count);
        }
    }
}
