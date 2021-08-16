package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class P3  {


    public static void main(String[] args) throws IOException {
//        Scanner scan = new Scanner(System.in);
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
//        int t = scan.nextInt();
        while(t>0){
            t--;
            String s = br.readLine();
            int len = s.length();
            int[] track0 = new int[len+1];
            int[] track1 = new int[len+1];
            long count = 0;
            for(int i = 1;i<len+1;i++){
                char curr = s.charAt(i-1);
                if(curr == '0'){
                    track0[i] = track1[i-1] + 1;
                    track1[i] = 0;
                }
                else if(curr == '1'){
                    track1[i] = track0[i-1]+1;
                    track0[i] = 0;
                }
                else{
                    track0[i] = track1[i-1] + 1;
                    track1[i] = track0[i-1] + 1;
                }
            }
//            System.out.println(Arrays.toString(track0));
//            System.out.println(Arrays.toString(track1));
            for(int i = 0;i<=len;i++){
                count =  count + Math.max(track0[i],track1[i]);
            }
            System.out.println(count);

        }
    }
}
