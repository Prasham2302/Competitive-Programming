package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
//        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t>0){
            t--;
            int n = scan.nextInt();

                ArrayList<Integer> arr = new ArrayList<Integer>();
                int i = 1;
                while(i < n){
                    arr.add(i+1);
                    arr.add(i);
                    i+=2;
                }
//                System.out.println(arr);
                if(n % 2 == 1){
                    arr.add(n);
                    int temp = arr.get(n-2);
                    arr.set(n-2,n);

                    arr.set(n-1,temp);
                }
                for(i = 0;i<arr.size();i++){
                    System.out.print(arr.get(i) +" ");
                }
                System.out.println();

        }
    }
}
