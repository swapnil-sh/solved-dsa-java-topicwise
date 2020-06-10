#include<iostream>
#include<bits/stdc++.h>
using namespace std;


bool subsetSum(int a[],int sum,int n)
{

        
    if(sum==0)
        return d[n-1][w-1];
    if(n==0 && sum!=0)
        return false;
    if(a[n-1]>sum)
        return subsetSum(a,sum,n-1);        
    else
        return (subsetSum(a,sum-a[n-1],n-1) || subsetSum(a,sum,n-1));
    
}
int main() {
	//code
	int t;
	cin>>t;
	while(t--)
	{
	    int n,sum;
	    cin>>n>>sum;
	    int a[n];
	    
	    for(int i=0;i<n;i++)
	        cin>>a[i];
	   
       bool x = subsetSum(a,sum,n);
       if(x==1)
            cout<<"YES"<<"\n";
       else
            cout<<"NO"<<"\n";     
	    
	}
	return 0;
}
