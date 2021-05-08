package com.company;

import java.io.*;
import java.util.Scanner;

public class evenMatrix {
    public static void solve(int[][] mat, int n ){
        int count = 1;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(j == n-1){
                    if(n%2 == 0 && i%2 == 1){
                        System.out.println(count+n-j-j-1);
                        count++;
                    }
                    else {
                        System.out.println(count);
                        count++;
                    }
                }
                else{
                    if(n%2 == 0 && i%2 == 1){
                        System.out.print((count+n-j-1-j)+ " ");
                        count++;
                    }
                    else {
                        System.out.print(count + " ");
                        count++;
                    }
                }

            }

        }
        //print(mat,n);

    }

    public static void print(int[][] mat, int n){
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(j==n-1){
                    System.out.println(mat[i][j]);
                }
                else{
                    System.out.print(mat[i][j]+" ");
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t>0){
            t--;
            int n = scan.nextInt();
            int[][] mat = new int[n][n];
            solve(mat,n);
            //print(mat,n);
        }
    }
}
