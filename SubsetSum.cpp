RECURSIVE METHOD

#include<iostream>
#include<bits/stdc++.h>
using namespace std;


bool subsetSum(int a[],int sum,int n)
{

        
    if(sum==0)
        return d[n-1][w-1];
    if(n==0 && sum!=0)
        return false;
    if(a[n-1]>sum)
        return subsetSum(a,sum,n-1);        
    else
        return (subsetSum(a,sum-a[n-1],n-1) || subsetSum(a,sum,n-1));
    
}
int main() 
{
	//code
	int t;
	cin>>t;
	while(t--)
	{
	    int n,sum;
	    cin>>n>>sum;
	    int a[n];
	    
	    for(int i=0;i<n;i++)
	        cin>>a[i];
	   
       bool x = subsetSum(a,sum,n);
       if(x==1)
            cout<<"YES"<<"\n";
       else
            cout<<"NO"<<"\n";     
	    
	}
	return 0;
}

-------------------------------------------------------------------------------------------------------------------

TABULATION METHOD


#include<iostream>
#include<bits/stdc++.h>
using namespace std;


bool subsetSumtab(int a[],int sum,int n)
{

    bool dp[n+1][sum+1];
    int i,j;
    for(i=0;i<n+1;i++)
    {
        for(j=0;j<sum+1;j++)
        {
            if(i==0)
                dp[i][j] = false;
            if(j==0)
                dp[i][j] = true;   
        }
    }

    for(i=1;i<n+1;i++)
    {
        for(j=1;j<sum+1;j++)
        {
            if(a[i-1]>j)
                dp[i][j] = dp[i-1][j];
            else
            {
                dp[i][j] = dp[i-1][j-a[i-1]] || dp[i-1][j];
            }
        }
    }

     for ( i = 0; i <= n; i++) 
     { 
       for ( j = 0; j <= sum; j++) 
          printf ("%4d", dp[i][j]); 
       printf("\n");
     } 

    return dp[n][sum];
}


int main()
 {
	//code
	int t;
	cin>>t;
	while(t--)
	{
	    int n,sum;
	    cin>>n>>sum;
	    int a[n];
	    
	    for(int i=0;i<n;i++)
	        cin>>a[i];
	   
       bool x = subsetSumtab(a,sum,n);
       if(x==1)
            cout<<"YES"<<"\n";
       else
            cout<<"NO"<<"\n";     
	    
	}
	return 0;
}


----------------------------------------------------------------------------------------------------------------------

Input - 

3
5
11
2 3 7 8 10
6
9
3 34 4 12 5 2
6
30
3 34 4 12 5 2


OUTPUT -

   1   0   0   0   0   0   0   0   0   0   0   0
   1   0   1   0   0   0   0   0   0   0   0   0
   1   0   1   1   0   1   0   0   0   0   0   0
   1   0   1   1   0   1   0   1   0   1   1   0
   1   0   1   1   0   1   0   1   1   1   1   1
   1   0   1   1   0   1   0   1   1   1   1   1
YES

   1   0   0   0   0   0   0   0   0   0
   1   0   0   1   0   0   0   0   0   0
   1   0   0   1   0   0   0   0   0   0
   1   0   0   1   1   0   0   1   0   0
   1   0   0   1   1   0   0   1   0   0
   1   0   0   1   1   1   0   1   1   1
   1   0   1   1   1   1   1   1   1   1
YES

1   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0
1   0   0   1   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0
1   0   0   1   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0
1   0   0   1   1   0   0   1   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0
1   0   0   1   1   0   0   1   0   0   0   0   1   0   0   1   1   0   0   1   0   0   0   0   0   0   0   0   0   0   0
1   0   0   1   1   1   0   1   1   1   0   0   1   0   0   1   1   1   0   1   1   1   0   0   1   0   0   0   0   0   0
1   0   1   1   1   1   1   1   1   1   1   1   1   0   1   1   1   1   1   1   1   1   1   1   1   0   1   0   0   0   0
NO


