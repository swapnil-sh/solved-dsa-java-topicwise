//Trapping Rain Water problem - GeeksforGeeks

#include<iostream>
#include<bits/stdc++.h>
using namespace std;


int trapRainWater(int a[],int n)
{
    int i,totalunitofwater = 0;
    int LGE[n];
    int RGE[n];
    
    LGE[0] = a[0];
    int maxL = a[0];
    for(i=1;i<n;i++)
    {
        if(a[i]>maxL)
            maxL = a[i];
        LGE[i] = maxL;
    }
    
    // for(i=0;i<n;i++)
    //     cout<<LGE[i]<<" ";
    RGE[n-1] = a[n-1];
    int maxR = a[n-1];
    for(i=n-2;i>=0;i--)
    {
        if(a[i]>maxR)
            maxR = a[i];
        RGE[i] = maxR;
    }
    
    // for(i=0;i<n;i++)
    //     cout<<RGE[i]<<" ";
    int water[n];
    for(i=0;i<n;i++)
    {
        water[i] = min(LGE[i],RGE[i]) - a[i];
    }
    
    for(i=0;i<n;i++)
        totalunitofwater = totalunitofwater + water[i];
    
    return totalunitofwater; 
    
}
int main() 
{
	//code
	int t;
	cin>>t;
	while(t--)
	{
	    int n,i;
	    cin>>n;
	    int a[n];
	    for(i=0;i<n;i++)
	        cin>>a[i];
	    
	    cout<<trapRainWater(a,n)<<endl;
	}
	return 0;
}
