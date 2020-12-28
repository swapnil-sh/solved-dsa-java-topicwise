/* Count the paths  - GeeksforGeeks Java Solutions*/


/*
-------------------Using DFS------------------

TC - O(n^2)
SC - O(V)
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Graph
{
    
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    public Graph(int V)
    {
        for(int i =0; i<V; i++)
            adj.add(new ArrayList<Integer>());
        
    }
    
    public void setEdg(int u,int v)
    {
        adj.get(u).add(v);
    }
    
    public int countPath(int s, int d)
    {
        int count = 0;
        boolean[] visited = new boolean[adj.size()];
        count = DFS(adj,s,d,visited);
        return count;
    }
    
    public int DFS(ArrayList<ArrayList<Integer>> adj, int s, int d, boolean[] visited)
    {
        if(s==d)
            return 1;
            
            visited[s] = true;
            int count = 0;
            for(int child : adj.get(s))
            {
                if(!visited[child]){
                    count += DFS(adj,child,d,visited);
                }
            }
            
        visited[s] = false;
        return count;
    }
}

class CountNoOfPaths
{
	public static void main (String[] args)throws IOException
	{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int t = Integer.parseInt(br.readLine());
	    while(t-->0)
	    {
	        String[] arr = br.readLine().split("\\s");
	        int V = Integer.parseInt(arr[0]);
	        int E = Integer.parseInt(arr[1]);
	        
	        Graph g = new Graph(V);
	        
	        arr = br.readLine().split("\\s");
	        for(int i =0; i<E; i++)
	        {
	           int u = Integer.parseInt(arr[2*i]);
	           int v = Integer.parseInt(arr[2*i + 1]);
	           g.setEdg(u,v);
	       }
	        
	        arr = br.readLine().split("\\s");
	        int s = Integer.parseInt(arr[0]);
	        int d = Integer.parseInt(arr[1]);
	        System.out.println(g.countPath(s,d));
	    }
	 }
}