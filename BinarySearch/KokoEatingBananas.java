/*875. Koko Eating Bananas - Leetcode Binary Search Java Solution*/

class KokoEatingBananas 
{
    private boolean canEatInTime(int piles[],int H,int count)
    {
        int hours=0;
        for(int pile:piles)
        {
            int div=pile/count;
            hours+=div;
            if(pile%count!=0)
                ++hours;
        }
        
        if(hours<=H)
            return true;
        return false;
    }
    public int minEatingSpeed(int[] piles, int H)
    {
        int i,max=piles[0];
        for(i=1;i<piles.length;i++)
        {
            if(max<piles[i])
                max=piles[i];    
        }
        System.out.println(max);
        
        int st=1;
        int end=max;
        int ans=0;
        while(st<=end)
        {
            int mid=st+(end-st)/2;
            if(canEatInTime(piles,H,mid))
            {
                ans=mid;
                end=mid-1;
            }
            else
                st=mid+1;
        }
        
        return ans;
        
        
    }
}
