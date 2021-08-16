package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t>0){
            t--;
            int n = scan.nextInt();
            int[] arr = new int[n];
            int maxIdx = 0;
            int minIdx = 0;
            for(int i = 0;i<n;i++){
                arr[i] = scan.nextInt();
                if(arr[i] < arr[minIdx]){
                    minIdx = i;
                }
                if(arr[i] > arr[maxIdx]){
                    maxIdx = i;
                }
            }
            minIdx++;
            maxIdx++;
            int rightmin = n + 1 - minIdx;
            int rightmax = n+1-maxIdx;
            int move = 0;
            if(minIdx<maxIdx){
                move = Math.min(minIdx + rightmax, Math.min(maxIdx, rightmin));
            }
            else{
                move = Math.min(maxIdx + rightmin, Math.min(minIdx, rightmax));
            }
            System.out.println(move);
        }

    }
}
