/*Travelling Salesman Problem - GeeksforGeeks Java Solution*/


import java.util.*;
import java.lang.*;
import java.io.*;

class TSP
{
     static int min_cost;
     static void travellingSalesMan(int src,int current_source,int[][] cities,boolean[] vis,int n,int count,int cost)
     {
	    if(count==n)
	    {
            if(cities[current_source][src]!=0)
                min_cost=Math.min(min_cost,cost+cities[current_source][src]);
            
	        return;
	    }
	    
	    vis[current_source]=true;
	    int i;
	    
	    for(i=0;i<n;i++)
	    {
	        if(cities[current_source][i]!=0 && vis[i]==false)
	            travellingSalesMan(src,i,cities,vis,n,count+1,cost+cities[current_source][i]);
	        
	    }
	    
	    vis[current_source]=false;
	}
     
	public static void main (String[] args)throws Exception
	{
	    Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int[][] cities = new int[n][n];
		    boolean[] vis = new boolean[n];
		    
		    for(int i=0;i<n;i++)
		        for(int j=0;j<n;j++)
		            cities[i][j] = sc.nextInt();
		    
		    Arrays.fill(vis, false);
		    min_cost=Integer.MAX_VALUE;
		    
		    travellingSalesMan(0,0,cities,vis,n,1,0);
		    System.out.println(min_cost);
		}
	 
	 }
}