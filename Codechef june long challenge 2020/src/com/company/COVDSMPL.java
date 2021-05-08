package com.company;

import java.util.Random;
import java.util.Scanner;

public class COVDSMPL {
    public static void print(int[][] mat, int n){
        System.out.println("2");
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(j == n-1) {
                    System.out.println(mat[i][j] + " ");
                }
                else{
                    System.out.print(mat[i][j]+" ");
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t>0) {
            t--;
            int n = scan.nextInt();
            int p = scan.nextInt();
            int[][] mat = new int[n][n];
            for(int i = 0;i<n;i++){
                for(int j = 0;j<n;j++){
                    System.out.println("1 "+i+" "+j+" "+i+" "+j);
                    int curr = scan.nextInt();
                    mat[i][j] = curr;
                }
            }
            print(mat,n);
        }
    }
}
