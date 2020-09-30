/*278. First Bad Version - Leetcode Binary Search Java Solution*/


/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class FirstBadVer extends VersionControl {
    public int firstBadVersion(int n) 
    {
        int st=1;
        int end=n;
        int res=-1;
        
        while(st<=end)
        {
            int mid=st+(end-st)/2;
            
            if(isBadVersion(mid)==true)
            {
                res=mid;
                end=mid-1;
            }
            else
                st=mid+1;
        }
        
        return res;
    }
}
