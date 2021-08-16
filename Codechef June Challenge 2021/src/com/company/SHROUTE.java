package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class SHROUTE {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while(t>0) {
            t--;
            String[] inp = br.readLine().split(" ");
            int n = Integer.parseInt(inp[0]);
            int m = Integer.parseInt(inp[1]);
            inp = br.readLine().split(" ");
            String[] inp2 = br.readLine().split(" ");
            int[] arr = new int[n];
            for(int i = 1;i<=n;i++){
                arr[i] = Integer.parseInt(inp[i]);
            }
            int[] b = new int[m];
            for(int i = 0;i<m;i++){
                b[i] = Integer.parseInt(inp2[i]);
            }
            int[] leftToRight = new int[n+1];
            int[] rightToLeft = new int[n+1];
            int curr = 1;
            while(curr <= n && arr[curr-1] != 1){
                leftToRight[curr] = -1;
                curr++;
            }
            int leftIdx = curr;
            curr = n;
            while(curr > 1 && arr[curr-1] != 2){
                rightToLeft[curr] = -1;
                curr--;
            }
            int rightIdx = curr;
            leftToRight[1] = 0;
            rightToLeft[1] = 0;
            for(int i = leftIdx;i<=n;i++){
                if(arr[i-1] == 1){
                    leftToRight[i] = 0;
                }
                else{
                    leftToRight[i] = leftToRight[i-1] + 1;
                }
            }
            for(int i = rightIdx;i>0;i--){
                if(arr[i-1] == 2){
                    rightToLeft[i] = 0;
                }
                else {
                    rightToLeft[i] = rightToLeft[i+1] + 1;
                }
            }
//            Arrays.fill(leftToRight, -1);
//            Arrays.fill(rightToLeft, -1);
//            int counter = -1;
//            if(arr[0] == 1){
//                counter = 0;
//                leftToRight[0] = counter;
//                counter++;
//            }
//            for(int i = 1;i<n;i++){
//                if(arr[i] == 1){
//                    counter = 0;
//                }
//                leftToRight[i] = counter;
//                if(counter != -1){
//                    counter++;
//                }
//            }
//            counter = -1;
//            if(arr[n-1] == 2){
//                counter = 0;
//                rightToLeft[0] = counter;
//                counter++;
//            }
//
//            for(int i = n-2;i>=0;i--){
//                if(arr[i] == 2){
//                    counter = 0;
//                }
//                rightToLeft[i] = counter;
//                if(counter!=-1){
//                    counter++;
//                }
//            }
//            System.out.println(Arrays.toString(leftToRight));
//            System.out.println(Arrays.toString(rightToLeft));
            int[] ans = new int[n+1];
            for(int i = 1;i<=n;i++){
                if(leftToRight[i] == -1 || rightToLeft[i] == -1){
                    ans[i] = Math.max(leftToRight[i],rightToLeft[i]);
                }
                else{
                    ans[i] = Math.min(leftToRight[i],rightToLeft[i]);
                }
            }
//            System.out.println(Arrays.toString(ans));
            BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
            for(int i = 0;i<m;i++){
                curr = ans[b[i]];
                output.write(curr+" ");
//                System.out.print(curr+" ");
            }
            output.write("\n");
            output.flush();
//            System.out.println();
        }
    }
}
