/* Minimum Spanning Tree - GeeksforGeeks Java Prims Algo Implementation*/


/*
--------------Using 3 ArraysLists---------------

Time Complexity: O(V^2).
Auxiliary Space: O(V).
*/

class PrimsAlgoMST
{
    
    static int getMin(ArrayList<Integer> wt,ArrayList<Boolean> vis)
    {
        int min=-1;
        for(int i=0;i<wt.size();i++)
        {
            if((!vis.get(i)) && (min == -1 || wt.get(i)<=wt.get(min)))
                min=i;
        }
        
        return min;
    }
    
    static int spanningTree(int V, int E, ArrayList<ArrayList<Integer>> graph)
    {
        // Add your code here
        int max=Integer.MAX_VALUE;
        int i,j;
        ArrayList<Integer> wt = new ArrayList<Integer>(V);
        ArrayList<Integer> parent = new ArrayList<Integer>(V);
        ArrayList<Boolean> visited = new ArrayList<Boolean>(V);
        
        for(i=0;i<V;i++)
            wt.add(new Integer(max));
        
        for(i=0;i<V;i++)
            parent.add(-1);
        
        for(i=0;i<V;i++)
            visited.add(false);
         
        parent.set(0,-1);
        wt.set(0,0);
        
        for(i=0;i<V;i++)
        {
            int minVertex=getMin(wt,visited);
            
            visited.set(minVertex,true);
            
            
            for(j=0;j<V;j++)
            {
                if((!visited.get(j)) && graph.get(minVertex).get(j)!=0)
                {
                    if(graph.get(minVertex).get(j)<wt.get(j))
                    {
                        wt.set(j,graph.get(minVertex).get(j));
                        parent.set(j,minVertex);
                    }
                }
            }
        }
        
        int sum=0;
        for(i=0;i<V;i++)
        {
           // System.out.print(wt.get(i)+" ");
          sum+=wt.get(i);
        }
      
     
       return sum;
    }

}

    

/*
--------------Using 3 MinHeap and PQ--------------

Time Complexity: O(Vlogn).
Auxiliary Space: O(V).
*/

/*
class Pair{
    int vertex;
    int key;
    Pair(int vertex,int key){
        this.vertex= vertex;
        this.key=key;
    }
}
class MySort implements Comparator<Pair>
{
    public int compare(Pair a,Pair b)
    {
        if(a.key>b.key)
            return 1;
        else if(a.key<b.key)
            return -1;
        else return 0;
    }
}
class MST
{
    static int spanningTree(int V, int E, ArrayList<ArrayList<Integer>> graph)
    {
        int parent[]=new int[V];
        for(int i=0;i<V;i++)
            parent[i]=-1;
        PriorityQueue<Pair> pq= new PriorityQueue<Pair>(V,new MySort());
        HashMap<Integer,Pair> hmap= new HashMap<Integer,Pair>();
        hmap.put(0,new Pair(0,0));
        pq.add(hmap.get(0));
        for(int i=1;i<V;i++)
	{
            hmap.put(i,new Pair(i,Integer.MAX_VALUE));
            pq.add(hmap.get(i));
        }
        while(!pq.isEmpty())
	{
            Pair u=pq.remove();
            ArrayList<Integer> list=graph.get(u.vertex); 
            for(int v=0;v<V;v++)
	    {
                int weight=list.get(v);
                if(weight!=Integer.MAX_VALUE&&pq.contains(hmap.get(v)))
		{
                    if(weight<hmap.get(v).key)
		     {
                        pq.remove(hmap.get(v));
                        hmap.get(v).key=weight;
                        pq.add(hmap.get(v));
                        parent[v]=u.vertex;
                    }
                }
            }
        }
        int res=0;
        for(int i=0;i<V;i++){
            if(parent[i]!=-1){
                res+=graph.get(i).get(parent[i]);    //undirected graph so any order is fine.
            }
        }
        return res;
    }
}

*/