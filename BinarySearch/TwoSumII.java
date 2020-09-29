/*167. Two Sum II - Input array is sorted - Leetcode Binary Search Java Solution*/

class TwoSumII
{
    public int binarySearch(int a[],int n,int x)
    {
        int st=0;
        int end=n-1;
        int res=-1;
        while(st<=end)
        {
            int mid=st+(end-st)/2;
            if(a[mid]==x)
            {
                res=mid;
                st=mid+1;
            }
            else if(x<a[mid])
                end=mid-1;
            else
                st=mid+1;
        }
        
        return res;
    }
    
    public int[] twoSum(int[] n, int t)
    {
        
        int res[]=new int[2];
        
        for(int i=0;i<n.length;i++)
        {
            int diff=t-n[i];
            System.out.println(diff);
            res[0]=i+1;
            int index=binarySearch(n,n.length,diff);
            System.out.println(index);
            if(index!=-1)
            {
                res[1]=index+1;
                break;
            }
                
        }
        
        return res;
        
    }
}
