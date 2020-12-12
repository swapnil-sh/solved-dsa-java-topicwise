/* DFS of Graph  - GeeksforGeeks Java Solutions*/

/*
----------------------USing Stack--------------------

Time Complexity: O(V + E).
Auxiliary Space: O(V).
*/

class DFSTraversal
{
    static ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> g, int N)
    {
       // add your code here
       ArrayList<Integer> res=new ArrayList<>();
        if(g.size()==0)
            return res;
        
        int i,flag;
        boolean vis[]=new boolean[N];
        Stack<Integer> st=new Stack<>();
        
        st.push(0);
        vis[0]=true;
        res.add(0);
        
        while(!st.isEmpty())
        {
            int top=st.peek();
            flag=0;
            
            for(i=0;i<g.get(top).size();i++)
            {
                if(!vis[g.get(top).get(i)])
                {
                    vis[g.get(top).get(i)]=true;
                    st.push(g.get(top).get(i));
                    
                    res.add(g.get(top).get(i));
                    flag=1;
                    break;
                }
            }
                
            if(flag==0)
                st.pop();
        }
        
        return res;
    }
}



/*
-----------USing Recursion----------------------
*/
/*
class Traversal
{
    
    static void dfsUtil(int s, ArrayList<ArrayList<Integer>> g, boolean vis[], ArrayList<Integer> res)
    {
        int i;
        vis[s]=true;
        res.add(s);
        for(i=0;i<g.get(s).size();i++)
            if(!vis[g.get(s).get(i)])
                dfsUtil(g.get(s).get(i), g, vis, res);
    }
    static ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> g, int N)
    {
       // add your code here
       ArrayList<Integer> res=new ArrayList<>();
        if(g.size()==0)
            return res;
        
        int i,flag;
        boolean vis[]=new boolean[N];
        dfsUtil(0, g,vis, res);
        return res;
    }
}*/