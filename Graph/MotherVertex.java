/* Mother Vertex  - GeeksforGeeks Java Solution*/

/*
------------------------Using DFS---------------------------

Time Complexity: O(V + E).
Auxiliary Space: O(V).

*/

class MotherVertex
{
    private static void dfs(int st, ArrayList<ArrayList<Integer>> g, boolean vis[])
    {
        int i;
        vis[st]=true;
        
        for(i=0;i<g.get(st).size();i++)
        {
            if(!vis[g.get(st).get(i)])
                dfs(g.get(st).get(i), g, vis);
        }
    }
    static int findMother(ArrayList<ArrayList<Integer>> g, int n)
    {
        // add your code here
        boolean vis[]=new boolean[n];
        int i, last_dfs=-1;
        
        for(i=0;i<n;i++)
        {
            if(!vis[i])
            {
                dfs(i, g, vis);
                last_dfs=i;
            }
        }
        
        for(i=0;i<n;i++)
            vis[i]=false;
        
        dfs(last_dfs, g, vis);
        for(i=0;i<n;i++)
        {
            if(!vis[i])
                return -1;
        }
        
        return last_dfs;
        
    }    
}
