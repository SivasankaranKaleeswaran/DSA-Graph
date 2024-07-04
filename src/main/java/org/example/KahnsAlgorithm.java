package org.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Kahns algorithm can be used in detecting cycle in directed graph,
// if the returned list is shorter than the V then cycle is there.

public class KahnsAlgorithm {
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

        System.out.println(topoSortBFS(V, adj).toString());

    }

    private static List<Integer> topoSortBFS(int v, ArrayList<ArrayList<Integer>> adj) {
        List<Integer> ans= new LinkedList<>();
        int[] count=new int[v];

        for(int i=0;i<adj.size();i++)
        {
            for(int k:adj.get(i))
            {
                count[k]++;
            }
        }

        Queue<Integer> q=new LinkedList<>();

        for(int i=0;i<v;i++)
        {
            if(count[i]==0)
            {
                q.add(i);
            }
        }

        while(!q.isEmpty())
        {
            int temp=q.poll();
            ans.add(temp);
            for(int i:adj.get(temp))
            {
                count[i]--;
                if(count[i]==0)
                {
                    q.add(i);
                }
            }

        }

        return ans;
    }
}
