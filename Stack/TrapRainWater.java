/*42. Trapping Rain Water - Leetcode Java Solutions*/


/*
----------------------Using PrefixMax and SuffixMax Array Solution------------------------------

TC - O(3n)
SC - O(2n)

*/
class TrapRainWater
{
    public int trap(int[] a) 
    {
        int i,j,n=a.length;
        int res=0,max=Integer.MIN_VALUE;
        int prefixMax[]=new int[n];
        int suffixMax[]=new int[n];
        
        for(i=0;i<n;i++)
        {
            if(max<a[i])
                max=a[i];
            
            prefixMax[i]=max;
        }
        
        max=Integer.MIN_VALUE;
        for(i=n-1;i>=0;i--)
        {
            if(max<a[i])
                max=a[i];
            
            suffixMax[i]=max;
        }
        
        for(i=0;i<n;i++)
            res+=Math.min(prefixMax[i], suffixMax[i])-a[i];
        
        
        return res;
        
    }
}
/*
----------------------Brute Force Solution------------------------------

TC - O(n^2)
SC - O(n)

*/
/*
class TrapRainWater
{
    public int trap(int[] h) 
    {
        int i,j,left=0,right=0,n=h.length;
        int res=0;
        
        for(i=1;i<n-1;i++)
        {
            left=h[i];
            for(j=0;j<i;j++)
                left=Math.max(left, h[j]);
            
            right=h[i];
            for(j=i+1;j<n;j++)
                right=Math.max(right, h[j]);
            
            res+=Math.min(left, right)-h[i];
        }
        
        return res;
        
    }
}
*/