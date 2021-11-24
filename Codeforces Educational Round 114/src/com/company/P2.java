package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class P2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        HashMap<Integer, ArrayList<String>> map = new HashMap<>();
        while(t > 0){
            t--;
            int a = scan.nextInt();
            int b = scan.nextInt();
            int c = scan.nextInt();
            int m = scan.nextInt();
            int count = 0;
            count += a-1;
            count += b-1;
            count += c-1;
            int[] arr = new int[3];
            arr[0] = a;
            arr[1] = b;
            arr[2] = c;
            Arrays.sort(arr);
            if(count < m){
                System.out.println("NO");
            }
            else{
                int rem = 0;
                if(arr[2] - 1 >= m){
                    rem += arr[2] - 1 - m;
                    if(arr[1] + arr[2] >= rem){
                        System.out.println("YES");
                    }
                    else{
                        System.out.println("NO");
                    }
                }
                else if(arr[1] + arr[2] - 2 >= m){
                    rem += arr[1] + arr[2] - 2 - m;
                    if(arr[0] >= rem){
                        System.out.println("YES");
                    }
                    else{
                        System.out.println("NO");
                    }
                }
                else{
                    System.out.println("YES");
                }
            }
        }
    }

}
