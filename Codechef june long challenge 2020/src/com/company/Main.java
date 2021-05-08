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
            int n = scan.nextInt();
            int[] arr = new int[n];
            for(int i = 0;i<n;i++){
                arr[i] = scan.nextInt();
            }
            boolean flag = true;
            int count5 = 0;
            int count10 = 0;
            for(int i = 0;i<n;i++){
                if(arr[i] == 5){
                    count5++;
                }
                if(arr[i] == 10){
                    if(count5<1){
                        flag = false;
                        break;
                    }
                    else{
                        count5--;
                        count10++;
                    }
                }
                if(arr[i] == 15) {
                    if (count10 > 0) {
                        count10--;
                    } else if (count5 > 1) {
                        count5 -= 2;
                    } else {
                        flag = false;
                        break;
                    }
                }
            }
            if(flag) {
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }
    }
}
