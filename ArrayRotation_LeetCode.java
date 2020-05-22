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

