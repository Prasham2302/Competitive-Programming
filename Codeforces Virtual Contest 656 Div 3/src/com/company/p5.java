package com.company;

import java.util.*;

public class p5 {
    private int V;
    private ArrayList<ArrayList<Integer>> adj;
    p5(int v)
    {
        V = v;
        adj = new ArrayList<ArrayList<Integer> >(v);
        for (int i = 0; i < v; ++i)
            adj.add(new ArrayList<Integer>());
    }
    void addEdge(int v, int w) { adj.get(v).add(w); }
    void topologicalSortUtil(int v, boolean visited[],
                             Stack<Integer> stack)
    {
        visited[v] = true;
        Integer i;
        Iterator<Integer> it = adj.get(v).iterator();
        while (it.hasNext()) {
            i = it.next();
            if (!visited[i])
                topologicalSortUtil(i, visited, stack);
        }
        stack.push(new Integer(v));
    }

    ArrayList<Integer> topologicalSort()
    {
        ArrayList<Integer> arr = new ArrayList<>();
        Stack<Integer> stack = new Stack<Integer>();
        boolean visited[] = new boolean[V];
        for (int i = 0; i < V; i++)
            visited[i] = false;
        for (int i = 0; i < V; i++)
            if (visited[i] == false)
                topologicalSortUtil(i, visited, stack);
        while (stack.empty() == false)
            arr.add(stack.pop());
        return arr;
    }
    private boolean isCyclicUtil(int i, boolean[] visited,
                                 boolean[] recStack)
    {
        if (recStack[i])
            return true;

        if (visited[i])
            return false;

        visited[i] = true;

        recStack[i] = true;
        List<Integer> children = adj.get(i);

        for (Integer c: children)
            if (isCyclicUtil(c, visited, recStack))
                return true;

        recStack[i] = false;

        return false;
    }

    private boolean isCyclic()
    {
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];
        for (int i = 0; i < V; i++)
            if (isCyclicUtil(i, visited, recStack))
                return true;

        return false;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t>0) {
            t--;
            int v = scan.nextInt();
            int edges = scan.nextInt();
            p5 graph = new p5(v);
            List<int[]> undirected = new ArrayList<>();
            for(int i = 0;i<edges;i++){
                int type = scan.nextInt();
                int source = scan.nextInt();
                int dest = scan.nextInt();
                if(type == 1){
                    graph.addEdge(source-1,dest-1);
                }
                else{
                    int[] toAdd = new int[] {source-1,dest-1};
                    undirected.add(toAdd);
                }
            }
            if(graph.isCyclic()){
                System.out.println("NO");
            }
            else{
                ArrayList<Integer> topo = graph.topologicalSort();


            }
        }
    }
}
