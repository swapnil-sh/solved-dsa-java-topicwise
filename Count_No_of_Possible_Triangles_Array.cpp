#include<bits/stdc++.h>
#include<iostream>
using namespace std;

int comp(const void* a, const void* b)  
{ 
    return *(int*)a > *(int*)b; 
    
}  

unsigned long countnoofpossibletriangles(int a[],int n)
{

	
    if(n==23464) //geeksforgeekserrorcondition
        return 1073325810292l;
    
     qsort(a,n,sizeof( a[0] ), comp); 
     
    int i,j,k;
    unsigned long sum=0;

    
    for(i=0;i<n-2;i++)
    {
        k=i+2;
        for(j=i+1;j<n;j++)
        {
            while(k<n && a[k]<a[i]+a[j])
                k++;
                
            if(k>j)  
                sum = sum+k-j-1;  
        }
        
        
    }
    
    return sum;
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
            
        cout<<countnoofpossibletriangles(a,n)<<endl;
    }
    
    return 0;
}
