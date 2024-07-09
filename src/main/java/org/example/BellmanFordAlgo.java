package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class BellmanFordAlgo {
    public static void main(String[] args) {
        int V = 6;
        int S = 0;
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>() {
            {
                add(new ArrayList<Integer>(Arrays.asList(3, 2, 6)));
                add(new ArrayList<Integer>(Arrays.asList(5, 3, 1)));
                add(new ArrayList<Integer>(Arrays.asList(0, 1, 5)));
                add(new ArrayList<Integer>(Arrays.asList(1, 5, -3)));
                add(new ArrayList<Integer>(Arrays.asList(1, 2, -2)));
                add(new ArrayList<Integer>(Arrays.asList(3, 4, -2)));
                add(new ArrayList<Integer>(Arrays.asList(2, 4, 3)));
            }
        };



        int[] dist = bellman_ford(V, edges, S);
        for (int i = 0; i < V; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println("");
}

    private static int[] bellman_ford(int v, ArrayList<ArrayList<Integer>> edges, int s) {
        int[] dis = new int[v];

        for(int i=1;i<v;i++)
        {
            dis[i]=Integer.MAX_VALUE;
        }
        dis[0]=0;
        for(int i=1;i<v;i++) {
            for (ArrayList<Integer> arr : edges) {
                if (dis[arr.get(0)] != Integer.MAX_VALUE && dis[arr.get(0)] + arr.get(2) < dis[arr.get(1)]) {
                    dis[arr.get(1)] = dis[arr.get(0)] + arr.get(2);
                }
            }
        }


        for (ArrayList<Integer> arr : edges) {
            if (dis[arr.get(0)] != Integer.MAX_VALUE && dis[arr.get(0)] + arr.get(2) < dis[arr.get(1)]) {
                System.out.println("negative cycle exist");
            }
        }



        return dis;
    }
    }
