#include <stdio.h>
#include<iostream>
#include <stdlib.h> // for abs()
#include <limits.h> // for INT_MAX
using namespace std;

long long minDist(long long arr[], long long n, long long x, long long y);

int main() 
{
	long long t;
	cin>>t;
	while(t--){
		long long n;
		cin>>n;
		long long a[n];
		for(long long i=0;i<n;i++)
			cin>>a[i];
		long long x,y;
		cin>>x>>y;
		cout<<minDist(a,n,x,y)<<endl;
	}
    return 0;
}

long long minDist(long long a[], long long n, long long x, long long y)
{  
    //add code here.

    long long i,mindist=INT_MAX,i1=0,i2=0,dist=-1,f1=0,f2=0;
    
    if(x==y)
        return 0;
    
    for(i=0;i<n;i++)
    {
        if(a[i]==x)
        {
            i1=i;
            f1=1;
        }
            
        if(a[i]==y)
        {
            i2=i;
            f2=1;
        }
        
        if(f1==1  && f2==1)
        {
            
            dist = abs(i1-i2);
            
            if(dist<mindist)
                mindist=dist;
        }
        
    }
    
    if(f1==0 || f2==0)
        return -1;
    else
        return mindist;
}
