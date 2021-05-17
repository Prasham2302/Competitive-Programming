    package com.company;

    import java.util.Scanner;

    public class Main {

        public static void main(String[] args) {
        // write your code here
            Scanner scan = new Scanner(System.in);
            int t = scan.nextInt();
            while(t>0){
                t--;
                int n = scan.nextInt();
                int x = scan.nextInt();
                if(n < 3){
                    System.out.println(1);
                }
                else{
                    n -= 2;
                    if(n%x == 0){
                        System.out.println(n/x+1);
                    }
                    else {
                        System.out.println(n / x + 2);
                    }
                }
            }
        }
    }
