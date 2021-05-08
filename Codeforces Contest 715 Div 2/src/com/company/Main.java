package com.company;

import java.util.ArrayList;
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
            ArrayList<Integer> odd = new ArrayList<>();
            ArrayList<Integer> even = new ArrayList<>();
            for(int i = 0;i<n;i++){
                arr[i] = scan.nextInt();
                if(arr[i]%2 == 0){
                    even.add(arr[i]);
                }
                else{
                    odd.add(arr[i]);
                }
            }
            int k = 0;
            for(int i = 0;i<odd.size();i++){
                arr[i] = odd.get(i);
                k++;
            }
            for(int i = 0;i<even.size();i++){
                arr[k] = even.get(i);
                k++;
            }
            for(int i = 0;i<n;i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
        }
    }
}
