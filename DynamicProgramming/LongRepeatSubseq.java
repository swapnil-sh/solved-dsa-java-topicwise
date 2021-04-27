/*   Longest Repeating Subsequence  - GeeksforGeeks Java Solution*/
/*Longest Common Subsequence - Dynamic Programming (add i!=j condition with s1.charAt(i-1)==s2.charAt(j-1))*/

/*
----------------LCS Tabulation-----------------
TC - O(n^2)
SC - O(n^2)
*/

class LongRepeatSubseq
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
                    
                else if(s1.charAt(i-1)==s2.charAt(j-1) && i!=j)
                    dp[i][j]=1+dp[i-1][j-1];
                else
                    dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        
        return dp[n][m];
    }
    public int LongestRepeatingSubsequence(String s)
    {
        // code here
        return lcs(s, s, s.length(), s.length());
    }
}