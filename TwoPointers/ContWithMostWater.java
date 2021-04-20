/*11. Container With Most Water - Leetcode Java Solutions*/

/*
------------------------Two Pointers Solution-----------------------
TC - O(n)
SC - O(1)
*/

class ContWithMostWater
{
    public int maxArea(int[] a)
    {
        int i=0,j=a.length-1,res=0,ar=0;

        while(i<j) 
        {
            ar=(j-i)*(Math.min(a[i], a[j]));
            res=Math.max(ar, res);
            
            if(a[i]<=a[j])
                i++;
            else
                j--;
        }
        
        return res;
    }
}

/*
------------------------Brute Force-----------------------
TC - O(n^2)
SC - O(1)
*/
/*
class Solution 
{
    public int maxArea(int[] a)
    {
        int i,j,res=0,ar=0;

        for(i=0;i<a.length-1;i++)
        {
            for(j=i+1;j<a.length;j++)
            {
                ar=(j-i)*Math.min(a[i], a[j]);
                res=Math.max(ar, res);
            }
        }
        return res;
    }
}
*/