package com.company;

import java.util.Scanner;

public class P3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t-- >0){
            int k = scan.nextInt();
            int row = (int) Math.ceil(Math.sqrt(k));
            int square = row * row;
            int diff = square - k;
            int currRow = row;
            int currCol = 1;
            if(diff >= row){
                currCol = row;
                currRow--;
                diff-= row;
                currRow -= diff;
            }
            else{
                currCol += diff;
            }
            System.out.println(currRow +" "+currCol);
        }
    }
}
