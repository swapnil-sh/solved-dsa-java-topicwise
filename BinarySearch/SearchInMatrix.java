/*Search in a matrix - GeeksforGeeks Binary Search Java Solution O(n+m) */

import java.util.*;
import java.lang.*;
import java.io.*;

class SearchInMatrix 
{
    public static int searchMatrix(int a[][],int n,int m,int k)
    {
        int i=0;
        int j=m-1;
        while(i>=0 && i<n && j>=0 && j<m)
        {
            if(a[i][j]==k)
                return 1;
            else if(a[i][j]>k)
                j--;
            else if(a[i][j]<k)
                i++;
        }
        
        return 0;
        
    }
	public static void main (String[] args)throws IOException
	{
		//code
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0)
		{
			int n=sc.nextInt();
			int m=sc.nextInt();
			
			int[][] a=new int[n][m];
			
			for(int i=0;i<n;i++)
			    for(int j=0;j<m;j++)
				a[i][j]=sc.nextInt();
				
			int k=sc.nextInt();
			
			System.out.println(searchMatrix(a,n,m,k));
		}
	}
}
