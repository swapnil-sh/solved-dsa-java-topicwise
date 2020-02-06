#include <iostream>
#include<bits/stdc++.h>
using namespace std;

vector<int> arrayofLeaders(int a[],int n)
{
    int i,max=a[n-1];
    vector<int> x; 
    x.push_back(a[n-1]);
    
    for(i=n-2;i>=0;i--)
    {
        if(max<=a[i])
        {
            max=a[i];
            x.push_back(a[i]);
        }
    }
    return x;
}

int main() 
{
	
	int t;
	cin>>t;
	while(t--)
	{
	    int n,i;
	    cin>>n;
	    int a[n];
	    
	    for(i=0;i<n;i++)
	        cin>>a[i];
	   
	    vector<int> res;
	   
	    res = arrayofLeaders(a,n);
	   
        for(i=res.size()-1;i>=0;i--)
            cout<<res[i]<<" ";
	    cout<<"\n";
	}
	return 0;
}
