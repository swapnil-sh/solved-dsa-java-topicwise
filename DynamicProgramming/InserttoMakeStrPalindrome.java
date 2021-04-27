/*  Form a palindrome  - GeeksforGeeks Java Solution*/
/*Longest Common Subsequence - Dynamic Programming (Reverse original string and find LCS and subtract with length of orig str)*/

/*
----------------LCS Tabulation-----------------
TC - O(n^2)
SC - O(n^2)
*/

class InserttoMakeStrPalindrome
{
    
    static int dp[][];
    static int lcs(String s1, String s2, int n, int m)
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
    static int countMin(String s)
    {
        // code here
        StringBuffer sb = new StringBuffer(s);
        sb.reverse();
        String revString = sb.toString();
        int n=s.length();
  
        return (n - lcs(s, revString , n, n));

    }
}