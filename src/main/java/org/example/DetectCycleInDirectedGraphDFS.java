package org.example;

import java.util.ArrayList;

public class DetectCycleInDirectedGraphDFS {
    public static void main(String[] args) {
        int V = 11;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(4);
        adj.get(3).add(7);
        adj.get(4).add(5);
        adj.get(5).add(6);
        adj.get(7).add(5);
        adj.get(8).add(9);
        adj.get(9).add(10);
        //adj.get(10).add(8);

        System.out.println(isCyclic(V, adj));

    }

    private static boolean isCyclic(int v, ArrayList<ArrayList<Integer>> adj) {

        boolean[] vis=new boolean[v];
        boolean[] path=new boolean[v];

        for(int i=0;i<v;i++)
        {
            if(!vis[i]) {
                if (dfs(adj, i, vis, path)) return true;
            }
        }

        return false;

    }

    private static boolean dfs(ArrayList<ArrayList<Integer>> adj, int i, boolean[] vis, boolean[] path) {

        vis[i]=true;
        path[i]=true;

        for(int k:adj.get(i))
        {
            if(!vis[k])
            {
                if(dfs(adj,k,vis,path)) return true;
            }
            else if(path[k]) return true;
        }

        path[i]=false;
        return false;

    }
}
