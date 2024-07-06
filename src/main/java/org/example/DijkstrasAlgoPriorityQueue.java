package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class DijkstrasAlgoPriorityQueue {
    public static void main(String[] args) {
        int V = 3, E=3,S=2;
        ArrayList<Integer> node1 = new ArrayList<Integer>() {{add(1);add(1);}};
        ArrayList<Integer> node2 = new ArrayList<Integer>() {{add(2);add(6);}};
        ArrayList<Integer> node3 = new ArrayList<Integer>() {{add(2);add(3);}};
        ArrayList<Integer> node4 = new ArrayList<Integer>() {{add(0);add(1);}};
        ArrayList<Integer> node5 = new ArrayList<Integer>() {{add(1);add(3);}};
        ArrayList<Integer> node6 = new ArrayList<Integer>() {{add(0);add(6);}};

        ArrayList<ArrayList<Integer>> inter1 = new ArrayList<ArrayList<Integer>>(){
            {
                add(node1);
                add(node2);
            }
        };
        ArrayList<ArrayList<Integer>> inter2 = new ArrayList<ArrayList<Integer>>(){
            {
                add(node3);
                add(node4);
            }
        };
        ArrayList<ArrayList<Integer>> inter3 = new ArrayList<ArrayList<Integer>>(){
            {
                add(node5);
                add(node6);
            }
        };
        ArrayList<ArrayList<ArrayList<Integer>>> adj= new ArrayList<ArrayList<ArrayList<Integer>>>(){
            {
                add(inter1); // for 1st node
                add(inter2); // for 2nd node
                add(inter3); // for 3rd node
            }
        };

        System.out.println(Arrays.toString(dijkstra(V,adj,S)));
    }

    private static int[] dijkstra(int v, ArrayList<ArrayList<ArrayList<Integer>>> adj, int s) {

        int[] dis = new int[v];
        PriorityQueue<Djpair> q=new PriorityQueue<Djpair>((x,y)-> x.distance-y.distance);

        for(int i=0;i<v;i++)
        {
            dis[i]=Integer.MAX_VALUE;
        }

        q.add(new Djpair(0,s));

        dis[s]=0;
        while(!q.isEmpty())
        {
            Djpair temp=q.poll();
            int curr=temp.node;
            int dist=temp.distance;

            for(int i=0;i<adj.get(curr).size();i++)
            {
                int enode=adj.get(curr).get(i).get(0);
                int edis= adj.get(curr).get(i).get(1);

                if(dist+edis < dis[enode])
                {
                    dis[enode]=dist+edis;
                    q.add(new Djpair(dis[enode], enode));
                }
            }
        }

        return dis;
    }
}

class Djpair
{
    int node;
    int distance;
    Djpair(int distance, int node)
    {
        this.distance=distance;
        this.node=node;

    }
}
