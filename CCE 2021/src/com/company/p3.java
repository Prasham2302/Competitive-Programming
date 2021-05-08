package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class p3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[][] maze = new int[2][n];
        for(int i = 0;i<n;i++){
            maze[0][i] = scan.nextInt();
        }
        for(int i = 0;i<n;i++){
            maze[1][i] = scan.nextInt();
        }

            int dp[][] = new int[2+1][n+1];
            for (int i = 1; i < 2; i++) {
                maze[i][0] += maze[i-1][0];
            }
            for (int i = 1; i < n; i++) {
                maze[0][i] += maze[0][i-1];
            }
//            System.out.println(Arrays.deepToString(maze));
            for (int i = 1; i < 2; i++) {
                for (int j = 1; j < n; j++) {
//                    System.out.println(i +" "+j);
                    maze[i][j] += Math.max(maze[i - 1][j], maze[i][j - 1]);
                }

            System.out.println(maze[1][n-1]);
        }

    }
}
