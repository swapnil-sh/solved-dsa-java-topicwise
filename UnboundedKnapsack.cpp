#include <iostream>
#include<bits/stdc++.h>
using namespace std;


int max(int a,int b)
{
    if(a>=b)
        return a;
    else
        return b;
}

int main() 
{
	//code
	int t;
	cin>>t;
	while(t--)
	{
	    int n,w,i,j;
	    cin>>n>>w;
	    int val[n];
	    int wt[n];
	    
	    for(i=0;i<n;i++)
	        cin>>val[i];
	        
	    for(i=0;i<n;i++)
	        cin>>wt[i];
	        
	    int dp[n+1][w+1];
	    
	    for(i=0;i<n+1;i++)
	    {
	        for(j=0;j<w+1;j++)
	            if(i==0 || j==0)
	                dp[i][j] = 0;
	    }
	    
	    for(i=1;i<n+1;i++)
	    {
	        for(j=1;j<w+1;j++)
	        {
	            if(wt[i-1]>j)
	                dp[i][j] = dp[i-1][j];
	           else
	                dp[i][j] = max(val[i-1]+dp[i][j-wt[i-1]],dp[i-1][j]);
	        }
	    }
	    
	      cout<<dp[n][w]<<"\n";
	}
	    
	    
	return 0;
}
