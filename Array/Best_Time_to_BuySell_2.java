/*122. Best Time to Buy and Sell Stock II (Multiple Transactions allowed) - Leetcode Java Solution*/

/*
------------------------Simple One Pass------------------


Time complexity : O(n)
Space complexity: O(1)

*/

class Best_Time_to_BuySell_2
{
    public int maxProfit(int[] a)
    {
        
        int i,profit=0;
        int lastMin=a[0];
        
        for(i=1;i<a.length;i++)
        {
            if(a[i]<lastMin)
                lastMin=a[i];
            
            if(a[i]-lastMin>=0)
            {
                profit+=a[i]-lastMin;
                lastMin=a[i];
            }
        }
        
        return profit;
    }
}



/*
------------------------Peak Valley Approach------------------


Time complexity : O(n)
Space complexity: O(1)

*/

/*

class Solution
{
    public int maxProfit(int[] p)
    {
        
        int i=0,profit=0;
        int buy=p[0];
        int sell=p[0];
        
        while(i<p.length-1)
        {
            while(i<p.length-1 && p[i]>=p[i+1])
                i++;
            buy=p[i];
            
            while(i<p.length-1 && p[i]<=p[i+1])
                i++;
            sell=p[i];
            
            profit+=sell-buy;
        }
        
        return profit;
    }
}

*/