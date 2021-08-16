package com.company;

import javax.print.DocFlavor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P2 {
    public static void main(String[] args) throws IOException {
//        Scanner scan = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(br.readLine());
            String input = br.readLine();
            char[] arr = input.toCharArray();
            int count  = 0;
            Queue<Integer> q = new LinkedList<>();
            for(int i = 0;i<n;i++){
                if(arr[i] != '?'){
                    count ++;
                    q.add(i);
                }
            }
            if(count == 0){
                arr[n/2] = 'B';
                q.add(n/2);
            }
            while(q.size()>0){
                int curr = q.poll();
                char element = arr[curr];
                if(curr != 0 && arr[curr-1] == '?'){
                    if(element == 'B'){
                        arr[curr-1] = 'R';
                        q.add(curr-1);
                    }
                    else{
                        arr[curr-1] = 'B';
                        q.add(curr-1);
                    }
                }
                if(curr != n-1 && arr[curr + 1] == '?'){
                    if(element == 'B'){
                        arr[curr+1] = 'R';
                        q.add(curr+1);
                    }
                    else{
                        arr[curr+1] = 'B';
                        q.add(curr+1);
                    }
                }
            }
//            for(int i = 0;i<n;i++){
//                if(arr[i] == '?'){
//                    arr[i] = 'B';
//                }
//            }
            System.out.println(new String(arr));
        }
    }
}
