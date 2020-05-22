NAIVE APPROACH

class Solution {
    public void rotate(int[] a, int k) {
        
        int i,t=0,j,n=0;
        n = a.length;
        for(i=0;i<k;i++)
        {
            t = a[n-1];
            for(j=n-1;j>0;j--)
            {
                a[j] = a[j-1];
            }
            a[j] = t;
        }
        
        for(i=0;i<n;i++)
            System.out.println(a[i]);
    }
}



--------------------------------------------------------------------------------------

REVERSAL APPROACH

class Solution {
    public void rotate(int[] a, int k) {
        
        int n = a.length;
        k = k%n;
        reverseArray(a,0,n-1);
        reverseArray(a,0,k-1);
        reverseArray(a,k,n-1);
        
        for(int i=0;i<n;i++)
            System.out.println(a[i]);
    }
    
    public void reverseArray(int a[],int st,int end){
        
        int t = 0;
        while(st<end){
            
            t = a[st];
            a[st] = a[end];
            a[end] = t;
            
            st++;
            end--;
        }
    }
    
}


------------------------------------------------------------------------------------------
