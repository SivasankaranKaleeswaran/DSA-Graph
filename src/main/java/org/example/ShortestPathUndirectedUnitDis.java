package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


// https://www.geeksforgeeks.org/problems/shortest-path-in-undirected-graph-having-unit-distance/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=shortest-path-in-undirected-graph-having-unit-distance
public class ShortestPathUndirectedUnitDis {
    public static void main(String[] args) {
        int n=9, m=10;
        int[][] edge = {{0,1},{0,3},{3,4},{4,5},{5,6},{1,2},{2,6},{6,7},{7,8},{6,8}};

        System.out.println(Arrays.toString(shortestPath(edge, n, m, 0)));

    }

    public static int[] shortestPath(int[][] edge,int n,int m ,int src)
    {
        int dis[] = new int[n];
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        Queue<Integer> q= new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            dis[i]=Integer.MAX_VALUE;
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edge.length;i++)
        {
            adj.get(edge[i][0]).add(edge[i][1]);
            adj.get(edge[i][1]).add(edge[i][0]);
        }
        q.add(src);
        dis[src]=0;

        while(!q.isEmpty())
        {
            int temp=q.poll();
            for(int k:adj.get(temp))
            {
                int ndis=dis[temp]+1;
                if(ndis<dis[k])
                {
                    q.add(k);
                    dis[k]=ndis;
                }
            }
        }

        return dis;

    }
}
