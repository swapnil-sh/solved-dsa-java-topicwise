#include <iostream>
#include <bits/stdc++.h>
using namespace std;

int firstindexofanelement(int a[],int n)
{
    int i,st=0,end=n,mid=0,pos=0;

    while(st<=end)
    {
        mid=(st+end)/2;

        if(a[mid]==0)
        {
            pos = mid;
            end = mid-1;
        }

        else if(a[mid]==1)
            st = mid+1;

        else    
            end = mid-1;
    }

    return pos;
}
int main() {
    
    int t;
    cin>>t;
    
    while(t--)
    {
    
        int n,i;
        cin>>n;
        int a[n];
        for(i=0;i<n;i++)
            cin>>a[i];
    
        int x = firstindexofanelement(a,n);
    
        cout<<n-x<<"\n";
    }

    return 0;
}

