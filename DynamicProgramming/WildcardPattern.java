/*Wildcard Pattern Matching - GeeksforGeeks Java Solution*/


import java.util.*;
class WildcardPattern
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String pat = sc.nextLine();
			String text = sc.nextLine();
			GfG g = new GfG();
			System.out.println(g.wildCard(pat,text));
			t--;
		}
	}
}// } Driver Code Ends


class GfG
{
    int dp[][]=new int[1001][1001];
    
    int solve(String p, String s, int i, int j)
    {
        if(i==-1 && j==-1)
            return 1;
        
        if(j==-1)
        {
            int k;
            for(k=0;k<i;k++)
            {
                if(p.charAt(k)!='*')
                    return 0;
            }
            return 1;
        }
        
        if(i==-1)
            return 0;
        
        if(dp[i][j]!=-1)
            return dp[i][j];
        
        if(p.charAt(i)==s.charAt(j) || p.charAt(i)=='?')
        {
            dp[i][j]=solve(p,s,i-1,j-1);
            return dp[i][j];
        }
        
        if(p.charAt(i)=='*')
        {
            int op1=solve(p,s,i-1,j);
            int op2=solve(p,s,i,j-1);
            
            if(op1==1 || op2==1)
                return dp[i][j]=1;
      
        }
        return dp[i][j]=0;
    }
    
    int wildCard(String p, String s)
    {
        for(int[] row: dp)
            Arrays.fill(row, -1);
            
        return solve(p, s, p.length()-1, s.length()-1);
    }
}
