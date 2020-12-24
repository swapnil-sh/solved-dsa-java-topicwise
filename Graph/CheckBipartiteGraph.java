/*Bipartite Graph - GeeksforGeeks Java Solution*/


// https://practice.geeksforgeeks.org/problems/bipartite-graph/1
// https://www.youtube.com/watch?v=MtFPqCcsoeA (Good video explanation)

/*
------------------------Using DFS--------------------------

TC - O(v*v)
SC - O(v)
*/

class CheckBipartiteGraph 
{
    private boolean dfs(int st, int color, boolean[] vis, int[] colorOfNodes, int g[][]) 
    {
        vis[st]=true;
        colorOfNodes[st]=color;
        
        boolean flag=true;
        int i;
        
        for(i=0;i<g[st].length;i++)
        {
            if(g[st][i]==1)
            {
                if(!vis[i])
                {
                    flag=dfs(i, 1-color, vis, colorOfNodes, g);
                    if(flag==false)
                        return false;
                }
            
                else if(colorOfNodes[st]==colorOfNodes[i])
                    return false;
            }
            
        }
        
        return true;
    }
    boolean isBipartite(int G[][],int V)
    {
          //add code here.
        boolean[] vis = new boolean[V];
        int[] colorOfNodes = new int[V];

        // we are starting with node 0 and color 0
        int color=0; // there are only two color to denote alternate vertices : 0 and 1
        int i;
        // this graph can disconnected also, check for all the nodes of the graph
        for(i=0;i<V;i++)
        {
            if(!vis[i]) 
            {
                if(!dfs(i, color, vis, colorOfNodes, G)) 
                    return false;
            }
        }
        
        return true;
          
    }
}