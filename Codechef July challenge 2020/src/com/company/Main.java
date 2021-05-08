package com.company;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scan= new Scanner(System.in);
        int t = scan.nextInt();
        while(t>0){
            t--;
            int n = scan.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            for(int i = 0;i<n;i++){
                a[i] =scan.nextInt();
            }
            for(int j = 0;j<n;j++){
                b[j] = scan.nextInt();
            }
            Arrays.sort(a);
            Arrays.sort(b);
            HashMap<Integer,Integer> a_count = new HashMap<>();
            HashMap<Integer,Integer> b_count = new HashMap<>();
            count(a,n,a_count);
            count(b,n,b_count);
            ArrayList<Integer> arr = takeunion(a,b,n);
            //count swaps
            int len = arr.size();
            long swaps = 0;
            ArrayList<Integer> swap_a = new ArrayList<>();
            ArrayList<Integer> swap_b = new ArrayList<>();
//            System.out.println(swap_arr);
             for(int i = 0;i<len;i++){

                int curr = arr.get(i);
                long c_a = 0;
                long c_b = 0;

                if(a_count.containsKey(curr)){
                    c_a = a_count.get(curr);
                }
                if(b_count.containsKey(curr)){
                    c_b = b_count.get(curr);
                }
                long check = c_a+c_b;
                if((check)%2 == 0){
                    if(c_a != c_b) {
                        int temp = Math.abs((int)c_a - (int)c_b);
                        swaps += temp/2;
                        for(int q = 0;q<temp/2;q++){
                            if(c_a>c_b) {
                                swap_a.add(curr);
                            }
                            else{
                                swap_b.add(curr);
                            }
                        }
                    }
                }
                else{
                    swaps = -1;
                    break;
                }

            }
            if(swaps != -1) {
                if(swap_a.size() == 0){
                    System.out.println(0);
                    continue;
                }
                long count = 0;
                long global_minima = 2*arr.get(0);
                int last_a = swap_a.size();
                int last_b = swap_b.size();
                int pos_a = 0;
                int pos_b = 0;
                while(pos_a<last_a && pos_b<last_b){
                    int curr_a = swap_a.get(pos_a);
                    int curr_b = swap_b.get(pos_b);
                    if(Math.min(curr_a,curr_b)<global_minima){
                        if(curr_a<curr_b){
                            pos_a++;
                            last_b--;
                            count+=curr_a;
                        }
                        else{
                            pos_b++;
                            last_a--;
                            count+=curr_b;
                        }
                    }
                    else{
                        pos_a++;
                        pos_b++;
                        count+=global_minima;
                    }
                }
                System.out.println(count);
            }
            else{
                System.out.println((int) swaps);
            }
        }
    }


    private static ArrayList takeunion(int[] a, int[] b, int n) {

        //merging two arrays
        ArrayList<Integer> arr = new ArrayList<>();
        int i = 0,j=0,k=0;
        while(i<n && j<n){
            if(a[i]<=b[j]){
                arr.add(a[i]);
                i++;
            }
            else{
                arr.add(b[j]);
                j++;
            }
        }
        while(i<n){
            arr.add(a[i++]);
        }
        while(j<n){
            arr.add(b[j++]);
        }

        //removing duplicates
        ArrayList<Integer> tarr = new ArrayList<>();
        int last = arr.get(0);
        tarr.add(arr.get(0));
        for(int s = 1;s<arr.size();s++){
            if(last != arr.get(s)){
                tarr.add(arr.get(s));
                last = arr.get(s);
            }
        }
        return  tarr;
    }
    private static void count(int[] a, int n,HashMap<Integer, Integer> a_count) {

        //storing the frequency of each number
        for(int i = 0;i<n;i++){
            if(a_count.containsKey(a[i])){
                int temp = a_count.get(a[i]);
                temp++;
                a_count.replace(a[i],temp);
            }
            else{
                a_count.put(a[i],1);
            }
        }
    }
}
