/* Implementing Dijkstra | Set 1 (Adjacency Matrix) - GeeksforGeeks Java Solution*/

class DijkstraAlgo
{
    static int minDistance(int dist[],boolean set[],int V)
    {
        int min = Integer.MAX_VALUE;
        int min_index=-1;
        
        //Iterate through dist[] and return the index of the node with min distance value.
        for(int v=0;v<V;v++) 
        {
            if(set[v]==false && dist[v]<=min)  
            {
                min = dist[v];
                min_index=v;
            }
        }
        return min_index;
    }
    
    static int[] dijkstra(ArrayList<ArrayList<Integer>> list, int src, int V)
    {
        // Write your code here
        int dist[] = new int[V]; //Stores the shortest path SOURCE node to all V nodes.
        boolean set[] = new boolean[V];
       //Initialize all distances to inf except source node.
       //Initialize boolean array to false(Already false in java so no need)
           Arrays.fill(dist,Integer.MAX_VALUE);
           
           dist[src] = 0;
           for(int i=0;i<V;i++) //Go through all the vertices.
           {
               int u = minDistance(dist,set,V);  //Here we pick the vertex with min distance value. 
               //u-> CURRENT min vertex  
               set[u] = true; //Now include the vertex in the set.
               
               for(int v=0;v<V;v++)  //To update distance values of all ADJACENT vertices of u.
               {
                   //v-> vertex adjacent to CURRENT vertex
                   if (set[v]==false && list.get(u).get(v)!= 0 && dist[u] != Integer.MAX_VALUE) 
                        dist[v] = Math.min(dist[v],dist[u] + list.get(u).get(v));
                        //Take the min of cur dist value AND distance from src to u + cost of going to v from u.
               }
           }
           
            return dist;   
    }
}
