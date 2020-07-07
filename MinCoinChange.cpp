// Variation of Unbounded Knapsack and Subset problem

#include <iostream>
#include <bits/stdc++.h>
using namespace std;

int minCoinChange(int a[],int n,int sum)
{
    int dp[n+1][sum+1];
    int i,j;
    
   // memset(dp,0,sizeof(dp));
    
    for(i=0;i<n+1;i++)
    {
        for(j=0;j<sum+1;j++)
        {
            if(i==0)
                dp[i][j] = INT_MAX-1;
            if(j==0 && i!=0)
                dp[i][j] = 0;
         
        }
    }
    
    for(i=1;i<sum+1;i++)
    {
        if(i%a[0]==0)
            dp[1][i] = i/a[0];
        else
         dp[1][i] = INT_MAX-1;
    }
    
    for(i=2;i<n+1;i++)
    {
        for(j=1;j<sum+1;j++)
        {
            if(a[i-1]>j)
                dp[i][j] = dp[i-1][j];
            if(a[i-1]<=j)
                dp[i][j] = min(dp[i][j-a[i-1]]+1,dp[i-1][j]);
        }
    }
    
    if(dp[n][sum]!=INT_MAX-1)
        return dp[n][sum];
    else 
        return -1;
    
}


int main() 
{

   int t;
   cin>>t;
   while(t--)
   {
       int v,n;
       cin>>v>>n;
       int a[n];
       for(int i=0;i<n;i++)
            cin>>a[i];

      cout<<minCoinChange(a,n,v)<<"\n";
    	    
    }
	return 0;
}
