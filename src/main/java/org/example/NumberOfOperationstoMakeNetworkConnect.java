package org.example;

//https://leetcode.com/problems/number-of-operations-to-make-network-connected/description/
public class NumberOfOperationstoMakeNetworkConnect {
    int[] size;
    int[] parent;
    public static void main (String[] args) {
        int V = 9;
        int[][] edge = {{0, 1}, {0, 2}, {1, 2},{0, 3}, {1, 2}, {2, 3}, {4, 5}, {5, 6}, {7, 8}};

        NumberOfOperationstoMakeNetworkConnect obj = new NumberOfOperationstoMakeNetworkConnect();
        int ans = obj.makeConnected(V, edge);
        System.out.println("The number of operations needed: " + ans);

    }

    public int makeConnected(int n, int[][] connections)
    {
    if (connections.length < n - 1) {
        return -1;
    }

    size=new int[n];
    parent=new int[n];
    int count=0;
        for(int i=0;i<n;i++)
    {
        size[i]=1;
        parent[i]=i;
    }
        for(int i=0;i<connections.length;i++)
    {
        int src=connections[i][0];
        int dst=connections[i][1];
        if(ultiParent(src) == ultiParent(dst)) count++;
        else
        {
            int nsrc=ultiParent(src);
            int ndst=ultiParent(dst);
            if(size[nsrc]<size[ndst])
            {
                parent[nsrc]=ndst;
                size[ndst]+=size[nsrc];
            }
            else
            {
                parent[ndst]=nsrc;
                size[nsrc]+=size[ndst];
            }
        }
    }
    int req=0;

        for(int i=0;i<n;i++)
    {
        if(i==parent[i]) req++;
    }

    int ans = req - 1;
        if (count >= ans) return req;
        return -1;}

    public int ultiParent(int k)
    {
        if(k==parent[k]) return k;
        int ulParent=ultiParent(parent[k]);
        parent[k]=ulParent;
        return ulParent;
    }

}
