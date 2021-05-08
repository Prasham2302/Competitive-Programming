package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t>0){
            t--;
            int n = Integer.parseInt(br.readLine());
            char[][] arr = new char[n][n];
            for(int i = 0;i<n;i++){
                String str = br.readLine();
                arr[i] = str.toCharArray();
            }
            int x1 = 0, x2 = 0, x3 = 0,x4 = 0;
            int y1 = 0, y2=0,y3=0,y4=0;
            boolean point1 = false;
            for(int i =0;i<n;i++){
                for(int j = 0;j<n;j++){
                    if(arr[i][j] == '*'){
                        if(point1 == false){
                            x1 = i;
                            y1 = j;
                            point1 = true;
                        }
                        else{
                            x2 = i;
                            y2 = j;
                        }
                    }
                }
            }
            if(x1 == x2){
                y3 = y1;
                y4 = y2;
                if(x1 == 0){
                    x3=x1+ 1;
                    x4=x1+1;
                }
                else{
                    x3 = x1-1;
                    x4 = x1-1;
                }
            }
            else if(y1 == y2){
                x3 = x1;
                x4 = x2;
                if(y1 == 0){
                    y3=y1+ 1;
                    y4=y1+1;
                }
                else{
                    y3 = y1-1;
                    y4 = y1-1;
                }
            }
            else{
                x3 = x2;
                y3 = y1;
                x4 = x1;
                y4 = y2;
            }
            arr[x3][y3] = '*';
            arr[x4][y4] = '*';
            for(int i = 0;i<n;i++){
                System.out.println(String.valueOf(arr[i]));


            }
        }
    }
}
