package com.company;

import java.util.Scanner;

public class colglife2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t>0) {
            t--;
            long n = scan.nextLong();
            long e = scan.nextLong();
            long h = scan.nextLong();
            long a = scan.nextLong();
            long b = scan.nextLong();
            long c = scan.nextLong();
            long counter = 0;

                long cost = Long.MAX_VALUE;
                for (long i = 0; i <= Math.min(n, Math.min(e, h)); i++) {
                    long items = i;
                    long curr_cost = i * c;
                    long curr_eggs = e - i;
                    long curr_choco = h - i;
                    long cakes = i, omelette = 0, shakes = 0;
                    if (a < b) {
                        if (curr_eggs > 0 && items < n) {
                            long can_make = curr_eggs/2;
                            if(can_make + items > n){
                                long required = n - items;
                                items += required;
                                curr_cost += required * a;
                            }
                            else{
                                items += curr_eggs / 2;
                                omelette += curr_eggs / 2;
                                curr_cost += (curr_eggs / 2) * a;
                            }
                        }
                        long required = n - items;
                        if (curr_choco / 3 >= required) {
                            shakes += required;
                            curr_cost += required * b;
                        } else {
                            curr_cost = Long.MAX_VALUE;
                        }
                    } else {
                        if (curr_choco > 0 && items < n) {
                            long can_make = curr_choco / 3;
                            if(can_make + items > n){
                                long required = n-items;
                                items += required;
                                curr_cost += required * b;
                            }
                            else{
                                items += curr_choco / 3;
                                shakes += curr_choco / 3;
                                curr_cost += (curr_choco / 3) * b;
                            }

                        }
                        long required = n - items;
                        if (curr_eggs / 2 >= required) {
                            omelette += required;
                            curr_cost += required * a;
                        } else {
                            curr_cost = Long.MAX_VALUE;
                        }
                    }
//                    System.out.println("QTY : " + cakes +" "+ omelette +" "+shakes);
//                    System.out.println(curr_cost +" "+curr_eggs +" "+curr_choco);
                    cost = Math.min(curr_cost, cost);
                }
                if (n <= e && n <= h) {
                    //only cakes;
                    cost = Math.min(cost, n * c);
                }
                if (e >= 2 * n) {
                    //only omellettes
                    cost = Math.min(n * a, cost);
                }
                if (h >= 3 * n) {
                    //only shakes
                    cost = Math.min(n * b, cost);
                }
                if (cost < 0 || cost == Long.MAX_VALUE) {
                    System.out.println(-1);
                } else {
                    System.out.println(cost);
                }

        }
    }
}
