package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class CRDGAME3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s= br.readLine().split(" ");
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t>0){
            t--;
            int c = scan.nextInt();
            int r = scan.nextInt();
            double countC  = Math.ceil((double)c/9);
            double countR = Math.ceil((double)r/9);
            if(countC<countR){
                System.out.println("0 "+(int)countC);
            }
            else{
                System.out.println("1 "+(int)countR);
            }
        }
    }
}
