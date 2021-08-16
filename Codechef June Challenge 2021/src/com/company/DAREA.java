package com.company;


import java.io.*;
import java.util.*;

public class DAREA {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while(t>0){
            t--;
            int n = Integer.parseInt(br.readLine());

            int[][] x = new int[n][2];
            int[][] y = new int[n][2];

            ArrayList<Integer> setXtemp = new ArrayList<>();
            ArrayList<Integer> setYtemp = new ArrayList<>();
            HashMap<Integer,Integer> storeX = new HashMap<>();
            HashMap<Integer,Integer> storeY = new HashMap<>();
            for(int i = 0;i<n;i++){
                String[] inp = br.readLine().split(" ");
                int currX = Integer.parseInt(inp[0]);
                int currY = Integer.parseInt(inp[1]);
                x[i] = new int[] {currX,currY};
                y[i] = new int[] {currY,currX};
                setXtemp.add(currX);
                setYtemp.add(currY);
                storeX.putIfAbsent(currX,0);
                storeY.putIfAbsent(currY,0);
                storeX.put(currX,storeX.get(currX)+1);
                storeY.put(currY,storeY.get(currY)+1);
            }

            Arrays.sort(x, Comparator.comparingInt(a -> a[0]));
            Arrays.sort(y, Comparator.comparingInt(a -> a[0]));

            PriorityQueue<Integer> setX = new PriorityQueue<>(setXtemp);
            PriorityQueue<Integer> setY = new PriorityQueue<>(setYtemp);
            PriorityQueue<Integer> setX_reverse = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> setY_reverse = new PriorityQueue<>(Collections.reverseOrder());
            setX_reverse.addAll(setXtemp);
            setY_reverse.addAll(setYtemp);

            long maximumHeight = 0;
            long minimumHeight = Long.MAX_VALUE;
            long area = Long.MAX_VALUE;
            long h1 = 0;
            long h2 = 0;
            long maximumWidth = 0;
            long minimumWidth = Long.MAX_VALUE;
            long w1 = 0;
            long w2 = 0;

            for(int i = 0;i<n-1;i++){
                maximumHeight = Math.max(maximumHeight,x[i][1]);
                minimumHeight = Math.min(minimumHeight, x[i][1]);
                h1 = maximumHeight - minimumHeight;
                int yToSearch = x[i][1];
                storeY.put(yToSearch,storeY.get(yToSearch)-1);
                if(storeY.get(yToSearch) <= 0) {
                    setY.remove(yToSearch);
                    setY_reverse.remove(yToSearch);
                }
                h2 = setY_reverse.peek() - setY.peek();
                maximumWidth = Math.max(maximumWidth,y[i][1]);
                minimumWidth = Math.min(minimumWidth, y[i][1]);
                w1 = maximumWidth - minimumWidth;
                int xToSearch = y[i][1];
                storeX.put(xToSearch,storeX.get(xToSearch)-1);
                if(storeX.get(xToSearch) <= 0) {
                    setX.remove(xToSearch);
                    setX_reverse.remove(xToSearch);
                }
                w2 = setX_reverse.peek()- setX.peek();
                area = Math.min(area, (y[i][0] - y[0][0]) * w1 + (y[n-1][0] - y[i+1][0]) * w2);
                area = Math.min(area, (x[i][0] - x[0][0]) * h1 + (x[n-1][0] - x[i+1][0]) * h2);
            }


            if(area == Long.MAX_VALUE){
                area = 0;
            }

            BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
            output.write(area+"\n");
            output.flush();

        }
    }
}
