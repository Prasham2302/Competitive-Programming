package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class DivanandaStore {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t> 0 ){
            t--;
            int n = scan.nextInt();
            int l = scan.nextInt();
            int r = scan.nextInt();
            int k = scan.nextInt();
            int[] arr = new int[n];
            for(int i = 0;i<n;i++){
                arr[i] = scan.nextInt();
            }
            Arrays.sort(arr);
            int count = 0;
            for(int i = 0;i<n;i++){
                if(arr[i] < l){
                    continue;
                }
                else if(arr[i] > r){
                    break;
                }
                else if(arr[i] <= k){

                    count++;
                    k-=arr[i];
                }
            }
            System.out.println(count);
        }
    }

}
