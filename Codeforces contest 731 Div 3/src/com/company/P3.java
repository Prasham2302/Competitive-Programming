package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class P3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t =scan.nextInt();
        while(t>0){
            t--;
            int k = scan.nextInt();
            int n = scan.nextInt();
            int m = scan.nextInt();
            int[] a = new int[n];
            int[] b = new int[m];
            for(int i = 0;i<n;i++){
                a[i] = scan.nextInt();
            }
//            System.out.println("a "+ Arrays.toString(a));
            for(int j = 0;j<m;j++){
                b[j] = scan.nextInt();
            }
            int lines = k;
            int aptr = 0;
            int bptr = 0;
            ArrayList<Integer> arr = new ArrayList<>();
            boolean passed = true;
            while(aptr < a.length && bptr < b.length){
//                System.out.println("loop 1 " + arr);
//                System.out.println(a[aptr]+" "+b[bptr]);
                if(a[aptr] == 0){
                    k++;
                    arr.add(0);
                    aptr++;
                    continue;
                }
                if(b[bptr] == 0){
                    k++;
                    arr.add(0);
                    bptr++;
                    continue;
                }
                if(a[aptr] <= k){
                    arr.add(a[aptr]);
                    aptr++;
                    continue;
                }
                else if(b[bptr] <= k){
                    arr.add(b[bptr]);
                    bptr++;
                    continue;
                }
                else{
                    passed  = false;
                    break;
                }
            }
            while(aptr < a.length){
//                System.out.println("loop2 "+ arr);
                if(a[aptr] == 0){
                    k++;
                    arr.add(0);
                    aptr++;
                }
                else if(a[aptr] <= k){
                    arr.add(a[aptr]);
                    aptr++;
                }
                else{
                    passed = false;
                    break;
                }
            }
            while(bptr < b.length){
//                System.out.println("loop3 "+ arr);
                if(b[bptr] == 0){
                    k++;
                    arr.add(0);
                    bptr++;
                }
                else if(b[bptr] <= k){
                    arr.add(b[bptr]);
                    bptr++;
                }
                else{
                    passed = false;
                    break;
                }
            }
            if(passed){
                for(int i = 0;i<arr.size();i++){
                    System.out.print(arr.get(i) +" ");
                }
                System.out.println();
            }
            else{
                System.out.println("-1");
            }
        }
    }
}
