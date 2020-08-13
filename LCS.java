//Longest Common Subsequence - GeeksforGeeks Solution JAVA

import java.util.*;
import java.lang.*;
import java.io.*;

class LCS 
{
    
    static int LCS(String s1,String s2,int l1,int l2)
    {
        int dp[][] = new int[l1+1][l2+1];
        int i,j;
        for(i=0;i<l1+1;i++)
        {
            for(j=0;j<l2+1;j++)
            {
                
                if(i==0 || j==0)
                    dp[i][j] = 0;
            }
        }
        
        for(i=1;i<l1+1;i++)
        {
            for(j=1;j<l2+1;j++)
            {
                if(s1.charAt(i-1)==s2.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        
        return dp[l1][l2];
    }
	public static void main (String[] args)throws Exception
	{
		//code
		Scanner sc = new Scanner(System.in);
		int t;
		t = sc.nextInt();
		
		while(t-->0)
		{
    		
    		int l1,l2;
    		String s1,s2;
    		
    		l1 = sc.nextInt();
		    l2 = sc.nextInt();
		    sc.nextLine();
            s1 = sc.next();
            sc.nextLine();
		    s2 = sc.next();
		    
    		
    		
    		System.out.println(LCS(s1,s2,l1,l2));
		}
	}
}
