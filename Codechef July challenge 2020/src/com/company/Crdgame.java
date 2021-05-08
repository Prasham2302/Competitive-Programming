package com.company;

import java.util.Scanner;

public class Crdgame {
    public static int numsum(int n){
        int sum = 0;
        while(n>0){
            sum+=n%10;
            n/=10;
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t>0){
            t--;
            int n = scan.nextInt();
            int chef = 0;
            int morty = 0;
            while(n>0){
                n--;
                int a = scan.nextInt();
                int b = scan.nextInt();
                int sum_a = numsum(a);
                int sum_b = numsum(b);
                if(sum_a == sum_b){
                    chef++;
                    morty++;
                }
                else if(sum_a<sum_b){
                    morty++;
                }
                else{
                    chef++;
                }
            }
            if(chef == morty){
                System.out.println(2+" "+chef);
            }
            else if(chef>morty){
                System.out.println(0+" "+chef);
            }
            else{
                System.out.println(1+" "+morty);
            }
        }
    }
}
