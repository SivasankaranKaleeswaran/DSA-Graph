package org.example;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://leetcode.com/problems/course-schedule-ii/description/
public class CourseSchedule {
    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{1,0},{0,1}};

        List<Integer> and = canFinish(numCourses, prerequisites);
        System.out.println(and.size()==numCourses?and.toString():List.of());

    }

    public static List<Integer> canFinish(int num, int[][] adj) {

        ArrayList<ArrayList<Integer>> lis= new ArrayList<>();
        for(int i=0;i<num;i++)
        {
            lis.add(new ArrayList<>());
        }
        List<Integer> ans=new LinkedList<>();
        int[] count=new int[num];

        for(int i=0;i<adj.length;i++)
        {
            lis.get(adj[i][1]).add(adj[i][0]);
        }
        for(int i=0;i<num;i++)
            for(int k:lis.get(i))
            {
                count[k]++;
            }
        Queue<Integer> q= new LinkedList<>();
        for(int i=0;i<num;i++)
        {
           if(count[i]==0)  q.add(i);
        }

        while(!q.isEmpty())
        {
            int temp=q.poll();
            ans.add(temp);
            for(int k:lis.get(temp))
            {
                count[k]--;
                if(count[k]==0) q.add(k);
            }
        }

        return ans;
    }
}
