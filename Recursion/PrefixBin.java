//Print N-bit binary numbers having more 1’s than 0’s - GeeksforGeeks Java Solution using Recursion

// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class PrefixBin 
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader read =
		new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(read.readLine());
		while (t-- > 0) 
		{
		    int n = Integer.parseInt(read.readLine());
		    Solution ob = new Solution();
		    ArrayList<String> result = ob.NBitBinary(n);
		    for(String value  : result)
		        System.out.print(value + " ");
		   
		    System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution 
{
    public void solve(int one,int zero,int n,String op,ArrayList<String> list)
    {
        if(n==0)
        {
            list.add(op);
            return;
        }
        
        solve(one+1,zero,n-1,op+'1',list);

        if(one>zero) 
            solve(one,zero+1,n-1,op+'0',list);
        
        return;
    }
    ArrayList<String> NBitBinary(int N) 
    {
        // code here
        
        int one=0;
        int zero=0;
        ArrayList<String> list=new ArrayList<String>();
        String op="";
        solve(one,zero,N,op,list);
        return list;
        
    }
}
