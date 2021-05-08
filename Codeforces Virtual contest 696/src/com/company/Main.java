package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        Scanner scan = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while(t>0){
            t--;
            int n = Integer.parseInt(br.readLine());
            int prev = -1;
            char[] arr = br.readLine().toCharArray();
            StringBuilder ans = new StringBuilder();
            for(int i = 0;i<n;i++){
                int curr = Character.getNumericValue(arr[i]);
                curr++;
                if(curr == prev){
                    ans.append('0');
                    prev = curr;
                }
                else{
                    prev = curr;
                    ans.append('1');
                }
            }
            System.out.println(ans.toString());
        }
    }
}
