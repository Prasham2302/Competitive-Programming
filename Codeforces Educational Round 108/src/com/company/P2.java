package com.company;

import java.util.HashMap;
import java.util.Scanner;

public class P2 {
    public static HashMap<String, Boolean> map = new HashMap<>();
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t>0){
            t--;
            int n = scan.nextInt();
            int m = scan.nextInt();
            int k = scan.nextInt();
            int cost = 0;
            boolean ans = path(n,m,k, cost, 1,1);
            if(ans){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
            map.clear();
        }
    }

    private static boolean path(int n, int m, int k, int cost, int x, int y) {
//        System.out.println(x +" "+y + " "+ cost);
        String str = x + " " + y;
        if (x == n && y == m) {
//            System.out.println(cost);
            if (cost == k) {
                return true;
            } else {
                return false;
            }
        }
        if(map.containsKey(str) == false) {
            if (x == n) {
                map.put(str, path(n, m, k, cost + x, x, y + 1));
            } else if (y == m) {
                map.put(str,path(n, m, k, cost + y, x + 1, y));
            } else {
                map.put(str,path(n, m, k, cost + y, x + 1, y) || path(n, m, k, cost + x, x, y + 1));
            }
        }
        return map.get(str);
    }

}
