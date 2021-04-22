/* Longest Common Substring - GeeksforGeeks Java Solutions*/
/*Longest Common Subsequence Pattern - DP*/

/*
---------------------------------Tabulation------------------------

TC - O(n^2)
SC - O(n^2)
*/


class LonComSubstring
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
            }
        }
        
        int res=Integer.MIN_VALUE;
        
        for(i=0;i<n+1;i++)
        {
            for(j=0;j<m+1;j++)
            {
                if(res<=dp[i][j])
                    res=dp[i][j];
            }
        }
        
        return res;
    }
    
    int longestCommonSubstr(String s1, String s2, int n, int m)
    {
        // code here
        return solve(s1, s2, n, m);
    }
}

/*
--------------------------------- Memoization------------------------

TC - O(n^2)
SC - O(n^2)
*/
/*
class Solution
{
    int solve(String s1, String s2, int n, int m, int count, HashMap<String, Integer> hm)
    {
        if(n==0 || m==0)
            return count;
        
        String key=n+"i"+m+"j"+count;
        
        if(hm.containsKey(key))
            return hm.get(key);
        
        int same=count;
        if(s1.charAt(n-1)==s2.charAt(m-1))
            same=solve(s1, s2, n-1, m-1, count+1, hm);

        int diff1 = solve(s1, s2, n, m-1, 0, hm);
        int diff2 = solve(s1, s2, n-1, m, 0, hm);
        int res = Math.max(same, Math.max(diff1, diff2));
        
        hm.put(key, res);
        return res;
    }
    
    int longestCommonSubstr(String s1, String s2, int n, int m)
    {
        // code here
        
        HashMap<String, Integer> hm=new HashMap<>();
        return solve(s1, s2, n, m, 0, hm);
    }
}
*/

/*
---------------------------------Brute Force Recursion------------------------

TC - O(3^n)
SC - O(3^n)
*/

/*
class Solution
{   
    int solve(String s1, String s2, int n, int m, int res)
    {
        if(n==0 || m==0)
            return res;
        
        if(s1.charAt(n-1)==s2.charAt(m-1))
            res=solve(s1, s2, n-1, m-1, res+1);
        else
            res=Math.max(res, Math.max(solve(s1, s2, n, m-1, 0),solve(s1, s2, n-1, m, 0)));
            
        return res;
    }
    
    int longestCommonSubstr(String s1, String s2, int n, int m)
    {
        // code here
        
        return solve(s1, s2, n, m, 0);
    }
}
*/