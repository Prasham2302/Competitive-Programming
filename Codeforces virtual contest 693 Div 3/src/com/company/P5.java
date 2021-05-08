package com.company;

import java.util.Scanner;

public class P5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t>0) {
            t--;
            int n = scan.nextInt();
            int[][] person = new int[n][2];

            for(int i = 0;i<n;i++){
                person[i][0] = scan.nextInt();
                person[i][1] = scan.nextInt();
            }
        }
    }
}
