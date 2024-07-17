package org.example;

public class DisjointSet {
    int[] rank;
    int[] parent;
    public DisjointSet(int n) {
        rank=new int[n+1];
        parent=new int[n+1];
        for (int i = 0; i <= n; i++) {
            rank[i]=0;
            parent[i]=i;
        }
    }

    public static void main (String[] args) {
        DisjointSet ds = new DisjointSet(7);
        ds.unionByRank(1, 2);
        ds.unionByRank(2, 3);
        ds.unionByRank(4, 5);
        ds.unionByRank(6, 7);
        ds.unionByRank(5, 6);

        // if 3 and 7 same or not
        if (ds.findUPar(3) == ds.findUPar(7)) {
            System.out.println("Same");
        } else
            System.out.println("Not Same");

        ds.unionByRank(3, 7);
        if (ds.findUPar(3) == ds.findUPar(7)) {
            System.out.println("Same");
        } else
            System.out.println("Not Same");
    }

    private int findUPar(int i) {
        if(i==parent[i]) return i;

        int ultimateParent=findUPar(parent[i]);
        parent[i]=ultimateParent;
        return parent[i];
    }

    private void unionByRank(int i, int j) {

        int getParentI=findUPar(i);
        int getParentJ=findUPar(j);
        if(getParentJ==getParentI) return;

        if(rank[getParentI]<rank[getParentJ])
        {
            parent[getParentI]=getParentJ;
        }
        else if(rank[getParentI]>rank[getParentJ])
        {
            parent[getParentJ]=getParentI;
        }
        else {
            parent[getParentJ]=getParentI;
            rank[getParentI]++;
        }
    }
}
