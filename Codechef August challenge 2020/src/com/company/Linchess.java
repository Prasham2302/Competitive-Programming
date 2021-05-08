package com.company;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Linchess {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t> 0){
            t--;
            int n = scan.nextInt();
            int k = scan.nextInt();
            int[] arr = new int[n];
            for(int i = 0;i<n;i++){
                arr[i] = scan.nextInt();
            }
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            for(int i = 0;i<n;i++){
                if(k%arr[i] == 0){
                        pq.add(arr[i]);
                }
            }
            if(pq.size() == 0){
                System.out.println(-1);
            }
            else{
                System.out.println(pq.peek());
            }
        }
    }
}
