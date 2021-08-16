package com.company;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static class pair{
        int x;
        int y;
        pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) {
	// write your code here
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t>0){
            t--;
            int startx = scan.nextInt();
            int starty = scan.nextInt();
            int endx = scan.nextInt();
            int endy = scan.nextInt();
            int fx = scan.nextInt();
            int fy = scan.nextInt();
            int count = 0;
            count += Math.abs(endx - startx);
            count += Math.abs(endy - starty);

            if(fx == endx && startx == fx && (Math.abs(fy - starty) + Math.abs(fy - endy)) == Math.abs(starty-endy)){
                count += 2;
            }
            else if(fy == endy && starty == fy && (Math.abs(fx - startx) + Math.abs(fx - endx)) == Math.abs(startx-endx)){
                count+=2;
            }
            System.out.println(count);
//            Queue<pair> q = new LinkedList<>();
//            pair start = new pair(startx,starty);
//            q.add(start);
//            q.add(null);
//            int level = 0;
//            String temp = startx + " "+starty;
//            HashSet<String> visited = new HashSet<>();
//            visited.add(temp);
//            visited.add(fx+" "+fy);
//            while(q.size() > 0){
//                pair curr = q.poll();
//
//                if(curr == null){
//                    if(q.size() == 0){
//                        break;
//                    }
//                    level++;
//                    q.add(null);
//                }
//                else{
//                    if(curr.x == endx && curr.y == endy){
//                        break;
//                    }
//                    int[] directions = {0,1,0,-1};
//                    for(int i = 0;i<4;i++){
//                        int newx = curr.x + directions[i];
//                        int newy = curr.y + directions[(i+1)%4];
//                        pair next = new pair(newx,newy);
//                        temp = newx + " "+newy;
//
//                        if(visited.contains(temp) == false){
//                            visited.add(temp);
//                            q.add(next);
//                        }
//                    }
//                }
//            }
//            System.out.println(level);
        }
    }
}
