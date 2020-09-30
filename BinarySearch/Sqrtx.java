/*69. Sqrt(x)* - Leetcode Binary Search Java Solution*/

class Sqrtx 
{
    public int mySqrt(int x)
    {
        if (x == 0) 
            return 0;
        
        int st=1;
        int end=x;
        int res=0;
        
        while (st<=end)
        {
            int mid=st+(end-st)/2;
            if (mid<=1.0*x/mid) 
            {
                res=mid;
                st=mid+1;
            }
            else 
                end=mid-1;
        }
        return res;
    }
}
