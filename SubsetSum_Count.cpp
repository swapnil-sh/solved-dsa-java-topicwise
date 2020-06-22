#include <bits/stdc++.h>
using namespace std;

int subsetSumCount(int a[],int n,int sum)
{
    int dp[n+1][sum+1];
    int i,j;
        
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
            else
            {
                dp[i][j] = dp[i-1][j-a[i-1]] + dp[i-1][j];
            }
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
    
    int n,sum; 
    cin>>n;
    int a[n];
    for(int i=0;i<n;i++)
        cin>>a[i];
    
    cin>>sum;
  
    cout<<subsetSumCount(a,n,sum)<<"\n"; 
      
  }
	return 0;
}
