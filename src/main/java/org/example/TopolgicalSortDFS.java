package org.example;

import java.util.*;

public class TopolgicalSortDFS {
    public static void main(String[] args) {
        int V = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(2).add(3);
        adj.get(3).add(1);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(5).add(0);
        adj.get(5).add(2);
        List<Integer> ans=topoSort(V, adj);
        Collections.reverse(ans);
        //instead create a new list and store run through the stack and store it by pop function.
        System.out.println(ans.toString());

    }

    private static List<Integer> topoSort(int v, ArrayList<ArrayList<Integer>> adj) {

        Stack<Integer> ans=new Stack<>();
        boolean[] vis=new boolean[v];

        for(int i=0;i<v;i++)
        {
            if(!vis[i])
            {
                dfs(adj, i, ans, vis);
            }
        }

        return ans;
    }

    private static void dfs(ArrayList<ArrayList<Integer>> adj, int i, Stack<Integer> ans, boolean[] vis) {

        vis[i]=true;
        for(int k:adj.get(i))
        {
            if(!vis[i])
             dfs(adj,k,ans,vis);
        }

        ans.add(i);
        return;
    }
}
