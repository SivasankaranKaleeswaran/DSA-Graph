package org.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//https://leetcode.com/problems/find-eventual-safe-states/
public class EventSafeState {
    public static void main(String[] args) {
        int[][] graph = {{1,2},{2,3},{5},{0},{5},{},{}};
        System.out.println(eventualSafeNodes(graph));
    }

    private static List<Integer> eventualSafeNodes(int[][] graph) {

        ArrayList<ArrayList<Integer>> adj=  new ArrayList<>();
        for(int i=0;i< graph.length;i++)
        {
            adj.add(new ArrayList<>());
            for(int k:graph[i])
            {
                adj.get(i).add(k);
            }
        }

        List<Integer> ans =new LinkedList<>();
        boolean[] vis=new boolean[graph.length];
        boolean[] path=new boolean[graph.length];
        int[] safeElement=new int[graph.length];

        for(int i=0;i<graph.length;i++)
        {
            if(!vis[i]) {
                dfs(adj, i, vis, path, safeElement);
            }
        }

        for(int i=0;i<safeElement.length;i++)
        {
            if(safeElement[i]==1) ans.add(i);
        }
        return ans;
    }

    private static boolean dfs(ArrayList<ArrayList<Integer>> adj, int i, boolean[] vis, boolean[] path, int[] safeElement) {

        vis[i]=true;
        path[i]=true;
        safeElement[i]=0;
        for(int k: adj.get(i))
        {
            if(!vis[k])
            {
                if(dfs(adj, k, vis, path, safeElement)) return true;
            }
            else if (path[k]) return true;
        }

        path[i]=false;
        safeElement[i]=1;
        return false;

    }
}
