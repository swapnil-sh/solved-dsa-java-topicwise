/* Matrix Chain Multiplication - GeeksforGeeks Java Solutions*/
/*Type - MCM (Choosing values of i and j and looping pver them with k)*/


/*
------------------------Memoization Solution-----------------------------------

TC-O(n^2)
SC-O(n^2)
*/

class MatChainMult
{
    static int dp[][];
    static int solve(int a[], int i, int j)
    {
        
        if(i>=j)
            return 0;
        
        if(dp[i][j]!=-1)
            return dp[i][j];
            
        int res=Integer.MAX_VALUE;
        for(int k=i;k<=j-1;k++)
        {
            int temp=solve(a, i, k)+solve(a, k+1, j)+a[i-1]*a[k]*a[j];
            res=Math.min(temp, res);
        }
        
        return dp[i][j]=res;
    }
    static int matrixMultiplication(int n, int a[])
    {
        // code here
        dp=new int[n][n];
        for(int row[]: dp)
            Arrays.fill(row, -1);
            
        return solve(a, 1, n-1);
        
    }
}

/*
------------------------Recursive Solution-----------------------------------
*/
/*
class Solution
{
    static int solve(int a[], int i, int j)
    {
        
        if(i>=j)
            return 0;
            
        int res=Integer.MAX_VALUE;
        for(int k=i;k<=j-1;k++)
        {
            int temp=solve(a, i, k)+solve(a, k+1, j)+a[i-1]*a[k]*a[j];
            res=Math.min(temp, res);
        }
        
        return res;
    }
    static int matrixMultiplication(int n, int a[])
    {
        // code here

        return solve(a, 1, n-1);
        
    }
}
*/
