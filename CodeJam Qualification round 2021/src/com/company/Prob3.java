package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Prob3 {
    public static void revese(int[] arr, int l, int r){
        int size = (r-l)/2;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = l;i<=r;i++){
            list.add(arr[i]);
        }
        int j = list.size()-1;
        for(int i = l;i<=r;i++){
            arr[i] = list.get(j);
            j--;
        }
    }
//    public static void revese(int[] arr, int l, int r){
//        int size = (r-l)/2;
//        for(int i = 0;i<=size;i++){
//            int temp = arr[i+l];
//            arr[i+l] = arr[r-i];
//            arr[r-i] = temp;
//        }
//    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for(int TestNumber = 1; TestNumber <= t;TestNumber++){
            int n = scan.nextInt();
            int c = scan.nextInt();
            int[] arr = new int[n];
            for(int i = 0;i<n;i++){
                arr[i] = i+1;
            }
            if(c < (n-1) || c> (n*(n+1))/2 - 1){
                System.out.println("Case #" +TestNumber +": IMPOSSIBLE");
            }
            else {
                for (int i = n - 2; i >= 0; i--) {
//                    System.out.println("i c : "+i +" "+c);
                    if (c > (i + 1)) {
                        //I need to reverse
                        int to_reverse = c - i - 1;
                        int end = Math.min(i+to_reverse, n - 1);
//                        System.out.println(to_reverse );
                        revese(arr, i, end); // reverses array from i to end
                        c -= (end - i + 1);
                    } else {
                        c -= 1;
                    }
                }
                StringBuilder st = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    st.append(arr[i]);
                    st.append(" ");
                }
                System.out.println("Case #" + TestNumber + ": " + st.toString());
            }
        }
    }
}
