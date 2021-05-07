/*583. Delete Operation for Two Strings - Leetcode Java Solution*/
/*Longest Common Subsequence Pattern*/

/*
Given two strings word1 and word2, return the minimum number of steps required to make word1 and word2 the same.

In one step, you can delete exactly one character in either string.

Example 1:

Input: word1 = "sea", word2 = "eat"
Output: 2
Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea"
*/

/*
----------------------Tabulation LCS----------------------------
TC - O(n^2)
SC - O(n^2)
*/
class MakeS1ToS2Min
{
    int solve(String s1, String s2, int n, int m)
    {
        if(n==0 || m==0)
            return 0;
        
        int i,j;
        int dp[][]=new int[n+1][m+1];
        
        for(i=0;i<n+1;i++)
        {
            for(j=0;j<m+1;j++)
            {
                if(i==0 || j==0)
                    dp[i][j]=0;
            }
        }
        
        for(i=1;i<n+1;i++)
        {
            for(j=1;j<m+1;j++)
            {
                if(s1.charAt(i-1)==s2.charAt(j-1))
                    dp[i][j]=1+dp[i-1][j-1];
                else
                    dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        return n+m-2*dp[n][m];
    }
    
    public int minDistance(String s1, String s2)
    {
        int lcs=solve(s1,s2,s1.length(),s2.length());
        
        return lcs;
    }
}