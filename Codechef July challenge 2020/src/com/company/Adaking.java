package com.company;

import java.util.Scanner;

public class Adaking {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t>0){
            t--;
            int k = scan.nextInt();
            char[][] board = new char[8][8];
            for(int i = 0;i<8;i++){
                for(int j = 0;j<8;j++){
                    if(i == 0 && j == 0){
                        board[0][0] = 'O';
                        k--;
                    }
                    else if(k>0){
                        k--;
                        board[i][j] = '.';
                    }
                    else{
                        board[i][j] = 'X';
                    }
                    System.out.print(board[i][j]);
                }
                System.out.println();
            }

        }
    }
}
