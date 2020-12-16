/* Find Missing And Repeating  - GeeksforGeeks 5 Approaches Java Solution*/

//---------------------------------1.XOR Operator Approach---------------------------------

/*
See algo on GFG
TC = O(n)
*/
class FindMissAndRepeat
{
    int[] findTwoElement(int arr[], int n)
    {
        // code here
        int res[]=new int[n];
        int xor1; 
        int set_bit_no; 
  
        int i; 
        int x=0; 
        int y=0; 
  
        xor1 = arr[0]; 
  
        for (i=1;i<n;i++) 
            xor1=xor1^arr[i]; 
  
        
        for(i=1;i<=n;i++) 
            xor1=xor1^i; 
  
        
        set_bit_no = xor1 & ~(xor1 - 1); 
  
        
        for(i=0;i<n;i++) 
        { 
            if ((arr[i] & set_bit_no) != 0)
                x=x^arr[i]; 
            else
                y=y^arr[i]; 
        } 
        
        for(i=1; i <= n; i++) 
        { 
            if ((i & set_bit_no) != 0) 
                x=x^i; 
            else
                y=y^i; 
        }
        
        int x_count = 0;
        for (i=0;i<n;i++)
        {
            if (arr[i]==x)
                x_count++;
        }
        
        if (x_count==0)
        {
            res[0]=y;
            res[1]=x;
        }
        else
        {
            res[0]=x;
            res[1]=y; 
        }
        
        return res;
    }
}

/*--------------------------2.Using Negation Technique of Hashing-------------------------------

Use elements as index and mark visited as negative (if input is positive) 
Time Complexity: O(n)
Space Complexity: O(1)

*/

/*
class Solve 
{
    int[] findTwoElement(int a[], int n)
    {
        // code here
        int res[]=new int[n];
        int i;
        int x=0,y=0;
    
        for (i=0;i<n;i++) 
        { 
            if (a[Math.abs(a[i]) - 1]>0) 
                a[Math.abs(a[i]) - 1] = -a[Math.abs(a[i]) - 1]; 
            else 
                x=Math.abs(a[i]);
            
        }
        
        for (i=0;i<n;i++)
        { 
            if(a[i]>0) 
            {
                y=i+1;
                break;
            }
        } 
        
        res[0]=x;
        res[1]=y;
        return res;
    }
}
*/



/*----------------3.Mathematical Approach------------------------

Steps:

    Let x be the missing and y be the repeating element.
    Let N is the size of array.
    Get the sum of all numbers using formula S = N(N+1)/2
    Get product of all numbers using formula Sum_Sq = N(N+1)(2N+1)/6
    Iterate through a loop from i=1….N
    S -= A[i]
    Sum_Sq -= (A[i]*A[i])
    It will give two equations

    x-y = S – (1)
    x^2 – y^2 = Sum_sq
    x+ y = (Sum_sq/S) – (2)

Time Complexity: O(n)
*/

/*
class Solve 
{
    int[] findTwoElement(int a[], int n)
    {
        // code here
        int res[]=new int[n];
        int i,x=0,y=0;
        
        long S=(long)(n*(n+1))/2;
        long S_sq=(long)(n*(n+1)*((2*n)+1))/6;
        
        
        for(i=0;i<n;i++)
        {
            S=S-(long)a[i];
            S_sq=S_sq-(long)(a[i]*a[i]);
        }
        
        x = (int)(S + S_sq/S)/(long)2; 
        y = x-(int)S; 
        
        res[0]=y;
        res[1]=x;
        
        return res;
    }
}
*/




/*----------------4.Use Hashing--------------------

Create a freq/count array and store the count of each elements at their respective index in count array and then find repeating and missing

TC = O(n)+O(n) = O(2n)
SC = O(n)

*/

/*
class Solve 
{
    int[] findTwoElement(int a[], int n)
    {
        // code here
        int res[]=new int[n];
        int countArr[]=new int[n+1];
        int i;
        
        for(i=0;i<n;i++)
            countArr[a[i]]++;
        
        for(i=1;i<=n;i++)
        {
            if(countArr[i]>1)
                res[0]=i;
            
            if(countArr[i]==0)
                res[1]=i;
        }
        

        return res;
    }
}

*/

/*----------------5.Brute Force Approach--------------------

Sort the array and then search for repeated and missing elements

TC = O(nlogn)
SC = O(1)

*/

/*class Solve 
{
    int[] findTwoElement(int a[], int n)
    {
        
        Arrays.sort(a);
       
        int i,flag1=0;
        
        int res[]=new int[2];
        
        for(i=0;i<n-1;i++)
        {
            if((i+1)!=a[i])
            {
                flag1=1;
            }
            if(a[i]==a[i+1])
            {
                res[0]=a[i];
                break;
            }
        }
        
        int j;
        if(flag1==0)
        {
            for(j=i+1;j<n;j++)
            {
                if(j!=a[j])
                {
                    res[1]=j;
                    break;
                }
            }
        }
        else if(flag1==1)
        {
            for(j=0;j<=i;j++)
            {
                if((j+1)!=a[j])
                {
                    res[1]=j+1;
                    break;
                }
            }
        }
        
        if(res[1]==0)
            res[1]=n;

        return res;
    }
}*/



/*
Swap Sort Sudo Code

TC - O(n) (can run more than n times in some cases)
SC - O(1)

int i=0;
while(i<n)
{
   if(a[i]!=a[a[i]-1])
      swap(a[i],a[a[i]-1]);
   else
      i++;
}

for(i=0;i<n;i++)
{
    if(a[i]!=i+1)
    {
	i+1----------> missing number
	a[i]---------> duplicate number
    }
}

*/