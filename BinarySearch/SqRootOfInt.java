/*Square Root of Integer - InterviewBit Java Solution*/

/*
--------------------------Binary Search-----------------------
TC - O(logn)
SC - O(1)
*/

public class SqRootOfInt
{
    public int sqrt(int n) 
    {
        int st=1;
        int end=n;
        int res=0;
        while(st<=end)
        {
            int mid=st+(end-st)/2;
            if(mid<=n/mid)
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
