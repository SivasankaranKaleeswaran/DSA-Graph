package org.example;

import java.util.Arrays;

//https://leetcode.com/problems/surrounded-regions/
public class SurroundedRegion {

    public static void main(String[] args)
    {
        char grid[][] = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'O', 'X', 'X'},
                {'X', 'X', 'O', 'O'}};

        boolean vis[][] = new boolean[grid.length][grid[0].length];


        //  int vis[][] = new int[grid.length][grid[0].length];
        for(int i=0;i< grid[0].length;i++) {
            dfs(grid, 0, i, vis);
        }
        for(int i=0;i< grid[0].length;i++) {
            dfs(grid, grid.length-1, i, vis);
        }
        for(int i=0;i< grid.length;i++) {
            dfs(grid, i, 0, vis);
        }
        for(int i=0;i< grid.length;i++) {
            dfs(grid, i, grid[0].length-1, vis);
        }

        int count=0;
        for(int i=0;i< grid.length;i++)
        {
            for(int j=0;j< grid[0].length;j++)
            {
                if(grid[i][j]=='O' && !vis[i][j])
                {
                    grid[i][j]='X';
                }
            }
        }
        for(int i=0;i< grid.length;i++)
         System.out.println(Arrays.toString(grid[i]));
    }

    private static void dfs(char grid[][], int row, int col, boolean vis[][]) {

        if(row>-1 && row< grid.length && col >-1 && col < grid[0].length && grid[row][col]=='O' && !vis[row][col]) {
            vis[row][col] = true;

            dfs(grid, row + 1, col, vis);
            dfs(grid, row - 1, col, vis);
            dfs(grid, row, col - 1, vis);
            dfs(grid, row, col + 1, vis);
        }
        else  return;



    }
}
