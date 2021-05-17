package com.company;

import java.util.Scanner;

public class P5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

            int n = scan.nextInt();
            int[] a = new int[3];
            int[] b = new int[3];
            for(int i = 0;i<3;i++){
                a[i] = scan.nextInt();
            }
            for(int i = 0;i<3;i++){
                b[i] = scan.nextInt();
            }
            int max = Math.min(a[0],b[1]) + Math.min(a[1],b[2]) + Math.min(a[2],b[0]);
            int min = Math.min(a[0], n - b[1]) + Math.min(a[1], n - b[2]) + Math.min(a[2], n-b[0]);
            min = Math.max(0, n - min);
            System.out.println(min +" "+max);

    }

}
