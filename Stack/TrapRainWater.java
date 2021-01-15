/*42. Trapping Rain Water - Leetcode Java Solutions*/


/*
----------------------Brute Force Solution------------------------------

TC - O(n^2)
SC - O(n)

*/
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