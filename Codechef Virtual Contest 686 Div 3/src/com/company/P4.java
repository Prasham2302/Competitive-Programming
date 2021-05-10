package com.company;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class P4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t > 0) {
            t--;
            long n = scan.nextLong();
            HashMap<Long,Long> map= new HashMap<>();
            for(long i = 2;i*i<=n;i++){
                long count = 0;
                while(n%i == 0){
                    count++;
                    n /= i;
                }
                if(count > 0){
                    map.put(count,i);
                }
            }
            if(n > 1){
                map.put((long) 1,n);
            }
            ArrayList<Long> counts = new ArrayList<>(map.keySet());
            Collections.sort(counts);
        }

    }
}
