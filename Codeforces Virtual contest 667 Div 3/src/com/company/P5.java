package com.company;


import java.util.*;

class Point{
    int x ;
    int y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}
class sort implements Comparator<Point>{
    @Override
    public int compare(Point o1, Point o2) {
        return o1.x > o2.x ? 1 : -1;
    }
}
public class P5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t>0){
            t--;
            int n = scan.nextInt();
            int k = scan.nextInt();
            ArrayList<Point> points = new ArrayList<>();
            for(int i = 0;i<n;i++){
                int u = scan.nextInt();
                int v = scan.nextInt();
                Point curr = new Point(u,v);
                points.add(curr);
            }
            Collections.sort(points, new sort());
            int[] sum1 = new int[n];
            int[] sum2 = new int[n];
//            int curr = 0;
//            int idx = 0;
//            while(idx < n && idx<k){
//                curr += points.get(idx).x;
//                sum1[idx] = curr;
//                idx++;
//            }
//            for(int i = idx+1;i<n;i++){
//                curr -= points.get(i-k).x;
//                curr += points.get(i).x;
//                sum1[i] = curr;
//            }
//            idx = 0;
//            curr = 0;
//            while(idx < n && idx < k){
//                curr += points.get(n-idx - 1).x;
//                sum2[n-idx-1] = curr;
//                idx++;
//            }
//            for(int i = idx+1;i<n;i++){
//                curr -= points.get(n-(i-k)-1).x;
//                curr += points.get(n-i-1).x;
//                sum2[n-i-1] = curr;
//            }
            int curr = 0;
            for(int i = 0;i<n;i++){
                while(points.get(i).x - points.get(curr).x > k){
                    curr++;
                }
                sum1[i] = i - curr + 1;
            }
            for(int i = 1;i<n;i++){
                sum1[i] = Math.max(sum1[i], sum1[i-1]);
            }
            curr = n-1;
            for(int i = n-1;i>-1;i--){
                while(points.get(curr).x - points.get(i).x > k){
                    curr--;
                }
                sum2[i] = curr - i + 1;
            }
            for(int i = n-2;i>-1;i--){
                sum2[i] = Math.max(sum2[i], sum2[i+1]);
            }
            int ans = 1;
            System.out.println(Arrays.toString(sum1)+" "+Arrays.toString(sum2));
            for(int i = 0;i<n-1;i++){
                ans = Math.max(ans, sum1[i] + sum2[i+1]);
            }
            System.out.println(ans);
        }
    }
}
