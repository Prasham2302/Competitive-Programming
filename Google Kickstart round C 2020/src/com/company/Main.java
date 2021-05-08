//package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for(int p = 1;p <= t ;p++){

            int n = scan.nextInt();
            int k = scan.nextInt();
            int[] arr = new int[n];
            for(int i = 0;i<n;i++){
                arr[i] = scan.nextInt();
            }
            int curr = k;
            int count = 0;
            for(int i = 0;i<n;i++){
                if(arr[i] == curr){
                    if(curr == 1){
                        count++;
                    }
                    curr--;
                }
                else{

                    curr = k;
                    if(arr[i] == curr){
                        if(curr == 1){
                            count++;
                        }
                        curr--;
                    }
                }
            }
            System.out.println("Case #" +p+": "+count);
        }
    }
}
