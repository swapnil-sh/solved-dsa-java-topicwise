#include<bits/stdc++.h>
using namespace std;

void maxNumberOfActivities(int st[],int fs[],int n)
{
    int i,j,c=1;
    pair<int, char> pairt[n]; 
  
    for (i = 0;i<n;i++)  
    { 
        pairt[i].first = fs[i]; 
        pairt[i].second = st[i]; 
    } 
  
    // Sorting the pair array. 
    sort(pairt, pairt + n); 
      
    // Modifying original arrays 
    for (int i = 0; i < n; i++)  
    { 
        fs[i] = pairt[i].first; 
        st[i] = pairt[i].second; 
    } 
    
    // for(i=0;i<n;i++)
    //     cout<<st[i]<<" ";
        
    //     cout<<"\n";
    // for(i=0;i<n;i++)
    //     cout<<fs[i]<<" ";
   
   int prev = fs[0];
   for(i=1;i<n;i++)
   {
       if(st[i]>=prev)
       {
            c++;
            prev = fs[i];
       }
   }
    
    cout<<c<<"\n";
    
}

int main() {
	
	int t;
	cin>>t;
	while(t--)
	{
	    int n,i;
	    cin>>n;
	    int st[n],fs[n];
	    
	    for(i=0;i<n;i++)
	        cin>>st[i];
	        
	    for(i=0;i<n;i++)
	        cin>>fs[i];
	   
	    maxNumberOfActivities(st,fs,n);     
	   
	}
	return 0;
}
