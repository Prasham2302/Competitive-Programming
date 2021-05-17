package com.company;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class TreeNode{
    int data;
    int level;
    ArrayList<TreeNode> children;
    TreeNode( int x){
        data = x;
        level = 0;
        children = new ArrayList<>();
    }
}
class pair{
    int first;
    int second;
    pair(int a, int b){
        first = a;
        second = b;
    }

    public int getFirst() {
        return first;
    }

    public int getSecond() {
        return second;
    }
}
class sorting implements Comparator<pair> {
    @Override
    public int compare(pair t1, pair t2) {
        if(t1.first > t2.first){
            return 1;
        }
        else if(t1.first < t2.first){
            return -1;
        }
        else{
            if(t1.second > t2.second){
                return 1;
            }
            else if(t1.second == t2.second){
                return 0;
            }
            else{
                return -1;
            }
        }
    }
}
public class KKLING {
    static ArrayList<pair> leaves = new ArrayList<>();

    public static void DFS2(TreeNode root){
        for(int i = 0;i<root.children.size();i++){
            TreeNode current = root.children.get(i);
            DFS2(current);
        }
        if(root.children.size() == 0){
            leaves.add(new pair(root.level,root.data+1));
        }
    }
    public static void DFS(TreeNode root, int l){
        root.level = l;
        for(int i = 0;i<root.children.size();i++){
            TreeNode current = root.children.get(i);
            DFS(current,l+1);
        }
    }

    public static void createTree(TreeNode root, ArrayList<Integer>[] adjacent, boolean[] visited){
        visited[root.data] = true;
        for(int i = 0;i<adjacent[root.data].size();i++){
            if(visited[adjacent[root.data].get(i)] == false){
                TreeNode temp = new TreeNode(adjacent[root.data].get(i));
                root.children.add(temp);
            }
        }
        for(int i = 0;i<root.children.size();i++){
            createTree(root.children.get(i),adjacent,visited);
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t>0){
            t--;
            int n = scan.nextInt();
            ArrayList<Integer>[] adjacent = new ArrayList[n];
            for(int i = 0;i<n;i++){
                adjacent[i] = new ArrayList<>();
            }
            for(int i = 0;i<n-1;i++){
                int u = scan.nextInt();
                int v = scan.nextInt();
                u--;
                v--;
                adjacent[u].add(v);
                adjacent[v].add(u);
            }
            TreeNode root = new TreeNode(0);
            boolean[] visted = new boolean[n];
            createTree(root,adjacent,visted);
            DFS(root,0);
            ArrayList<pair> ans = new ArrayList<>();
            for(int i = 0;i<root.children.size();i++){
                DFS2(root.children.get(i));
                ArrayList<pair> v = new ArrayList<>();
                pair p;
                boolean f = false;
                Collections.sort(leaves,new sorting());
                p = leaves.get(0);
                v.add(p);
                int val = p.first;
                int j = 1;
                while(j<leaves.size()){
                    while(j<leaves.size() && leaves.get(j).getFirst() == val){
                        if(f){
                            v.add(new pair(p.getFirst()+1,leaves.get(j).getSecond()));
                        }
                        else{
                            v.add(leaves.get(j));
                        }
                        j++;
                    }
                    if(j<leaves.size()){
                        v.clear();
                        f = true;
                        p.second = leaves.get(j).second;
                        v.add(new pair(p.getFirst()+1,leaves.get(j).getSecond()));
                        val = leaves.get(i).first;
                        j++;
                    }
                }
                leaves.clear();
                for(pair x : v){
                    ans.add(x);
                }
            }
            Collections.sort(ans,new sorting());
            int day = ans.get(0).first;
            ArrayList<Integer> storeans = new ArrayList<>();
            for(int i = 0;i<ans.size();i++){
                if(ans.get(i).getFirst() == day){
                    storeans.add(ans.get(i).getSecond());
                }
                else{
                    break;
                }
            }
            System.out.println(storeans.size() +" "+day);
//            Collections.sort(storeans);
            for(Integer x : storeans){
                System.out.print(x +" ");
            }
            System.out.println();
        }
    }
}
