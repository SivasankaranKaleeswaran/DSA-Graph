package org.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/cheapest-flights-within-k-stops/description/
public class CheapestFlightWithKstops
{
    public static void main(String[] args) {

        int n = 4, src = 0, dst = 3, K = 1;
        int[][] flights={{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};

        System.out.println(cheapestFLight(n,flights,src,dst,K));
    }

    private static int cheapestFLight(int n, int[][] flights, int src, int dst, int k) {

        ArrayList<ArrayList<FlightPair>> adj=new ArrayList<>();
        int[] dis=new int[n];

        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
            dis[i]=Integer.MAX_VALUE;
        }

        for(int i=0;i<flights.length;i++)
        {
            adj.get(flights[i][0]).add(new FlightPair(flights[i][1], flights[i][2]));
        }

        Queue<FlightTuples> q= new LinkedList<>();
        q.add(new FlightTuples(0, src, 0));
        dis[src]=0;

        while (!q.isEmpty())
        {
            FlightTuples t=q.poll();
            int stop=t.stop;
            int srce=t.src;
            int amount=t.cost;
            if(stop<=k)
            {
                for(FlightPair j:adj.get(srce))
                {
                    if(amount+j.cost < dis[j.dest])
                    {
                        dis[j.dest]=amount+j.cost;
                        q.add(new FlightTuples(stop+1, j.dest, dis[j.dest]));
                    }
                }
            }
        }

        return dis[dst];
    }
}

class FlightPair
{
    int dest, cost;

    public FlightPair(int dest, int cost) {
        this.dest = dest;
        this.cost = cost;
    }
}

class FlightTuples
{
    int stop, src, cost;

    public FlightTuples(int stop, int src, int cost) {
        this.stop = stop;
        this.src = src;
        this.cost = cost;
    }
}
