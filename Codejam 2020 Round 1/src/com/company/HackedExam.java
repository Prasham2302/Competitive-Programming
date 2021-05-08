package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class HackedExam {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int test = 1;test<=t;test++){
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int q = Integer.parseInt(input[1]);
            String[][] students = new String[n][2];
            for(int i = 0;i<n;i++){
                students[i] = br.readLine().split(" ");
            }
            int max = 0;
            int idx = 0;
            for(int i = 0;i<n;i++){
                int curr = Integer.parseInt(students[i][1]);
                if(curr > max){
                    idx = i;
                    max = curr;
                }
            }
            System.out.println("Case #"+test+": "+students[idx][0] + " "+students[idx][1] + "/1");
        }
    }
}
