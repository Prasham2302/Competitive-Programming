package com.company;

import java.util.Scanner;

public class P3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t>0){
            t--;
            int n = scan.nextInt();
            if(n == 1){
                System.out.println(1);
            }
            else if(n == 2){
                System.out.println(-1);
            }
            else{
                int max = n *n;
                int[][] mat = new int[n][n];
                int i = 0;
                int j = 0;
                boolean toBreak = false;
                int curr= 1;
                while(i<n){
                    while(j<n){
                        mat[i][j] = curr;
                        curr+=2;
                        j++;
                        if(curr > max){
                            toBreak = true;
                            break;
                        }
                    }
                    if(toBreak){
                        break;
                    }
                    j = 0;
                    i += 1;
                }
                curr = 2;
                while(i<n){
                    while(j<n){
                        mat[i][j] = curr;
                        curr+=2;
                        j++;
                    }
                    j = 0;
                    i+=1;
                }
                printmatrix(mat, n);
            }
        }
    }

    private static void printmatrix(int[][] mat, int n) {
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                System.out.print(mat[i][j] +" ");
            }
            System.out.println();
        }
    }
}
