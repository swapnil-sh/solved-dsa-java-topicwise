/*  Minimum Deletions to Make a String Palindrome - GeeksforGeeks Java Solution*/
/*Longest Common Subsequence - Dynamic Programming (Reverse original string and find LCS and subtract it with orig string length)*/

/*
----------------LCS Tabulation-----------------
TC - O(n^2)
SC - O(n^2)
*/

class MinDeletionstoMakePalin
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
    
    static int minimumNumberOfDeletions(String s)
    {
        //your code here
        int n=s.length();
        
        if(n<=1)
            return n;
        
        char cArr[]=s.toCharArray();
        int i=0,j=s.length()-1;
        
        
        while(i<j)
        {
            char ch=cArr[i];
            cArr[i]=cArr[j];
            cArr[j]=ch;
            
            i++;
            j--;
        }
        
        String revS=new String(cArr);
        
        int res=lcs(s, revS, n, n);
        
        return n-res;
    }
}