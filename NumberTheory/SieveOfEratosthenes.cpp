#include <iostream>
#include<bits/stdc++.h>
using namespace std;

bool IsPrime[900000001];
vector<int> v;
void SieveOfEratosthenes()  
{  
        int MAX_SIZE=90000000;
        int i,j;
        for(i=0;i<MAX_SIZE;i++) 
            IsPrime[i]=true; 
          
        for (i=2;i*i<MAX_SIZE;i++)  
        {  
            if (IsPrime[i] == true)  
            {  
                for (j=i*i;j<MAX_SIZE;j+=i)  
                    IsPrime[j]=false;  
            }  
        }  
        for (i=2;i<MAX_SIZE;i++)  
            if (IsPrime[i] == true)  
                v.push_back(i); 
}  
int main() 
{
        int Q;
        cin>>Q;
        SieveOfEratosthenes(); 
        while(Q!=0)
        {
            int n;
            cin>>n;
            cout<<v[n-1]<<endl; 
            Q--;

        }
    
    return 0;
}


    


