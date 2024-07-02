package org.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CycleDetctionUndirectedGraph {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            adj.add(new ArrayList < > ());
        }
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);
        //adj.get(3).add(1);
        boolean ans = isCycleDFS(4, adj);
        System.out.println(ans);

        System.out.println(isCycleBFS(4,adj));

    }

    private static boolean isCycleBFS(int V, ArrayList<ArrayList<Integer>> adj) {

        Queue<Path> q=new LinkedList<>();
        boolean[] vis = new boolean[V];

        for(int i=0;i<V;i++)
        {
            if(!vis[i])
            {
                q.add(new Path(i,-1));
            }
            while(!q.isEmpty())
            {
                Path p=q.poll();
                int curr=p.node;
                int parent= p.par;
                vis[curr]=true;
                for(int k:adj.get(curr))
                {
                    if(!vis[k])
                    {
                        q.add(new Path(k,curr));

                    }
                    else if(k != parent) return true;
                }
            }

        }

        return false;
    }

    private static boolean isCycleDFS(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis =new boolean[V];
        for(int i=0;i<V;i++)
        {
            if(!vis[i])
            {
                if(checkCycleDFS(adj, i, -1,vis)) return true;
            }
        }

        return false;

    }

    private static boolean checkCycleDFS(ArrayList<ArrayList<Integer>> adj, int node, int parent, boolean[] vis) {
        vis[node]=true;
        for(int i:adj.get(node))
        {
            if(!vis[i])
            {
                if(checkCycleDFS(adj, i, node, vis)) return true;
            }
            else if(parent!=i) return true;
        }

        return false;
    }

}

class Path
{
    int node;
    int par;
    Path(int node, int par)
    {
        this.node=node;
        this.par=par;
    }
}