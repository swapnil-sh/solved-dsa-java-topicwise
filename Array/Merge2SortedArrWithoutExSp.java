/*Merge two Sorted Arrays without using extra space - GeeksforGeeks Java Solution*/


//--------------------------Gap Method (Shell Sort Concept)----------------------------
/*
The idea: We start comparing elements that are far from each other rather than adjacent. 
For every pass, we calculate the gap and compare the elements towards the right of the gap. Every pass, the gap reduces to the ceiling value of dividing by 2.

Time Complexity: O((n+m)*log(n+m))
Auxiliary Space: O(1)

*/

class Merge2SortedArrWithoutExSp
{
    int nextGap(int gap)
    {
        if(gap<=1)
            return 0;
        
        return gap/2+gap%2;
    }
    public void merge(int a[], int b[], int n, int m) 
    {
        // code here
        int gap=n+m;
        int i,j,temp=0;
        gap=nextGap(gap);
        
        while(gap>0)
        {
            for(i=0;i+gap<n;i++)
            {
                if(a[i]>a[i+gap])
                {
                    temp=a[i];
                    a[i]=a[i+gap];
                    a[i+gap]=temp;
                }
            }
            
            for (j=gap>n?gap-n:0;i<n && j<m;i++,j++)
            {
                if(a[i]>b[j])
                {
                    temp=a[i];
                    a[i]=b[j];
                    b[j]=temp;
                    
                }
                
            }
            
            if(j<m)
            {
                for (j = 0; j + gap < m; j++)
                {
                    if (b[j]>b[j+gap]) 
                    {
                        temp=b[j];
                        b[j]=b[j+gap];
                        b[j+gap]=temp;
                    }
                }
            }
            
            gap=nextGap(gap);
        }
        
    }
}




//----------------------------Solution without using any extra space - 1---------------------------

/*
TC = O(nlogn)+O(mlogm)+O(n)
SC = O(1)
*/

class Solution 
{
    public void merge(int a[], int b[], int n, int m) 
    {
        // code here
        int i=n-1,j=0;
        while(i>=0 && j<m)
        {
            if(a[i]>b[j])
            {
                int temp=a[i];
                a[i]=b[j];
                b[j]=temp;
            }
            
            i--;
            j++;
        }
        Arrays.sort(a);
        Arrays.sort(b);
                
    }
}

//----------------------------Solution without using any extra space - 2---------------------------
/*
TC = O(n*m)
SC = O(1)
*/

/*
class Solution 
{
    
    
    public void merge(int a[], int b[], int n, int m) 
    {
        // code here
        int i=0,j=0,temp=0;
        
        while(i<n && j<m)
        {
            if(a[i]>b[j])
            {
                temp=a[i];
                a[i]=b[j];
                b[j]=temp;
                
                for(int k=0;k<m-1;k++)
                {
                    if(b[k]>b[k+1])
                    {
                        temp=b[k];
                        b[k]=b[k+1];
                        b[k+1]=temp;
                    }
                }
                
            }
            
            i++;
        }
        
    }
}
*/

/*-------------------Using Extra Space-----------------------------------

TC - O(nlogn)+O(n)+O(n)
SC - O9=(n)

/*
class Solution 
{

    public void merge(int a[], int b[], int n, int m) 
    {
        // code here
        int x[]=new int[n+m];
        int i;
        
        for(i=0;i<n;i++)
            x[i]=a[i];
        
        int j=i;
        for(i=0;i<m;i++)
            x[j++]=b[i];
            
        Arrays.sort(x);
        
        for(i=0;i<n;i++)
            a[i]=x[i];
        
        j=i;
        for(i=0;i<m;i++)
            b[i]=x[j++];
        
        
    }
}
*/