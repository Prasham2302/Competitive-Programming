package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class MinimumExtractions {
    public static void main(String[] args) throws IOException {
//        Scanner scan = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t > 0){
            t--;
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] split = br.readLine().split(" ");
            for(int i = 0;i<n;i++){
                arr[i] = Integer.parseInt(split[i]);
            }
            Arrays.sort(arr);
            int min = arr[0];
            for(int i = 1;i<n;i++){
                min = Math.max(min, arr[i] - arr[i-1]);
//                System.out.println(Arrays.toString(arr));
            }
            System.out.println(min);

        }
    }
}
