package com.company;

import java.util.*;

public class P3 {
    public static class tower implements Comparable<tower>{
        ArrayList<Integer> index;
        int size;
        tower(){
            size = 0;
            index = new ArrayList<>();
        }
        @Override
        public int compareTo(tower a) {
            if(this.size > a.size) {
                return 1;
            } else if (this.size < a.size) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t>0){
            t--;
            int n = scan.nextInt();
            int m = scan.nextInt();
            int x = scan.nextInt();


            ArrayList<Integer> arr = new ArrayList<>();
            HashMap<Integer,Integer> map = new HashMap<>();
            for(int i = 0;i<n;i++){
                arr.add(scan.nextInt());
                map.put(i, arr.get(i));
            }

            System.out.println("YES");
            PriorityQueue<tower> towers  = new PriorityQueue<>();
            for(int i = 0;i<m;i++){
                tower curr = new tower();
                towers.add(curr);
            }
            for(int i = 0;i<n;i++){
                tower curr = towers.poll();
                curr.size += arr.get(i);
                curr.index.add(i);
                towers.add(curr);
            }

            int[] ans = new int[n];
            int count = 1;
            while(towers.size() > 0){
                tower curr = towers.poll();
                for(Integer p : curr.index){
                    ans[p] = count;
                }
                count++;
            }
            for(int i = 0;i<n;i++){
                System.out.print(ans[i] +" ");
            }
            System.out.println();

        }
    }
}
