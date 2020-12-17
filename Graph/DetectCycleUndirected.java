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