package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class second {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t>0){
            t--;
            int n = Integer.parseInt(br.readLine());
            char[] inp= br.readLine().toCharArray();
            int[] ts = new int[n];
            int[] m = new int[n];
            int count = 0;
            if(inp[0] == 'T'){
                ts[0]++;
                count++;
            }
            else{
                m[0]++;
            }
            for(int i =1;i<n;i++){
                if(inp[i] == 'T'){
                    ts[i]++;
                    count++;
                }
                else{
                    m[i]++;
                }
                ts[i] += ts[i-1];
                m[i] += m[i-1];
            }
            boolean fail = false;
            for(int i = 0;i<n;i++){
                if(m[i] > ts[i]){
//                    System.out.println("1");
                    fail = true;
                    break;
                }
            }
            if(fail == false) {
                for (int i = 0; i < n; i++) {
                    if (inp[i] == 'M') {
                        boolean pass = false;
                        for (int j = i + 1; j < n; j++) {
                            if (inp[j] == 'T') {
                                inp[j] = 'o';
                                pass = true;
                                break;
                            }
                        }
                        if (!pass) {
//                            System.out.println("2");
                            fail = true;
                        }
                    }
                }
            }
            if(fail){
               System.out.println("NO");
//                System.out.println("3");
            }
            else{
                if(count/2 != m[n-1]){
//                    System.out.println("4");
                    System.out.println("NO");
                }
                else{
                    System.out.println("YES");
                }
            }
        }
    }
}
