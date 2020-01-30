#include <iostream>
#include <bits/stdc++.h>
using namespace std;

int searchFirstIndex(int a[],int n,int x)
{
    int start=0,pos=0,mid,end;
    end = n;

    if (n == 0)
	    return -1;
	        
    if(n == 1)
        return 0;

    while(start<=end)
    {
        mid = (start+end)/2;
        if(x == a[mid])
        {
            pos = mid;
            end = mid-1; 
        }

        else if(x>a[mid])
            start = mid+1;

        else
            end = mid-1;
    }

    return pos;
}

int searchLastIndex(int a[],int n,int x)
{
    int start=0,pos=0,mid,end;
    end = n;

    if (n == 0)
	    return -1;

    if(n==1)
        return 0;

    while(start<=end)
    {
        mid = (start+end)/2;
        if(x == a[mid] )
        {
            pos = mid;
            start = mid+1; 
        }

        else if(x>a[mid])
            start = mid+1;

        else
            end = mid-1;
    }

    return pos;
}
int main() 
{
    int t;
    cout<<"Enter the no of test cases : "<<endl;
    cin>>t;
    while(t--)
    {

        int n,x;
        cout<<"Enter the size of array : "<<endl;
        cin>>n;
        int a[n];
        cout<<"Enter the elements of array : "<<endl;
        for(int i=0;i<n;i++)
            cin>>a[i];
        cout<<"Enter the number that who's first and last occurence needs to be searched : "<<endl;
        cin>>x;

        cout<<"Last Occurence of the number is = "<<searchLastIndex(a,n,x)<<endl;
        cout<<"First Occurence of the number is = "<<searchFirstIndex(a,n,x)<<endl;
    }


    return 0;
}

