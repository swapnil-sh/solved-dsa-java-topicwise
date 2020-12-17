/* BFS of graph  - GeeksforGeeks Java Solution*/

/*
----------------------Using Queue--------------------

Time Complexity: O(V + E).
Auxiliary Space: O(V).
*/

class BFSTraversal
{
    static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> g, int N)
    {
        // add your code here
        ArrayList<Integer> res=new ArrayList<>();
        if(g.size()==0)
            return res;
        
        boolean vis[]=new boolean[N];
        Queue<Integer> q=new LinkedList<>();
        
        q.offer(0);
        vis[0]=true;
        
        while(!q.isEmpty())
        {
            int temp=q.poll();
            res.add(temp);
        
            for(int i:g.get(temp))
            {
                if(!vis[i])
                {
                    vis[i]=true;
                    q.offer(i);
                }
            }
        }
        return res;
        
    }
}
