package com.company;

import java.util.*;

public class mex {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t>0){
            t--;
            int n = scan.nextInt();
            int k = scan.nextInt();
            ArrayList<Long> arr = new ArrayList<>();
            HashSet<Long> set = new HashSet<>();
            Long max_val = Long.MIN_VALUE;
            for(int i = 0;i<n;i++){
                long temp = scan.nextLong();
                arr.add(temp);
                set.add(temp);
                max_val = Math.max(max_val, temp);
            }
            Collections.sort(arr);
            ArrayList<Long> list = new ArrayList<>();
            for(long i= 0;i<max_val;i++){
                if(set.contains(i) == false){
                    list.add(i);
                }
            }
            while(k>0){
                k--;
                long mex = binary(arr,n);
                System.out.println("mex : " + mex);
                if(mex == max_val){
                    mex++;
                }
                long toAdd = (long) Math.ceil((mex + max_val)/2);
                System.out.println("toadd : " + toAdd);
                if(set.contains(toAdd) == false){
                    arr.add((int) toAdd,toAdd);
                }
                set.add(toAdd);
                max_val = Math.max(toAdd,max_val);
                System.out.println("Array : " + arr);
                System.out.println(Arrays.toString(set.toArray()));
            }
            System.out.println(set.size());

        }
    }

    private static long binary(ArrayList<Long> arr, int n) {
        int l = 0, r= n-1;
        while(l <= r){
            int mid = (l+r)/2;
            if(arr.get(mid) > mid){
                r = mid-1;
            }
            else if(arr.get(mid) <= mid){
                l = mid+1;
            }
        }
        return l;
    }
}
