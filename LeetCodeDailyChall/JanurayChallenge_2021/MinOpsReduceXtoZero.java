/*1658. Minimum Operations to Reduce X to Zero - Leetcode Java Solutions*/

/*
------------------------Using Sliding Window------------------------------
TC-O(n)
SC-O(n)
*/


class MinOpsReduceXtoZero
{
    public int minOperations(int[] a, int x) 
    {
        int i, j, target=-x, n=a.length,sum=0,res=-1;
        for(i=0;i<n;i++)
            target+=a[i];
        
        if(target==0)
            return n;
        
        if(target<0)
            return -1;
        
        i=0;
        j=0;
        
        while(i<n && j<n)
        {
            sum+=a[j];            
            while(i<j && sum>target)
                    sum-=a[i++];
            if(sum==target)
                res=Math.max(res, j-i+1);            
            j++;
        }
        
        return res==-1?-1:n-res;
        
    }
}
/*
------------------------Using HashMap------------------------------
TC-O(n)
SC-O(n)
*/
/*
class MinOpsReduceXtoZero
{
    public int minOperations(int[] a, int x)
    {
        int i,target=-x,n=a.length;
        
        for(i=0;i<n;i++)
            target+=a[i];
        
        if(target==0)
            return a.length;
        
        HashMap<Integer, Integer> hm=new HashMap<>();
        hm.put(0,-1);
        
        int res=-1,sum=0;
        for(i=0;i<a.length;i++)
        {
            sum+=a[i];
            if(hm.containsKey(sum-target))
                res=Math.max(res, i-hm.get(sum-target));
            
            hm.put(sum, i);
        }
        
        return res==-1?-1:a.length-res;
    }
}
*/