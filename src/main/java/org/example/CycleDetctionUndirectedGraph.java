package org.example;

import java.util.ArrayList;

public class CycleDeectionUndirectedGraph {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            adj.add(new ArrayList < > ());
        }
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);


        boolean ans = isCycleDFS(4, adj);

    }

    private static boolean isCycleDFS(int i, ArrayList<ArrayList<Integer>> adj) {


        return true;

    }
}
