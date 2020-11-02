/*287. Find the Duplicate Number - Leetcode Java Solution using Floyds Cycle Detetction Algo*/


/*
	TC - O(n)
	SC - O(1)

Other Approaches - 
	1. Sort and find next TC-O(nlogn) and SC-O(1) but array will be modified
	2. Use Hashing TC-O(n) and SC-O(n)
*/
class FindDupNo
{
    public int findDuplicate(int[] a) 
    {
        int slow=a[0];
        int fast=a[0];
        int res=0;
        
        do
        {
            slow=a[slow];
            fast=a[a[fast]];
            
            if(slow==fast)
                break;
        }while(slow!=fast);
        
        slow=a[0];
        while(slow!=fast)
        {
            slow=a[slow];
            fast=a[fast];
        }
        res=slow;
        
        return res;
    }
}