/* 516. Longest Palindromic Subsequence - Leetcode Java Solution*/
/*Longest Common Subsequence - Dynamic Programming (Reverse original string and find LCS*/

/*
----------------LCS Tabulation-----------------
TC - O(n^2)
SC - O(n^2)
*/

class LongCommPalinSubseq
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
    public int longestPalindromeSubseq(String s)
    {
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
        
        return res;
        
    }
}


/*
----------------LCS Memoization-----------------
TC - O(n^2)
SC - O(n^2)
*/

/*
int dp[100][100]={0};
//Recursion with memoization (top_down) with two strings
int longest(string s1,string s2,int i,int j){
	if(i==s1.length() or j==s2.length()){
		return 0;
	}
	if(dp[i][j]!=0){
		return dp[i][j];
	}
	if(s1[i]==s2[j]){
		return dp[i][j]=1+longest(s1,s2,i+1,j+1);
	}
	return dp[i][j]=max(longest(s1,s2,i+1,j),longest(s1,s2,i,j+1));
}
int longestPalindromeSubseq(string s){
	string s1;
	s1=s;
	reverse(s1.begin(),s1.end());
	return longest(s,s1,0,0);
}
*/