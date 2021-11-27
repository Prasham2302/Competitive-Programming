package com.company;

import java.util.Scanner;

public class SpecialPermutation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t> 0){
            t--;
            int n = scan.nextInt();
            int a = scan.nextInt();
            int b = scan.nextInt();
            int[] arr = new int[n];
            int countless = b-1;
            int countmore = n-a;
            if(a < b){
                countless--;
                countmore--;
            }
            if(countless < n/2 || countmore < n/2){
                System.out.println("-1");
                continue;
            }
            arr[0] = a;
            arr[n-1] = b;
            if(n > 2){
                int num = n;
                for(int i = 1;i<n/2;i++){
                    arr[i] = num;
                    if(arr[i] == b || arr[i] == a){
                        arr[i]--;
                    }
                    num--;
                }
                num =1;
                for(int i = n-2;i>=n/2;i--){
                    arr[i] = num;
                    if(arr[i] == a ){
                        arr[i]++;
                    }
                }
            }
            for(int i = 0;i<n;i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
        }
    }
}
