package com.company;

import java.util.Scanner;

public class P3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
//        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
//        int t = Integer.parseInt(br.readLine());
        int t = scan.nextInt();
        while(t>0) {
            t--;
            int n = scan.nextInt();
            int[] arr = new int[n];
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                arr[i] = scan.nextInt();
                max = Math.max(max,arr[i]);
                min = Math.min(min,arr[i]);
            }
            if(max == min){
                System.out.println(-1);
            }
            else{
                int left = 0;
                while(arr[left] != max){
                    left++;
                }
                if(left == 0){
                    while(arr[left] == arr[left+1]){
                        left++;
                    }
                }
                System.out.println(left+1);
            }
        }
    }
}
