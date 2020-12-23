/* Flood fill Algorithm - GeeksforGeeks Java Solutions*/

/*
------------------Using DFS-----------------------

TC - O(n*m)
SC - O(1)
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class FloodFillAlgo
{
	private static void floodFill(int a[][], int n, int m, int x, int y, int oldCol, int newCol)
    	{
        
            if(x>=0 && x<n && y>=0 && y<m && a[x][y]==oldCol)
            {
                a[x][y]=newCol;
            
                floodFill(a, n, m, x-1, y, oldCol, newCol);
                floodFill(a, n, m, x+1, y, oldCol, newCol);
                floodFill(a, n, m, x, y-1, oldCol, newCol);
                floodFill(a, n, m, x, y+1, oldCol, newCol);
            }
        
            return;
      	}
	public static void main (String[] args)throws IOException
	{
	 //code
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

	    int t=Integer.parseInt(br.readLine());
	    while(t--!=0)
	    {
	        String s[]=br.readLine().split("\\s");
	        int n,m;
	        n=Integer.parseInt(s[0]);
	        m=Integer.parseInt(s[1]);
	        s=br.readLine().split("\\s");
	        int a[][]=new int[n][m];
	        int i,j,c=0;
	        
	        for(i=0;i<n;i++)
	        {
	            for(j=0;j<m;j++)
	                a[i][j]=Integer.parseInt(s[c++]);
	        }
	        
	        s=br.readLine().split("\\s");
	        int x=Integer.parseInt(s[0]);
	        int y=Integer.parseInt(s[1]);
	        int k=Integer.parseInt(s[2]);
	        
	        floodFill(a, n, m, x, y, a[x][y], k);
	        
	        for(i=0;i<n;i++)
	        {
	            for(j=0;j<m;j++)
	            {
	                System.out.print(a[i][j]+" ");
	            }
	        }
	        
	        System.out.println();
	    }
	    
	    
	}
}



/*
-----------------------BFS Approach(Queue)------------------------

GFG Solution

Algorithm for BFS based approach :

    Create a queue of pairs.
    Insert an initial index given in the queue.
    Mark initial index as visited in vis[][] matrix.
    Until the queue is not empty repeat step 3.1 to 3.6
        Take the front element from the queue
        Pop from the queue
        Store current value/colour at coordinate taken out from queue (precolor)
        Update the value/color of the current index which is taken out from the queue
        Check for all 4 direction i.e (x+1,y),(x-1,y),(x,y+1),(x,y-1) is valid or not and if valid then check that value at that coordinate should be equal to precolor and value of that coordinate in vis[][] is 0.
        If all the above condition is true push the corresponding coordinate in queue and mark as 1 in vis[][]
    Print the matrix.


TC - O(n*m)
SC - O(n)

*/

/*
import java.io.*;
import java.util.*;
 
// Class to store the pairs
class Pair implements Comparable<Pair> {
    int first;
    int second;
 
    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
 
    @Override
    public int compareTo(Pair o) {
        return second - o.second;
    }
}
 
class GFG {
    public static int validCoord(int x, int y, int n, int m)
    {
        if (x < 0 || y < 0) {
            return 0;
        }
        if (x >= n || y >= m) {
            return 0;
        }
        return 1;
    }
    // Function to run bfs
    public static void bfs(int n, int m, int data[][],int x, int y, int color)
    {
   
        // Visiing array
         int vis[][]=new int[101][101];
         
        // Initialing all as zero
        for(int i=0;i<=100;i++){
            for(int j=0;j<=100;j++){
                vis[i][j]=0;
            }
        }
         
        // Creating queue for bfs
         Queue<Pair> obj = new LinkedList<>();
   
        // Pushing pair of {x, y}
         Pair pq=new Pair(x,y);
         obj.add(pq);
          
        // Marking {x, y} as visited
         vis[x][y] = 1;
   
        // Untill queue is emppty
        while (!obj.isEmpty()) 
        {
            // Extrating front pair
            Pair coord = obj.peek();
            int x1 = coord.first;
            int y1 = coord.second;
            int preColor = data[x1][y1];
             
            data[x1][y1] = color;
     
            // Poping front pair of queue
            obj.remove();
 
            // For Upside Pixel or Cell
            if ((validCoord(x1 + 1, y1, n, m)==1) && vis[x1 + 1][y1] == 0 && data[x1 + 1][y1] == preColor)
            {
                Pair p=new Pair(x1 +1, y1);
                obj.add(p);
                vis[x1 + 1][y1] = 1;
            }
     
            // For Downside Pixel or Cell
            if ((validCoord(x1 - 1, y1, n, m)==1) && vis[x1 - 1][y1] == 0 && data[x1 - 1][y1] == preColor) 
            {
                Pair p=new Pair(x1-1,y1);
                obj.add(p);
                vis[x1- 1][y1] = 1;
            }
     
            // For Right side Pixel or Cell
            if ((validCoord(x1, y1 + 1, n, m)==1) && vis[x1][y1 + 1] == 0 && data[x1][y1 + 1] == preColor) 
            {
                Pair p=new Pair(x1,y1 +1);
                obj.add(p);
                vis[x1][y1 + 1] = 1;
            }
     
            // For Left side Pixel or Cell
            if ((validCoord(x1, y1 - 1, n, m)==1) && vis[x1][y1 - 1] == 0 && data[x1][y1 - 1] == preColor) 
            {
                Pair p=new Pair(x1,y1 -1);
                obj.add(p);
                vis[x1][y1 - 1] = 1;
            }
        }
   
         // Printing The Changed Matrix Of Pixels
        for (int i = 0; i < n; i++) 
        {
            for (int j = 0; j < m; j++) 
            {   
             System.out.print(data[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void main (String[] args) {
        int nn, mm, xx, yy, colorr;
        nn = 8;
        mm = 8;
 
        int dataa[][] = {{ 1, 1, 1, 1, 1, 1, 1, 1 },
                          { 1, 1, 1, 1, 1, 1, 0, 0 },
                          { 1, 0, 0, 1, 1, 0, 1, 1 },
                          { 1, 2, 2, 2, 2, 0, 1, 0 },
                          { 1, 1, 1, 2, 2, 0, 1, 0 },
                          { 1, 1, 1, 2, 2, 2, 2, 0 },
                          { 1, 1, 1, 1, 1, 2, 1, 1 },
                          { 1, 1, 1, 1, 1, 2, 2, 1 },};
 
        xx = 4; yy = 4; colorr = 3;
   
        // Function Call
        bfs(nn, mm, dataa, xx, yy, colorr);
    }
} 

*/