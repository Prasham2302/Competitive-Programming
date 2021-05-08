package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scan = new Scanner(System.in);
        long t = scan.nextLong();
        while(t>0){
            t--;
            int r = scan.nextInt();
            int c = scan.nextInt();
            int x = scan.nextInt();
            long[][] A = new long[r][c];
            long[][] B = new long[r][c];
            for(int i = 0;i<r;i++){
                for(int j = 0;j<c;j++){
                    A[i][j] = scan.nextLong();
                }
            }
            for(int i = 0;i<r;i++){
                for(int j = 0;j<c;j++){
                    B[i][j] = scan.nextLong();
                }
            }
            for(int i = 0;i<r;i++){
                for(int j = 0;j<c;j++){
                    A[i][j] -= B[i][j];
                }
            }
            for(int i = 0;i<r;i++){
                for(int j = 0;j<c;j++){
                    if(A[i][j] != 0){

                    }
                }
            }
        }
    }
}
