#include <iostream>
#include<bits/stdc++.h>
using namespace std;



void buyandsellstocks1loop(int  a[],int n)
{
    int i=0, j=1;
    bool turn = false;
    bool flag = true;
    int start, end;
    
    while(i<n-1 && j<n){
        
        if(a[i] < a[j] && flag){
            start = i;
            flag = false;
            turn = true;
        }
        else if(a[i] > a[j] && !flag){
            end = i;
            flag = true;
            cout<<"("<<start<<" "<<end<<")"<<" ";
        }
        
        i++;
        j++;
    }
    
    if(!flag && turn){
        end = i;
        cout<<"("<<start<<" "<<end<<")"<<" ";
    }
    
    if(!turn)
        cout<<"No Profit";
    cout<<"\n"
    
}

void buyandsellstocks(int a[],int n)
{

   int i=0,j=0,buy=0,sell=0,flag=0;
   
    while(i<n-1 && j<n)
    {
        if(a[i]>a[i+1])
        {
            i++;
            if(i==n-1)
                break;
            buy = i;
            flag=1;
            continue;
        }
        else
        {
            buy = i;
            flag=1;
        }
        if(buy==n-1)
            break;
        
        j=i+1;
        while(j<n-1 && a[j]<a[j+1])
            j++;
        
            sell = j;
        
        
        cout<<"("<<buy<<" "<<sell<<")"<<" ";
        
        i=j+1;
    }
    
    if(flag==0)
        cout<<"No Profit";
	    
	    cout<<"\n";

}

int main() 
{
    
    int t;
    cin>>t;
    while(t--)
    {
        int n;
        cin>>n;
        int a[n];
        for(int i=0;i<n;i++)
            cin>>a[i];
            
        buyandsellstocks(a,n);
	buyandsellstocks1loop(a,n);
        
        
    }
	return 0;
}
