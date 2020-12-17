/* Detect cycle in an undirected graph - GeeksforGeeks Java Solutions*/


/*
--------------------Using DFS------------------------

Time Complexity: O(V + E).
Auxiliary Space: O(V).
*/

class DetectCycleUndirected
{
    
    private static boolean dfs(int s, ArrayList<ArrayList<Integer>> g, boolean vis[], int parent)
    {
        
        vis[s]=true;
        int i;
        for(i=0;i<g.get(s).size();i++)
        {
            if(!vis[g.get(s).get(i)])
            {
                if(dfs(g.get(s).get(i), g, vis, s))
                    return true;
            }
            
            else if(g.get(s).get(i)!=parent)
                return true;
        }
        
        return false;
    }
    static boolean isCyclic(ArrayList<ArrayList<Integer>> g, int V)
    {
       // add your code here
       boolean vis[]=new boolean[V];
       boolean res=false;
       int i;
       for(i=0;i<V;i++)
       {
           if(!vis[i])
                res=dfs(i, g, vis, -1);
       }
       
       return res;
    }
}




/*
--------------------Using BFS (Queue)------------------------

Time Complexity: O(V + E).
Auxiliary Space: O(V).
*/


class DetectCycle
{
    
    private static boolean bfs(int s, ArrayList<ArrayList<Integer>> g, boolean vis[])
    {
        
            int parent[] = new int[vis.length]; 
            Arrays.fill(parent, -1); 
  
            // Create a queue for BFS 
            Queue<Integer> q = new LinkedList<>(); 
  
            // Mark the current node as 
            // visited and enqueue it 
            vis[s] = true; 
            q.add(s); 
  
            while (!q.isEmpty())  
            { 
  
                // Dequeue a vertex from  
                // queue and print it 
                int u = q.poll(); 
  
  
                // Get all adjacent vertices  
                // of the dequeued vertex u. 
                // If a adjacent has not been  
                // visited, then mark it visited 
                // and enqueue it. We also mark parent 
                // so that parent is not considered 
                // for cycle. 
                for(int i=0;i<g.get(u).size();i++)
                { 
                    int v = g.get(u).get(i); 
                    if (!vis[v])  
                    { 
                        vis[v] = true; 
                        q.add(v); 
                        parent[v] = u; 
                    } 
                    else if (parent[u] != v) 
                        return true; 
                } 
            } 
            return false; 
    }
    static boolean isCyclic(ArrayList<ArrayList<Integer>> g, int V)
    {
       // add your code here
       boolean vis[]=new boolean[V];
       boolean res=false;
       int i;
       for(i=0;i<V;i++)
       {
           if (!vis[i] && bfs(i, g, vis)) 
                    return true; 
       }
       
       return false;
    }
}