package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class P2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t>0){
            t--;
            int n = scan.nextInt();
            int[] arr = new int[n];
            long sum = 0;
            long count1 = 0;
            long count2 = 0;
            for(int i = 0;i<n;i++){
                arr[i] = scan.nextInt();
                if(arr[i] == 1){
                    count1++;
                }
                else{
                    count2++;
                }
            }

            if(count1%2 == 0 && (count2%2 == 0 || count1>=2)){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }
    }
}
