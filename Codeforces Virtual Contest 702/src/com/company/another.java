package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class another {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t>0){
            t--;
            int n = scan.nextInt();
            int[] arr = new int[n];
            for(int i = 0;i<n;i++){
                arr[i] = scan.nextInt();
            }
            int[] ans = new int[n];
            dfs(arr,ans,0,0,n-1);
//            System.out.println("ans : "+ Arrays.toString(ans));
            for(int i = 0;i<n;i++){
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }

    private static void dfs(int[] arr, int[] ans, int i,int l,int r) {
        if(l > r){
            return;
        }
//        System.out.println(l +" "+r);
//        System.out.println(Arrays.toString(ans));
        int ind = l;
        int max = arr[ind];
        for(int k = l+1;k<=r;k++){
            if(arr[k] > max){
                ind = k;
                max = arr[k];
            }
        }
        ans[ind] = i;
        dfs(arr,ans,i+1,l,ind-1);
        dfs(arr,ans,i+1,ind+1,r);
    }

}
