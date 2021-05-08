package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t>0){
            t--;
            int n = scan.nextInt();
            int[] arr = new int[n];
            for(int i = 0;i<n;i++){
                arr[i] = scan.nextInt();
            }
            int left = 0;
            int right = n-1;
            while(left<right){
                System.out.print(arr[left] +" ");
                System.out.print(arr[right]+ " ");
                left++;
                right--;
            }
            if(left == right){
                System.out.print(arr[left]);
            }
            System.out.println();
        }
    }
}
