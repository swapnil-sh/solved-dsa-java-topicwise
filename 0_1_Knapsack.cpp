
#include <iostream>
using namespace std;


int max(int a,int b)
{
    if(a>=b)
        return a;
    else
        return b;
}

int recurKnapsack(int wt[],int val[],int w,int n)
{
    if(n==0 || w==0)
        return 0;
    
    if(wt[n-1]<=w)
        return max(val[n-1]+recurKnapsack(wt,val,w-wt[n-1],n-1), recurKnapsack(wt,val,w,n-1));
        
    else if(wt[n-1]>w)
        return recurKnapsack(wt,val,w,n-1);
}


int main()
{
	//code
	int t;
	cin>>t;
	while(t--)
	{
	    int n,w,i;
	    cin>>n>>w;
	    int val[n];
	    int wt[n];
	    
	    for(i=0;i<n;i++)
	        cin>>val[i];
	        
	    for(i=0;i<n;i++)
	        cin>>wt[i];
	        
	    cout<<recurKnapsack(wt,val,w,n)<<"\n";
	   
	    
	}
	return 0;
}
