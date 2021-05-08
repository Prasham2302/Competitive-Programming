package com.company;
import java.util.*;

class Pair implements Comparable<Pair>{
    long key;
    long value;
    Pair(long a, long b){
        key = a;
        value = b;
    }

    public long getKey() {
        return key;
    }

    public long getValue() {
        return value;
    }

    @Override
    public int compareTo(Pair a){
        if(a.getKey() == this.getKey()){
            if(a.getValue() > this.getValue()){
                return 1;
            }
            else if(a.getValue() < this.getValue()){
                return -1;
            }
            else{
                return 0;
            }
//            return (int) (a.getValue() - this.getValue());
        }
        else{
            if(a.getKey() > this.getKey()){
                return 1;
            }
            else {
                return -1;
            }
//            return (int) (a.getKey() - this.getKey());
        }
    }
}

public class treePerm {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t>0){
            t--;
            int n = scan.nextInt();
            int m = scan.nextInt();
            int k = scan.nextInt();
            int[] g = new int[n+1];
            for(int i = 0;i<n;i++){
                g[i+1] = scan.nextInt();
            }
            ArrayList<Pair>[] arr = new ArrayList[n+1];
            ArrayList<Pair>[] dp = new ArrayList[n+1];
            for(int i = 0;i<=n;i++){
                arr[i] = new ArrayList<>();
                dp[i] = new ArrayList<>();
            }
            for(int i = 0;i<m;i++){
                int u = scan.nextInt();
                int v = scan.nextInt();
                int d = scan.nextInt();
                arr[u].add(new Pair(i,d));
                arr[v].add(new Pair(i,d));
            }

            dp[0].add(new Pair(0,0));
            for(int i = 1;i<=n;i++){
                ArrayList<Pair> temp = new ArrayList<>(dp[i-1]);
                long curr = 0, mask = 0;
                HashSet<Long> open = new HashSet<>();
                for(int j = i;j>=1;j--){
                    curr+=g[j];
                    mask^=(1) << j;
                    for(Pair xyz : arr[j]){
                        if(open.contains(xyz.getKey())){
                            curr += xyz.getValue();
                        }
                        else{
                            open.add(xyz.getKey());
                        }
                    }
                    if(j>1){
                        for(Pair xyz : dp[j-2]){
                            temp.add(new Pair(xyz.getKey()+curr,mask^(xyz.getValue())));
                        }
                    }
                    else{
                        temp.add(new Pair(curr,mask));
                    }
                }
                Collections.sort(temp);
                HashSet<Long> sel = new HashSet<>();
                long filled = 0;

                for(int j = 0;j<temp.size() && filled < k;j++){
                    if(sel.contains(temp.get(j).getValue())){
                        continue;
                    }
                    dp[i].add(temp.get(j));
                    filled++;
                    sel.add(temp.get(j).getValue());
                }
            }
            for(int i = 0;i<k;i++){
                System.out.print(dp[n].get(i).getKey() +" ");
            }
            System.out.println();

        }
    }
}
