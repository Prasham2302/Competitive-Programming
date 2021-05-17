package com.company;

import java.util.Scanner;

public class P5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
//        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
//        int t = Integer.parseInt(br.readLine());

            int n = scan.nextInt();
            long factorial = 1;
            for(int i = 1;i<n;i++){
                factorial *= i;
            }

            factorial *= 2;
            factorial /= n;
            System.out.println(factorial);

    }
}
