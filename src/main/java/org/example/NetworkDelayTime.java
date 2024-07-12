package org.example;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class NetworkDelayTime {
    public static void main(String[] args) {

        int[][] times = {{2,1,1},{2,3,1},{3,4,1}};
        int n = 4, k = 2;

        System.out.println(networkDelayTime(times, n, k));
    }

    public static int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<NetworkPair>> adj=new ArrayList<>();
        int[] dis=new int[n+1];

        for(int i=0;i<n+1;i++)
        {
            adj.add(new ArrayList<>());
            dis[i]=Integer.MAX_VALUE;
        }

        for(int[] t:times)
        {
            adj.get(t[0]).add(new NetworkPair(t[1],t[2]));
        }
        PriorityQueue<NetworkPair> q=new PriorityQueue<>((x,y)->x.time-y.time);
        q.add(new NetworkPair(k,0));
        dis[k]=0;

        while (!q.isEmpty())
        {
            NetworkPair t=q.poll();
            int dst=t.src;
            int dist=t.time;

            for(NetworkPair p:adj.get(dst))
            {
                int ndist=dist+p.time;
                if(ndist<dis[p.src])
                {
                    dis[p.src]=ndist;
                    q.add(new NetworkPair(p.src, ndist));
                }
            }
        }
        int out=Integer.MIN_VALUE;
        //System.out.println(Arrays.toString(dis));

        for(int i=1;i<n+1;i++)
        {
            if(dis[i]==Integer.MAX_VALUE) return -1;
            if(dis[i]>out) out=dis[i];
        }

        return out;
    }

}

class NetworkPair
{
    int src, time;

    public NetworkPair(int src, int time) {
        this.src = src;
        this.time = time;
    }
}
