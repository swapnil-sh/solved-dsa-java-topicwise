#include <iostream>
#include <bits/stdc++.h>
using namespace std;

int main() {
	//code
	
	ios_base::sync_with_stdio(false); 
    cin.tie(NULL);
	int t;
	cin>>t;
	while(t--)
	{
	    int n,i,a=0,flag=0,k,j;
	    cin>>n;
	    int ar[n];
	    for(i=0;i<n;i++)
	        cin>>ar[i];
	        
	   sort(ar,ar+n);
	        
	    for(i=0;i<n;i++)
	    {
	        ar[i] = ar[i]*ar[i];
	    }
	   
	    for(i=n-1;i>=2;i--)
	    {
	        j=0,k=i-1;
	        while(j<k)
	        {
	            //cout<<"\n"<<ar[j]+ar[k]<<"\n";
	            
	            if(ar[j]+ar[k] < ar[i])
	            {
	                j++;
	            }
	            else if(ar[j]+ar[k] > ar[i])
	            {
	                k--;
	            }
	            else
	            {
	                flag=1;
	                break;
	            }
	            
	        }
	    }
	    
	    if(flag==1)
	        cout<<"Yes"<<"\n";
	    else
	        cout<<"No"<<"\n";
	    
	}
	return 0;
}
