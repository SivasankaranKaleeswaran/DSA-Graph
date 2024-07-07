package org.example;

//https://leetcode.com/problems/number-of-enclaves/description/
public class NumberofEnclaves {

    public static void main(String[] args)
    {
        int grid[][] = {
                {0, 0, 0, 0},
                {1, 0, 0, 0},
                {1, 1, 1, 0},
                {0, 0, 0, 0}};


      //  int vis[][] = new int[grid.length][grid[0].length];
        for(int i=0;i< grid[0].length;i++) {
            dfs(grid, 0, i);
        }
        for(int i=0;i< grid[0].length;i++) {
           dfs(grid, grid.length-1, i);
        }
        for(int i=0;i< grid.length;i++) {
            dfs(grid, i, 0);
        }
        for(int i=0;i< grid.length;i++) {
            dfs(grid, i, grid[0].length-1);
        }

        int count=0;
        for(int i=0;i< grid.length;i++)
        {
            for(int j=0;j< grid[0].length;j++)
            {
                if(grid[i][j]==1)
                {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    private static void dfs(int[][] grid, int row, int col) {

        if(row>-1 && row< grid.length && col >-1 && col < grid[0].length && grid[row][col]==1) {
            grid[row][col] = 0;

            dfs(grid, row + 1, col);
            dfs(grid, row - 1, col);
            dfs(grid, row, col - 1);
            dfs(grid, row, col + 1);
        }
        else  return;



    }
}
