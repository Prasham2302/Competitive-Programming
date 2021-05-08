package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class ConsAdd {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long t = scan.nextLong();
        while(t>0) {
            t--;
            int r = scan.nextInt();
            int c = scan.nextInt();;
            int x = scan.nextInt();;
            long[][] A = new long[r][c];
            long[][] B = new long[r][c];
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    A[i][j] = scan.nextLong();
                }
            }
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    B[i][j] = scan.nextLong();
                }
            }
//            System.out.prlongln("Input");
//
//            System.out.prlongln("A " + Arrays.deepToString(A));
//            System.out.prlongln("B " + Arrays.deepToString(B));
            for(int i = 0;i<r;i++){
                for(int j = 0;j<c-x+1;j++){
                    if(A[i][j] != B[i][j]) {
                        long diff = B[i][j] - A[i][j];
//                        System.out.prlongln(diff);
//                        System.out.println("Before "+ Arrays.deepToString(A));
                        for (int k = j; k < j + x; k++) {
//                            System.out.prlongln("In loop "+ A[i][k] +" "+diff);
                            A[i][k] += diff;
                        }
//                        System.out.println("After " + Arrays.deepToString(A));
                    }
                }
            }
//            System.out.println(Arrays.deepToString(A));
            Boolean ans = true;
            for(int i = 0;i<c;i++){
                if(ans == false){
                    break;
                }
                for(int j = 0;j<r-x+1;j++){
                    if(A[j][i] != B[j][i]){
                        long diff = B[j][i] - A[j][i];
                        for(int k = j;k<j+x;k++){
                            A[k][i] += diff;
                        }
                    }
                    if(j == r-x){
                        for(int k = j+1;k<r;k++){
                            if(A[k][i] != B[k][i]){
                                ans = false;
                                break;
                            }
                        }
                    }
                }
            }
            System.out.println(Arrays.deepToString(A));
            if(ans == false){
                System.out.println("NO");
            }
            else{
                System.out.println("YES");
            }
        }
    }
}
