/* Topological sort - GeeksforGeeks Java Solutions*/

/*
-------------------Using DFS (USing Additional Stack)----------------------

Time Complexity: O(V + E).
Auxiliary Space: O(V).
*/

class TopologicalSort 
{
    private static void dfs(int s, ArrayList<ArrayList<Integer>> g, boolean vis[], Stack<Integer> st)
    {
        vis[s]=true;
        int i;
        
        for(i=0;i<g.get(s).size();i++)
        {
            if(!vis[g.get(s).get(i)])
                dfs(g.get(s).get(i), g, vis, st);
        }
        
        st.push(s);
    }
    static int[] topoSort(ArrayList<ArrayList<Integer>> g, int N) 
    {
        // add your code here
        boolean vis[]=new boolean[N];
        Stack<Integer> st=new Stack<>();
        int i;
        
        for(i=0;i<N;i++)
            if(!vis[i])
                dfs(i, g, vis, st);
        
        int res[]=new int[N];
        i=0;
        while(!st.isEmpty())
            res[i++]=st.pop();
        
        return res;
    }
}
