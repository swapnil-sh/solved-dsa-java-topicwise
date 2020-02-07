#include<bits/stdc++.h>
using namespace std;

bool isSubSequence(vector<int> s1,vector<int> s2, int m, int n)
{
   
    if (m == 0) return true;
    if (n == 0) return false;
 
   
    if (s1[m-1] == s2[n-1])
        return isSubSequence(s1, s2, m-1, n-1);
 
  
    return isSubSequence(s1, s2, m, n-1);
}

vector<int> find3Numbers(vector<int> , int );

int main()
{
	int t;
	cin>>t;
	while(t--)
	{
		int n;
		cin>>n;
		vector<int> a(n+1);
		for(int i=0;i<n;i++)
		cin>>a[i];
		
		  vector<int> res = find3Numbers(a, n);
    
    	 
    	  
    	  if(res.size()==0)
    	  {
    	  	cout<<0<<endl;
    	  }
    	  else if(res[0]<res[1] and res[1]<res[2])
          cout<<isSubSequence(res,a,res.size(),n)<<endl;
          else
          cout<<0<<endl;
	}
    
  
    return 0;
}

/*The function returns a vector containing the 
increasing sub-sequence of length 3 if present
else returns an empty vector */


vector<int> find3Numbers(vector<int> a, int n)
{
   //Your code here
   
   int i=0,max=INT_MAX,min=INT_MAX,flag=0,j;
   vector<int> v;
   
    for(i=0;i<n;i++)
    {
        if(a[i]<=min)
            min = a[i];
        else if(a[i]<=max)
            max = a[i];
        else
            break;
    }
   
    if(i==n)
        return v;
    
    for(j=0;j<i;j++)
    {
        if(a[j]<=max)
        {
            min = a[j];
            break;
        }
    }
   
   v.push_back(min);
   v.push_back(max);
   v.push_back(a[i]);
   
   return v;
   
            
}


