package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;


public class PAIRFLIP {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t>0){
            t--;
            String[] temp = br.readLine().split(" ");
            int n = Integer.parseInt(temp[0]);
            int m = Integer.parseInt(temp[1]);
            int e = Integer.parseInt(temp[2]);
            //R r i j
            //C c i J
            String[] a = new String[n];
            String[] b = new String[n];
            for(int i = 0;i<n;i++){
                a[i] = br.readLine();
            }
            for(int i = 0;i<n;i++){
                b[i] = br.readLine();
            }
            ArrayList<String> operations = new ArrayList<>();
            int count = 0;
            boolean toFlip = true;
            HashMap<String,Boolean> map = new HashMap<>();
            for(int i = 0;i<n;i++){
                int prev = 0;
                for(int j = 0;j<m;j++){
                    String loc = i +" "+ j;
                    String prevloc = i+" "+prev;
                    char curr = a[i].charAt(j);
                    if(curr == '1' && toFlip && map.containsKey(loc) == false){
                        prev = j;
                        toFlip = false;
                    }
                    if(curr == '1' && toFlip == false && map.containsKey(loc) == false){
                        toFlip = true;
                        String toAdd = "R "+(i+1)+" "+(prev+1)+" "+(j+1);
                        count++;
                        operations.add(toAdd);
                        map.put(loc,true);
                        map.put(prevloc,true);
                    }
                }
                if(toFlip == false){
                    toFlip = true;
                    for(int k = i+1;k<n;k++) {
                        String loc = k + " " + prev;
                        String prevloc = i + " " + prev;
                        char curr = a[k].charAt(prev);
                        if (curr == '1' && map.containsKey(loc) == false) {
                            toFlip = true;
                            String toAdd = "C " + (prev + 1) + " " + (i + 1) + " " + (k + 1);
                            count++;
                            operations.add(toAdd);
                            map.put(loc, true);
                            map.put(prevloc, true);
                        }
                    }
                }
            }
            //check
            boolean failed  = false;
            for(int i = 0;i<n;i++){
                if(failed){
                    break;
                }
                for(int j = 0;j<m;j++){
                    String loc = i +" "+j;
                    char curr = a[i].charAt(j);
                    if(curr == '1' && map.containsKey(loc) == false){
                        failed = true;
                        break;
                    }
                }
            }
            System.out.println(map.keySet());
            if(failed)
                System.out.println(-1);
            if(e == 0)
                System.out.println(count);
            else{
                System.out.println(count);
                printoutput(operations);
            }
        }
    }

    private static void printoutput(ArrayList<String> operations) {
        for(int i = 0;i<operations.size();i++){
            System.out.println(operations.get(i));
        }
    }
}
