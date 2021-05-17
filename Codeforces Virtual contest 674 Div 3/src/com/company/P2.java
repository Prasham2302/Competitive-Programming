package com.company;

import java.util.Scanner;


public class P2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t>0){
            t--;
            int n = scan.nextInt();
            int m = scan.nextInt();

            boolean ans = false;
            for(int i = 0;i<n;i++){
                int a = scan.nextInt();
                int b = scan.nextInt();
                int c = scan.nextInt();
                int d = scan.nextInt();
                ans = b == c || ans;
            }
            if(m%2 == 1){
                System.out.println("NO");
            }
            else{
                if(ans == true){
                    System.out.println("YES");
                }
                else{
                    System.out.println("NO");
                }
            }
        }
    }
}
