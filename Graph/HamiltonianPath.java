/*Hamiltonian Path - GeeksforGeeks Java Solution*/

/*
--------------------------USing DFS and Backtracking-------------------------

TC - O(V^2)
SC - O(V^2)
*/

class HamiltonianPath 
{
    static int count;
    public static boolean checkHamiltonianPath(int [][]graph, int s, boolean[] vis, int V)
    {
        vis[s]=true;
        count++;
        
        if(count==V)
            return true;
            
        for(int i=0;i<graph[s].length;i++)
        {
            if(graph[s][i]==1 && !vis[i])
            {
                if(checkHamiltonianPath(graph,i,vis,V))
                    return true;
            }
        }
            
        vis[s]=false;
        count--;
        return false;
        
    }
	public static void main (String[] args)throws IOException
	{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int t = Integer.parseInt(br.readLine());
	    while(t-->0)
	    {
	        String[] arr=br.readLine().split("\\s");
	        int V=Integer.parseInt(arr[0]);
	        int E=Integer.parseInt(arr[1]);
	        int i,j;
	        
            int[][] graph = new int[V][V];
            
            arr=br.readLine().split("\\s");
            for(i=0;i<E;i++)
            {
                int u=Integer.parseInt(arr[2*i]);
	            int v=Integer.parseInt(arr[2*i + 1]);
                graph[u-1][v-1]=1;
                graph[v-1][u-1]=1;
            }
	        
	        boolean[] vis = new boolean[V];
            boolean res=false;

            for(i=0;i<V;i++)
            {
                Arrays.fill(vis, false);
                count=0;
                res=checkHamiltonianPath(graph,i,vis,V);
    
                if(res==true)
                    break;
            }
            
            if(res==false)
                System.out.println(0);
            else
                System.out.println(1);
	    }
	}
}