package org.example;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/number-of-provinces/description/
public class NumberOfProvincesAdjacentMatrix {
    public static void main(String[] args) {
       int[][] isConnected = {{1,0,0,0},{0,1,0,0},{0,0,1,0}, {0,0,0,1}};//{{1,0,0},{1,1,0},{0,0,1}};
       boolean[] vis = new boolean[isConnected.length];
       int count=0;
       for(int i=0;i<isConnected.length;i++)
       {
           if(!vis[i])
           {
               count++;
               dfs(isConnected, i, vis);
           }
       }

        System.out.println(count);
        System.out.println(bfs(isConnected,vis));

    }

    static void dfs(int arr[][], int x, boolean[] vis)
    {
        if(!vis[x])
        {
            vis[x]=true;
            for(int i=0;i<arr[x].length;i++)
            {
                if(arr[x][i]==1)
                {
                    dfs(arr, i, vis);
                }
            }
        }

    }

    static int bfs(int arr[][], boolean vis[])
    {
         int count=0;
        Queue<Integer> q=new LinkedList<>();
         for(int i=0;i<arr[0].length;i++)
         {
             if(!vis[i])
             {
                 vis[i]=true;
                 q.add(i);
                 count++;
                 while(!q.isEmpty())
                 {
                     int x=q.poll();
                     for(int j=0;j<arr[x].length;j++)
                     {
                         if(arr[i][j]==1 && !vis[j])
                         {
                             q.add(j);
                         }
                     }
                 }
             }
         }
      return count;
    }
}