package com.company;

import java.lang.reflect.Array;
import java.util.*;

import static java.util.Arrays.sort;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t>0){
            t--;
            int n = scan.nextInt();
            long[] arr = new long[n];
            long[][] mat = new long[n][2];
            for(int i = 0;i<n;i++) {
                arr[i] = scan.nextInt();
                mat[i][0] = arr[i];
                mat[i][1] = i;
            }
            Arrays.sort(mat,new Comparator<long[]>(){
                public int compare(long[] a,long[] b){
                    return Long.compare(a[0],b[0]);
                }
            });
            ArrayList<Long> ans = new ArrayList<>();
//            System.out.println(Arrays.deepToString(mat));

            int sum = 0;
            int count  = 0;
            for(int i = 0;i<n-1;i++){
                sum += mat[i][0];
                if(sum >= mat[i+1][0]){
                    ans.add(mat[i][1]+1);
                    count++;
                }
                else{
                    ans.clear();
                    count = 0;
                }
            }
            ans.add(mat[n-1][1]+1);
            count++;
            Collections.sort(ans);
            System.out.println(count);
            for(int i = 0;i<ans.size();i++){
                System.out.print(ans.get(i) +" ");
            }
            System.out.println();

        }
    }
}
