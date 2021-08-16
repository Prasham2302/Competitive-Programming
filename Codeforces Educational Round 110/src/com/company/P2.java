package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class P2 {
    public static int gcd(int a, int b)
    {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
//        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
//        int t = Integer.parseInt(br.readLine());
        int t = scan.nextInt();
        while(t>0){
            t--;
            int n = scan.nextInt();
            Integer[] arr = new Integer[n];

            for(int i = 0;i<n;i++){
                arr[i] = scan.nextInt();
            }
            ArrayList<Integer> even = new ArrayList<>();
            ArrayList<Integer> odd = new ArrayList<>();
            for(int i = 0;i<n;i++){
                if(arr[i] % 2 == 0){
                    even.add(arr[i]);
                }
                else{
                    odd.add(arr[i]);
                }
            }
            ArrayList<Integer> temp = new ArrayList<>();
            temp.addAll(even);
            temp.addAll(odd);
            int count  = 0;
            for(int i = 0;i<n-1;i++){
                for(int j = i+1;j<n;j++){
//                    System.out.println(arr[i] +" "+arr[j]);
//                    if(arr[i]%2 == 0 && arr[j]%2==0){
//                        count++;
//                    }
                    int curr = gcd(temp.get(i),2*temp.get(j));
                    if(curr > 1){
                        count++;
                    }
//                    System.out.println(count);
                }
            }
            System.out.println(count);
        }
    }
}
