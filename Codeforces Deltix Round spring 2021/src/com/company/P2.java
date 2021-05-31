package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class P2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t>0){
            t--;
            int n = scan.nextInt();
            int[] arr = new int[n];
            for(int i = 0;i<n;i++){
                arr[i] = scan.nextInt();
            }
            ArrayList<String> ans = new ArrayList<>();
            int i = 0;
            while(i<n){

                arr[i] = arr[i] + arr[i+1];
                arr[i+1] = arr[i+1] - arr[i];
                arr[i] = arr[i] + arr[i+1];

                String inp1 = "1 " + (i+1) +" "+(i+2);
                String inp2 = "2 " + (i+1) +" "+(i+2);

                ans.add(inp1);
                ans.add(inp2);
                ans.add(inp1);

                arr[i+1] = arr[i+1] - arr[i];
                arr[i] = arr[i] + arr[i+1];
                arr[i+1] = arr[i+1] - arr[i];

                ans.add(inp2);
                ans.add(inp1);
                ans.add(inp2);

                i+=2;
            }
//            System.out.println(Arrays.toString(arr));

            System.out.println(ans.size());
            for(i = 0;i<ans.size();i++){
                System.out.println(ans.get(i));
            }
        }
    }
}
