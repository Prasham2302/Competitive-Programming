package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class p5 {
    public static void main(String[] args) throws IOException {
//        Scanner scan = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t>0) {
            t--;
            String l = br.readLine();
            String r = br.readLine();
            int i = 0;
            int j = 0;
            String max = l.length() > r.length() ?  l : r;
            String min = l.length() > r.length() ?  r : l;
            int count = 0;
            while(max.length() - i > min.length()){
                char dig = max.charAt(i);

            }

        }
    }
}
