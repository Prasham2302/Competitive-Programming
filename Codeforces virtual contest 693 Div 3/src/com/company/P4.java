package com.company;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class P4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t>0) {
            t--;
            int  n = scan.nextInt();
            Integer[] arr = new Integer[n];
            for(int i = 0;i<n;i++){
                arr[i] = scan.nextInt();
            }
            Arrays.sort(arr, Collections.reverseOrder());
            long alice = 0, bob = 0;
            for(int i = 0;i<n;i++){
                if(i%2 == 0){
                    if(arr[i]%2 == 0){
                        alice+=arr[i];
                    }
                }
                else{
                    if(arr[i]%2 == 1){
                        bob+=arr[i];
                    }
                }
            }
            if(alice == bob){
                System.out.println("Tie");
            }
            else if(alice > bob){
                System.out.println("Alice");
            }
            else{
                System.out.println("Bob");
            }
        }
    }
}
