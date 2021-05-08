package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class third {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        HashMap<Integer,Integer> map =new HashMap<>();
        for(int i = 0;i<n;i++){
            arr[i] = scan.nextInt();
            map.putIfAbsent(arr[i],0);
            map.put(arr[i],map.get(arr[i])+1);
        }
        int[] arrs = new int[map.size()];
        int z = 0;
        for(Integer x : map.keySet()){
            arrs[z] = x;
            z++;
        }
        int n2 = arrs.length;
        Arrays.sort(arrs);
        int left = n2/2;
        int right = left+1;
        if(n2%2 == 0){
            right = left;
            left = right-1;
        }

        ArrayList<Integer> order = new ArrayList<>();
        order.add(arr[left]);
        long sum = arr[left];
        if(right<n2) {
            sum += arr[right];
            order.add(arr[right]);
        }
        sum = sum/2;
        left--;
        right++;
        long count = 2;
        while(left>=0 && right<n2){
            if(Math.abs(sum - arr[left]) > Math.abs(sum - arr[right])){
//                System.out.println(arr[left]);
                int curr = map.get(arr[left]);
                while(curr>0){
                    curr--;
                    order.add(arr[left]);
                }
                sum = sum * count;
                sum += arr[left];
                count++;
                sum /= count;
                left--;
            }
            else{
//                System.out.println(arr[right]);
                int curr = map.get(arr[right]);
                while(curr>0){
                    curr--;
                    order.add(arr[right]);
                }

                sum = sum * count;
                sum += arr[right];
                count++;
                sum /= count;
                right++;
            }
        }
        while(left>=0){
            order.add(arr[left]);
            left--;
        }
        while(right<n){
//            System.out.println(arr[right]);
            order.add(arr[right]);
            right++;
        }
//        System.out.println("size "+ order.size());
        int[] min = new int[n];
        int[] max = new int[n];

        min[0] = order.get(0);
        max[0] = order.get(0);
        for(int i = 1;i<n;i++){
            int curr = order.get(i);
            min[i] = Math.min(curr,min[i-1]);
            max[i] = Math.max(curr,max[i-1]);
        }
//        System.out.println(order);
//        System.out.println(Arrays.toString(min));
//        System.out.println(Arrays.toString(max));
        long d = 0;
        for(int i= 0;i<n;i++){
            d += max[i] - min[i];
        }
        long d2 = 0;
        int[] min2 = new int[n];
        int[] max2 = new int[n];
        min[order.size()-1] = order.get(order.size()-1);
        System.out.println(order.get(order.size()-1));
        max[order.size()-1] = order.get(order.size()-1);
        for(int i = order.size()-2;i>=0;i--){
            int curr = order.get(i);
            min2[i] = Math.min(curr,min2[i+1]);
            max2[i] = Math.max(curr,max2[i+1]);
        }
        System.out.println(order);
        System.out.println(Arrays.toString(min2));
        System.out.println(Arrays.toString(max2));
        for(int i = order.size()-1;i>=0;i--){
            d2 += max2[i] - min2[i];
        }
        System.out.println(d2);
        d = Math.min(d,d2);
        System.out.println(d);
    }
}
