/*Detect cycle in a directed graph - GeeksforGeeks Java Solution*/

/*
-------------------Using DFS--------------------

 Complexity Analysis:

    Time Complexity: O(V+E).
    Time Complexity of this method is same as time complexity of DFS traversal which is O(V+E).

    Space Complexity: O(V).
    To store the visited and recursion stack O(V) space is needed.



*/

class DetectCycleDirected
{
    private static boolean dfs(int s, ArrayList<ArrayList<Integer>> g, boolean vis[], boolean rec[])
    {
        if(vis[s]==false)
        {
            int i;
            vis[s]=true;
            rec[s]=true;
            
            for(i=0;i<g.get(s).size();i++)
            {
                if(!vis[g.get(s).get(i)] && dfs(g.get(s).get(i), g, vis, rec))
                    return true;
                else if(rec[g.get(s).get(i)]==true)
                    return true;
            }
        }
        
        rec[s]=false;
        return false;
    }
    
    static boolean isCyclic(ArrayList<ArrayList<Integer>> g, int V)
    {
        // add your code here
        int i;
        boolean vis[]=new boolean[V];
        boolean rec[]=new boolean[V];
       // boolean res=false;
        
        for(i=0;i<V;i++)
        {
            if(!vis[i])
                if(dfs(i, g, vis, rec))
                    return true;
        }
        
        return false;
    }
}