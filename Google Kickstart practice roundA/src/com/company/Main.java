package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t =scan.nextInt();

        for(int p = 1;p<=t;p++){
            int n = scan.nextInt();
            int b = scan.nextInt();
            int[] arr = new int[n];
            for(int i = 0;i<n;i++){
                arr[i] = scan.nextInt();

            }
            Arrays.sort(arr);
            int i = 0;
            int count = 0;
            while(b>0 && i<arr.length){
                if(b>=arr[i]){
                    b-=arr[i];
                    count++;
                    i++;
                }
                else{
                    break;
                }
            }
            System.out.println("Case #" +p+": "+count);
        }
    }
}
