package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class p4 {
    public static ArrayList<Integer> primeFactors(int n)
    {
        ArrayList<Integer> arr = new ArrayList<>();
        while (n%2==0)
        {
            arr.add(2);
            n /= 2;
        }
        for (int i = 3; i <= Math.sqrt(n); i+= 2)
        {
            while (n%i == 0)
            {
                arr.add(i);
                n /= i;
            }
        }
        if (n > 2)
            arr.add(n);
        return arr;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t>0) {
            t--;
            int a = scan.nextInt();
            int b = scan.nextInt();
            int k = scan.nextInt();

            if(k == 1){
                if(a == b){
                    System.out.println("NO");
                    continue;
                }
                if(Math.max(a,b) % Math.min(a,b) == 0){
                    System.out.println("YES");
                }
                else{
                    System.out.println("NO");
                }
            }
            else{
                ArrayList<Integer> prime_a = primeFactors(a);
                ArrayList<Integer> prime_b = primeFactors(b);
//                System.out.println(prime_a);
//                System.out.println(prime_b);
                int size = prime_a.size() + prime_b.size();
                if(size >= k){
                    System.out.println("YES");
                }
                else{
                    System.out.println("NO");
                }
            }
        }
    }
}