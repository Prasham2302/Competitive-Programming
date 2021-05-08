package com.company;

import java.util.Scanner;

public class lockedSafe2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t>0) {
            t--;
            int n = scan.nextInt();
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scan.nextLong();
            }
            long count = 0;
            for(int i = 0;i<n;i++){
                for(int j = i;j<n;j++){
                    long And = arr[i];
                    long Or = arr[i];
                    long max = arr[i];
                    for(int k = i+1;k<=j;k++){
                        And = And & arr[k];
                        Or = Or | arr[k];
                        max = Math.max(max,arr[k]);
                    }
                    long Xor = Or ^ And;
//                    System.out.println("Or and And : "+ Or +" "+ And + " ");
                    if(Xor >= max){
//                        System.out.println(i +" "+j);
                        count++;
                    }

                }
            }
//            System.out.println(count);
            long sum = (n*(n+1))/2;
            long prev = -1;
            for(int i = 0;i<n;){
                long count1 = 0;
                prev = arr[i];
                while(i<n&&arr[i]==prev){
                    count1++;
                    i++;
                }
                if(prev!=0){
                    sum-=(count1*(count1+1))/2;
                }
            }
//            System.out.println(sum + " " + count);
            if(sum == count){
                System.out.println("correct");
            }
            else {
                System.out.println("Incorrect");
            }
        }
    }
}
