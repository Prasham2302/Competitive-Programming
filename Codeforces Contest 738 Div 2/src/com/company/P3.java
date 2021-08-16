package com.company;

import java.util.*;

public class P3 {
    static class Graph {
        private int V;
        private LinkedList<Integer> adj[];
        private int in[];
        ArrayList<Integer> finalPath;
        Graph(int v) {
            V = v;
            adj = new LinkedList[v];
            in = new int[V];
            for (int i = 0; i < v; ++i) {
                adj[i] = new LinkedList();
                in[i] = 0;
            }
        }
        void print(){
            for(int i = 0;i<V;i++){
                System.out.println(adj[i]);
            }
        }
        void addEdge(int v, int w) {
            adj[v].add(w);
            in[w]++;
        }
        void DFSUtil(int v, Boolean visited[], ArrayList<Integer> path) {
            visited[v] = true;
            path.add(v);
            int n;
            Iterator<Integer> i = adj[v].iterator();
            while (i.hasNext()) {
                n = i.next();
                if (!visited[n])
                    DFSUtil(n, visited,path);
            }
        }
        Graph getTranspose() {
            Graph g = new Graph(V);
            for (int v = 0; v < V; v++) {
                Iterator<Integer> i = adj[v].listIterator();
                while (i.hasNext()) {
                    g.adj[i.next()].add(v);
                    (g.in[v])++;
                }
            }
            return g;
        }
        Boolean isSC() {
            Boolean visited[] = new Boolean[V];
            ArrayList<Integer> path = new ArrayList<>();
            for (int i = 0; i < V; i++)
                visited[i] = false;
            DFSUtil(0, visited,path);
            for (int i = 0; i < V; i++)
                if (visited[i] == false)
                    return false;
            Graph gr = getTranspose();
            for (int i = 0; i < V; i++)
                visited[i] = false;
            gr.DFSUtil(0, visited,path);
            for (int i = 0; i < V; i++) {
                if (visited[i] == false) {
                    return false;
                }
            }
            finalPath = new ArrayList<>(path);
            return true;
        }
        Boolean isEulerianCycle() {
            if (isSC() == false) {
//                System.out.println("Is not SC");
                return false;
            }
            for (int i = 0; i < V; i++)
                if (adj[i].size() != in[i])
                    return false;
            return true;
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t-- > 0){
            int n = scan.nextInt();
            int[] arr = new int[n];
            for(int i = 0;i<arr.length;i++){
                arr[i] = scan.nextInt();
            }
//            ArrayList<Integer>[] graph = new ArrayList[n+2];
            Graph graph = new Graph(n+1);
            for(int i = 0;i<n+1;i++){
                if(i < n-1){
                    graph.addEdge(i,i+1);
                }
            }
            for(int i = 0;i<n;i++){
                if(arr[i] == 0){
                    graph.addEdge(i,n);
                }
                else{
                    graph.addEdge(n,i);
                }
            }
//            for(int i = 0;i<n+2;i++){
//                System.out.println(graph[i]);
//            }
            graph.print();
            if(graph.isEulerianCycle()){
                ArrayList<Integer> ans = graph.finalPath;
                for(int i = 0;i<ans.size();i++){
                    System.out.print((ans.get(i)+1) +" ");
                }
                System.out.println();
            }
            else{
                System.out.println(-1);
            }
        }
    }
}
