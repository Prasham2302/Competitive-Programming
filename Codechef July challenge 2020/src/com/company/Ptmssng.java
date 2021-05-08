package com.company;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

public class Ptmssng {
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t>0){
            t--;
            int n = Integer.parseInt(br.readLine());
            
            int[][] pts = new int[4*n-1][2];
            HashMap<Integer,Integer> y_map = new HashMap<>();
            HashMap<Integer,Integer> x_map = new HashMap<>();
            int curr = 0;
            for(int i = 0;i<4*n-1;i++){
                String[] temp = br.readLine().split(" ");
                pts[i][0] = Integer.parseInt(temp[0]);
                pts[i][1] = Integer.parseInt(temp[1]);
                curr = pts[i][1];
                y_map.putIfAbsent(curr,0);
                y_map.replace(curr,y_map.get(curr)+1);
                curr = pts[i][0];
                x_map.putIfAbsent(curr,0);
                x_map.replace(curr,x_map.get(curr)+1);
            }

            int x = 0;
            int y= 0;

            for(int i = 0;i<4*n-1;i++){
                if(x_map.get(pts[i][0])%2 == 1){
                    x = pts[i][0];
                }
                if(y_map.get(pts[i][1])%2 == 1){
                    y = pts[i][1];
                }
            }
            System.out.println(x+" "+y);
        }
    }
}
