/* Unique BST's - GeeksforGeeks Java Solutions*/


/*
--------------USing Recursion and Memoization--------------

Time Complexity - O(3 ^ N) (Rec)
*/

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class CountUniqBST
{
    
    int catalanRec(int n)
    {
       if(n==0 || n==1)
        return 1;

       int count= 0;
       for(int i=1;i<n;i++)
        count+= catalan(i)*catalan(n-i);

       return count
    }

    private static int findUniqueBST(int n, int dp[])
    {
        if(n==0 || n==1)
            return 1;
        
        if(dp[n]!=-1)
            return dp[n];
        
        int i,count=0;
        for(i=1;i<=n;i++)
            count+=findUniqueBST(i-1, dp)*findUniqueBST(n-i, dp);
        
        dp[n]=count;
        
        return dp[n];
    }
	public static void main (String[] args)throws IOException
	{
		//code
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		while(t--!=0)
		{
		    int n=Integer.parseInt(br.readLine());
		    int dp[]=new int[15];
		    for(int i=0;i<dp.length;i++)
		        dp[i]=-1;
		    System.out.println(findUniqueBST(n, dp));
		}
	}
}