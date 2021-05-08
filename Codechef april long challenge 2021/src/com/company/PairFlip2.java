package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class PairFlip2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t>0) {
            t--;
            String[] temp = br.readLine().split(" ");
            int n = Integer.parseInt(temp[0]);
            int m = Integer.parseInt(temp[1]);
            int e = Integer.parseInt(temp[2]);
            String[] a = new String[n];
            String[] b = new String[n];
            for (int i = 0; i < n; i++) {
                a[i] = (br.readLine());
            }
            for (int i = 0; i < n; i++) {
                b[i] = (br.readLine());
            }
            ArrayList<String> operations = new ArrayList<>();
            long count = 0;
            boolean[][] mat = new boolean[n][m];
            boolean toFlip = true;
            for(int i = 0;i<n;i++){
                int prev = 0;
                toFlip = true;
                for(int j = 0;j<m;j++){
                    char curr = a[i].charAt(j);
                    if(curr == '1' && toFlip && mat[i][j] == false){
                        prev = j;
                        toFlip = false;
                    }
                    else if(curr == '1' && toFlip == false && mat[i][j] == false){
                        toFlip = true;
                        String toAdd = "R "+(i+1)+" "+(prev+1)+" "+(j+1);
                        operations.add(toAdd);
                        count++;
                        mat[i][prev] = true;
                        mat[i][j] = true;
                    }
                }
            }
            for(int i = 0;i<m;i++){
                int prev = 0;
                toFlip = true;
                for(int j = 0;j<n;j++){
                    char curr = a[j].charAt(i);
                    if(curr == '1' && toFlip && mat[j][i] == false){
                        prev = j;
                        toFlip = false;
                    }
                    else if(curr == '1' && toFlip == false && mat[j][i] == false){
                        toFlip = true;
                        String toAdd = "C "+(i+1)+" "+(prev+1)+" "+(j+1);
                        operations.add(toAdd);
                        count++;
                        mat[prev][i] = true;
                        mat[j][i] = true;
                    }
                }
            }
            boolean failed  = false;
            for(int i = 0;i<n;i++){
                if(failed){
                    break;
                }
                for(int j = 0;j<m;j++){
                    char curr = a[i].charAt(j);
                    if(curr == '1' && mat[i][j] == false){
                        failed = true;
                        break;
                    }
                }
            }
//            System.out.println(Arrays.deepToString(a));
            if(failed){
                System.out.println(-1);
            }
            else if(e == 0)
                System.out.println(count);
            else{
                System.out.println(count);
                printoutput(operations);
            }
        }
    }
    private static void printoutput(ArrayList<String> operations) {
        for(int i = 0;i<operations.size();i++){
            System.out.println(operations.get(i));
        }
    }
}
