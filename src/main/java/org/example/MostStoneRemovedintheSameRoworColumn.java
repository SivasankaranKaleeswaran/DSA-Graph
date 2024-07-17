package org.example;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/description/
public class MostStoneRemovedintheSameRoworColumn {
    public static void main (String[] args) {
        int n = 6;
        int[][] stones = {
                {0, 0}, {0, 2},
                {1, 3}, {3, 1},
                {3, 2}, {4, 3}
        };

        //  MostStoneRemovedintheSameRoworColumn obj = new MostStoneRemovedintheSameRoworColumn();

        System.out.println("The maximum number of stones we can remove is: " + maxRemove(stones, n));
    }

    private static int maxRemove(int[][] stones, int n) {
        int maxR=0,maxC=0;

        for(int i=0;i<stones.length;i++)
        {
            maxR=Math.max(maxR,stones[i][0]);
            maxC=Math.max(maxC,stones[i][1]);
        }
        int m=maxR+maxC+1;

        int[] size=new int[m+1];
        int[] parent=new int[m+1];
        for(int i=0;i<=m;i++)
        {
            size[i]=1;
            parent[i]=i;
        }

        Set<Integer> uniElement=new HashSet<>();
        for(int i=0;i<stones.length;i++)
        {
            int rowN=stones[i][0];
            int colN=stones[i][1]+1+maxR;
            unionBySize(rowN,colN, size, parent);
            uniElement.add(rowN);
            uniElement.add(colN);
        }

        int count=0;
        for (int i: uniElement)
        {
            if(i==parent[i]) count++;
        }
        return stones.length-count;
    }

    private static void unionBySize(int rowN, int colN, int[] size, int[] parent) {

        int uParenRow=ultiParent(rowN, size, parent);
        int uParentCol=ultiParent(colN, size, parent);

        if(uParentCol == uParenRow ) return;

        if(size[uParenRow]<size[uParentCol])
        {
            parent[uParenRow]=uParentCol;
            size[uParentCol]+=size[uParenRow];
        }
        else
        {
            parent[uParentCol]=uParenRow;
            size[uParenRow]+=size[uParentCol];
        }
    }

    private static int ultiParent(int k, int[] size, int[] parent) {
        if(k==parent[k]) return k;
        int ultPar=ultiParent(parent[k], size, parent);
        parent[k]=ultPar;
        return ultPar;
    }
}
