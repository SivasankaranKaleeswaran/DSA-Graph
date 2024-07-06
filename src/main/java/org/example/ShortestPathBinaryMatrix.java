package org.example;

import java.util.PriorityQueue;

// https://leetcode.com/problems/shortest-path-in-binary-matrix/description/
public class ShortestPathBinaryMatrix {
    public static void main(String[] args) {
        int[][] grid ={{1,0,0},{1,1,0},{1,1,0}};// {{0,1},{1,0}};//{{0,0,0},{1,1,0},{1,1,0}};
        System.out.println(shortestPathBinaryMatrix(grid));

    }

    public  static int shortestPathBinaryMatrix(int[][] grid) {

        PriorityQueue<Paths> q=new PriorityQueue<>((x,y)-> x.dist-y.dist);
        int dis[][] = new int[grid.length][grid.length];
        for(int i=0;i< grid.length;i++)
        {
            for(int j=0;j< grid.length;j++)
            {
                dis[i][j]=Integer.MAX_VALUE;
            }
        }
        if(grid[0][0]==0)
        {
            q.add(new Paths(0,0,1));
            dis[0][0]=1;
        }

        while(!q.isEmpty())
        {
            Paths t=q.poll();
            int dist=t.dist;
            int row=t.row;
            int col = t.col;

            int[] nr={0,0,-1,1,1,-1,-1,1};
            int[] nc={-1,1,0,0,1,1,-1,-1};

            for(int i=0;i<8;i++)
            {
                int nrow=row+nr[i];
                int ncol=col+nc[i];
                if(nrow >-1 && nrow < grid.length && ncol >-1 && ncol< grid.length && grid[nrow][ncol]==0 && dist+1 < dis[nrow][ncol])
                {
                    q.add(new Paths(nrow, ncol, dist+1));
                    dis[nrow][ncol]=dist+1;

                }

            }
        }

        return dis[grid.length-1][grid.length-1] == Integer.MAX_VALUE? -1: dis[grid.length-1][grid.length-1] ;
    }
}

class Paths
{
    int row;
    int col;
    int dist;

    public Paths(int row, int col, int dist) {
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
}
