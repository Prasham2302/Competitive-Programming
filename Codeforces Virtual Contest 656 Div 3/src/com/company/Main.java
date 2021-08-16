package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t>0){
            t--;
            int[] arr = new int[3];
            arr[0] = scan.nextInt();
            arr[1] = scan.nextInt();
            arr[2] = scan.nextInt();
            Arrays.sort(arr);

            if(arr[2] == arr[1]){
                System.out.println("YES");
                System.out.println(arr[0] +" "+ arr[0] +" "+arr[2]);

            }
            else{
                System.out.println("NO");
            }
        }
    }
}
