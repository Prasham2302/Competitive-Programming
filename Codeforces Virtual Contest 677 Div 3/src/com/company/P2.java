package com.company;

import java.util.Scanner;

public class P2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
//        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
//        int t = Integer.parseInt(br.readLine());
        int t = scan.nextInt();
        while(t>0) {
            t--;
            int n = scan.nextInt();
            int[] arr = new int[n];
            for(int i = 0;i<n;i++){
                arr[i] = scan.nextInt();
            }
            int left = 0;
            int right = n-1;
            while(arr[left] != 1){
                left++;
            }
            while(arr[right] != 1){
                right--;
            }
            int count = 0;
            int prev =arr[left];
            for(int i = left+1;i<=right;i++){
                if(arr[i] == 0){
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
