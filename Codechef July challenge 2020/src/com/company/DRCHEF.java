package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DRCHEF {
    //////////////////////////
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t>0){
            t--;
            String[] s = br.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            long x = Integer.parseInt(s[1]);
            s = br.readLine().split(" ");
            int[] arr = new int[n];
            for(int i = 0;i<n;i++){
                arr[i] = Integer.parseInt(s[i]);
            }
            Arrays.sort(arr);
            int pos = binary(arr,x,n-1,0);
            int i = pos;
//            System.out.println(pos);
            long count = 0;
            if(pos == -1){
                count += n;
                System.out.println(count);
                continue;
            }
            else if(pos > 0){
                if(arr[pos-1] <= x && arr[pos-1]>=x/2 && pos>=1){
                    pos = pos-1;
                }
            }
//            System.out.println(pos);
            i = pos;
            while(i<arr.length){
                if(x>=arr[i]){
                    x = arr[i]*2;
                    i++;
                }
                else{
                    x = x*2;
                }
                count++;
            }
            count+=(pos);
            System.out.println(count);
        }
    }
    ///////////////////////

    ///////////////////////
    public static int binary(int[] arr, long x, int high,int low) {
        int ans = -1;
        while(low<=high){
//            System.out.println(low+" "+high);
            int mid = (low+high)/2;
            if(arr[mid] < x){
                low = mid+1;
            }
            else{
                ans = mid;
                high = mid-1;
            }
        }
        return ans;
    }
}
