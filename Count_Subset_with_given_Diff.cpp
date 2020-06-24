#include<iostream>
#include<bits/stdc++.h>
using namespace std;

int countSubsetSum(int a[],int n,int sum)
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
                dp[i][j] = dp[i-1][j-a[i-1]] + dp[i-1][j];
        }
    }

    return dp[n][sum];
}
int countSubsetDiff(int a[],int n,int diff)
{
    int i,sum=0,s1=0;
    for(i=0;i<n;i++)
        sum=sum+a[i];

    s1 = (diff+sum)/2;

    return countSubsetSum(a,n,s1);
    
}
int main(){
    int n,diff;
    cin>>n;
    int arr[n] ;
    for(int i=0;i<n;i++)
        cin>>arr[i];

    cin>>diff;
    cout<<countSubsetDiff(arr,n,diff)<<endl;

}
