package com.company;

import java.util.Scanner;

public class WirEl {
    public static void swap(int[][] arr, int r1,int r2,int c1){
        int temp = arr[r1][c1];
        arr[r1][c1] = arr[r2][c1];
        arr[r1][c1] = temp;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[][] xy = new int[2][n];
        int[][] abcd = new int[4][m];
        for(int i = 0;i<n;i++){
            int x = scan.nextInt();
            int y = scan.nextInt();
            xy[0][i] = x;
            xy[1][i] = y;
        }
        for(int j = 0;j<m;j++){
            abcd[0][j] = scan.nextInt();
            abcd[1][j] = scan.nextInt();
            abcd[2][j] = scan.nextInt();
            abcd[3][j] = scan.nextInt();
        }
        for(int i = 0;i<m;i++){
            if(abcd[0][i] > abcd[2][i]){
                swap(abcd,0,2,i);
                swap(abcd,1,3,i);
            }
            if(i%2 == 0){
                System.out.println(-abcd[0][i] +" "+ (-abcd[1][i]-1));
            }
            else{
                System.out.println((1000000+1-abcd[0][i]) +" "+ (1000000-abcd[1][i]));
            }

        }
    }
}
