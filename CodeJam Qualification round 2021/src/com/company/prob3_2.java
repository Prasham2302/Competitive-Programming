package com.company;

import java.util.Scanner;

public class prob3_2 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for(int TestNumber = 1; TestNumber <= t;TestNumber++) {
            int n = scan.nextInt();
            int c = scan.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = i + 1;
            }
        }
    }
}
