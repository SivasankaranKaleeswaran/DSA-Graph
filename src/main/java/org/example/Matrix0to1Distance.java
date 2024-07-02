package org.example;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/01-matrix/description/
public class Matrix0to1Distance {
    public static void main(String[] args) {
        int[][] mat = {{0,0,0},{0,1,0},{0,0,0}};
        boolean[][] vis = new boolean[mat.length][mat[0].length];
        int[][] dis= new int[mat.length][mat[0].length];
        Queue<Storage> q=new LinkedList<>();
        for(int i=0;i<mat.length;i++)
            for(int j=0;j<mat[0].length;j++)
            {
                if(mat[i][j]==0)
                {
                    vis[i][j]=true;
                    q.add(new Storage(0, i, j));
                }
            }
        while(!q.isEmpty())
        {
            Storage temp=q.poll();
            int dist=temp.dis;
            int row= temp.row;
            int col= temp.col;

            dis[row][col]=dist;

            int rown[] = {-1, 1,0,0};
            int coln[] = {0,0,-1,1};
            for(int i=0;i<4;i++)
            {
                int nrow=row+rown[i];
                int ncol=col+coln[i];

                if(ncol>-1 && ncol<mat[0].length && nrow > -1 && nrow < mat[0].length && !vis[nrow][ncol])
                {
                    vis[nrow][ncol]=true;
                    q.add(new Storage(dist+1, nrow, ncol));
                }
            }



        }

        for (int i=0;i<mat.length;i++)
        {
            System.out.println(Arrays.toString(dis[i]));
        }
    }
}

class Storage{
    int dis;
    int row;
    int col;

    public Storage(int dis, int row, int col) {
        this.dis = dis;
        this.row = row;
        this.col = col;
    }
}