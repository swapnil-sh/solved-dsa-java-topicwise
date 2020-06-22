#include <bits/stdc++.h>
using namespace std;

long long minimumSumPartition(long long a[],long long n,long long sum)
{
    bool dp[n+1][sum+1];
    int i,j,diff=0;
    for(i=0;i<n+1;i++)
    {
        for(j=0;j<sum+1;j++)
        {
            if(i==0)
                dp[i][j] = false;
            if(j==0)
                dp[i][j] = true;   
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
                dp[i][j] = dp[i-1][j-a[i-1]] || dp[i-1][j];
            }
        }
    }
  
  
    for(i=(sum+1)/2;i>=0;i--)
    {
        if(dp[n][i] == true)
        {
            diff = abs(sum-(2*i));
            break;
        }
         
    }

    return diff;
}

int main() 
{

  long long t;
  cin>>t;
  while(t--)
  {
    
    long long n,sum=0,i; 
    cin>>n;
    long long a[n];
    for(i=0;i<n;i++)
        cin>>a[i];

    for(i=0;i<n;i++)
        sum = sum+a[i];
        
    cout<<minimumSumPartition(a,n,sum)<<"\n"; 
      
  }
	return 0;
}
