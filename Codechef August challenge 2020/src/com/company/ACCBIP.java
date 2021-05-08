package com.company;

import java.util.*;

class color{
    int currColor;
    int freq;
    int cost;
    color(int currColor,int freq,int cost){
        this.currColor = currColor;
        this.freq = freq;
        this.cost = cost;
    }

}
class colorComparator implements Comparator<color>{

    @Override
    public int compare(color c1, color c2) {
        if(c1.freq < c2.freq){
            return 1;
        }
        else if(c1.freq > c2.freq){
            return -1;
        }
        else{
            if(c1.cost < c2.cost){
                return -1;
            }
            else{
                return 1;
            }
        }
    }
}
public class ACCBIP {
    static long nCr(int n, int r)
    {
        if(n<r){
            return 0;
        }
        long denom = 1;
        long numer = 1;
        for(int i = 2;i<=r;i++){
            denom *= i;
        }
        for(int i = n;i>n-r;i--){
            numer *= i;
        }
        return numer/denom;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t>0){
            t--;
            int n = scan.nextInt();
            int c = scan.nextInt();
            int k = scan.nextInt();
            HashMap<Integer, Integer> map = new HashMap<>();
            int[] a = new int[n];
            int[] b = new int[n];
            int[] colors = new int[n];
            int[] freq = new int[c];


            for(int i = 0;i<n;i++){
                a[i] = scan.nextInt();
                b[i] = scan.nextInt();
                colors[i] = scan.nextInt();
                freq[colors[i]-1]++;
            }


            int[] cost = new int[c];
            for(int i = 0;i<c;i++){
                cost[i] = scan.nextInt();
            }

            PriorityQueue<color> store = new PriorityQueue<>(new colorComparator());
            for(int i = 0;i<c;i++){
                color temp = new color(i+1,freq[i],cost[i]);
                if(freq[i] > 2){
                    store.add(temp);
                }
            }
            while(store.size()>0 && k>0){
                color temp = store.poll();
                if(temp.cost<=k){

                }
            }

        }
    }
}
