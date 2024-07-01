package org.example;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/rotting-oranges/description/
public class RottenOrange {
    public static void main(String[] args) {
        int[][] grid = {{2,1,1},{0,1,1},{1,0,1}};//{{2,1,1},{0,1,0},{0,1,1}};
        System.out.println(orangesRotting(grid));

    }

    public static int orangesRotting(int[][] grid) {
        Queue<Node> q = new LinkedList<>();
        int freshcount=0;
        int t=0;
        int rotten=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[i].length;j++)
            {
                if(grid[i][j]==2)
                {
                    q.add(new Node(0,i,j));
                }
                if(grid[i][j]==1)
                {
                    freshcount++;
                }
            }

        }

        while(!q.isEmpty())
        {
            Node x=q.poll();
            int time=x.time;
            int row=x.row;
            int col=x.col;
            t=Math.max(t,time);

            int rown[] = {-1, 1,0,0};
            int coln[] = {0,0,-1,1};
            for(int i=0;i<4;i++)
            {
                if(row+rown[i]>=0 && col + coln[i]>=0 && col + coln[i] < grid[0].length && row+rown[i] < grid.length)
                {
                    if(grid[row+rown[i]][col + coln[i]]==1)
                    {
                        grid[row+rown[i]][col + coln[i]]=2;
                        rotten++;
                        q.add(new Node(time+1, row+rown[i], col + coln[i]));
                    }
                }
            }
        }

        return rotten==freshcount?t:-1;
    }

}

class Node
{
    int time;
    int row;
    int col;
    Node(int time, int row, int col)
    {
         this.time=time;
         this.row=row;
         this.col=col;
    }

}
