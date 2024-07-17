package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class KruscEdge
{
    int src, dest, weight;
    KruscEdge(int _src, int _dest, int _wt) {
        this.src = _src; this.dest = _dest; this.weight = _wt;
    }
}
public class KruscalAlgo {

    int[] size;
    int[] parent;
    public KruscalAlgo(int n) {
        size=new int[n+1];
        parent=new int[n+1];
        for (int i = 0; i <= n; i++) {
            size[i]=0;
            parent[i]=i;
        }
    }

    private int findUPar(int i) {
       if(i == parent[i]) return i;
       int UltiParent=findUPar(parent[i]);
       parent[i]=UltiParent;
       return parent[i];

    }

    private void unionBySize(int i, int j) {
        int ultiparentI=findUPar(i);
        int ultiParentJ=findUPar(j);
        if(ultiParentJ == ultiparentI) return;

        if(size[ultiparentI]<size[ultiParentJ])
        {
            parent[ultiparentI]=ultiParentJ;
            size[ultiParentJ]+=size[ultiparentI];
        }
        else if(size[ultiparentI]>size[ultiParentJ])
        {
            parent[ultiParentJ]=ultiparentI;
            size[ultiparentI]+=size[ultiParentJ];
        }
        else {
            parent[ultiParentJ]=ultiparentI;
            size[ultiparentI]+=size[ultiParentJ];
        }
    }

    public static void main (String[] args) {
        int V = 5;

        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
        int[][] edges =  { {0, 1, 2}, {0, 3, 6}, {1, 2, 3}, {1, 3, 8}, {1, 4, 5}, {4, 2, 7}};

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<ArrayList<Integer>>());
        }

        for (int i = 0; i < 6; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

            ArrayList<Integer> tmp1 = new ArrayList<Integer>();
            ArrayList<Integer> tmp2 = new ArrayList<Integer>();
            tmp1.add(v);
            tmp1.add(w);

            tmp2.add(u);
            tmp2.add(w);

            adj.get(u).add(tmp1);
            adj.get(v).add(tmp2);
        }

         spanningTree(V, adj);
      //  System.out.println("The sum of all the edge weights: " );

}

    private static void spanningTree(int v, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        KruscalAlgo k=new KruscalAlgo(v);
        PriorityQueue<KruscEdge> newEdge=new PriorityQueue<>((x,y)->x.weight-y.weight);

        for (int i = 0; i < adj.size(); i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                int adjNode = adj.get(i).get(j).get(0);
                int wt = adj.get(i).get(j).get(1);
                int node = i;
                newEdge.add(new KruscEdge(i, adjNode, wt));
            }
        }

        int mstWt = 0;


        // M x 4 x alpha x 2
        while(!newEdge.isEmpty()) {
            KruscEdge e=newEdge.poll();
            int wt = e.weight;
            int U = e.src;
            int V = e.dest;
            System.out.println(wt+" "+U+" "+V);

            if (k.findUPar(U) != k.findUPar(V)) {
                mstWt += wt;
                k.unionBySize(U, V);
            }
        }

        System.out.println(mstWt);

    }


}
