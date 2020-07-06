// Variation of Unbounded Knapsack and Subset problem

#include <iostream>
#include <bits/stdc++.h>
using namespace std;

int coinChange(int a[],int n,int sum)
{
    int dp[n+1][sum+1];
    int i,j;
    
   // memset(dp,0,sizeof(dp));
    
    for(i=0;i<n+1;i++)
    {
        for(j=0;j<sum+1;j++)
        {
            if(i==0)
                dp[i][j] = 0;
            if(j==0)
                dp[i][j] = 1;
         
        }
    }
    
    for(i=1;i<n+1;i++)
    {
        for(j=1;j<sum+1;j++)
        {
            if(a[i-1]>j)
                dp[i][j] = dp[i-1][j];
            if(a[i-1]<=j)
                dp[i][j] = dp[i][j-a[i-1]]+dp[i-1][j];
        }
    }
    
    return dp[n][sum];
}


int main() 
{

   int t;
   cin>>t;
   while(t--)
   {
       int n;
       cin>>n;
       int a[n];
       for(int i=0;i<n;i++)
            cin>>a[i];
    
       int s;
       cin>>s;

    
      cout<<coinChange(a,n,s)<<"\n";
    	    
    }
	return 0;
}
