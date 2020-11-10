/*121. Best Time to Buy and Sell Stock(Only one transaction allowed) - Leetcode Java Solution*/


/*
Time complexity : O(n)
Space complexity : O(1) 
*/

class Best_Time_to_BuySell_1
{
    public int maxProfit(int[] p)
    {
        
        int i,j;
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        
        for(i=0;i<p.length;i++)
        {
            if(p[i]<minPrice)
                minPrice=p[i];
            
            else if(p[i]-minPrice>maxProfit)
                maxProfit=p[i]-minPrice;
        }
        
        return maxProfit;
        
    }
}

/*
----------------------------Brute Force Solution----------------------

Time complexity : O(n^2)
Space complexity : O(1) 

*/

/*
class Solution
{
    public int maxProfit(int[] p)
    {
        
        int i,j;
        int maxProf=Integer.MIN_VALUE;
        
        for(i=0;i<p.length-1;i++)
        {
            for(j=i+1;j<p.length;j++)
            {
                if(p[j]-p[i]>=maxProf)
                    maxProf=p[j]-p[i];
            }
        }
        
        if(maxProf<0)
            return 0;
        return maxProf;
        
    }
}

*/