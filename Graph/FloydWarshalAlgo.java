/* Floyd Warshall - GeeksforGeeks Java Solution*/

/*

TC - O(n^2)
Sc - O(n^2)
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class FloydWarshalAlgo
{
	public static void main (String[] args) throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		StringBuffer sb=new StringBuffer();
		
		while(T-->0)
		{
		    int n=Integer.parseInt(br.readLine());
		    int[][] dist=new int[n][n];
		    int[][] arr=new int[n][n];
		    int i,j,k;
		    
		    for(i=0;i<n;i++)
		    {
		        String[] s=br.readLine().split(" ");
		        for(j=0;j<n;j++)
		        {
		            arr[i][j]=Integer.parseInt(s[j]);
		            dist[i][j]=arr[i][j];
		        }
		    }
		    
		    for(k=0;k<n;k++)
		    {
		        for(i=0;i<n;i++)
		        {
		            for(j=0;j<n;j++)
		            {
		                if(dist[i][k]+dist[k][j]<dist[i][j])
		                    dist[i][j]=dist[i][k]+dist[k][j];
		                
		            }
		        }
		    }
		    for(int[] x:dist)
		    {
		        for(int y:x)
		        {
		            if(y==10000000)
		            {
		               sb.append("INF ");
		            }
		            else
		            {
		            sb.append(y+" ");
		            }
		        }
		        sb.append("\n");
		    }
		}
        System.out.print(sb);
	}
}
		    