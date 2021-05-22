package com.company;

import java.util.Scanner;

public class P2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t>0){
                  t--;
            int n = scan.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            int min_a = Integer.MAX_VALUE;
            int min_b = Integer.MAX_VALUE;
            for(int i = 0;i<n;i++){
                a[i] = scan.nextInt();
                min_a = Math.min(min_a, a[i]);
            }

            for(int i = 0;i<n;i++){
                b[i] = scan.nextInt();
                min_b = Math.min(min_b, b[i]);
            }

            long count = 0;
            for(int i = 0;i<n;i++){
                int tempA = a[i] - min_a;
                int tempB = b[i] - min_b;
                count += Math.min(tempA,tempB);
                count += Math.max(tempA,tempB) - Math.min(tempA,tempB);
            }
            System.out.println(count);

        }
    }
}
