package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scan = new Scanner(System.in);
        int A = scan.nextInt();
        int B = scan.nextInt();
        int C = scan.nextInt();
        int X = scan.nextInt();
        int ans = 0;
        int[] curr = new int[]{50,100,500};
        int[] count = new int[3];
        count[0] = C;
        count[1] = B;
        count[2] = A;
        int[][] dp = new int[X+1][3+1];
        for(int i = 1;i<=X;i++){
            for(int j = 1;j<=3;j++){
                for(int k = 1;k<=count[j-1];k++){
                    if(i>curr[j-1] * k){
                        dp[i][j] += dp[i-count[j-1] * k][j-1];
                    }
                    if( i == count[j-1] * k){
                        dp[i][j] += 1;
                    }
                }
            }
        }
        for(int i = 0;i<= 3;i++){
            ans += dp[X][i];
        }
        System.out.println(ans);


    }
}
