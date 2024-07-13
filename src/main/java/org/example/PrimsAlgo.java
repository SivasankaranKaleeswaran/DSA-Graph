package org.example;

import java.util.ArrayList;
import java.util.PriorityQueue;


// like dfs, use sum variable. check if the element is visited if not
// add in sum and in loop add the adacent element if not visited but dont mark it as visited.

// only difference is here after addiing it in queue we will not mark it as visited
//instead after removing from queue we will check and add in sum and in queue
public class PrimsAlgo {
    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
        int[][] edges = {{0, 1, 2}, {0, 2, 1}, {1, 2, 1}, {2, 3, 2}, {3, 4, 1}, {4, 2, 2}};

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<ArrayList<Integer>>());
        }

        for (int i = 0; i < 6; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

            ArrayList<Integer> tmp1 = new ArrayList<Integer>();
            ArrayList<Integer> tmp2 = new ArrayList<Integer>();
            tmp1.add(v);
            tmp1.add(w);

            tmp2.add(u);
            tmp2.add(w);

            adj.get(u).add(tmp1);
            adj.get(v).add(tmp2);
        }
        System.out.println(adj.toString());


        System.out.println("The sum of all the edge weights: " + spanningTree(V, adj));
    }

        private static int spanningTree ( int v, ArrayList<ArrayList<ArrayList<Integer>>>adj){

        int sum=0;
        boolean[] vis=new boolean[v];
        PriorityQueue<PrimPair> q=new PriorityQueue<>((x,y)->x.dis-y.dis);
        q.add(new PrimPair(-1,0,0));

        while(!q.isEmpty())
        {
            PrimPair t=q.poll();
            int node=t.node;
            int dis=t.dis;

            if(!vis[node])
            {
                sum+=dis;
                vis[node]=true;
                for(int i=0;i<adj.get(node).size();i++)
                {
                    int curr=adj.get(node).get(i).get(0);
                    int ndis=adj.get(node).get(i).get(1);
                    if(!vis[curr])
                    {
                        q.add(new PrimPair(node, curr, ndis));
                    }
                }
            }
        }
        return sum;
        }
    }

    class PrimPair
    {
        int parent, node, dis;

        public PrimPair(int parent, int node, int dis) {
            this.parent = parent;
            this.node = node;
            this.dis = dis;
        }
    }
