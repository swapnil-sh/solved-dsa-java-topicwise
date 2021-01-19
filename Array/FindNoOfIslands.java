/* Find the number of islands - GeeksforGeeks and Leetcode(200) Java Solution*/

/*

-------------------------------------DFS Solution using Extra Space-------------------------------

TC - O(n*m)
SC - O(n*m)

*/

class FindNoOfIslands
{

    // Function to find the number of island in the given list A
    // N, M: size of list row and column respectively
    static boolean isSafe(ArrayList<ArrayList<Integer>> a, int x, int y,ArrayList<ArrayList<Boolean>> vis)
    {
        int n=a.size();;
        int m=a.get(0).size();
        
        return (x>=0 && x<n && y>=0 && y<m && (a.get(x).get(y)==1 && !vis.get(x).get(y)));
    }
    static void dfs(ArrayList<ArrayList<Integer>> a, int x, int y,ArrayList<ArrayList<Boolean>> vis)
    {
        int rowNum[]={-1,-1,-1,0,0,1,1,1};
        int colNum[]={-1,0,1,-1,1,-1,0,1};
        
        vis.get(x).set(y, true);
        
        for(int i=0;i<8;i++)
        {
            if(isSafe(a,x+rowNum[i],y+colNum[i],vis))
                dfs(a,x+rowNum[i],y+colNum[i],vis);
        }
    }
    static int findIslands(ArrayList<ArrayList<Integer>> a, int n, int m)
    {

        // Your code here
        ArrayList<ArrayList<Boolean>> vis=new ArrayList<>();
        
        int i,j,count=0;
        
        for(i=0;i<n;i++)
        {
            vis.add(new ArrayList<Boolean>());
            for(j=0;j<m;j++)
            {
                vis.get(i).add(j,false); 
            }
        }
        
        for(i=0;i<n;i++)
        {
            for(j=0;j<m;j++)
            {
                if(a.get(i).get(j)==1 && !vis.get(i).get(j))
                {
                    dfs(a,i,j,vis);
                    count++;
                }
            }
        }
     
        return count;   
    }
}



/*

-------------------------------------DFS Solution without using Extra Space-------------------------------

TC - O(n*m)
SC - O(1)

*/

/*
class Islands {

    // Function to find the number of island in the given list
    // N, M: size of list row and column respectively
    static void dfs(ArrayList<ArrayList<Integer>> adj, int i, int j)
    {
       if(i<0 || i>=adj.size() || j<0 || j>=adj.get(i).size() || adj.get(i).get(j)==0)
           return;
       
       
       adj.get(i).set(j,0); //substituting all possible connected 1's with 0's in ArrayList
    
        dfs(adj,i-1,j);
        dfs(adj,i+1,j);
        dfs(adj,i,j-1);
        dfs(adj,i,j+1);
        dfs(adj,i-1,j-1);
        dfs(adj,i+1,j+1);
        dfs(adj,i-1,j+1);
        dfs(adj,i+1,j-1);
    }
    
    static int findIslands(ArrayList<ArrayList<Integer>> list, int N, int M) 
    {
        
        int count=0;
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<M;j++)
            {
                if(list.get(i).get(j)==1)
                {
                    
                    dfs(list,i,j);
                    count++;
                }
            }
        }
        return count;
    }
}
*/



/*
----------Leetcode Solution--------------
*/

/*

class Solution 
{
    
    private boolean validAdjEdges(char [][]grid, int i, int j)
    {
        int n=grid.length;
        int m=grid[0].length;
        
        return (((i>=0 && i<n) && (j>=0 && j<m)) && (grid[i][j]=='1'));
    }
    
    private void dfs(int i, int j, char [][] grid)
    {
        
        int rowNum[]={-1,0,1,0};
        int colNum[]={0,-1,0,1};
        grid[i][j]='0';
        int k;
        
        for(k=0;k<4;k++)
        {
            if(validAdjEdges(grid, i+rowNum[k], j+colNum[k]))
                dfs(i+rowNum[k], j+colNum[k], grid);
        }
        
    }
    public int numIslands(char[][] grid)
    {
        int i,j,count=0;
        
        for(i=0;i<grid.length;i++)
        {
            for(j=0;j<grid[i].length;j++)
            {
                if(grid[i][j]=='1')
                {
                    dfs(i, j, grid);
                    count++;
                }
            }
        }
        
        return count;
    }
}
*/