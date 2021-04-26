/* Minimum number of deletions and insertions - GeeksforGeeks Java Solution*/
/*Longest Common Subsequence - Dynamic Programming*/

class MinInsDel
{
    int dp[][];
    int lcs(String s1, String s2, int n, int m)
    {
        if(n==0 || m==0)
            return 0;
        
        dp=new int[n+1][m+1];
        int i,j;
        for(i=0;i<n+1;i++)
        {
            for(j=0;j<m+1;j++)
            {
                if(i==0 || j==0)
                    dp[i][j]=0;
                    
                else if(s1.charAt(i-1)==s2.charAt(j-1))
                    dp[i][j]=1+dp[i-1][j-1];
                else
                    dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        
        return dp[n][m];
    }
	public int minOperations(String s1, String s2) 
	{ 
	    // Your code goes here
	    
	    int lcsLen=lcs(s1, s2, s1.length(), s2.length());
	    int del=s1.length()-lcsLen;
	    int ins=s2.length()-lcsLen;
	    
	    return del+ins;
	    
	} 
}