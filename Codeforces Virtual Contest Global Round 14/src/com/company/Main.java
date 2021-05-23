package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
            int[] arr = new int[n];
            int sum = 0;
            for(int i = 0;i<n;i++){
                arr[i] = scan.nextInt();
                sum += arr[i];
            }
            if(sum == x){
                System.out.println("NO");
            }
            else{

                System.out.println("YES");
                sum = 0;
                ArrayList<Integer> ans = new ArrayList<>();
                for(int i : arr){
                    ans.add(i);
                }
                Collections.sort(ans,Collections.reverseOrder());
                while(ans.size() > 0){
                    sum += ans.get(0);
                    if(sum != x){
                        System.out.print(ans.get(0) +" ");
                        ans.remove(0);
                    }
                    else{
                        sum -= ans.get(0);
                        sum += ans.get(1);
                        System.out.print(ans.get(1) +" ");
                        ans.remove(1);
                    }
                }
                System.out.println();
            }
        }
    }
}
