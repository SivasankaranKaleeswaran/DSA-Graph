package org.example;

import java.util.PriorityQueue;

public class PathWithMinEffort {

    public static void main(String[] args) {

        int[][] heights = {{1, 2, 2}, {3, 8, 2}, {5, 3, 5}};

        System.out.println(minimumEffort(heights));
    }

    private static int minimumEffort(int[][] heights) {
        int rowL=heights.length;
        int colL= heights[0].length;
        int[][] dis = new int[rowL][colL];

        PriorityQueue<Tuple> q=new PriorityQueue<Tuple>((x,y)-> x.distance-y.distance);

        for(int i=0;i<rowL;i++)
        {
            for(int j=0;j<colL;j++)
            {
                dis[i][j]=Integer.MAX_VALUE;
            }
        }
        dis[0][0]=0;

        q.add(new Tuple(0,0,0));

        while(!q.isEmpty())
        {
            Tuple T=q.poll();
            int diff=T.distance;
            int row=T.row;
            int col=T.col;

            if(row==rowL-1 && col==colL-1) return diff;
            int nrow[]={0,0,-1,1};
            int ncol[]={-1,1,0,0};
            for(int i=0;i<4;i++)
            {
                int rown=row+nrow[i];
                int coln=col+ncol[i];

                if(rown>-1 && coln>-1 && coln<colL && rown<rowL)
                {
                    int diffn=Math.max(diff,Math.abs(heights[row][col]-heights[rown][coln]));
                    if(diffn< dis[rown][coln])
                    {
                        dis[rown][coln]=diffn;
                        q.add(new Tuple(rown, coln, diffn));
                    }
                }
            }

        }

        return 1;
    }

}
class Tuple
{
    int row, col, distance;

    public Tuple(int row, int col, int distance) {
        this.row = row;
        this.col = col;
        this.distance = distance;
    }
}