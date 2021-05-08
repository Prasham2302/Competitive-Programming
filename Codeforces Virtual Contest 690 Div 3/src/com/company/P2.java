package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class P2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t>0){
            t--;
            int n = Integer.parseInt(br.readLine());
            String inp = br.readLine();
            if(inp.startsWith("2") && inp.endsWith("020")){
                System.out.println("YES");
            }
            else if(inp.startsWith("20") && inp.endsWith("20")){
                System.out.println("YES");
            }
            else if(inp.startsWith("202") && inp.endsWith("0")){
                System.out.println("YES");
            }
            else if(inp.startsWith("2020")){
                System.out.println("YES");
            }
            else if(inp.endsWith("2020")){
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }


        }
    }
}
