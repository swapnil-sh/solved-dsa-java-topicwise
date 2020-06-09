
#include <iostream>
using namespace std;


int max(int a,int b)
{
    if(a>=b)
        return a;
    else
        return b;
}

int recurKnapsack(int wt[],int val[],int w,int n)
{
    if(n==0 || w==0)
        return 0;
    
    if(wt[n-1]<=w)
        return max(val[n-1]+recurKnapsack(wt,val,w-wt[n-1],n-1), recurKnapsack(wt,val,w,n-1));
        
    else if(wt[n-1]>w)
        return recurKnapsack(wt,val,w,n-1);
}


int main()
{
	//code
	int t;
	cin>>t;
	while(t--)
	{
	    int n,w,i;
	    cin>>n>>w;
	    int val[n];
	    int wt[n];
	    
	    for(i=0;i<n;i++)
	        cin>>val[i];
	        
	    for(i=0;i<n;i++)
	        cin>>wt[i];
	        
	    cout<<recurKnapsack(wt,val,w,n)<<"\n";
	   
	    
	}
	return 0;
}




------------------------------------------------------------------------------------------------------------------

MEMOIZATION

#include <iostream>
#include<bits/stdc++.h>
using namespace std;

int dp[500][500];



int max(int a,int b)
{
    if(a>=b)
        return a;
    else
        return b;
}

int recurKnapsack(int wt[],int val[],int w,int n)
{
    memset(dp,-1,sizeof(dp));
    if(n==0 || w==0)
        return 0;
        
    if(dp[n][w]!=-1)
        return dp[n][w];
    
    if(wt[n-1]<=w)
    {
        dp[n][w] = max(val[n-1]+recurKnapsack(wt,val,w-wt[n-1],n-1), recurKnapsack(wt,val,w,n-1));
        return dp[n][w];
    }
    else if(wt[n-1]>w)
    {
        dp[n][w] = recurKnapsack(wt,val,w,n-1);
        return dp[n][w];
    }
}


int main()
{
	//code
	int t;
	cin>>t;
	while(t--)
	{
	    int n,w,i;
	    cin>>n>>w;
	    int val[n];
	    int wt[n];
	    
	    for(i=0;i<n;i++)
	        cin>>val[i];
	        
	    for(i=0;i<n;i++)
	        cin>>wt[i];
	        
	    cout<<recurKnapsack(wt,val,w,n)<<"\n";
	   
	    
	}
	return 0;
}

-----------------------------------------------------------------------------------------------------------------------

TABULATION


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
            for(j=0;j<w+1;j++)
                if(i==0 || j==0)
                    dp[i][j] = 0;
        
        for(i=1;i<n+1;i++)
        {
            for(j=1;j<w+1;j++)
            {
                if(wt[i-1]<=j)
                {
                    dp[i][j] = max(val[i-1]+dp[i-1][j-wt[i-1]],dp[i-1][j]);
                    
                }
                else
                {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        
    	        
	    cout<<dp[n][w]<<"\n";
	   
	    
	}
	return 0;
}
