/* Strongly Connected Components (Kosaraju's Algo) - GeeksforGeeks Java Solution*/


/*
------------------Using DFS------------------

Time Complexity: O(N + M).
Auxiliary Space: O(N).
*/
class KosarajuAlgo
{
    static Stack<Integer> stack;
    static void dfs(ArrayList<ArrayList<Integer>> list, boolean visited[], int start, Stack<Integer> stack)
    {
        visited[start]=true;
        ArrayList<Integer> temp = list.get(start);
        for(int i=0; i<temp.size(); i++)
        {
            int num=temp.get(i);
            if(visited[num]==false)
            {
                dfs(list,visited,num,stack);
            }
        }
        stack.push(start);
    }
    
    static void reverse(ArrayList<ArrayList<Integer>> revlist, ArrayList<ArrayList<Integer>> list)
    {
        for(int i=0; i<list.size(); i++)
        {
            for(int j=0; j<list.get(i).size(); j++)
            {
                int num = list.get(i).get(j);
                revlist.get(num).add(i);
            }
        }
    }
    
    static void print(ArrayList<ArrayList<Integer>> list )
    {
        for(int i=0 ;i<list.size(); i++)
        {
            System.out.print(i+"-> ");
            for(int j=0; j<list.get(i).size() ;j++)
            {
                System.out.print(list.get(i).get(j)+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    static void dfs2(ArrayList<ArrayList<Integer>> list, boolean visited[], int start)
    {
        visited[start]=true;
        ArrayList<Integer> temp = list.get(start);
        for(int i=0; i<temp.size(); i++)
        {
            int num=temp.get(i);
            if(visited[num]==false)
            {
                dfs2(list,visited,num);
            }
        }
    }
    
    public int kosaraju(ArrayList<ArrayList<Integer>> list, int n)
    {
         stack = new Stack<Integer>();
         boolean visited[]= new boolean[n];
         for(int i=0; i<n; i++)
         {
            if(visited[i]==false)
            {
                  dfs(list,visited,i,stack);
            }
         }
          
         ArrayList<ArrayList<Integer>> revlist = new ArrayList<ArrayList<Integer>>();
         
         for(int i=0; i<n; i++)
             revlist.add(new ArrayList<Integer>());
         
         reverse(revlist, list);
         
         Arrays.fill(visited,false);
         int cnt=0;
         
         while(!stack.isEmpty())
         {
             int start= stack.pop();
             if(visited[start]==false)
             {
                 cnt++;
                 dfs2(revlist, visited, start);
             }
         }
         
         return cnt;
    }
}
