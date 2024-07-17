package org.example;

public class DisjointSetBySize {
    int[] size;
    int[] parent;
    public DisjointSetBySize(int n) {
        size=new int[n+1];
        parent=new int[n+1];
        for (int i = 0; i <= n; i++) {
            size[i]=0;
            parent[i]=i;
        }
    }

    public static void main (String[] args) {
        DisjointSetBySize ds = new DisjointSetBySize(7);
        ds.unionBySize(1, 2);
        if (ds.findUPar(1) == ds.findUPar(6)) {
            System.out.println("Same");
        } else
            System.out.println("Not Same");
        ds.unionBySize(2, 3);
        ds.unionBySize(4, 5);
        ds.unionBySize(6, 7);
        ds.unionBySize(5, 6);

        // if 3 and 7 same or not
        if (ds.findUPar(3) == ds.findUPar(7)) {
            System.out.println("Same");
        } else
            System.out.println("Not Same");

        ds.unionBySize(3, 7);
        if (ds.findUPar(3) == ds.findUPar(7)) {
            System.out.println("Same");
        } else
            System.out.println("Not Same");
    }

    private int findUPar(int i) {
        if(i==parent[i]) return i;
        int ultiParent=findUPar(parent[i]);
        parent[i]=ultiParent;
        return parent[i];

    }

    private void unionBySize(int i, int j) {
        int parentI=findUPar(i);
        int parentJ=findUPar(j);

        if(parentI==parentJ) return;

        if(size[parentI]<size[parentJ])
        {
            parent[parentI]=parentJ;
            size[parentJ]+=size[parentI];
        }
        else if(size[parentI]>size[parentJ])
        {
            parent[parentJ]=parentI;
            size[parentI]+=size[parentJ];
        }
        else {
            parent[parentJ]=parentI;
            size[parentI]+=size[parentJ];
        }


    }
}
