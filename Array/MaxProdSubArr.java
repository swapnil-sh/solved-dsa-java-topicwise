/*152. Maximum Product Subarray - Leetcode Java Solution*/

/*
----------------------Optimal----------------------------------------------
TC - O(n)
SC - O(1)
*/

class MaxProdSubArr
{
    public int maxProduct(int[] a)
    {
        int n=a.length;

        
        if(n==1)
            return a[0];
            
        int i,temp=0,flag=0;
        int ans=a[0];
        int max_end_at_i=a[0];
        int min_end_at_i=a[0];
        
        for(i=1;i<n;i++)
        {
            if(a[i]==0)
            {
                max_end_at_i=1;
                min_end_at_i=1;
                flag=1;
                continue;
            }
            
            temp=max_end_at_i;
            max_end_at_i=Math.max(a[i], temp*a[i]);
            max_end_at_i=Math.max(max_end_at_i, min_end_at_i*a[i]);
            
            min_end_at_i=Math.min(a[i], min_end_at_i*a[i]);
            min_end_at_i=Math.min(min_end_at_i, temp*a[i]);
            
            System.out.println(max_end_at_i + " " + min_end_at_i);
            
            if(ans<max_end_at_i)
                ans=max_end_at_i;
        }
      
        if(flag==1 && ans<0)
            return 0;
        
        return ans;
    }
}