package com.company;

import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for(int i = 1;i<= t;i++){
            int n = scan.nextInt();
            int[][] mat = new int[n][n];
            for(int j = 0;j<n;j++){
                for(int k = 0;k<n;k++){
                    mat[j][k] = scan.nextInt();
                }
            }
            int trace = 0;
            int row = 0;
            int col = 0;
            for(int j = 0;j<n;j++){
                HashSet<Integer> set = new HashSet<>();
                boolean flag = true;
                for(int k = 0;k<n;k++){
                    if(j==k){
                        trace += mat[j][k];
                    }
                    if(set.contains(mat[j][k]) && flag){
                        flag = false;
                        row++;
                    }
                    set.add(mat[j][k]);
                }
            }
            for(int j = 0;j<n;j++){
                HashSet<Integer> set = new HashSet<>();
                boolean flag = true;
                for(int k = 0;k<n;k++){
                    if(set.contains(mat[k][j]) && flag){
                        flag = false;
                        col++;
                    }
                    set.add(mat[k][j]);
                }
            }

            System.out.println("Case #"+i+": " + trace +" "+row+" "+col);

        }
    }
}
