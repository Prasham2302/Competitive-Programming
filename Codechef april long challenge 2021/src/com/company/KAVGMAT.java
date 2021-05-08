package com.company;

import java.util.Scanner;

public class KAVGMAT {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t>0){
            int n = scan.nextInt();
            int m = scan.nextInt();
            int k = scan.nextInt();
            long[][] sum = new long[n+1][m+1];
            for(int i = 1;i<=n;i++){
                for(int j = 1;j<=m;j++){
                    sum[i][j] = scan.nextLong();
                }
            }

            for(int i = 1;i<n+1;i++){
                for(int j = 1;j<m+1;j++){
                    sum[i][j] += sum[i][j-1];
                }
            }
            for(int i = 1;i<=m;i++){
                for(int j = 1;j<=n;j++){
                    sum[j][i] += sum[j-1][i];
                }
            }
            int count = 0;
            for(int size = 1;size<= n;size++){
                for(int i = 1;i<=n-size+1;i++){
                     int low = 1;
                     int high = m - size + 1;
                     int mid;
                     int p = 0;
                     int flag = 0;
                     while(low <= high){
                         mid = (high + low)/2;
                         long temp = sum[i+size-1][mid+size-1] - sum[i+size-1][mid-1] - sum[i-1][mid+size-1] + sum[i-1][mid-1];
                         if(temp >= k * size*size){
                             high = mid -1;
                             p = mid;
                             flag = 1;
                         }
                         else{
                             low = mid + 1;
                         }
                     }
                    if(flag == 1){
                        count += (m - size - p + 2);
                    }
                }
            }
            System.out.println(count);
        }
    }
}
