package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        Scanner scan = new Scanner(System.in);
//        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
//        int t = Integer.parseInt(br.readLine());
        int t = scan.nextInt();
        while(t>0){
            t--;
            int[] arr = new int[4];
            for(int i = 0;i<4;i++){
                arr[i] = scan.nextInt();
            }
            int a = Math.max(arr[1],arr[0]);
            int b = Math.max(arr[2],arr[3]);
            Arrays.sort(arr);
            int max1 = arr[3];
            int max2 = arr[2];
            if(Math.max(max1,max2) == Math.max(a,b) && Math.min(max1,max2) == Math.min(a,b)){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }
    }
}
