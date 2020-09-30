/*441. Arranging Coins - Leetcode Binary Search Java Solution*/

class ArrangeCoins
{
    public int arrangeCoins(int n) 
    {
        if(n<=0)
            return 0;
        
        long st=1;
        long end=n;
        long currSum=1;
        while(st<=end)
        {
            long mid=st+(end-st)/2;
            currSum=mid*(mid+1)/2;
            
            if(currSum==n)
                return (int)mid;
            if(n<currSum)
                end=mid-1;
            else
                st=mid+1;
                
        }
        
        return (int)end;
        
    }
}








// class Solution
// {
//     public int arrangeCoins(int n) 
//     {
//         if(n<=0)
//             return 0;
        
//         int cnt=1;
//         while(n>0)
//         {
//             n=n-cnt;
//             if(n<0)
//                 break;
//             cnt++;
            
//         }
        
//         return cnt-1;
        
//     }
// }
