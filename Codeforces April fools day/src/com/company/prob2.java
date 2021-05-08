package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class prob2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp = br.readLine();
        double t = Math.random();
        if(t<0.5){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }
    }
}
