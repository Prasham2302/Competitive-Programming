package com.company;

import java.util.Scanner;

public class P2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t>0){
            t--;
            int n = scan.nextInt();
            int k = scan.nextInt();
            int[] heights = new int[n];
            for(int i = 0;i<n;i++){
                heights[i] = scan.nextInt();
            }
            int start = 0;
            rocks: for(int i = 0; i < k; i++){
                if(start < 0){start=0;}
                for(int a = start; a < n - 1; a++) {
                    if (heights[a] < heights[a + 1]) {
                        start = a - 1;
                        heights[a]++;
                        continue rocks;
                    }
                }
                start = -3;
                break;
            }
            System.out.println(start + 2);
        }
    }
}
