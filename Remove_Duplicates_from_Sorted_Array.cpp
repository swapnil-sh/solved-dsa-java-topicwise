#include <iostream>
using namespace std;

int removeDuplicates(int a[],int n) 
{
        int i=0,j=1; //using two pointer approach

        if (n==0 || n==1) 
        return n; 
        
        for(j=1;j<n;j++)
        {
            if(a[j] != a[i])
            {
                i++;
                a[i] = a[j];
            }
        }
        return i+1;
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
        
        n = removeDuplicates(a,n);

        for(int i=0;i<n;i++)
            cout<<a[i]<<" ";

        cout<<"\n";
    }
    return 0;
}

