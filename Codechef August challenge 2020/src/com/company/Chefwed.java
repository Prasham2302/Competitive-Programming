package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Chefwed {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t>0){
            t--;
            int n = scan.nextInt();
            int k = scan.nextInt();
            int[] arr = new int[n];
            for(int i = 0;i<n;i++){
                arr[i] = scan.nextInt();
            }
            int[][] mat = new int[n+1][n+1];
            for(int i = 0;i<n;i++){
                HashMap<Integer,Integer> map = new HashMap<>();
                for(int j = i;j<n;j++){
                    if(j == 0){
                        mat[i][j] = 0;
                    }
                    else{
                        mat[i][j] = mat[i][j-1];
                    }
                    if(map.containsKey(arr[j])){
                        if(map.get(arr[j]) == 1){
                            mat[i][j]++;
                        }
                        mat[i][j]++;
                    }
                    map.putIfAbsent(arr[j],0);
                    map.replace(arr[j],map.get(arr[j])+1);
                }
            }
            System.out.println(Arrays.deepToString(mat));
            int ans = Integer.MAX_VALUE;
            int len = 100;
            int[][] dp = new int[101][1001];

            for(int i = 1;i<=n;i++){
                dp[1][i] = mat[0][i-1];
            }
            for(int i = 2;i<=len;i++){
                dp[i][1] = 0;
            }

            for(int i = 2;i<=len;i++){
                for(int j = 2;j<=n;j++){
                    int temp = Integer.MAX_VALUE;
                    for(int l = 1;l<j;l++){
                        temp = Math.min(temp, dp[i-1][l]+mat[l][j-1]);
                    }
                    dp[i][j] = temp;
                }
            }
            for(int i = 0;i<101;i++){
                System.out.println(Arrays.toString(dp[i]));
            }
            for(int i = 1;i<=len;i++){
                ans = Math.min(i*k + dp[i][n],ans);
            }
            System.out.println(ans);
        }
    }
}
