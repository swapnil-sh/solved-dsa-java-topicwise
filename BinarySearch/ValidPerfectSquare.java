/*367. Valid Perfect Square - Leetcode Binary Search Java Solution*/

class ValidPerfectSquare
{
    public boolean isPerfectSquare(int n) 
    {
        long st=1;
        long end=n;
        while(st<=end)
        {
            long mid=st+(end-st)/2;
            if((mid*mid)==n)
                return true;
            else if(mid*mid>n)
                end=mid-1;
            else
                st=mid+1;
        }
        
        return false;
        
    }
}
