#include <iostream>
using namespace std;

void leftsmrightgreat(int a[],int n)
{
    int i;
    
    int leftMax[n];
    int rightMin[n];
    
    int max=a[0];
    leftMax[0] = max;
    for(i=1;i<n;i++)
    {
        if(a[i]>max)
            max = a[i];
        
        leftMax[i] = max;
    }
    
    int min = a[n-1];
    rightMin[n-1] = min;
    for(i=n-2;i>=0;i--)
    {
        if(a[i]<min)
            min = a[i];
        
        rightMin[i] = min;
    }
    
    bool flag=true;
    
    for(i=1;i<n-1;i++)
    {
        if(a[i]>=leftMax[i] && a[i]<=rightMin[i])
        {
            cout<<a[i]<<"\n";
            flag = false;
            break;
        }
    }
    
    if(flag == true)
        cout<<-1<<"\n";
    
}

int main() {
    
    int t;
    cin>>t;
    while(t--)
    {
        int i,n;
        cin>>n;
        int a[n];
        
        for(i=0;i<n;i++)
            cin>>a[i];
            
        leftsmrightgreat(a,n);
    }
	//code
	return 0;
}
