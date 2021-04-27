/* 392. Is Subsequence - Leetcode Java Solutions*/
/*Longest Common Subsequence - Dynamic Programming (check if len of lcs == len of string*/

/*
----------------LCS Tabulation-----------------
TC - O(n^2)
SC - O(n^2)
*/

class IsSubsequence
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
    public boolean isSubsequence(String s, String t)
    {
        int len=lcs(s,t,s.length(), t.length());
        System.out.println(len);
        if(len==s.length())
            return true;
        else
            return false;
    }
}

/*
----------------------Two Pointer Solution---------------------------
TC - O(n+m)
SC - O(1)
*/
/*
class Solution 
{
    public boolean isSubsequence(String s, String t)
    {
        int i=0,j=0;
        while(i<s.length() && j<t.length())
        {
            if(s.charAt(i)==t.charAt(j))
            {
                i++;
                j++;                
            }
            else
                j++;
        }
        
        if(i==s.length())
            return true;
        else
            return false;
    }
}
*/