package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CHAOSEMP2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        int t = Integer.parseInt(st[0]);
        int q = Integer.parseInt(st[1]);
        int d = Integer.parseInt(st[2]);
        while(t>0) {
            t--;
            long l = -2*((long) Math.pow(10,18));
            long y1 = -2*((long) Math.pow(10,18)) ;
            long r = 2*((long) Math.pow(10,18)) ;
            long y2 = 2*((long) Math.pow(10,18));
            String ans = "";
            boolean hellfire = true;
            while(l<=r){
                long mid = (l+r)/2;
                if(hellfire){
                    System.out.println(1 +" "+mid +" "+y1);
                    System.out.flush();
                }
                else{
                    System.out.println(2+" "+mid+" "+y1+" "+mid+" "+y2);
                    System.out.flush();
                }
                ans = br.readLine();
                if(ans.charAt(0) == 'X'){
                    hellfire = false;
                }
                else if(ans.charAt(0) == 'N'){
                    l = mid + 1;
                }
                else if(ans.charAt(0) == 'P'){
                    r= mid-1;
                }
                else if(ans.charAt(0) == 'O'){
                    break;
                }
                else if(ans.equals("FAILED")) {
                    break;
                }
            }

        }
        br.close();

    }
}
