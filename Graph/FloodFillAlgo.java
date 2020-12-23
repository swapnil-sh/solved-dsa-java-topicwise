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